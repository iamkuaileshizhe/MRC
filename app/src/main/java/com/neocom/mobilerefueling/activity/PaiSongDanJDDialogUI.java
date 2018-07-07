package com.neocom.mobilerefueling.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.PaiSongDanDialogAdapter;
import com.neocom.mobilerefueling.adapter.PaiSongDanShowAdapter;
import com.neocom.mobilerefueling.amap.AmapTTSController;
import com.neocom.mobilerefueling.bean.DeliveryOrderRespBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.GetCarInfoReqBean;
import com.neocom.mobilerefueling.bean.GetCarInfoRespBean;
import com.neocom.mobilerefueling.bean.JiaYouJiRespBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.bean.OilRequestBean;
import com.neocom.mobilerefueling.bean.OilResponseBean;
import com.neocom.mobilerefueling.bean.OnedeliveryIdReqBean;
import com.neocom.mobilerefueling.bean.PaiSongDanCommitBean;
import com.neocom.mobilerefueling.bean.PaiSongDanOilPriceReqBean;
import com.neocom.mobilerefueling.bean.PaiSongDanOilPriceRespBean;
import com.neocom.mobilerefueling.bean.PaisongDanItemBean;
import com.neocom.mobilerefueling.bean.RescheduReqBean;
import com.neocom.mobilerefueling.bean.RescheduRespBean;
import com.neocom.mobilerefueling.bean.TakeOrderBean;
import com.neocom.mobilerefueling.fragment.AddOilCarFragment;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.PointsConverToGD;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.EditDialog;
import com.neocom.mobilerefueling.view.ListViewWithScroll;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIDateTimeSaveListener;
import com.widget.jcdialog.listener.DialogUIListener;
import com.widget.jcdialog.widget.DateSelectorWheelView;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import me.leefeng.promptlibrary.PromptButton;
import me.leefeng.promptlibrary.PromptButtonListener;
import me.leefeng.promptlibrary.PromptDialog;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.HTTP;

/**
 * Created by admin on 2017/11/30.
 * <p>
 * 加油中的 界面 即是 已接单界面
 */

public class PaiSongDanJDDialogUI extends BaseActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, INaviInfoCallback, AddOilCarFragment.addCarCallBack {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.order_no)
    OrderConbindView orderNo;
    @BindView(R.id.caiyou_leixing)
    OrderConbindView caiyouLeixing;
    @BindView(R.id.peisong_dizhi)
    OrderConbindView peisongDizhi;
    @BindView(R.id.paidan_bianhao)
    OrderConbindView paidanBianhao;
    @BindView(R.id.paidan_ren)
    OrderConbindView paidanRen;
    @BindView(R.id.chepaihao)
    OrderConbindView chepaihao;
    @BindView(R.id.paidan_true_ren)
    OrderConbindView paidanTrueRen;
    @BindView(R.id.paidan_dianhua)
    OrderConbindView paidanDianhua;
    @BindView(R.id.shouhua_ren)
    OrderConbindView shouhuaRen;
    @BindView(R.id.shouhua_ren_shoujihao)
    OrderConbindView shouhuaRenShoujihao;
    @BindView(R.id.add_car)
    FrameLayout addCar;
    @BindView(R.id.receive_list)
    ListViewWithScroll receiveList;
    @BindView(R.id.car_lv_rl)
    LinearLayout carLvRl;
    @BindView(R.id.zong_jiayou_liang)
    OrderConbindView zongJiayouLiang;
    @BindView(R.id.jiayou_feiyong)
    OrderConbindView jiayouFeiyong;
    @BindView(R.id.order_time)
    OrderConbindView orderTime;
    //    @BindView(R.id.yuji_songda_time)
//    OrderConbindView yujiSongdaTime;
    //    @BindView(R.id.jiayou_paytype)
//    OrderConbindView jiayouPaytype;
    @BindView(R.id.jiayou_paytype_ll)
    LinearLayout jiayouPaytypeLl;
    @BindView(R.id.send_time)
    TextView sendTime;
    @BindView(R.id.com_content_choose_time)
    TextView comContentChooseTime;
    @BindView(R.id.choose_time)
    RelativeLayout chooseTime;
    @BindView(R.id.note_receive)
    EditText noteReceive;
    @BindView(R.id.pay_now)
    Button payNow;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLl;
    Gson gson;
    @BindView(R.id.all_price_money)
    TextView allPriceMoney;

    @BindView(R.id.bottom_ll_yes_no)
    LinearLayout bottomLlYesNo;
    @BindView(R.id.agree_order)
    Button agreeOrder;
    @BindView(R.id.disagree_order)
    Button disagreeOrder;
    @BindView(R.id.price_all)
    RelativeLayout priceAll;
    //    @BindView(R.id.user_sure_state)
//    OrderConbindView userSureState;
    @BindView(R.id.re_order)
    TextView reOrder;

    @BindView(R.id.add_budan)
    LinearLayout addBudan;

    @BindView(R.id.yidaochag_ll)
    LinearLayout yidaochagLl;

    @BindView(R.id.pay_type_choose)
    RadioGroup payTypeChoose;

    @BindView(R.id.rb_online_pay)
    RadioButton rbOnlinePay;
    @BindView(R.id.rb_cash_pay)
    RadioButton rbCashPay;

    @BindView(R.id.oil_all_amount)
    TextView oilAllAmount;

    public static String itemId;
    private String indentId;
    private String paiDanState;
//    private AmapTTSController amapTTSController;

    public static List<PaiSongDanCommitBean.CarListBean> addedToCommitCarList;
    public List<JiaYouJiRespBean.BringBean> readyToAdd;

    public static List<JiaYouJiRespBean.BringBean> showInDialogist;
//    public static List<OilLXGBBean.BringBean> oilType;
//    public static List<OilLXGBBean.BringBean> oilGB;
//    public Handler mHandler;

    public DeliveryOrderRespBean.BringBean mBringBean;

    //    PaiSongDanJieDanAdapter jieDanAdapter;
    PaiSongDanDialogAdapter showJDAdapter;


    PaiSongDanCommitBean paiSongDanCommitBean;


    TakeOrderBean takeBean;

    @BindView(R.id.jiayou_finish_time)
    OrderConbindView jiayouFinishTime;
    @BindView(R.id.jiayou_finish_man)
    OrderConbindView jiayouFinishMan;

    public static PaiSongDanCommitBean.CarListBean carBeanAddedTo;
    public int POSITION_EDIT = -1;
    public static String areaCode;
    private String oilPriceNow;
    public boolean canAddShow = false;
    public boolean canOnitemClick = false;

    public static boolean isTestCarNum = false;

//    private PromptDialog promptDialog;


    public static void actionStart(Context context, String id) {

        Intent intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
        intent.putExtra("itemId", id);
        context.startActivity(intent);

    }

    @Override
    public void initContentView() {
        setContentView(R.layout.pai_song_jie_dan_layout);
    }

    public static boolean isReqCarNum = true;

    @Override
    public void initView() {

        itemId = getIntent().getExtras().getString("itemId");
        indentId = getIntent().getStringExtra("indentId");
        paiDanState = getIntent().getStringExtra("dstate");
        paiSongDanCommitBean = new PaiSongDanCommitBean();
        takeBean = new TakeOrderBean();
        addedToCommitCarList = new ArrayList<>();
        showInDialogist = new ArrayList<>();
        readyToAdd = new ArrayList<>();
        gson = new Gson();
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addCar.setOnClickListener(this);
//        jiayouPaytype.setOnClickListener(this);
//        jiayouPaytype.setTitle("支付方式");
//        jiayouPaytype.setContet("在线支付");
//        paiSongDanCommitBean.setPayType(Constant.PAY_ONLINE); // 1
        paiSongDanCommitBean.setPayType(Constant.PAY_CASH); // 1
//        userSureState.setTitle("确认状态");

        receiveList.setOnItemLongClickListener(this);
        payNow.setOnClickListener(this);
        agreeOrder.setOnClickListener(this);
        disagreeOrder.setOnClickListener(this);
        addBudan.setOnClickListener(this);
        reOrder.setOnClickListener(this);
        yidaochagLl.setOnClickListener(this);
// SpeechUtils.getInstance(this).speakText();系统自带的语音播报
//        amapTTSController = AmapTTSController.getInstance(getApplicationContext());
//        amapTTSController.init();

        getDataFromServer();


        showJDAdapter = new PaiSongDanDialogAdapter();
        receiveList.setAdapter(showJDAdapter);


        receiveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (canOnitemClick) {
                    POSITION_EDIT = position;
                    carBeanAddedTo = showJDAdapter.getItem(position);
                    isTestCarNum = false;
                    isReqCarNum = false;
                    CallAddoilDialog();
                } else {
                    return;
                }


            }
        });


        payTypeChoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                RadioButton radioButton = group.findViewById(checkedId);

                switch (checkedId) {

                    case R.id.rb_online_pay:


//                        jiayouPaytype.setContet("在线支付");
                        paiSongDanCommitBean.setPayType(Constant.PAY_ONLINE);

//                        Toast.makeText(PaiSongDanJDDialogUI.this, "在线支付", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rb_cash_pay:


//                        Toast.makeText(PaiSongDanJDDialogUI.this, "现金支付", Toast.LENGTH_SHORT).show();
                        paiSongDanCommitBean.setPayType(Constant.PAY_CASH);

                        break;


                }


            }
        });

        jiayouFinishTime.setTitle("加油完成时间");
        jiayouFinishMan.setTitle("加油完成人");

//        getCYLXFromServer();
//        getGBFromServer();

//        naviToDes();

//        initDialog();
    }


    private void naviToDes(final String deliveryAddress, final String addressCoor) {

        peisongDizhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LatLng latLng;

                if (TextUtils.isEmpty(addressCoor)) {
                    Toasty.error(PaiSongDanJDDialogUI.this, "获取坐标点有误", Toast.LENGTH_SHORT, true).show();
                    return;
                } else {
                    String[] split = addressCoor.split(",");
                    String jingDuStr = split[0];
                    String weiDuStr = split[1];

                    double jingDuDb = Double.parseDouble(jingDuStr);
                    double weiDuDb = Double.parseDouble(weiDuStr);

                    latLng = PointsConverToGD.convetToGD(PaiSongDanJDDialogUI.this, new LatLng(weiDuDb, jingDuDb));

                    Log.i(TAG, "onClick: 转转后坐标==》" + new Gson().toJson(latLng) + "；；qian" + addressCoor);
                }

                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), new AmapNaviParams(null, null, new Poi(deliveryAddress, latLng, ""), AmapNaviType.DRIVER), PaiSongDanJDDialogUI.this);


            }
        });


    }


    private void getCarInfoByCarNum() {

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo != null) {

//            String carNum = userInfo.getCarNum();
            String carNum = SPUtils.getSaveCar();

            getCarInfoFromServer(carNum);

        } else {

            Toasty.error(PaiSongDanJDDialogUI.this, "获取车辆信息失败", Toast.LENGTH_SHORT, true).show();

        }


    }

    PaisongDanItemBean.BringBean mOilTypeStand;

    private void getCarInfoFromServer(String carNumStr) {


        carNum carNum = new carNum();
        carNum.setCarNum(carNumStr);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carNum);
        HttpManger.getHttpMangerInstance().getServices().findOilTypeByCarNum(requestBody).enqueue(new Callback<PaisongDanItemBean>() {
            @Override
            public void onResponse(Call<PaisongDanItemBean> call, Response<PaisongDanItemBean> response) {
                disDialog();
                PaisongDanItemBean body = response.body();

                if (body != null) {
                    PaisongDanItemBean.BringBean bring = body.getBring();

                    if (bring != null) {

//                        parseItemBean(bring);

                        mOilTypeStand = bring;

//                        getoilPriceByOilTypeStand();

                    } else {

                        String message = body.getMessage();

                        if (TextUtils.isEmpty(message)) {

                            Toasty.error(PaiSongDanJDDialogUI.this, "获取加油车信息失败", Toast.LENGTH_SHORT, true).show();
                            return;

                        } else {

                            Toasty.error(PaiSongDanJDDialogUI.this, message, Toast.LENGTH_SHORT, true).show();
                            return;

                        }

                    }

                } else {
                    Toasty.error(PaiSongDanJDDialogUI.this, "获取加油车信息失败", Toast.LENGTH_SHORT, true).show();
                    return;

                }

            }

            @Override
            public void onFailure(Call<PaisongDanItemBean> call, Throwable t) {
                disDialog();
                Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
                return;
            }
        });


    }

//    /**
//     * 根据 地区 加油类型 国标 获取 油价
//     */
//    private void getoilPriceByOilTypeStand() {
//
//        if (mBringBean != null) {
//
////            findOilPrice
//            areaCode = mBringBean.getAreaCode();
//            PaiSongDanOilPriceReqBean priceReqBean = new PaiSongDanOilPriceReqBean();
//            priceReqBean.setUserId(mBringBean.getC_user());
//
//            priceReqBean.setArea(areaCode);
//            priceReqBean.setNationalStandard(mOilTypeStand.getNationalStandard());
//            priceReqBean.setOilType(mOilTypeStand.getOilType());
//            Log.i(TAG, "getoilPriceByOilTypeStand: ==============>>>" + new Gson().toJson(priceReqBean));
//            RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(priceReqBean);
//
//            HttpManger.getHttpMangerInstance().getServices().findOilPrice(requestBody).enqueue(new Callback<PaiSongDanOilPriceRespBean>() {
//                @Override
//                public void onResponse(Call<PaiSongDanOilPriceRespBean> call, Response<PaiSongDanOilPriceRespBean> response) {
//                    PaiSongDanOilPriceRespBean body = response.body();
//                    if (body != null) {
//
//                        PaiSongDanOilPriceRespBean.BringBean bring = body.getBring();
//
//                        if (bring != null) {
//
//                            oilPriceNow = bring.getOilPrice();
//
//                        }
//
//
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<PaiSongDanOilPriceRespBean> call, Throwable t) {
//
//                }
//            });
//
//
//        } else {
//            disDialog();
//            Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
//            return;
//        }
//
//
//    }


//    private void parseItemBean(final PaisongDanItemBean.BringBean bring) {
//
//        if (mBringBean != null) {
//
//            OilRequestBean oilRequestBean = new OilRequestBean();
//
//            areaCode = mBringBean.getAreaCode();
//
//            oilRequestBean.setArea(areaCode);
////            oilRequestBean.setArea("370000");
//            oilRequestBean.setNationalStandard(bring.getNationalStandard());
//            oilRequestBean.setOilType(bring.getOilType());
//            oilRequestBean.setTime(UIUtils.getCurrentTime());
//
//            RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(oilRequestBean);
//            HttpManger.getHttpMangerInstance().getServices().findOilpriceByArea(requestBody).enqueue(new Callback<OilResponseBean>() {
//                @Override
//                public void onResponse(Call<OilResponseBean> call, Response<OilResponseBean> response) {
//                    disDialog();
//                    OilResponseBean body = response.body();
//
//                    if (body != null) {
//
//                        OilResponseBean.BringBean bodyBring = body.getBring();
//
//                        if (bodyBring != null) {
//
//                            String oilPrice = bodyBring.getOilPrice();
//
////                            addToItem(bring, oilPrice);
//
//
//                            PaiSongDanCommitBean.CarListBean carListBean = new PaiSongDanCommitBean.CarListBean();
//
//                            carListBean.setFinishTime(UIUtils.getCurrentTime());
//                            carListBean.setOilType(bring.getOilType());
//                            carListBean.setNationalStandard(bring.getNationalStandard());
//                            carListBean.setOilBalance(oilPrice);
//
//                            showDialogToAdd(carListBean);
//
//
//                        } else {
//                            disDialog();
//
////                            String message = body.getMessage();
////
////                            if (TextUtils.isEmpty(message)) {
////                                Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
////                            } else {
////                                Toasty.error(PaiSongDanJDDialogUI.this, message, Toast.LENGTH_SHORT, true).show();
////                            }
//                            addEmptyItem();
//                            return;
//
//                        }
//
//
//                    } else {
//
//                        disDialog();
//                        Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
//                        return;
//
//                    }
//
//
//                }
//
//                @Override
//                public void onFailure(Call<OilResponseBean> call, Throwable t) {
//                    disDialog();
//                    Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
//                    return;
//                }
//            });
//
//
//        } else {
//            disDialog();
//            Toasty.error(PaiSongDanJDDialogUI.this, "添加失败", Toast.LENGTH_SHORT, true).show();
//            return;
//        }
//
//
//    }


//    //    添加一辆空车
//    public void addEmptyItem() {
//
//        carBeanAddedTo = new PaiSongDanCommitBean.CarListBean();
//
//        carBeanAddedTo.setFinishTime(UIUtils.getCurrentTime());
//        carBeanAddedTo.setOilType("");
//        carBeanAddedTo.setOilTypeName("");
//        carBeanAddedTo.setNationalStandardName("");
//        carBeanAddedTo.setNationalStandard("");
//        carBeanAddedTo.setOilBalance("");
//        carBeanAddedTo.setDocType(Constant.DOCTYPE_NORMAL);
//        CallAddoilDialog();
////        AddOilCarFragment addOilCarFragment = new AddOilCarFragment();
////        addOilCarFragment.show(getSupportFragmentManager(), "addOilCarFragment");
//
//    }


    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


//    private void getCYLXFromServer() {
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(new EmBody());
//
//        HttpManger.getHttpMangerInstance().getServices().findAllCYLX(requestBody).enqueue(new Callback<OilLXGBBean>() {
//            @Override
//            public void onResponse(Call<OilLXGBBean> call, Response<OilLXGBBean> response) {
//                Log.i(TAG, "onResponse: 请求柴油类型返回");
//
//
//                OilLXGBBean body = response.body();
//                if (body != null) {
//                    List<OilLXGBBean.BringBean> bring = body.getBring();
//                    if (bring != null) {
//                        oilType = bring;
//
////                        LOAD_TYPE_STATE = true;
////                        handler.sendEmptyMessage(100);
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<OilLXGBBean> call, Throwable t) {
////                Log.i(TAG, "onFailure: 返回柴油类型失败");
////                Toasty.error(PaiSongDanJDDialogUI.this, "返回柴油类型失败", Toast.LENGTH_SHORT, true).show();
//                return;
//            }
//        });
//    }


//    private void getGBFromServer() {
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(new EmBody());
//        HttpManger.getHttpMangerInstance().getServices().findAllGB(requestBody).enqueue(new Callback<OilLXGBBean>() {
//            @Override
//            public void onResponse(Call<OilLXGBBean> call, Response<OilLXGBBean> response) {
//                OilLXGBBean body = response.body();
//                if (body != null) {
//                    List<OilLXGBBean.BringBean> bring = body.getBring();
//                    if (bring != null) {
//                        oilGB = body.getBring();
////                        LOAD_GB_STATE = true;
////                        handler.sendEmptyMessage(101);
//                    }
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<OilLXGBBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: 返回失败");
//            }
//        });
//    }

    @Override
    public void SendOilCarData(PaiSongDanCommitBean.CarListBean carBean) {
        Log.i(TAG, "SendOilCarData: 333333333==" + new Gson().toJson(carBean));

        carBeanAddedTo = carBean;

        if (POSITION_EDIT == -1) {
            addedToCommitCarList.add(carBeanAddedTo);
            showJDAdapter.notifyDataSetChanged();
            calAllMoney();
        } else {
            PaiSongDanCommitBean.CarListBean showJDAdapterItem = showJDAdapter.getItem(POSITION_EDIT);
            showJDAdapterItem.setTelphone(carBeanAddedTo.getTelphone());
            showJDAdapterItem.setTankSize(carBeanAddedTo.getTankSize());
            showJDAdapterItem.setOilType(carBeanAddedTo.getOilType());
            showJDAdapterItem.setOilBalance(carBeanAddedTo.getOilBalance());
            showJDAdapterItem.setOilBalance_show(carBeanAddedTo.getOilBalance_show());
            showJDAdapterItem.setOilTotal(carBeanAddedTo.getOilTotal());
            showJDAdapterItem.setOilTotal_show(carBeanAddedTo.getOilTotal_show());
            showJDAdapterItem.setNationalStandard(carBeanAddedTo.getNationalStandard());
            showJDAdapterItem.setPName(carBeanAddedTo.getPName());
            showJDAdapterItem.setVehicleCode(carBeanAddedTo.getVehicleCode());
            showJDAdapterItem.setFinishTime(carBeanAddedTo.getFinishTime());
            showJDAdapterItem.setSettleUnit(carBeanAddedTo.getSettleUnit());
            showJDAdapter.notifyDataSetChanged();
            calAllMoney();
        }


    }


    public class EmBody {


    }

    DeliveryOrderRespBean.BringBean oilSettUniteBring = new DeliveryOrderRespBean.BringBean();

    public void getDataFromServer() {
        showLoadingDialog("数据加载中");
        CarId carId = new CarId();
        carId.setId(itemId);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(carId));

        Call<DeliveryOrderRespBean> call = HttpManger.getHttpMangerInstance().getServices().getDeliveryOrderById(requestBody);

        call.enqueue(new Callback<DeliveryOrderRespBean>() {
            @Override
            public void onResponse(Call<DeliveryOrderRespBean> call, Response<DeliveryOrderRespBean> response) {

//                DeliveryOrderRespBean.BringBean bringBean = response.body().getBring();
                disDialog();
                DeliveryOrderRespBean body = response.body();


                if (body != null) {


                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {
                        DeliveryOrderRespBean.BringBean bring = body.getBring();
                        oilSettUniteBring = bring;
                        if (bring != null) {
                            processData(bring);
                        }


                    } else {

                        if (!TextUtils.isEmpty(message)) {
                            showMyDialog(message);
                        }

                    }


                } else {
                    showMyDialog("数据加载异常");
                }

            }

            @Override
            public void onFailure(Call<DeliveryOrderRespBean> call, Throwable t) {
                disDialog();
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
            }
        });


    }


    //    Gson gson;
    MenuBean menuBean;
    List<MenuBean.BringBean> menuItems;

    public boolean menuEqualServer(String menu) {

        if (gson == null) {
            gson = new Gson();
        }

        if (menuBean == null) {
            menuBean = gson.fromJson(GetUserInfoUtils.getMenu(), MenuBean.class);
        }
        if (menuItems == null || menuItems.size() == 0) {
            menuItems = menuBean.getBring();
        }


        Log.i(TAG, "menuEqualServer: " + new Gson().toJson(menuItems));

        for (int i = 0; i < menuItems.size(); i++) {

            String code = menuItems.get(i).getCode();

            if (code.equals(menu)) {
//                Log.i(TAG, "menuEqualServer:内 " + code + ";menu;" + menu + "->" + i);
                return true;
            }
//            Log.i(TAG, "menuEqualServer: 外" + code + ";menu;" + menu + "->" + i);
        }


        return false;
    }


    private void processData(DeliveryOrderRespBean.BringBean bringBean) {
        Log.i(TAG, "processData: ==>" + new Gson().toJson(bringBean));

        mBringBean = bringBean;


        jiayouFinishMan.setContet(bringBean.getFinishPerson());
        jiayouFinishTime.setContet(bringBean.getFinishTime());


        String payType = bringBean.getPayType();

        if (!TextUtils.isEmpty(payType)) {

            //        线上支付
            if (payType.equals("1")) {
                rbOnlinePay.setChecked(true);
            } else {
                rbCashPay.setChecked(true);
            }

        }

        String c_user = bringBean.getC_user();
        if (TextUtils.isEmpty(c_user)) {
            c_user = "";
        }
        SPUtils.saveContent(Constant.SP_C_USER, c_user);

//        getCarInfoByCarNum(); // 去获取加油车车辆信息

        final String deliveryAddress = bringBean.getDeliveryAddress();
        final String addressCoor = bringBean.getAddressCoor();

        naviToDes(deliveryAddress, addressCoor);

        String dstate = bringBean.getDstate();
        if (dstate.equals(Constant.JD_DAIJIEDAN)) {
//    只显示 是否接单
//    可选时间
//    隐匿加号

            boolean b = menuEqualServer(Constant.MENU_BUSI_ORDER_PICKUP);
            LogUtils.i("processData: ===========" + b);
            if (b) {
                bottomLlYesNo.setVisibility(View.VISIBLE);
                chooseTime.setVisibility(View.VISIBLE);
            }

            canOnitemClick = false;
            chooseTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    {
                        DialogUtils.showDatePick(PaiSongDanJDDialogUI.this, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMM, 0, new DialogUIDateTimeSaveListener() {
                            @Override
                            public void onSaveSelectedDate(int tag, String selectedDate) {

                                comContentChooseTime.setText(selectedDate);
                                takeBean.setEstimateArrivalTime(selectedDate);
                            }
                        }).show();
                    }


                }
            });


        }
        if (dstate.equals(Constant.JD_YIJIEDAN)) {
//    只显示 提交订单
//    可选时间
//    显示加号


            /**
             * 新增 已到场 状态
             */
            reOrder.setVisibility(View.VISIBLE);// 订单调度 显示
            yidaochagLl.setVisibility(View.VISIBLE);


        }

//        新增 待支付 状态

        if (dstate.equals(Constant.JD_YIDAOCHANG)) {

            getCarInfoByCarNum(); // 去获取加油车车辆信息


            boolean b = menuEqualServer(Constant.MENU_BUSI_ORDER_FINISH);
            if (b) {

                priceAll.setVisibility(View.VISIBLE);
                carLvRl.setVisibility(View.VISIBLE);

            }

            canAddShow = true;
            canOnitemClick = true;
            addCar.setVisibility(View.VISIBLE);
            bottomLl.setVisibility(View.VISIBLE);

            reOrder.setVisibility(View.VISIBLE);// 订单调度 显示

//            jiayouPaytype.setVisibility(View.VISIBLE);
            jiayouPaytypeLl.setVisibility(View.VISIBLE);


        }

//
        if (dstate.equals(Constant.JD_DAIZHIFU) || dstate.equals(Constant.JD_DAIQUEREN)) {

            getCarInfoByCarNum(); // 去获取加油车车辆信息
            payNow.setText("重新提交");

            boolean b = menuEqualServer(Constant.MENU_BUSI_ORDER_FINISH);
            if (b) {

                priceAll.setVisibility(View.VISIBLE);
                carLvRl.setVisibility(View.VISIBLE);

            }

            canAddShow = true;
            canOnitemClick = true;
            addCar.setVisibility(View.VISIBLE);
            bottomLl.setVisibility(View.VISIBLE);

            reOrder.setVisibility(View.GONE);// 订单调度 显示
            jiayouPaytypeLl.setVisibility(View.VISIBLE);

            addBudan.setVisibility(View.VISIBLE);
            List<DeliveryOrderRespBean.BringBean.CarListBean> carList = bringBean.getCarList();

            LogUtils.i("--->" + GsonUtil.GsonString(carList));

            if (carList != null && carList.size() > 0) {

                PaiSongDanShowAdapter showAdapter = new PaiSongDanShowAdapter(carList);
                showJDAdapter = new PaiSongDanDialogAdapter();

                LogUtils.i("------>显示");

                receiveList.setAdapter(showJDAdapter);


                for (int i = 0; i < carList.size(); i++) {

                    DeliveryOrderRespBean.BringBean.CarListBean carListBeanItemData = carList.get(i);

                    LogUtils.d("carListBeanItemData==添加显示的==" + new Gson().toJson(carListBeanItemData));

                    PaiSongDanCommitBean.CarListBean addToShowItem = new PaiSongDanCommitBean.CarListBean();

                    addToShowItem.setTelphone(carListBeanItemData.getTelphone());
                    addToShowItem.setTankSize(carListBeanItemData.getTankSize());
                    addToShowItem.setTankSize_show(carListBeanItemData.getTankSize_show());
                    addToShowItem.setOilType(carListBeanItemData.getOilType());
                    addToShowItem.setOilTypeName(carListBeanItemData.getOilTypeName());
                    addToShowItem.setOilBalance(carListBeanItemData.getOilBalance());
                    addToShowItem.setOilBalance_show(carListBeanItemData.getOilBalance_show());
                    addToShowItem.setOilTotal(carListBeanItemData.getOilTotal());
                    addToShowItem.setOilTotal_show(carListBeanItemData.getOilTotal_show());
                    addToShowItem.setNationalStandard(carListBeanItemData.getNationalStandard());
                    addToShowItem.setNationalStandardName(carListBeanItemData.getNationalStandardName());
                    addToShowItem.setPName(carListBeanItemData.getPName());
                    addToShowItem.setVehicleCode(carListBeanItemData.getVehicleCode());
                    addToShowItem.setFinishTime(carListBeanItemData.getFinishTime());
                    addToShowItem.setDocType(carListBeanItemData.getDocType());
                    addToShowItem.setSettleUnit(carListBeanItemData.getSettleUnit());

                    addedToCommitCarList.add(addToShowItem);
                }
                showJDAdapter.notifyDataSetChanged();
                calAllMoney();

            } else {

                LogUtils.i("------>不显示");
                carLvRl.setVisibility(View.GONE);
                canAddShow = false;
            }


            noteReceive.setFocusable(false);
            noteReceive.setFocusableInTouchMode(false);


            String remark = bringBean.getRemark();
            if (TextUtils.isEmpty(remark)) {
                noteReceive.setText("无备注");
            } else {
                noteReceive.setText(remark);
            }


            calAllMoney();

        }


//|| dstate.equals(Constant.JD_DAIZHIFU) 有 待支付 后来让调走了
        if (dstate.equals(Constant.JD_YIWANCHENG) || dstate.equals(Constant.JD_YIJUJUE) || dstate.equals(Constant.JD_YIQUEREN)) {
//    不能选择时间
//    没有 是否接单 按钮
//    没有 提交按钮
//
//隐匿加号

//            userSureState.setVisibility(View.VISIBLE);
//            userSureState.setContet(GetOrderStateUtil.getPaiSonDanState(bringBean.getDstate()));

            if (dstate.equals(Constant.JD_YIWANCHENG)) {

                jiayouFinishTime.setVisibility(View.VISIBLE);
                jiayouFinishMan.setVisibility(View.VISIBLE);

            }

            addCar.setVisibility(View.INVISIBLE);
            carLvRl.setVisibility(View.VISIBLE);
            addBudan.setVisibility(View.INVISIBLE);
            canAddShow = false;
            canOnitemClick = false;
            List<DeliveryOrderRespBean.BringBean.CarListBean> carList = bringBean.getCarList();

            if (carList != null && carList.size() > 0) {

                PaiSongDanShowAdapter showAdapter = new PaiSongDanShowAdapter(carList);
                receiveList.setAdapter(showAdapter);

            } else {
                carLvRl.setVisibility(View.GONE);
                canAddShow = false;
            }

            noteReceive.setFocusable(false);
            noteReceive.setFocusableInTouchMode(false);


            String remark = bringBean.getRemark();
            if (TextUtils.isEmpty(remark)) {
                noteReceive.setText("无备注");
            } else {
                noteReceive.setText(remark);
            }


        }

        if (dstate.equals("10")) {

//            userSureState.setVisibility(View.VISIBLE);
//            userSureState.setContet(GetOrderStateUtil.getPaiSonDanState(bringBean.getDstate()));
            String remark = bringBean.getRemark();
            if (TextUtils.isEmpty(remark)) {
                noteReceive.setText("无备注");
            } else {
                noteReceive.setText(remark);
            }
            noteReceive.setFocusable(false);
            noteReceive.setFocusableInTouchMode(false);


        }


        orderNo.setTitle("订单号");
        orderNo.setContet(bringBean.getIndentCode());
        orderTime.setTitle("下单时间");
        orderTime.setContet(bringBean.getOrderTime());

        caiyouLeixing.setTitle(bringBean.getNationalStandardName() + bringBean.getOilTypeName());
        caiyouLeixing.setContet(bringBean.getOilAmount());
        peisongDizhi.setTitle("配送地址");
        peisongDizhi.setContet(bringBean.getDeliveryAddress());

        paidanBianhao.setTitle("派送单编号");
        paidanBianhao.setContet(bringBean.getDeliveryCode());

        paidanTrueRen.setTitle("派单人");
        paidanTrueRen.setContet(bringBean.getDeliveryName());

        paidanRen.setTitle("预约时间");
        chepaihao.setTitle("车牌号");
        chepaihao.setContet(bringBean.getCarNum());
//        estimateTime
        String estimateTime = bringBean.getEstimateTime();
        LogUtils.i("processData: =========" + estimateTime + "");
        if (TextUtils.isEmpty(estimateTime)) {
            paidanRen.setContet("尽快送达");
        } else {
            paidanRen.setContet(estimateTime);
        }


        paidanDianhua.setTitle("派单人电话");
        paidanDianhua.setContet(bringBean.getTelphone());
//        yujiSongdaTime.setTitle("预计送达时间");
//        yujiSongdaTime.setContet(bringBean.getEstimateArrivalTime());


        shouhuaRen.setTitle("收货人");
        shouhuaRen.setContet(bringBean.getReceiverName());
        shouhuaRenShoujihao.setTitle("收货人手机号");
        shouhuaRenShoujihao.setContet(bringBean.getOrderTel());

        zongJiayouLiang.setTitle("车牌号");
        zongJiayouLiang.setContet(bringBean.getCarNum());

        jiayouFeiyong.setTitle("送货人");
        jiayouFeiyong.setContet(bringBean.getDeliveryName());

//        String remark = bringBean.getRemark();
//        if (TextUtils.isEmpty(remark)) {
//            noteReceive.setText("无备注");
//        }else {
//            noteReceive.setText(remark);
//        }

//        要提交的数据
        String u_user = bringBean.getU_user();
        if (TextUtils.isEmpty(u_user)) {
            paiSongDanCommitBean.setU_user("");
        } else {
            paiSongDanCommitBean.setU_user(u_user);
        }

        String remarkStr = noteReceive.getText().toString();

        if (TextUtils.isEmpty(remarkStr)) {

            paiSongDanCommitBean.setRemark("");

        } else {
            paiSongDanCommitBean.setRemark(remarkStr);
        }

        paiSongDanCommitBean.setId(bringBean.getId());


        String commitId = bringBean.getId();
        takeBean.setId(commitId);
        String commitIndentId = bringBean.getIndentId();
        takeBean.setIndentId(commitIndentId);


    }

    public void showMyDialog(String msg) {
//"订单提交成功"

        DialogUtils.showAlert(this, "提示", msg, "", "", "我知道了", "", true, new DialogUIListener() {
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


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_car:

                isTestCarNum = true;
                POSITION_EDIT = -1;


//                AddDataToItem();

//不是 补单 是 直接添加
                AddOneDataItemByDialog(false);


                break;


            case R.id.pay_now:

                commitPaiSongDan();
                break;


            case R.id.agree_order:

                String arrivalTime = takeBean.getEstimateArrivalTime();

                if (arrivalTime == null) {

                    Toasty.info(PaiSongDanJDDialogUI.this, "请选择时间", Toast.LENGTH_SHORT, true).show();
                    return;

                }

                long timeCurrent = System.currentTimeMillis();
                String chooseTimeStamp = CommonUtil.dateToStamp(arrivalTime);


                LogUtils.d("当前时间；" + timeCurrent + "；选择时间" + chooseTimeStamp);

                BigDecimal currentDecimal = new BigDecimal(timeCurrent);

                BigDecimal chooseTime = new BigDecimal(chooseTimeStamp);


                int compareTo = currentDecimal.compareTo(chooseTime);

                if (compareTo == 1) {

//                    当前时间大，不可以通过

                    showWarnTip("所选时间小于当前时间");

                    return;

                }
//
//                else {
////相等和超过当前时间 都可以
////                    处理通过
//
//
//                }


                String noteReceiveS = noteReceive.getText().toString().trim();

//                takeBean.setId(itemId);
                takeBean.setDstate("1"); // 同意
//                takeBean.setIndentId(indentId);
//                takeBean.setEstimateArrivalTime(timeChoose);

                if (TextUtils.isEmpty(noteReceiveS)) {
                    takeBean.setRemark("");
                } else {
                    takeBean.setRemark(noteReceiveS);
                }
                takeBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());


                commitAgreeAbleOrder(takeBean);
                break;
            case R.id.disagree_order:

                //                拒绝
                String noteReceiveStr = noteReceive.getText().toString().trim();

                if (TextUtils.isEmpty(noteReceiveStr)) {
                    Toast.makeText(this, "请填写备注", Toast.LENGTH_SHORT).show();
                    return;
                }

// 拒绝 订单
//                takeBean.setId(itemId);
                takeBean.setDstate("2"); //拒绝
//                takeBean.setIndentId(indentId);
//                takeBean.setEstimateArrivalTime("");
                takeBean.setRemark(noteReceiveStr);
                takeBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());


                commitAgreeAbleOrder(takeBean);
                break;

            case R.id.add_budan:
//是 补单
                isReqCarNum = true;
                isTestCarNum = true;
                AddOneDataItemByDialog(true);
                break;
            case R.id.re_order:
//重新调度

                showToAskReLoad();

                break;
            case R.id.yidaochag_ll:
//重新调度

                showToAskYiDaoChang("确认已到场");


                break;


        }
    }


    private PromptDialog promptAskDialog;

    public void showToAskYiDaoChang(String msg) {


        if (promptAskDialog == null) {
            //创建对象
            promptAskDialog = new PromptDialog(this);
            //设置自定义属性
            promptAskDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);
        }

        //按钮的定义，创建一个按钮的对象
        PromptButton confirm = new PromptButton("确定", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
//                Toast.makeText(BaseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
//                finish();

                AlreadyArrival();

            }
        });
        confirm.setTextColor(Color.parseColor("#DAA520"));
        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件

        PromptButton cancleBtn = new PromptButton("取消", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
//                Toast.makeText(BaseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        promptAskDialog.showWarnAlert(msg, confirm, cancleBtn);


    }

    private void AlreadyArrival() {
        showLoadingDialog("确认中...");
        OnedeliveryIdReqBean idReqBean = new OnedeliveryIdReqBean();
        idReqBean.setDeliveryId(itemId);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(idReqBean);
        HttpManger.getHttpMangerInstance().getServices().driverConfirm(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                disDialog();

                EmptyBringGetOilBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {

                            showInfoTip("确认成功");
                        } else {
                            showInfoTip(message);
                        }

                        finish();
//                        getDataFromServer();

                    } else {
                        if (TextUtils.isEmpty(message)) {

                            showInfoTip("确认失败");
                        } else {
                            showInfoTip(message);
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                LogUtils.i(t.getMessage());
                showWarnTip("连接异常");

            }
        });

    }


    private void showToAskReLoad() {


        EditDialog editDialog = new EditDialog(this);
        editDialog.show();
        editDialog.setOnPosNegClickListener(new EditDialog.OnPosNegClickListener() {
            @Override
            public void posClickListener(String value) {
//                Toast.makeText(PaiSongDanJDDialogUI.this, "确定", Toast.LENGTH_SHORT).show();
                LogUtils.i(value);

                reScheduleDeliveryOrder(value);

            }

            @Override
            public void negCliclListener(String value) {
//                Toast.makeText(PaiSongDanJDDialogUI.this, "取消", Toast.LENGTH_SHORT).show();
                LogUtils.i(value);
            }
        });


    }

    private void reScheduleDeliveryOrder(String reschedule) {
        showLoadingDialog("调度数据提交中...");
        RescheduReqBean reqBean = new RescheduReqBean();
        reqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        reqBean.setDeliveryId(itemId);
        reqBean.setRemark(reschedule);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqBean);
        HttpManger.getHttpMangerInstance().getServices().reScheduleDeliveryOrder(requestBody).enqueue(new Callback<RescheduRespBean>() {
            @Override
            public void onResponse(Call<RescheduRespBean> call, Response<RescheduRespBean> response) {
                disDialog();

                RescheduRespBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();
                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("调度成功");
                        } else {
                            showInfoTip(message);
                        }
                        finish();

                    } else {
                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("调度失败");
                        } else {
                            showInfoTip(message);
                        }

                    }

                }


            }

            @Override
            public void onFailure(Call<RescheduRespBean> call, Throwable t) {
                disDialog();
                showWarnTip("调度异常");
                LogUtils.i(t.getMessage());

            }
        });

    }


    /**
     * @param isBuDan 是不是补单 功能
     */
//    private void AddOneDataItemByDialog(String docType) {
    private void AddOneDataItemByDialog(boolean isBuDan) {

        if (mOilTypeStand == null) {
            Toasty.error(PaiSongDanJDDialogUI.this, "获取油品类型中...", Toast.LENGTH_SHORT, true).show();
            return;
        }
//        if (TextUtils.isEmpty(oilPriceNow)) {
//            Toasty.error(PaiSongDanJDDialogUI.this, "价格获取中，请稍后重试...", Toast.LENGTH_SHORT, true).show();
//            return;
//        }


        carBeanAddedTo = new PaiSongDanCommitBean.CarListBean();

        carBeanAddedTo.setOilType(mOilTypeStand.getOilType());
        carBeanAddedTo.setOilTypeName(mOilTypeStand.getOilTypeName());
        carBeanAddedTo.setNationalStandardName(mOilTypeStand.getNationalStandardName());
        carBeanAddedTo.setNationalStandard(mOilTypeStand.getNationalStandard());
        String settleUnit = oilSettUniteBring.getSettleUnit();
        if (TextUtils.isEmpty(settleUnit)) {
            carBeanAddedTo.setSettleUnit("0");
        } else {
            carBeanAddedTo.setSettleUnit(oilSettUniteBring.getSettleUnit());
        }


        ///////////////////////////////////////////////////////

//        carBeanAddedTo.setOilBalance(oilPriceNow);
//
        ///////////////////////////////////////////////////////
//        carBeanAddedTo.setDocType(docType);

        if (isBuDan) {
            carBeanAddedTo.setDocType(Constant.DOCTYPE_BUDAN);
            carBeanAddedTo.setFinishTime("");
        } else {
            carBeanAddedTo.setDocType(Constant.DOCTYPE_NORMAL);
            carBeanAddedTo.setFinishTime(UIUtils.getCurrentTime());
        }

        CallAddoilDialog();

    }


    public void commitPaiSongDan() {
//        paiSongDanCommitBean
        List<PaiSongDanCommitBean.CarListBean> carList = paiSongDanCommitBean.getCarList();
        if (carList == null || carList.size() == 0) {
            Toasty.info(PaiSongDanJDDialogUI.this, "您还没有添加加油车辆", Toast.LENGTH_SHORT, true).show();
            return;
        }


        String payType = paiSongDanCommitBean.getPayType();


        if (payType == null) {
            Toasty.info(PaiSongDanJDDialogUI.this, "请选择支付方式", Toast.LENGTH_SHORT, true).show();
            return;
        }

        paiSongDanCommitBean.setU_user(GetUserInfoUtils.getUserInfo().getUserId());
//        paiSongDanCommitBean.setFinishPerson(GetUserInfoUtils.getUserInfo().getUserId());
        showLoadingDialog("提交中...");

        Double oilAmount = 0.00;
        for (int i = 0; i < carList.size(); i++) {

            carList.get(i).setNationalStandardName(null);
            carList.get(i).setOilTypeName(null);


        }


        Log.i(TAG, "commitPaiSongDan: 提交JSON" + new Gson().toJson(paiSongDanCommitBean));
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(paiSongDanCommitBean);

        HttpManger.getHttpMangerInstance().getServices().submitDeliveryOrder(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();


                boolean res = body.isRes();

                String message1 = body.getMessage();

                if (res) {


                    if (TextUtils.isEmpty(message1)) {
                        Toasty.info(PaiSongDanJDDialogUI.this, "提交成功", Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.info(PaiSongDanJDDialogUI.this, message1, Toast.LENGTH_SHORT, true).show();
                    }

                    finish();


                } else {
                    if (TextUtils.isEmpty(message1)) {
                        Toasty.info(PaiSongDanJDDialogUI.this, "提交失败", Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.info(PaiSongDanJDDialogUI.this, message1, Toast.LENGTH_SHORT, true).show();
                    }

                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                Toasty.info(PaiSongDanJDDialogUI.this, "提交失败", Toast.LENGTH_SHORT, true).show();
                return;

            }
        });

    }


    public void commitAgreeAbleOrder(TakeOrderBean takeBean) {
        showLoadingDialog("提交中...");
        String toJson = gson.toJson(takeBean);
        Log.i(TAG, "commitAgreeAbleOrder:提交的数据 " + toJson);

        RequestBody requestBody = RequestBody.create(MediaType.parse(Constant.CONTENT_TYPE), toJson);
        Call<EmptyBringGetOilBean> call = HttpManger.getHttpMangerInstance().getServices().takeDeliveryOrder(requestBody);

        call.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                disDialog();

                EmptyBringGetOilBean body = response.body();

                if (body != null) {
                    if (body.isRes()) {
                        showMyDialog("提交成功");
                    } else {
                        Toasty.info(PaiSongDanJDDialogUI.this, "订单提交失败", Toast.LENGTH_SHORT, true).show();
                        return;
                    }
                } else {
                    Toasty.info(PaiSongDanJDDialogUI.this, "订单提交失败", Toast.LENGTH_SHORT, true).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                Toasty.info(PaiSongDanJDDialogUI.this, "订单提交失败", Toast.LENGTH_SHORT, true).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
                return;

            }
        });
    }


//


    public void calAllMoney() {

        if (addedToCommitCarList == null) {
            return;
        }
        BigDecimal allMoney = new BigDecimal("0.0000");
        BigDecimal allOil = new BigDecimal("0.0000");


        String oilL = "0";
        String oilT = "0";

        BigDecimal oilLdeDecimal = new BigDecimal(oilL);
        BigDecimal oilTDecimal = new BigDecimal(oilT);
        for (int i = 0; i < addedToCommitCarList.size(); i++) {

            PaiSongDanCommitBean.CarListBean carListBean = addedToCommitCarList.get(i);
            String oilTotal = carListBean.getOilTotal();


            if (!TextUtils.isEmpty(oilTotal)) {

                BigDecimal itemMoney = new BigDecimal(oilTotal);
                allMoney = allMoney.add(itemMoney);


            }


            String oilCount = addedToCommitCarList.get(i).getTankSize();
            String settleUnit = carListBean.getSettleUnit();

            if (!TextUtils.isEmpty(oilCount)) {
                BigDecimal itemMoney = new BigDecimal(oilCount);
                allOil = allOil.add(itemMoney);


                BigDecimal oilAdd = new BigDecimal(oilCount);
//                升
                if (settleUnit.equals("0")) {

                    oilLdeDecimal = oilLdeDecimal.add(oilAdd);
                } else {
                    oilTDecimal = oilTDecimal.add(oilAdd);
                }


            }


        }
        LogUtils.i("--吨--" + oilTDecimal + "=升=" + oilLdeDecimal);
        StringBuilder showOilTv = new StringBuilder();
//        String costMoney = UIUtils.formatDoub(allPrice, 4);
        String allMoneyStr = allMoney.stripTrailingZeros().toPlainString();
        String allOilStr = allOil.stripTrailingZeros().toPlainString();
        allPriceMoney.setText("合计:" + allMoneyStr + "元");
        paiSongDanCommitBean.setCarList(addedToCommitCarList);
        paiSongDanCommitBean.setPayAmount(allMoneyStr);
//        paiSongDanCommitBean.setOilAmount(UIUtils.formatDoub(oilAmount, 2));
//        Log.i(TAG, "calAllMoney: 计算总价..." + new Gson().toJson(paiSongDanCommitBean));
        String amountToil = oilTDecimal.toPlainString();
        String amountLoil = oilLdeDecimal.toPlainString();


        int compareTo = oilTDecimal.compareTo(BigDecimal.ZERO);

        if (compareTo != 0) {
            showOilTv.append(amountToil + "吨");
        }

        int compareTo1 = oilLdeDecimal.compareTo(BigDecimal.ZERO);

        if (compareTo1 != 0) {

            if (compareTo == 0) {
                showOilTv.append(amountLoil + "升");
            } else {
                showOilTv.append("+").append(amountLoil + "升");
            }

        }


        oilAllAmount.setText(showOilTv);


        paiSongDanCommitBean.setOilAmount(allOilStr);
        Log.i(TAG, "calAllMoney: 计算总价..." + allOilStr);

    }


    public void CallAddoilDialog() {


        Constant.deliveryCode = paidanBianhao.getContent();

        if (TextUtils.isEmpty(Constant.deliveryCode)) {
            Toasty.info(PaiSongDanJDDialogUI.this, "无派单编号", Toast.LENGTH_SHORT, true).show();
            return;
        }

        AddOilCarFragment addOilCarFragment = new AddOilCarFragment();
        addOilCarFragment.show(getSupportFragmentManager(), "addOilCarFragment");

    }


    @Override
    public void onNewIntent(Intent intent) {

        if (!canAddShow) {
            return;
        }

        if (Constant.isDialogShow) {
            return;
        }


        //1.获取Tag对象
        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        //2.获取Ndef的实例

        if (detectedTag != null) {
            Ndef ndef = Ndef.get(detectedTag);
//        mTagText = ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n";

//            Toast.makeText(this, "==onNewIntent>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onNewIntent: ==>>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n");
            readNfcTag(intent);


//        mNfcText.setText(mTagText);
        }
    }

    /**
     * 读取NFC标签文本数据
     */
    private void readNfcTag(Intent intent) {

        Log.i(TAG, "readNfcTag: =================开始 读取标签====================");

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage msgs[] = null;
            int contentSize = 0;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                    contentSize += msgs[i].toByteArray().length;
                }
            }


            try {
                if (msgs != null) {
                    NdefRecord record = msgs[0].getRecords()[0];
                    String textRecord = parseTextRecord(record);
//                    mTagText += textRecord + "\n\ntext\n" + contentSize + " bytes";
//                    Toast.makeText(this, "数据" + textRecord + "\n\ntext\n" + contentSize + " bytes", Toast.LENGTH_SHORT).show();


//                    getDataFromServer(textRecord);
                    Log.i(TAG, "readNfcTag: " + textRecord + "\n\ntext\n" + contentSize + " bytes");

                    if (TextUtils.isEmpty(textRecord)) {
                        Toasty.error(PaiSongDanJDDialogUI.this, "读取标签有误", Toast.LENGTH_SHORT, true).show();


                    } else {

                        NFCTagBean tagBean = parseStrToBean(textRecord);

                        if (tagBean != null) {


                            String carnum = tagBean.getCarnum();
                            getCarListDataFromServer(carnum);

                        } else {

                            Toasty.error(PaiSongDanJDDialogUI.this, "读取标签有误", Toast.LENGTH_SHORT, true).show();
                            return;

                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }


    private void getCarListDataFromServer(final String carNo) {


        String cUser = SPUtils.getContent(Constant.SP_C_USER);
        GetCarInfoReqBean infoReqBean = new GetCarInfoReqBean();

        infoReqBean.setCode(carNo);

        if (TextUtils.isEmpty(cUser)) {
            infoReqBean.setUserId("");
        } else {
            infoReqBean.setUserId(cUser);
        }


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(infoReqBean);
        HttpManger.getHttpMangerInstance().getServices().findCarinfoFuzzyCode(requestBody).enqueue(new Callback<GetCarInfoRespBean>() {
            @Override
            public void onResponse(Call<GetCarInfoRespBean> call, Response<GetCarInfoRespBean> response) {

                GetCarInfoRespBean body = response.body();
                if (body != null) {

                    List<GetCarInfoRespBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        parseCarinfoFuzzyCodeBring(carNo, bring);

                    }

                }

            }

            @Override
            public void onFailure(Call<GetCarInfoRespBean> call, Throwable t) {
//                Toasty.info(PaiSongDanJDDialogUI.this, "加载超时", Toast.LENGTH_SHORT).show();
//                return;
            }
        });


    }

    private void parseCarinfoFuzzyCodeBring(String carNo, List<GetCarInfoRespBean.BringBean> bring) {

        GetCarInfoRespBean.BringBean toAddNFCBean = new GetCarInfoRespBean.BringBean();

        if (bring != null && bring.size() > 0) {
            toAddNFCBean.setName(bring.get(0).getName());
            toAddNFCBean.setTelephone(bring.get(0).getTelephone());
            toAddNFCBean.setCarNum(carNo);
            CallAddedToNfcNum(toAddNFCBean);
        } else {
            Toasty.info(PaiSongDanJDDialogUI.this, "获取信息有误", Toast.LENGTH_SHORT).show();
            return;
        }


    }


    private void CallAddedToNfcNum(GetCarInfoRespBean.BringBean toAddNFCBean) {

        if (mOilTypeStand == null) {
            Toasty.error(PaiSongDanJDDialogUI.this, "获取油品国标失败", Toast.LENGTH_SHORT, true).show();
            return;
        }
//        if (TextUtils.isEmpty(oilPriceNow)) {
//            Toasty.error(PaiSongDanJDDialogUI.this, "获取价格失败", Toast.LENGTH_SHORT, true).show();
//            return;
//        }

        carBeanAddedTo = new PaiSongDanCommitBean.CarListBean();

        carBeanAddedTo.setVehicleCode(toAddNFCBean.getCarNum());
        carBeanAddedTo.setPName(toAddNFCBean.getName());
        carBeanAddedTo.setTelphone(toAddNFCBean.getTelephone());
        carBeanAddedTo.setFinishTime(UIUtils.getCurrentTime());
        carBeanAddedTo.setOilType(mOilTypeStand.getOilType());
        carBeanAddedTo.setOilTypeName(mOilTypeStand.getOilTypeName());
        carBeanAddedTo.setNationalStandardName(mOilTypeStand.getNationalStandardName());
        carBeanAddedTo.setNationalStandard(mOilTypeStand.getNationalStandard());
//        carBeanAddedTo.setOilBalance(oilPriceNow);
        carBeanAddedTo.setDocType(Constant.DOCTYPE_NORMAL);

        CallAddoilDialog();

        Constant.isDialogShow = true;

    }


    /**
     * 解析NDEF文本数据，从第三个字节开始，后面的文本数据
     *
     * @param ndefRecord
     * @return
     */
    public static String parseTextRecord(NdefRecord ndefRecord) {
        /**
         * 判断数据是否为NDEF格式
         */
        //判断TNF
        if (ndefRecord.getTnf() != NdefRecord.TNF_WELL_KNOWN) {
            return null;
        }
        //判断可变的长度的类型
        if (!Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
            return null;
        }
        try {
            //获得字节数组，然后进行分析
            byte[] payload = ndefRecord.getPayload();
            //下面开始NDEF文本数据第一个字节，状态字节
            //判断文本是基于UTF-8还是UTF-16的，取第一个字节"位与"上16进制的80，16进制的80也就是最高位是1，
            //其他位都是0，所以进行"位与"运算后就会保留最高位
            String textEncoding = ((payload[0] & 0x80) == 0) ? "UTF-8" : "UTF-16";
            //3f最高两位是0，第六位是1，所以进行"位与"运算后获得第六位
            int languageCodeLength = payload[0] & 0x3f;
            //下面开始NDEF文本数据第二个字节，语言编码
            //获得语言编码
            String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            //下面开始NDEF文本数据后面的字节，解析出文本
            String textRecord = new String(payload, languageCodeLength + 1,
                    payload.length - languageCodeLength - 1, textEncoding);
            return textRecord;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public NFCTagBean parseStrToBean(String nfcdata) {

        NFCTagBean nfcTagBean = null;
        if (!TextUtils.isEmpty(nfcdata)) {

            Log.i(TAG, "initView: nfcdata==>" + nfcdata);
            NFCTagBean tagBean = new NFCTagBean();
            Gson gson = new Gson();
            nfcTagBean = gson.fromJson(nfcdata, NFCTagBean.class);
            return nfcTagBean;
        } else {
            Log.i(TAG, "initView: nfcdata为空");
            return null;
        }

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {


        if (!canOnitemClick) {
            return true;
        }

        DialogUtils.showAlert(PaiSongDanJDDialogUI.this, "", "确定要删除选中数据么", "", "", "确定", "取消", false, new DialogUIListener() {
            @Override
            public void onPositive() {

                Log.i(TAG, "onPositive: 删除之前大小" + addedToCommitCarList.size());
                for (int j = 0; j < addedToCommitCarList.size(); j++) {
                    Log.i(TAG, "onPositive: " + addedToCommitCarList.get(j).toString());
                }

                addedToCommitCarList.remove(i);

                showJDAdapter.notifyDataSetChanged();

                Log.i(TAG, "onPositive: ==============================================================");

                for (int j = 0; j < addedToCommitCarList.size(); j++) {
                    Log.i(TAG, "onPositive: " + addedToCommitCarList.get(j).toString());
                }

                Log.i(TAG, "onPositive: 删除之后===大小" + addedToCommitCarList.size());

                calAllMoney();
            }

            @Override
            public void onNegative() {


            }

        }).show();

        return true;
    }


    @Override
    public void onInitNaviFailure() {

    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {

    }

    @Override
    public void onStartNavi(int i) {

    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {

    }

    @Override
    public void onCalculateRouteFailure(int i) {

    }

    @Override
    public void onGetNavigationText(String s) {
//        amapTTSController.onGetNavigationText(s);
    }

    @Override
    public void onStopSpeaking() {
//        amapTTSController.stopSpeaking();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        amapTTSController.destroy();
        addedToCommitCarList.clear();
        isReqCarNum = true;

//        oilType.clear();
//        oilGB.clear();
        mBringBean = null;
    }

    public class GetCarJiaYouJi {

        private String carNum;


        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }


        @Override
        public String toString() {
            return "GetCarJiaYouJi{" +
                    "carNum='" + carNum + '\'' +
                    '}';
        }
    }


    public class NFCTagBean {


        /**
         * carnum : 鲁A12345
         * cartype : 补给车
         */

        private String carnum;
        private String cartype;

        public String getCarnum() {
            return carnum;
        }

        public void setCarnum(String carnum) {
            this.carnum = carnum;
        }

        public String getCartype() {
            return cartype;
        }

        public void setCartype(String cartype) {
            this.cartype = cartype;
        }

        @Override
        public String toString() {
            return "NFCTagBean{" +
                    "carnum='" + carnum + '\'' +
                    ", cartype='" + cartype + '\'' +
                    '}';
        }
    }

    public class CarId {

        public String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "CarId{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }


    public class carNum {
        private String carNum;

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        @Override
        public String toString() {
            return "carNum{" +
                    "carNum='" + carNum + '\'' +
                    '}';
        }
    }

}
