package com.neocom.mobilerefueling.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/2/9.
 * <p>
 * 加油车 司机 接单
 */

public class JieDanAtivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;

    @Override
    public void initContentView() {
        setContentView(R.layout.jiayou_layout);

    }

    @Override
    public void initView() {
        topBarTitleTv.setText("派送单列表");
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
