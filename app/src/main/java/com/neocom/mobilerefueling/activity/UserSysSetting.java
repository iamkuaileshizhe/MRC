package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.view.TopTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/6/26.
 */

public class UserSysSetting extends BaseActivity implements SuperTextView.OnSuperTextViewClickListener {
    @BindView(R.id.setting_topbar)
    TopTitleBar settingTopbar;
    @BindView(R.id.sys_setting_danwei)
    SuperTextView sysSettingDanwei;
    @BindView(R.id.sys_setting_voice)
    SuperTextView sysSettingVoice;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_user_sys_setting_layout);
    }

    @Override
    public void initView() {
        settingTopbar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });
        sysSettingDanwei.setOnSuperTextViewClickListener(this);
        sysSettingVoice.setOnSuperTextViewClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClickListener(SuperTextView superTextView) {

        switch (superTextView.getId()) {

            case R.id.sys_setting_danwei:

                startActivity(new Intent(this, UserSettingActivity.class));

                break;
            case R.id.sys_setting_voice:

                startActivity(new Intent(this, VoiceSettingActivity.class));

                break;

        }

    }
}
