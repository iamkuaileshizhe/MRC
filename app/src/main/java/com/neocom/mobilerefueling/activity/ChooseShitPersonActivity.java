package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ChoosePersonAdapter;
import com.neocom.mobilerefueling.adapter.ShitAdapter;
import com.neocom.mobilerefueling.bean.ChoosePersonBean;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.LoadingLayout;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/21.
 */

public class ChooseShitPersonActivity extends BaseActivity implements XListView.IXListViewListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.loading_layout)
    LoadingLayout mLoadingLayout;
    @BindView(R.id.person_listview)
    XListView listView;

    private ChoosePersonAdapter receiveListAdapter;

    List<ChoosePersonBean.BringBean> bringShow;


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {

                case 102:

                    bringShow = (List<ChoosePersonBean.BringBean>) msg.obj;


                    if (bringShow != null) {
                        int size = bringShow.size();
                        if (size == 0) {
                            mLoadingLayout.showEmpty();
                            return;
                        }

                        receiveListAdapter = new ChoosePersonAdapter(ChooseShitPersonActivity.this, bringShow);
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


    @Override
    public void initContentView() {
        setContentView(R.layout.choose_persion_layout);
    }

    @Override
    public void initView() {

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mLoadingLayout.showLoading();
        listView.setPullLoadEnable(true);
        listView.setXListViewListener(this);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////跳转 个人详情 shiftUser
//                Intent intent = new Intent();
//                intent.putExtra("shiftUser", receiveListAdapter.getItem(i-1).getUserName());
//                setResult(2, intent);
//                finish();
//            }
//        });


        mLoadingLayout.setErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoadingLayout.showLoading();
                getDataFomServer();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        getDataFomServer();
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


    public void getDataFomServer() {
        ReqUserID reqUserID = new ReqUserID();
        reqUserID.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqUserID);
        HttpManger.getHttpMangerInstance().getServices().findPeopleByDeptId(requestBody).enqueue(new Callback<ChoosePersonBean>() {
            @Override
            public void onResponse(Call<ChoosePersonBean> call, Response<ChoosePersonBean> response) {
                mLoadingLayout.showMain();


                ChoosePersonBean body = response.body();

                if (listView != null) {
                    listView.stopRefresh(true);
                }

                if (body != null) {

                    List<ChoosePersonBean.BringBean> bring = body.getBring();

                    if (bring != null) {
                        processJson(bring);
                    }

                }

//                List<ChoosePersonBean.BringBean> bring = response.body().getBring();
//                if (listView != null) {
//                    listView.stopRefresh(true);
//                }
//                if (bring != null) {
//                    processJson(bring);
//                }

            }

            @Override
            public void onFailure(Call<ChoosePersonBean> call, Throwable t) {

                if (listView != null) {
                    listView.stopRefresh(false);
                }
                mLoadingLayout.showError();

            }
        });

    }


    private void processJson(List<ChoosePersonBean.BringBean> bring) {

        Message msg = Message.obtain();
        msg.what = 102;
        msg.obj = bring;
        mHandler.sendMessage(msg);
    }


    @Override
    public void initData() {

    }

    public class ReqUserID {

        private String userId;


        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ReqUserID{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }


}
