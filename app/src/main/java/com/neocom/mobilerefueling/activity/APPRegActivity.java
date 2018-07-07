package com.neocom.mobilerefueling.activity;


import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.view.CircleImageAvtar;

import butterknife.BindView;

/**
 * Created by admin on 2017/10/24.
 */

public class APPRegActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.reg_logo)
    CircleImageAvtar regLogo;
    @BindView(R.id.reg_et_mobile)
    EditText regEtMobile;
    @BindView(R.id.iv_clean_phone)
    ImageView ivCleanPhone;
    @BindView(R.id.reg_et_token)
    EditText regEtToken;
    @BindView(R.id.reg_btn_register)
    Button regBtnRegister;
    @BindView(R.id.reg_et_password)
    EditText regEtPassword;
    @BindView(R.id.clean_password)
    ImageView cleanPassword;
    @BindView(R.id.iv_show_pwd)
    ImageView ivShowPwd;
    @BindView(R.id.reg_cb)
    CheckBox regCb;
    @BindView(R.id.reg_btn_login)
    Button regBtnLogin;
    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.root)
    RelativeLayout root;



    // 验证码
    private int time_count;
    private Runnable thread;
    @Override
    public void initContentView() {
        setContentView(R.layout.app_register_layout);
    }

    @Override
    public void initView() {
        regBtnRegister.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.reg_btn_register:




//                if (TextUtils.isEmpty(name)) {
//                    CommonUtil.showToask(this, "请输入手机号");
//                    return;
//                }
//                if (!CommonUtil.isMobileNumber(name)) {
//                    CommonUtil.showToask(this, "手机号格式不正确");
//                    return;
//                }
                time_count = 60;
                thread = new Runnable() {
                    public void run() {
                        regBtnRegister.setText("(" + time_count + ")秒后重发");
                        if (time_count > 0) {
                            regBtnRegister.postDelayed(thread, 1000);
                            time_count--;
                        } else {
                            regBtnRegister.setText("获取验证码");
                            regBtnRegister.setBackgroundResource(R.drawable.rec_stroke_grey);
                            regBtnRegister.setClickable(true);
                            time_count = 60;
                        }
                    }
                };

                regBtnRegister.post(thread);
                break;

        }
    }
}
