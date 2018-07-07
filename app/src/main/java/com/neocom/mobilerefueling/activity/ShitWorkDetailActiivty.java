package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.JiaoJieSubmitBean;
import com.neocom.mobilerefueling.bean.PeopleDetailRespBean;
import com.neocom.mobilerefueling.bean.ShiftWorkDetailBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/27.
 * <p>
 * 交接班 详情
 */

public class ShitWorkDetailActiivty extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
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
    @BindView(R.id.com_edit_title)
    TextView comEditTitle;
    @BindView(R.id.com_edit_content)
    TextView comEditContent;
    @BindView(R.id.choose_time)
    RelativeLayout chooseTime;
    @BindView(R.id.shit_address_titile)
    TextView shitAddressTitile;
    @BindView(R.id.shit_address_content)
    TextView shitAddressContent;
    @BindView(R.id.shit_car_no_titile)
    TextView shitCarNoTitile;
    @BindView(R.id.remain_car_oil_titile)
    TextView remainCarOilTitile;
    @BindView(R.id.remain_car_oil)
    TextView remainCarOil;
    @BindView(R.id.car_mile_titile)
    TextView carMileTitile;
    @BindView(R.id.car_mile)
    TextView carMile;
    @BindView(R.id.shit_car_address_titile)
    TextView shitCarAddressTitile;
    @BindView(R.id.shit_car_address)
    TextView shitCarAddress;
    @BindView(R.id.shift_remark_info)
    TextView shiftRemarkInfo;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.bottom_ll_sub_oil)
    LinearLayout bottomLlSubOil;
    @BindView(R.id.shit_car_no)
    TextView shitCarNo;

    @BindView(R.id.unsubmit_now)
    Button unsubmitNow;
    @BindView(R.id.jieban_time)
    SuperTextView jiebanTime;
    @BindView(R.id.queren_status)
    SuperTextView querenStatus;
    @BindView(R.id.queren_person)
    SuperTextView querenPerson;
    @BindView(R.id.join_type)
    SuperTextView joinType;
    @BindView(R.id.join_status)
    SuperTextView joinStatus;

    private String shiftId;
    private String show;

    @Override
    public void initContentView() {
        setContentView(R.layout.shit_wor_lzyout);
    }

    @Override
    public void initView() {
        Intent intent = getIntent();

        shiftId = intent.getStringExtra("shiftId");
        show = intent.getStringExtra("show");

        if ("3".equals(show)) {
            submitNow.setVisibility(View.GONE);
            unsubmitNow.setVisibility(View.GONE);
        } else {
            submitNow.setVisibility(View.VISIBLE);
            unsubmitNow.setVisibility(View.VISIBLE);
        }


        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        carryUser.setTitle("交班人");

        turnUser.setTitle("接班人");

        submitNow.setOnClickListener(clickListener);
        unsubmitNow.setOnClickListener(clickListener);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

        getDataFronServer();
        findPeopleDetail();
    }


    private void findPeopleDetail() {

        UserIdReqBean userIdReqBean = new UserIdReqBean();
        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
        HttpManger.getHttpMangerInstance().getServices().findPeopleDetail(requestBody).enqueue(new Callback<PeopleDetailRespBean>() {
            @Override
            public void onResponse(Call<PeopleDetailRespBean> call, Response<PeopleDetailRespBean> response) {

                PeopleDetailRespBean body = response.body();

                if (body != null) {

                    PeopleDetailRespBean.BringBean bring = body.getBring();

                    if (bring != null) {


//                        joinStatus.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));
//                        joinType.setRightString(GetOrderStateUtil.getJoinStatus(bring.getJoinType()));

                        joinType.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));


                        joinStatus.setRightString(GetOrderStateUtil.getJoinStatus(bring.getUserStatus()));


//                        userStatus 上班0  或者是 下班 1

                        String userStatus = bring.getUserStatus();


                        if (TextUtils.isEmpty(userStatus)) {

                            SPUtils.saveContent(Constant.WORK_STATE, "");

                        } else {

                            SPUtils.saveContent(Constant.WORK_STATE, userStatus);
                        }

//                        SPUtils.saveContent(Constant.WORK_STATE, bring.getCarryStatus());

                        SPUtils.setSaveCar(bring.getCarNum());

//                        String carNum = bring.getCarNum();
//                        if (TextUtils.isEmpty(carNum)) {
//
//                            SPUtils.saveContent(Constant.CAR_NUM, "");
//
//                        } else {
//
//                            SPUtils.saveContent(Constant.CAR_NUM, carNum);
//                        }

//                        Toast.makeText(ShitWorkDetailActiivty.this, "车牌号："+carNum+";状态;"+userStatus, Toast.LENGTH_SHORT).show();

                    }

                }


            }

            @Override
            public void onFailure(Call<PeopleDetailRespBean> call, Throwable t) {

                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }


    private void getDataFronServer() {
        showLoadingDialog("加载中...");
        ShiftId sId = new ShiftId();
        sId.setId(shiftId);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(sId);
        HttpManger.getHttpMangerInstance().getServices().findOilShiftById(requestBody).enqueue(new Callback<ShiftWorkDetailBean>() {
            @Override
            public void onResponse(Call<ShiftWorkDetailBean> call, Response<ShiftWorkDetailBean> response) {

//                ShiftWorkDetailBean.BringBean bring = response.body().getBring();
                disDialog();
                ShiftWorkDetailBean body = response.body();

                if (body != null) {
                    ShiftWorkDetailBean.BringBean bring = body.getBring();
                    if (bring != null) {
                        parseBringBean(bring);
                    }

                }

            }

            @Override
            public void onFailure(Call<ShiftWorkDetailBean> call, Throwable t) {
                disDialog();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void parseBringBean(ShiftWorkDetailBean.BringBean bring) {

        carryUser.setContet(bring.getCarryUser());

        turnUser.setContet(bring.getTurnUser());

        comEditContent.setText(bring.getShiftTime());

        shitAddressContent.setText(bring.getShiftAddress());

        shitCarNo.setText(bring.getCarNum());

        remainCarOil.setText(bring.getRemainCarOil());

        carMile.setText(bring.getCarsMileage());

        shitCarAddress.setText(bring.getRemainTankOil());
        shiftRemarkInfo.setText(bring.getRemark());

        String confirmStatus = bring.getConfirmStatus();

        if (confirmStatus.equals("0")) {
            bottomLlSubOil.setVisibility(View.VISIBLE);
        } else {
            bottomLlSubOil.setVisibility(View.GONE);
        }


//        @BindView(R.id.jieban_time)
//        SuperTextView jiebanTime;
//        @BindView(R.id.queren_status)
//        SuperTextView querenStatus;
//        @BindView(R.id.queren_person)
//        SuperTextView querenPerson;

        jiebanTime.setRightString(bring.getConfirmTime());
        querenStatus.setRightString(GetOrderStateUtil.getconfirmStatus(bring.getConfirmStatus()));
        querenPerson.setRightString(GetUserInfoUtils.getUserInfo().getUserName());

//        11
//        joinStatus.setRightString(GetOrderStateUtil.getJoinTypeState(bring.getJoinType()));
//        joinType.setRightString(GetOrderStateUtil.getJoinStatus(bring.getJoinStatus()));

//        getconfirmStatus


    }


    public class ShiftId {

        private String id;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "shiftId{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.submit_now:

                    //审核通过
                    sunmitInfo("1");

                    break;
                case R.id.unsubmit_now:
//审核不通过
                    sunmitInfo("0");
                    break;


            }
        }
    };

    private void sunmitInfo(String flag) {

        JiaoJieSubmitBean jiaoJieSubmitBean = new JiaoJieSubmitBean();
        jiaoJieSubmitBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        jiaoJieSubmitBean.setShiftId(shiftId);
        jiaoJieSubmitBean.setFlag(flag);

        showLoadingDialog("提交中...");
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(jiaoJieSubmitBean);
        HttpManger.getHttpMangerInstance().getServices().updateShiftStatus(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();

                EmptyBringGetOilBean body = response.body();
                if (body != null) {

                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {


                        if (TextUtils.isEmpty(message)) {
                            showDialog("更新成功");

                            findPeopleDetail();

                        } else {
                            showDialog(message);
                            findPeopleDetail();
                        }


                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showDialog("更新失败");

                            findPeopleDetail();

                        } else {
                            showDialog(message);
                            findPeopleDetail();
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                Toast.makeText(ShitWorkDetailActiivty.this, "连接超时", Toast.LENGTH_SHORT).show();
//                            showDialog("更新");
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }


    public class OneId {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "OneId{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }


    public void showDialog(String msg) {

        DialogUtils.showAlert(ShitWorkDetailActiivty.this, "提示", msg, "", "", "我知道了", "", true, new DialogUIListener() {
            @Override
            public void onPositive() {
//                showToast("onPositive");
                finish();
            }

            @Override
            public void onNegative() {
//                showToast("onNegative");
            }

        }).show();


    }


}
