package com.neocom.mobilerefueling.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.PayBottomAdapter;
import com.neocom.mobilerefueling.alipay.Alipay;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.PayRequestParamBean;
import com.neocom.mobilerefueling.bean.PayResponseParamBean;
import com.neocom.mobilerefueling.bean.PayWXRespParaBean;
import com.neocom.mobilerefueling.bean.PayWayReqBean;
import com.neocom.mobilerefueling.bean.UnionParRespBean;
import com.neocom.mobilerefueling.bean.UpCurrentPayStatebean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.wxpay.WXPay;
import com.unionpay.UPPayAssistEx;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2018/6/12.
 */

public class PayBottomFragment extends BottomSheetDialogFragment implements View.OnClickListener {


    Button okGoPayBtn;
    private View view;
    private RecyclerView payListRec;
    List<PayWayReqBean.BringBean> payWayListBring;
    private String payYueE;
    private SuperTextView toSeeDetail;
    private TextView moneyNumTv;
    PayBottomAdapter payBottomAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.paychoose_layout);

        Bundle payType = getArguments();
        String payTypeString = payType.getString(Constant.payWayShow);
        payYueE = payType.getString(Constant.payYue);
        payWayListBring = GsonUtil.getObjectList(payTypeString, PayWayReqBean.BringBean.class);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();

    }

    private void initData() {


    }

    private void initView() {

//        ImageView closeOne = view.findViewById(R.id.close_one);
        payListRec = view.findViewById(R.id.pay_list);
        toSeeDetail = view.findViewById(R.id.to_see_detail);
        okGoPayBtn = view.findViewById(R.id.ok_go_pay_btn);
        moneyNumTv = view.findViewById(R.id.money_num_tv);

        okGoPayBtn.setOnClickListener(this);
        moneyNumTv.setText("需支付" + payYueE + "元");

        initRecyclerView();
    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        payListRec.setLayoutManager(layoutManager);
        payListRec.setItemAnimator(new DefaultItemAnimator());
//        PayBottomAdapter payBottomAdapter = new PayBottomAdapter(getContext(), payWay);
        payBottomAdapter = new PayBottomAdapter(getContext(), payWayListBring);
        payBottomAdapter.setSelection(0);
        payListRec.setAdapter(payBottomAdapter);
        payBottomAdapter.setOnRecycerViewItemClickListener(new PayBottomAdapter.OnRecycerViewItemClickListener() {
            @Override
            public void OnClick(PayWayReqBean.BringBean payChooseBean, int position) {
//                Toast.makeText(getContext(), "->" + payChooseBean.getPayWayName() + "-" + position, Toast.LENGTH_SHORT).show();

//                callPayParams(payChooseBean.getPayWayName());

                payBottomAdapter.setSelection(position);

            }
        });
    }


    private void callPayParams() {

        if (TextUtils.isEmpty(payYueE)) {

            Toast.makeText(getActivity(), "未获取到余额", Toast.LENGTH_SHORT).show();
            return;
        }

//        String payName = payWayListBring.get(payBottomAdapter.getSelection()).getPayWayName();
        String payCode = payWayListBring.get(payBottomAdapter.getSelection()).getPayWayCode();

        switch (payCode) {
            case "2":
                getPayParams(Constant.PAYWAY_ALIPAY, payYueE);
                break;
            case "3":
                getPayParams(Constant.PAYWAY_WX, payYueE);
                break;
            case "1":
                getPayParams(Constant.PAYWAY_UNION, payYueE);
                break;
            case "4":
                LogUtils.i("余额");

                break;

        }


    }

    private void getPayParams(final String payWay, String amount) {

        PayRequestParamBean payRequestParamBean = new PayRequestParamBean();
        payRequestParamBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        payRequestParamBean.setPayWay(payWay);
//        payRequestParamBean.setAmount("0.01");
        payRequestParamBean.setAmount(amount);
        payRequestParamBean.setType(Constant.TRADE_TYPE_CHONGZHI);
        payRequestParamBean.setGoodsType(Constant.GOODS_TYPE_CHONGZHI);
        payRequestParamBean.setRelationId("");

//        final String reqOrderInfo = new Gson().toJson(payRequestParamBean);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(payRequestParamBean);

        if (payWay == Constant.PAYWAY_ALIPAY) {

            HttpManger.getHttpMangerInstance().getServices().paymentAliPay(requestBody).enqueue(new Callback<PayResponseParamBean>() {
                @Override
                public void onResponse(Call<PayResponseParamBean> call, Response<PayResponseParamBean> response) {

                    PayResponseParamBean body = response.body();

                    if (body != null) {

//                        String bring1 = body.getBring();

                        boolean res = body.isRes();
                        String message = body.getMessage();
                        if (res) {

                            PayResponseParamBean.BringBean bring = body.getBring();

                            if (bring != null) {
                                parseBring(bring);
                            } else {


                                if (TextUtils.isEmpty(message)) {

                                    Toast.makeText(getContext(), "充值成功", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                                    return;

                                }
                            }


                        } else {

                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(getContext(), "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                                return;

                            }


                        }


                    }


                }

                @Override
                public void onFailure(Call<PayResponseParamBean> call, Throwable t) {
                    LogUtils.i("onFailure: " + t.getMessage());
                }
            });

        }

        if (payWay == Constant.PAYWAY_WX) {

            HttpManger.getHttpMangerInstance().getServices().paymentWXPay(requestBody).enqueue(new Callback<PayWXRespParaBean>() {
                @Override
                public void onResponse(Call<PayWXRespParaBean> call, Response<PayWXRespParaBean> response) {


                    PayWXRespParaBean body = response.body();

                    if (body != null) {


                        boolean res = body.isRes();
                        String message = body.getMessage();

                        if (res) {


                            PayWXRespParaBean.BringBean bring = body.getBring();

                            if (bring != null) {
                                LogUtils.i("onResponse: 微信支付返回....");
                                parseWXBring(bring);
                            } else {

                                if (TextUtils.isEmpty(message)) {

                                    Toast.makeText(getContext(), "充值失败", Toast.LENGTH_SHORT).show();

                                } else {

                                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                                    return;

                                }

                            }


                        } else {
                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(getContext(), "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                                return;

                            }

                        }


                    }


                }

                @Override
                public void onFailure(Call<PayWXRespParaBean> call, Throwable t) {
                    LogUtils.i("onFailure: " + t.getMessage());
                }
            });


        }

        if (payWay == Constant.PAYWAY_UNION) {

            HttpManger.getHttpMangerInstance().getServices().paymentUnionPay(requestBody).enqueue(new Callback<UnionParRespBean>() {
                @Override
                public void onResponse(Call<UnionParRespBean> call, Response<UnionParRespBean> response) {

                    UnionParRespBean body = response.body();
                    if (body != null) {

                        boolean res = body.isRes();
                        String message = body.getMessage();

                        if (res) {


                            UnionParRespBean.BringBean bring = body.getBring();

                            if (bring != null) {
//                            Log.i(TAG, "onResponse: 去做 银联扣款动作...");

                                parseUnionBring(bring);
                            }

                        } else {

                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(getContext(), "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

                            }


                        }


                    }

                }

                @Override
                public void onFailure(Call<UnionParRespBean> call, Throwable t) {
                    LogUtils.i("onFailure: " + t.getMessage());
                }
            });

        }


    }


    private void parseBring(PayResponseParamBean.BringBean bring) {
        sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANZHONG);

        doAlipay(bring);

    }


    private void parseWXBring(PayWXRespParaBean.BringBean bring) {

        LogUtils.i("parseWXBring: 返回实体类：" + bring.toString() + "；转json：" + new Gson().toJson(bring));

//        doWXPay(new Gson().toJson(bring));
        sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANZHONG);
        doWXPay(bring);

    }

    UnionParRespBean.BringBean doUniobring;

    private void parseUnionBring(UnionParRespBean.BringBean bring) {

        LogUtils.i("parseBring: :返回tn消息:" + bring);

//        gotoPay(orderInfoReq,bringResp);
//        gotoPay();
//        doAlipay(bringResp);
        this.doUniobring = bring;
        sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANZHONG);
        doUnionpay(bring);
    }


    public void sendCurrentPayState(String recordId, String status) {

        UpCurrentPayStatebean upCurrentPayStatebean = new UpCurrentPayStatebean();
        upCurrentPayStatebean.setRecordId(recordId);
        upCurrentPayStatebean.setStatus(status);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(upCurrentPayStatebean);

        HttpManger.getHttpMangerInstance().getServices().updateStatus(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                EmptyBringGetOilBean body = response.body();

                if (body != null) {

                    String bring = body.getBring();


                    if (bring != null) {


                        LogUtils.i("onResponse: " + bring);

                    }


                } else {

                    LogUtils.i("onResponse:返回 空");
                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                LogUtils.i("onFailure: " + t.getMessage());
            }
        });


    }


    /**
     * 支付宝支付
     *
     * @param bring 支付服务生成的支付参数
     */
    private void doAlipay(final PayResponseParamBean.BringBean bring) {

        final String returnStr = bring.getReturnStr();
        if (TextUtils.isEmpty(returnStr)) {
            return;
        }

        new Alipay(getContext(), returnStr, new Alipay.AlipayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();
//                showSucDialog();
            }

            @Override
            public void onDealing() {
                Toast.makeText(getContext(), "支付处理中...", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onError(int error_code) {
                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANSHIBAI);
                switch (error_code) {

                    case Alipay.ERROR_RESULT:
                        Toast.makeText(getContext(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_NETWORK:
                        Toast.makeText(getContext(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_PAY:
                        Toast.makeText(getContext(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(getContext(), "支付错误", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onCancel() {
                Toast.makeText(getContext(), "支付取消", Toast.LENGTH_SHORT).show();
                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANQUXIAO);
            }
        }).doPay();
    }


    /**
     * 微信支付
     *
     * @param bring 支付服务生成的支付参数
     */
//    private IWXAPI api;
    private void doWXPay(final PayWXRespParaBean.BringBean bring) {
//        api = WXAPIFactory.createWXAPI(this, Constant.WX_APPID);
        if (bring == null) {
            return;
        }
        String wx_appid = bring.getAppId();  //替换为自己的appid
        WXPay.init(UIUtils.getContext(), wx_appid); //要在支付前调用
        WXPay.getInstance().doPay(bring, new WXPay.WXPayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();
//                showSucDialog();
            }

            @Override
            public void onError(int error_code) {

                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANSHIBAI);

                switch (error_code) {
                    case WXPay.NO_OR_LOW_WX:
                        Toast.makeText(getContext(), "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                        break;

                    case WXPay.ERROR_PAY_PARAM:
                        Toast.makeText(getContext(), "参数错误", Toast.LENGTH_SHORT).show();
                        break;

                    case WXPay.ERROR_PAY:
                        Toast.makeText(getContext(), "支付失败", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(getContext(), "支付取消", Toast.LENGTH_SHORT).show();

                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANQUXIAO);
            }
        });
    }

    public static final int PLUGIN_NOT_INSTALLED = -1;
    public static final int PLUGIN_NEED_UPGRADE = 2;

    private void doUnionpay(UnionParRespBean.BringBean bring) {


        String returnStr = bring.getReturnStr();

        if (TextUtils.isEmpty(returnStr)) {

            return;
        }

        String model = bring.getModel();

//        if (!TextUtils.isEmpty(model)) {
//          String  mMode = model;
//        }
        LogUtils.i("doUnionpay: 0正式" + model);
        // mMode参数解释：
        // 0 - 启动银联正式环境
        // 1 - 连接银联测试环境
        int ret = UPPayAssistEx.startPay(getActivity(), null, null, returnStr, model);
        if (ret == PLUGIN_NEED_UPGRADE || ret == PLUGIN_NOT_INSTALLED) {
            // 需要重新安装控件
            Log.e("控件", " plugin not found or need upgrade!!!");

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("提示");
            builder.setMessage("完成购买需要安装银联支付控件，是否安装？");

            builder.setNegativeButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            UPPayAssistEx.installUPPayPlugin(getActivity());
                            dialog.dismiss();
                        }
                    });

            builder.setPositiveButton("取消",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.create().show();

        }
        Log.e("去支付", "" + ret);

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        payWayBack = ((callPayWayBack) context);
//        payWayBack
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_go_pay_btn:

                if (payWayBack != null) {
                    if (TextUtils.isEmpty(payYueE)) {

                        Toast.makeText(getActivity(), "未获取到余额", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    PayWayReqBean.BringBean bringBean = payWayListBring.get(payBottomAdapter.getSelection());

                    payWayBack.SendChooseData(bringBean,payYueE);

                }

//                callPayParams();
                dismiss();
                break;

        }
    }

    callPayWayBack payWayBack;

    public interface callPayWayBack {
        void SendChooseData(PayWayReqBean.BringBean chooseBean,String moneyNum);
    }

}
