package com.neocom.mobilerefueling.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.neocom.mobilerefueling.R;
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
 * Created by admin on 2017/9/7.
 */

public class YunYouCheListFragment extends BaseFragment {
    @BindView(R.id.indicator_driver_mic_fg)
    MagicIndicator indicatorDriverMicFg;
    @BindView(R.id.vp_worksign_driver_vp_fg)
    HorizontalViewPager vpWorksignDriverVpFg;
    //    Unbinder unbinder;
    private String[] mTabNames = UIUtils.getStringArray(R.array.order_list_names);
    private View view;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.driver_receive_list_layout);
        return view;
    }

    @Override
    public void initView() {
        initViewPager();
    }


    @Override
    public void initData() {

    }

    private void initViewPager() {

        DriverRecAdapter recAdapter = new DriverRecAdapter(getChildFragmentManager());

        vpWorksignDriverVpFg.setAdapter(recAdapter);
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
                //                simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
                simplePagerTitleView.setNormalColor(Color.BLACK);
//                simplePagerTitleView.setSelectedColor(Color.WHITE);
                simplePagerTitleView.setSelectedColor(Color.parseColor("#0084ff"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vpWorksignDriverVpFg.setCurrentItem(index);
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

        indicatorDriverMicFg.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(UIUtils.getContext(), 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(indicatorDriverMicFg, vpWorksignDriverVpFg);
    }


    class DriverRecAdapter extends FragmentStatePagerAdapter {

        private String[] mTabNames;

        public DriverRecAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.order_list_names);


//            order_list_names
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return super.getPageTitle(position);

            return mTabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            return YunYouCheFactory.createFragment(position);
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


}
