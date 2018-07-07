package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/10.
 */

public class JiaoJieBanCarListActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;

    @Override
    public void initContentView() {

        setContentView(R.layout.cheliang_list_layout);

    }

    @Override
    public void initView() {
        topBarTitleTv.setText("交接班车辆选择");
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
