package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.adapter.QZKHListAdapter;
import com.neocom.mobilerefueling.adapter.ZSKHListAdapter;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.QZKHReqBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.bean.ZSKHReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.ClearEditText;
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

public class ZSKHFragment extends BaseFragment implements XListView.IXListViewListener {

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
    private String roleCode;
    private ClearEditText searchEditextview;
    private String searchKeyWord = "";

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.zskh_list_layout);
        return view;
    }

    @Override
    public void initView() {
        receiveListview = view.findViewById(R.id.receive_listview);
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        searchEditextview = view.findViewById(R.id.filter_edit);
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


        //根据输入框输入值的改变来过滤搜索
        searchEditextview.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
//                filterData(s.toString());
                searchKeyWord = s.toString();
//                Toast.makeText(getActivity(), "11改变111" + searchKeyWord, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchKeyWord = s.toString();
//                Toast.makeText(getContext(), "创建完成...."+searchKeyWord.toString(), Toast.LENGTH_SHORT).show();


                CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
                getDataFomServer(CURRENT_PAGE_NUMBER);

            }
        });

        searchEditextview.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || event.getKeyCode() == KeyEvent.ACTION_DOWN) {

                    searchKeyWord = searchEditextview.getText().toString();
//                    Toast.makeText(getContext(), "开始 搜索", Toast.LENGTH_SHORT).show();
                    CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
                    getDataFomServer(CURRENT_PAGE_NUMBER);

                    return true;

                }


                return false;
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


//        KHDetailBringBean zskhItem = receiveListAdapter.getItem(clickPosition - 1);
//
//        Gson gson = new Gson();
//        String itemContent = gson.toJson(zskhItem);
//        Intent intent = new Intent(UIUtils.getContext(), AddQianZaiKeHuActivity.class);
//        intent.putExtra("itemContent", itemContent);
//        intent.putExtra(Constant.KHTYPE, Constant.ZSKH);
//        return intent;

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
        intent.putExtra(Constant.COMING, Constant.ZS_COMING);
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

        roleCode = GetOrderStateUtil.getRoleCode(GetUserInfoUtils.getUserInfo().getRoleCode());

    }


    public void getDataFomServer(int currentPageInt) {

        String currentPage = String.valueOf(currentPageInt);


        ZSKHReqBean zskhReqBean = new ZSKHReqBean();


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo == null) {
            return;
        }

        String roleCode = GetOrderStateUtil.getRoleCode(userInfo.getRoleCode());

        if (roleCode == "1") {
            zskhReqBean.setUserId(userInfo.getUserId());
        }

        zskhReqBean.setNameSim(searchKeyWord);
        zskhReqBean.setBeginNum(currentPage);
        zskhReqBean.setEndNum(Constant.PER_PAGE_NUMS);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(zskhReqBean);

        Call<QZKHRespBean> call = HttpManger.getHttpMangerInstance().getServices().findFormalCustomerList(requestBody);
        call.enqueue(new Callback<QZKHRespBean>() {
            @Override
            public void onResponse(Call<QZKHRespBean> call, Response<QZKHRespBean> response) {


                if (receiveListview != null) {
                    receiveListview.stopRefresh(true);
                }

                QZKHRespBean body = response.body();
                if (body != null) {
                    List<KHDetailBringBean> bring = body.getBring();
                    if (bring != null) {
                        processJson(bring);
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
