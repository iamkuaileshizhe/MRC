package com.neocom.mobilerefueling.processor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.BaseActivity;
import com.neocom.mobilerefueling.adapter.WaitToDoAdapter;
import com.neocom.mobilerefueling.bean.WaitDoRequest;
import com.neocom.mobilerefueling.bean.WaitDoResponse;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/5/26.
 * <p>
 * 已办事项
 */

public class HaveDoneActivity extends BaseActivity implements XRecyclerView.LoadingListener {
    @BindView(R.id.wait_do_topbar)
    TopTitleBar waitDoTopbar;
    @BindView(R.id.recyclerview)
    XRecyclerView recyclerview;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private int PAGE_CURRENT = Constant.FIRST_PAGE;

    private boolean isPullUp = false;// 是否是上拉

    WaitToDoAdapter waitToDoAdapter;

    List<WaitDoResponse.WaitDoItem> showListBring;


    @Override
    public void initContentView() {
        setContentView(R.layout.have_done_layout);
    }

    @Override
    public void initData() {

        if (showListBring == null) {
            showListBring = new ArrayList<>();
        }

        waitToDoAdapter = new WaitToDoAdapter(HaveDoneActivity.this, recyclerview, showListBring);
        recyclerview.setAdapter(waitToDoAdapter);

        waitToDoAdapter.setClickCallBack(new WaitToDoAdapter.ItemClickCallBack() {
            @Override
            public void onItemClick(WaitDoResponse.WaitDoItem waitDoItem, int pos) {

                Intent intent = new Intent(HaveDoneActivity.this, JingBanRenSPActivity.class);

                String itemData = GsonUtil.GsonString(waitDoItem);
                intent.putExtra("itemData", itemData);
                intent.putExtra("opFlag", "update");
                intent.putExtra("isButtonGone", Constant.BUTTON_DISSHOW);
                startActivity(intent);

            }
        });

    }

    @Override
    public void initView() {

        waitDoTopbar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });
        initRefreshAndLoadMore();


    }

    private void initRefreshAndLoadMore() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setPullRefreshEnabled(true);
        recyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);

        recyclerview.getDefaultFootView().setLoadingHint("加载中");
        recyclerview.getDefaultFootView().setNoMoreHint("加载完毕");

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//手机端 获取 数据


            }
        });

        recyclerview.setLoadingListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        clearListData();
        swipeRefreshLayout.setRefreshing(true);
        getDataFromServer(Constant.FIRST_PAGE);
    }


    public void clearListData() {
        if (showListBring != null && showListBring.size() > 0) {
            showListBring.clear();
            waitToDoAdapter.notifyDataSetChanged();
        }
    }

    private void getDataFromServer(int currentPage) {

//        todoList
        WaitDoRequest waitDoRequest = new WaitDoRequest();
        waitDoRequest.setBeginNum(String.valueOf(currentPage));
        waitDoRequest.setEndNum(Constant.PER_PAGE_NUMS);
        waitDoRequest.setC_user(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(waitDoRequest);

        Call<WaitDoResponse> todoListCall = HttpManger.getHttpMangerInstance().getServices().havedoList(requestBody);

        todoListCall.enqueue(new Callback<WaitDoResponse>() {
            @Override
            public void onResponse(Call<WaitDoResponse> call, Response<WaitDoResponse> response) {

                refreshState();
                WaitDoResponse waitDoResponse = response.body();

                if (waitDoResponse != null) {

                    List<WaitDoResponse.WaitDoItem> bring = waitDoResponse.getBring();

                    if (bring != null && bring.size() > 0) {

                        LogUtils.i("获取 待办事项的数据" + GsonUtil.GsonString(response.body()));

                        showDataToView(bring);


                    } else {

                        if (recyclerview != null) {
                            recyclerview.setNoMore(true);
                        }

                    }


                } else {
                    showFailTip();
                }
            }

            @Override
            public void onFailure(Call<WaitDoResponse> call, Throwable t) {
                refreshState();
                showFailTip();
                LogUtils.i(t.getMessage());

            }
        });

    }


    private void refreshState() {

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }

        if (isPullUp) {
            recyclerview.loadMoreComplete();
        } else {

            recyclerview.refreshComplete();
        }

    }


    private void showDataToView(List<WaitDoResponse.WaitDoItem> bring) {
        showListBring.addAll(bring);
        waitToDoAdapter.notifyDataSetChanged();

        if (isPullUp) {
            recyclerview.loadMoreComplete();
            if (bring.size() < 10) {
                recyclerview.setNoMore(true);
            }
        }

//        waitToDoAdapter.setClickCallBack(new WaitToDoAdapter.ItemClickCallBack() {
//            @Override
//            public void onItemClick(WaitDoResponse.WaitDoItem waitDoItem, int pos) {
//
//                Intent intent = new Intent(HaveDoneActivity.this, JingBanRenSPActivity.class);
//
//                String itemData = GsonUtil.GsonString(waitDoItem);
//                intent.putExtra("itemData", itemData);
//                intent.putExtra("opFlag", "update");
//                intent.putExtra("isButtonGone", StaticUtils.BUTTON_DISSHOW);
//                startActivity(intent);
//
//            }
//        });

    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        clearListData();
        isPullUp = false;
        PAGE_CURRENT = Constant.FIRST_PAGE;
        getDataFromServer(PAGE_CURRENT);

    }

    @Override
    public void onLoadMore() {
        isPullUp = true;

        PAGE_CURRENT++;
        getDataFromServer(PAGE_CURRENT);
    }
}
