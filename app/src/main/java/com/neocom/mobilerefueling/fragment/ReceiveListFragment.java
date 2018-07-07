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
 * Created by admin on 2017/8/25.
 */

public class ReceiveListFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

    private ReceiveListAdapter receiveListAdapter;

    List<ReceiverOrderBeanBring.BringBean> bringShow;

//    private ReceiveListUpdateObserver updateObserver;

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
                            listView.stopLoadMore("已无更多数据");
                            Log.i(TAG, "handleMessage: 已无更多数据,页数=》" + CURRENT_PAGE_NUMBER);
                        } else {

                            receiveListAdapter.addMoreListData(bringShow);
                            int size = bringShow.size();

                            if (size < 10) {
                                listView.stopLoadMore("已全部加载");
                            }

//                            CURRENT_PAGE_NUMBER++;

                            if (size != 0) {

                                CURRENT_PAGE_NUMBER++;
                            }

                            Log.i(TAG, "handleMessage: 在 上拉去加载，第" + CURRENT_PAGE_NUMBER + "页" + "，加载" + size + "个");
                            listView.stopLoadMore();
                            listView.stopLoadMore("已加载");

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
                            listView.setAdapter(receiveListAdapter);

                            mLoadingLayout.showMain();

                            if (size < 10) {
                                listView.stopLoadMore("已全部加载");
                            }

                            CURRENT_PAGE_NUMBER++;
                            Log.i(TAG, "handleMessage: 准备去加载，第" + CURRENT_PAGE_NUMBER + "页");

                        } else {
                            mLoadingLayout.showEmpty();
                        }


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

                ReceiverOrderBeanBring.BringBean item = receiveListAdapter.getItem(i - 1);
                String itemId = item.getId();
                String paiDanState = item.getDstate();
                Log.i(TAG, "onItemClick: " + itemId + ";;state:" + paiDanState);


                Intent intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
                intent.putExtra("dstate", paiDanState);

                intent.putExtra("itemId", itemId);
                startActivity(intent);


//                Intent intent = null;
//                if ((Constant.JD_DAIJIEDAN).equals(paiDanState)) {
////                    intent = new Intent(UIUtils.getContext(), PaiSongDanJieDanActivity.class);
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
//                } else if ((Constant.JD_YIJIEDAN).equals(paiDanState)) {
////                    intent = new Intent(UIUtils.getContext(), OrderFinishActivity.class);
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
//                } else if ((Constant.JD_YIJUJUE).equals(paiDanState)) {
//
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
////                    Toast.makeText(UIUtils.getContext(), "已拒绝您暂时不能查看订单", Toast.LENGTH_SHORT).show();
////                    return;
//                } else if ((Constant.JD_YIWANCHENG).equals(paiDanState)) {
////                    intent = new Intent(UIUtils.getContext(), OrderFinishActivity.class);
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
////                    Toast.makeText(UIUtils.getContext(), "订单已完成", Toast.LENGTH_SHORT).show();
////                    return;
//                } else if ((Constant.JD_DAIZHIFU).equals(paiDanState)) {
////                    intent = new Intent(UIUtils.getContext(), OrderFinishActivity.class);
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
////                    Toast.makeText(UIUtils.getContext(), "订单已完成", Toast.LENGTH_SHORT).show();
////                    return;
//                }else if (Constant.JD_YIQUXIAO.equals(paiDanState)){
//
//                    intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//                    intent.putExtra("dstate", paiDanState);
//
//                }
//                intent.putExtra("itemId", itemId);
//                startActivity(intent);

//                if (i==0){
//                    startActivity(new Intent(UIUtils.getContext(), ReceiveListDetailActivity.class));
//                }else if(i==1){
//                    startActivity(new Intent(UIUtils.getContext(), OrderFinishActivity.class));
//                }

            }
        });

//        updateObserver = new ReceiveListUpdateObserver(new Handler());
//
//        getActivity().getContentResolver().registerContentObserver(Constant.UPDATE_RECEIVE, false, updateObserver);

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

    @Override
    public void initData() {

    }

    @Override
    public void onRefresh() {
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
//                listView.stopLoadMore();
//                listView.stopLoadMore("已全部加载");
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


//        carNumBean.setCarNum(GetUserInfoUtils.getUserInfo().getCarNum());
        carNumBean.setCarNum(SPUtils.getSaveCar());
        carNumBean.setDstate(Constant.JD_DQUANBU);
        carNumBean.setCurrentPage(currentPage);
        carNumBean.setPageSize(Constant.PER_PAGE_NUMS);
        Gson gson = new Gson();
        String carNumJson = gson.toJson(carNumBean);

        RequestBody requestBody = RequestBody.create(MediaType.parse(Constant.CONTENT_TYPE), carNumJson);

        Call<ReceiverOrderBeanBring> call = HttpManger.getHttpMangerInstance().getServices().deliveryOrderList(requestBody);
        call.enqueue(new Callback<ReceiverOrderBeanBring>() {
            @Override
            public void onResponse(Call<ReceiverOrderBeanBring> call, Response<ReceiverOrderBeanBring> response) {

                if (listView != null) {
                    listView.stopRefresh(true);
                }
                ReceiverOrderBeanBring body = response.body();
                if (body != null) {
                    List<ReceiverOrderBeanBring.BringBean> bring = body.getBring();
                    if (bring != null) {
                        processJson(bring);

                    }
                }

            }

            @Override
            public void onFailure(Call<ReceiverOrderBeanBring> call, Throwable t) {
                listView.stopRefresh(false);
                if (isPullState) {
                    mLoadingLayout.showError();
                }
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


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        ReceiverOrderBeanBring.BringBean item = receiveListAdapter.getItem(position-1);
//        String itemId = item.getId();
//
//        Toast.makeText(UIUtils.getContext(), position+";;"+(position-1), Toast.LENGTH_SHORT).show();
////        startActivity(new Intent(UIUtils.getContext(), ReceiveListDetailActivity.class));
//
//
//    }


//    public class ReceiveListUpdateObserver extends ContentObserver {
//
//
//        public ReceiveListUpdateObserver(Handler handler) {
//            super(handler);
//        }
//
//        @Override
//        public void onChange(boolean selfChange) {
//            super.onChange(selfChange);
//
//            Log.i(TAG, "onChange: 改变了....");
//            getDataFomServer();
//
//        }
//
//        @Override
//        public void onChange(boolean selfChange, Uri uri) {
//            this.onChange(selfChange);
////            super.onChange(selfChange, uri);
//        }
//    }


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


        mLoadingLayout.showLoading();
        isPullState = false;
        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
        getDataFomServer(CURRENT_PAGE_NUMBER);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 生命周期");

//        getDataFomServer(Constant.FIRST_PAGE);
//        mLoadingLayout.showLoading();
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
