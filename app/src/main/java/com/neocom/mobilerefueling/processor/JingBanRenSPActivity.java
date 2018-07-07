package com.neocom.mobilerefueling.processor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lcodecore.tkrefreshlayout.utils.LogUtil;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.BaseActivity;
import com.neocom.mobilerefueling.adapter.BottomSheetAdapter;
import com.neocom.mobilerefueling.adapter.JingBanRenSPAdapter;
import com.neocom.mobilerefueling.bean.CangKuGoodsBean;
import com.neocom.mobilerefueling.bean.ChildItemBean;
import com.neocom.mobilerefueling.bean.GodsListRespBean;
import com.neocom.mobilerefueling.bean.GuanLianGoodsRespBean;
import com.neocom.mobilerefueling.bean.JBRBringBean;
import com.neocom.mobilerefueling.bean.JBRConListBean;
import com.neocom.mobilerefueling.bean.JingBanRenRespBean;
import com.neocom.mobilerefueling.bean.LabelDataBean;
import com.neocom.mobilerefueling.bean.OnlyStringBeanReso;
import com.neocom.mobilerefueling.bean.ProcessAgreeBean;
import com.neocom.mobilerefueling.bean.ProcessRelGoodsBean;
import com.neocom.mobilerefueling.bean.ProcessWithGoodsRespBean;
import com.neocom.mobilerefueling.bean.StartProcessBean;
import com.neocom.mobilerefueling.bean.StartProcessRespBean;
import com.neocom.mobilerefueling.bean.ToViewRequestBean;
import com.neocom.mobilerefueling.bean.WaitDoResponse;
import com.neocom.mobilerefueling.bean.permissionReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.net.RequestManger;
import com.neocom.mobilerefueling.processor.profragment.MultiBottomFragment;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.FromJsonUtils;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.ParseCallBack;
import com.neocom.mobilerefueling.utils.ShowCallBack;
import com.neocom.mobilerefueling.utils.UIUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import butterknife.Bind;
import butterknife.BindView;
import me.leefeng.promptlibrary.PromptButton;
import me.leefeng.promptlibrary.PromptButtonListener;
import me.leefeng.promptlibrary.PromptDialog;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/23.
 * 经办人 审批
 */

public class JingBanRenSPActivity extends BaseActivity implements View.OnClickListener {
    //    @Bind(R.id.jbrsp_top_bar)
//    TopTitleBar jbrspTopBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    //    @Bind(R.id.submit_btn)
//    Button submitBtn;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.agree_btn)
    Button agreeBtn;
    @BindView(R.id.disagree_btn)
    Button disagreeBtn;
    @BindView(R.id.agree_disagree_btn_layout)
    LinearLayout agreeDisagreeBtnLayout;
    private String opFlag;
    private WaitDoResponse.WaitDoItem waitDoItem;
    Map<String, String> mapData;
    Map<String, String> processMap;

    @BindView(R.id.left_finish_ll)
    LinearLayout leftFinishLl;
    @BindView(R.id.guanlian_right_left_tv)
    TextView guanlianRightLeftTv;
    @BindView(R.id.commit_right_tv)
    TextView commitRightTv;
    //    @BindView(R.id.bottom_option)
//    LinearLayout bottomOption;
//    @BindView(R.id.add_media_tv)
//    TextView addMediaTv;
//    @BindView(R.id.show_media_tv)
//    TextView showMediaTv;
    @BindView(R.id.goods_show_list_tv)
    TextView goodsShowListTv;
    @BindView(R.id.root_jbr_sp)
    RelativeLayout rootJbrSp;


    private static String PERMISSION_VALUE = "permissionvalue";
    //    String workorderBusikey;
    private BottomSheetDialog bottomGoodsList;

    @BindView(R.id.goods_list_ll)
    LinearLayout goodsListLl;

    private String opType; //类型。0：入库，1：出库，2：调拨

    public static String chuRuKuType = "";
    public static String chuRuKuName = "";
    public static String ruKuNameValue = "";


    @Override
    public void initContentView() {
        setContentView(R.layout.jingbanren_sp_layout);
    }

    //    goodsList

    /**
     * 其他活动 启动 流程 ui
     *
     * @param context
     * @param opFlagValue
     */
    public static void actionStartOpProcess(Context context, String opFlagValue) {
        Intent intent = new Intent(context, JingBanRenSPActivity.class);
        intent.putExtra("opFlag", opFlagValue);
        context.startActivity(intent);
    }

    public static void actionStartWithProcessValue(Context context, String opFlagValue, String opType, permissionReqBean permissionReqBean) {

        Intent intent = new Intent(context, JingBanRenSPActivity.class);
        intent.putExtra("opFlag", opFlagValue);
        intent.putExtra("opType", opType);
        intent.putExtra(PERMISSION_VALUE, GsonUtil.GsonString(permissionReqBean));
        context.startActivity(intent);

    }

    permissionReqBean reqBean;
    boolean isButtonGone = false; // 审批 按钮显示

    @Override
    public void initData() {

        opFlag = getIntent().getStringExtra("opFlag");
        opType = getIntent().getStringExtra("opType");

        isButtonGone = getIntent().getBooleanExtra("isButtonGone", Constant.BUTTON_SHOW);

        if (!TextUtils.isEmpty(opType)) {
            chuRuKuType = opType;
        }


        String pmSionStrValue = getIntent().getStringExtra(PERMISSION_VALUE);

        reqBean = GsonUtil.GsonToBean(pmSionStrValue, permissionReqBean.class);

        String itemData = getIntent().getStringExtra("itemData");
        waitDoItem = GsonUtil.GsonToBean(itemData, WaitDoResponse.WaitDoItem.class);

        LogUtil.i("获取流程的名称" + opFlag + ";;" + GsonUtil.GsonString(waitDoItem));

        if (mapData == null) {

            mapData = new HashMap<>();
//            mapData.put("curTaskId", "wf_purchaseInsert_start");
//          mapData.put("curTaskId", workorderBusikey);
            mapData.put("opFlag", opFlag);
//            mapData.put("processDefId", "wf_purchaseInsert");

//            mapData.put("u_user", "a47ecb957fa1469787cf07554a0a81f1");
//            mapData.put("u_user", StaticUtils.App_UserId);
            mapData.put("u_user", GetUserInfoUtils.getUserInfo().getUserId());
            mapData.put("userCode", "xyz");

            if (reqBean != null) {
//                mapData.put("curTaskId", reqBean.getCurTaskId());

                mapData.put("processDefId", reqBean.getProcessDefId());

            }


        }


        if (opFlag.equals("update")) {

            guanlianRightLeftTv.setVisibility(View.GONE);
            commitRightTv.setVisibility(View.GONE);

            goodsShowListTv.setVisibility(View.GONE);

        }

        if (processMap == null) {

            processMap = new HashMap<>();

        }


        getStringViewDataFromServer();

    }

    @Override
    public void initView() {
        leftFinishLl.setOnClickListener(this);
        guanlianRightLeftTv.setOnClickListener(this);
        commitRightTv.setOnClickListener(this);
//        addMediaTv.setOnClickListener(this);
//        showMediaTv.setOnClickListener(this);
        agreeBtn.setOnClickListener(this);
        disagreeBtn.setOnClickListener(this);
        goodsListLl.setOnClickListener(this);

        goodsShowListTv.setOnClickListener(this);

        initPullAndRecyclerView();

//        getViewDataFromServer();


//        initBottomSheetView();

    }


    private boolean oneButton = false;
//    ProcessAgreeBean processAgreeBean;

    private void getStringViewDataFromServer() {

        swipeRefreshLayout.setRefreshing(true);

        if (opFlag.equals("add")) {

            getViewFromServer(reqBean);

            oneButton = true;

        } else {
            oneButton = false;

            if (waitDoItem == null) {
                showInfoTip("获取数据有误");
                swipeRefreshLayout.setRefreshing(false);
                return;
            }


            WaitToDoOrHaveDoneToGetVew();


        }


    }

    private void WaitToDoOrHaveDoneToGetVew() {
        reqBean = new permissionReqBean();
        reqBean.setWorkOrderId(waitDoItem.getWorkorderId());
        getViewFromServer(reqBean);
    }

    private void getViewFromServer(permissionReqBean reqBean) {

        if (!TextUtils.isEmpty(GetUserInfoUtils.getUserInfo().getUserId())) {
            reqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        }

        if (waitDoItem != null) {

            String executionId = waitDoItem.getExecutionId();
            if (!TextUtils.isEmpty(executionId)) {
                reqBean.setExecutionId(executionId);
            }
        }


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqBean);
//        Call<String> callReq = HttpManger.getHttpMangerInstance().getStringServices().permissionList(requestBody);
        Call<String> callReq = null;
        if (opFlag.equals("add")) {
            callReq = HttpManger.getHttpMangerInstance().getStringServices().toAddForApp(requestBody);
        } else {

            if (isButtonGone) {

                //已办请求数据
                callReq = HttpManger.getHttpMangerInstance().getStringServices().toViewForApp(requestBody);
            } else {
// 待办请求数据
                callReq = HttpManger.getHttpMangerInstance().getStringServices().toUpdateForApp(requestBody);
            }

        }


        callReq.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                swipeRefreshLayout.setRefreshing(false);

                String body = response.body();

                if (body != null) {

                    String jsonString = body.toString();

                    Log.i(TAG, "onResponse: ===>>" + jsonString);

                    parseJson(jsonString);
//                parseJson(Constant.JOSN);
//                Log.i(TAG, "onResponse: ===>>" + Constant.JOSN);
                } else {
                    showFailTip();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Log.d(TAG, "onFailure: ---->>" + t.getMessage());
                showFailTip();
            }
        });

    }

    boolean canGoOn = true;

    JingBanRenRespBean verifyRespBeanEmpty;

    private void parseJson(String json) {

        if (!TextUtils.isEmpty(json)) {

            JingBanRenRespBean respBean = FromJsonUtils.jsonToJBRBean(json, new ShowCallBack() {
                @Override
                public void showTips(String msg) {
                    showWarnTip(msg);
                    canGoOn = false;
                }
            });

            if (canGoOn) {

//                verifyRespBeanEmpty = respBean;
                JBRBringBean bring = respBean.getBring();
                LogUtils.i("----->>" + GsonUtil.GsonString(bring));

                if (bring == null) {
                    showWarnTip("数据异常");
                    return;
                }

                List<JBRConListBean> conList = bring.getConList();

                if (conList != null && conList.size() > 0) {
                    showViewData(conList);
                    mapData.put("templateId", respBean.getBring().getTemplateId());
                }

            }

        }

    }

    List<JBRConListBean> conListBoolean;

    private void showViewData(List<JBRConListBean> conList) {
        conListBoolean = conList;


//        if (beanList != null && beanList.size() > 0) {
//            beanList.clear();
//            bottomSheetAdapter.notifyDataSetChanged();
//        }

        if (goodsListLl.getVisibility() == View.VISIBLE) {
            goodsListLl.setVisibility(View.GONE);
        }

        if (oneButton) {
//            submitBtn.setVisibility(View.VISIBLE);
//            bottomOption.setVisibility(View.VISIBLE);
//            bottomOption.setVisibility(View.GONE);
            LogUtil.i("显示一个 按钮");
        } else {
//            agree_disagree_btn_layout

            if (isButtonGone) {

                agreeDisagreeBtnLayout.setVisibility(View.GONE);
            } else {
                agreeDisagreeBtnLayout.setVisibility(View.VISIBLE);
            }


        }


        LogUtil.i("--数据 列表-" + new Gson().toJson(conList));

//        List<LabelDataBean> labelData = conList.get(1).getLabelData();

//        此处对 列表特殊处理


        for (int i = 0; i < conList.size(); i++) {

//            var_process_supplier
            List<LabelDataBean> labelData = conList.get(i).getLabelData();

            if (labelData != null && labelData.size() > 0) {

                for (int j = 0; j < labelData.size(); j++) {

                    LabelDataBean dataBean = labelData.get(j);

                    if (dataBean != null) {

                        String colname = dataBean.getColname();

                        if (!TextUtils.isEmpty(colname) && colname.equals("var_process_supplier")) {

                            String showValue = dataBean.getShowValue();
                            String value = dataBean.getValue();
                            if (showValue.equals("是") || value.equals("是")) {

                                for (int k = 0; k < conList.size(); k++) {

                                    JBRConListBean jbrConListBean = conList.get(k);

                                    if (jbrConListBean != null) {

                                        String labelName = jbrConListBean.getLabelName();

                                        if (!TextUtils.isEmpty(labelName) && labelName.equals("法务审核")) {

                                            conList.remove(k);
                                            LogUtils.i("删除" + labelName);
                                            continue;
                                        }


                                    }


                                }


                            }
                        }

                        //                        去掉 采购分管副总付款审批
                        if (!TextUtils.isEmpty(colname) && colname.equals("var_process_change")) {

                            String value = dataBean.getValue();
                            String showValue = dataBean.getShowValue();

                            if (value.equals("否") || showValue.equals("否")) {


                                for (int k = 0; k < conList.size(); k++) {

                                    JBRConListBean jbrConListBean = conList.get(k);

                                    if (jbrConListBean != null) {

                                        String labelName = jbrConListBean.getLabelName();

                                        if (!TextUtils.isEmpty(labelName) && labelName.equals("采购分管副总付款审批")) {

                                            conList.remove(k);
                                            LogUtils.i("删除" + labelName);
                                            continue;
                                        }


                                    }


                                }

                            }


                        }


                    }


                }


            }


        }


//        LogUtil.i("==替换之前=>" + GsonUtil.GsonString(verifyRespBeanEmpty));
        LogUtil.i("==替换之后=>" + GsonUtil.GsonString(conList));


        Collections.sort(conList, new Comparator<JBRConListBean>() {
            @Override
            public int compare(JBRConListBean o1, JBRConListBean o2) {
                int i1 = Integer.parseInt(o1.getLabelOrder());
                int i2 = Integer.parseInt(o2.getLabelOrder());

                if (i1 > i2) {
                    return 1;
                } else if (i1 == i2) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        LogUtil.i("==排序之后=>" + GsonUtil.GsonString(conList));

        JingBanRenSPAdapter jingBanRenSPAdapter = new JingBanRenSPAdapter(this, conList);
        jingBanRenSPAdapter.setHasStableIds(true);
        recyclerView.setAdapter(jingBanRenSPAdapter);

    }

    private boolean isPassToNext(List<JBRConListBean> conList) {


        for (int i = 0; i < conList.size(); i++) {

//            var_process_supplier
            List<LabelDataBean> labelData = conList.get(i).getLabelData();

            if (labelData != null && labelData.size() > 0) {

                for (int j = 0; j < labelData.size(); j++) {

                    LabelDataBean dataBean = labelData.get(j);

                    if (dataBean != null) {

                        String colname = dataBean.getColname();

                        if (!TextUtils.isEmpty(colname) && colname.equals("form_record")) {

                            String showValue = dataBean.getShowValue();
                            String value = dataBean.getValue();

                            if (!TextUtils.isEmpty(showValue) || !TextUtils.isEmpty(value)) {

                                return true;

                            }
                        }


                    }


                }


            }


        }


        return false;
    }

    private void initPullAndRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getStringViewDataFromServer();

            }
        });

    }


    Set<Map<String, String>> mapSet = new HashSet<>();

//    Map<String, String> mapData = new HashMap<>();

    /**
     * 获取 列表中的 值
     */
    public void saveListData(int parentPosition, int childPosition, Map<String, String> stringMap) {

//        Toast.makeText(this, "=父类的=" + parentPosition + "; 孩子的>" + childPosition, Toast.LENGTH_SHORT).show();
//        stringMapList.add(stringMap);
//        mapSet.add(stringMap);


//        mapData.put("curTaskId", "wf_purchaseInsert_start");


        if (stringMap != null) {


            for (Map.Entry<String, String> stringEntry : stringMap.entrySet()) {

                LogUtil.i("=首页获取=键=" + stringEntry.getKey() + ":值:" + stringEntry.getValue());

                mapData.put(stringEntry.getKey(), stringEntry.getValue());

                if (opFlag.equals("update")) {
                    processMap.put(stringEntry.getKey(), stringEntry.getValue());
                }

            }


        }


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.left_finish_ll:

                finish();

                break;
            case R.id.bottom_clear_all_goods:

                finish();

                break;

//            case R.id.add_media_tv:
//
////                Toast.makeText(this, "显示 多媒体", Toast.LENGTH_SHORT).show();
//
//
//                break;

            case R.id.goods_list_ll:

//               显示底部列表
                bottomGoodsList.show();
                break;

//            case R.id.show_media_tv:
//
////                Toast.makeText(this, "显示 多媒体列表", Toast.LENGTH_SHORT).show();
//
//                break;

            case R.id.guanlian_right_left_tv:


                LogUtil.i("opType 类型 :" + opType + ";;" + isChooseWhareHouse());
//
//                if (Constant.CHUKU_TYPE.equals(opType) && !isChooseWhareHouse()) {
//                    showWarnTip("请选择仓库");
//                    return;
//
//                }
////                if ("2".equals(opType)&&(TextUtils.isEmpty(chuRuKuName) || TextUtils.isEmpty(ruKuNameValue))) { // 调拨
//                if ("2".equals(opType) && !isChooseWhareHouse()) { // 调拨
////                    if (TextUtils.isEmpty(chuRuKuName) || TextUtils.isEmpty(ruKuNameValue)) {
//                    showWarnTip("请选择调出仓库或调入仓库");
//                    return;
////                    }
//
//                }
//
//
////                判断是否 选择 仓库
//
//
////                此时 跳转列表
//
//                if (!EventBus.getDefault().isRegistered(JingBanRenSPActivity.this)) {
//                    EventBus.getDefault().register(JingBanRenSPActivity.this);
//                }
//                Intent intent;
//
//                if (StaticUtils.CHUKU_TYPE.equals(opType) || "2".equals(opType)) {
////                    intent = new Intent(JingBanRenSPActivity.this, ChuKuGuanLianGoodsActivity.class);
//                    intent = new Intent(JingBanRenSPActivity.this, GuanLianChuRuGoodsActivity.class);
//                } else {
//                    intent = new Intent(JingBanRenSPActivity.this, GuanLianGoodsActivity.class);
//                }
//
//
//                startActivity(intent);

                break;

//            case R.id.submit_btn:
            case R.id.commit_right_tv:

                String uuid = CommonUtil.getUUID();
                mapData.put("id", uuid);
                String gsonStringmapData = GsonUtil.GsonString(mapData);


////                for (Map.Entry<String, String> stringEntry :
////                        mapData.entrySet()) {
////
////                    LogUtils.i("-->Key" + stringEntry.getKey() + "==Value:" + stringEntry.getValue());
////
////                }
//                LogUtils.i("-获取的map--" + gsonStringmapData);
//
//
                for (Map.Entry<String, String> stringEntry : mapData.entrySet()) {

                    String key = stringEntry.getKey();
                    String value = stringEntry.getValue();

                    LogUtils.i("--key->" + key + "<-value->" + value);

                    if (TextUtils.isEmpty(value)) {

//                        if (verifyRespBeanEmpty != null) {

//                            JBRBringBean bring = verifyRespBeanEmpty.getBring();

//                            if (bring != null) {

//                                List<JBRConListBean> conList = bring.getConList();

                        if (conListBoolean != null && conListBoolean.size() > 0) {

                            for (int i = 0; i < conListBoolean.size(); i++) {

                                JBRConListBean jbrConListBean = conListBoolean.get(i);

//                                        if (jbrConListBean != null) {
//                                            String labelName = jbrConListBean.getLabelName();

                                List<LabelDataBean> labelData = jbrConListBean.getLabelData();

                                if (labelData != null && labelData.size() > 0) {

                                    for (int j = 0; j < labelData.size(); j++) {
                                        LabelDataBean labelDataBean = labelData.get(j);
                                        String colname = labelDataBean.getColname();
                                        String coltext = labelDataBean.getColtext();
                                        String required = labelDataBean.getRequired();

                                        if (required.equals("1")) { // 必填

                                            LogUtils.i("---key-" + key + "-colname-" + colname);

                                            if (!TextUtils.isEmpty(colname)) {
                                                LogUtils.i("必填：key：" + key + ";name;" + colname);
                                                if (key.equals(colname)) {
                                                    LogUtils.i("必填：：->" + colname);
                                                    showWarnTip("请选择" + coltext);
                                                    return;
                                                }
                                            }
                                        }

                                    }

                                }

                            }


                        }


//                                }

//                            }

//                        }


                    }

                }


                /****************************************************************/
                if (!TextUtils.isEmpty(gsonStringmapData)) {
                    startProcess(gsonStringmapData);
                }
//发起流程
                /****************************************************************/

                break;

            case R.id.agree_btn:

                if (conListBoolean != null && conListBoolean.size() > 0) {
                    boolean passToNext = isPassToNext(conListBoolean);
                    if (passToNext) {

                        showInfoTip("请先处理未审核的提油记录");
                        return;
                    }
                }


                showToAskShenPi(1);
                break;

            case R.id.disagree_btn:
//                processAgree(0);
                showToAskShenPi(0);
                break;
            case R.id.goods_show_list_tv:

//                显示 商品列表


//                List<GuanLianGoodsRespBean.BringBean> recyclerData = bottomSheetAdapter.getRecyclerData();
//                LogUtil.i("---显示商品->>" + GsonUtil.GsonString(recyclerData));
//
//                if (recyclerData != null && recyclerData.size() > 0) {
//                    bottomGoodsList.show();
//                } else {
//                    showWarnTip("商品列表为空");
//                }

                break;

        }

    }


    private boolean isChooseWhareHouse() {

        boolean isChoosed = false;
        for (Map.Entry<String, String> stringEntry : mapData.entrySet()) {

            String key = stringEntry.getKey();
            String value = stringEntry.getValue();
            LogUtil.i("-出库->" + "KEY:" + key + ";VALUE;" + value);

            if ("form_wareHouse".equals(key) || "form_out_wareHouse".equals(key)) {
                isChoosed = true;
                chuRuKuName = value;

            }

            if (key.equals("form_in_wareHouse")) {
                isChoosed = true;
                ruKuNameValue = value;
            }


        }

        return isChoosed;
    }


    private PromptDialog promptExitDialog;

    public void showToAskShenPi(final int isOk) {


        if (promptExitDialog == null) {
            //创建对象
            promptExitDialog = new PromptDialog(this);
            //设置自定义属性
            promptExitDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);
        }

        //按钮的定义，创建一个按钮的对象
        PromptButton confirm = new PromptButton("确定", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {

                processAgree(isOk);
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


        promptExitDialog.showWarnAlert("确定要提交么", confirm, cancleBtn);


    }


    /**
     * 流程 同意 不同意参数
     *
     * @param isOk 1.是0.否
     */
    private void processAgree(int isOk) {

        showLoadingDialog("提交中...");
        if (waitDoItem == null) {
            showWarnTip("获取数据有误");
        }
        if (isOk == 1) {
            processMap.put("c_dt", waitDoItem.getCreateDt());
            processMap.put("c_user", waitDoItem.getCreateUser());
//            processMap.put("curTaskId", processAgreeBean.getCurTaskId());
//            processMap.put("curTaskName", processAgreeBean.getCurTaskName());
            processMap.put("instId", waitDoItem.getProcInstId());
            processMap.put("opFlag", opFlag);
//            processMap.put("processDefId", processAgreeBean.getProcessDefId());
//            processMap.put("templateId", processAgreeBean.getTemplateId());
            processMap.put("u_dt", UIUtils.getCurrentTime());
//            processMap.put("u_user", processAgreeBean.getuUser());
            processMap.put("u_user", GetUserInfoUtils.getUserInfo().getUserId());
            processMap.put("id", waitDoItem.getWorkorderId());
            processMap.put("suggestionContent", "");


//            processMap.put("cuserId", StaticUtils.App_UserId);
        } else {
            if (processMap != null && processMap.size() > 0) {
                processMap.clear();
            }

            processMap.put("curUserId", GetUserInfoUtils.getUserInfo().getUserId());
            processMap.put("insId", waitDoItem.getProcInstId());

        }

        processMap.put("executionId", waitDoItem.getExecutionId());

        String processCommit = GsonUtil.GsonString(processMap);

        commitShenHeData(processCommit, isOk);

    }

    private void commitShenHeData(String processCommit, int isOk) {

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), processCommit);

        Call<OnlyStringBeanReso> call = null;
//        1 是 同意 2 是 不同意
        if (isOk == 1) {
            call = HttpManger.getHttpMangerInstance().getServices().processNodeTask(requestBody);
        } else {
            call = HttpManger.getHttpMangerInstance().getServices().backTask(requestBody);
        }

        if (call == null) {
            return;
        }


        call.enqueue(new Callback<OnlyStringBeanReso>() {
            @Override
            public void onResponse(Call<OnlyStringBeanReso> call, Response<OnlyStringBeanReso> response) {

                disDialog();

                OnlyStringBeanReso body = response.body();

                if (body != null) {

                    Boolean res = body.isRes();

                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            showShortToast("提交成功");
                        } else {
                            showShortToast(message);
                        }

                        finish();
                    } else {

                        if (TextUtils.isEmpty(message)) {
                            showInfoTip("提交失败");
                        } else {
                            showWarnTip(message);
                        }

                    }


                }


            }

            @Override
            public void onFailure(Call<OnlyStringBeanReso> call, Throwable t) {
                disDialog();
                LogUtil.i(t.getMessage());
                showFailTip();

            }
        });


    }

    private void startProcess(String gsonString) {

        showLoadingDialog("提交中...");

        RequestManger.getRequestManger().startProcess(gsonString, new RequestCallBack() {
            @Override
            public void onSuccess(Object data) {

                disDialog();
                LogUtil.i("-----" + data.toString());

                StartProcessBean processBean = FromJsonUtils.parseProcessStartJson(data.toString(), new ShowCallBack() {
                    @Override
                    public void showTips(String msg) {
                        showInfoTip(msg);
                    }
                });

                if (processBean != null && processBean.isRes()) {
                    Toast.makeText(JingBanRenSPActivity.this, "提交成功", Toast.LENGTH_SHORT).show();

                    finish();
                }

            }

            @Override
            public void onFailure(String msg) {
                disDialog();
                LogUtil.i(msg);
                showFailTip();
            }

        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(JingBanRenSPActivity.this);
//        chuRuKuType = null;
//        chuRuKuName = null;
//        ruKuNameValue = null;
    }


}
