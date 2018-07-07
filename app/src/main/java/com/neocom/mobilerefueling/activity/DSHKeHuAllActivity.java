package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/6.
 */

public class DSHKeHuAllActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;

    @Override
    public void initContentView() {
        setContentView(R.layout.dsh_kehu_all_layout);
    }

    @Override
    public void initView() {
        topBarTitleTv.setText("待处理列表查询");
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


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        dispatchTouchEvent(ev);
//        return super.dispatchTouchEvent(ev);
//    }
//
//
//    public interface MyOnTouchListener {
//        public boolean dispatchTouchEvent(MotionEvent ev);
//    }

}
