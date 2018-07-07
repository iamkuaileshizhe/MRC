package com.neocom.mobilerefueling.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.DailyBalanceDropAdapter;
import com.neocom.mobilerefueling.adapter.DailyBalanceListAdapter;
import com.neocom.mobilerefueling.bean.DailyBalanceBean;
import com.neocom.mobilerefueling.bean.DailyBalanceReqBean;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.downloadutils.LogUtil;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class DailyBalanceActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.daily_top_bar_finish_ll)
    LinearLayout dailyTopBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.daily_build_ll)
    LinearLayout dailyBuildLl;
    @BindView(R.id.trade_way)
    TextView tradeWay;
    @BindView(R.id.daily_pay_way_ll)
    LinearLayout dailyPayWayLl;
    @BindView(R.id.dily_start_time_tv)
    TextView dilyStartTimeTv;
    @BindView(R.id.daily_start_date_ll)
    LinearLayout dailyStartDateLl;
    @BindView(R.id.dily_end_time_tv)
    TextView dilyEndTimeTv;
    @BindView(R.id.daily_end_date_ll)
    LinearLayout dailyEndDateLl;
    @BindView(R.id.daily_balance_rv)
    XRecyclerView dailyBalanceRv;
    @BindView(R.id.empty_text)
    TextView emptyText;


    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;
    private String balance_type[] = {"全部", "待结算", "已结算"};
    private TimePickerView pvCustomLunar;

    private boolean isStartDate = true; // 是否是开始日期

    DailyBalanceReqBean balanceReqBean;

    DailyBalanceReqBean dailyBalanceReqBean;

    DailyBalanceListAdapter dailyBalanceListAdapter;
    List<DailyBalanceRespBean.BringBean> dailyBalanceReqBeen;

    private boolean isPullUp = false; // 是否是上啦加载
    private int currentPage = 1;

    private boolean isStartTimeCHoose = false;
    private boolean isEndTimeCHoose = false;

    @Override
    public void initContentView() {
        setContentView(R.layout.daily_balance_layout);
    }

    @Override
    public void initView() {
        if (balanceReqBean == null) {
            balanceReqBean = new DailyBalanceReqBean();
        }
        dailyTopBarFinishLl.setOnClickListener(this);
        dailyPayWayLl.setOnClickListener(this);
        dailyStartDateLl.setOnClickListener(this);
        dailyEndDateLl.setOnClickListener(this);
        emptyText.setOnClickListener(this);
        initTimeChoose();

//        createAndgetdailyIndex();


        if (dailyBalanceReqBean == null) {
            dailyBalanceReqBean = new DailyBalanceReqBean();
        }

        initRecyclerView();


    }


    @Override
    protected void onStart() {
        super.onStart();
        GetFirstData();
    }

    private void GetFirstData() {
        isPullUp = false;
        currentPage = Constant.FIRST_PAGE;
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
        dailyBalanceRv.getDefaultFootView().setLoadingHint("加载中...");
        dailyBalanceRv.getDefaultFootView().setNoMoreHint("加载完毕...");

        dailyBalanceReqBeen = new ArrayList<>();
        dailyBalanceListAdapter = new DailyBalanceListAdapter(DailyBalanceActivity.this, dailyBalanceReqBeen);
        dailyBalanceRv.setAdapter(dailyBalanceListAdapter);

        dailyBalanceListAdapter.setOnItemRecyclerViewClickListener(new DailyBalanceListAdapter.OnItemRecyclerViewClick() {
            @Override
            public void OnItemClick(DailyBalanceRespBean.BringBean bringBean, int position) {

                LogUtils.i("-->" + GsonUtil.GsonString(bringBean));

                String id = bringBean.getId();
                if (TextUtils.isEmpty(id)) {
                    return;
                }

                DailyBalanceDetailActivity.detailStart(DailyBalanceActivity.this, id);
            }
        });

        dailyBalanceRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

//                isPullUp = false;
//                currentPage = Constant.FIRST_PAGE;
//                queryDailyAllRecordList(Constant.FIRST_PAGE);

                GetFirstData();
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
            dailyBalanceListAdapter.notifyDataSetChanged();
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

        if (isStartTimeCHoose && isEndTimeCHoose) {
            LogUtils.i("可以请求");
        } else if (!isStartTimeCHoose && !isEndTimeCHoose) {
            LogUtils.i("可以请求");
        } else {
            showShortToast("请选择完整的起始时间");
            return;
        }

        if (!isPullUp) {
            resetListDatas();
        }


        dailyBalanceReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        dailyBalanceReqBean.setBeginNum(String.valueOf(currentPage));
        dailyBalanceReqBean.setEndNum(Constant.PER_PAGE_NUMS);

        startGetDataFromServer(dailyBalanceReqBean);

    }

    private void startGetDataFromServer(DailyBalanceReqBean dailyBalanceReqBean) {
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(dailyBalanceReqBean);
        Call<DailyBalanceRespBean> stringCall = HttpManger.getHttpMangerInstance().getServices().queryDailyRecordList(requestBody);
        stringCall.enqueue(new Callback<DailyBalanceRespBean>() {
            @Override
            public void onResponse(Call<DailyBalanceRespBean> call, Response<DailyBalanceRespBean> response) {

//                carCodeBringBean
                completeView();

                DailyBalanceRespBean body = response.body();

                if (body != null) {
                    String message = body.getMessage();

                    boolean res = body.isRes();


                    if (res) {

                        List<DailyBalanceRespBean.BringBean> bring = response.body().getBring();
                        if (bring != null) {
                            showToAddView(bring);
                        } else {
                            if (TextUtils.isEmpty(message)) {
                                showWarnTip("获取信息失败");
                            } else {
                                showWarnTip(message);
                            }

                            setEmptyRec();
                        }

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showWarnTip("获取信息失败");
                        } else {
                            showWarnTip(message);
                        }

                    }

                    setEmptyRec();
                } else {

                    showFailTip();
                }

            }

            @Override
            public void onFailure(Call<DailyBalanceRespBean> call, Throwable t) {
                completeView();
                showFailTip();
                setEmptyRec();
                LogUtils.e(t.getMessage());
            }
        });


    }

    private void setEmptyRec() {

        if (dailyBalanceRv != null && dailyBalanceListAdapter != null) {
            dailyBalanceRv.setEmptyView(emptyText);
            dailyBalanceListAdapter.notifyDataSetChanged();

        }

    }

    private void completeView() {

        if (isPullUp) {

            dailyBalanceRv.loadMoreComplete();
        } else {
            dailyBalanceRv.refreshComplete();
        }
    }

    private void showToAddView(List<DailyBalanceRespBean.BringBean> bring) {

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
        dailyBalanceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
        initDropData();
    }


    List<DailyBalanceBean> balanceBeen;

    private void initDropData() {
        balanceBeen = new ArrayList<>();
        DailyBalanceBean dailyBalanceAll = new DailyBalanceBean();
        dailyBalanceAll.setId("1");
        dailyBalanceAll.setValue("全部");
        balanceBeen.add(dailyBalanceAll);

        DailyBalanceBean dailyBalanceWill = new DailyBalanceBean();
        dailyBalanceWill.setId("0");
        dailyBalanceWill.setValue("待结算");
        balanceBeen.add(dailyBalanceWill);

        DailyBalanceBean dailyBalanceAlready = new DailyBalanceBean();
        dailyBalanceAlready.setId("2");
        dailyBalanceAlready.setValue("已结算");
        balanceBeen.add(dailyBalanceAlready);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.daily_top_bar_finish_ll:
                finish();
                break;
            case R.id.daily_pay_way_ll:
                showPopItem(balanceBeen, dailyPayWayLl);
                break;
            case R.id.daily_start_date_ll:
                isStartDate = true;
//                显示开始日期
                pvCustomLunar.show();
                break;
            case R.id.daily_end_date_ll:
                isStartDate = false;
//                显示结束日期
                pvCustomLunar.show();
                break;
            case R.id.empty_text:


                GetFirstData();

                break;
        }

    }


    private void showPopItem(List<DailyBalanceBean> datas, LinearLayout parenr) {
        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {
            layoutLeft = UIUtils.inflate(
                    R.layout.pop_menulist);
            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            final DailyBalanceDropAdapter adapter = new DailyBalanceDropAdapter(DailyBalanceActivity.this, datas);
            menulistLeft.setAdapter(adapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(DailyBalanceActivity.this, "点就是" + adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();

                    DailyBalanceBean adapterItem = adapter.getItem(position);

                    tradeWay.setText(adapterItem.getValue());
                    dailyBalanceReqBean.setPayStatus(adapterItem.getId());
                    GetFirstData();
                    // 隐藏弹出窗口
                    if (popLeft != null && popLeft.isShowing()) {
                        popLeft.dismiss();
                    }

                }
            });

            // 创建弹出窗口
            // 窗口内容为layoutLeft，里面包含一个ListView
            // 窗口宽度跟tvLeft一样
            popLeft = new PopupWindow(layoutLeft, parenr.getWidth(),
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(Color.BLACK);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            int topBarHeight = parenr.getBottom();
            popLeft.showAsDropDown(parenr, 0,
                    (topBarHeight - parenr.getHeight()) / 2);

            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });


        }

    }

    private void initTimeChoose() {
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomLunar = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
//                Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();

                if (isStartDate) {

                    String startTime = CommonUtil.getTime(date);
                    dilyStartTimeTv.setText(startTime);
                    dailyBalanceReqBean.setStartTime(startTime);
                    isStartTimeCHoose = true;
                } else {
                    String endTime = CommonUtil.getTime(date);
                    dilyEndTimeTv.setText(endTime);
                    dailyBalanceReqBean.setEndNum(endTime);
                    isEndTimeCHoose = true;
                }

                GetFirstData();
            }
        })
                .setDate(selectedDate)
//                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_lunar, new CustomListener() {

                    @Override
                    public void customLayout(final View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomLunar.returnData();
                                pvCustomLunar.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomLunar.dismiss();
                            }
                        });
                        //公农历切换
                        CheckBox cb_lunar = (CheckBox) v.findViewById(R.id.cb_lunar);
                        cb_lunar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                pvCustomLunar.setLunarCalendar(!pvCustomLunar.isLunarCalendar());
                                //自适应宽
                                setTimePickerChildWeight(v, 0.8f, isChecked ? 1f : 1.1f);
                            }
                        });

                    }

                    /**
                     * 公农历切换后调整宽
                     * @param v
                     * @param yearWeight
                     * @param weight
                     */
                    private void setTimePickerChildWeight(View v, float yearWeight, float weight) {
                        ViewGroup timepicker = (ViewGroup) v.findViewById(R.id.timepicker);
                        View year = timepicker.getChildAt(0);
                        LinearLayout.LayoutParams lp = ((LinearLayout.LayoutParams) year.getLayoutParams());
                        lp.weight = yearWeight;
                        year.setLayoutParams(lp);
                        for (int i = 1; i < timepicker.getChildCount(); i++) {
                            View childAt = timepicker.getChildAt(i);
                            LinearLayout.LayoutParams childLp = ((LinearLayout.LayoutParams) childAt.getLayoutParams());
                            childLp.weight = weight;
                            childAt.setLayoutParams(childLp);
                        }
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(Color.RED)
                .build();
    }

}
