package com.neocom.mobilerefueling.fragment;

import android.content.Context;
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
import com.neocom.mobilerefueling.activity.ShitWorkDetailActiivty;
import com.neocom.mobilerefueling.adapter.ShitAdapter;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.bean.TurnedUserBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
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
 * Created by admin on 2017/10/26.
 * 待接班
 */

public class UnChangeWorkFrament extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

    private ShitAdapter receiveListAdapter;

//    List<ReceiverOrderBeanBring.BringBean> bringShow;

    List<ShiftResponseBean.BringBean> bringShow;
//    private ReceiveListUpdateObserver updateObserver;

    private String WAIT_TO_SHIFT = "0"; //待接班


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:

                    bringShow = (List<ShiftResponseBean.BringBean>) msg.obj;


                    if (bringShow != null) {
                        int size = bringShow.size();
                        if (size == 0) {
                            mLoadingLayout.showEmpty();
                            return;
                        }

                        receiveListAdapter = new ShitAdapter(bringShow);
                        listView.setAdapter(receiveListAdapter);

                        mLoadingLayout.showMain();


                        if (size < 10) {
                            listView.stopLoadMore("已全部加载");
                        }

                    } else {
                        mLoadingLayout.showEmpty();
                    }


                    break;


            }

        }
    };
    private LoadingLayout mLoadingLayout;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.receive_list_layout);
//        view = View.inflate(UIUtils.getContext(), R.layout.receive_list_layout, null);
        return view;
    }

    @Override
    public void initView() {
//        xListView = view.findViewById(R.id.receive_listview);
//        xListView.setPullLoadEnable(true);
//        xListView.setXListViewListener(this);

        listView = view.findViewById(R.id.receive_listview);
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        mLoadingLayout.showLoading();
        listView.setPullLoadEnable(true);
        listView.setXListViewListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(UIUtils.getContext(), "->" + i + "-->" + (i - 1), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UIUtils.getContext(), ShitWorkDetailActiivty.class);

                intent.putExtra("shiftId", receiveListAdapter.getItem(i - 1).getId());
                intent.putExtra("show","1");

                startActivity(intent);


//
//                ReceiverOrderBeanBring.BringBean item = receiveListAdapter.getItem(i - 1);
//                String itemId = item.getId();
//                String paiDanState = item.getDstate();
//                Log.i(TAG, "onItemClick: " + itemId + ";;state:" + paiDanState);
//
//                Intent intent = null;
//                if (("0").equals(paiDanState)) {
//                    intent = new Intent(UIUtils.getContext(), ReceiveListDetailActivity.class);
//                    intent.putExtra("dstate", paiDanState);
//                } else if (("1").equals(paiDanState)) {
//                    intent = new Intent(UIUtils.getContext(), OrderFinishActivity.class);
//                    intent.putExtra("dstate", paiDanState);
//                } else if (("2").equals(paiDanState)) {
//
//                    intent = new Intent(UIUtils.getContext(), ReceiveListDetailActivity.class);
//                    intent.putExtra("dstate", paiDanState);
////                    Toast.makeText(UIUtils.getContext(), "已拒绝您暂时不能查看订单", Toast.LENGTH_SHORT).show();
////                    return;
//                } else if (("3").equals(paiDanState)) {
//                    intent = new Intent(UIUtils.getContext(), OrderFinishActivity.class);
//                    intent.putExtra("dstate", paiDanState);
////                    Toast.makeText(UIUtils.getContext(), "订单已完成", Toast.LENGTH_SHORT).show();
////                    return;
//                }
//                intent.putExtra("itemId", itemId);
//                startActivity(intent);
//
////                if (i==0){
////                    startActivity(new Intent(UIUtils.getContext(), ReceiveListDetailActivity.class));
////                }else if(i==1){
////                    startActivity(new Intent(UIUtils.getContext(), OrderFinishActivity.class));
////                }
            }
        });

//        updateObserver = new ReceiveListUpdateObserver(new Handler());
//
//        getActivity().getContentResolver().registerContentObserver(Constant.UPDATE_RECEIVE, false, updateObserver);

        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoadingLayout.showLoading();
                getDataFomServer();
            }
        });


    }

    @Override
    public void initData() {

    }

    @Override
    public void onRefresh() {
        Log.i(TAG, "onRefresh: ===>下拉刷新");
        getDataFomServer();
    }

    @Override
    public void onLoadMore() {
        Log.i(TAG, "onLoadMore: 上拉加载");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.stopLoadMore();
                listView.stopLoadMore("已全部加载");
            }
        }, 2000);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: 生命周期");
//        getDataFomServer();
    }


    public void getDataFomServer() {

//        CarryUserBean carryUserBean=new CarryUserBean();
//        carryUserBean.setBeginNum("1");
//        carryUserBean.setCarryUserId("3f67e2778c944999a00692f493862c50");
//        carryUserBean.setEndNum("10");
//        carryUserBean.setShiftStatus("");


        TurnedUserBean turnedUserBean = new TurnedUserBean();
        turnedUserBean.setBeginNum("1");
        turnedUserBean.setTurnUserId("3f67e2778c944999a00692f493862c50");
        turnedUserBean.setEndNum("10");
        turnedUserBean.setShiftStatus(WAIT_TO_SHIFT);

        Gson gson = new Gson();
        String carNumJson = gson.toJson(turnedUserBean);


        RequestBody requestBody = RequestBody.create(MediaType.parse(Constant.CONTENT_TYPE), carNumJson);
        HttpManger.getHttpMangerInstance().getServices().searchOilShiftList(requestBody).enqueue(new Callback<ShiftResponseBean>() {
            @Override
            public void onResponse(Call<ShiftResponseBean> call, Response<ShiftResponseBean> response) {
                Log.i(TAG, "onResponse: " + response.body().toString());

                if (listView != null) {
                    listView.stopRefresh(true);
                }

                ShiftResponseBean body = response.body();
                if (body != null) {
                    List<ShiftResponseBean.BringBean> bring = body.getBring();
                    if (bring != null) {
                        parseBring(bring);
                    }

                }


            }

            @Override
            public void onFailure(Call<ShiftResponseBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());

                                listView.stopRefresh(false);
                mLoadingLayout.showError();

            }
        });


    }

    private void parseBring(List<ShiftResponseBean.BringBean> bring) {

        Message msg = Message.obtain();
        msg.what = 102;
        msg.obj = bring;
        mHandler.sendMessage(msg);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: 生命周期");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: 生命周期");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: 生命周期");
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: 生命周期");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 生命周期");

        getDataFomServer();
        mLoadingLayout.showLoading();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: 生命周期");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: 生命周期");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: 生命周期");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 生命周期");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: 生命周期");
    }
}