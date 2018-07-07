package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.neocom.mobilerefueling.R;

/**
 * Created by admin on 2017/11/20.
 */

public class BuJiQueRenActivity extends BaseActivity {


    @Override
    public void initContentView() {
        setContentView(R.layout.bu_ji_que_ren_layout);
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
