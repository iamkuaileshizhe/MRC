//package com.neocom.mobilerefueling.fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.LinearLayout;
//
//import com.google.gson.Gson;
//import com.neocom.mobilerefueling.R;
//import com.neocom.mobilerefueling.activity.AddgetOilActivity;
//import com.neocom.mobilerefueling.activity.GetOilDetailActivity;
//import com.neocom.mobilerefueling.adapter.GetOilFgAdapter;
//import com.neocom.mobilerefueling.bean.RequestGetOilPageBean;
//import com.neocom.mobilerefueling.bean.ResponseGetOilPageBean;
//import com.neocom.mobilerefueling.globle.Constant;
//import com.neocom.mobilerefueling.net.HttpManger;
//import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
//import com.neocom.mobilerefueling.utils.UIUtils;
//import com.neocom.mobilerefueling.view.LoadingLayout;
//import com.neocom.mobilerefueling.view.XListView;
//
//import java.util.List;
//
//import butterknife.BindView;
//import okhttp3.RequestBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by admin on 2017/9/5.
// */
//
//public class GetOilListFragmen extends BaseFragment implements XListView.IXListViewListener, View.OnClickListener {
//    //    @BindView(R.id.get_oil_lv)
//    XListView getOilLv;
//    //    Unbinder unbinder;
//    @BindView(R.id.loading_layout)
//    LoadingLayout mLoadingLayout;
//    @BindView(R.id.get_oil_ll)
//    LinearLayout getOilLl;
//
//
//    protected Handler mHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
////            super.handleMessage(msg);
//
//            switch (msg.what) {
//
//                case 101:
//
//                    List<ResponseGetOilPageBean.BringBean> bringNew = (List<ResponseGetOilPageBean.BringBean>) msg.obj;
//
//                    if (bringNew != null) {
//
//                        int size = bringNew.size();
//                        if (size == 0) {
//                            mLoadingLayout.showEmpty();
//                            return;
//                        }
//                        oilFgAdapter = new GetOilFgAdapter(bringNew);
//                        getOilLv.setAdapter(oilFgAdapter);
//                        mLoadingLayout.showMain();
//
//                        if (size == 10) {
//                            getOilLv.stopLoadMore("已加载全部");
//
//                        }
//
//                    } else {
//                        mLoadingLayout.showEmpty();
//                    }
//                    break;
//            }
//
//        }
//    };
//    private GetOilFgAdapter oilFgAdapter;
//    private View view;
//
//
//    @Override
//    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        view = UIUtils.inflate(R.layout.get_oil_fg_list_layout);
//
//        return view;
//    }
//
//    @Override
//    public void initView() {
//        getOilLv = view.findViewById(R.id.get_oil_lv);
//        getOilLv.setPullLoadEnable(true);
//        getOilLv.setXListViewListener(this);
//        getOilLl.setOnClickListener(this);
//
//        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                mLoadingLayout.showLoading();
//                getDataFromServer();
//            }
//        });
//        getOilLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                ResponseGetOilPageBean.BringBean oilFgAdapterItem = oilFgAdapter.getItem(i - 1);
//                String id = oilFgAdapterItem.getId();
////                Log.i(TAG, "onItemClick: 本组 id 是：==》:" + id);
////                GetOilDetailActivity.class
//
//                Intent intent = new Intent(UIUtils.getContext(), GetOilDetailActivity.class);
//                intent.putExtra("itemId", id);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        getDataFromServer();
//
//    }
//
//    public void getDataFromServer() {
//
//        RequestGetOilPageBean getOilPageBean = new RequestGetOilPageBean();
//
//        getOilPageBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
//        getOilPageBean.setBeginNum("1");
//        getOilPageBean.setEndNum("10");
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(getOilPageBean);
//        Call<ResponseGetOilPageBean> call = HttpManger.getHttpMangerInstance().getServices().purchaseList(requestBody);
//
//        call.enqueue(new Callback<ResponseGetOilPageBean>() {
//            @Override
//            public void onResponse(Call<ResponseGetOilPageBean> call, Response<ResponseGetOilPageBean> response) {
//                Log.i(TAG, "onResponse: ==>" + new Gson().toJson(response.body()));
//
//                if (getOilLv != null) {
//                    getOilLv.stopRefresh(true);
//                }
//
//                ResponseGetOilPageBean bodyRes = response.body();
//                if (bodyRes != null) {
//
//                    if (bodyRes.isRes()) {
//
//                        parseRes(bodyRes);
//
//                    } else {
//                        mLoadingLayout.showEmpty();
//                        Log.i(TAG, "onResponse: 为获取到 提油记录列表");
//
//                    }
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseGetOilPageBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: ==>" + t.getMessage());
//                getOilLv.stopRefresh(false);
//                mLoadingLayout.showError();
//            }
//        });
//    }
//
//    private void parseRes(ResponseGetOilPageBean bodyRes) {
//        List<ResponseGetOilPageBean.BringBean> bring = bodyRes.getBring();
//
//        if (bring != null) {
//            Message message = Message.obtain();
//            message.what = 101;
//            message.obj = bring;
//
//            mHandler.sendMessage(message);
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        getDataFromServer();
//        mLoadingLayout.showLoading();
//    }
//
//    @Override
//    public void onRefresh() {
//        getDataFromServer();
//    }
//
//    @Override
//    public void onLoadMore() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                getOilLv.stopLoadMore();
//                getOilLv.stopLoadMore("已全部加载");
//            }
//        }, 2000);
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        startActivity(new Intent(UIUtils.getContext(), AddgetOilActivity.class));
//
//    }
//}
