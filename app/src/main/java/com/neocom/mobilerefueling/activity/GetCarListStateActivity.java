package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.CarCodeAdapter;
import com.neocom.mobilerefueling.adapter.DailyBalanceListAdapter;
import com.neocom.mobilerefueling.bean.CarCodeReqBean;
import com.neocom.mobilerefueling.bean.CarCodeRespBean;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import org.greenrobot.eventbus.EventBus;

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

public class GetCarListStateActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.get_car_state_tpb)
    TopTitleBar getCarStateTpb;
    @BindView(R.id.daily_balance_rv)
    XRecyclerView dailyBalanceRv;


    CarCodeAdapter carCodeAdapter;
    List<CarCodeRespBean.BringBean> carCodeBringBean;

    private boolean isPullUp = false; // 是否是上啦加载
    private int currentPage = 1;


    @Override
    public void initContentView() {
        setContentView(R.layout.get_car_list_sate_layout);
    }

    @Override
    public void initView() {
        getCarStateTpb.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });


        initRecyclerView();
        queryDailyAllRecordList(Constant.FIRST_PAGE);

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
        dailyBalanceRv.setLoadingMoreEnabled(false);
        dailyBalanceRv.getDefaultFootView().setLoadingHint("加载中...");
        dailyBalanceRv.getDefaultFootView().setNoMoreHint("加载完毕...");

        carCodeBringBean = new ArrayList<>();
        carCodeAdapter = new CarCodeAdapter(GetCarListStateActivity.this, carCodeBringBean);
        dailyBalanceRv.setAdapter(carCodeAdapter);

        carCodeAdapter.setOnItemRecyclerViewClickListener(new CarCodeAdapter.OnItemRecyclerViewClick() {
            @Override
            public void OnItemClick(CarCodeRespBean.BringBean bringBean, int position) {

//                 final String carInfo = data.getStringExtra("carInfo");

                Intent intent = new Intent();
                intent.putExtra("carInfo", GsonUtil.GsonString(bringBean));
                setResult(104, intent);
                finish();
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

        if (carCodeBringBean != null && carCodeBringBean.size() > 0) {
            carCodeBringBean.clear();
            carCodeAdapter.notifyDataSetChanged();
        }

    }

    private void queryDailyAllRecordList(int currentPage) {

        if (!isPullUp) {
            resetListDatas();
        }

        CarCodeReqBean carCodeReqBean = new CarCodeReqBean();
//        carCodeReqBean.setCarCode(GetUserInfoUtils.getUserInfo().getCarNum());
        carCodeReqBean.setCarCode("");

//        jieSuanReqBean.setId(balanceId);
//        jieSuanReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
//        jieSuanReqBean.setBeginNum(String.valueOf(currentPage));
//        jieSuanReqBean.setEndNum(Constant.PER_PAGE_NUMS);

        startGetDataFromServer(carCodeReqBean);
    }

    private void startGetDataFromServer(CarCodeReqBean carCodeReqBean) {

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carCodeReqBean);
        Call<CarCodeRespBean> stringCall = HttpManger.getHttpMangerInstance().getServices().getCarStateList(requestBody);
        stringCall.enqueue(new Callback<CarCodeRespBean>() {
            @Override
            public void onResponse(Call<CarCodeRespBean> call, Response<CarCodeRespBean> response) {

//                carCodeBringBean


                List<CarCodeRespBean.BringBean> bring = response.body().getBring();
                showToAddView(bring);

            }

            @Override
            public void onFailure(Call<CarCodeRespBean> call, Throwable t) {

            }
        });


    }

    private void showToAddView(List<CarCodeRespBean.BringBean> bring) {

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
            carCodeBringBean.addAll(bring);
        }
        carCodeAdapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.daily_top_bar_finish_ll:
                finish();
                break;

        }

    }


}
