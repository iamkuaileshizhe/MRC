package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.TiYouBean;
import com.neocom.mobilerefueling.bean.TiYouRespBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.OrderEdittext;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIDateTimeSaveListener;
import com.widget.jcdialog.listener.DialogUIListener;
import com.widget.jcdialog.widget.DateSelectorWheelView;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/10.
 */

public class TiYouGongDanActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.car_code)
    OrderEdittext carCode;
    @BindView(R.id.car_driver)
    OrderEdittext carDriver;
    @BindView(R.id.car_telphone)
    OrderEdittext carTelphone;
    @BindView(R.id.youyang_no)
    OrderEdittext youyangNo;
    @BindView(R.id.youyang_position)
    OrderEdittext youyangPosition;
    @BindView(R.id.remain_oil)
    OrderEdittext remainOil;
    @BindView(R.id.tiqu_oil)
    OrderEdittext tiquOil;
    @BindView(R.id.tiyou_time)
    OrderConbindView tiyouTime;
    @BindView(R.id.oil_pici)
    OrderConbindView oilPici;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.oil_hetong)
    OrderConbindView oilHetong;
    @BindView(R.id.hetong_more)
    ImageView hetongMore;
    @BindView(R.id.remark_info)
    EditText remarkInfo;
    @BindView(R.id.submit_cancle)
    Button submitCancle;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLl;
    private TiYouBean tiYouBean;

    @Override
    public void initContentView() {
        setContentView(R.layout.ti_you_layout);
    }

    @Override
    public void initView() {
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        oilPici.setOnClickListener(this);
        oilHetong.setOnClickListener(this);
        submitNow.setOnClickListener(this);
        tiyouTime.setOnClickListener(this);
        initTitle();
    }

    private void initTitle() {

        carCode.setEditTitle("提油车牌号");
//        carCode.setEditContent(GetUserInfoUtils.getUserInfo().getCarNum());
        carCode.setEditContent(SPUtils.getSaveCar());
        carDriver.setEditTitle("提油司机");
        carDriver.setEditContent(GetUserInfoUtils.getUserInfo().getUserName());
        carTelphone.setEditTitle("提油司机电话");
        carTelphone.setEditContent(GetUserInfoUtils.getUserInfo().getUserInfoMobile());
        youyangNo.setEditTitle("油样编号");
        youyangPosition.setEditTitle("存放位置");
        remainOil.setEditTitle("剩余油量(吨)");
        tiquOil.setEditTitle("提取油量(吨)");
        tiyouTime.setTitle("提油时间");
        tiyouTime.setContet("请选择时间");
        oilPici.setTitle("油品批次");
        oilHetong.setTitle("合同");

    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.tiyou_time:

            {
                DialogUtils.showDatePick(TiYouGongDanActivity.this, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

//                        Toast.makeText(ReceiveListDetailActivity.this, "时间："+selectedDate, Toast.LENGTH_SHORT).show();
                        tiyouTime.setContet(selectedDate);

                    }
                }).show();
            }

            break;
            case R.id.oil_pici:

                Intent intent = new Intent(UIUtils.getContext(), GetPiCiActivity.class);

                startActivityForResult(intent, 111);
//                startActivity(intent);

                break;

            case R.id.oil_hetong:

//                GetHeTongActivity
                Intent intentHetong = new Intent(UIUtils.getContext(), GetHeTongActivity.class);

                startActivityForResult(intentHetong, 122);
//                startActivity(intentHetong);
                break;

            case R.id.submit_now:

                submitTiYouInfo();

                break;


        }


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111 && resultCode == 112) {
//            Log.i(TAG, "onActivityResult: =批次=" + data.getStringExtra("batchId"));
            oilPici.setContet(data.getStringExtra("batchId"));
//            tiYouBean.setBatchId(data.getStringExtra("batchId"));

        }

        if (requestCode == 122 && resultCode == 123) {

//            Log.i(TAG, "onActivityResult: =合同==》" + data.getStringExtra("hetongId"));
            oilHetong.setContet(data.getStringExtra("hetongId"));
//            tiYouBean.setContractId(data.getStringExtra("hetongId"));
        }

    }


    private void submitTiYouInfo() {

        tiYouBean = new TiYouBean();

        tiYouBean.setRecordStatus("1");

        String carCodeStr = carCode.getEditContent();
        if (TextUtils.isEmpty(carCodeStr)) {
            Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setCarCode(carCodeStr);
        String carDriverStr = carDriver.getEditContent();
        if (TextUtils.isEmpty(carDriverStr)) {
            Toast.makeText(this, "请输入提油司机姓名", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setDriver(carDriverStr);
        String carTelphoneStr = carTelphone.getEditContent();
        if (TextUtils.isEmpty(carTelphoneStr)) {
            Toast.makeText(this, "请输入提油司机电话", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setTelphone(carTelphoneStr);
        String youyangNoStr = youyangNo.getEditContent();
        if (TextUtils.isEmpty(youyangNoStr)) {
            Toast.makeText(this, "请输入油样编号", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setOilCode(youyangNoStr);
        String youyangPositionStr = youyangPosition.getEditContent();
        if (TextUtils.isEmpty(youyangPositionStr)) {
            Toast.makeText(this, "请输入存放位置", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setOilPlace(youyangPositionStr);

        String remainOilStr = remainOil.getEditContent();
        if (TextUtils.isEmpty(remainOilStr)) {
            Toast.makeText(this, "请输入剩余油量", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setSurplusOil(remainOilStr);

        String tiquOilStr = tiquOil.getEditContent();
        if (TextUtils.isEmpty(tiquOilStr)) {
            Toast.makeText(this, "请输入提取油量", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setPurchaseNum(tiquOilStr);

        String tiyouTimeStr = tiyouTime.getContent();
        if (TextUtils.isEmpty(tiyouTimeStr)||tiyouTimeStr.equals("请选择时间")) {
            Toast.makeText(this, "请输入提油时间", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setPurchaseTime(tiyouTimeStr.replace("年", "-").replace("月", "-").replace("日", "-"));

        String piciStr = oilPici.getContent();
        if (TextUtils.isEmpty(piciStr)) {
            Toast.makeText(this, "请选择油品批次", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouBean.setBatchId(piciStr);

        String oilHetongStr = oilHetong.getContent();
        if (TextUtils.isEmpty(oilHetongStr)) {
            Toast.makeText(this, "请选择合同", Toast.LENGTH_SHORT).show();
            return;
        }
        showLoadingDialog("提交中...");
        tiYouBean.setContractId(oilHetongStr);
        tiYouBean.setC_user(GetUserInfoUtils.getUserInfo().getUserId());

//        String remarkStr = remarkInfo.getText().toString().trim();
//                if (TextUtils.isEmpty(remarkStr)){
//                    tiYouBean.
//
//        }else{
//                    tiYouBean.
//                }
//        tiYouBean.setContractId("合同");
//
//        tiYouBean.setBatchId("批次");

        String toJson = new Gson().toJson(tiYouBean);
        Log.i(TAG, "submitTiYouInfo: " + toJson);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(tiYouBean);
        HttpManger.getHttpMangerInstance().getServices().addPurchase(requestBody).enqueue(new Callback<TiYouRespBean>() {
            @Override
            public void onResponse(Call<TiYouRespBean> call, Response<TiYouRespBean> response) {
//                Log.i(TAG, "onResponse: " + response.body().toString());
                disDialog();



                TiYouRespBean body = response.body();

                if (body != null) {



//                    if (TextUtils.isEmpty(message)){
//                        showDialog("提油单提交成功");
//                    }else {
//                        showDialog(message);
//                    }

                    if (body.isRes()){
                        String message = body.getMessage();

                       if (TextUtils.isEmpty(message)){
                        showDialog("提油单提交成功");
                    }else {
                        showDialog(message);
                    }


                    }else{

                        showDialog("订单提交失败，请检查");
                    }

                }
            }

            @Override
            public void onFailure(Call<TiYouRespBean> call, Throwable t) {
                disDialog();
                Log.i(TAG, "onFailure: " + t.getMessage());
                showDialog("订单提交失败，请检查");
            }
        });
    }


    public void showDialog(String mag) {


        DialogUtils.showAlert(TiYouGongDanActivity.this, "提示", mag, "", "", "我知道了", "", true, new DialogUIListener() {
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
