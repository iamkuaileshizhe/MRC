package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.YpGbDownAdapter;
import com.neocom.mobilerefueling.bean.AddPiCiBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.FileUploadResponse;
import com.neocom.mobilerefueling.bean.OilLXGBBean;
import com.neocom.mobilerefueling.bean.SupplyListBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.isEditeTextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/2.
 */

public class AddPiCiActivity extends BaseActivity implements View.OnClickListener, SuperTextView.OnSuperTextViewClickListener {

//    saveBatchManager

    //    AddPiCiBean

    List<OilLXGBBean.BringBean> bringGb;
    List<OilLXGBBean.BringBean> bringLx;
    List<OilLXGBBean.BringBean> bringSupplyList;
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.youpin_type)
    SuperTextView youpinType;
    @BindView(R.id.youpin_gb)
    SuperTextView youpinGb;
    @BindView(R.id.supply_list)
    SuperTextView supplyList;
    @BindView(R.id.sample_no)
    isEditeTextView sampleNo;
    @BindView(R.id.fuel_density)
    isEditeTextView fuelDensity;
    @BindView(R.id.supply_name)
    isEditeTextView supplyName;
    @BindView(R.id.supply_tel)
    isEditeTextView supplyTel;
    @BindView(R.id.add_file)
    SuperTextView addFile;
    @BindView(R.id.note_info)
    EditText noteInfo;
    @BindView(R.id.remain_text)
    TextView remainText;
    @BindView(R.id.other_info)
    RelativeLayout otherInfo;

    AddPiCiBean addPiCiBean;
    @BindView(R.id.submit_now)
    Button submitNow;

    @Override
    public void initContentView() {
        setContentView(R.layout.add_pici_layout);

    }

    @Override
    public void initView() {

        noteInfo.addTextChangedListener(textWatcher);
        remainText.setText("剩余" + 50 + "字");
        topBarFinishLl.setOnClickListener(this);
        topBarTitleTv.setText("新增油品批次");
        youpinType.setOnSuperTextViewClickListener(this);
        youpinGb.setOnSuperTextViewClickListener(this);
        supplyList.setOnSuperTextViewClickListener(this);
        addFile.setOnSuperTextViewClickListener(this);
        submitNow.setOnClickListener(this);

        addPiCiBean = new AddPiCiBean();
        getCYLXFromServer();
        getGBFromServer();
        getSupplistFromServer();
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

//                        SPUtils.saveContent(Constant.CY_LX, new Gson().toJson(body));
                        bringLx = bring;
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

//                        SPUtils.saveContent(Constant.CY_GB, new Gson().toJson(body));
                        bringGb = bring;
                    }
                }


            }

            @Override
            public void onFailure(Call<OilLXGBBean> call, Throwable t) {
                Log.i(TAG, "onFailure: 返回失败");
            }
        });
    }

    private void getSupplistFromServer() {

//        findSupplyList

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(new EmBody());
        HttpManger.getHttpMangerInstance().getServices().findSupplyList(requestBody).enqueue(new Callback<SupplyListBean>() {
            @Override
            public void onResponse(Call<SupplyListBean> call, Response<SupplyListBean> response) {

                SupplyListBean body = response.body();

                boolean res = body.isRes();

                if (res) {

                    List<SupplyListBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        converToDicBean(bring);

                    }


                }


            }

            @Override
            public void onFailure(Call<SupplyListBean> call, Throwable t) {

            }
        });


    }


    private void converToDicBean(List<SupplyListBean.BringBean> bring) {

        bringSupplyList = new ArrayList<>();

        if (bring.size() >= 0) {

            for (int i = 0; i < bring.size(); i++) {
                OilLXGBBean.BringBean bringItemBean = new OilLXGBBean.BringBean();
                SupplyListBean.BringBean bringBean = bring.get(i);
                String id = bringBean.getId();
                bringItemBean.setDictValue(id);
                String name = bringBean.getName();
                bringItemBean.setDictName(name);
                bringSupplyList.add(bringItemBean);

            }


        }

    }

    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;

    private void showPopItems(List<OilLXGBBean.BringBean> datas, final View parenr) {
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

            final YpGbDownAdapter adapter = new YpGbDownAdapter(AddPiCiActivity.this, datas);
            menulistLeft.setAdapter(adapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(AddQianZaiKeHuActivity.this, "选择的是" + adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();

                    String chooseStr = adapter.getItem(position).getDictName();
                    String chooseCode = adapter.getItem(position).getDictValue();

                    switch (parenr.getId()) {

                        case R.id.youpin_type:

                            youpinType.setRightString(chooseStr);
                            addPiCiBean.setFuelModel(chooseCode);

                            break;

                        case R.id.youpin_gb:

                            youpinGb.setRightString(chooseStr);
                            addPiCiBean.setNationalStandard(chooseCode);

                            break;
                        case R.id.supply_list:

                            supplyList.setRightString(chooseStr);
                            addPiCiBean.setSupplyId(chooseCode);

                            break;


                    }

                    Log.i(TAG, "onItemClick: " + new Gson().toJson(adapter.getItem(position)));

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

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.top_bar_finish_ll:
                finish();
                break;
            case R.id.submit_now:

                getdataFromView();

                break;


        }

    }

    private void getdataFromView() {

        String fuelModel = addPiCiBean.getFuelModel();

        if (TextUtils.isEmpty(fuelModel)) {
            Toast.makeText(this, "请选择油品型号", Toast.LENGTH_SHORT).show();
            return;
        }

        String nationalStandard = addPiCiBean.getNationalStandard();
        if (TextUtils.isEmpty(nationalStandard)) {
            Toast.makeText(this, "请选择油品国标", Toast.LENGTH_SHORT).show();
            return;

        }
        String supplyId = addPiCiBean.getSupplyId();

        if (TextUtils.isEmpty(supplyId)) {
            Toast.makeText(this, "请选择供应商", Toast.LENGTH_SHORT).show();
            return;
        }
        String sampleNoContent = sampleNo.getContent();
        if (TextUtils.isEmpty(sampleNoContent)) {
            Toast.makeText(this, sampleNo.getisEtvHint(), Toast.LENGTH_SHORT).show();
            return;
        }
        addPiCiBean.setSampleNo(sampleNoContent);

        String fuelDensityContent = fuelDensity.getContent();
        if (TextUtils.isEmpty(fuelDensityContent)) {
            Toast.makeText(this, fuelDensity.getisEtvHint(), Toast.LENGTH_SHORT).show();
            return;
        }
        addPiCiBean.setFuelDensity(fuelDensityContent);

        String supplyNameContent = supplyName.getContent();

        if (TextUtils.isEmpty(supplyNameContent)) {
            Toast.makeText(this, supplyName.getisEtvHint(), Toast.LENGTH_SHORT).show();
            return;
        }
        addPiCiBean.setSupplyName(supplyNameContent);

        String supplyTelContent = supplyTel.getContent();

        if (TextUtils.isEmpty(supplyTelContent)) {

            Toast.makeText(this, supplyTel.getisEtvHint(), Toast.LENGTH_SHORT).show();
            return;
        }
        addPiCiBean.setSupplyTel(supplyTelContent);

        String note = noteInfo.getText().toString().trim();
        addPiCiBean.setRemark(note);

        Log.i(TAG, "getdataFromView: ===" + new Gson().toJson(addPiCiBean));
        sendDataToServer();


    }

    private void sendDataToServer() {
        showLoadingDialog("提交中...");
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(addPiCiBean);
        HttpManger.getHttpMangerInstance().getServices().saveBatchManager(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
                disDialog();
                EmptyBringGetOilBean body = response.body();

                if (body != null) {

                    String message = body.getMessage();
                    boolean res = body.isRes();

                    if (res) {

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(AddPiCiActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddPiCiActivity.this, message, Toast.LENGTH_SHORT).show();
                        }

                        FileUpLoad(body.getBring());

                    } else {
                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(AddPiCiActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddPiCiActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                }


            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                disDialog();
                Toast.makeText(AddPiCiActivity.this, "添加超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    @Override
    public void onClickListener(SuperTextView superTextView) {

        switch (superTextView.getId()) {

            case R.id.youpin_type:
                if (bringLx == null || bringLx.size() == 0) {
                    Toast.makeText(this, "获取油品类型有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                showPopItems(bringLx, youpinType);
                break;
            case R.id.youpin_gb:
                if (bringGb == null || bringGb.size() == 0) {
                    Toast.makeText(this, "获取油品国标有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                showPopItems(bringGb, youpinGb);
                break;
            case R.id.supply_list:
                if (bringSupplyList == null || bringSupplyList.size() == 0) {
                    Toast.makeText(this, "获取供应商有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                showPopItems(bringSupplyList, supplyList);
                break;

            case R.id.add_file:
//                Toast.makeText(this, "选择文件", Toast.LENGTH_SHORT).show();

                openChooseFile();

                break;

        }


    }

    private void openChooseFile() {


        new LFilePicker()
                .withActivity(this)
                .withRequestCode(Constant.REQUESTCODE_FROM_ACTIVITY)
                .withTitle("文件选择")
                .withIconStyle(com.leon.lfilepickerlibrary.utils.Constant.ICON_STYLE_BLUE)
                .withBackIcon(com.leon.lfilepickerlibrary.utils.Constant.BACKICON_STYLEONE)
                .withMutilyMode(false)
                .withMaxNum(2)
                .withStartPath("/storage/emulated/0/Download")//指定初始显示路径
                .withNotFoundBooks("至少选择一个文件")
                .withIsGreater(false)//过滤文件大小 小于指定大小的文件
                .withFileSize(4096 * 1024)//指定文件大小为2M
//                .withChooseMode(true)//文件夹选择模式
//                .withFileFilter(new String[]{"txt", "png", "docx", "pdf"})
//                .withFileFilter(new String[]{"txt"})
                .withFileFilter(new String[]{"pdf", "png", "jpg", "jpeg"})
                .start();


    }

    String filePathStr;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == Constant.REQUESTCODE_FROM_ACTIVITY) {
                List<String> list = data.getStringArrayListExtra(com.leon.lfilepickerlibrary.utils.Constant.RESULT_INFO);
                for (String s : list) {
//                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "onActivityResult: ===》" + s.toString());

                    filePathStr = s;

                    addFile.setRightString(s.substring(s.lastIndexOf("/") + 1));

//                    String fileName = fName.substring(fName.lastIndexOf("/")+1);

                }
//                Toast.makeText(getApplicationContext(), "选中了" + list.size() + "个文件", Toast.LENGTH_SHORT).show();
                String path = data.getStringExtra("path");
//                Toast.makeText(getApplicationContext(), "选中的路径为" + path, Toast.LENGTH_SHORT).show();
                Log.i("LeonFilePicker", path);
            }
        }
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

        if (TextUtils.isEmpty(filePathStr)) {
            finish();

        } else {
            showLoadingDialog("附件上传中...");
            RequestBody bodyParam = null;
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.addFormDataPart("userId", GetUserInfoUtils.getUserInfo().getUserId());
            builder.addFormDataPart("thingId", thingId);
            MediaType fileType = MediaType.parse("application/octet-stream");
            File file = new File(filePathStr);

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
                                Toast.makeText(AddPiCiActivity.this, "新增成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(AddPiCiActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                            finish();

                        } else {
                            if (TextUtils.isEmpty(message)) {
                                Toast.makeText(AddPiCiActivity.this, "新增失败", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(AddPiCiActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                        }


                    }

                }

                @Override
                public void onFailure(Call<FileUploadResponse> call, Throwable t) {
                    Log.i(TAG, "onResponse: ============onFailure===========");
                    disDialog();
                    Toast.makeText(AddPiCiActivity.this, "上传超时", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }


    public class EmBody {


    }
}
