package com.neocom.mobilerefueling.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.activity.DSHKeHuAllActivity;
import com.neocom.mobilerefueling.adapter.QZKHListAdapter;
import com.neocom.mobilerefueling.bean.DSHKeHuBean;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.QZKHReqBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingLayout;
import com.neocom.mobilerefueling.view.SearchEditText;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/25.
 */
//, DSHKeHuAllActivity.MyOnTouchListener
public class DSHKeHuAllFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

    private QZKHListAdapter receiveListAdapter;

    List<KHDetailBringBean> bringShow;

//    private ReceiveListUpdateObserver updateObserver;

    private int CURRENT_PAGE_NUMBER = 1; // 要 加载的第几页
    private boolean isPullState = false; // 是否是 上拉加载的状态 true 是上拉 加载 false 不是上拉加载

//    DSHKeHuAllActivity.MyOnTouchListener onTouchListener;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:

                    bringShow = (List<KHDetailBringBean>) msg.obj;

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
                            if (size == 0) {
                                mLoadingLayout.showEmpty();
                                return;
                            }

                            receiveListAdapter = new QZKHListAdapter(bringShow);
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
    private Context mContext;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.dsh_search_list_layout);
//        view = View.inflate(UIUtils.getContext(), R.layout.receive_list_layout, null);
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
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KHDetailBringBean item = receiveListAdapter.getItem(position - 1);
                String idShenHeItem = item.getId(); // 提交时 用 此 ID
                String idItem = item.getCustomerId(); // 查询 详情 用 此 ID

                String checkStatus = item.getCheckStatus();

                Intent intent = new Intent(getActivity(), AddQianZaiKeHuActivity.class);
//                if (TextUtils.isEmpty(idItem)) {
                intent.putExtra("idItem", idShenHeItem);
//                } else {
//                    intent.putExtra("idItem", idItem);
//                }
                intent.putExtra("shenHeId", idShenHeItem);
                intent.putExtra("checkStatus", checkStatus);
                intent.putExtra(Constant.COMING,Constant.DCL_COMING );
                startActivity(intent);
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


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (isShouldHideKeyboard(v, ev)) {
//                hideKeyboard(v.getWindowToken());
//            }
//        }
//        return super.dispatchTouchEvent(ev);
//    }


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

    }


    public void getDataFomServer(int currentPageInt) {

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo == null) {
            return;
        }

        String currentPage = String.valueOf(currentPageInt);

//        QZKHReqBean reqBean = new QZKHReqBean();
//        reqBean.setBeginNum(currentPage);
//        reqBean.setEndNum(Constant.PER_PAGE_NUMS);
//        reqBean.setRoleCode(GetOrderStateUtil.getRoleCode(userInfo.getRoleCode()));
////        reqBean.setCheckStatus(Constant.QZKH_ALL);
//        reqBean.setNameSim("");
////        reqBean.setUserId(userInfo.getUserId());

        DSHKeHuBean reqBean = new DSHKeHuBean();
        reqBean.setCurrentPage(currentPage);
        reqBean.setRoleCode(GetOrderStateUtil.getRoleCode(userInfo.getRoleCode()));
        reqBean.setNameSim("");
        reqBean.setPageSize(Constant.PER_PAGE_NUMS);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqBean);


        Call<QZKHRespBean> call = HttpManger.getHttpMangerInstance().getServices().findCheckPendingCustomer(requestBody);
        call.enqueue(new Callback<QZKHRespBean>() {
            @Override
            public void onResponse(Call<QZKHRespBean> call, Response<QZKHRespBean> response) {

                if (listView != null) {
                    listView.stopRefresh(true);
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
                listView.stopRefresh(false);
                if (isPullState) {
                    mLoadingLayout.showError();
                }
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());

            }
        });

    }


    private void processJson(List<KHDetailBringBean> bring) {


        Log.i(TAG, "processJson: " + new Gson().toJson(bring));

        Message msg = Message.obtain();
        msg.what = 102;
        msg.obj = bring;
        mHandler.sendMessage(msg);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


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
    public void onAttach(Activity activity) {

        mContext = activity.getApplication();
        super.onAttach(activity);

    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = ((Activity) mContext).getCurrentFocus();
//            if (isShouldHideKeyboard(v, ev)) {
//                hideKeyboard(v.getWindowToken());
//            }
//        }
//
//        return false;
//    }
//
//
//    /**
//     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
//     *
//     * @param v
//     * @param event
//     * @return
//     */
//    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
//        if (v != null && (v instanceof EditText)) {
//            int[] l = {0, 0};
//            v.getLocationInWindow(l);
//            int left = l[0],
//                    top = l[1],
//                    bottom = top + v.getHeight(),
//                    right = left + v.getWidth();
//            if (event.getX() > left && event.getX() < right
//                    && event.getY() > top && event.getY() < bottom) {
//                // 点击EditText的事件，忽略它。
//                return false;
//            } else {
//                v.clearFocus();
//                return true;
//            }
//        }
//        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
//        return false;
//    }
//
//    /**
//     * 获取InputMethodManager，隐藏软键盘
//     *
//     * @param token
//     */
//    private void hideKeyboard(IBinder token) {
//        if (token != null) {
//            InputMethodManager im = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
//        }
//    }


}
