package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.ListSettingBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.ModifyRecordSupply;
import com.neocom.mobilerefueling.bean.SupplyDetailRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/8.
 */

public class YunYouDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.supply_code)
    OrderConbindView supplyCode;
    @BindView(R.id.supply_car_code)
    OrderConbindView supplyCarCode;
    @BindView(R.id.supply_car_driver)
    OrderConbindView supplyCarDriver;
    @BindView(R.id.supply_car_telphone)
    OrderConbindView supplyCarTelphone;
    @BindView(R.id.move_car_code)
    OrderConbindView moveCarCode;
    @BindView(R.id.move_car_driver)
    OrderConbindView moveCarDriver;
    @BindView(R.id.move_car_telphone)
    OrderConbindView moveCarTelphone;
//    @BindView(R.id.surplus_oil)
//    OrderConbindView surplusOil;
    @BindView(R.id.supply_num)
    OrderConbindView supplyNum;
    @BindView(R.id.supply_time)
    OrderConbindView supplyTime;
    @BindView(R.id.supply_address)
    OrderConbindView supplyAddress;
    @BindView(R.id.batch_id)
    OrderConbindView batchId;
    @BindView(R.id.file_old_name)
    OrderConbindView fileOldName;
    @BindView(R.id.record_status)
    OrderConbindView recordStatus;
    @BindView(R.id.confirm_people)
    OrderConbindView confirmPeople;
    @BindView(R.id.confirm_time)
    OrderConbindView confirmTime;
    @BindView(R.id.c_dt)
    OrderConbindView cDt;
    @BindView(R.id.create_name)
    OrderConbindView createName;
    @BindView(R.id.u_dt)
    OrderConbindView uDt;
    @BindView(R.id.modify_name)
    OrderConbindView modifyName;
    @BindView(R.id.remark_ifm)
    OrderConbindView remarkIfm;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLl;
    @BindView(R.id.pay_cancle)
    Button payCancle;
    @BindView(R.id.pay_now)
    Button payNow;


    private String itemId;
    private String itemStatus;
    private String WEI_QUE_REN = "0";

    private  boolean booleanExtra=false;

    @Override
    public void initContentView() {
        setContentView(R.layout.yun_you_detail_layout);
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        itemId = intent.getStringExtra("itemId");
        itemStatus = intent.getStringExtra("itemStatus");

         booleanExtra = intent.getBooleanExtra(Constant.showSureBtn, false);


        Log.i(TAG, "跳转onItemClick: " + itemId + ";" + itemStatus);
//        if (WEI_QUE_REN.equals(itemStatus)) {
//            bottomLl.setVisibility(View.VISIBLE);
//        }

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        payCancle.setOnClickListener(this);
        payNow.setOnClickListener(this);
        batchId.setOnClickListener(this);
        fileOldName.setOnClickListener(this);
        initTitle();

    }

    private void initTitle() {


        supplyCode.setTitle("补给记录编号");
        supplyCarCode.setTitle("补给车车牌号");
        supplyCarDriver.setTitle("补给车司机");
        supplyCarTelphone.setTitle("补给车司机电话");
        moveCarCode.setTitle("加油车车牌号");
        moveCarDriver.setTitle("加油车司机");
        moveCarTelphone.setTitle("加油车司机电话");
//        surplusOil.setTitle("剩余油量");
        supplyNum.setTitle("补给油量");
        supplyTime.setTitle("补给时间");
        supplyAddress.setTitle("补给地点");
        batchId.setTitle("油品批次");
        fileOldName.setTitle("质检报告");
        recordStatus.setTitle("确认状态");
        confirmPeople.setTitle("确认人");
        confirmTime.setTitle("确认时间");
        cDt.setTitle("新增时间");
        createName.setTitle("新增人姓名");
        uDt.setTitle("最后修改时间");
        modifyName.setTitle("最后修改人");
        remarkIfm.setTitle("备注");

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (TextUtils.isEmpty(itemId)) {
            Toast.makeText(this, "获取数据异常,请重试", Toast.LENGTH_SHORT).show();
            finish();
        }

        getDataFromServer();
    }

    private void getDataFromServer() {
        RequestID requestID = new RequestID();
        requestID.setId(itemId);

        String unit = Constant.DANWEI_T;

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();

        if (listSetting != null) {

            String item_quality = listSetting.getItem_quality();

            if (!TextUtils.isEmpty(item_quality)) {
                unit=item_quality;
            }
        }

        requestID.setUnit(unit);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(requestID);
        HttpManger.getHttpMangerInstance().getServices().supplyDetail(requestBody).enqueue(new Callback<SupplyDetailRespBean>() {
            @Override
            public void onResponse(Call<SupplyDetailRespBean> call, Response<SupplyDetailRespBean> response) {

                SupplyDetailRespBean body = response.body();

                if (body != null) {
                    SupplyDetailRespBean.BringBean bring = body.getBring();
                    if (bring != null) {
                        parseBring(bring);

                    }

                }

            }

            @Override
            public void onFailure(Call<SupplyDetailRespBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage().toString());
            }
        });
    }

    SupplyDetailRespBean.BringBean bringCommit;
    String batchIdStr;
    private String DANWEI = "吨";

    private void parseBring(SupplyDetailRespBean.BringBean bring) {
        this.bringCommit = bring;

        String recordStatus = bring.getRecordStatus();

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo != null) {

//            String carType = userInfo.getCarType();
//
//            if (TextUtils.isEmpty(carType)){
//                bottomLl.setVisibility(View.GONE);
//            }else {
//
//                if ((WEI_QUE_REN.equals(recordStatus))&&(carType.equals("1"))) {
//                    bottomLl.setVisibility(View.VISIBLE);
//                }
//
//            }

            String roleCode = userInfo.getRoleCode();

//            if (roleCode.contains(Constant.ROLE_BUJU) && WEI_QUE_REN.equals(recordStatus)) {
//                bottomLl.setVisibility(View.VISIBLE);
////                 if (WEI_QUE_REN.equals(recordStatus)) {
////                     bottomLl.setVisibility(View.VISIBLE);
////                 } else {
////                     bottomLl.setVisibility(View.GONE);
////                 }
//            } else {
//                bottomLl.setVisibility(View.GONE);
//            }


            LogUtils.i("---状态--"+booleanExtra+"---"+recordStatus);

            if (booleanExtra&&recordStatus.equals(WEI_QUE_REN)){

                bottomLl.setVisibility(View.VISIBLE);

            }else {
                bottomLl.setVisibility(View.GONE);
            }

        }

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
        if (listSetting != null) {

            String item_quality = listSetting.getItem_quality();

            if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_T)) {

                DANWEI = "吨";

            } else {
                DANWEI = "千克";
            }

        }

        supplyCode.setContet(bring.getSupplyCode());
        supplyCarCode.setContet(bring.getSupplyCarCode());
        supplyCarDriver.setContet(bring.getSupplyCarDriver());
        supplyCarTelphone.setContet(bring.getSupplyCarTelphone());
        moveCarCode.setContet(bring.getMoveCarCode());
        moveCarDriver.setContet(bring.getMoveCarDriver());
        moveCarTelphone.setContet(bring.getMoveCarTelphone());
//        surplusOil.setContet(bring.getSurplusOil() + DANWEI);
//        supplyNum.setContet(bring.getSupplyNum() + DANWEI);
        supplyNum.setContet(bring.getSupplyNum() );
        supplyTime.setContet(bring.getSupplyTime());
        supplyAddress.setContet(bring.getSupplyAddress());

        batchIdStr = bring.getBatchId();
        batchId.setContet(batchIdStr);
        fileOldName.setContet(bring.getFileName());
        this.recordStatus.setContet(GetOrderStateUtil.getSendType(bring.getRecordStatus()));
        confirmPeople.setContet(bring.getConfirmPeople());
        confirmTime.setContet(bring.getConfirmTime());
        cDt.setContet(bring.getC_dt());
        createName.setContet(bring.getCreateName());
        uDt.setContet(bring.getU_dt());
        modifyName.setContet(bring.getModifyName());
        remarkIfm.setContet(bring.getRemarks());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.pay_cancle:
                comfirmTiYouDan("1");// 不通过
                break;
            case R.id.pay_now:
                comfirmTiYouDan("2");// 通过
                break;
            case R.id.file_old_name:


                // 查看质检报告
//                Toast.makeText(this, "请稍后再试...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.batch_id:// 查看批次详情

                if (batchIdStr == null) {
                    Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(YunYouDetailActivity.this, GetOilPiCiDetailActivity.class);
                intent.putExtra("batchNum", batchIdStr);
                startActivity(intent);


                break;


        }


    }

    // 1 不通过 2 通过
    public void comfirmTiYouDan(String status) {

        if (bringCommit == null) {
            Toast.makeText(this, "请等待加载完成", Toast.LENGTH_SHORT).show();
            return;
        }


        ModifyRecordSupply modifyRecordSupply = new ModifyRecordSupply();
        modifyRecordSupply.setId(itemId);
        modifyRecordSupply.setRecordStatus(status);
//        modifyRecordSupply.setConfirmPeople(bringCommit.getConfirmPeople());
        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo != null) {
            modifyRecordSupply.setConfirmPeople(userInfo.getUserId());
        }

        modifyRecordSupply.setConfirmTime(bringCommit.getConfirmTime());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(modifyRecordSupply);
        HttpManger.getHttpMangerInstance().getServices().modifyRecordSupply(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
//                Log.i(TAG, "onResponse: "+response.body().toString());

//                boolean res = response.body().isRes();

                EmptyBringGetOilBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();
                    if (res) {

                        String message = body.getMessage();
                        if (TextUtils.isEmpty(message)) {
                            Toasty.info(YunYouDetailActivity.this, "保存成功", Toast.LENGTH_SHORT, true).show();
                        } else {
                            Toasty.info(YunYouDetailActivity.this, message, Toast.LENGTH_SHORT, true).show();
                        }

                        finish();
                    } else {
                        Toasty.info(YunYouDetailActivity.this, "保存失败", Toast.LENGTH_SHORT, true).show();
                    }

                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(YunYouDetailActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public class RequestID {

        private String id;
        private String unit;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "RequestID{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

}
