package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ListDropDownAdapter;
import com.neocom.mobilerefueling.bean.AddShitWorkBean;
import com.neocom.mobilerefueling.bean.AddShitWorkRespBean;
import com.neocom.mobilerefueling.bean.CarInfoRespBean;
import com.neocom.mobilerefueling.bean.CarStateRespBean;
import com.neocom.mobilerefueling.bean.DicChildrenBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.PeopleDetailRespBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.WeiboDialogUtils;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.leefeng.promptlibrary.PromptButton;
import me.leefeng.promptlibrary.PromptButtonListener;
import me.leefeng.promptlibrary.PromptDialog;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/23.
 * 添加 交接班
 */

public class AddChangeWorkActivity extends BaseActivity implements View.OnClickListener, SuperTextView.OnSuperTextViewClickListener {
    AddShitWorkBean addShitWorkBean;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.carry_user)
    OrderConbindView carryUser;
    @BindView(R.id.turn_user)
    OrderConbindView turnUser;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.turn_user_rl)
    RelativeLayout turnUserRl;
    @BindView(R.id.com_edit_content)
    TextView comEditContent;
    @BindView(R.id.shit_address_content)
    TextView shitAddressContent;
    @BindView(R.id.shit_car_no)
    TextView shitCarNo;
    @BindView(R.id.shit_info)
    LinearLayout shitInfo;
    @BindView(R.id.remain_car_oil)
    TextView remainCarOil;
    @BindView(R.id.car_mile)
    EditText carMile;
    @BindView(R.id.shit_car_remain)
    EditText shitCarRemain;
    @BindView(R.id.car_info)
    LinearLayout carInfo;
    @BindView(R.id.shift_remark_info)
    EditText shiftRemarkInfo;
    @BindView(R.id.shift_remark_info_cv)
    RelativeLayout shiftRemarkInfoCv;
    @BindView(R.id.submit_cancle)
    Button submitCancle;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.bottom_ll_sub_oil)
    LinearLayout bottomLlSubOil;
    @BindView(R.id.choose_car)
    LinearLayout chooseCar;
    @BindView(R.id.jiaojie_type)
    SuperTextView jiaojieType;
    @BindView(R.id.adddress_ll)
    LinearLayout adddressLl;

    String carNum;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    String workState;

    @Override
    public void initContentView() {
        setContentView(R.layout.add_change_work_activity);
    }

    @Override
    public void initView() {

        addShitWorkBean = new AddShitWorkBean();
//        intent.putExtra("workState", "on");

        Intent intent = getIntent();
        workState = intent.getStringExtra("workState");


        carryUser.setTitle("交班人");
        carryUser.setContet(GetUserInfoUtils.getUserInfo().getUserName());
        turnUser.setTitle("接班人");
        turnUser.setContet("请选择接班人");

//        turnUser.setOnClickListener(this);


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();


        if (TextUtils.isEmpty(workState)) {

//            shitCarNo.setText(userInfo.getCarNum());
            shitCarNo.setText(SPUtils.getSaveCar());
            addShitWorkBean.setCarId(userInfo.getCarId());
            jiaojieType.setOnSuperTextViewClickListener(this);

            findPeopleDetail();

        }


        String currentTime = UIUtils.getCurrentTime();
        comEditContent.setText(currentTime);
        addShitWorkBean.setShiftTime(currentTime);
        initLocation();
        startLocation();

//        去获取 油量展示

        if (!TextUtils.isEmpty(userInfo.getCarNum())) {
//            getCarInfoByCarNum(userInfo.getCarNum());
            getCarInfoByCarNum(userInfo.getCarNum());
        }


    }

    private void findPeopleDetail() {
        showLoadingDialog("用户信息更新中...");
        UserIdReqBean userIdReqBean = new UserIdReqBean();
        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
        HttpManger.getHttpMangerInstance().getServices().findPeopleDetail(requestBody).enqueue(new Callback<PeopleDetailRespBean>() {
            @Override
            public void onResponse(Call<PeopleDetailRespBean> call, Response<PeopleDetailRespBean> response) {
                disDialog();

                PeopleDetailRespBean body = response.body();

                if (body != null) {

                    PeopleDetailRespBean.BringBean bring = body.getBring();

                    if (bring != null) {
//                        joinStatus.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));
//                        joinType.setRightString(GetOrderStateUtil.getJoinStatus(bring.getJoinStatus()));
//                        jiaojieType.setRightString(GetOrderStateUtil.getJoinStatus(bring.getJoinType()));
                        jiaojieType.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));

//                        addShitWorkBean.setJoinType(bring.getJoinStatus());
                        addShitWorkBean.setJoinType(bring.getJoinType());

                        SPUtils.setSaveCar(bring.getCarNum());

                    }

                }

            }

            @Override
            public void onFailure(Call<PeopleDetailRespBean> call, Throwable t) {
                disDialog();
                showWarnTip("连接超时");
            }
        });


    }


    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (!TextUtils.isEmpty(workState)) {


            if (workState.equals("on")) {
                topBarTitleTv.setText("上班");

                carryUser.setVisibility(View.GONE);
                turnUserRl.setVisibility(View.GONE);

                addShitWorkBean.setTurnUserId(GetUserInfoUtils.getUserInfo().getUserId());
                jiaojieType.setOnSuperTextViewClickListener(this);
            }
            if (workState.equals("off")) {
                topBarTitleTv.setText("下班");

                carryUser.setVisibility(View.GONE);
                turnUserRl.setVisibility(View.GONE);

                addShitWorkBean.setTurnUserId("");
                addShitWorkBean.setCarryUserId(GetUserInfoUtils.getUserInfo().getUserId());

//                String carNum = SPUtils.getContent(Constant.CAR_NUM);
//                String carNum = SPUtils.getContent(Constant.CAR_NUM);

                String carNum = SPUtils.getSaveCar();


                shitCarNo.setText(carNum);
                addShitWorkBean.setCarId(userInfo.getCarId());
                jiaojieType.setRightIcon(null);

//                jiaojieType.setOnSuperTextViewClickListener(this);
                findPeopleDetail();
            }

//            findPeopleDetail();


        }


    }

    //    R.id.com_edit_content,
    @OnClick({R.id.top_bar_finish_ll, R.id.turn_user, R.id.submit_now, R.id.choose_car})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_bar_finish_ll:
                finish();
                break;
            case R.id.choose_car:

                LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

//                if (userInfo != null) {
//                    carNum = userInfo.getCarNum();
//
//                }
//
//                if (!TextUtils.isEmpty(carNum)) {
//                    return;
//                }

                if (!TextUtils.isEmpty(workState)) {
                    if (workState.equals("off")) {

//                        carNum = userInfo.getCarNum();
                        carNum = SPUtils.getSaveCar();

                        if (!TextUtils.isEmpty(carNum)) {
                            return;
                        }

//                    return;
                    }
                }


                getCarListFronServer();


                break;
            case R.id.turn_user:

//                选择人

                Intent intent = new Intent(UIUtils.getContext(), ChooseShitPersonActivity.class);

                startActivityForResult(intent, 1);

////                startActivityForResult();
//
//                startActivity(new Intent(UIUtils.getContext(),ChooseShitPersonActivity.class));

                break;
//            case R.id.com_edit_content:
////                选择人
////                Toast.makeText(this, "选择时间", Toast.LENGTH_SHORT).show();
//
//            {
//                DialogUtils.showDatePick(AddChangeWorkActivity.this, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
//                    @Override
//                    public void onSaveSelectedDate(int tag, String selectedDate) {
//                        addShitWorkBean.setShiftTime(selectedDate);
//                        comEditContent.setText(selectedDate);
//                    }
//                }).show();
//            }
//
//
//            break;
            case R.id.submit_now:
//                选择人
//                Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();

                subMitShitInfo();

                break;


        }

    }

    private void getCarListFronServer() {


        Intent intent = new Intent(AddChangeWorkActivity.this, JiaoJieBanCarListActivity.class);

        startActivityForResult(intent, 103);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 2) {

            final String shiftUser = data.getStringExtra("shiftUser");
            final String shiftUserId = data.getStringExtra("shiftUserId");

            if (shiftUser == null) {
//                Toasty.error(AddChangeWorkActivity.this, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                return;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    turnUser.setContet(shiftUser);
                    addShitWorkBean.setTurnUserId(shiftUserId);

                }
            });


        }

        if (requestCode == 103 && resultCode == 104) {

            final String carNum = data.getStringExtra("carNum");
//            intent.putExtra("carId", getItem(position).getId());
            final String carId = data.getStringExtra("carId");


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    shitCarNo.setText(carNum);
                    addShitWorkBean.setCarId(carId);
//                    addShitWorkBean.setca

                }
            });

// 去获取 油量

            getCarInfoByCarNum(carNum);

        }


    }

    private void getCarInfoByCarNum(String carNum) {

        carInfoNum carInfoNum = new carInfoNum();
        carInfoNum.setCode(carNum);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carInfoNum);
//        HttpManger.getHttpMangerInstance().getServices().findCarinfoByCode(requestBody).enqueue(new Callback<CarInfoRespBean>() {
        HttpManger.getHttpMangerInstance().getServices().findCarStateByCode(requestBody).enqueue(new Callback<CarStateRespBean>() {
            @Override
            public void onResponse(Call<CarStateRespBean> call, Response<CarStateRespBean> response) {

                CarStateRespBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();
                    if (res) {
                        CarStateRespBean.BringBean bring = body.getBring();

                        if (bring != null) {

                            String leaveOil = bring.getLeaveOilForT();
                            remainCarOil.setText(leaveOil);
//                            setRemain

                            addShitWorkBean.setRemainTankOil(leaveOil);
                        }


                    } else {

                        String message = body.getMessage();

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(AddChangeWorkActivity.this, "获取油量信息失败", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(AddChangeWorkActivity.this, message, Toast.LENGTH_SHORT).show();
                        }


                    }


                }


            }

            @Override
            public void onFailure(Call<CarStateRespBean> call, Throwable t) {
                Toast.makeText(AddChangeWorkActivity.this, "连接超时,获取油量失败", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void subMitShitInfo() {

//        openType	String	Y	openType=”add” 新增地址
//        openType=”update” 修改地址
//        id	String	N	记录Id,
//        若openType=”add”，可不填
//        userId	String	Y	用户Id
//        carCode	String	Y	车牌号
//        carryUserId	String	Y	交班人userId
//        turnUserId	String	Y	接班人userId
//        carsMileage	String	Y	车辆里程数
//        remainCarOil	String	Y	车辆剩余油量
//        remainTankOil	String	Y	油罐剩余油量
//        shiftTime	String	Y	交接时间
//        shiftAddress	String	Y	交接地点
//        remark	String	Y	备注


//        String shitCarNoStr = shitCarNo.getText().toString().trim();
//
//        if (TextUtils.isEmpty(shitCarNoStr)){
//            Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
//        return;
//        }else{
//            addShitWorkBean.set Chepaihao
//        }


        if (TextUtils.isEmpty(workState)) {

            String turnUserId = addShitWorkBean.getTurnUserId();

            if (TextUtils.isEmpty(turnUserId)) {
                Toast.makeText(this, "请选择接班人", Toast.LENGTH_SHORT).show();
                return;
            }

        }


        String shitCarNoStr = shitCarNo.getText().toString().trim();

//        addShitWorkBean.setCarCode(userInfo.getCarNum());

        if (TextUtils.isEmpty(shitCarNoStr)) {
            Toast.makeText(this, "请选择车牌号", Toast.LENGTH_SHORT).show();
            return;
        }

        String joinType = addShitWorkBean.getJoinType();

        if (TextUtils.isEmpty(joinType)) {
            Toast.makeText(this, "请选择交接类型", Toast.LENGTH_SHORT).show();
            return;
        }

        addShitWorkBean.setCarCode(shitCarNoStr);
        if (TextUtils.isEmpty(addShitWorkBean.getShiftTime())) {
            Toast.makeText(this, "请选择时间", Toast.LENGTH_SHORT).show();
            return;
        }

//        String remainCarOilStr = remainCarOil.getText().toString().trim();
//
////        if (TextUtils.isEmpty(remainCarOilStr)) {
////            Toast.makeText(this, "请输入剩余油量", Toast.LENGTH_SHORT).show();
////            return;
////        } else {
////            addShitWorkBean.setRemainCarOil(remainCarOilStr);
////        }
//        addShitWorkBean.setRemainCarOil(remainCarOilStr);
        String carMileStr = carMile.getText().toString().trim();

        if (TextUtils.isEmpty(carMileStr)) {
            Toast.makeText(this, "请输入车辆里程", Toast.LENGTH_SHORT).show();
            return;
        }
        addShitWorkBean.setCarsMileage(carMileStr);

//        String remianOilAmount = shitCarRemain.getText().toString().trim();

//        if (TextUtils.isEmpty(remianOilAmount)) {
//            Toast.makeText(this, "请输入剩余油量", Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            addShitWorkBean.setRemainTankOil(remianOilAmount);
//        }

        String remark = shiftRemarkInfo.getText().toString().trim();
        if (TextUtils.isEmpty(remark)) {
            addShitWorkBean.setRemark("");
        }
        addShitWorkBean.setRemark(remark);


        addShitWorkBean.setOpenType("add");
        addShitWorkBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        addShitWorkBean.setCarryUserId(GetUserInfoUtils.getUserInfo().getUserId());
//        addShitWorkBean.setCarId(GetUserInfoUtils.getUserInfo().getCarId());


        Log.i(TAG, "subMitShitInfo: " + addShitWorkBean.toString());

//        WeiboDialogUtils dialogUtils=WeiboDialogUtils.createLoadingDialog(AddChangeWorkActivity.this,"提交中...")
        showLoadingDialog("提交中...");
        RequestBody body = HttpManger.getHttpMangerInstance().getRequestBody(addShitWorkBean);
        HttpManger.getHttpMangerInstance().getServices().insertOilShiftDuty(body).enqueue(new Callback<AddShitWorkRespBean>() {
            @Override
            public void onResponse(Call<AddShitWorkRespBean> call, Response<AddShitWorkRespBean> response) {

                AddShitWorkRespBean body = response.body();
                disDialog();

                if (body != null) {

//                    if (body.getBring() != null) {
//
//                    } else {
//                        showDialogTip("添加出现异常", 0);
//                    }

                    boolean res = body.isRes();

                    String message = body.getMessage();
                    AddShitWorkRespBean.BringBean bring = body.getBring();
                    if (res) {

                        showDialogTip(message, 1);

                        String carryStatus = bring.getCarryStatus();
                        if (!TextUtils.isEmpty(carryStatus)) {
                            SPUtils.saveContent(Constant.WORK_STATE, bring.getCarryStatus());
                        }
                        findPeopleDetail();
                    } else {
                        showDialogTip(message, 0);
                    }


                }


            }

            @Override
            public void onFailure(Call<AddShitWorkRespBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
                disDialog();
                Toast.makeText(AddChangeWorkActivity.this, "连接超时", Toast.LENGTH_SHORT).show();

//                showDialogTip("添加出现异常", 0);
            }
        });

    }

    public void showDialogTip(String mag, final int i) {


        DialogUtils.showAlert(AddChangeWorkActivity.this, "提示", mag, "", "", "我知道了", "", true, new DialogUIListener() {
            @Override
            public void onPositive() {
//                showToast("onPositive");
                if (i == 1) {


                    if (workState.equals("off")) {
                        askToCreateIndex();
                    } else {
                        finish();
                    }


                }

            }

            @Override
            public void onNegative() {
//                showToast("onNegative");
                finish();
            }

        }).show();


    }


    /**
     * 创建日清日结
     */
    private PromptDialog promptExitDialog;

    private void askToCreateIndex() {

        if (promptExitDialog == null) {
            //创建对象
            promptExitDialog = new PromptDialog(this);
            //设置自定义属性
            promptExitDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);
        }

        //按钮的定义，创建一个按钮的对象
        PromptButton confirm = new PromptButton("确定", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {

                createAndgetdailyIndex();
            }
        });
        confirm.setTextColor(Color.parseColor("#DAA520"));
        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件

        PromptButton cancleBtn = new PromptButton("取消", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
//                Toast.makeText(BaseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        promptExitDialog.showWarnAlert("创建日清日结结算记录", confirm, cancleBtn);


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

                                showShortToast("创建成功");
                            } else {

                                showShortToast(message);
                            }

                            finish();
                        } else {

                            balanceId = bring;

                            DailyBalanceDetailActivity.detailStart(AddChangeWorkActivity.this, bring);
                            finish();
                        }

                    } else {

                        if (TextUtils.isEmpty(message)) {

                            showShortToast("创建失败");
                        } else {

                            showShortToast(message);
                        }
                        finish();
                    }
                } else {
                    showShortToast("创建结算记录失败");
                    finish();
                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                showFailTip();
                LogUtils.i(t.getMessage());
            }
        });

    }


    /**
     * 初始化定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void initLocation() {
        //初始化client
        locationClient = new AMapLocationClient(AddChangeWorkActivity.this);
        locationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
    }

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            if (null != location) {

//                StringBuffer sb = new StringBuffer();
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {


                    shitAddressContent.setText(location.getAddress());


                    addShitWorkBean.setShiftAddress(location.getAddress());

//                    getCodeByProvinceName(provinceName);

                    stopLocation();
//                    sb.append("定位成功" + "\n");
//                    sb.append("定位类型: " + location.getLocationType() + "\n");
//                    sb.append("经    度    : " + location.getLongitude() + "\n");
//                    sb.append("纬    度    : " + location.getLatitude() + "\n");
//                    sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
//                    sb.append("提供者    : " + location.getProvider() + "\n");
//
//                    sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
//                    sb.append("角    度    : " + location.getBearing() + "\n");
//                    // 获取当前提供定位服务的卫星个数
//                    sb.append("星    数    : " + location.getSatellites() + "\n");
//                    sb.append("国    家    : " + location.getCountry() + "\n");
//                    sb.append("省            : " + location.getProvince() + "\n");
//                    sb.append("市            : " + location.getCity() + "\n");
//                    sb.append("城市编码 : " + location.getCityCode() + "\n");
//                    sb.append("区            : " + location.getDistrict() + "\n");
//                    sb.append("区域 码   : " + location.getAdCode() + "\n");
//                    sb.append("地    址    : " + location.getAddress() + "\n");
//                    sb.append("兴趣点    : " + location.getPoiName() + "\n");
//                    //定位完成的时间
//                    sb.append("定位时间: " + Utils.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                } else {
                    //定位失败
//                    sb.append("定位失败" + "\n");
//                    sb.append("错误码:" + location.getErrorCode() + "\n");
//                    sb.append("错误信息:" + location.getErrorInfo() + "\n");
//                    sb.append("错误描述:" + location.getLocationDetail() + "\n");

                    shitAddressContent.setText("定位失败");
                    shitAddressContent.setTextColor(Color.RED);

                }
//                sb.append("***定位质量报告***").append("\n");
//                sb.append("* WIFI开关：").append(location.getLocationQualityReport().isWifiAble() ? "开启":"关闭").append("\n");
//                sb.append("* GPS状态：").append(getGPSStatusString(location.getLocationQualityReport().getGPSStatus())).append("\n");
//                sb.append("* GPS星数：").append(location.getLocationQualityReport().getGPSSatellites()).append("\n");
//                sb.append("****************").append("\n");
//                //定位之后的回调时间
//                sb.append("回调时间: " + Utils.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");
//
//                //解析定位结果，
//                String result = sb.toString();
//                tvResult.setText(result);
            } else {
//                tvResult.setText("定位失败，loc is null");
                shitAddressContent.setText("定位失败");
                shitAddressContent.setTextColor(Color.RED);
            }
        }
    };


    /**
     * 开始定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void startLocation() {
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    /**
     * 停止定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void stopLocation() {
        // 停止定位
        Log.i(TAG, "stopLocation: =============停止定位=================");
        locationClient.stopLocation();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }


    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }


    @Override
    public void onClickListener(SuperTextView superTextView) {

        List<DicChildrenBean> jiaoJieTypeList = createJiaoJieType();
        showPopItems(jiaoJieTypeList, superTextView);

    }

    private List<DicChildrenBean> createJiaoJieType() {

        List<DicChildrenBean> datas = new ArrayList<>();
        DicChildrenBean dicChildrenBean = new DicChildrenBean();
        dicChildrenBean.setDictValue("0");
        dicChildrenBean.setDictName("押运员");
        datas.add(dicChildrenBean);

        DicChildrenBean sijiChildrenBean = new DicChildrenBean();
        sijiChildrenBean.setDictValue("1");
        sijiChildrenBean.setDictName("司机");
        datas.add(sijiChildrenBean);
        return datas;
    }


    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;

    private void showPopItems(List<DicChildrenBean> datas, final View parenr) {
        if (datas == null && datas.size() == 0) {
            return;
        }

//        if (canSuperTextViewClick) {
//            return;
//        }

        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {

            layoutLeft = UIUtils.inflate(R.layout.pop_menulist);
            menulistLeft = (ListView) layoutLeft.findViewById(R.id.menulist);

            final ListDropDownAdapter adapter = new ListDropDownAdapter(AddChangeWorkActivity.this, datas);
            menulistLeft.setAdapter(adapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(AddQianZaiKeHuActivity.this, "选择的是" + adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();

                    String chooseStr = adapter.getItem(position).getDictName();
                    String chooseCode = adapter.getItem(position).getDictValue();

                    jiaojieType.setRightString(chooseStr);
                    addShitWorkBean.setJoinType(chooseCode);
//                    addShitWorkBean.setJoinStatus(chooseCode);


                    Log.i(TAG, "onItemClick: " + new Gson().toJson(adapter.getItem(position)));

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
                    2);
//            (topBarHeight - parenr.getHeight()) / 2
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


    class carInfoNum {


        /**
         * code : 川A34995
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
