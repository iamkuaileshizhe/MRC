package com.neocom.mobilerefueling.wxapi;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
//import com.neo.mobilerefueling.R;
//import com.neo.mobilerefueling.activity.ChargeMoneyActivity;
//import com.neo.mobilerefueling.utils.LogUtils;
//import com.neo.mobilerefueling.wxpay.WXPay;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.wxpay.WXPay;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler, View.OnClickListener {

    //	private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
    private static final String TAG = "WXPayEntryActivity";

//    private IWXAPI api;

    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private View view_custom;
    private TextView detailTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);

//        api = WXAPIFactory.createWXAPI(this, Constant.WX_APPID);
//        api.handleIntent(getIntent(), this);
//        initDialog();




        if(WXPay.getInstance() != null) {
            WXPay.getInstance().getWXApi().handleIntent(getIntent(), this);
        } else {
            finish();
        }


    }





    private void initDialog() {
        //初始化Builder
        builder = new AlertDialog.Builder(WXPayEntryActivity.this);
        //加载自定义的那个View,同时设置下
        final LayoutInflater inflater = getLayoutInflater();
        view_custom = inflater.inflate(R.layout.pay_suc_layout, null, false);
        builder.setView(view_custom);
        builder.setCancelable(false);
        alert = builder.create();

        initDialogView(view_custom);

    }


    private void initDialogView(View view) {

        detailTxt = view.findViewById(R.id.detail_txt);
        TextView okTv = view.findViewById(R.id.ok_tv);

        detailTxt.setOnClickListener(WXPayEntryActivity.this);
        okTv.setOnClickListener(WXPayEntryActivity.this);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
//        api.handleIntent(intent, this);

        if(WXPay.getInstance() != null) {
            WXPay.getInstance().getWXApi().handleIntent(intent, this);
        }

    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        LogUtils.d("onPayFinish, errCode = " + resp.errCode + ";;" + new Gson().toJson(resp));

//        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("提示");
//            builder.setMessage("微信支付结果" + String.valueOf(resp.errCode));
//            builder.show();
//        }

//        名称 描述 解决方案
//        0 成功 展示成功页面
//        -1 错误 可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
//        -2 用户取消 无需处理。发生场景：用户不支付了，点击取消，返回APP。




        if(resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if(WXPay.getInstance() != null) {
                if(resp.errStr != null) {
                    Log.e("wxpay", "errstr=" + resp.errStr);
                }

                WXPay.getInstance().onResp(resp.errCode);
                finish();
            }
        }



//        if (resp.errCode == 0) {
//
//            showSucDialog();
//        } else if (resp.errCode == -1) {
//
//
//            showDialogTips("支付失败");
//
//
//        } else if (resp.errCode == -2) {
//            showDialogTips("取消支付");
//
//        }


    }


    public void showDialogTips(String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("支付结果通知");
        builder.setMessage(msg);
        builder.setInverseBackgroundForced(true);
        // builder.setCustomTitle();
        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.create().show();

    }


    public void showSucDialog() {

        alert.show();
//        detailTxt.setText("成功支付" + ChargeMoneyActivity.MONEY_GRIDE + "元");
        detailTxt.setText("成功支付");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:

                finish();

                break;


        }


    }
}