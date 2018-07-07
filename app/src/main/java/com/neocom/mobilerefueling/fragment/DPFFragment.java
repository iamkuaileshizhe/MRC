package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.adapter.ZSKHListAdapter;
import com.neocom.mobilerefueling.bean.DPFReqBean;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.bean.ZSKHReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingLayout;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/8.
 * 正式客户
 */

public class DPFFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;

    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载

    protected int clickPosition = -1;

    protected ZSKHListAdapter receiveListAdapter;
    List<KHDetailBringBean> bringShow;
    private LoadingLayout mLoadingLayout;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case 102:

                    bringShow = (List<KHDetailBringBean>) msg.obj;

                    if (isPullState) {
                        // 上拉加载

                        if (bringShow == null) {
                            receiveListview.stopLoadMore("已无更多数据");
                            Log.i(TAG, "handleMessage: 已无更多数据,页数=》" + CURRENT_PAGE_NUMBER);
                        } else {
                            receiveListAdapter.addMoreListData(bringShow);
                            int size = bringShow.size();

                            if (size < 10) {
                                receiveListview.stopLoadMore("已全部加载");
                            }
                            if (size != 0) {

                                CURRENT_PAGE_NUMBER++;
                            }
                            Log.i(TAG, "handleMessage: 在 上拉去加载，第" + CURRENT_PAGE_NUMBER + "页" + "，加载" + size + "个");
                            receiveListview.stopLoadMore();
                            receiveListview.stopLoadMore("已加载");

                        }


                    } else {
                        // 下拉刷新

                        if (bringShow != null) {
                            int size = bringShow.size();
                            if (size == 0) {
                                mLoadingLayout.showEmpty();
                                return;
                            }

                            receiveListAdapter = new ZSKHListAdapter(bringShow);
                            receiveListview.setAdapter(receiveListAdapter);

                            mLoadingLayout.showMain();

                            if (size < 10) {
                                receiveListview.stopLoadMore("已全部加载");
                            }

//                            CURRENT_PAGE_NUMBER++;

                            if (size != 0) {

                                CURRENT_PAGE_NUMBER++;
                            }
                            Log.i(TAG, "handleMessage: 准备去加载，第" + CURRENT_PAGE_NUMBER + "页");

                        } else {
                            mLoadingLayout.showEmpty();
                        }


                    }

                    break;


            }

        }
    };
    private XListView receiveListview;


    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.receive_list_layout);
        return view;
    }

    @Override
    public void initView() {
        receiveListview = view.findViewById(R.id.receive_listview);
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        mLoadingLayout.showLoading();
        receiveListview.setPullLoadEnable(true);
        receiveListview.setXListViewListener(this);
        receiveListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                clickPosition = i;

                Intent intent = jumpToActivity();

                if (intent == null) {
                    return;
                }

                startActivity(intent);


            }
        });
        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mLoadingLayout.showLoading();
                isPullState = false;
                CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
                getDataFomServer(CURRENT_PAGE_NUMBER);

            }
        });

    }

    protected Intent jumpToActivity() {



        KHDetailBringBean item = receiveListAdapter.getItem(clickPosition - 1);
        String idShenHeItem = item.getId(); // 提交时 用 此 ID
        String idItem = item.getCustomerId(); // 查询 详情 用 此 ID

        String checkStatus = item.getCheckStatus();

        Intent intent = new Intent(getActivity(), AddQianZaiKeHuActivity.class);
        if (TextUtils.isEmpty(idItem)) {
            intent.putExtra("idItem", idShenHeItem);
        } else {
            intent.putExtra("idItem", idItem);
        }
        intent.putExtra("shenHeId", idShenHeItem);
        intent.putExtra("checkStatus", checkStatus);
        intent.putExtra(Constant.COMING,Constant.DPF_COMING );

        return intent;


    }

    @Override
    public void initData() {
//        getDataFomServer();
    }

    @Override
    public void onRefresh() {
//        getDataFomServer();

        isPullState = false;
        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
        getDataFomServer(CURRENT_PAGE_NUMBER);


    }

    @Override
    public void onLoadMore() {
        Log.i(TAG, "onLoadMore: 上拉加载");

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                receiveListview.stopLoadMore();
//                receiveListview.stopLoadMore("已全部加载");
//            }
//        }, 2000);

        isPullState = true;
        getDataFomServer(CURRENT_PAGE_NUMBER);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: 生命周期");
//        mLoadingLayout.showLoading();
//        isPullState = false;
//        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
//        getDataFomServer(CURRENT_PAGE_NUMBER);
    }


    public void getDataFomServer(int currentPageInt) {

        String currentPage = String.valueOf(currentPageInt);

        DPFReqBean dpfReqBean = new DPFReqBean();


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo == null) {
            return;
        }

        dpfReqBean.setUserId(userInfo.getUserId());
        dpfReqBean.setRoleCode(GetOrderStateUtil.getRoleCode(userInfo.getRoleCode()));
        dpfReqBean.setBeginNum(currentPage);
        dpfReqBean.setEndNum(Constant.PER_PAGE_NUMS);


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(dpfReqBean);

        Call<QZKHRespBean> call = HttpManger.getHttpMangerInstance().getServices().noConfirmCustomerList(requestBody);
        call.enqueue(new Callback<QZKHRespBean>() {
            @Override
            public void onResponse(Call<QZKHRespBean> call, Response<QZKHRespBean> response) {


                if (receiveListview != null) {
                    receiveListview.stopRefresh(true);
                }

                QZKHRespBean body = response.body();
                if (body != null) {
                    boolean res = body.isRes();
                    if (res){

                        List<KHDetailBringBean> bring = body.getBring();
                        if (bring != null) {
                            processJson(bring);
                        }
                    }else {

                        mLoadingLayout.showEmpty();
                    }


                }

            }

            @Override
            public void onFailure(Call<QZKHRespBean> call, Throwable t) {
                receiveListview.stopRefresh(false);
                mLoadingLayout.showError();
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
            }
        });

    }


//    protected String getCheckStatus() {
//
//        return "";
//    }


    private void processJson(List<KHDetailBringBean> bring) {

        Log.i(TAG, "processJson: 处理 返回 的值 ");

        Message msg = Message.obtain();
        msg.what = 102;
        msg.obj = bring;
        mHandler.sendMessage(msg);

    }

    @Override
    public void onStart() {
        super.onStart();

        mLoadingLayout.showLoading();
        isPullState = false;
        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
        getDataFomServer(CURRENT_PAGE_NUMBER);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 生命周期");

//        getDataFomServer();
//        mLoadingLayout.showLoading();
    }


}
