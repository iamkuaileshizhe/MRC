package com.neocom.mobilerefueling.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.OrderAdapter;
import com.neocom.mobilerefueling.bean.AllOrderBean;
import com.neocom.mobilerefueling.bean.AllOrderListBean;
import com.neocom.mobilerefueling.bean.RequestPageBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.XListView;


import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/9.
 */

public class AllOrderFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private List<OrderBean> orderBeenList;
    private final int OK = 100;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case OK:

                    List<AllOrderListBean> orderList = (List<AllOrderListBean>) msg.obj;

                    OrderAdapter orderAdapter = new OrderAdapter(orderList);
                    allOrderLv.setAdapter(orderAdapter);

                    break;

            }

//            super.handleMessage(msg);
        }
    };
    private XListView allOrderLv;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.order_layout);
        return view;
    }

    @Override
    public void initView() {
        TextView textView = view.findViewById(R.id.order_tv);
        textView.setText("AllOrderFragment");

        allOrderLv = view.findViewById(R.id.all_order_lv);
        allOrderLv.setPullLoadEnable(true);
        allOrderLv.setXListViewListener(this);

    }

    @Override
    public void initData() {


        getAllOrderListFromServer();

    }

    /**
     * 从 服务器 获取数据刘表
     */
    private void getAllOrderListFromServer() {

        RequestPageBean pageBean = new RequestPageBean();
        pageBean.setBeginNum("1");
        pageBean.setEndNum("10");

        Gson gson = new Gson();
        String pageJson = gson.toJson(pageBean);


        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), pageJson);

        Call<AllOrderBean> call = HttpManger.getHttpMangerInstance().getServices().getAllOrder(requestBody);
        call.enqueue(new Callback<AllOrderBean>() {
            @Override
            public void onResponse(Call<AllOrderBean> call, Response<AllOrderBean> response) {
                if (response != null) {
//                    Log.i(TAG, "onResponse: " + new Gson().toJson(response.body()));

                    if (allOrderLv != null) {
                        allOrderLv.stopRefresh(true);
                    }
                    AllOrderBean body = response.body();
                    if (body != null) {

                        processBody(body);
                    }
                }

            }

            @Override
            public void onFailure(Call<AllOrderBean> call, Throwable t) {
                Log.i(TAG, "onFailure: 网络返回失败..." + t.getMessage());
                allOrderLv.stopRefresh(true);
            }
        });


    }

    private void processBody(AllOrderBean body) {

        if (body != null) {

                List<AllOrderListBean> bodyBring = body.getBring();
                if (bodyBring != null) {
                    Message message = Message.obtain();
                    message.what = OK;
                    message.obj = bodyBring;
                    mHandler.sendMessage(message);
                }
        }
    }

    @Override
    public void onRefresh() {
        getAllOrderListFromServer();
    }

    @Override
    public void onLoadMore() {
        Log.i(TAG, "onLoadMore: 下拉加载更多");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                allOrderLv.stopLoadMore();
                allOrderLv.stopLoadMore("已全部加在");
            }
        }, 2000);

    }
}
