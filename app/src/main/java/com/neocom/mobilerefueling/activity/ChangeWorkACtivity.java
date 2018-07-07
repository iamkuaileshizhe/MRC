package com.neocom.mobilerefueling.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.fragment.ChangeWorkFactory;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.HorizontalViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import butterknife.BindView;

/**
 * Created by admin on 2017/10/23.
 * 交接班
 */

public class ChangeWorkACtivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.top_title_bar_rl)
    RelativeLayout topTitleBarRl;
    @BindView(R.id.change_work_mic_fg)
    MagicIndicator changeWorkMicFg;
    @BindView(R.id.vp_work_vp_fg)
    HorizontalViewPager vpWorkVpFg;
    private String[] mTabNames = UIUtils.getStringArray(R.array.change_list_names);
    @Override
    public void initContentView() {

        setContentView(R.layout.change_work_activity);


    }

    @Override
    public void initView() {
        topBarFinishLl.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        initViewPager();
    }

    @Override
    public void initData() {

    }




    private void initViewPager() {

        ChangeWorkAdapter recAdapter = new ChangeWorkAdapter(getSupportFragmentManager());

        vpWorkVpFg.setAdapter(recAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(UIUtils.getContext());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTabNames == null ? 0 : mTabNames.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {


                final BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTabNames[index]);
                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpWorkVpFg.setCurrentItem(index);
                        badgePagerTitleView.setBadgeView(null); // cancel badge when click tab
                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);

                badgePagerTitleView.setAutoCancelBadge(false);

                return badgePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }
        });

        changeWorkMicFg.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(UIUtils.getContext(), 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(changeWorkMicFg, vpWorkVpFg);
    }


    class ChangeWorkAdapter extends FragmentStatePagerAdapter {

        private String[] mTabNames;

        public ChangeWorkAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.change_list_names);
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return super.getPageTitle(position);

            return mTabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            return ChangeWorkFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return mTabNames.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);

            Log.i(TAG, "destroyItem: ========================================" + position);

        }
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.top_bar_finish_ll:

                finish();

                break;
            case R.id.btn_add:


//                startActivity(new Intent(UIUtils.getContext(),));

                break;


        }


    }

}
