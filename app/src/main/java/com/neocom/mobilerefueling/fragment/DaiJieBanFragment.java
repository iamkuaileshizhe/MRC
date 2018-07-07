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
import com.neocom.mobilerefueling.activity.YunYouDetailActivity;
import com.neocom.mobilerefueling.adapter.ShitAdapter;
import com.neocom.mobilerefueling.adapter.YunYouCheListAdapter;
import com.neocom.mobilerefueling.adapter.YunYouCheResponseBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.bean.TurnedUserBean;
import com.neocom.mobilerefueling.bean.YunYouCheRequestBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
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

public class DaiJieBanFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

//    private YunYouCheListAdapter receiveListAdapter;
//
//    List<YunYouCheResponseBean.BringBean> bringShow;

    private ShitAdapter receiveListAdapter;

//    List<ReceiverOrderBeanBring.BringBean> bringShow;

    List<ShiftResponseBean.BringBean> bringShow;


    private String WAIT_TO_SHIFT = "0"; //待接班

    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:

                    bringShow = (List<ShiftResponseBean.BringBean>) msg.obj;

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

                            receiveListAdapter = new ShitAdapter(bringShow);
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
        return view;
    }

    @Override
    public void initView() {

        listView = view.findViewById(R.id.receive_listview);
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        mLoadingLayout.showLoading();
        listView.setPullLoadEnable(true);
        listView.setXListViewListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(UIUtils.getContext(), ShitWorkDetailActiivty.class);

                intent.putExtra("shiftId", receiveListAdapter.getItem(i - 1).getId());
                intent.putExtra("show", "1");

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

    @Override
    public void initData() {

    }

    @Override
    public void onRefresh() {
        Log.i(TAG, "onRefresh: ===>下拉刷新");
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
//        getDataFomServer();
    }


    public void getDataFomServer(int currentPageInt) {
        String currentPage = String.valueOf(currentPageInt);

//        YunYouCheRequestBean requestBean = new YunYouCheRequestBean();
//        requestBean.setBeginNum(currentPage);
//        requestBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
//        requestBean.setEndNum(Constant.PER_PAGE_NUMS);
//        requestBean.setRecordStatus("");


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo == null) {
            return;
        }

        TurnedUserBean turnedUserBean = new TurnedUserBean();
        turnedUserBean.setBeginNum(currentPage);
        turnedUserBean.setTurnUserId(userInfo.getUserId());
        turnedUserBean.setEndNum(Constant.PER_PAGE_NUMS);
        turnedUserBean.setShiftStatus(WAIT_TO_SHIFT);


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(turnedUserBean);


//        Gson gson = new Gson();
//        String carNumJson = gson.toJson(turnedUserBean);
//        RequestBody requestBody = RequestBody.create(MediaType.parse(Constant.CONTENT_TYPE), carNumJson);

//        Call<YunYouCheResponseBean> call = HttpManger.getHttpMangerInstance().getServices().supplyList(requestBody);
//        call.enqueue(new Callback<YunYouCheResponseBean>() {
//            @Override
//            public void onResponse(Call<YunYouCheResponseBean> call, Response<YunYouCheResponseBean> response) {
//
//                if (listView != null) {
//                    listView.stopRefresh(true);
//                }
//                if (response.body() != null) {
//
//                    List<YunYouCheResponseBean.BringBean> bring = response.body().getBring();
//                    if (bring != null) {
//
//                        processJson(bring);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<YunYouCheResponseBean> call, Throwable t) {
//                listView.stopRefresh(false);
//                mLoadingLayout.showError();
//                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
//
//            }
//        });


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


//    private void processJson(List<YunYouCheResponseBean.BringBean> bring) {
//
//
//        Message msg = Message.obtain();
//        msg.what = 102;
//        msg.obj = bring;
//        mHandler.sendMessage(msg);
//
//    }

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

//        getDataFomServer();
//mLoadingLayout.showLoading();
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
