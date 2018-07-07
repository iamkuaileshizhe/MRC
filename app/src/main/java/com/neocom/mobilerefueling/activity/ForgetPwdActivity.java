package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.neocom.mobilerefueling.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/11/27.
 */

public class ForgetPwdActivity extends BaseActivity {
    @BindView(R.id.et_forget_tel)
    EditText etForgetTel;
    @BindView(R.id.et_forget_pwd)
    EditText etForgetPwd;
    @BindView(R.id.et_forget_comfirm)
    EditText etForgetComfirm;
    @BindView(R.id.et_forget_yzm)
    EditText etForgetYzm;
    @BindView(R.id.btn_forget_yzm)
    Button btnForgetYzm;
    @BindView(R.id.btn_forget_confirm)
    Button btnForgetConfirm;
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;

    @Override
    public void initContentView() {
        setContentView(R.layout.forget_pwd_layout);
    }

    @Override
    public void initView() {

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void initData() {

    }

}
