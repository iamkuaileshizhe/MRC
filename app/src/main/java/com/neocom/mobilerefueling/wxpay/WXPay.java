package com.neocom.mobilerefueling.wxpay;

import android.content.Context;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.bean.PayWXRespParaBean;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

//import com.tencent.mm.sdk.constants.Build;
//import com.tencent.mm.sdk.modelpay.PayReq;
//import com.tencent.mm.sdk.openapi.IWXAPI;
//import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * 微信支付
 * Created by tsy on 16/6/1.
 */
public class WXPay {

    private static WXPay mWXPay;
    private IWXAPI mWXApi;
    //    private String mPayParam;
    private WXPayResultCallBack mCallback;

    public static final int NO_OR_LOW_WX = 1;   //未安装微信或微信版本过低
    public static final int ERROR_PAY_PARAM = 2;  //支付参数错误
    public static final int ERROR_PAY = 3;  //支付失败

    public interface WXPayResultCallBack {
        void onSuccess(); //支付成功

        void onError(int error_code);   //支付失败

        void onCancel();    //支付取消
    }

    public WXPay(Context context, String wx_appid) {
        mWXApi = WXAPIFactory.createWXAPI(context, null);
        mWXApi.registerApp(wx_appid);
    }

    public static void init(Context context, String wx_appid) {
        if (mWXPay == null) {
            mWXPay = new WXPay(context, wx_appid);
        }
    }

    public static WXPay getInstance() {
        return mWXPay;
    }

    public IWXAPI getWXApi() {
        return mWXApi;
    }

    /**
     * 发起微信支付
     */
//    public void doPay(String pay_param, WXPayResultCallBack callback) {
    public void doPay(PayWXRespParaBean.BringBean bring, WXPayResultCallBack callback) {
        LogUtils.i("发起微信支付参数:: " + new Gson().toJson(bring));
//        mPayParam = pay_param;
        mCallback = callback;

        if (!check()) {
            if (mCallback != null) {
                mCallback.onError(NO_OR_LOW_WX);
            }
            return;
        }

//        JSONObject param = null;
//        try {
//            param = new JSONObject(mPayParam);
//        } catch (JSONException e) {
//            e.printStackTrace();
//            if (mCallback != null) {
//                mCallback.onError(ERROR_PAY_PARAM);
//            }
//            return;
//        }

//        || TextUtils.isEmpty(param.optString("package"))




//        if (TextUtils.isEmpty(param.optString("appid")) || TextUtils.isEmpty(param.optString("partnerid"))
//                || TextUtils.isEmpty(param.optString("prepayid")) ||
//                TextUtils.isEmpty(param.optString("noncestr")) || TextUtils.isEmpty(param.optString("timestamp")) ||
//                TextUtils.isEmpty(param.optString("sign"))) {
//            if (mCallback != null) {
//                mCallback.onError(ERROR_PAY_PARAM);
//            }
//            return;
//        }

//        wxfa7ab97dd028ff83

//        PayReq req = new PayReq();
//        req.appId = param.optString("appid");
//        req.partnerId = param.optString("partnerid");
//        req.prepayId = param.optString("prepayid");
////        req.packageValue = param.optString("package");
//        req.packageValue = param.optString("Sign=WXPay");
//        req.nonceStr = param.optString("noncestr");
//        req.timeStamp = param.optString("timestamp");
//        req.sign = param.optString("sign");


        try {
//            PayReq req = new PayReq();
//            req.appId = "wxfa7ab97dd028ff83";  // 测试用appId
//            req.appId			= param.getString("appid");
//            req.partnerId		= param.getString("partnerid");
//            req.prepayId		= param.getString("prepayid");
//            req.nonceStr		= param.getString("noncestr");
//            req.timeStamp		= param.getString("timestamp");
//            req.packageValue	= param.getString("package");
//            req.sign			= param.getString("sign");
//            req.extData			= "app data"; // optional


            PayReq req = new PayReq();
            req.appId = bring.getAppId();  // 测试用appId
            req.partnerId = bring.getPartnerId();
            req.prepayId = bring.getPrepayId();
            req.nonceStr = bring.getNonceStr();
            req.timeStamp = bring.getTimeStamp();
            req.packageValue = "Sign=WXPay";
            req.sign = bring.getSign();
            req.extData = "app data"; // optional
            req.signType = "HMAC-SHA256";

            LogUtils.d("拉起微信:====" + new Gson().toJson(req));


            mWXApi.sendReq(req);
        } catch (Exception e) {
            e.printStackTrace();

            if (mCallback != null) {
                mCallback.onError(ERROR_PAY_PARAM);
            }

            LogUtils.i("-- 支付上传参数 异常--");

        }
    }

    //支付回调响应
    public void onResp(int error_code) {
        if (mCallback == null) {
            return;
        }

        if (error_code == 0) {   //成功
            mCallback.onSuccess();
        } else if (error_code == -1) {   //错误
            mCallback.onError(ERROR_PAY);
        } else if (error_code == -2) {   //取消
            mCallback.onCancel();
        }

        mCallback = null;
    }

    //检测是否支持微信支付
    private boolean check() {
        return mWXApi.isWXAppInstalled() && mWXApi.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
    }
}
