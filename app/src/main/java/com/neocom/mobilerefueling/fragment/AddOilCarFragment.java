package com.neocom.mobilerefueling.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.PaiSongDanJDDialogUI;
import com.neocom.mobilerefueling.adapter.OilCarInfoAdapter;
import com.neocom.mobilerefueling.adapter.OilTypeAdapter;
import com.neocom.mobilerefueling.bean.AllCostReqBean;
import com.neocom.mobilerefueling.bean.AllCostRespBean;
import com.neocom.mobilerefueling.bean.GetCarInfoReqBean;
import com.neocom.mobilerefueling.bean.GetCarInfoRespBean;
import com.neocom.mobilerefueling.bean.OilRequestBean;
import com.neocom.mobilerefueling.bean.OilResponseBean;
import com.neocom.mobilerefueling.bean.PaiSongDanCommitBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.widget.jcdialog.bean.BuildBean;
import com.widget.jcdialog.widget.DateSelectorWheelView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 2017/12/20.
 */

public class AddOilCarFragment extends DialogFragment implements View.OnClickListener {
    private static final String TAG = "AddOilCarFragment";
    private TextView itemChepaihao;
    private TextView itemLianxiren;
    private TextView itemLianxidianhua;
    private TextView itemFinishTime;
    private TextView itemYoupinleixing;
    private TextView itemGuobiao;
    private EditText itemJiayouliang;
    private EditText itemDanjiaEt;
    private EditText itemFeiyongEt;
    private OrderConbindView itemDanjia;
    private OrderConbindView itemFee;
    private Button cancleBtn;
    private Button okBtn;
    private ListView listOil;
    private LinearLayout contentLl;
    private LinearLayout listLl;


    private final int YPCHOOSE = 1;
    private final int GBCHOOSE = 2;
    private int CHOOSE = 0;
    OilTypeAdapter oilItemTYPEAdapter;
    private ImageView closeDg;
    private LinearLayout searchCarListRl;
    private EditText etSearch;
    private ImageView ivDeleteText;
    private RecyclerView searchCarList;

    Animation slide_left_to_left;
    Animation slide_right_to_left;
    Animation slide_left_to_right;
    Animation slide_left_to_left_in;
    private ProgressBar progressBar;
    private ImageView backDis;
    private DateSelectorWheelView dwvDate;
    private LinearLayout timeChooseLl;
    private LinearLayout timeLl;
    private TextView tvNext;
    private Button cancleTimeBtn;
    private String docType;
    private ImageView chooseTimeArrowIv;

    private TextView oilLTv;
    private TextView oilTTv;
    private TextView addOilUnit;
    private TextView addOilPrice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setContentView(R.layout.pai_song_dan_dialog_layout);
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        // 设置宽度为屏宽, 靠近屏幕底部。
        final Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.AnimBottom);
        final WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        lp.height = getActivity().getWindowManager().getDefaultDisplay().getHeight() * 4 / 5;
        window.setAttributes(lp);


        initView(dialog);


        slide_left_to_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_left);
        slide_right_to_left = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_right_to_left);
        slide_left_to_right = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_right);
        slide_left_to_left_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_left_to_left_in);
        return dialog;
    }

    private void initView(Dialog dialog) {

        itemChepaihao = dialog.findViewById(R.id.item_chepaihao);
        itemLianxiren = dialog.findViewById(R.id.item_lianxiren);
        itemLianxidianhua = dialog.findViewById(R.id.item_lianxidianhua);
        itemFinishTime = dialog.findViewById(R.id.item_finish_time);
        itemYoupinleixing = dialog.findViewById(R.id.item_youpinleixing);
        itemGuobiao = dialog.findViewById(R.id.item_guobiao);
        itemJiayouliang = dialog.findViewById(R.id.item_jiayouliang);
        itemDanjiaEt = dialog.findViewById(R.id.item_danjia_Et);
        itemFeiyongEt = dialog.findViewById(R.id.item_feiyong_Et);
        itemDanjia = dialog.findViewById(R.id.item_danjia);
        itemFee = dialog.findViewById(R.id.item_fee);
        cancleBtn = dialog.findViewById(R.id.cancle_btn);
        okBtn = dialog.findViewById(R.id.ok_btn);
        listOil = dialog.findViewById(R.id.list_oil);
        contentLl = dialog.findViewById(R.id.content_ll);
        listLl = dialog.findViewById(R.id.list_ll);
        closeDg = dialog.findViewById(R.id.close_dg);

        oilTTv = dialog.findViewById(R.id.oil_t_tv);
        oilLTv = dialog.findViewById(R.id.oil_l_tv);
        backDis = dialog.findViewById(R.id.back_dis);

        searchCarListRl = dialog.findViewById(R.id.search_car_list_rl);
        etSearch = dialog.findViewById(R.id.etSearch);

        ivDeleteText = dialog.findViewById(R.id.ivDeleteText);


        progressBar = dialog.findViewById(R.id.progress);

        searchCarList = dialog.findViewById(R.id.search_car_list);
        timeLl = dialog.findViewById(R.id.time_ll);
        timeLl.setOnClickListener(this);
        timeChooseLl = dialog.findViewById(R.id.time_choose);

//        private TextView addOilUnit;
//        private TextView addOilPrice;

        addOilUnit = dialog.findViewById(R.id.add_oil_unit);
        addOilPrice = dialog.findViewById(R.id.add_oil_price);

        cancleTimeBtn = dialog.findViewById(R.id.cancle_time_btn);
        Button okTimeBtn = dialog.findViewById(R.id.ok_time_btn);
        chooseTimeArrowIv = dialog.findViewById(R.id.choose_time_arrow_iv);

        tvNext = dialog.findViewById(R.id.tv_next);

        dwvDate = dialog.findViewById(R.id.dwv_date);
        BuildBean buildBean = new BuildBean();
//        dwvDate.setShowDate(System.currentTimeMillis() + 60000);
        dwvDate.setShowDate(System.currentTimeMillis() + 60000);
        dwvDate.setShowDateType(DateSelectorWheelView.TYPE_YYYYMMDDHHMM);

        searchCarList.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchCarList.setItemAnimator(new DefaultItemAnimator());

        cancleBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
//        itemYoupinleixing.setOnClickListener(this);
//        itemGuobiao.setOnClickListener(this);
        closeDg.setOnClickListener(this);

        itemChepaihao.setOnClickListener(this);
        ivDeleteText.setOnClickListener(this);
        backDis.setOnClickListener(this);
        cancleTimeBtn.setOnClickListener(this);
        okTimeBtn.setOnClickListener(this);
        oilTTv.setOnClickListener(this);
        oilLTv.setOnClickListener(this);

//        initListView();

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDate = dwvDate.getSelectedDate();

                Toast.makeText(getActivity(), "选择时间是:" + selectedDate, Toast.LENGTH_SHORT).show();

            }
        });

        initData();


        getCarListDataFromServer("");
    }

    private void initData() {

        Log.i("11111", "initData:取json:: " + PaiSongDanJDDialogUI.carBeanAddedTo.toString());
        itemChepaihao.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getVehicleCode());
        itemLianxiren.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getPName());
        itemLianxidianhua.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getTelphone());
        itemFinishTime.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getFinishTime());
        itemYoupinleixing.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getNationalStandardName() + " " + PaiSongDanJDDialogUI.carBeanAddedTo.getOilTypeName());
        itemGuobiao.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getNationalStandardName());
        itemJiayouliang.setText(PaiSongDanJDDialogUI.carBeanAddedTo.getTankSize());
//        itemJiayouliang.setSelection(PaiSongDanJDDialogUI.carBeanAddedTo.getTankSize().length());
        itemDanjia.setTitle("单价");

//        PaiSongDanJDDialogUI.carBeanAddedTo.setOilTotal(oilTotalPrice);
//        PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance(oilUnitPrice);
//        PaiSongDanJDDialogUI.carBeanAddedTo.setOilTotal_show(oilTotalPrice + "元");


        itemDanjia.setContet(PaiSongDanJDDialogUI.carBeanAddedTo.getOilBalance_show());

        itemFee.setTitle("总计");
        itemFee.setContet(PaiSongDanJDDialogUI.carBeanAddedTo.getOilTotal_show());

        docType = PaiSongDanJDDialogUI.carBeanAddedTo.getDocType();

        if (!TextUtils.isEmpty(docType) && docType.equals(Constant.DOCTYPE_BUDAN)) {
            chooseTimeArrowIv.setVisibility(View.VISIBLE);
        } else {
            chooseTimeArrowIv.setVisibility(View.GONE);
        }

        if (PaiSongDanJDDialogUI.carBeanAddedTo.getSettleUnit().equals("0")) {
            changeDanWei(true);
        } else {
            changeDanWei(false);
        }

        itemJiayouliang.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

//                Log.i(TAG, "afterTextChanged:输入油量是 " + s.toString());

                String itemDanjiaContent = itemDanjia.getContent().trim();

//                Toasty.info(getContext(), "==>" + s.toString() + "；单价：" + itemDanjiaContent, Toast.LENGTH_SHORT, true).show();

                String shuLiang = s.toString();

                if (TextUtils.isEmpty(shuLiang)) {

                    itemFee.setContet("0");

                    return;
                }
//                PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance(itemDanjiaContent);
                PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize(shuLiang);

                if (PaiSongDanJDDialogUI.carBeanAddedTo.getSettleUnit().equals("0")) {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize_show(shuLiang + "升");
                } else {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize_show(shuLiang + "吨");
                }


                LogUtils.i("============" + s.toString());

                calMoney();


            }
        });


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 0) {
                    ivDeleteText.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    searchCarList.setVisibility(View.GONE);
                    getCarListDataFromServer("");
                } else {
                    ivDeleteText.setVisibility(View.VISIBLE);

                    progressBar.setVisibility(View.VISIBLE);
                    searchCarList.setVisibility(View.GONE);
                    getCarListDataFromServer(s.toString());


                }

            }
        });


    }

    private void getCarListDataFromServer(final String carNo) {

        if (!PaiSongDanJDDialogUI.isReqCarNum) {
            return;
        }

        String cUser = SPUtils.getContent(Constant.SP_C_USER);
        GetCarInfoReqBean infoReqBean = new GetCarInfoReqBean();
//        infoReqBean.setCarNum(carNo);
//        infoReqBean.setDeliveryCode(Constant.deliveryCode);
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

                progressBar.setVisibility(View.GONE);
                searchCarList.setVisibility(View.VISIBLE);

                GetCarInfoRespBean body = response.body();
                if (body != null) {

                    List<GetCarInfoRespBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        parseBring(bring);

                        if (TextUtils.isEmpty(carNo) || bring.size() == 1) {

                            itemChepaihao.setText(bring.get(0).getCarNum());
                            itemLianxiren.setText(bring.get(0).getName());
                            itemLianxidianhua.setText(bring.get(0).getTelephone());

                        }

                    }

                }

            }

            @Override
            public void onFailure(Call<GetCarInfoRespBean> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                searchCarList.setVisibility(View.VISIBLE);
                Toasty.info(getActivity(), "加载车牌号信息超时", Toast.LENGTH_SHORT).show();
                return;
            }
        });


    }


    private void parseBring(final List<GetCarInfoRespBean.BringBean> bring) {
        OilCarInfoAdapter carInfoAdapter = new OilCarInfoAdapter(getActivity(), bring);
        searchCarList.setAdapter(carInfoAdapter);


        carInfoAdapter.setOnItemClickListener(new OilCarInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, GetCarInfoRespBean.BringBean bringBean) {


//                List<PaiSongDanCommitBean.CarListBean> veryfyCarNo = PaiSongDanJDDialogUI.addedToCommitCarList;
//
//                String carNum = bringBean.getCarNum();
//
//                if (TextUtils.isEmpty(carNum)) {
//                    carNum = "";
//                }
//
//                if (veryfyCarNo.size() > 0) {
//
//                    for (int i = 0; i < veryfyCarNo.size(); i++) {
//                        String vehicleCode = veryfyCarNo.get(i).getVehicleCode();
//
//                        LogUtils.d("选中车牌号：" + carNum + ";;便利车车牌：" + vehicleCode);
//
//                        if (vehicleCode.equals(carNum)) {
//                            isExistSameCarNo = true;
//                        }
//
//                    }
//
//
//                }
//
//                if (isExistSameCarNo) {
//
//                    Toast.makeText(getActivity(), "请勿重复添加想通车牌号", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                String carNum = bringBean.getCarNum();

                boolean veryfyCarNo = veryfyCarNo(carNum);
                if (veryfyCarNo) {

                    Toast.makeText(getActivity(), "请勿重复添加相同车牌号", Toast.LENGTH_SHORT).show();
                    return;
                }


                contentLl.startAnimation(slide_left_to_left_in);
                contentLl.setVisibility(View.VISIBLE);
                searchCarListRl.startAnimation(slide_left_to_right);
                searchCarListRl.setVisibility(View.GONE);

//                GetCarInfoRespBean.BringBean bringBean = bring.get(position);

                itemChepaihao.setText(carNum);
                itemLianxiren.setText(bringBean.getName());
                itemLianxidianhua.setText(bringBean.getTelephone());

            }
        });

    }

    private void calMoney() {


        String tankSize = PaiSongDanJDDialogUI.carBeanAddedTo.getTankSize();
        String itemDanjiaContent = PaiSongDanJDDialogUI.carBeanAddedTo.getOilBalance();

        if (TextUtils.isEmpty(tankSize)) {
            return;
        }


        AllCostReqBean allCostReqBean = new AllCostReqBean();


        if (TextUtils.isEmpty(PaiSongDanJDDialogUI.itemId)) {
            Toast.makeText(getContext(), "获取价格有误", Toast.LENGTH_SHORT).show();
            return;
        } else {

            allCostReqBean.setDeliveryId(PaiSongDanJDDialogUI.itemId);
            allCostReqBean.setOilAmount(tankSize);
            allCostReqBean.setSettleUnit(PaiSongDanJDDialogUI.carBeanAddedTo.getSettleUnit());
        }


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(allCostReqBean);
        HttpManger.getHttpMangerInstance().getServices().getOilTotalPrice(requestBody).enqueue(new Callback<AllCostRespBean>() {
            @Override
            public void onResponse(Call<AllCostRespBean> call, Response<AllCostRespBean> response) {

                AllCostRespBean body = response.body();
                if (body != null) {

                    boolean res = body.isRes();

                    if (res) {

                        AllCostRespBean.BringBean bring = body.getBring();

                        if (bring != null) {

                            String oilUnitPrice = bring.getOilUnitPrice(); // 单价
                            String oilTotalPrice = bring.getOilTotalPrice(); // 总价
                            String unit = bring.getUnit();
                            itemFee.setContet(oilTotalPrice + "元");
                            PaiSongDanJDDialogUI.carBeanAddedTo.setOilTotal(oilTotalPrice);
                            PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance(oilUnitPrice);
                            PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance_show(oilUnitPrice + bring.getUnit());
                            PaiSongDanJDDialogUI.carBeanAddedTo.setOilTotal_show(oilTotalPrice + "元");


                            itemDanjia.setContet(oilUnitPrice + unit);
                        }


                    }

                }

            }

            @Override
            public void onFailure(Call<AllCostRespBean> call, Throwable t) {

            }
        });


//        BigDecimal costDecimal = new BigDecimal("0.0000");
//
//        BigDecimal danJiaBigDecimal = new BigDecimal(itemDanjiaContent);
//        BigDecimal shuLiangDecimal = new BigDecimal(tankSize);
//
//        costDecimal = danJiaBigDecimal.multiply(shuLiangDecimal);
//
//        String costDecimalStr = costDecimal.stripTrailingZeros().toPlainString();
//
//        itemFee.setContet(costDecimalStr);
//        PaiSongDanJDDialogUI.carBeanAddedTo.setOilTotal(costDecimalStr);


    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.item_chepaihao:
                contentLl.startAnimation(slide_left_to_left);
                contentLl.setVisibility(View.GONE);
                searchCarListRl.startAnimation(slide_right_to_left);
                searchCarListRl.setVisibility(View.VISIBLE);

                break;

            case R.id.time_ll:

                if (docType.equals(Constant.DOCTYPE_NORMAL)) {
                    return;
                }

                contentLl.startAnimation(slide_left_to_left);
                contentLl.setVisibility(View.GONE);
                timeChooseLl.startAnimation(slide_right_to_left);
                timeChooseLl.setVisibility(View.VISIBLE);

                break;

            case R.id.back_dis:

                contentLl.startAnimation(slide_left_to_left_in);
                contentLl.setVisibility(View.VISIBLE);
                searchCarListRl.startAnimation(slide_left_to_right);
                searchCarListRl.setVisibility(View.GONE);

                break;

            case R.id.cancle_btn:
                PaiSongDanJDDialogUI.carBeanAddedTo = null;
                Constant.isDialogShow = false;
                getDialog().dismiss();
                break;

            case R.id.ivDeleteText:
                etSearch.setText("");
                break;

            case R.id.ok_btn:
                String ChepaihaoStr = itemChepaihao.getText().toString().trim();

                if (TextUtils.isEmpty(ChepaihaoStr)) {

                    Toasty.info(getContext(), "请检索车牌号", Toast.LENGTH_SHORT, true).show();
                    return;
                }


                if (PaiSongDanJDDialogUI.isTestCarNum) {

                    boolean veryfyCarNo = veryfyCarNo(ChepaihaoStr);
                    if (veryfyCarNo) {

                        Toast.makeText(getActivity(), "请勿重复添加相同车牌号", Toast.LENGTH_SHORT).show();
                        return;
                    }


                }


                String finishTime = PaiSongDanJDDialogUI.carBeanAddedTo.getFinishTime();
                if (TextUtils.isEmpty(finishTime)) {
                    Toasty.info(getActivity(), "您未选择时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                String lianxirenStr = itemLianxiren.getText().toString();
                if (TextUtils.isEmpty(lianxirenStr)) {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setPName("");
                } else {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setPName(lianxirenStr);
                }
                String LianxidianhuaStr = itemLianxidianhua.getText().toString();
                if (TextUtils.isEmpty(LianxidianhuaStr)) {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setTelphone("");
                } else {
                    PaiSongDanJDDialogUI.carBeanAddedTo.setTelphone(LianxidianhuaStr);
                }


                PaiSongDanJDDialogUI.carBeanAddedTo.setVehicleCode(ChepaihaoStr);

//                itemLianxiren = dialog.findViewById(R.id.item_lianxiren);
//                itemLianxidianhua = dialog.findViewById(R.id.item_lianxidianhua);

                if (TextUtils.isEmpty(PaiSongDanJDDialogUI.carBeanAddedTo.getOilType())) {
                    Toasty.info(getContext(), "请选择油品类型", Toast.LENGTH_SHORT, true).show();
                    return;
                }

                if (TextUtils.isEmpty(PaiSongDanJDDialogUI.carBeanAddedTo.getNationalStandard())) {
                    Toasty.info(getContext(), "请选择国标", Toast.LENGTH_SHORT, true).show();
                    return;
                }

                String jiayouliangStr = itemJiayouliang.getText().toString().trim();

                if (TextUtils.isEmpty(jiayouliangStr)) {
                    Toasty.info(getContext(), "请输入加油量", Toast.LENGTH_SHORT, true).show();
                    return;
                }


                int compareTo = new BigDecimal(jiayouliangStr).compareTo(BigDecimal.ZERO);

                if (compareTo == 0) {

                    Toast.makeText(getActivity(), "加油量输入不能为0", Toast.LENGTH_SHORT).show();
                    return;
                }


                PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize(jiayouliangStr);

//                处理
                addCarCallBack.SendOilCarData(PaiSongDanJDDialogUI.carBeanAddedTo);
                Constant.isDialogShow = false;
                getDialog().dismiss();

                break;
//            case R.id.item_youpinleixing:
//
////                showPopItem(itemYoupinleixing,YPCHOOSE,PaiSongDanJDDialogUI.oilType);
//
//                //        List<OilLXGBBean.BringBean> oilType = PaiSongDanJDDialogUI.oilType;
////        List<OilLXGBBean.BringBean> oilGB = PaiSongDanJDDialogUI.oilGB;
//
//                CHOOSE = YPCHOOSE;
//
//                contentLl.startAnimation(slide_left_to_left);
//                contentLl.setVisibility(View.GONE);
//                listLl.startAnimation(slide_right_to_left);
//                listLl.setVisibility(View.VISIBLE);
//
//
//                oilItemTYPEAdapter = new OilTypeAdapter(PaiSongDanJDDialogUI.oilType);
//                listOil.setAdapter(oilItemTYPEAdapter);
//
//
//                break;
//            case R.id.item_guobiao:
//                CHOOSE = GBCHOOSE;
//                contentLl.startAnimation(slide_left_to_left);
//                contentLl.setVisibility(View.GONE);
//                listLl.startAnimation(slide_right_to_left);
//                listLl.setVisibility(View.VISIBLE);
//
//                oilItemTYPEAdapter = new OilTypeAdapter(PaiSongDanJDDialogUI.oilGB);
//                listOil.setAdapter(oilItemTYPEAdapter);
//
////                final OilTypeAdapter oilItemGBAdapter = new OilTypeAdapter(PaiSongDanJDDialogUI.oilGB);
////                listOil.setAdapter(oilItemGBAdapter);
//
//                break;

            case R.id.close_dg:
                PaiSongDanJDDialogUI.carBeanAddedTo = null;
                Constant.isDialogShow = false;
                getDialog().dismiss();

                break;

            case R.id.cancle_time_btn:

                contentLl.startAnimation(slide_left_to_left_in);
                contentLl.setVisibility(View.VISIBLE);
                timeChooseLl.startAnimation(slide_left_to_right);
                timeChooseLl.setVisibility(View.GONE);

                break;

            case R.id.ok_time_btn:

                String selectedDate = dwvDate.getSelectedDate();

//                if (TextUtils.isEmpty(selectedDate)){
//                    return;
//                }

                PaiSongDanJDDialogUI.carBeanAddedTo.setFinishTime(selectedDate);

                itemFinishTime.setText(selectedDate);

                contentLl.startAnimation(slide_left_to_left_in);
                contentLl.setVisibility(View.VISIBLE);
                timeChooseLl.startAnimation(slide_left_to_right);
                timeChooseLl.setVisibility(View.GONE);


                break;

            case R.id.oil_l_tv:

                changeDanWei(true);

                break;

            case R.id.oil_t_tv:
                changeDanWei(false);
                break;

        }


    }

    private void changeDanWei(boolean isL) {

        String jiayouliangStr = itemJiayouliang.getText().toString().trim();
        itemJiayouliang.setSelection(jiayouliangStr.length());
        PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize(jiayouliangStr);

        if (isL) {
            oilLTv.setBackground(getResources().getDrawable(R.drawable.tv_bg_dr));
            oilLTv.setTextColor(Color.WHITE);

            oilTTv.setBackgroundColor(Color.WHITE);
            oilTTv.setTextColor(getResources().getColor(R.color.color_text_black));
            PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize_show(jiayouliangStr + "元/升");
            PaiSongDanJDDialogUI.carBeanAddedTo.setSettleUnit("0");

            addOilPrice.setText("元/升");
            addOilUnit.setText("升");
        } else {
            oilTTv.setBackground(getResources().getDrawable(R.drawable.tv_bg_dr));
            oilTTv.setTextColor(Color.WHITE);
            oilLTv.setTextColor(getResources().getColor(R.color.color_text_black));
            oilLTv.setBackgroundColor(Color.WHITE);
            PaiSongDanJDDialogUI.carBeanAddedTo.setTankSize_show(jiayouliangStr + "元/吨");
            PaiSongDanJDDialogUI.carBeanAddedTo.setSettleUnit("1");
            addOilPrice.setText("元/吨");
            addOilUnit.setText("吨");
        }
        calMoney();
    }


//    public void getOilPriceByArea(final OrderConbindView itemDanjia) {
//
//        OilRequestBean oilRequestBean = new OilRequestBean();
//
//        String nationalStandard = PaiSongDanJDDialogUI.carBeanAddedTo.getNationalStandard();
//
//        if (TextUtils.isEmpty(nationalStandard)) {
//            Toasty.info(getContext(), "请选择国标获取油价", Toast.LENGTH_SHORT, true).show();
//            return;
//        }
//        String oilType = PaiSongDanJDDialogUI.carBeanAddedTo.getOilType();
//        if (TextUtils.isEmpty(oilType)) {
//            Toasty.info(getContext(), "请选择油品类型获取油价", Toast.LENGTH_SHORT, true).show();
//            return;
//        }
//
//        oilRequestBean.setArea(PaiSongDanJDDialogUI.areaCode);
////        oilRequestBean.setArea("370000");
//        oilRequestBean.setNationalStandard(nationalStandard);
//        oilRequestBean.setOilType(oilType);
//        oilRequestBean.setTime(PaiSongDanJDDialogUI.carBeanAddedTo.getFinishTime());
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(oilRequestBean);
//        HttpManger.getHttpMangerInstance().getServices().findOilpriceByArea(requestBody).enqueue(new Callback<OilResponseBean>() {
//            @Override
//            public void onResponse(Call<OilResponseBean> call, Response<OilResponseBean> response) {
//
//                OilResponseBean body = response.body();
//                if (body != null) {
//                    OilResponseBean.BringBean bring = body.getBring();
//                    if (bring != null) {
//
//
//                        itemDanjia.setContet(bring.getOilPrice());
//                        PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance(bring.getOilPrice());
//                        calMoney();
//                    } else {
//                        Toasty.info(getContext(), "查询油价失败", Toast.LENGTH_SHORT, true).show();
//                        itemDanjia.setContet("0");
//                        PaiSongDanJDDialogUI.carBeanAddedTo.setOilBalance("0");
//                        calMoney();
//                        return;
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<OilResponseBean> call, Throwable t) {
//                Log.i("异常信息", "onFailure: " + t.getMessage());
//            }
//        });
//
//
//    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        addCarCallBack = (addCarCallBack) getActivity();

    }

    addCarCallBack addCarCallBack;

    public interface addCarCallBack {

        void SendOilCarData(PaiSongDanCommitBean.CarListBean carBean);

    }


    public boolean veryfyCarNo(String carNum) {
        boolean isExistSameCarNo = false;
        List<PaiSongDanCommitBean.CarListBean> veryfyCarNo = PaiSongDanJDDialogUI.addedToCommitCarList;

        if (TextUtils.isEmpty(carNum)) {
            carNum = "";
            isExistSameCarNo = false;
        }

        if (veryfyCarNo.size() > 0) {

            for (int i = 0; i < veryfyCarNo.size(); i++) {
                String vehicleCode = veryfyCarNo.get(i).getVehicleCode();

                LogUtils.d("选中车牌号：" + carNum + ";;便利车车牌：" + vehicleCode);

                if (vehicleCode.equals(carNum)) {
                    isExistSameCarNo = true;
                }

            }


        } else {
            isExistSameCarNo = false;
        }


        return isExistSameCarNo;
    }


}
