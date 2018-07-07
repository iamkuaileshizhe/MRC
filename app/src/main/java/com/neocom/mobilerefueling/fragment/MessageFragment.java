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
import android.widget.AdapterView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.MsgAdapter;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MsgBean;
import com.neocom.mobilerefueling.net.HttpManger;
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
 * Created by admin on 2017/12/14.
 */

public class MessageFragment extends BaseFragment implements XListView.IXListViewListener {

    private View view;
    //    private XListView xListView;
    private XListView listView;

    private MsgAdapter receiveListAdapter;

//    List<ResponseDingDanOrderBean.BringBean> bringShow;

    List<MsgBean.BringBean> bringShow;
//    private ReceiveListUpdateObserver updateObserver;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:

                    bringShow = (List<MsgBean.BringBean>) msg.obj;


                    if (bringShow != null) {
                        int size = bringShow.size();
                        if (size == 0) {
                            mLoadingLayout.showEmpty();
                            return;
                        }

                        receiveListAdapter = new MsgAdapter(bringShow);
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

        view = UIUtils.inflate(R.layout.msg_list_layout);
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
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(UIUtils.getContext(), "1111111111111111", Toast.LENGTH_SHORT).show();
//                ResponseDingDanOrderBean.BringBean item = receiveListAdapter.getItem(i - 1);
//                if (item == null) {
//                    Toast.makeText(UIUtils.getContext(), "获取数据异常", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//
//
//                    String itemId = item.getId();
//                    String paiDanState = item.getIndentStatus();
//                    Intent intent = new Intent(UIUtils.getContext(), OrderDetailNewActivity.class);
//                    intent.putExtra("itemId", itemId);
//                    intent.putExtra("paiDanState", paiDanState);
//                    startActivity(intent);
//
//                }


            }
        });


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
        getDataFomServer();
    }


    public void getDataFomServer() {

        ReqId reqId = new ReqId();

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo == null) {
            return;
        }

        reqId.setUserId(userInfo.getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqId);

        HttpManger.getHttpMangerInstance().getServices().getAllMessage(requestBody).enqueue(new Callback<MsgBean>() {
            @Override
            public void onResponse(Call<MsgBean> call, Response<MsgBean> response) {

                MsgBean body = response.body();

                if (listView != null) {
                    listView.stopRefresh(true);
                }

                if (body != null) {
                    List<MsgBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        processJson(bring);


                    }


                }


            }

            @Override
            public void onFailure(Call<MsgBean> call, Throwable t) {
                if (listView != null) {
                    listView.stopRefresh(true);
                }
            }
        });


    }


    private void processJson(List<MsgBean.BringBean> bring) {

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

    public class ReqId {

        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ReqId{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }

}