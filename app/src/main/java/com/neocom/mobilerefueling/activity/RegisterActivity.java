package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.listener.IDCheckInfoCalBack;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.TimeCountUtil;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/25.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.logo_rl)
    RelativeLayout logoRl;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.iv_clean_username)
    ImageView ivCleanUsername;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(R.id.iv_clean_iv)
    ImageView ivCleanIv;
    @BindView(R.id.reg_et_token)
    EditText regEtToken;
    @BindView(R.id.reg_btn_register)
    Button regBtnRegister;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.clean_password)
    ImageView cleanPassword;
    @BindView(R.id.iv_show_pwd)
    ImageView ivShowPwd;
    @BindView(R.id.et_car_no)
    EditText etCarNo;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.root)
    RelativeLayout root;

    @BindView(R.id.iv_clean_carno)
    ImageView ivCleanCarno;
    @BindView(R.id.et_user_card)
    EditText etUserCard;
    @BindView(R.id.iv_clean_user_card)
    ImageView ivCleanUserCard;

    private TimeCountUtil mTimeCountUtil;

    @Override
    public void initContentView() {

        setContentView(R.layout.register_layout);


    }

    @Override
    public void initView() {
        ivCleanUsername.setOnClickListener(this);
        ivCleanIv.setOnClickListener(this);
        regBtnRegister.setOnClickListener(this);
        ivShowPwd.setOnClickListener(this);
        ivCleanCarno.setOnClickListener(this);
        ivCleanUserCard.setOnClickListener(this);
        userName.addTextChangedListener(new myInoutWatcher(userName));
        etUserPhone.addTextChangedListener(new myInoutWatcher(etUserPhone));
        etPassword.addTextChangedListener(new myInoutWatcher(etPassword));
        etCarNo.addTextChangedListener(new myInoutWatcher(etCarNo));
        etUserCard.addTextChangedListener(new myInoutWatcher(etUserCard));
        mTimeCountUtil = new TimeCountUtil(regBtnRegister, 5000, 1000);
        checkIDCard();

        getDeviceInfo();

    }

    private void getDeviceInfo() {

        DeviceInfo deviceInfo = new DeviceInfo();

        int screenWidth = CommonUtil.getScreenWidth(RegisterActivity.this);
        String screenWidthStr = String.valueOf(screenWidth);
        deviceInfo.setWidth(screenWidthStr);
        int screenHeight = CommonUtil.getScreenHeight(RegisterActivity.this);
        String screenHeightStr = String.valueOf(screenHeight);
        deviceInfo.setHeight(screenHeightStr);
        String ipStr = CommonUtil.getLocalIpAddress();
        deviceInfo.setIpAddress(ipStr);

        String phoneBrand = CommonUtil.getPhoneBrand();
        deviceInfo.setEquModel(phoneBrand);

        String buildVersion = CommonUtil.getBuildVersion();
        deviceInfo.setSystemModel(buildVersion);
        Log.i(TAG, "getDeviceInfo: ====" + new Gson().toJson(deviceInfo));

        getRcodeByEquInfo(deviceInfo);

    }

    private void getRcodeByEquInfo(DeviceInfo deviceInfo) {

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(deviceInfo);
        HttpManger.getHttpMangerInstance().getServices().getRcodeByEquInfo(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                EmptyBringGetOilBean body = response.body();

                if (body != null) {

                    boolean res = body.isRes();

                    if (res){
                        String bring = body.getBring();



                    }


                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {

            }
        });

    }


    private void checkIDCard() {

        etUserCard.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    final String idCardNum = etUserCard.getText().toString().trim();

                    if (TextUtils.isEmpty(idCardNum)) {
                        return;
                    }

                    try {
                        CommonUtil.IDCardValidate(idCardNum, new IDCheckInfoCalBack() {
                            @Override
                            public void checkInfo(String infoCard) {
                                Toast.makeText(RegisterActivity.this, infoCard, Toast.LENGTH_SHORT).show();
//                                etUserCard.setSelection(idCardNum.length());
//                                etUserCard.requestFocus();//获取焦点
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_clean_username:
                userName.setText("");
                break;
            case R.id.iv_clean_iv:
                etUserPhone.setText("");
                break;
            case R.id.reg_btn_register:
                mTimeCountUtil.start();
                // TODO 请求验证码

                break;
            case R.id.iv_show_pwd:


                if (etPassword.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    ivShowPwd.setImageResource(R.drawable.pass_visuable);
                } else {
                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ivShowPwd.setImageResource(R.drawable.pass_gone);
                }
                String pwd = etPassword.getText().toString();
                if (!TextUtils.isEmpty(pwd)) {
                    etPassword.setSelection(pwd.length());
                }

                break;

            case R.id.iv_clean_carno:
                etCarNo.setText("");
                break;
            case R.id.iv_clean_user_card:
                etUserCard.setText("");
                break;

        }

    }


    public class myInoutWatcher implements TextWatcher {
        View inputview;

        public myInoutWatcher(View inputview) {
            this.inputview = inputview;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {


            switch (inputview.getId()) {
                case R.id.user_name:
//                    if (!TextUtils.isEmpty(s) && ivCleanUsername.getVisibility() == View.GONE) {
//                        ivCleanUsername.setVisibility(View.VISIBLE);
//                    } else if (TextUtils.isEmpty(s)) {
//                        ivCleanUsername.setVisibility(View.GONE);
//                    }
                    showCleanIv(s, ivCleanUsername);
                    break;
                case R.id.et_user_phone:

                    showCleanIv(s, ivCleanIv);

//                    if (!TextUtils.isEmpty(s) && ivCleanIv.getVisibility() == View.GONE) {
//                        ivCleanIv.setVisibility(View.VISIBLE);
//                    } else if (TextUtils.isEmpty(s)) {
//                        ivCleanIv.setVisibility(View.GONE);
//                    }

                    if (s.toString().isEmpty()) {
                        return;
                    }

                    String phoneNum = etUserPhone.getText().toString().trim();

                    if (phoneNum.length() == 11) {

                        boolean mobileNumber = CommonUtil.isMobileNumber(phoneNum);

                        if (!mobileNumber) {

                            Toast.makeText(RegisterActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();

                        }

                    }


                    break;

                case R.id.et_password:

//                    if (!TextUtils.isEmpty(s) && cleanPassword.getVisibility() == View.GONE) {
//                        cleanPassword.setVisibility(View.VISIBLE);
//                    } else if (TextUtils.isEmpty(s)) {
//                        cleanPassword.setVisibility(View.GONE);
//                    }
                    showCleanIv(s, cleanPassword);
                    if (s.toString().isEmpty()) {
                        return;
                    }
                    if (!s.toString().matches("[A-Za-z0-9]+")) {
                        String temp = s.toString();
                        Toast.makeText(RegisterActivity.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                        s.delete(temp.length() - 1, temp.length());
                        etPassword.setSelection(s.length());
                    }


                    break;

                case R.id.et_car_no:

//                    if (!TextUtils.isEmpty(s) && ivCleanCarno.getVisibility() == View.GONE) {
//                        ivCleanCarno.setVisibility(View.VISIBLE);
//                    } else if (TextUtils.isEmpty(s)) {
//                        ivCleanCarno.setVisibility(View.GONE);
//                    }
                    showCleanIv(s, ivCleanCarno);
                    break;
                case R.id.et_user_card:

//                    if (!TextUtils.isEmpty(s) && ivCleanUserCard.getVisibility() == View.GONE) {
//                        ivCleanUserCard.setVisibility(View.VISIBLE);
//                    } else if (TextUtils.isEmpty(s)) {
//                        ivCleanUserCard.setVisibility(View.GONE);
//                    }

                    showCleanIv(s, ivCleanUserCard);

                    break;


            }


        }
    }

    private void showCleanIv(Editable s, ImageView iv) {

        if (!TextUtils.isEmpty(s) && iv.getVisibility() == View.GONE) {
            iv.setVisibility(View.VISIBLE);
        } else if (TextUtils.isEmpty(s)) {
            iv.setVisibility(View.GONE);
        }

    }


}
