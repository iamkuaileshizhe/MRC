package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/1.
 */

public class SupplyListActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
//    @BindView(R.id.top_bar_finish_ll)
//    LinearLayout topBarFinishLl;
//    @BindView(R.id.top_bar_title_tv)
//    TextView topBarTitleTv;
//    @BindView(R.id.top_bar_ok_ll)
//    LinearLayout topBarOkLl;

    @Override
    public void initContentView() {

        setContentView(R.layout.supply_list_layout);


    }

    @Override
    public void initView() {
        topBarTitleTv.setText("供应商列表");
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }

}
