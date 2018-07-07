package com.neocom.mobilerefueling.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.neo.mobilerefueling.R;
//import com.neo.mobilerefueling.adapter.RecmentListAdapter;
//import com.neo.mobilerefueling.bean.LoginResponseBean;
//import com.neo.mobilerefueling.bean.RecmentReqListBean;
//import com.neo.mobilerefueling.bean.RecmentRespListBean;
//import com.neo.mobilerefueling.globle.Constant;
//import com.neo.mobilerefueling.net.HttpManger;
//import com.neo.mobilerefueling.utils.GetUserInfoUtils;
//import com.neo.mobilerefueling.utils.UIUtils;
//import com.neo.mobilerefueling.view.LoadingLayout;
//import com.neo.mobilerefueling.view.XListView;
//
//import java.util.List;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.MyRecommentActivity;
import com.neocom.mobilerefueling.adapter.RecmentListAdapter;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.RecmentReqListBean;
import com.neocom.mobilerefueling.bean.RecmentRespListBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingLayout;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/13.
 * <p>
 * 推荐列表 展示
 */
public class RecmentListFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

    //    private DingDanAdapter receiveListAdapter;
    private RecmentListAdapter receiveListAdapter;

    //    List<RecmentRespListBean.BringBean> bringShow;
//    List<RecmentRespListBean.BringBean> bringShow;
    List<RecmentRespListBean.BringBean.RecomListBean> bringShow;

    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case 102:

                    bringShow = (List<RecmentRespListBean.BringBean.RecomListBean>) msg.obj;

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
//                            if (size == 0) {
//                                mLoadingLayout.showEmpty();
//                                return;
//                            }

                            receiveListAdapter = new RecmentListAdapter(bringShow);
                            listView.setAdapter(receiveListAdapter);

                            mLoadingLayout.showMain();

                            if (size < 10) {
                                listView.stopLoadMore("");
                            }

                            CURRENT_PAGE_NUMBER++;
                            Log.i(TAG, "handleMessage: 准备去加载，第" + CURRENT_PAGE_NUMBER + "页");

                        } else {
//                            mLoadingLayout.showEmpty();
                            LogUtils.i("空的列表");
                        }


                    }

                    break;
            }

        }
    };


    private LoadingLayout mLoadingLayout;
    private MyRecommentActivity recommentActivity;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.receive_list_layout);
//        view = View.inflate(UIUtils.getContext(), R.layout.receive_list_layout, null);
        return view;
    }

    @Override
    public void initView() {

        listView = view.findViewById(R.id.receive_listview);
        mLoadingLayout = view.findViewById(R.id.loading_layout);
        mLoadingLayout.showLoading();
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(true);
        listView.setXListViewListener(this);


        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoadingLayout.showLoading();
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

        isPullState = true;
        getDataFomServer(CURRENT_PAGE_NUMBER);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: 生命周期");
//        getDataFomServer();

        recommentActivity = (MyRecommentActivity) getActivity();

        recommentActivity.setMyRecNo("");
        recommentActivity.setMyRecomendor("");

    }


    public void getDataFomServer(int currentPageInt) {

        String currentPage = String.valueOf(currentPageInt);

        RecmentReqListBean recmentReqListBean = new RecmentReqListBean();

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo == null) {
            return;
        }

        recmentReqListBean.setUserId(userInfo.getUserId());
        recmentReqListBean.setPage(currentPage);
        recmentReqListBean.setPageSize(Constant.PER_PAGE_NUMS);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(recmentReqListBean);

        Call<RecmentRespListBean> call = HttpManger.getHttpMangerInstance().getServices().queryRurInfoList(requestBody);
        call.enqueue(new Callback<RecmentRespListBean>() {
            @Override
            public void onResponse(Call<RecmentRespListBean> call, Response<RecmentRespListBean> response) {

                RecmentRespListBean body = response.body();
                if (listView != null) {
                    listView.stopRefresh(true);
                }


//                if (body != null) {
//                    List<RecmentRespListBean.BringBean> bringBeen = body.getBring();
//                    if (bringBeen != null) {
//                        processJson(bringBeen);
//                    }
//                }

                boolean res = body.isRes();

                if (res) {

                    RecmentRespListBean.BringBean bodyBring = body.getBring();

                    if (bodyBring != null) {


                        processJson(bodyBring);

                    }


                } else {

                    mLoadingLayout.showError();

                }


            }

            @Override
            public void onFailure(Call<RecmentRespListBean> call, Throwable t) {
                listView.stopRefresh(false);
                mLoadingLayout.showError();
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());

            }
        });

    }


    private void processJson(RecmentRespListBean.BringBean bodyBring) {


//        RecmentRespListBean.BringBean bodyBring
//        List<RecmentRespListBean.BringBean> bringBeen

        List<RecmentRespListBean.BringBean.RecomListBean> recomList = bodyBring.getRecomList();

        String rUserName = bodyBring.getRUserName();
        String totalNo = bodyBring.getTotal();

        recommentActivity.setMyRecNo(totalNo);
        recommentActivity.setMyRecomendor(rUserName);

        Message msg = Message.obtain();
        msg.what = 102;
        msg.obj = recomList;
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
//        getDataFomServer();
//        mLoadingLayout.showLoading();

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
//public class RecmentListFragment extends BaseFragment implements XListView.IXListViewListener {
//
//    private View view;
//    //    private XListView xListView;
//    private XListView listView;
//
////    private DingDanAdapter receiveListAdapter;
//    private RecmentListAdapter receiveListAdapter;
//
//    List<RecmentRespListBean.BringBean> bringShow;
//
//
//    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
//    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载
//
//    private Handler mHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//
//            switch (msg.what) {
//
//                case 102:
//
//                    bringShow = (List<RecmentRespListBean.BringBean>) msg.obj;
//
//                    if (isPullState) {
//                        // 上拉加载
//
//                        if (bringShow == null) {
//                            listView.stopLoadMore("已无更多数据");
//                            Log.i(TAG, "handleMessage: 已无更多数据,页数=》" + CURRENT_PAGE_NUMBER);
//                        } else {
//
//                            receiveListAdapter.addMoreListData(bringShow);
//                            int size = bringShow.size();
//
//                            if (size < 10) {
//                                listView.stopLoadMore("已全部加载");
//                            }
//
//
//                            if (size != 0) {
//
//                                CURRENT_PAGE_NUMBER++;
//                            }
//
//                            Log.i(TAG, "handleMessage: 在 上拉去加载，第" + CURRENT_PAGE_NUMBER + "页" + "，加载" + size + "个");
//                            listView.stopLoadMore();
//                            listView.stopLoadMore("已加载");
//
//                        }
//
//
//                    } else {
//                        // 下拉刷新
//
//                        if (bringShow != null) {
//                            int size = bringShow.size();
//                            if (size == 0) {
//                                mLoadingLayout.showEmpty();
//                                return;
//                            }
//
//                            receiveListAdapter = new RecmentListAdapter(bringShow);
//                            listView.setAdapter(receiveListAdapter);
//
//                            mLoadingLayout.showMain();
//
//                            if (size < 10) {
//                                listView.stopLoadMore("已全部加载");
//                            }
//
//                            CURRENT_PAGE_NUMBER++;
//                            Log.i(TAG, "handleMessage: 准备去加载，第" + CURRENT_PAGE_NUMBER + "页");
//
//                        } else {
//                            mLoadingLayout.showEmpty();
//                        }
//
//
//                    }
//
//                    break;
//            }
//
//        }
//    };
//
//
//    private LoadingLayout mLoadingLayout;
//
//    @Override
//    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        view = UIUtils.inflate(R.layout.receive_list_layout);
////        view = View.inflate(UIUtils.getContext(), R.layout.receive_list_layout, null);
//        return view;
//    }
//
//    @Override
//    public void initView() {
//
//        listView = view.findViewById(R.id.receive_listview);
//        mLoadingLayout = view.findViewById(R.id.loading_layout);
//        mLoadingLayout.showLoading();
//        listView.setPullLoadEnable(true);
//        listView.setXListViewListener(this);
//
//
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                RecmentRespListBean.BringBean item = receiveListAdapter.getItem(i - 1);
////                if (item == null) {
////                    Toast.makeText(UIUtils.getContext(), "获取数据异常", Toast.LENGTH_SHORT).show();
////                    return;
////                } else {
////
////
////                    String itemId = item.getId();
////                    String paiDanState = item.getIndentStatus();
////                    Intent intent = new Intent(UIUtils.getContext(), OrderDetailNewActivity.class);
////                    intent.putExtra("itemId", itemId);
////                    intent.putExtra("paiDanState", paiDanState);
////                    startActivity(intent);
////
////                }
////
////
////            }
////        });
//
//
//        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mLoadingLayout.showLoading();
//                mLoadingLayout.showLoading();
//                isPullState = false;
//                CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
//                getDataFomServer(CURRENT_PAGE_NUMBER);
//            }
//        });
//
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//    @Override
//    public void onRefresh() {
//        Log.i(TAG, "onRefresh: ===>下拉刷新");
//        isPullState = false;
//        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
//        getDataFomServer(CURRENT_PAGE_NUMBER);
//    }
//
//    @Override
//    public void onLoadMore() {
//        Log.i(TAG, "onLoadMore: 上拉加载");
//
//        isPullState = true;
//        getDataFomServer(CURRENT_PAGE_NUMBER);
//
//    }
//
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Log.i(TAG, "onActivityCreated: 生命周期");
////        getDataFomServer();
//    }
//
//
//    public void getDataFomServer(int currentPageInt) {
//
//        String currentPage = String.valueOf(currentPageInt);
//
//        RecmentReqListBean recmentReqListBean = new RecmentReqListBean();
//
//        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
//        if (userInfo == null) {
//            return;
//        }
//
//        recmentReqListBean.setUserId(userInfo.getUserId());
////        recmentReqListBean.setUserId("d01a3197e17f414e94b8f2d32fb37fd8");
//        recmentReqListBean.setPage(currentPage);
//        recmentReqListBean.setPageSize(Constant.PER_PAGE_NUMS);
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(recmentReqListBean);
//
//        Call<RecmentRespListBean> call = HttpManger.getHttpMangerInstance().getServices().queryRurInfoList(requestBody);
//        call.enqueue(new Callback<RecmentRespListBean>() {
//            @Override
//            public void onResponse(Call<RecmentRespListBean> call, Response<RecmentRespListBean> response) {
//
//                RecmentRespListBean body = response.body();
//                if (listView != null) {
//                    listView.stopRefresh(true);
//                }
//                if (body != null) {
//                    List<RecmentRespListBean.BringBean> bringBeen = body.getBring();
//                    if (bringBeen != null) {
//                        processJson(bringBeen);
//                    }
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<RecmentRespListBean> call, Throwable t) {
//                listView.stopRefresh(false);
//                mLoadingLayout.showError();
//                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
//
//            }
//        });
//
//    }
//
//
//    private void processJson(List<RecmentRespListBean.BringBean> bringBeen) {
//
//        Message msg = Message.obtain();
//        msg.what = 102;
//        msg.obj = bringBeen;
//        mHandler.sendMessage(msg);
//
//    }
//
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.i(TAG, "onAttach: 生命周期");
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.i(TAG, "onCreate: 生命周期");
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Log.i(TAG, "onCreateView: 生命周期");
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.i(TAG, "onStart: 生命周期");
////        getDataFomServer();
////        mLoadingLayout.showLoading();
//
//        mLoadingLayout.showLoading();
//        isPullState = false;
//        CURRENT_PAGE_NUMBER = Constant.FIRST_PAGE;
//        getDataFomServer(CURRENT_PAGE_NUMBER);
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.i(TAG, "onResume: 生命周期");
//
////        getDataFomServer();
////        mLoadingLayout.showLoading();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.i(TAG, "onPause: 生命周期");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.i(TAG, "onStop: 生命周期");
//
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.i(TAG, "onDestroyView: 生命周期");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.i(TAG, "onDestroy: 生命周期");
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.i(TAG, "onDetach: 生命周期");
//    }
//}
