package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.GetOilDetaiBean;
import com.neocom.mobilerefueling.bean.ListSettingBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderComEdittext;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/15.
 */

public class GetOilDetailActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.get_oil_noteno)
    OrderComEdittext getOilNoteno;
    @BindView(R.id.get_oil_car_no)
    OrderComEdittext getOilCarNo;
    @BindView(R.id.get_oil_car_driver)
    OrderComEdittext getOilCarDriver;
    @BindView(R.id.get_oil_driver_phone)
    OrderComEdittext getOilDriverPhone;
    @BindView(R.id.get_oil_remian_oil)
    OrderComEdittext getOilRemianOil;
    @BindView(R.id.get_oil_get_oil_count)
    OrderComEdittext getOilGetOilCount;
    @BindView(R.id.get_oil_get_oil_time)
    OrderComEdittext getOilGetOilTime;
    @BindView(R.id.get_oil_pici)
    OrderConbindView getOilPici;
    @BindView(R.id.get_oil_report)
    OrderConbindView getOilReport;
    @BindView(R.id.get_oil_hetong)
    OrderConbindView getOilHeTong;
    @BindView(R.id.get_oil_note_remark)
    OrderComEdittext getOilNoteRemark;
    @BindView(R.id.get_oil_youyangbianhao)
    OrderComEdittext getOilYouyangbianhao;
    @BindView(R.id.get_oil_cunfangweizhi)
    OrderComEdittext getOilCunfangweizhi;
    private String getoilid;
    private String downLoadOldName;
    private String downLoadFileId;
    ProgressBar progressBar;
    private String savePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MR";

    @Override
    public void initContentView() {

        setContentView(R.layout.get_oil_detail_activity);

    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        getoilid = intent.getStringExtra("itemId");
        getOilPici.setOnClickListener(this);
        getOilReport.setOnClickListener(this);
        getOilHeTong.setOnClickListener(this);
        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        getDataFromServer();


    }


    @Override
    public void initData() {

    }

    private void getDataFromServer() {

        GetOilDetatiId detatiId = new GetOilDetatiId();
        detatiId.setId(getoilid);

        String unit = Constant.DANWEI_T;

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();

        if (listSetting != null) {

            String item_quality = listSetting.getItem_quality();

            if (!TextUtils.isEmpty(item_quality)) {
                unit=item_quality;
            }
        }

        detatiId.setUnit(unit);

        final RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(detatiId);

        Call<GetOilDetaiBean> call = HttpManger.getHttpMangerInstance().getServices().purchaseDetail(requestBody);
        call.enqueue(new Callback<GetOilDetaiBean>() {
            @Override
            public void onResponse(Call<GetOilDetaiBean> call, Response<GetOilDetaiBean> response) {

                GetOilDetaiBean body = response.body();
                if (body != null) {
                    GetOilDetaiBean.BringBean bring = body.getBring();
                    if (bring != null) {
                        parseBringBean(bring);
                    } else {
                        Log.i(TAG, "onResponse: 显示 空界面");
                    }
                }
            }

            @Override
            public void onFailure(Call<GetOilDetaiBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


//    String batchId;
    String batchNum;
    String contractId;

    private void parseBringBean(GetOilDetaiBean.BringBean bringBean) {

        getOilYouyangbianhao.setEditTitle("油样编号");
        getOilYouyangbianhao.setEditContent(bringBean.getOilCode());

        getOilCunfangweizhi.setEditTitle("存放位置");
        getOilCunfangweizhi.setEditContent(bringBean.getOilPlace());
        getOilNoteno.setEditTitle("提油记录编号");
        getOilNoteno.setEditContent(bringBean.getPurchaseCode());
        getOilCarNo.setEditTitle("提油车车牌号");
        getOilCarNo.setEditContent(bringBean.getCarCode());

        getOilCarDriver.setEditTitle("提油车司机");
        getOilCarDriver.setEditContent(bringBean.getDriver());

        getOilDriverPhone.setEditTitle("提油司机电话");
        getOilDriverPhone.setEditContent(bringBean.getTelphone());

        getOilRemianOil.setEditTitle("剩余油量");
        String surplusOil = bringBean.getSurplusOil();
        if (!TextUtils.isEmpty(surplusOil)){
            getOilRemianOil.setEditContent(surplusOil+" 升");
        }


        getOilGetOilCount.setEditTitle("提取油量");

        String purchaseNum = bringBean.getPurchaseNum();

        if (!TextUtils.isEmpty(purchaseNum)){
            getOilGetOilCount.setEditContent(purchaseNum+" 吨");
        }


        getOilGetOilTime.setEditTitle("提油时间");
        getOilGetOilTime.setEditContent(bringBean.getPurchaseTime());
//        batchId = bringBean.getBatchId();
        batchNum = bringBean.getBatchNum();

        getOilPici.setTitle("油品批次");
//        getOilPici.setContet(batchId);
        getOilPici.setContet(bringBean.getBatchNum());

//        getOilReport.setTitle("质检报告");
//        getOilReport.setContet(bringBean.getFileOldName());
//        downLoadOldName = bringBean.getFileOldName();

        contractId = bringBean.getContractId();
        getOilHeTong.setTitle("合同");
        getOilHeTong.setContet(contractId);

//        downLoadFileId = bringBean.getFileId();
        getOilNoteRemark.setEditTitle("备注");
        getOilNoteRemark.setEditContent(bringBean.getRemarks());
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.get_oil_pici:


                if (batchNum == null) {
                    Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(GetOilDetailActivity.this, GetOilPiCiDetailActivity.class);
                intent.putExtra("batchNum", batchNum);
                startActivity(intent);

//                startActivity(new Intent(UIUtils.getContext(), GetPiCiActivity.class));

                break;
            case R.id.get_oil_report:
//                Toast.makeText(this, "获取质检报告", Toast.LENGTH_SHORT).show();
                break;
            case R.id.get_oil_hetong:
//                Toast.makeText(this, "获取质检报告", Toast.LENGTH_SHORT).show();
                if (contractId == null) {

                    Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
                    return;

                }

                Intent intentCID = new Intent(GetOilDetailActivity.this, HeTongDetailActivity.class);
                intentCID.putExtra("contractNum", contractId);
                startActivity(intentCID);

                break;

        }


    }

//    @Override
//    public void update(long bytesRead, long contentLength, boolean done) {
//
//        System.out.println("bytesRead" + bytesRead);
//        System.out.println("contentLength" + contentLength);
//        System.out.println("done" + done);
//        progressBar.setProgress((int) ((bytesRead * 100) / contentLength));
//
//    }


    public class GetOilDetatiId {
        //        {
//            "id":"13826ac51df343c09cd5b27ce14a0efc"
//        }
        public String id;
        public String unit;

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
            return "GetOilDetatiId{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

}
