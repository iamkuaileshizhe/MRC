package com.neocom.mobilerefueling.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.CarStateRespBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.FileUploadResponse;
import com.neocom.mobilerefueling.bean.GetOilDetaiBean;
import com.neocom.mobilerefueling.bean.ListSettingBean;
import com.neocom.mobilerefueling.bean.TiYouModifyBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LQRPhotoSelectUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.BottomMenuDialog;
import com.neocom.mobilerefueling.view.OrderComEdittext;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.isEditeTextView;

import java.io.File;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/15.
 */

public class TiYouDetailActivity extends BaseActivity implements View.OnClickListener, SuperTextView.OnSuperTextViewClickListener {

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
    @BindView(R.id.ty_gongyingshang)
    SuperTextView tyGongyingshang;
    @BindView(R.id.ty_address)
    SuperTextView tyAddress;
    @BindView(R.id.ty_amount_num)
    SuperTextView tyAmountNum;
    @BindView(R.id.remain_tank_oil)
    isEditeTextView remainTankOil;
    //    SuperTextView remainTankOil;
    @BindView(R.id.ty_amount_time)
    SuperTextView tyAmountTime;
    @BindView(R.id.ty_diaodu_user)
    SuperTextView tyDiaoduUser;
    @BindView(R.id.ty_diaodu_time)
    SuperTextView tyDiaoduTime;
    @BindView(R.id.submit_cancle)
    Button submitCancle;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.bottom_ll_sub_oil)
    LinearLayout bottomLlSubOil;
    @BindView(R.id.pounds_before)
    isEditeTextView poundsBefore;
    @BindView(R.id.pounds_after)
    isEditeTextView poundsAfter;
    @BindView(R.id.purchase_num)
    isEditeTextView purchaseNumTv;
    @BindView(R.id.complete_time)
    isEditeTextView completeTime;
    @BindView(R.id.ty_youyang_code)
    isEditeTextView tyYouyangCode;
    @BindView(R.id.ty_place)
    isEditeTextView tyPlace;
    @BindView(R.id.upload_pic)
    SuperTextView uploadPic;
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    //    @BindView(R.id.remain_tank_oil_danwei)
//    TextView remainTankOilDanwei;
//    @BindView(R.id.pounds_before_danwei)
//    TextView poundsBeforeDanwei;
//    @BindView(R.id.pounds_after_danwei)
//    TextView poundsAfterDanwei;
//    @BindView(R.id.purchase_num_danwei)
//    TextView purchaseNumDanwei;
    private String getoilDetail;
    private String downLoadOldName;
    private String downLoadFileId;
    ProgressBar progressBar;
    private String savePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MR";
    private LQRPhotoSelectUtils mLqrPhotoSelectUtils;
    private String photoPath;
    Gson gson;
    TiYouModifyBean tiYouModifyBean;

    private boolean isChakanDetail = false;
    private String fileUrlId;

//    字段名 supplyName(供应商名称)，userName(指令创建人名称) 先 空出预留

    private boolean isInput = false; // 首先是 不能输入的

    @Override
    public void initContentView() {

        setContentView(R.layout.tiyou_detail_activity);

    }

    @Override
    public void initView() {
        if (gson == null) {
            gson = new Gson();
        }
        Intent intent = getIntent();
//        getoilDetail = intent.getStringExtra("tiyoudata");
        getoilDetail = intent.getStringExtra("itemid");
        Log.i(TAG, "initView: ====" + getoilDetail);
//        TiYNewRespBean.BringBean bringBean = gson.fromJson(getoilDetail, TiYNewRespBean.BringBean.class);

        getOilPici.setOnClickListener(this);
        getOilReport.setOnClickListener(this);
        getOilHeTong.setOnClickListener(this);
        uploadPic.setOnSuperTextViewClickListener(this);

        submitNow.setOnClickListener(this);

        initPoundsInout();

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tiYouModifyBean = new TiYouModifyBean();
        completeTime.setContent(UIUtils.getCurrentTime());
        getDataFromServer();

        initPhoto();
        initDanWei();
    }

    private String DUN = "吨";
    private String QIANKE = "千克";

    private void initDanWei() {

        tiYouModifyBean.setUnit(Constant.DANWEI_T); //

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
        if (listSetting != null) {
            String item_quality = listSetting.getItem_quality();
            if (!TextUtils.isEmpty(item_quality)) {

                tiYouModifyBean.setUnit(item_quality);
//                remainTankOilDanwei.setText(QIANKE);
//                poundsBeforeDanwei.setText(QIANKE);
//                poundsAfterDanwei.setText(QIANKE);
//                purchaseNumDanwei.setText(QIANKE);

            } else {
                tiYouModifyBean.setUnit(Constant.DANWEI_T);
//                remainTankOilDanwei.setText(DUN);
//                poundsBeforeDanwei.setText(DUN);
//                poundsAfterDanwei.setText(DUN);
//                purchaseNumDanwei.setText(DUN);
            }


        }


    }

    private void initPhoto() {
        // 1、创建LQRPhotoSelectUtils（一个Activity对应一个LQRPhotoSelectUtils）
        mLqrPhotoSelectUtils = new LQRPhotoSelectUtils(this, new LQRPhotoSelectUtils.PhotoSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                // 4、当拍照或从图库选取图片成功后回调
//                mTvPath.setText(outputFile.getAbsolutePath());
//                mTvUri.setText(outputUri.toString());
                photoPath = outputFile.getAbsolutePath();

                uploadPic.setRightString(outputFile.getName());
                Glide.with(TiYouDetailActivity.this).load(outputUri).into(ivPic);
            }
        }, false);//true裁剪，false不裁剪

        //        mLqrPhotoSelectUtils.setAuthorities("com.lqr.lqrnativepicselect.fileprovider");
        //        mLqrPhotoSelectUtils.setImgPath(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + String.valueOf(System.currentTimeMillis()) + ".jpg");
    }


    private void initPoundsInout() {

        poundsBefore.getInoutLayout().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setpurchaseNum();

            }
        });

        poundsAfter.getInoutLayout().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setpurchaseNum();
            }
        });


    }


    public void setpurchaseNum() {

        if (!isInput) {
            return;
        }

        String poundsBeforeContent = poundsBefore.getContent();
        String poundsAfterContent = poundsAfter.getContent();


        if (!TextUtils.isEmpty(poundsBeforeContent) && !TextUtils.isEmpty(poundsAfterContent)) {

            BigDecimal beforeB = new BigDecimal(poundsBeforeContent);


            BigDecimal bigDecimalA = new BigDecimal(poundsAfterContent);

            BigDecimal min = bigDecimalA.subtract(beforeB);

            String purNum = min.stripTrailingZeros().toPlainString();
            purchaseNumTv.setContent(purNum);


        } else {
            purchaseNumTv.setContent("");
        }

    }

    @Override
    public void initData() {

    }

    private void getDataFromServer() {

        if (TextUtils.isEmpty(getoilDetail)) {
            Toast.makeText(this, "获取详情有误", Toast.LENGTH_SHORT).show();
            return;
        }

        GetOilDetatiId detatiId = new GetOilDetatiId();
        detatiId.setId(getoilDetail);

        String unit = Constant.DANWEI_T;

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();

        if (listSetting != null) {

            String item_quality = listSetting.getItem_quality();

            if (!TextUtils.isEmpty(item_quality)) {
                unit = item_quality;
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
    GetOilDetaiBean.BringBean serverData;

    private void parseBringBean(GetOilDetaiBean.BringBean bringBean) {
        serverData = bringBean;

        tyGongyingshang.setRightString(bringBean.getSupplyName());
        tyAddress.setRightString(bringBean.getSupplyAddress());

        String purchaseNum = bringBean.getInstructNum();

        tyAmountNum.setRightString(purchaseNum);

        tyAmountTime.setRightString(bringBean.getInstructTime());
        tyDiaoduUser.setRightString(bringBean.getUserName());

        tyDiaoduTime.setRightString(bringBean.getC_dt());

        getOilYouyangbianhao.setEditTitle("油样编号");
        getOilYouyangbianhao.setEditContent(bringBean.getOilCode());

        getOilCunfangweizhi.setEditTitle("存放位置");
        getOilCunfangweizhi.setEditContent(bringBean.getOilPlace());
        getOilNoteno.setEditTitle("提油记录编号");
        getOilNoteno.setEditContent(bringBean.getPurchaseCode());

        String bringBeanCarCode = bringBean.getCarCode();
        getOilCarNo.setEditTitle("提油车车牌号");
        getOilCarNo.setEditContent(bringBeanCarCode);

        getOilCarDriver.setEditTitle("提油车司机");
        getOilCarDriver.setEditContent(bringBean.getDriver());

        getOilDriverPhone.setEditTitle("提油司机电话");
        getOilDriverPhone.setEditContent(bringBean.getTelphone());

        getOilRemianOil.setEditTitle("剩余油量");
        String surplusOil = bringBean.getSurplusOil();
        if (!TextUtils.isEmpty(surplusOil)) {
            getOilRemianOil.setEditContent(surplusOil);
        }


        getOilGetOilCount.setEditTitle("提取油量");

//        String purchaseNumTv = bringBean.getPurchaseNum();
//
//        if (!TextUtils.isEmpty(purchaseNumTv)) {
//            getOilGetOilCount.setEditContent(purchaseNumTv + " 吨");
//        }


//        getOilGetOilTime.setEditTitle("提油时间");
//        getOilGetOilTime.setEditContent(bringBean.getPurchaseTime());
//        batchId = bringBean.getBatchId();
        batchNum = bringBean.getBatchNum();

        getOilPici.setTitle("批次信息");
//        getOilPici.setContet(batchId);
        getOilPici.setContet(bringBean.getBatchNum());

//        getOilReport.setTitle("质检报告");
//        getOilReport.setContet(bringBean.getFileOldName());
//        downLoadOldName = bringBean.getFileOldName();

        contractId = bringBean.getContractId();
        getOilHeTong.setTitle("合同信息");
        getOilHeTong.setContet(contractId);

        uploadPic.setRightString(bringBean.getOilfileOldName());

        fileUrlId = bringBean.getOilfileId();


//        downLoadFileId = bringBean.getFileId();

        //        @BindView(R.id.ty_youyang_code)
//        SuperTextView tyYouyangCode;
//        @BindView(R.id.ty_place)
//        SuperTextView tyPlace;

//        tyPlace.setContent(bringBean.getOilPlace());
//        tyYouyangCode.setContent(bringBean.getOilCode());

        getOilNoteRemark.setEditTitle("备注");
        getOilNoteRemark.setEditContent(bringBean.getRemarks());


        String recordStatus = bringBean.getRecordStatus();
//        String insConfirmStatus = bringBean.getInsConfirmStatus();
        Log.i(TAG, "parseBringBean: " + recordStatus);
        if (!TextUtils.isEmpty(recordStatus)) {

            if (recordStatus.equals(Constant.TY_REC_DAITOYOU) || recordStatus.equals(Constant.TY_REC_SHENHEBUTONGGUO)) {
                bottomLlSubOil.setVisibility(View.VISIBLE);
                isEditeTextViewCanEdit(true);

                setUnite();

            } else {

                String uniteStr = "吨";
                String unitName = bringBean.getUnitName();

                if (!TextUtils.isEmpty(unitName)) {
                    uniteStr = unitName;
                }

                bottomLlSubOil.setVisibility(View.GONE);
                isEditeTextViewCanEdit(false);
                poundsBefore.setContent(bringBean.getPoundsBefore() + uniteStr);
                poundsAfter.setContent(bringBean.getPoundsAfter() + uniteStr);
                purchaseNumTv.setContent(bringBean.getPurchaseNum() + uniteStr);
                completeTime.setContent(bringBean.getCompleteTime());

//                tyPlace.setContent(isEdit);
//                tyYouyangCode.setContent(isEdit);

                tyPlace.setContent(bringBean.getOilPlace());
                tyYouyangCode.setContent(bringBean.getOilCode());

//                String unitName = bringBean.getUnitName();

//                if (TextUtils.isEmpty(unitName)){
//                    setToShowUnit("吨");
//                }else {
//                    setToShowUnit(unitName);
//                }


                isChakanDetail = true;
//                uploadPic.setRightString("查看图片");
                uploadPic.setLeftString("查看图片");
            }

        }

        if (!TextUtils.isEmpty(bringBeanCarCode)) {
            getCarInfoByCarNum(bringBeanCarCode);

        }


    }

    private void setUnite() {
        String unit = "(吨)";

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
        if (listSetting != null) {
            String item_quality = listSetting.getItem_quality();
            if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_KG_L)) {
                unit = "(千克)";
            }

        }

//        poundsBefore.setTitle("磅前质量" + unit);
//        poundsAfter.setTitle("磅后质量" + unit);
//        purchaseNumTv.setTitle("提油量" + unit);
        setToShowUnit(unit);
    }

    private void setToShowUnit(String unit) {
//        remainTankOil.setTitle("剩余油量" + unit);
        poundsBefore.setTitle("磅前质量" + unit);
        poundsAfter.setTitle("磅后质量" + unit);
        purchaseNumTv.setTitle("提油量" + unit);
    }

    private void getCarInfoByCarNum(String carNum) {

        carInfoNum carInfoNum = new carInfoNum();
        carInfoNum.setCode(carNum);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carInfoNum);
//        HttpManger.getHttpMangerInstance().getServices().findCarinfoByCode(requestBody).enqueue(new Callback<CarInfoRespBean>() {
        HttpManger.getHttpMangerInstance().getServices().findCarStateByCode(requestBody).enqueue(new Callback<CarStateRespBean>() {
            @Override
            public void onResponse(Call<CarStateRespBean> call, Response<CarStateRespBean> response) {

                CarStateRespBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();
                    if (res) {
                        CarStateRespBean.BringBean bring = body.getBring();

                        if (bring != null) {

                            String leaveOil = bring.getLeaveOilForT();
                            remainTankOil.setContent(leaveOil);

//                            ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
//
//                            if (listSetting != null) {
//                                String item_quality = listSetting.getItem_quality();
//                                if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_KG_L)) {
//                                    String leaveOilForL = bring.getLeaveOilForL();
//                                    remainTankOil.setRightString(leaveOilForL);
//
//                                }
//
//                            }


                        }


                    }


                }


            }

            @Override
            public void onFailure(Call<CarStateRespBean> call, Throwable t) {
                Toast.makeText(TiYouDetailActivity.this, "连接超时,获取油量失败", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void isEditeTextViewCanEdit(boolean isEdit) {
        isInput = isEdit;
        poundsBefore.isEdit(isEdit);
        poundsAfter.isEdit(isEdit);

        tyPlace.isEdit(isEdit);
        tyYouyangCode.isEdit(isEdit);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.get_oil_pici:


//                if (batchNum == null) {
//                    Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                //                Intent intent = new Intent(TiYouDetailActivity.this, GetOilPiCiDetailActivity.class);
//                intent.putExtra("batchNum", batchNum);
//                startActivity(intent);

                if (isChakanDetail) {

                    if (batchNum == null) {
                        Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Intent intent = new Intent(TiYouDetailActivity.this, GetOilPiCiDetailActivity.class);
                    intent.putExtra("batchNum", batchNum);
                    startActivity(intent);


                } else {


                    Intent intent = new Intent(UIUtils.getContext(), GetPiCiActivity.class);
                    intent.putExtra("show", "show");
                    startActivityForResult(intent, 111);

                }


//                startActivity(new Intent(TiYouDetailActivity.this, GetPiCiActivity.class));

                break;
            case R.id.get_oil_report:
//                Toast.makeText(this, "获取质检报告", Toast.LENGTH_SHORT).show();
                break;
            case R.id.get_oil_hetong:
                if (TextUtils.isEmpty(contractId)) {
                    Toast.makeText(this, "尚未选择合同", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intentCID = new Intent(TiYouDetailActivity.this, HeTongDetailActivity.class);
                intentCID.putExtra("contractNum", contractId);
                startActivity(intentCID);

                break;

            case R.id.submit_now:

                String poundsBeforeStr = poundsBefore.getContent();

                if (TextUtils.isEmpty(poundsBeforeStr)) {

                    Toast.makeText(this, poundsBefore.getisEtvHint(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String poundsAfterStr = poundsAfter.getContent();

                if (TextUtils.isEmpty(poundsAfterStr)) {
                    Toast.makeText(this, poundsAfter.getisEtvHint(), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(photoPath)) {
                    Toast.makeText(this, "请选择照片", Toast.LENGTH_SHORT).show();
                    return;
                }


                submitInfo();

                break;


        }


    }

    private void submitInfo() {

        showLoadingDialog("提交中...");
        if (serverData == null) {
            Toast.makeText(this, "获取数据有误", Toast.LENGTH_SHORT).show();
            return;
        }
        tiYouModifyBean.setRecordStatus("2"); //  中间省去了 一步骤 默认先写死 1 后来 有 传 2 了
        tiYouModifyBean.setId(getoilDetail);
        tiYouModifyBean.setDriver(serverData.getDriver());
        tiYouModifyBean.setTelphone(serverData.getTelphone());
//        tiYouModifyBean.setSurplusOil(serverData.getSurplusOil());

        tiYouModifyBean.setPoundsBefore(poundsBefore.getContent());
        tiYouModifyBean.setPoundsAfter(poundsAfter.getContent());

        tiYouModifyBean.setPurchaseNum(purchaseNumTv.getContent());

//        tiYouModifyBean.setPurchaseTime(serverData.getPurchaseTime());
//        tiYouModifyBean.setOilCode(serverData.getOilCode());
        tiYouModifyBean.setOilCode(tyYouyangCode.getContent());
        tiYouModifyBean.setOilPlace(tyPlace.getContent());

        tiYouModifyBean.setCompletePeople(GetUserInfoUtils.getUserInfo().getUserId());
        tiYouModifyBean.setCompleteTime(completeTime.getContent());
        tiYouModifyBean.setPurchaseTime(completeTime.getContent());
        tiYouModifyBean.setSurplusOil(remainTankOil.getContent());

//        surplusOil	String	N	剩余油量
//        purchaseTime	String	N	提取时间

//        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
//
//
//
//        Log.i(TAG, "submitInfo: ===" + new Gson().toJson(tiYouModifyBean));

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(tiYouModifyBean);
        Call<EmptyBringGetOilBean> call = HttpManger.getHttpMangerInstance().getServices().modifyPurchase(requestBody);
        call.enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();

                if (body != null) {
                    boolean res = body.isRes();

                    String message = body.getMessage();
                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            if (TextUtils.isEmpty(message)) {
                                Toast.makeText(TiYouDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(TiYouDetailActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        }

                        if (!TextUtils.isEmpty(getoilDetail)) {
                            FileUpLoad(getoilDetail);
                        }

//                        finish();

                    } else {

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(TiYouDetailActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(TiYouDetailActivity.this, message, Toast.LENGTH_SHORT).show();
                        }


                    }


                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                Toast.makeText(TiYouDetailActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


    private void FileUpLoad(String thingId) {

//        RequestBody bodyParam = null;
//        MultipartBuilder mb = new MultipartBuilder();
//        mb.addFormDataPart("thingId", itemid);
//        mb.addFormDataPart("userId", StaticUtils.App_UserId);
//        /*mb.addFormDataPart("thingId", "c8bfe3b140f14e83889f14895fc08470");
//        mb.addFormDataPart("userId", "c19c0ea8d8df468ab1e9e2582e0b2a00");*/
//
//        MediaType fileType = MediaType.parse("application/octet-stream");
//        for (int i = 0; i < adapt_attachment.attachmentlist.size() ; i++) {
//            AttachmentModel modelfile = adapt_attachment.attachmentlist.get(i);
//            File myfile = new File(modelfile.getAttachmentPath());
//            RequestBody filebody = RequestBody.create(fileType, myfile);
//            mb.addFormDataPart("fileupload",modelfile.getAttachmentName() , filebody);
//        }
//        bodyParam = mb.build();

        if (TextUtils.isEmpty(photoPath)) {
            finish();

        } else {
            showLoadingDialog("附件上传中...");
            RequestBody bodyParam = null;
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.addFormDataPart("userId", GetUserInfoUtils.getUserInfo().getUserId());
            builder.addFormDataPart("thingId", thingId);
            MediaType fileType = MediaType.parse("application/octet-stream");
            File file = new File(photoPath);

            RequestBody filebody = RequestBody.create(fileType, file);

            builder.addFormDataPart("fileupload", file.getName(), filebody);

            bodyParam = builder.build();


            HttpManger.getHttpMangerInstance().getServices().saveUploadFile(bodyParam).enqueue(new Callback<FileUploadResponse>() {
                @Override
                public void onResponse(Call<FileUploadResponse> call, Response<FileUploadResponse> response) {
                    disDialog();
                    Log.i(TAG, "onResponse: ============onResponse===========");

                    FileUploadResponse body = response.body();

                    if (body != null) {

                        boolean res = body.isRes();
                        String message = body.getMessage();
                        if (res) {

                            if (TextUtils.isEmpty(message)) {
                                Toast.makeText(TiYouDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(TiYouDetailActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                            finish();

                        } else {
                            if (TextUtils.isEmpty(message)) {
                                Toast.makeText(TiYouDetailActivity.this, "新增失败", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(TiYouDetailActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                        }


                    }

                }

                @Override
                public void onFailure(Call<FileUploadResponse> call, Throwable t) {

                    LogUtils.i(t.getMessage());
                    Log.i(TAG, "onResponse: ============onFailure===========");
                    disDialog();
                    Toast.makeText(TiYouDetailActivity.this, "上传超时", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111 && resultCode == 112) {
//            Log.i(TAG, "onActivityResult: =批次=" + data.getStringExtra("batchId"));
            getOilPici.setContet(data.getStringExtra("batchId"));
//            tiYouBean.setBatchId(data.getStringExtra("batchId"));


        } else {
            // 2、在Activity中的onActivityResult()方法里与LQRPhotoSelectUtils关联
            mLqrPhotoSelectUtils.attachToActivityForResult(requestCode, resultCode, data);
        }


    }

    @Override
    public void onClickListener(SuperTextView superTextView) {


        if (isChakanDetail) {

            Log.i(TAG, "onClickListener: 查看图片");

            if (TextUtils.isEmpty(fileUrlId)) {
                Toast.makeText(this, "请稍后再试", Toast.LENGTH_SHORT).show();
                return;
            }

            String downFileUrl = Constant.BASE_URL + "/busi/interface/fileDownLoad/" + fileUrlId;
            Log.i(TAG, "onClickListener: =====" + downFileUrl);
            Intent intent = new Intent(TiYouDetailActivity.this, ImagesDetailActivity.class);
            intent.putExtra(ImagesDetailActivity.INTENT_IMAGE_URL_TAG, downFileUrl);
            startActivity(intent);


        } else {
            showBottomDialog();
        }


    }


    BottomMenuDialog menuDialog;

    private void showBottomDialog() {

        menuDialog = new BottomMenuDialog.Builder(TiYouDetailActivity.this)
                .setTitle("上传图片")
                .addMenu("从手机相册选择", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(TiYouDetailActivity.this, "相册选择", Toast.LENGTH_SHORT).show();

                        takePicFromGallery();

                        menuDialog.dismiss();
                    }
                }).addMenu("拍照选择", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(TiYouDetailActivity.this, "拍照选择", Toast.LENGTH_SHORT).show();
                        takePicFromPhoto();
                        menuDialog.dismiss();
                    }
                }).create();

        menuDialog.show();

    }

    private void takePicFromPhoto() {

        // 3、调用拍照方法
        PermissionGen.with(TiYouDetailActivity.this)
                .addRequestCode(LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
                .permissions(Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                ).request();

    }

    private void takePicFromGallery() {
        PermissionGen.needPermission(TiYouDetailActivity.this,
                LQRPhotoSelectUtils.REQ_SELECT_PHOTO,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}
        );


    }


    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void takePhoto() {
        mLqrPhotoSelectUtils.takePhoto();
    }

    @PermissionSuccess(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void selectPhoto() {
        mLqrPhotoSelectUtils.selectPhoto();
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_TAKE_PHOTO)
    private void showTip1() {
        //        Toast.makeText(getApplicationContext(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @PermissionFail(requestCode = LQRPhotoSelectUtils.REQ_SELECT_PHOTO)
    private void showTip2() {
        //        Toast.makeText(getApplicationContext(), "不给我权限是吧，那就别玩了", Toast.LENGTH_SHORT).show();
        showDialog();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        // 2、在Activity中的onActivityResult()方法里与LQRPhotoSelectUtils关联
//        mLqrPhotoSelectUtils.attachToActivityForResult(requestCode, resultCode, data);
//    }

    public void showDialog() {
        //创建对话框创建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置对话框显示小图标
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //设置标题
        builder.setTitle("权限申请");
        //设置正文
        builder.setMessage("在设置-应用-权限 中开启相机、存储权限，才能正常使用拍照或图片选择功能");

        //添加确定按钮点击事件
        builder.setPositiveButton("去设置", new DialogInterface.OnClickListener() {//点击完确定后，触发这个事件

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //这里用来跳到手机设置页，方便用户开启权限
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + TiYouDetailActivity.this.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        //添加取消按钮点击事件
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        //使用构建器创建出对话框对象
        AlertDialog dialog = builder.create();
        dialog.show();//显示对话框
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

    class carInfoNum {


        /**
         * code : 川A34995
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
