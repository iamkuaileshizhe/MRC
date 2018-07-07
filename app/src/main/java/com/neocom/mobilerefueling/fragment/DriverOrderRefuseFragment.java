package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.PaiSongDanJDDialogUI;
import com.neocom.mobilerefueling.adapter.ReceiveListAdapter;
import com.neocom.mobilerefueling.bean.DriverOrderRequestBean;
import com.neocom.mobilerefueling.bean.ReceiverOrderBeanBring;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingLayout;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/8.
 */

public class DriverOrderRefuseFragment extends BaseFragment implements XListView.IXListViewListener {


    //    @BindView(R.id.receive_listview)
//    XListView receiveListview;
    private View view;

    private ReceiveListAdapter receiveListAdapter;
    List<ReceiverOrderBeanBring.BringBean> bringShow;

    private LoadingLayout mLoadingLayout;

    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:


                    bringShow = (List<ReceiverOrderBeanBring.BringBean>) msg.obj;

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

                            receiveListAdapter = new ReceiveListAdapter(bringShow);
                            receiveListview.setAdapter(receiveListAdapter);

                            mLoadingLayout.showMain();

                            if (size < 10) {
                                receiveListview.stopLoadMore("已全部加载");
                            }

                            CURRENT_PAGE_NUMBER++;
                            Log.i(TAG, "handleMessage: 准备去加载，第" + CURRENT_PAGE_NUMBER + "页");

                        } else {
                            mLoadingLayout.showEmpty();
                        }


                    }


//                    bringShow = (List<ReceiverOrderBeanBring.BringBean>) msg.obj;
//
//
//                    if (bringShow != null) {
//
//                        int size = bringShow.size();
//                        if (size == 0) {
//                            mLoadingLayout.showEmpty();
//                        }
//                        receiveListAdapter = new ReceiveListAdapter(bringShow);
//                        receiveListview.setAdapter(receiveListAdapter);
//                        mLoadingLayout.showMain();
//                        if (bringShow.size() < 10) {
//                            receiveListview.stopLoadMore("已全部加载");
//                        }
//
//                    } else {
//                        mLoadingLayout.showEmpty();
//                    }

                    break;


            }

        }
    };
    private XListView receiveListview;


    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.receive_list_layout);
//        view = View.inflate(UIUtils.getContext(), R.layout.receive_list_layout, null);
        return view;
    }

    @Override
    public void initView() {
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        receiveListview = view.findViewById(R.id.receive_listview);
        mLoadingLayout.showLoading();
        receiveListview.setPullLoadEnable(true);
        receiveListview.setXListViewListener(this);
        receiveListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ReceiverOrderBeanBring.BringBean item = receiveListAdapter.getItem(i - 1);
                String itemId = item.getId();
                String paiDanState = item.getDstate();
                String indentId = item.getIndentId();
                Log.i(TAG, "onItemClick: " + itemId + ";;state:" + paiDanState);


//                Intent intent = new Intent(UIUtils.getContext(), PaiSongDanJieDanActivity.class);
                Intent intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
                intent.putExtra("dstate", paiDanState);
                intent.putExtra("indentId", indentId);
                intent.putExtra("itemId", itemId);
                startActivity(intent);
            }
        });

        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mLoadingLayout.showLoading();
//                getDataFomServer();

                mLoadingLayout.showLoading();
                isPullState = false;
                CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
                getDataFomServer(CURRENT_PAGE_NUMBER);

            }
        });
    }

    @Override
    public void initData() {
    }

    @Override
    public void onRefresh() {

//        getDataFomServer();

        Log.i(TAG, "onRefresh: ===>下拉刷新");
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
//        getDataFomServer();

//        mLoadingLayout.showLoading();
//        getDataFomServer(Constant.FIRST_PAGE);
//        mLoadingLayout.showLoading();

    }


    public void getDataFomServer(int currentPageInt) {
        String currentPage = String.valueOf(currentPageInt);

        DriverOrderRequestBean carNumBean = new DriverOrderRequestBean();

//        carNumBean.setCarNum("加油车测试");
//        carNumBean.setCarNum("移动加油车1");
//        carNumBean.setCarNum(GetUserInfoUtils.getUserInfo().getCarNum());
        carNumBean.setCarNum(SPUtils.getSaveCar());
        carNumBean.setDstate(Constant.JD_YIJUJUE);
        carNumBean.setCurrentPage(currentPage);
        carNumBean.setPageSize(Constant.PER_PAGE_NUMS);
        Gson gson = new Gson();
        String carNumJson = gson.toJson(carNumBean);


        RequestBody requestBody = RequestBody.create(MediaType.parse(Constant.CONTENT_TYPE), carNumJson);

        Call<ReceiverOrderBeanBring> call = HttpManger.getHttpMangerInstance().getServices().deliveryOrderList(requestBody);
        call.enqueue(new Callback<ReceiverOrderBeanBring>() {
            @Override
            public void onResponse(Call<ReceiverOrderBeanBring> call, Response<ReceiverOrderBeanBring> response) {

//                Log.i(TAG, "onResponse: ==>>>" + response.body().toString());
//                Log.i(TAG, "onResponse: ==>>bring>" + response.body().getBring().toString());
                if (receiveListview != null) {
                    receiveListview.stopRefresh(true);
                }
                ReceiverOrderBeanBring body = response.body();
                if (body != null) {

                    List<ReceiverOrderBeanBring.BringBean> bring = body.getBring();

                    if (bring != null) {
                        processJson(bring);
                    }

                } else {
                    if (receiveListview != null) {
                        receiveListview.stopRefresh(false);
                    }
                    mLoadingLayout.showError();
                }
            }

            @Override
            public void onFailure(Call<ReceiverOrderBeanBring> call, Throwable t) {
                receiveListview.stopRefresh(false);
                mLoadingLayout.showError();
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
            }
        });

    }


    private void processJson(List<ReceiverOrderBeanBring.BringBean> bring) {

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
//        mLoadingLayout.showMain();
    }
}
