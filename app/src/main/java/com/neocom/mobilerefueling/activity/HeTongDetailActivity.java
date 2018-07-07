package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.HeTongRespBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/13.
 */

public class HeTongDetailActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.batch_num)
    OrderConbindView batchNum;
    @BindView(R.id.contract_num)
    OrderConbindView contractNum;
    @BindView(R.id.batch_status)
    OrderConbindView batchStatus;
    @BindView(R.id.fuel_model_name)
    OrderConbindView fuelModelName;
    @BindView(R.id.national_standard)
    OrderConbindView nationalStandard;
    @BindView(R.id.price)
    OrderConbindView price;
    @BindView(R.id.fuel_total)
    OrderConbindView fuelTotal;
    @BindView(R.id.fuel_done)
    OrderConbindView fuelDone;
    @BindView(R.id.supply_name)
    OrderConbindView supplyName;
    @BindView(R.id.supply_tel)
    OrderConbindView supplyTel;
    @BindView(R.id.buyer)
    OrderConbindView buyer;
    @BindView(R.id.buy_time)
    OrderConbindView buyTime;
    @BindView(R.id.buyer_tel)
    OrderConbindView buyerTel;
    @BindView(R.id.pay_status)
    OrderConbindView payStatus;
    @BindView(R.id.remark)
    OrderConbindView remark;
    @BindView(R.id.supply_cus_name)
    OrderConbindView supplyCusName;
    private String heTongId;

    @Override
    public void initContentView() {

        setContentView(R.layout.hetong_detail_layout);

    }

    @Override
    public void initView() {

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initTitle();
    }

    private void initTitle() {

        batchNum.setTitle("合同编码");
        contractNum.setTitle("合同号");
        batchStatus.setTitle("合同状态");
        fuelModelName.setTitle("油品类型");
        nationalStandard.setTitle("国标");
        price.setTitle("单价");
        fuelTotal.setTitle("总油量(吨)");
        fuelDone.setTitle("已提油量(吨)");
        supplyCusName.setTitle("供油商");
        supplyName.setTitle("供油商联系人");
        supplyTel.setTitle("供油商联系电话");
        buyer.setTitle("采购人");
        buyTime.setTitle("采购时间");
        buyerTel.setTitle("采购人电话");
        payStatus.setTitle("支付情况");
        remark.setTitle("备注");

        Intent intent = getIntent();

        heTongId = intent.getStringExtra("contractNum");

//        if (heTongId == null) {
//            Toast.makeText(this, "获取数据异常", Toast.LENGTH_SHORT).show();
//            finish();
//        }

    }

    @Override
    public void initData() {

    }


    @Override
    protected void onStart() {
        super.onStart();
        getDataFromServer();
    }

    private void getDataFromServer() {

        RequestId requestId = new RequestId();
        requestId.setContractNum(heTongId);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(requestId);
        HttpManger.getHttpMangerInstance().getServices().contractDetail(requestBody).enqueue(new Callback<HeTongRespBean>() {
            @Override
            public void onResponse(Call<HeTongRespBean> call, Response<HeTongRespBean> response) {

                HeTongRespBean body = response.body();

                if (body != null) {


                    HeTongRespBean.BringBean bring = body.getBring();

                    if (bring != null) {

                        parseBringBean(bring);

                    } else {
//                        Toasty.info(HeTongDetailActivity.this, "获取数据异常", Toast.LENGTH_SHORT, true).show();
                        finish();
                    }


                }


            }

            @Override
            public void onFailure(Call<HeTongRespBean> call, Throwable t) {
                Toast.makeText(HeTongDetailActivity.this, "获取数据异常", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private void parseBringBean(HeTongRespBean.BringBean bring) {

        batchNum.setContet(bring.getBatchNum());
        contractNum.setContet(bring.getContractNum());
        batchStatus.setContet(bring.getBatchStatus());
        fuelModelName.setContet(bring.getFuelModelName());
        nationalStandard.setContet(bring.getNationalStandard());
        price.setContet(bring.getPrice());
        fuelTotal.setContet(bring.getFuelTotal());
        fuelDone.setContet(bring.getFuelDone());
        supplyCusName.setContet(bring.getSupplyCusName());
        supplyName.setContet(bring.getSupplyName());
        supplyTel.setContet(bring.getSupplyTel());
        buyer.setContet(bring.getBuyer());
        buyerTel.setContet(bring.getBuyerTel());
        buyTime.setContet(bring.getBuyTime());
        payStatus.setContet(bring.getPayStatus());
        remark.setContet(bring.getRemark());
    }

    public class RequestId {

        private String contractNum;

        public String getContractNum() {
            return contractNum;
        }

        public void setContractNum(String contractNum) {
            this.contractNum = contractNum;
        }

        @Override
        public String toString() {
            return "RequestId{" +
                    "contractNum='" + contractNum + '\'' +
                    '}';
        }
    }

}
