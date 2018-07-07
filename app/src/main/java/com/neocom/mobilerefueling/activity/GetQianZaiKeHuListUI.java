package com.neocom.mobilerefueling.activity;


import android.content.Intent;
import android.view.View;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;

/**
 * Created by Administrator on 2018/1/31.
 */

public class GetQianZaiKeHuListUI extends BaseActivity {

    @Override
    public void initContentView() {
        setContentView(R.layout.qianzaikehu_list_ui_layout);

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.top_bar_ok_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UIUtils.getContext(), AddQianZaiKeHuActivity.class));

            }
        });
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }


}
