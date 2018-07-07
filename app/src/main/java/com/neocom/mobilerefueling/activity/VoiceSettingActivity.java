package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/6/21.
 */

public class VoiceSettingActivity extends BaseActivity {


    @BindView(R.id.voice_setting_topbar)
    TopTitleBar voiceSettingTopbar;
    @BindView(R.id.voice_tts_speach)
    SuperTextView voiceTtsSpeach;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_voice_setting);
    }

    @Override
    public void initView() {
        boolean ttsState = SPUtils.getTTSState();

        voiceTtsSpeach.setSwitchIsChecked(ttsState);
        TTSSetting();

    }

    @Override
    public void initData() {

    }

    private void TTSSetting() {
        voiceTtsSpeach.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                superTextView.setSwitchIsChecked(!superTextView.getSwitchIsChecked());
            }
        }).setSwitchCheckedChangeListener(new SuperTextView.OnSwitchCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SPUtils.setTTSState(isChecked);

            }
        });


    }

}
