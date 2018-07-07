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

//import com.huanyu.itsms.R;
//import com.huanyu.itsms.utils.UIUtils;

/**
 * Created by admin on 2017/7/17.
 */

public class WorkSignFragment extends BaseFragment {

    private View view;
//    private List<SwipeBean> mDatas;
    //    private LinearLayoutManager mLayoutManager;
    private String[] mTabNames = UIUtils.getStringArray(R.array.tab_names);

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.work_sign_fragment);
        return view;
    }

    @Override
    public void initView() {
//        TextView textView = view.findViewById(R.id.tv_home_fg);
//        textView.setText(getClass().getSimpleName());

//        final RecyclerView mRv = view.findViewById(R.id.rv);
//
//        final SwipeDelAdapter mAdapter = new SwipeDelAdapter(UIUtils.getContext(), mDatas);
//        mAdapter.setOnDelListener(new SwipeDelAdapter.onSwipeListener() {
//            @Override
//            public void onDel(int pos) {
//
//                if (pos >= 0 && pos < mDatas.size()) {
//                    Toast.makeText(UIUtils.getContext(), "删除:" + pos, Toast.LENGTH_SHORT).show();
//                    mDatas.remove(pos);
//                    mAdapter.notifyItemRemoved(pos);//推荐用这个
//                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
//                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
//                    //mAdapter.notifyDataSetChanged();
//                }
//
//
//            }
//
//            @Override
//            public void onTop(int pos) {
//
//
//                if (pos > 0 && pos < mDatas.size()) {
//                    SwipeBean swipeBean = mDatas.get(pos);
//                    mDatas.remove(swipeBean);
//                    mAdapter.notifyItemInserted(0);
//                    mDatas.add(0, swipeBean);
//                    mAdapter.notifyItemRemoved(pos + 1);
//                    if (mLayoutManager.findFirstVisibleItemPosition() == 0) {
//                        mRv.scrollToPosition(0);
//                    }
//                    //notifyItemRangeChanged(0,holder.getAdapterPosition()+1);
//                }
//
//            }
//        });
//
//        mRv.setAdapter(mAdapter);
//        mRv.setLayoutManager(mLayoutManager = new GridLayoutManager(UIUtils.getContext(), 2));
//
//
//        //6 2016 10 21 add , 增加viewChache 的 get()方法，
//        // 可以用在：当点击外部空白处时，关闭正在展开的侧滑菜单。我个人觉得意义不大，
//        mRv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    SwipeMenuLayout viewCache = SwipeMenuLayout.getViewCache();
//                    if (null != viewCache) {
//                        viewCache.smoothClose();
//                    }
//                }
//                return false;
//            }
//        });

//        ListView mLv = (ListView) view.findViewById(R.id.worksign_fg_lv);


        initViewPager();

//        mLv.setAdapter(new CommonAdapter<SwipeBean>(UIUtils.getContext(), mDatas, R.layout./*item_swipe_menu*/item_cst_swipe) {
//            @Override
//            public void convert(final ViewHolder holder, SwipeBean swipeBean, final int position) {
//                //((CstSwipeDelMenu)holder.getConvertView()).setIos(false);//这句话关掉IOS阻塞式交互效果
//                holder.setText(R.id.content, swipeBean.name);
//                holder.setOnClickListener(R.id.content, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(UIUtils.getContext(), "position:" + position, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                holder.setOnClickListener(R.id.btnDelete, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(UIUtils.getContext(), "删除:" + position, Toast.LENGTH_SHORT).show();
//                        //在ListView里，点击侧滑菜单上的选项时，如果想让擦花菜单同时关闭，调用这句话
//                        ((SwipeMenuLayout) holder.getConvertView()).quickClose();
//                        mDatas.remove(position);
//                        notifyDataSetChanged();
//                    }
//                });
//            }
//        });


    }

    private void initViewPager() {

        MagicIndicator magicIndicator = view.findViewById(R.id.indicator_worksign_fg);
        final HorizontalViewPager viewPager = (HorizontalViewPager) view.findViewById(R.id.vp_worksign_fg);

        OrderAdapter mAdapter = new OrderAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);


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
                        viewPager.setCurrentItem(index);
                        badgePagerTitleView.setBadgeView(null); // cancel badge when click tab
                    }
                });
                badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);

//                // setup badge
//                if (index != 2) {
//                    TextView badgeTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.simple_count_badge_layout, null);
//                    badgeTextView.setText("" + (index + 1));
//                    badgePagerTitleView.setBadgeView(badgeTextView);
//                } else {
//                    ImageView badgeImageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.simple_red_dot_badge_layout, null);
//                    badgePagerTitleView.setBadgeView(badgeImageView);
//                }
//
//                // set badge position
//                if (index == 0) {
//                    badgePagerTitleView.setXBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_LEFT, -UIUtil.dip2px(context, 6)));
//                    badgePagerTitleView.setYBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_TOP, 0));
//                } else if (index == 1) {
//                    badgePagerTitleView.setXBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_RIGHT, -UIUtil.dip2px(context, 6)));
//                    badgePagerTitleView.setYBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_TOP, 0));
//                } else if (index == 2) {
//                    badgePagerTitleView.setXBadgeRule(new BadgeRule(BadgeAnchor.CENTER_X, -UIUtil.dip2px(context, 3)));
//                    badgePagerTitleView.setYBadgeRule(new BadgeRule(BadgeAnchor.CONTENT_BOTTOM, UIUtil.dip2px(context, 2)));
//                }

                // don't cancel badge when tab selected
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


        magicIndicator.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer(); // must after setNavigator
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(UIUtils.getContext(), 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));
        ViewPagerHelper.bind(magicIndicator, viewPager);

    }

    @Override
    public void initData() {
//        mDatas = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            mDatas.add(new SwipeBean("" + i));
//        }
    }

//    @Override
//    protected void immersionInit() {
//        ImmersionBar.with(this).init();
//    }


    class OrderAdapter extends FragmentStatePagerAdapter {


        private String[] mTabNames;

        public OrderAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // TODO Auto-generated method stub
            return mTabNames[position];
        }

        /*
         * 返回 当前位置 Fragment 对象
         */
        @Override
        public Fragment getItem(int position) {
            // TODO Auto-generated method stub
            return OrderFragmentFactory.createOrderFragment(position);
        }

        /*
         * Fragment 个数
         */
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mTabNames.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);

            Log.i(TAG, "destroyItem: ========================================" + position);
        }
    }

}
