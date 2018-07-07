package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.fragment.DaiJieBanFragment;
import com.neocom.mobilerefueling.fragment.JiaoBanFragment;
import com.neocom.mobilerefueling.fragment.TiYouNewAllFragment;
import com.neocom.mobilerefueling.fragment.TiYouNewYiQueRenFragment;
import com.neocom.mobilerefueling.fragment.TiYouNewYiWeiQueRenFragment;
import com.neocom.mobilerefueling.fragment.YiJieBanFragment;
import com.neocom.mobilerefueling.utils.AddFragmentUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/10/26.
 */

public class TiYouNewActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.add_work_ll)
    LinearLayout addWorkLl;
    @BindView(R.id.top_title_bar_rl)
    RelativeLayout topTitleBarRl;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    //    private TabLayout mTabLayout;
//    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragment;
//    LinearLayout addWorkLl;

    @Override
    public void initContentView() {
        setContentView(R.layout.change_wk_layout);
    }

    @Override
    public void initView() {

//        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
//        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
//        addWorkLl = (LinearLayout) findViewById(R.id.add_work_ll);

        topBarTitleTv.setText("提油记录列表");
        addWorkLl.setVisibility(View.GONE);

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        addWorkLl.setOnClickListener(this);
        mTitle = new ArrayList<>();
        mTitle.add("全部");
//        mTitle.add("已确认");
//        mTitle.add("未确认");
        mTitle.add("已完成");
        mTitle.add("待处理");


        mFragment = new ArrayList<>();
//        mFragment.add(new DaiJieBanFragment());
        mFragment.add(new TiYouNewAllFragment());
//        mFragment.add(new YiJieBanFragment());
        mFragment.add(new TiYouNewYiQueRenFragment());
//        mFragment.add(new JiaoBanFragment());
        mFragment.add(new TiYouNewYiWeiQueRenFragment());

//        如果是 已确认，则显示 提交的信息 输入 否则 不显示 信息提交输入 只展示

        AddFragmentUtils.addTab(mTabLayout, mViewPager, mFragment, mTitle, getSupportFragmentManager());


    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(UIUtils.getContext(), AddChangeWorkActivity.class));
    }


}
