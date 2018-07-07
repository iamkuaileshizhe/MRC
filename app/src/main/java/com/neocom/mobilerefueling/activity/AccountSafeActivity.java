package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/6.
 */

public class AccountSafeActivity extends BaseActivity implements SuperTextView.OnSuperTextViewClickListener {
    @BindView(R.id.account_top_bar)
    TopTitleBar accountTopBar;
    @BindView(R.id.account_change_pwd)
    SuperTextView accountChangePwd;
    @BindView(R.id.account_change_phone)
    SuperTextView accountChangePhone;
    @BindView(R.id.account_userinfo)
    SuperTextView accountUserinfo;


    @Override
    public void initContentView() {
        setContentView(R.layout.activity_account_safe);
    }

    @Override
    public void initView() {
        accountTopBar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });
    }

    @Override
    public void initData() {
        accountChangePwd.setOnSuperTextViewClickListener(this);
        accountChangePhone.setOnSuperTextViewClickListener(this);
        accountUserinfo.setOnSuperTextViewClickListener(this);
    }


    @Override
    public void onClickListener(SuperTextView superTextView) {

        switch (superTextView.getId()) {

            case R.id.account_change_pwd:
                startActivity(new Intent(UIUtils.getContext(), UpdatePwd.class));
                break;
            case R.id.account_change_phone:

                break;
            case R.id.account_userinfo:
                startActivity(new Intent(UIUtils.getContext(), UserInfoActivity.class));
                break;


        }

    }
}
