package com.neocom.mobilerefueling.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.huanyu.itsms.R;
//import com.huanyu.itsms.adapter.HomeFgGridViewAdapter;
//import com.huanyu.itsms.anim.ZoomOutPageTransformer;
//import com.huanyu.itsms.bean.GridViewBean;
//import com.huanyu.itsms.bean.ViewPagerInfoBean;
//import com.huanyu.itsms.utils.UIUtils;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.HomeFgGridViewAdapter;
import com.neocom.mobilerefueling.anim.ZoomOutPageTransformer;
import com.neocom.mobilerefueling.bean.GridViewBean;
import com.neocom.mobilerefueling.bean.ViewPagerInfoBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by XYZ on 2017/7/17.
 */

public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    private View view;
    private BaseAdapter mAdapter;
    private List<GridViewBean> gridViewBeanList;
    private ViewPager mPicPager;
    private TextView mTvTitle;
    private LinearLayout mPointContainer;
    private ArrayList<ViewPagerInfoBean> mPicDatas;
    protected static final String TAG = "HomeFragment";
    private AutoSwitchPicTask mAutoSwitchTask;
//    private LinearLayout mToolBar;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.home_fragment);

        return view;
    }

    @Override
    public void initData() {
        gridViewBeanList = new ArrayList<>();

        for (int i = 0; i <8 ; i++) {


            gridViewBeanList.add(new GridViewBean("柴油"+i));

        }


    }

    @Override
    public void initView() {

//        mToolBar = view.findViewById(R.id.home_toolbar);
        initGridView();
        initViewPagerData();
        initViewPagerView();
//        TextView textView = view.findViewById(R.id.tv_home_fg);
//        textView.setText("找到了");


    }

    /**
     * 加载 GrideView
     */
    public void initGridView() {
        ListView listView = view.findViewById(R.id.gv_home_fg);
        mAdapter = new HomeFgGridViewAdapter<GridViewBean>(gridViewBeanList, R.layout.hm_fg_gv_item) {
            @Override
            public void bindView(HomeFgGridViewAdapter.ViewHolder holder, GridViewBean obj) {
                holder.setImageResource(R.id.gv_iv, obj.getiId());
                holder.setText(R.id.gv_tv, obj.getiName());

            }
        };

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(UIUtils.getContext(), "点击:" + i, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 初始化数据
     */
    private void initViewPagerData() {
        mPicDatas = new ArrayList<>();
        mPicDatas.add(new ViewPagerInfoBean(R.drawable.oil_one, "加油新技能get√"));
        mPicDatas.add(new ViewPagerInfoBean(R.drawable.oil_one, "加油新技能get√"));
        mPicDatas.add(new ViewPagerInfoBean(R.drawable.oil_one, "加油新技能get√"));
        mPicDatas.add(new ViewPagerInfoBean(R.drawable.oil_one, "加油新技能get√"));
        mPicDatas.add(new ViewPagerInfoBean(R.drawable.oil_one, "加油新技能get√"));


//        mPicDatas.add(new ViewPagerInfoBean(R.drawable.a, "一一一一"));
//        mPicDatas.add(new ViewPagerInfoBean(R.drawable.b, "二二二二"));
//        mPicDatas.add(new ViewPagerInfoBean(R.drawable.c, "三三三三"));
//        mPicDatas.add(new ViewPagerInfoBean(R.drawable.d, "四四四四"));
//        mPicDatas.add(new ViewPagerInfoBean(R.drawable.e, "五五五五"));

    }

    /**
     * 加载  循环轮播图
     */
    private void initViewPagerView() {
        mPicPager = view.findViewById(R.id.vp_home_fg);
        mTvTitle = view.findViewById(R.id.tv_intro_home_fg);
        mPointContainer = view.findViewById(R.id.dot_layout_home_fg);

        initViewPager();
    }

    private void initViewPager() {

        // 清空点
        mPointContainer.removeAllViews();

        for (int i = 0; i < mPicDatas.size(); i++) {
            View point = new View(UIUtils.getContext());
            point.setBackgroundResource(R.mipmap.dot_normal);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6, 6);
            if (i != 0) {
                params.leftMargin = 8;
            } else {
                // 设置默认的图片
                point.setBackgroundResource(R.mipmap.dot_focus);
            }
            // 添加点
            mPointContainer.addView(point, params);

        }

        // 给ViewPager初始化数据
        mPicPager.setAdapter(new TopPicPagerAdapter());// adapter --->

        // 添加ViewPager的监听
        mPicPager.setOnPageChangeListener(this);
//		mPicPager.setPageTransformer(true, new DepthPageTransformer());
        mPicPager.setPageTransformer(true, new ZoomOutPageTransformer());

        // 设置title的默认值
        mTvTitle.setText(mPicDatas.get(0).getIntro().toString());

        // 开启轮播图
        if (mAutoSwitchTask == null) {
            mAutoSwitchTask = new AutoSwitchPicTask();
        }
        mAutoSwitchTask.start();

        // 设置ViewPager的touch的监听
        mPicPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "按下去，停止轮播");
                        // 如果手指按下去时，希望轮播停止，
                        mAutoSwitchTask.stop();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        Log.d(TAG, "抬起，开始轮播");
                        // 如果手指抬起时，图片进行轮播
                        mAutoSwitchTask.start();
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

    }

//    @Override
//    protected void immersionInit() {
////super.immersionInit();
//        ImmersionBar.with(this)
//                .titleBar(mToolBar)
//                .navigationBarColor("#FFFFFF")
//                .init();
//
//    }


    class AutoSwitchPicTask extends Handler implements Runnable {
        /**
         * 开启任务
         */
        public void start() {
            stop();
            postDelayed(this, 5000);
        }

        /**
         * 关闭任务
         */
        public void stop() {
            removeCallbacks(this);
        }

        @Override
        public void run() {
            // ViewPager选中下一个，如果是最后一个就选中第一个

            int position = mPicPager.getCurrentItem();
            if (position != mPicPager.getAdapter().getCount() - 1) {
                // 选中下一个
                mPicPager.setCurrentItem(++position);
            } else {
                // 如果是最后一个就选中第一个
                mPicPager.setCurrentItem(0);
            }

            // 发送延时任务
            postDelayed(this, 5000);
        }

    }


    class TopPicPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            if (mPicDatas != null) {
                return mPicDatas.size();
            }
            return 0;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(UIUtils.getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            // 设置iv的image，设置默认值
            iv.setImageResource(mPicDatas.get(position).getIconResId());
            // 设置网络图片
            // String uri = mPicDatas.get(position).topimage;
            // mBitmapUtils.display(iv, uri);

//            String uri = mPicDatas.get(position);
//            mBitmapUtils.display(iv, uri);
            container.addView(iv);
            return iv;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        // 设置选中的点
        int count = mPointContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = mPointContainer.getChildAt(i);
            view.setBackgroundResource(position == i ? R.drawable.dot_focus : R.mipmap.dot_normal);
        }

        // 设置文本
        mTvTitle.setText(mPicDatas.get(position).getIntro().toString());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
