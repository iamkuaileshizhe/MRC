package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.OrderDetailActivity;
import com.neocom.mobilerefueling.adapter.OrderAdapter;
import com.neocom.mobilerefueling.bean.AllOrderBean;
import com.neocom.mobilerefueling.bean.AllOrderListBean;
import com.neocom.mobilerefueling.bean.CurrentOrderListBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/9.
 */

public class AllCurrentOrderFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private View view;
    //    private List<OrderBean> orderBeenList;
    private final int OK = 101;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case OK:

                    orderList = (List<AllOrderListBean>) msg.obj;

                    orderAdapter = new OrderAdapter(orderList);
                    allOrderLv.setAdapter(orderAdapter);

                    break;

            }

//            super.handleMessage(msg);
        }
    };
    private ListView allOrderLv;
    private List<AllOrderListBean> orderList;
    private OrderAdapter orderAdapter;

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
        allOrderLv.setOnItemClickListener(this);

    }

    @Override
    public void initData() {

        getAllOrderListFromServer();

    }

    /**
     * 从 服务器 获取数据刘表
     */
    private void getAllOrderListFromServer() {


        CurrentOrderListBean orderListBean = new CurrentOrderListBean();
        orderListBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        orderListBean.setBeginNum("1");
        orderListBean.setEndNum("10");

        Gson gson = new Gson();
        String pageJson = gson.toJson(orderListBean);


        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), pageJson);

        Call<AllOrderBean> call = HttpManger.getHttpMangerInstance().getServices().getListByUserID(requestBody);
        call.enqueue(new Callback<AllOrderBean>() {
            @Override
            public void onResponse(Call<AllOrderBean> call, Response<AllOrderBean> response) {

                AllOrderBean body = response.body();
                if (body != null) {
                    processBody(body);

                }

            }

            @Override
            public void onFailure(Call<AllOrderBean> call, Throwable t) {
                Log.i(TAG, "onFailure: 网络返回失败..." + t.getMessage());
            }
        });


    }

    private void processBody(AllOrderBean body) {

        List<AllOrderListBean> bodyBring = body.getBring();
        if (bodyBring != null) {
            Message message = Message.obtain();
            message.what = OK;
            message.obj = bodyBring;
            mHandler.sendMessage(message);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        AllOrderListBean bean = (AllOrderListBean) orderAdapter.getItem(i);

//        Log.i(TAG, "onItemClick: " + bean.getId());

        Intent intent = new Intent(UIUtils.getContext(), OrderDetailActivity.class); // 跳转 Activity
        intent.putExtra("userId", bean.getId());

        startActivity(intent);


    }
}
