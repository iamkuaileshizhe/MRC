package com.neocom.mobilerefueling.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.JieSuanDailyBalanceListAdapter;
import com.neocom.mobilerefueling.bean.DailyBalanceReqBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.JieSuanReqBean;
import com.neocom.mobilerefueling.bean.JieSuanRespBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
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
 * Created by Administrator on 2018/5/29.
 * <p>
 * 日清日结
 */

public class JieSuanDailyBalanceActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.jiesuan_tpb)
    TopTitleBar jiesuanTpb;
    @BindView(R.id.daily_balance_rv)
    XRecyclerView dailyBalanceRv;


    DailyBalanceReqBean balanceReqBean;

    JieSuanReqBean jieSuanReqBean;

    //    DailyBalanceListAdapter dailyBalanceListAdapter;
    JieSuanDailyBalanceListAdapter jieSuanDailyBalanceListAdapter;
    List<JieSuanRespBean.BringBean> dailyBalanceReqBeen;

    private boolean isPullUp = false; // 是否是上啦加载
    private int currentPage = 1;
    private String id;
    private String payStatus;


    public static void jieSuanActionStart(Context context, String id, String payStatus) {

        Intent intent = new Intent(context, JieSuanDailyBalanceActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("payStatus", payStatus);
        context.startActivity(intent);

    }

    @Override
    public void initContentView() {
        setContentView(R.layout.jiesuan_layout);
    }

    @Override
    public void initView() {
        if (balanceReqBean == null) {
            balanceReqBean = new DailyBalanceReqBean();
        }

//        createAndgetdailyIndex();


        if (jieSuanReqBean == null) {
            jieSuanReqBean = new JieSuanReqBean();
        }


        //          intent.putExtra("id",id);
//        intent.putExtra("payStatus",payStatus);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        payStatus = intent.getStringExtra("payStatus");

        if (payStatus.equals("0")) {
            jiesuanTpb.setTitleText("未确认订单列表");
        } else if (payStatus.equals("1")) {
            jiesuanTpb.setTitleText("已确认订单列表");
        } else if (payStatus.equals("2")) {
            jiesuanTpb.setTitleText("账期订单订单列表");
        } else if (payStatus.equals("3")) {
            jiesuanTpb.setTitleText("个人完成订单订单列表");
        }

        initTopBar();

        initRecyclerView();
        queryDailyAllRecordList(Constant.FIRST_PAGE);


    }

    private void initTopBar() {

        jiesuanTpb.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {

                finish();

            }
        });


    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dailyBalanceRv.setLayoutManager(layoutManager);

        dailyBalanceRv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        dailyBalanceRv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        dailyBalanceRv.setArrowImageView(R.drawable.iconfont_downgrey);

        dailyBalanceRv
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        dailyBalanceRv.getDefaultFootView().setLoadingHint("加载中...");
        dailyBalanceRv.getDefaultFootView().setNoMoreHint("加载完毕...");

        dailyBalanceReqBeen = new ArrayList<>();
        jieSuanDailyBalanceListAdapter = new JieSuanDailyBalanceListAdapter(JieSuanDailyBalanceActivity.this, dailyBalanceReqBeen);
        dailyBalanceRv.setAdapter(jieSuanDailyBalanceListAdapter);

        jieSuanDailyBalanceListAdapter.setOnItemRecyclerViewClickListener(new JieSuanDailyBalanceListAdapter.OnItemRecyclerViewClick() {
            @Override
            public void OnItemClick(JieSuanRespBean.BringBean bringBean, int position) {

                LogUtils.i("点击的是--》" + position + ";;" + GsonUtil.GsonString(bringBean));
                String id = bringBean.getId();


                if (TextUtils.isEmpty(id)) {
                    return;
                }

//                DailyBalanceDetailActivity.detailStart(JieSuanDailyBalanceActivity.this, JieSuanDailyBalanceActivity.this.id);

//                PaiSongDanJDDialogUI.actionStart(JieSuanDailyBalanceActivity.this, id);
                DailyBlancePaiSongDanActivity.actionStart(JieSuanDailyBalanceActivity.this, id);
//
            }
        });

        dailyBalanceRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                isPullUp = false;
                currentPage = Constant.FIRST_PAGE;
                queryDailyAllRecordList(Constant.FIRST_PAGE);

            }

            @Override
            public void onLoadMore() {
                isPullUp = true;
                currentPage++;
                queryDailyAllRecordList(currentPage);
            }
        });

    }

    private void resetListDatas() {

        if (dailyBalanceReqBeen != null && dailyBalanceReqBeen.size() > 0) {
            dailyBalanceReqBeen.clear();
            jieSuanDailyBalanceListAdapter.notifyDataSetChanged();
        }

    }

    private String balanceId = "";

    private void createAndgetdailyIndex() {
        showLoadingDialog("创建结算记录中...");
        UserIdReqBean userIdReqBean = new UserIdReqBean();
        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
        Call<EmptyBringGetOilBean> dailyIndexCall = HttpManger.getHttpMangerInstance().getServices().dailyIndex(requestBody);
        disDialog();
        dailyIndexCall.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                EmptyBringGetOilBean body = response.body();

                if (body != null) {

                    String bring = body.getBring();
                    String message = body.getMessage();
                    boolean res = body.isRes();

                    if (res) {

                        if (TextUtils.isEmpty(bring)) {

                            if (TextUtils.isEmpty(message)) {

                                showWarnTip("创建失败");
                            } else {

                                showWarnTip(message);
                            }


                        } else {

                            balanceId = bring;


                        }

                    } else {

                        if (TextUtils.isEmpty(message)) {

                            showWarnTip("创建失败");
                        } else {

                            showWarnTip(message);
                        }

                    }

                } else {
                    showInfoTip("创建结算记录失败");
                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                LogUtils.i(t.getMessage());
            }
        });

    }

    private void queryDailyAllRecordList(int currentPage) {

        if (!isPullUp) {
            resetListDatas();
        }

//        jieSuanReqBean.setId(balanceId);


        jieSuanReqBean.setId(id);
        jieSuanReqBean.setStatus(payStatus);
        jieSuanReqBean.setBeginNum(String.valueOf(currentPage));
        jieSuanReqBean.setEndNum(Constant.PER_PAGE_NUMS);
        jieSuanReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        startGetDataFromServer(jieSuanReqBean);

    }

    private void startGetDataFromServer(JieSuanReqBean jieSuanBean) {

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(jieSuanBean);
        Call<JieSuanRespBean> stringCall = HttpManger.getHttpMangerInstance().getServices().queryIndentList(requestBody);
        stringCall.enqueue(new Callback<JieSuanRespBean>() {
            @Override
            public void onResponse(Call<JieSuanRespBean> call, Response<JieSuanRespBean> response) {

//                carCodeBringBean
                completeView();

                JieSuanRespBean body = response.body();

                if (body != null) {
                    String message = body.getMessage();

                    boolean res = body.isRes();


                    if (res) {

                        List<JieSuanRespBean.BringBean> bring = response.body().getBring();

                        if (bring != null) {
                            showToAddView(bring);
                        } else {
                            if (TextUtils.isEmpty(message)) {
                                showWarnTip("获取信息失败");
                            } else {
                                showWarnTip(message);
                            }
                        }

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showWarnTip("获取信息失败");
                        } else {
                            showWarnTip(message);
                        }

                    }


                } else {

                    showFailTip();
                }


            }

            @Override
            public void onFailure(Call<JieSuanRespBean> call, Throwable t) {
                completeView();
                showFailTip();
                LogUtils.e(t.getMessage());
            }
        });


    }


    private void completeView() {

        if (isPullUp) {

            dailyBalanceRv.loadMoreComplete();
        } else {
            dailyBalanceRv.refreshComplete();
        }


    }

    private void showToAddView(List<JieSuanRespBean.BringBean> bring) {

        if (isPullUp) {
            dailyBalanceRv.loadMoreComplete();

            if (bring != null && bring.size() >= 0) {

                if (bring.size() < 10) {
                    dailyBalanceRv.setNoMore(true);
                }
            }

        } else {
            dailyBalanceRv.refreshComplete();
        }

        if (bring != null && bring.size() > 0) {
            dailyBalanceReqBeen.addAll(bring);
        }
        jieSuanDailyBalanceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }

    }


}
