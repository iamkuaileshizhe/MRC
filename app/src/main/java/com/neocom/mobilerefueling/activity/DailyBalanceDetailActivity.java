package com.neocom.mobilerefueling.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.alipay.Alipay;
import com.neocom.mobilerefueling.bean.DailyAccountPassReqBean;
import com.neocom.mobilerefueling.bean.DailyRecordRespBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.IdBean;
import com.neocom.mobilerefueling.bean.NeedCheckReqBean;
import com.neocom.mobilerefueling.bean.OnlyIdReqBean;
import com.neocom.mobilerefueling.bean.PayRequestParamBean;
import com.neocom.mobilerefueling.bean.PayResponseParamBean;
import com.neocom.mobilerefueling.bean.PayWXRespParaBean;
import com.neocom.mobilerefueling.bean.PayWayGetBean;
import com.neocom.mobilerefueling.bean.PayWayReqBean;
import com.neocom.mobilerefueling.bean.UnionParRespBean;
import com.neocom.mobilerefueling.bean.UpCurrentPayStatebean;
import com.neocom.mobilerefueling.fragment.PayBottomFragment;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;
import com.neocom.mobilerefueling.view.VeryfyEditDialog;
import com.neocom.mobilerefueling.wxpay.WXPay;
import com.unionpay.UPPayAssistEx;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/6/2.
 */

public class DailyBalanceDetailActivity extends BaseActivity implements View.OnClickListener, SuperTextView.OnSuperTextViewClickListener, PayBottomFragment.callPayWayBack {
    @BindView(R.id.detail_top_bar)
    TopTitleBar detailTopBar;
    @BindView(R.id.balance_sate)
    SuperTextView balanceSate;
    @BindView(R.id.balance_start_time)
    SuperTextView balanceStartTime;
    @BindView(R.id.balance_end_time)
    SuperTextView balanceEndTime;
    @BindView(R.id.balance_rec_no)
    SuperTextView balanceRecNo;
    @BindView(R.id.balance_car_no)
    SuperTextView balanceCarNo;
    @BindView(R.id.balance_driver_name)
    SuperTextView balanceDriverName;
    @BindView(R.id.balance_safeman_name)
    SuperTextView balanceSafemanName;
    @BindView(R.id.balance_daily_finish_count)
    SuperTextView balanceDailyFinishCount;
    @BindView(R.id.balance_daily_oil_count)
    SuperTextView balanceDailyOilCount;
    @BindView(R.id.balance_daily_supplyoil_count)
    SuperTextView balanceDailySupplyoilCount;
    @BindView(R.id.balance_per_finish_order)
    SuperTextView balancePerFinishOrder;
    @BindView(R.id.balance_per_sure_order)
    SuperTextView balancePerSureOrder;
    @BindView(R.id.balance_per_unsure_order)
    SuperTextView balancePerUnsureOrder;
    @BindView(R.id.balance_cash_money_count)
    SuperTextView balanceCashMoneyCount;
    @BindView(R.id.balance_online_money_count)
    SuperTextView balanceOnlineMoneyCount;
    @BindView(R.id.balance_uncal_money_count)
    SuperTextView balanceUncalMoneyCount;
    @BindView(R.id.balance_uncal_money_order_detail)
    SuperTextView balanceUncalMoneyOrderDetail;


    @BindView(R.id.agree_btn)
    Button agreeBtn;
    @BindView(R.id.disagree_btn)
    Button disagreeBtn;
    @BindView(R.id.agree_disagree_btn_layout)
    LinearLayout agreeDisagreeBtnLayout;

    private final String ZHIFU = "支付";
    private final String QUEREN = "确认";
    private String yueEMoney = "0";

    private Context context;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private View view_custom;

    private TextView detailTxt;

    public static void detailStart(Context context, String itemId) {

        Intent intent = new Intent(context, DailyBalanceDetailActivity.class);
        intent.putExtra("itemId", itemId);
        context.startActivity(intent);


    }

    @Override
    public void initContentView() {
        setContentView(R.layout.daily_balance_detail_layout);
    }

    String itemId = "";

    @Override
    public void initView() {
        itemId = getIntent().getStringExtra("itemId");
        detailTopBar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });

        agreeBtn.setOnClickListener(this);
        disagreeBtn.setOnClickListener(this);
        balancePerSureOrder.setOnSuperTextViewClickListener(this);
        balancePerUnsureOrder.setOnSuperTextViewClickListener(this);
        balanceUncalMoneyOrderDetail.setOnSuperTextViewClickListener(this);
        balancePerFinishOrder.setOnSuperTextViewClickListener(this);
        context = DailyBalanceDetailActivity.this;
        getDataFromServer();
        initDialog();
    }

    private void initDialog() {
        //初始化Builder
        builder = new AlertDialog.Builder(context);
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

        detailTxt.setOnClickListener(this);
        okTv.setOnClickListener(this);

    }

    private void getDataFromServer() {
        if (TextUtils.isEmpty(itemId)) {
            return;
        }
        showLoadingDialog("详情加载中...");
        OnlyIdReqBean onlyIdReqBean = new OnlyIdReqBean();
        onlyIdReqBean.setId(itemId);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(onlyIdReqBean);
        Call<DailyRecordRespBean> stringCall = HttpManger.getHttpMangerInstance().getServices().queryDailyRecordById(requestBody);
        stringCall.enqueue(new Callback<DailyRecordRespBean>() {
            @Override
            public void onResponse(Call<DailyRecordRespBean> call, Response<DailyRecordRespBean> response) {
                disDialog();
                DailyRecordRespBean body = response.body();

                if (body != null) {

                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        DailyRecordRespBean.BringBean bring = body.getBring();

                        if (bring == null) {


                            if (TextUtils.isEmpty(message)) {

                                showWarnTip("获取信息为空");

                            } else {
                                showWarnTip(message);
                            }

                        } else {

                            showDataToView(bring);

                        }

                    } else {
                        if (TextUtils.isEmpty(message)) {

                            showWarnTip("获取信息失败");

                        } else {
                            showWarnTip(message);
                        }

                    }

                }

            }

            @Override
            public void onFailure(Call<DailyRecordRespBean> call, Throwable t) {
                disDialog();
                showFailTip();
                LogUtils.e(t.getMessage());
            }
        });
    }

    String payStatus = "";

    private void showDataToView(DailyRecordRespBean.BringBean bring) {
        balanceStartTime.setRightString(bring.getSettlemenStart());
        balanceEndTime.setRightString(bring.getSettlemenEnd());
        balanceRecNo.setRightString(bring.getDailyCode());
        balanceCarNo.setRightString(bring.getCarNumber());
        balanceDriverName.setRightString(bring.getDriverName() + "  " + bring.getDriverTel());
        balanceSafemanName.setRightString(bring.getCarSafteyName() + "  " + bring.getCarSafteyTel());
        balanceDailyFinishCount.setRightString(bring.getCarDeliveryNums());
        balanceDailyOilCount.setRightString(bring.getCarOilAmount());
        balanceDailySupplyoilCount.setRightString(bring.getCarSupplyAmount());

        balancePerFinishOrder.setRightString(bring.getDeliveryNums());
        balancePerSureOrder.setRightString(bring.getDeliveryConfirm());
        balancePerUnsureOrder.setRightString(bring.getDeliveryNoConfirm());
        balanceCashMoneyCount.setRightString(bring.getAccountPay());
        balanceOnlineMoneyCount.setRightString(bring.getOnlinePay());


//        balanceUncalMoneyOrderDetail.setRightString(bring.getAccountPay());
        balanceUncalMoneyOrderDetail.setRightString(bring.getDeliveryPayNums());

        String payable = bring.getPayable();
        String payableShow = bring.getPayable_show();
        balanceUncalMoneyCount.setRightString(payableShow);

//        balanceSate.setCenterString(GetOrderStateUtil.getJieSuanState(bring.getPayStatus()));
        balanceSate.setCenterString(GetOrderStateUtil.getDailyBlanceState(bring.getPayStatus()));


        if (TextUtils.isEmpty(payable)) {
            agreeDisagreeBtnLayout.setVisibility(View.GONE);
            yueEMoney = "0";
        } else {

            BigDecimal bigDecimal = new BigDecimal(payable);
            yueEMoney = payable;
            int compareTo = bigDecimal.compareTo(BigDecimal.ZERO);
            if (compareTo <= 0) {
                agreeBtn.setText(QUEREN);
            } else {
                agreeBtn.setText(ZHIFU);
            }

            this.payStatus = bring.getPayStatus();

            if (this.payStatus.equals("2")) {
//                已完成
                agreeDisagreeBtnLayout.setVisibility(View.GONE);
            } else {
                agreeDisagreeBtnLayout.setVisibility(View.VISIBLE);
            }

        }

    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.agree_btn:

                String agreeBtnText = agreeBtn.getText().toString();

                if (agreeBtnText.equals(ZHIFU)) {
//                    Toast.makeText(this, "支付", Toast.LENGTH_SHORT).show();

                    requestPayWay();

                } else if (agreeBtnText.equals(QUEREN)) {
//                    Toast.makeText(this, "确认", Toast.LENGTH_SHORT).show();

                    dailyAccountPass();

                }

                break;
            case R.id.disagree_btn:
                VeryfyEditDialog veryfyEditDialog = new VeryfyEditDialog(this);
                veryfyEditDialog.show();
                veryfyEditDialog.setOnPosNegClickListener(new VeryfyEditDialog.OnPosNegClickListener() {
                    @Override
                    public void posClickListener(String value) {

                        needCheckReq(value);

                    }

                    @Override
                    public void negCliclListener(String value) {


                    }
                });
                break;


//            detailTxt = view.findViewById(R.id.detail_txt);
//            TextView okTv = view.findViewById(R.id.ok_tv);


            case R.id.detail_txt:

                break;

            case R.id.ok_tv:

                alert.dismiss();
                finish();

                break;

        }

    }


    private void requestPayWay() {
        showLoadingDialog("加载中...");
        PayWayGetBean payWayGetBean = new PayWayGetBean();
        payWayGetBean.setBusinessId(Constant.ZHIFU_GERENJIESUAN);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(payWayGetBean);
        Call<PayWayReqBean> payWayCall = HttpManger.getHttpMangerInstance().getServices().getPayWayByBusinessId(requestBody);
        payWayCall.enqueue(new Callback<PayWayReqBean>() {
            @Override
            public void onResponse(Call<PayWayReqBean> call, Response<PayWayReqBean> response) {
                disDialog();

                PayWayReqBean body = response.body();

                if (body != null) {

                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        List<PayWayReqBean.BringBean> payWayListBring = body.getBring();

                        if (payWayListBring != null && payWayListBring.size() > 0) {

                            ToShowPayWay(payWayListBring);

                        } else {
                            showWarnTip("未获取到支付方式");
                        }

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showWarnTip("获取失败");
                        } else {
                            showWarnTip(message);
                        }

                    }

                } else {
                    showFailTip();
                }


            }

            @Override
            public void onFailure(Call<PayWayReqBean> call, Throwable t) {
                disDialog();
                LogUtils.i(t.getMessage());
                showFailTip();
            }
        });

    }

    private void ToShowPayWay(List<PayWayReqBean.BringBean> payWayListBring) {

        Bundle bundle = new Bundle();
        bundle.putString(Constant.payWayShow, GsonUtil.GsonString(payWayListBring));
        bundle.putString(Constant.payYue, yueEMoney);

        PayBottomFragment payBottomFragment = new PayBottomFragment();
        payBottomFragment.setArguments(bundle);

        payBottomFragment.show(getSupportFragmentManager(), "payManger");


    }


    private void dailyAccountPass() {
        showLoadingDialog("确认中请稍后...");
        DailyAccountPassReqBean dailyAccountPassReqBean = new DailyAccountPassReqBean();
        dailyAccountPassReqBean.setId(itemId);
        dailyAccountPassReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(dailyAccountPassReqBean);
        Call<EmptyBringGetOilBean> dailyAccountPassCall = HttpManger.getHttpMangerInstance().getServices().dailyAccountPass(requestBody);
        dailyAccountPassCall.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();

                if (body == null) {
                    showFailTip();
                } else {

                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showShortToast("操作成功");
                        } else {
                            showShortToast(message);
                        }
                        finish();
                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("操作失败");
                        } else {
                            showInfoTip(message);
                        }

                    }


                }

                String bring = body.getBring();

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                showFailTip();
                LogUtils.i(t.getMessage());

            }
        });
    }

    private void needCheckReq(String value) {
        showLoadingDialog("请稍等...");
        NeedCheckReqBean needCheckReqBean = new NeedCheckReqBean();
        needCheckReqBean.setId(itemId);
        needCheckReqBean.setDesc(value);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(needCheckReqBean);
        Call<EmptyBringGetOilBean> dissentDailyRecord = HttpManger.getHttpMangerInstance().getServices().dissentDailyRecord(requestBody);

        dissentDailyRecord.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();

                if (body == null) {

                    showFailTip();

                } else {

                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showShortToast("操作成功");
                        } else {
                            showShortToast(message);
                        }
                        finish();
                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("操作成功");

                        } else {

                            showInfoTip(message);
                        }

                    }

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

    @Override
    public void onClickListener(SuperTextView superTextView) {

//        if (payStatus.equals("2")) {
//            return;
//        }
        switch (superTextView.getId()) {

            case R.id.balance_per_sure_order:
//已确认
                String sureOrderNum = balancePerSureOrder.getRightString();

                BigDecimal bigDecimal = new BigDecimal(sureOrderNum);

                int compareTo = bigDecimal.compareTo(BigDecimal.ZERO);

                if (compareTo == 0) {
                    showInfoTip("您暂无已确认订单");
                    return;
                }
                JieSuanDailyBalanceActivity.jieSuanActionStart(DailyBalanceDetailActivity.this, itemId, "1");

                break;
            case R.id.balance_per_unsure_order:
//                JieSuanDailyBalanceActivity.jieSuanActionStart(DailyBalanceDetailActivity.this, itemId, Constant.JIESUAN_DAI);
//              未确认

                String rightString = balancePerUnsureOrder.getRightString();

                BigDecimal decimal = new BigDecimal(rightString);

                int compareTo1 = decimal.compareTo(BigDecimal.ZERO);

                if (compareTo1 == 0) {
                    showInfoTip("您暂无待确认订单");
                    return;
                }

                JieSuanDailyBalanceActivity.jieSuanActionStart(DailyBalanceDetailActivity.this, itemId, "0");


                break;

            case R.id.balance_uncal_money_order_detail:
//账期
                String zhangqiYue = balanceUncalMoneyOrderDetail.getRightString();


                if (!TextUtils.isEmpty(zhangqiYue)) {

                    showWarnTip("您暂无账期订单");
                    return;
                }


                JieSuanDailyBalanceActivity.jieSuanActionStart(DailyBalanceDetailActivity.this, itemId, "2");

                break;
            case R.id.balance_per_finish_order:

                String finishOrder = balancePerFinishOrder.getRightString();

                BigDecimal bigDecimal2 = new BigDecimal(finishOrder);
                int compareTo2 = bigDecimal2.compareTo(BigDecimal.ZERO);
                if (compareTo2 == 0) {
                    showInfoTip("您暂无个人完成订单");
                    return;
                }
                JieSuanDailyBalanceActivity.jieSuanActionStart(DailyBalanceDetailActivity.this, itemId, "3");

                break;


        }


    }

    private String moneyNum = "0";

    @Override
    public void SendChooseData(PayWayReqBean.BringBean chooseBean, String moneyNum) {
        String payWayCode = chooseBean.getPayWayCode();
        this.moneyNum = moneyNum;
        if (payWayCode.equals(Constant.PAYWAY_UNION)) {
            getPayParams(Constant.PAYWAY_UNION, moneyNum);
        } else if (payWayCode.equals(Constant.PAYWAY_ALIPAY)) {
            getPayParams(Constant.PAYWAY_ALIPAY, moneyNum);
        } else if (payWayCode.equals(Constant.PAYWAY_WX)) {
            getPayParams(Constant.PAYWAY_WX, moneyNum);
        }

    }

    public void showSucDialog() {

        alert.show();
        detailTxt.setText("成功支付" + moneyNum + "元");

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

                                    Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                                    return;

                                }
                            }


                        } else {

                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
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

                                    Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();

                                } else {

                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                                    return;

                                }

                            }


                        } else {
                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
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

                                Toast.makeText(context, "充值失败", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

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

        LogUtils.i("parseBring: :返回tn消息:" + GsonUtil.GsonString(bring));

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

        new Alipay(context, returnStr, new Alipay.AlipayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                showSucDialog();
            }

            @Override
            public void onDealing() {
                Toast.makeText(context, "支付处理中...", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onError(int error_code) {
                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANSHIBAI);
                switch (error_code) {

                    case Alipay.ERROR_RESULT:
                        Toast.makeText(context, "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_NETWORK:
                        Toast.makeText(context, "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_PAY:
                        Toast.makeText(context, "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(context, "支付错误", Toast.LENGTH_SHORT).show();

                        break;
                }

            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "支付取消", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                showSucDialog();
            }

            @Override
            public void onError(int error_code) {

                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANSHIBAI);

                switch (error_code) {
                    case WXPay.NO_OR_LOW_WX:
                        Toast.makeText(context, "未安装微信或微信版本过低", Toast.LENGTH_SHORT).show();
                        break;

                    case WXPay.ERROR_PAY_PARAM:
                        Toast.makeText(context, "参数错误", Toast.LENGTH_SHORT).show();
                        break;

                    case WXPay.ERROR_PAY:
                        Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "支付取消", Toast.LENGTH_SHORT).show();

                sendCurrentPayState(bring.getId(), Constant.ORDER_FUKUANQUXIAO);
            }
        });
    }

    public static final int PLUGIN_NOT_INSTALLED = -1;
    public static final int PLUGIN_NEED_UPGRADE = 2;

//    private void doUnionpay(UnionParRespBean.BringBean bring) {
//
//        String model = "01"; // 测试环境
//        String returnStr = bring.getReturnStr();
//
//        if (TextUtils.isEmpty(returnStr)) {
//
//            return;
//        }
//
//        if (!TextUtils.isEmpty(bring.getModel())) {
//            model = bring.getModel();
//        }
//
////        if (!TextUtils.isEmpty(model)) {
////          String  mMode = model;
////        }
//        LogUtils.i("doUnionpay: 0正式" + model);
//        // mMode参数解释：
//        // 0 - 启动银联正式环境
//        // 1 - 连接银联测试环境
//        int ret = UPPayAssistEx.startPay(UIUtils.getContext(), null, null, returnStr, model);
//        if (ret == PLUGIN_NEED_UPGRADE || ret == PLUGIN_NOT_INSTALLED) {
//            // 需要重新安装控件
//            Log.e("控件", " plugin not found or need upgrade!!!");
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(UIUtils.getContext());
//            builder.setTitle("提示");
//            builder.setMessage("完成购买需要安装银联支付控件，是否安装？");
//
//            builder.setNegativeButton("确定",
//                    new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            UPPayAssistEx.installUPPayPlugin(UIUtils.getContext());
//                            dialog.dismiss();
//                        }
//                    });
//
//            builder.setPositiveButton("取消",
//                    new DialogInterface.OnClickListener() {
//
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            builder.create().show();
//
//        }
//        Log.e("去支付", "" + ret);
//
//    }


    private String mMode = "00";

    private void doUnionpay(UnionParRespBean.BringBean bring) {


        String returnStr = bring.getReturnStr();

        if (TextUtils.isEmpty(returnStr)) {

            return;
        }

        String model = bring.getModel();

        if (!TextUtils.isEmpty(model)) {
            mMode = model;
        }
        Log.i(TAG, "doUnionpay: 0正式" + mMode);
        // mMode参数解释：
        // 0 - 启动银联正式环境
        // 1 - 连接银联测试环境
        int ret = UPPayAssistEx.startPay(this, null, null, returnStr, mMode);
        if (ret == PLUGIN_NEED_UPGRADE || ret == PLUGIN_NOT_INSTALLED) {
            // 需要重新安装控件
            Log.e("控件", " plugin not found or need upgrade!!!");

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("完成购买需要安装银联支付控件，是否安装？");

            builder.setNegativeButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            UPPayAssistEx.installUPPayPlugin(context);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*************************************************
         * 步骤3：处理银联手机支付控件返回的支付结果
         ************************************************/
        if (data == null) {
            return;
        }

        String msg = "";
        /*
         * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
         */
        String str = data.getExtras().getString("pay_result");
        if (str.equalsIgnoreCase("success")) {

            // 如果想对结果数据验签，可使用下面这段代码，但建议不验签，直接去商户后台查询交易结果
            // result_data结构见c）result_data参数说明
            if (data.hasExtra("result_data")) {
                String result = data.getExtras().getString("result_data");
                try {
                    JSONObject resultJson = new JSONObject(result);
                    String sign = resultJson.getString("sign");
                    String dataOrg = resultJson.getString("data");
                    // 此处的verify建议送去商户后台做验签
                    // 如要放在手机端验，则代码必须支持更新证书
//                    boolean ret = verify(dataOrg, sign, 0);
//                    if (ret) {
//                        // 验签成功，显示支付结果
//                        msg = "支付成功！";
//                    } else {
//                        // 验签失败
//                        msg = "支付失败！";
//                    }
                } catch (JSONException e) {
                }
            }
            // 结果result_data为成功时，去商户后台查询一下再展示成功
            msg = "支付成功！";
            showSucDialog();
        } else if (str.equalsIgnoreCase("fail")) {
            msg = "支付失败！";
            sendCurrentPayState(doUniobring.getId(), Constant.ORDER_FUKUANSHIBAI);
            showDialogTips(msg);
        } else if (str.equalsIgnoreCase("cancel")) {
            msg = "支付取消";

            sendCurrentPayState(doUniobring.getId(), Constant.ORDER_FUKUANQUXIAO);

            showDialogTips(msg);

        }


    }

    private boolean verify(String msg, String sign64, String mode) {
        // 此处的verify，商户需送去商户后台做验签


        return true;

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
            }
        });
        builder.create().show();


    }

}
