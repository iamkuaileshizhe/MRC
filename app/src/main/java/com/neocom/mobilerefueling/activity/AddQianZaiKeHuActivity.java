package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ListDropDownAdapter;
import com.neocom.mobilerefueling.adapter.ZhiXingPriceAdapter;
import com.neocom.mobilerefueling.bean.AddressBean;
import com.neocom.mobilerefueling.bean.DQJLSHenHeBean;
import com.neocom.mobilerefueling.bean.DicChildrenBean;
import com.neocom.mobilerefueling.bean.DictBean;
import com.neocom.mobilerefueling.bean.DictReqBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.FindOilPriceRespBean;
import com.neocom.mobilerefueling.bean.KHBringBean;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.KHDetalRespBean;
import com.neocom.mobilerefueling.bean.KhReqDetailBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MarQueenDataReqBean;
import com.neocom.mobilerefueling.bean.OilLXGBBean;
import com.neocom.mobilerefueling.bean.QZKHBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.bean.QzkhTjshBean;
import com.neocom.mobilerefueling.bean.SHTGRedpBean;
import com.neocom.mobilerefueling.bean.SHTGReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.ExpandableLayout;
import com.neocom.mobilerefueling.view.isEditeTextView;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIDateTimeSaveListener;
import com.widget.jcdialog.listener.DialogUIListener;
import com.widget.jcdialog.widget.DateSelectorWheelView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/30.
 * <p>
 * 添加潜在客户
 */

// intent.putExtra(Constant.COMING, Constant.ZS_COMING);
public class AddQianZaiKeHuActivity extends BaseActivity implements SuperTextView.OnSuperTextViewClickListener, View.OnClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.kehu_name)
    isEditeTextView kehuName;
    @BindView(R.id.kehu_sim_name)
    isEditeTextView kehuSimName;
    @BindView(R.id.kehu_type)
    SuperTextView kehuType;
    @BindView(R.id.kehu_source)
    SuperTextView kehuSource;
    @BindView(R.id.kehu_info_layout)
    LinearLayout kehuInfoLayout;
    @BindView(R.id.ex_show_kehu_type)
    SuperTextView exShowKehuType;
    @BindView(R.id.kehu_reg_num)
    isEditeTextView kehuRegNum;
    @BindView(R.id.kehu_faren_name)
    isEditeTextView kehuFarenName;
    @BindView(R.id.kehu_comp_addr)
    isEditeTextView kehuCompAddr;
    @BindView(R.id.kehu_reg_money)
    isEditeTextView kehuRegMoney;
    @BindView(R.id.kehu_reg_date)
    SuperTextView kehuRegDate;
    @BindView(R.id.kehu_comp_type)
    SuperTextView kehuCompType;
    @BindView(R.id.kehu_busi_scope)
    SuperTextView kehuBusiScope;
    @BindView(R.id.kehu_belong_busi)
    SuperTextView kehuBelongBusi;
    @BindView(R.id.kehu_type_layout)
    LinearLayout kehuTypeLayout;
    @BindView(R.id.ex_kehu_type)
    ExpandableLayout exKehuType;
    @BindView(R.id.comp_info)
    LinearLayout compInfo;
    @BindView(R.id.ex_show_user_info)
    SuperTextView exShowUserInfo;
    @BindView(R.id.lianxiren_name)
    isEditeTextView lianxirenName;
    @BindView(R.id.lianxiren_mobi)
    isEditeTextView lianxirenMobi;
    @BindView(R.id.lianxiren_phone)
    isEditeTextView lianxirenPhone;
    @BindView(R.id.lianxiren_email)
    isEditeTextView lianxirenEmail;
    @BindView(R.id.lianxiren_fox)
    isEditeTextView lianxirenFox;
    @BindView(R.id.lianxiren_qq)
    isEditeTextView lianxirenQq;
    @BindView(R.id.lianxiren_wx)
    isEditeTextView lianxirenWx;
    @BindView(R.id.lianxiren_birthday)
    SuperTextView lianxirenBirthday;
    @BindView(R.id.lianxiren_layout)
    LinearLayout lianxirenLayout;
    @BindView(R.id.ex_layout)
    ExpandableLayout exLayout;
    @BindView(R.id.ex_show_check)
    SuperTextView exShowCheck;
    @BindView(R.id.check_paytype)
    SuperTextView checkPaytype;
    @BindView(R.id.check_oil_type)
    SuperTextView checkOilType;
    @BindView(R.id.check_oil_ticket)
    isEditeTextView checkOilTicket;
    @BindView(R.id.check_car_num)
    isEditeTextView checkCarNum;
    @BindView(R.id.check_car_type)
    SuperTextView checkCarType;
    @BindView(R.id.check_refuel_rate)
    isEditeTextView checkRefuelRate;
    @BindView(R.id.check_refuel_num)
    isEditeTextView checkRefuelNum;
    @BindView(R.id.check_refuel_way)
    SuperTextView checkRefuelWay;
    @BindView(R.id.check_refuel_addr)
    isEditeTextView checkRefuelAddr;
    @BindView(R.id.check_refuel_oil_type)
    isEditeTextView checkRefuelOilType;
    @BindView(R.id.check_refuel_others_service)
    isEditeTextView checkRefuelOthersService;
    @BindView(R.id.ex_check_layout)
    ExpandableLayout exCheckLayout;
    @BindView(R.id.note_info)
    EditText noteInfo;
    @BindView(R.id.remain_text)
    TextView remainText;
    @BindView(R.id.other_info)
    RelativeLayout otherInfo;
    @BindView(R.id.sc_content)
    ScrollView scContent;
    @BindView(R.id.save_now)
    Button saveNow;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.bottom_ll_sub)
    LinearLayout bottomLlSub;

    @BindView(R.id.diaocha_layout)
    LinearLayout diaochaLayout;

    @BindView(R.id.tijiaoren_ll)
    LinearLayout tijiaorenFl;

    @BindView(R.id.tijiaoren_info_title)
    SuperTextView tijiaorenInfoTitle;

    @BindView(R.id.tijiaoren_info_ex)
    ExpandableLayout tijiaorenInfoEx;

    @BindView(R.id.tijiaoren_name)
    SuperTextView tijiaorenName;
    @BindView(R.id.tijiaoren_mobile)
    SuperTextView tijiaorenMobile;
    @BindView(R.id.tijiaoren_email)
    SuperTextView tijiaorenEmail;
    @BindView(R.id.youhuijine_info_title)
    SuperTextView youhuijineInfoTitle;
    @BindView(R.id.yxje_jsfs)
    SuperTextView yxjeJsfs;
    @BindView(R.id.yxje_zqkh)
    SuperTextView yxjeZqkh;
    @BindView(R.id.yxje_khdj)
    SuperTextView yxjeKhdj;
    @BindView(R.id.yxje_gssf)
    SuperTextView yxjeGssf;
    @BindView(R.id.lv_container)
    LinearLayout lvContainer;
    @BindView(R.id.yhje_list)
    RecyclerView yhjeList;
    @BindView(R.id.youhuijine_info_ex)
    ExpandableLayout youhuijineInfoEx;
    @BindView(R.id.youhuijine_ll)
    LinearLayout youhuijineLl;
    @BindView(R.id.delete_now)
    Button deleteNow;

    @BindView(R.id.qiye_info)
    LinearLayout qiyeMainInfo;

    @BindView(R.id.kehu_diaocha_info)
    LinearLayout kehuDiaochaInfo;

    @BindView(R.id.lianxiren_info_main)
    LinearLayout lianxirenInfoMain;


    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;
//    private String keHuLeiXing[] = {"企业", "个人"};
//    private String keHuLaiYuan[] = {"内部开发", "合作伙伴"};
//    private String qiYeLeiXingg[] = {"私营企业", "国有企业",
//            "集体企业", "股份制企业", "联营企业",
//            "外商投资企业", "个人独资企业", "股份合作企业"};
//    private String jingYingFanWei[] = {"劳务总承包", "劳务专业承包",
//            "劳务分包", "建筑装饰工程", "景观工程",
//            "安防工程"};
//    private String suoShuHangYe[] = {"交通运输", "石油炼化",
//            "油气炼化", "油气开采", "油气运输"};
//
//    private String cheLiangLeiXing[] = {"工程机械", "客车", "货车"};
//    private String fuKuanFangShi[] = {"现结算", "账期结算"};
//    private String buJiFangShi[] = {"油枪", "油罐"};
//    private String youPinLeiXing[] = {"国五", "国四"};

    private String btnTextTJSH = "提交审核";
    private String btnTextBC = "保存";
    private String btnTextSHBTG = "审核不通过";
    private String btnTextSHTG = "审核通过";


    private String btnTextBJ = "编辑";


    Gson gson;
    private QZKHBean qzkhBean;

    private String customerId;

//    private boolean canSuperTextViewClick = false;

    DictBean.BringBean dicValue;
    private SHTGReqBean shtgReqBean;

//    private OilLXGBBean chaiYouLX;
//    private OilLXGBBean chaiYouLX;
//    isPassed	String	Y	是否审核通过
//0:不通过 1:通过


//            SPUtils.saveContent(Constant.CY_LX, new Gson().toJson(body));
//                        SPUtils.saveContent(Constant.CY_GB, new Gson().toJson(body));

    private String isPassedY = "1";
    private String isPassedN = "0";
    private ZhiXingPriceAdapter zhiXingPriceAdapter;
    private String xiaoShouZhuGuanShenHeId;
    private String roleCode;

    private String xiaoShouZhuGuan = "1";
    private String diQuJingLi = "2";
    private String comingExtra;


    @Override
    public void initContentView() {
        setContentView(R.layout.add_qianzaikh_layout);

        if (gson == null) {
            gson = new Gson();
        }


    }


    @Override
    public void initView() {


        Intent intent = getIntent();
        String itemContent = intent.getStringExtra("itemContent");

        String idItem = intent.getStringExtra("idItem");
//        intent.putExtra("itemState",checkStatus);
        String checkStatus = intent.getStringExtra("checkStatus");

//        intent.putExtra("shenHeId",idShenHeItem);

        xiaoShouZhuGuanShenHeId = intent.getStringExtra("shenHeId"); // cusTomerId

        String khType = intent.getStringExtra(Constant.KHTYPE);

//        intent.putExtra(Constant.COMING,Constant.DPF_COMING );
        comingExtra = intent.getStringExtra(Constant.COMING); // 记录菜单 来源的 标记值

        LogUtils.i("点击来源:==>>" + comingExtra);
        topBarTitleTv.setText("添加潜在客户");
        topBarFinishLl.setOnClickListener(this);
        saveNow.setOnClickListener(this);
        submitNow.setOnClickListener(this);
        deleteNow.setOnClickListener(this);

        exShowKehuType.setOnSuperTextViewClickListener(this);
        exShowCheck.setOnSuperTextViewClickListener(this);
        exShowUserInfo.setOnSuperTextViewClickListener(this);
        tijiaorenInfoTitle.setOnSuperTextViewClickListener(this);
        kehuType.setOnSuperTextViewClickListener(this);
        kehuSource.setOnSuperTextViewClickListener(this);
        kehuRegDate.setOnSuperTextViewClickListener(this);
        kehuCompType.setOnSuperTextViewClickListener(this);
        lianxirenBirthday.setOnSuperTextViewClickListener(this);
        checkPaytype.setOnSuperTextViewClickListener(this);
        kehuBusiScope.setOnSuperTextViewClickListener(this);
        kehuBelongBusi.setOnSuperTextViewClickListener(this);
        checkOilType.setOnSuperTextViewClickListener(this);
        checkRefuelWay.setOnSuperTextViewClickListener(this);
        checkCarType.setOnSuperTextViewClickListener(this);
        youhuijineInfoTitle.setOnSuperTextViewClickListener(this);

        yxjeJsfs.setOnSuperTextViewClickListener(this);
        yxjeZqkh.setOnSuperTextViewClickListener(this);
        yxjeKhdj.setOnSuperTextViewClickListener(this);
        yxjeGssf.setOnSuperTextViewClickListener(this);

        scContent.smoothScrollTo(0, 20);

        yhjeList.setLayoutManager(new LinearLayoutManager(AddQianZaiKeHuActivity.this));
        yhjeList.setItemAnimator(new DefaultItemAnimator());

        noteInfo.addTextChangedListener(textWatcher);
        remainText.setText("剩余" + 50 + "字");

        KHBringBean bringBean = gson.fromJson(itemContent, KHBringBean.class);
        qzkhBean = new QZKHBean();
        shtgReqBean = new SHTGReqBean();

//        if (Constant.KHTYPE.equals(Constant.ZSKH)) {
//
////        intent.putExtra(Constant.KHTYPE, Constant.ZSKH);
//            saveNow.setText("删除");
//            submitNow.setText("编辑");
//        }

        if (!TextUtils.isEmpty(idItem)) {

            getKeHuDetailFromServer(idItem);


            changeUIbyIdorState(checkStatus, khType);


            roleCode = GetOrderStateUtil.getRoleCode(GetUserInfoUtils.getUserInfo().getRoleCode());

//            String roleCodeLetter = GetUserInfoUtils.getUserInfo().getRoleCode();

            Log.i(TAG, "initView: roleCode==>" + roleCode);

            String cityCode = SPUtils.getContent("cityCode");


            if (!TextUtils.isEmpty(roleCode) && (roleCode.equals(Constant.YEWUYUAN_CODE) || roleCode.equals(Constant.SHICHANG_CODE) || roleCode.equals(Constant.JINGLI_CODE))) {

//                setisEdit(kehuTypeLayout, false);
//                setisEdit(lianxirenLayout, false);
//                setisEdit(diaochaLayout, false);
//                setisEdit(kehuInfoLayout, false);
//
//                setisEdit(qiyeMainInfo, false);
//                setisEdit(lianxirenName, false);
//
//
//                setSuperTextViewNoArrow(kehuTypeLayout, false);
//                setSuperTextViewNoArrow(lianxirenLayout, false);
//                setSuperTextViewNoArrow(diaochaLayout, false);
//                setSuperTextViewNoArrow(kehuInfoLayout, false);
//
//                setSuperTextViewNoArrow(kehuDiaochaInfo, false);
//                setSuperTextViewNoArrow(lianxirenName, false);

                allNoEdit();

//                Toast.makeText(this, "==>" + comingExtra, Toast.LENGTH_SHORT).show();

                if (TextUtils.isEmpty(comingExtra)) {
                    LogUtils.i("空来源..." + comingExtra);
                    saveNow.setVisibility(View.VISIBLE);
                    saveNow.setText(btnTextTJSH);
                    submitNow.setVisibility(View.VISIBLE);
                    submitNow.setText(btnTextBJ);
                    deleteNow.setVisibility(View.VISIBLE);

                } else {
                    LogUtils.i("来源..." + comingExtra);
                    if (comingExtra.equals(Constant.DPF_COMING)) {

                        topBarTitleTv.setText("客户信息预览");

                        submitNow.setVisibility(View.GONE);
                        deleteNow.setVisibility(View.GONE);

//                        setisEdit(kehuTypeLayout, false);
//                        setisEdit(lianxirenLayout, false);
//                        setisEdit(diaochaLayout, false);
//                        setisEdit(kehuInfoLayout, false);
//
//
//
//                        setSuperTextViewNoArrow(kehuTypeLayout, false);
//                        setSuperTextViewNoArrow(lianxirenLayout, false);
//                        setSuperTextViewNoArrow(diaochaLayout, false);
//                        setSuperTextViewNoArrow(kehuInfoLayout, false);

                        allNoEdit();

                    } else if (comingExtra.equals(Constant.ZS_COMING)) {

                        LogUtils.i("来源..." + comingExtra);

                        topBarTitleTv.setText("正式客户信息预览");

                        submitNow.setVisibility(View.GONE);
                        deleteNow.setVisibility(View.GONE);
                        saveNow.setVisibility(View.GONE);

//                        youhuijineLl.setVisibility(View.VISIBLE);

//                        setisEdit(kehuTypeLayout, false);
//                        setisEdit(lianxirenLayout, false);
//                        setisEdit(diaochaLayout, false);
//                        setisEdit(kehuInfoLayout, false);
//
//                        setSuperTextViewNoArrow(kehuTypeLayout, false);
//                        setSuperTextViewNoArrow(lianxirenLayout, false);
//                        setSuperTextViewNoArrow(diaochaLayout, false);
//                        setSuperTextViewNoArrow(kehuInfoLayout, false);
                        allNoEdit();

                    } else if (comingExtra.equals(Constant.DCL_COMING)) {
                        saveNow.setVisibility(View.VISIBLE);
                        saveNow.setText(btnTextSHBTG);
                        submitNow.setVisibility(View.VISIBLE);
                        submitNow.setText(btnTextSHTG);
                        youhuijineLl.setVisibility(View.VISIBLE);
                        deleteNow.setVisibility(View.GONE);
                    } else {
                        LogUtils.i("未知来源...");
                        saveNow.setVisibility(View.VISIBLE);
                        saveNow.setText(btnTextTJSH);
                        submitNow.setVisibility(View.VISIBLE);
                        submitNow.setText(btnTextBJ);
                        deleteNow.setVisibility(View.VISIBLE);
                        setNoteIsEdit(false);


                    }

                }


            }


        }

        getDicFromServer();


    }


    public void allNoEdit() {
        LogUtils.i("都不可编辑....");
        setisEdit(kehuTypeLayout, false);
        setisEdit(lianxirenLayout, false);
        setisEdit(diaochaLayout, false);
        setisEdit(kehuInfoLayout, false);

        setisEdit(qiyeMainInfo, false);
        setisEdit(lianxirenInfoMain, false);
        setisEdit(youhuijineLl, false);


        setSuperTextViewNoArrow(kehuTypeLayout, false);
        setSuperTextViewNoArrow(lianxirenLayout, false);
        setSuperTextViewNoArrow(diaochaLayout, false);
        setSuperTextViewNoArrow(kehuInfoLayout, false);

        setSuperTextViewNoArrow(kehuDiaochaInfo, false);
        setSuperTextViewNoArrow(lianxirenInfoMain, false);
        setNoteIsEdit(false);
    }

    public void allCanEdit() {

        setisEdit(kehuTypeLayout, true);
        setisEdit(lianxirenLayout, true);
        setisEdit(diaochaLayout, true);
        setisEdit(kehuInfoLayout, true);

        setisEdit(qiyeMainInfo, true);
        setisEdit(lianxirenInfoMain, true);


        setSuperTextViewNoArrow(kehuTypeLayout, true);
        setSuperTextViewNoArrow(lianxirenLayout, true);
        setSuperTextViewNoArrow(diaochaLayout, true);
        setSuperTextViewNoArrow(kehuInfoLayout, true);

        setSuperTextViewNoArrow(kehuDiaochaInfo, true);
        setSuperTextViewNoArrow(lianxirenInfoMain, true);

    }


    private void getZXJGFromServer(String cityCode) {


        MarQueenDataReqBean marQueenDataReqBean = new MarQueenDataReqBean();

//        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
//
////        SPUtils.saveContent("cityCode",provinceCode);
//
//
//
//        if (userInfo != null) {
//            marQueenDataReqBean.setUserId(userInfo.getUserId());
//        }
//        marQueenDataReqBean.setProvince("630000");
        marQueenDataReqBean.setProvince(cityCode);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(marQueenDataReqBean);
        HttpManger.getHttpMangerInstance().getServices().findOilPricesByUserId(requestBody).enqueue(new Callback<FindOilPriceRespBean>() {
            @Override
            public void onResponse(Call<FindOilPriceRespBean> call, Response<FindOilPriceRespBean> response) {

                FindOilPriceRespBean body = response.body();

                if (body != null) {
                    List<FindOilPriceRespBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        parseZxjgBring(bring);

                    }

                }

            }

            @Override
            public void onFailure(Call<FindOilPriceRespBean> call, Throwable t) {

            }
        });


    }

    private void parseZxjgBring(List<FindOilPriceRespBean.BringBean> bring) {


        zhiXingPriceAdapter = new ZhiXingPriceAdapter(bring, roleCode, AddQianZaiKeHuActivity.this);
        yhjeList.setAdapter(zhiXingPriceAdapter);

    }

    private void changeUIbyIdorState(String checkStatus, String khType) {
        Log.i(TAG, "changeUIbyIdorState: -----" + checkStatus);
        if (checkStatus.equals(Constant.WTJ)) {

//            saveNow.setText(btnTextTJSH);
////            submitNow.setVisibility(View.VISIBLE);
////            submitNow.setText("编辑");
//            tijiaorenFl.setVisibility(View.VISIBLE);
//            remainText.setVisibility(View.INVISIBLE);
//            setNoteIsEdit(false);
//            setisEdit(kehuTypeLayout, false);
//            setisEdit(lianxirenLayout, false);
//            setisEdit(diaochaLayout, false);
//            setisEdit(kehuInfoLayout, false);
//
////            canSuperTextViewClick = true;
//            setSuperTextViewNoArrow(kehuTypeLayout, false);
//            setSuperTextViewNoArrow(lianxirenLayout, false);
//            setSuperTextViewNoArrow(diaochaLayout, false);
//            setSuperTextViewNoArrow(kehuInfoLayout, false);
            allNoEdit();
        }

    }

    private void setSuperTextViewNoArrow(ViewGroup viewParent, boolean isEdit) {

        int childCount = viewParent.getChildCount();
        Log.i(TAG, "setSuperTextViewNoArrow: ===" + childCount);
        for (int i = 0; i < childCount; i++) {
            View childSuperTv = viewParent.getChildAt(i);
            Log.i(TAG, "setSuperTextViewNoArrow: =====>" + childSuperTv.getId());

            if (childSuperTv instanceof SuperTextView) {
                if (isEdit) {
                    ((SuperTextView) childSuperTv).setRightIcon(R.drawable.arrow_down);
                    ((SuperTextView) childSuperTv).setOnSuperTextViewClickListener(this);

                } else {
                    ((SuperTextView) childSuperTv).setRightIcon(null);
                    ((SuperTextView) childSuperTv).setOnSuperTextViewClickListener(null);
                }
            }

        }

    }

    private void getDicFromServer() {

        getCYLXFromServer();
        getGBFromServer();

        DictReqBean dictReqBean = new DictReqBean();

        dictReqBean.setJSFS(Constant.JSFS);
        dictReqBean.setWf_manage_scope(Constant.WF_MANAGE_SCOPE);
        dictReqBean.setWf_firm_industry(Constant.WF_FIRM_INDUSTRY);
        dictReqBean.setWf_firm_type(Constant.WF_FIRM_TYPE);
        dictReqBean.setWf_customer_type(Constant.WF_CUSTOMER_TYPE);
        dictReqBean.setWf_customer_source(Constant.WF_CUSTOMER_SOURCE);
        dictReqBean.setCar_type(Constant.CAR_TYPE_DIC);
        dictReqBean.setSupply_way(Constant.SUPPLY_WAY);
        dictReqBean.setCustomer_grade(Constant.CUSTOMER_GRADE);
        dictReqBean.setWf_customer_payment(Constant.WF_CUSTOMER_PAYMENT);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(dictReqBean);
        HttpManger.getHttpMangerInstance().getServices().findCustomerDictByCode(requestBody).enqueue(new Callback<DictBean>() {
            @Override
            public void onResponse(Call<DictBean> call, Response<DictBean> response) {

                DictBean body = response.body();

                if (body != null) {

                    DictBean.BringBean bring = body.getBring();

                    if (bring != null) {

                        String jsonDic = new Gson().toJson(bring);
                        Log.i(TAG, "onResponse: ==>" + jsonDic);
                        SPUtils.saveContent(Constant.DIC_CONTENT, jsonDic);

                    }

                }


            }

            @Override
            public void onFailure(Call<DictBean> call, Throwable t) {

                Log.i(TAG, "onFailure: 获取 字典失败" + t.getMessage());

            }
        });


    }


    private void getCYLXFromServer() {

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(new EmBody());

        HttpManger.getHttpMangerInstance().getServices().findAllCYLX(requestBody).enqueue(new Callback<OilLXGBBean>() {
            @Override
            public void onResponse(Call<OilLXGBBean> call, Response<OilLXGBBean> response) {
                Log.i(TAG, "onResponse: 请求柴油类型返回");


                OilLXGBBean body = response.body();
                if (body != null) {
                    List<OilLXGBBean.BringBean> bring = body.getBring();
                    if (bring != null) {

                        SPUtils.saveContent(Constant.CY_LX, new Gson().toJson(body));

                    }

                }

            }

            @Override
            public void onFailure(Call<OilLXGBBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: 返回柴油类型失败");
            }
        });
    }


    private void getGBFromServer() {
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(new EmBody());
        HttpManger.getHttpMangerInstance().getServices().findAllGB(requestBody).enqueue(new Callback<OilLXGBBean>() {
            @Override
            public void onResponse(Call<OilLXGBBean> call, Response<OilLXGBBean> response) {
                OilLXGBBean body = response.body();
                if (body != null) {
                    List<OilLXGBBean.BringBean> bring = body.getBring();
                    if (bring != null) {

                        SPUtils.saveContent(Constant.CY_GB, new Gson().toJson(body));

                    }
                }


            }

            @Override
            public void onFailure(Call<OilLXGBBean> call, Throwable t) {
                Log.i(TAG, "onFailure: 返回失败");
            }
        });
    }


    private void getKeHuDetailFromServer(String customerId) {
        showLoadingDialog("数据加载中");
        KhReqDetailBean reqDetailBean = new KhReqDetailBean();
        reqDetailBean.setCustomerId(customerId);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqDetailBean);
        Call<KHDetalRespBean> call;
        if (!TextUtils.isEmpty(comingExtra) && comingExtra.equals(Constant.DCL_COMING)) {

            call = HttpManger.getHttpMangerInstance().getServices().findChangeCustomerDetail(requestBody);
        } else {
            call = HttpManger.getHttpMangerInstance().getServices().findHideCustomerDetail(requestBody);
        }


        call.enqueue(new Callback<KHDetalRespBean>() {
            @Override
            public void onResponse(Call<KHDetalRespBean> call, Response<KHDetalRespBean> response) {
                disDialog();
                KHDetalRespBean body = response.body();

                if (body != null) {

                    KHDetailBringBean bring = body.getBring();

                    if (bring != null) {

                        setValueToView(bring);

                    }
                }
            }

            @Override
            public void onFailure(Call<KHDetalRespBean> call, Throwable t) {
                reqTimeOut(t);

            }
        });

    }

    private void setValueToView(KHDetailBringBean bring) {


//        DictBean.BringBean dicValue = GetUserInfoUtils.getDicValue();
//        if (dicValue == null) {
//            Toast.makeText(this, "获取数据有误", Toast.LENGTH_SHORT).show();
//            return;
//        }

        try {

            customerId = bring.getId();

            kehuName.setContent(bring.getCusname());
            kehuSimName.setContent(bring.getNameSim());

            kehuRegNum.setContent(bring.getFirmNum());
            kehuFarenName.setContent(bring.getFirmLegal());
            kehuCompAddr.setContent(bring.getFirmLoc());
            kehuRegMoney.setContent(bring.getFirmCapital());
            kehuRegDate.setRightString(bring.getFirmDate());

//            lianxirenName.setContent(bring.getLinkmanName());

            checkRefuelOilType.setContent(bring.getWishOil());
            checkRefuelOthersService.setContent(bring.getOtherSer());

            /*****************************************/
            checkOilTicket.setContent(bring.getBillAsk());
            checkCarNum.setContent(bring.getCarNum());
            checkRefuelRate.setContent(bring.getSupplyRate());
            checkRefuelNum.setContent(bring.getSupplyNum());
            checkRefuelAddr.setContent(bring.getWishArea());
            /*****************************************/


            KHDetailBringBean.LinkManMessBean linkManMess = bring.getLinkManMess();

            if (linkManMess == null) {
                lianxirenBirthday.setRightString("");
                lianxirenMobi.setContent("");
                lianxirenPhone.setContent("");
                lianxirenEmail.setContent("");
                lianxirenFox.setContent(""); // 没有 后台说 暂时 先 空一下
                lianxirenQq.setContent("");
                lianxirenWx.setContent("");
            } else {
                lianxirenBirthday.setRightString(linkManMess.getBirth());
                lianxirenMobi.setContent(linkManMess.getMobile());
                lianxirenPhone.setContent(linkManMess.getTelephone());
                lianxirenEmail.setContent(linkManMess.getEmail());
                lianxirenFox.setContent(""); // 没有 后台说 暂时 先 空一下
                lianxirenQq.setContent(linkManMess.getQqNum());
                lianxirenWx.setContent(linkManMess.getWeChat());
                lianxirenName.setContent(linkManMess.getName());

            }

            KHDetailBringBean.SaleManMessBean saleManMess = bring.getSaleManMess();
            if (saleManMess == null) {
                tijiaorenName.setRightString("");
                tijiaorenMobile.setRightString("");
                tijiaorenEmail.setRightString("");
            } else {
                tijiaorenName.setRightString(saleManMess.getUserName());
                tijiaorenMobile.setRightString(saleManMess.getUserTel());
                tijiaorenEmail.setRightString(saleManMess.getUserEmail());
            }


            checkOilType.setRightString(bring.getOilTypesName());
//            checkCarType.setRightString("车辆类型");

            String other = bring.getOther();

            if (TextUtils.isEmpty(other)) {
                noteInfo.setText("暂无备注");
                remainText.setVisibility(View.INVISIBLE);
            } else {
                noteInfo.setText(bring.getOther());
                remainText.setVisibility(View.INVISIBLE);
            }


            /************市场经理 设置修改价格 的值*********************************************/


            /*********************************************************/
            /*****************地区 经理 优惠金额信息****************************************/
            KHDetailBringBean.OtherMessBean otherMess = bring.getOtherMess();
            if (otherMess == null) {

//                bring.getOtherMess();

                kehuType.setRightString("");
                kehuSource.setRightString("");
                kehuCompType.setRightString("");
                kehuBusiScope.setRightString("");
                kehuBelongBusi.setRightString("");

                yxjeJsfs.setRightString("");
                yxjeZqkh.setRightString("");
                yxjeKhdj.setRightString("");
            } else {

                kehuType.setRightString(otherMess.getCustomerTypeName());
                kehuSource.setRightString(otherMess.getCustomerSourceName());
                kehuCompType.setRightString(otherMess.getFirmTypeName());
                kehuBusiScope.setRightString(otherMess.getFirmBuscopeName());
                kehuBelongBusi.setRightString(otherMess.getFirmIndustryName());

                yxjeJsfs.setRightString(otherMess.getPayWayName());
                yxjeZqkh.setRightString(otherMess.getCustomerPaymentName());
                yxjeKhdj.setRightString(otherMess.getCustomerGradeName());

                checkRefuelWay.setRightString(otherMess.getSupplyWayName());
                checkPaytype.setRightString(otherMess.getPayWayName());
//                checkOilTicket.setContent(bring.getBillAsk());

                checkCarType.setRightString(otherMess.getCarTypeName());

            }

            /*********************************************************/


//            List<KHDetailBringBean.StrikePriceListBean> strikePriceList = bring.getStrikePriceList();

//            strikePriceList


//                    zhiXingPriceAdapter = new ZhiXingPriceAdapter(bring, roleCode, AddQianZaiKeHuActivity.this);
//            yhjeList.setAdapter(zhiXingPriceAdapter);


        } catch (Exception e) {
            Toast.makeText(this, "获取数据有误", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    @Override
    public void initData() {

    }

    @Override
    public void onClickListener(SuperTextView superTextView) {

//        SPUtils.saveContent(Constant.DIC_CONTENT, jsonDic);

        if (dicValue == null) {
            dicValue = GetUserInfoUtils.getDicValue();
        }


        switch (superTextView.getId()) {
            case R.id.ex_show_kehu_type:

                if (exKehuType.isExpanded()) {

                    exKehuType.collapse();
                } else {
                    exKehuType.expand();
                }

                break;

            case R.id.ex_show_user_info:

                if (exLayout.isExpanded()) {
                    exLayout.collapse();

                } else {
                    exLayout.expand();
                }

                break;

            case R.id.ex_show_check:


                if (exCheckLayout.isExpanded()) {
                    exCheckLayout.collapse();
                } else {
                    exCheckLayout.expand();
                }

                break;
            case R.id.tijiaoren_info_title:


                if (tijiaorenInfoEx.isExpanded()) {
                    tijiaorenInfoEx.collapse();
                } else {
                    tijiaorenInfoEx.expand();
                }

                break;
            case R.id.youhuijine_info_title:


                if (youhuijineInfoEx.isExpanded()) {
                    youhuijineInfoEx.collapse();
                } else {
                    youhuijineInfoEx.expand();
                }

                break;


            case R.id.kehu_type:

                showPopItems(dicValue.getWf_customer_type(), kehuType);
                break;
            case R.id.kehu_source:
                showPopItems(dicValue.getWf_customer_source(), kehuSource);
                break;
            case R.id.kehu_reg_date:
                showToGetDate(kehuRegDate);
                break;
            case R.id.lianxiren_birthday:
                showToGetDate(lianxirenBirthday);
                break;
            case R.id.kehu_comp_type:
                showPopItems(dicValue.getWf_firm_type(), kehuCompType);
                break;
            case R.id.kehu_busi_scope:
                showPopItems(dicValue.getWf_manage_scope(), kehuBusiScope);
                break;
            case R.id.kehu_belong_busi:
                showPopItems(dicValue.getWf_firm_industry(), kehuBelongBusi);
                break;
            case R.id.check_paytype:
                showPopItems(dicValue.getJSFS(), checkPaytype);
                break;
            case R.id.check_oil_type:
                showPopItems(dicValue.getJSFS(), checkOilType);
                break;
            case R.id.check_refuel_way:
                showPopItems(dicValue.getSupply_way(), checkRefuelWay);
                break;
            case R.id.check_car_type:
                showPopItems(dicValue.getCar_type(), checkCarType);
                break;

            case R.id.yxje_jsfs:
                showPopItems(dicValue.getJSFS(), yxjeJsfs);
                break;
            case R.id.yxje_zqkh:
                showPopItems(dicValue.getWf_customer_payment(), yxjeZqkh);
                break;
            case R.id.yxje_khdj:
                showPopItems(dicValue.getCustomer_grade(), yxjeKhdj);
                break;
            case R.id.yxje_gssf:
//                showPopItems(Arrays.asList(cheLiangLeiXing), checkCarType);
                Intent intent = new Intent(AddQianZaiKeHuActivity.this, CitySelecterActivity.class);
                startActivityForResult(intent, 105);
//                startActivity(new Intent(AddQianZaiKeHuActivity.this, CitySelecterActivity.class));
                break;


        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 105 && resultCode == 106) {

            String cityBean = data.getStringExtra("cityBean");
//            Toast.makeText(this, "==" + cityBean, Toast.LENGTH_SHORT).show();
            AddressBean addressBean = gson.fromJson(cityBean, AddressBean.class);

            shtgReqBean.setProvince(addressBean.getID());

            yxjeGssf.setRightString(addressBean.getTypeName());

            getZXJGFromServer(addressBean.getID());

        }

//        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showToGetDate(final View view) {

//        if (canSuperTextViewClick) {
//            return;
//        }

        {
            DialogUtils.showDatePick(AddQianZaiKeHuActivity.this, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMM, 0, new DialogUIDateTimeSaveListener() {
                @Override
                public void onSaveSelectedDate(int tag, String selectedDate) {

                    switch (view.getId()) {
                        case R.id.kehu_reg_date:
                            kehuRegDate.setRightString(selectedDate);

                            qzkhBean.setFirmDate(selectedDate);

                            break;
                        case R.id.lianxiren_birthday:
                            lianxirenBirthday.setRightString(selectedDate);
                            qzkhBean.setBirth1(selectedDate);
                            break;

                    }

                }
            }).show();
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.save_now:

                String btnStr = saveNow.getText().toString().trim();

//                saveNow.setText("审核不通过");


                if (btnStr.equals(btnTextSHBTG)) {

                    Log.i(TAG, "onClick: 审核不通过");

//                    roleCode.equals(xiaoShouZhuGuan) || roleCode.equals(diQuJingLi)
                    if (roleCode.equals(xiaoShouZhuGuan)) {
                        sCJLshbtgToServer();
                    }

                    if (roleCode.equals(diQuJingLi)) {
                        dQJLShenHe(isPassedN);
                    }

                }


                if (btnStr.equals(btnTextBC)) {

                    saveInfo("add");

                }

                if (btnStr.equals(btnTextTJSH)) {

                    submitInfo();


                }


                break;

            case R.id.submit_now:
//                shtgReqBean = new SHTGReqBean();


//                customerAuditByRoleCode

                String submitText = submitNow.getText().toString().trim();

                if (submitText.equals(btnTextSHTG)) {
                    Log.i(TAG, "onClick: 销售主管 审核通过");

                    if (roleCode.equals(xiaoShouZhuGuan)) {


                        List<FindOilPriceRespBean.BringBean> zxjgData = zhiXingPriceAdapter.getZXJGData();
                        if (zxjgData == null || zxjgData.size() == 0) {
                            Toast.makeText(this, "请填写优惠价格列表", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        shtgReqBean.setCustomerId(xiaoShouZhuGuanShenHeId);
                        shtgReqBean.setIsPassed(isPassedY);
                        shtgReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
                        shtgReqBean.setRoleCode(GetOrderStateUtil.getRoleCode(GetUserInfoUtils.getUserInfo().getRoleCode()));

                        List<SHTGReqBean.PriceListBean> priceListBeen = new ArrayList<>();
                        for (int i = 0; i < zxjgData.size(); i++) {

                            FindOilPriceRespBean.BringBean listPrice = zxjgData.get(i);

                            SHTGReqBean.PriceListBean commitBean = new SHTGReqBean.PriceListBean();
                            commitBean.setOilType(listPrice.getOilType());
                            commitBean.setNationalStandard(listPrice.getNationalStandard());
                            commitBean.setDiscountAmount(listPrice.getPrePrice());
                            commitBean.setPerformAmount(listPrice.getPerformAmount());
                            priceListBeen.add(commitBean);
                        }

                        shtgReqBean.setPriceList(priceListBeen);

                        scjlSHCommit(shtgReqBean);
                    }

                    if (roleCode.equals(diQuJingLi)) {
                        Log.i(TAG, "onClick: 地区经理 审核通过");

                        dQJLShenHe(isPassedY);

                    }


                }
                if (roleCode.equals(Constant.YEWUYUAN_CODE) || roleCode.equals(Constant.SHICHANG_CODE)) {
                    if (submitText.equals(btnTextBJ)) {
//                        setisEdit(kehuTypeLayout, true);
//                        setisEdit(lianxirenLayout, true);
//                        setisEdit(diaochaLayout, true);
//                        setisEdit(kehuInfoLayout, true);
//
//                        setSuperTextViewNoArrow(kehuTypeLayout, true);
//                        setSuperTextViewNoArrow(lianxirenLayout, true);
//                        setSuperTextViewNoArrow(diaochaLayout, true);
//                        setSuperTextViewNoArrow(kehuInfoLayout, true);
//
//                        setNoteIsEdit(true);

                        allCanEdit();

                    }

                }


//                saveNow.setText(btnTextTJSH);
//                submitNow.setVisibility(View.VISIBLE);
//                submitNow.setText(btnTextBJ);

                break;
            case R.id.top_bar_finish_ll:

                finish();

                break;
            case R.id.delete_now:


                DialogUtils.showAlert(AddQianZaiKeHuActivity.this, "", "确定要删除该列表么", "", "", "确定", "取消", false, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        deleteCustomer();

                    }

                    @Override
                    public void onNegative() {


                    }

                }).show();

                break;

        }


    }


    /**
     * 潜在客户 提交删除
     */
    public void deleteCustomer() {
        showLoadingDialog("删除中...");
        QzkhTjshBean deleteQZKHReq = new QzkhTjshBean();
        deleteQZKHReq.setCustomerId(customerId);
        deleteQZKHReq.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        HttpManger.getHttpMangerInstance().getServices().deleteCustomer(HttpManger.getHttpMangerInstance().getRequestBody(deleteQZKHReq)).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();
                if (body != null) {
                    String message = body.getMessage();


                    boolean res = body.isRes();

                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(AddQianZaiKeHuActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddQianZaiKeHuActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    } else {


                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("删除失败");
                        } else {
                            Toast.makeText(AddQianZaiKeHuActivity.this, message, Toast.LENGTH_SHORT).show();
                            showInfoTip(message);
                        }

                    }


                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                showInfoTip("连接超时");
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


    private void dQJLShenHe(String isPass) {
        showLoadingDialog("提交中...");
        DQJLSHenHeBean dqjlsHenHeBean = new DQJLSHenHeBean();
        dqjlsHenHeBean.setCustomerId(xiaoShouZhuGuanShenHeId);
        dqjlsHenHeBean.setIsPassed(isPass);

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo == null) {
            return;
        }
        dqjlsHenHeBean.setUserId(userInfo.getUserId());
        dqjlsHenHeBean.setRoleCode(roleCode);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(dqjlsHenHeBean);

        HttpManger.getHttpMangerInstance().getServices().customerAuditByRoleCode(requestBody).enqueue(new Callback<SHTGRedpBean>() {
            @Override
            public void onResponse(Call<SHTGRedpBean> call, Response<SHTGRedpBean> response) {
                disDialog();
                SHTGRedpBean body = response.body();

                if (body != null) {

                    String message = body.getMessage();

                    if (body.isRes()) {

                        if (TextUtils.isEmpty(message)) {

                            Toast.makeText(AddQianZaiKeHuActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddQianZaiKeHuActivity.this, message, Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(AddQianZaiKeHuActivity.this, "提交失败", Toast.LENGTH_SHORT).show();

                    }

                    finish();
                }

            }

            @Override
            public void onFailure(Call<SHTGRedpBean> call, Throwable t) {
                disDialog();
                Toast.makeText(AddQianZaiKeHuActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


    /**
     * 市场经理 审核不通过
     */
    private void sCJLshbtgToServer() {
//        shtgReqBean = new SHTGReqBean();

        shtgReqBean.setCustomerId(customerId);
        shtgReqBean.setIsPassed(isPassedN);
        shtgReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        shtgReqBean.setRoleCode(GetOrderStateUtil.getRoleCode(GetUserInfoUtils.getUserInfo().getRoleCode()));
        scjlSHCommit(shtgReqBean);
    }

    private void scjlSHCommit(SHTGReqBean reqBean) {
        showLoadingDialog("审核提交中...");


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqBean);
        HttpManger.getHttpMangerInstance().getServices().customerAuditByRoleCode(requestBody).enqueue(new Callback<SHTGRedpBean>() {
            @Override
            public void onResponse(Call<SHTGRedpBean> call, Response<SHTGRedpBean> response) {
                disDialog();
                SHTGRedpBean body = response.body();

                if (body != null) {

                    String message = body.getMessage();

                    if (body.isRes()) {

                        Toast.makeText(AddQianZaiKeHuActivity.this, message, Toast.LENGTH_SHORT).show();

                    }

                    SHTGRedpBean.BringBean bring = body.getBring();

                    if (bring != null) {

                        parseSCJLSH(bring);


                    }
                    finish();
                } else {
                    Toast.makeText(AddQianZaiKeHuActivity.this, "审核失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SHTGRedpBean> call, Throwable t) {
                disDialog();
                Toast.makeText(AddQianZaiKeHuActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void parseSCJLSH(SHTGRedpBean.BringBean bring) {
        Log.i(TAG, "parseSCJLSH: " + new Gson().toJson(bring));

    }


    private void editInfo() {
    }

    private void delZSKH() {
    }

    /**
     * 提交 审核 信息
     */
    private void submitInfo() {
        showLoadingDialog("提交审核信息中");
        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (TextUtils.isEmpty(customerId) || userInfo == null) {
            Toast.makeText(this, "提交有误", Toast.LENGTH_SHORT).show();
            return;
        }


        QzkhTjshBean qzkhTjshBean = new QzkhTjshBean();

        qzkhTjshBean.setCustomerId(customerId);

        qzkhTjshBean.setUserId(userInfo.getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(qzkhTjshBean);
        HttpManger.getHttpMangerInstance().getServices().checkCustomer(requestBody).enqueue(new Callback<KHDetalRespBean>() {
            @Override
            public void onResponse(Call<KHDetalRespBean> call, Response<KHDetalRespBean> response) {
                disDialog();
                KHDetalRespBean body = response.body();
                if (body != null) {
                    String message = body.getMessage();
                    if (TextUtils.isEmpty(message)) {

                        if (body.isRes()) {
                            Toast.makeText(AddQianZaiKeHuActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddQianZaiKeHuActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(AddQianZaiKeHuActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                    finish();

                }


            }

            @Override
            public void onFailure(Call<KHDetalRespBean> call, Throwable t) {
                disDialog();
                Toast.makeText(AddQianZaiKeHuActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    /**
     * 保存 信息
     *
     * @param oPtype
     */
    private void saveInfo(String oPtype) {

//        opFlag =”add”新增潜在客户信息
//        opFlag =”update”修改潜在客户信息


        qzkhBean.setOpFlag(oPtype);


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo != null) {
            qzkhBean.setUserId(userInfo.getUserId());
        }

        if (oPtype.equals("update")) {
            qzkhBean.setPeopleId(""); // 那里获取再说 ？？？
            qzkhBean.setId("");
            qzkhBean.setNameNum("");
        }

        String kehuNameStr = getIsContent(kehuName);

        if (TextUtils.isEmpty(kehuNameStr)) {
            return;
        }

        qzkhBean.setCusname(kehuNameStr);

        String kehuSimNameStr = getIsContent(kehuSimName);

        if (TextUtils.isEmpty(kehuSimNameStr)) {
            return;
        }
        qzkhBean.setNameSim(kehuSimNameStr);
//checkStatus	String	Y	审核状态:写死为0
        qzkhBean.setCheckStatus("0");

        String noteStr = noteInfo.getText().toString().trim();
        qzkhBean.setOther(noteStr);

        if (qzkhBean.getCusType() != null && qzkhBean.getCusType().equals("1")) {

            String kehuRegNumStr = getIsContent(kehuRegNum);

            if (TextUtils.isEmpty(kehuRegNumStr)) {
                return;
            }

            qzkhBean.setFirmNum(kehuRegNumStr);

            String kehuFarenNameStr = getIsContent(kehuFarenName);
            if (TextUtils.isEmpty(kehuFarenNameStr)) {
                return;
            }
            qzkhBean.setFirmLegal(kehuFarenNameStr);
            String kehuCompAddrStr = getIsContent(kehuCompAddr);

            if (TextUtils.isEmpty(kehuCompAddrStr)) {
                return;
            }

            qzkhBean.setFirmLoc(kehuCompAddrStr);

            String kehuRegMoneyStr = getIsContent(kehuRegMoney);

            qzkhBean.setFirmCapital(kehuRegMoneyStr);

            if (TextUtils.isEmpty(qzkhBean.getFirmDate())) {
                Toast.makeText(this, "请选择注册日期", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(qzkhBean.getFirmType())) {

                Toast.makeText(this, "请选择企业类型", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(qzkhBean.getFirmBuscope())) {
                Toast.makeText(this, "请选择企业经营范围", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(qzkhBean.getFirmIndustry())) {
                Toast.makeText(this, "请选择所属行业", Toast.LENGTH_SHORT).show();
                return;
            }

        }

        String lianxirenNameStr = getIsContent(lianxirenName);

        if (TextUtils.isEmpty(lianxirenNameStr)) {
            return;
        }
        qzkhBean.setName1(lianxirenNameStr);
        String lianxirenMobiStr = getIsContent(lianxirenMobi);

        if (TextUtils.isEmpty(lianxirenMobiStr)) {
            return;
        }
        qzkhBean.setTel1(lianxirenMobiStr);
        String lianxirenPhoneStr = getIsContent(lianxirenPhone);

        qzkhBean.setPhone1(lianxirenPhoneStr);
        String lianxirenEmailStr = getIsContent(lianxirenEmail);

        qzkhBean.setEmail1(lianxirenEmailStr);
        String lianxirenFoxStr = getIsContent(lianxirenFox);

        qzkhBean.setFax1(lianxirenFoxStr);
        String lianxirenQqStr = getIsContent(lianxirenQq);

        qzkhBean.setQq1(lianxirenQqStr);
        String lianxirenWxStr = getIsContent(lianxirenWx);

        qzkhBean.setWechat1(lianxirenWxStr);

        String billAsk = checkOilTicket.getContent();

        if (!TextUtils.isEmpty(billAsk)) {
            qzkhBean.setBillAsk(billAsk);
        }
        String carNum = checkCarNum.getContent();

        if (!TextUtils.isEmpty(carNum)) {
            qzkhBean.setCarNum(carNum);
        }

        String supplyRate = checkRefuelRate.getContent();

        if (!TextUtils.isEmpty(supplyRate)) {
            qzkhBean.setSupplyRate(supplyRate);
        }
        String supplyNum = checkRefuelNum.getContent();

        if (!TextUtils.isEmpty(supplyNum)) {
            qzkhBean.setSupplyNum(supplyNum);
        }
        String wishArea = checkRefuelAddr.getContent();

        if (!TextUtils.isEmpty(wishArea)) {
            qzkhBean.setWishArea(wishArea);
        }
        String wishOil = checkRefuelOilType.getContent();

        if (!TextUtils.isEmpty(wishOil)) {
            qzkhBean.setWishOil(wishOil);
        }
        String otherSer = checkRefuelOthersService.getContent();

        if (!TextUtils.isEmpty(otherSer)) {
            qzkhBean.setOtherSer(otherSer);
        }
        Log.i(TAG, "savaInfo: ===>>" + new Gson().toJson(qzkhBean));

        savaOrUpdateCustomer(qzkhBean);

    }

    public void savaOrUpdateCustomer(QZKHBean qzCusBean) {

        showLoadingDialog("请稍后...");

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(qzCusBean);

        if (qzCusBean.getOpFlag().equals("add")) {
            saveCus(requestBody);
        } else {

            updateCus(requestBody);

        }

    }

    private void updateCus(RequestBody requestBody) {
        HttpManger.getHttpMangerInstance().getServices().UpdateCustomer(requestBody).enqueue(new Callback<QZKHRespBean>() {
            @Override
            public void onResponse(Call<QZKHRespBean> call, Response<QZKHRespBean> response) {
                disDialog();
                QZKHRespBean body = response.body();

                if (body == null) {

                    Toast.makeText(AddQianZaiKeHuActivity.this, "返回数据异常", Toast.LENGTH_SHORT).show();

                } else {


                    boolean res = body.isRes();
                    String message = body.getMessage();


                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("更新成功");
                        } else {
                            showInfoTip(message);
                        }
                        finish();

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("更新失败");
                        } else {
                            showInfoTip(message);
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<QZKHRespBean> call, Throwable t) {
                reqTimeOut(t);
            }
        });

    }


    private void saveCus(RequestBody requestBody) {

        HttpManger.getHttpMangerInstance().getServices().saveCustomer(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();


                if (body == null) {
                    Toast.makeText(AddQianZaiKeHuActivity.this, "返回数据异常", Toast.LENGTH_SHORT).show();

                } else {


                    boolean res = body.isRes();
                    String message = body.getMessage();


                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("保存成功");
                        } else {
                            showInfoTip(message);
                        }
                        finish();

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("保存失败");
                        } else {
                            showInfoTip(message);
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {

                disDialog();
                Log.i(TAG, "onFailure: " + t.getMessage());
                showWarnTip("连接超时");
            }
        });


    }

    private String getIsContent(isEditeTextView textView) {

        String content = textView.getContent();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, textView.getisEtvHint(), Toast.LENGTH_SHORT).show();
            return "";
        }
        return content;

    }


    /**
     * @param isEdit 设置 客户名称是否编辑
     */
    private void setisEdit(ViewGroup parent, boolean isEdit) {

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View view = parent.getChildAt(i);
            Log.i(TAG, "setKeHuNameEdit: " + view.getId());
            if (view instanceof isEditeTextView) {

                ((isEditeTextView) view).isEdit(isEdit);
            }

        }

    }

    /**
     * @param isEdit 设置 客户类型是否编辑
     */
    private void setKeHuTypeisEdit(boolean isEdit) {

        int childCount = kehuTypeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View view = kehuTypeLayout.getChildAt(i);
            Log.i(TAG, "setKeHuTypeisEdit: " + view.getId());
            if (view instanceof isEditeTextView) {

                ((isEditeTextView) view).isEdit(isEdit);
            }

        }

    }


    private void showPopItems(List<DicChildrenBean> datas, final View parenr) {
        if (datas == null && datas.size() == 0) {
            return;
        }

//        if (canSuperTextViewClick) {
//            return;
//        }

        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {

            layoutLeft = UIUtils.inflate(R.layout.pop_menulist);
            menulistLeft = (ListView) layoutLeft.findViewById(R.id.menulist);

            final ListDropDownAdapter adapter = new ListDropDownAdapter(AddQianZaiKeHuActivity.this, datas);
            menulistLeft.setAdapter(adapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(AddQianZaiKeHuActivity.this, "选择的是" + adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();

                    String chooseStr = adapter.getItem(position).getDictName();
                    String chooseCode = adapter.getItem(position).getDictValue();

                    switch (parenr.getId()) {
                        case R.id.kehu_type:

                            kehuType.setRightString(chooseStr);

                            qzkhBean.setCusType(chooseCode);
                            if (chooseStr.equals("企业")) {
//                               企业 布局显示
                                compInfo.setVisibility(View.VISIBLE);
                            } else {
//                               企业布局 消失
                                compInfo.setVisibility(View.GONE);
                            }

                            break;

                        case R.id.kehu_source:

                            kehuSource.setRightString(chooseStr);

                            qzkhBean.setCusSource(chooseCode);


                            break;

                        case R.id.kehu_comp_type:
                            kehuCompType.setRightString(chooseStr);
                            qzkhBean.setFirmType(chooseCode);
                            break;

                        case R.id.kehu_busi_scope:
                            kehuBusiScope.setRightString(chooseStr);

                            qzkhBean.setFirmBuscope(chooseCode);

                            break;

                        case R.id.kehu_belong_busi:
                            kehuBelongBusi.setRightString(chooseStr);
                            qzkhBean.setFirmIndustry(chooseCode);

                            break;

                        case R.id.check_paytype:
                            checkPaytype.setRightString(chooseStr);
                            qzkhBean.setPayWay(chooseCode);

                            break;

                        case R.id.check_oil_type:
                            checkOilType.setRightString(chooseStr);
                            qzkhBean.setOilTypes(chooseCode);
                            break;

                        case R.id.check_refuel_way:
                            checkRefuelWay.setRightString(chooseStr);
                            qzkhBean.setSupplyWay(chooseCode);
                            break;
                        case R.id.check_car_type:
                            checkCarType.setRightString(chooseStr);
                            qzkhBean.setCarType(chooseCode);
                            break;
                        case R.id.yxje_jsfs:
                            yxjeJsfs.setRightString(chooseStr);
                            shtgReqBean.setSettlement(chooseCode);
                            break;
                        case R.id.yxje_zqkh:
                            yxjeZqkh.setRightString(chooseStr);
                            shtgReqBean.setCustomerPayment(chooseCode);
                            break;
                        case R.id.yxje_khdj:
                            yxjeKhdj.setRightString(chooseStr);
                            shtgReqBean.setCustomerGrade(chooseCode);
                            popLeft.dismiss();
                            break;

                    }


                    // 隐藏弹出窗口
                    if (popLeft != null && popLeft.isShowing()) {
                        popLeft.dismiss();
                    }


                }
            });


            // 创建弹出窗口
            // 窗口内容为layoutLeft，里面包含一个ListView
            // 窗口宽度跟tvLeft一样
            popLeft = new PopupWindow(layoutLeft, parenr.getWidth(),
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(Color.BLACK);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            int topBarHeight = parenr.getBottom();
            popLeft.showAsDropDown(parenr, 0,
                    2);
//            (topBarHeight - parenr.getHeight()) / 2
            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });


        }


    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            remainText.setText("剩余" + (50 - s.length()) + "字");
        }
    };

    private void reqTimeOut(Throwable t) {
        disDialog();
        Log.i(TAG, "onFailure: " + t.getMessage());
        Toast.makeText(AddQianZaiKeHuActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
    }


    private void setNoteIsEdit(boolean isEditNote) {


        noteInfo.setFocusableInTouchMode(isEditNote);
        noteInfo.setFocusable(isEditNote);
        if (isEditNote) {
            noteInfo.requestFocus();
        } else {
            noteInfo.clearFocus();
        }


    }

    public class EmBody {


    }

}
