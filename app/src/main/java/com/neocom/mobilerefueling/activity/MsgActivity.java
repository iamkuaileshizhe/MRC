package com.neocom.mobilerefueling.activity;

import android.view.View;

import com.neocom.mobilerefueling.R;

/**
 * Created by admin on 2017/11/20.
 */

public class MsgActivity extends BaseActivity {
    @Override
    public void initContentView() {
        setContentView(R.layout.mag_layout);
    }

    @Override
    public void initView() {

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
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
