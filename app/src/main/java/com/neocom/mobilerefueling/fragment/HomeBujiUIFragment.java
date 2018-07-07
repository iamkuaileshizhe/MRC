package com.neocom.mobilerefueling.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.BuJiQueRenActivity;
import com.neocom.mobilerefueling.activity.ChangeWkActivity;
import com.neocom.mobilerefueling.activity.MsgActivity;
import com.neocom.mobilerefueling.activity.TiYouGongDanActivity;
import com.neocom.mobilerefueling.activity.UserInfoActivity;
import com.neocom.mobilerefueling.adapter.BannerViewpagerAdapter;
import com.neocom.mobilerefueling.adapter.HomeFgGridViewAdapter;
import com.neocom.mobilerefueling.bean.FindOilPriceRespBean;
import com.neocom.mobilerefueling.bean.HomeMenuBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MarQueenDataReqBean;
import com.neocom.mobilerefueling.bean.Marquee;
import com.neocom.mobilerefueling.bean.ProvinceCodeRespBean;
import com.neocom.mobilerefueling.bean.ViewPagerInfoBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.BannerView;
import com.neocom.mobilerefueling.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/31.
 */

public class HomeBujiUIFragment extends BaseFragment implements View.OnClickListener {
    //    @BindView(R.id.vp_home_fg)
//    ViewPager viewpagerHomeUi;
//    @BindView(R.id.viewpager_rl)
//    RelativeLayout viewpagerRl;
//    @BindView(R.id.divider_line)
//    View dividerLine;
//    @BindView(R.id.menu_bg_iv)
//    ImageView menuBgIv;
    @BindView(R.id.home_menu)
    GridView homeMenu;
    @BindView(R.id.menu_gv_rl)
    RelativeLayout menuGvRl;
    @BindView(R.id.divider_line_menu)
    View dividerLineMenu;
    //    @BindView(R.id.gv_tv)
//    TextView gvTv;
//    @BindView(R.id.gv_price)
//    TextView gvPrice;
//    @BindView(R.id.tv_intro_home_fg)
//    TextView tvIntroHomeFg;
    //    @BindView(R.id.tv_intro_home_fg)
//    TextView gvPercent;
//    @BindView(R.id.gv_up_down)
//    ImageView gvUpDown;
//    @BindView(R.id.gv_up_arrow)
//    ImageView gvUpArrow;
    @BindView(R.id.main_oil_price_ll)
    LinearLayout mainOilPriceLl;
    //    @BindView(R.id.dot_layout_home_fg)
//    LinearLayout mPointContainer;
    @BindView(R.id.me_iv)
    ImageView meIv;
    @BindView(R.id.call_iv)
    ImageView callIv;

    @BindView(R.id.rl_banner)
    RelativeLayout rlBanner;

    private BannerView bannerView;
    private BannerViewpagerAdapter pagerAdapter;
    private int[] pics;


    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    Unbinder unbinder;
    private List<HomeMenuBean> gridViewBeanList;
    //    private ArrayList<ViewPagerInfoBean> mPicDatas;
    private View view;
//    private AutoSwitchPicTask mAutoSwitchTask;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.home_ui_layout);
        return view;
    }

    @Override
    public void initView() {
//        initViewPager();
        initGridView();
        meIv.setOnClickListener(this);
        callIv.setOnClickListener(this);

        if (pics == null) {
            pics = new int[]{R.mipmap.banner001, R.mipmap.banner002, R.mipmap.banner003, R.mipmap.banner004, R.mipmap.banner005};
        }

        initBannerView();

    }

    private void initBannerView() {

        pagerAdapter = new BannerViewpagerAdapter(UIUtils.getContext(), pics);
        bannerView = new BannerView(UIUtils.getContext(), pics, pagerAdapter, R.layout.customviewpager);
        //将bannerview添加到需引入控件即可
        rlBanner.addView(bannerView.getBannerView());

    }

//    private void initViewPager() {
//
//        // 清空点
//        mPointContainer.removeAllViews();
//
//        for (int i = 0; i < mPicDatas.size(); i++) {
//            View point = new View(UIUtils.getContext());
//            point.setBackgroundResource(R.mipmap.dot_normal);
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6, 6);
//            if (i != 0) {
//                params.leftMargin = 8;
//            } else {
//                // 设置默认的图片
//                point.setBackgroundResource(R.drawable.dot_focus);
//            }
//            // 添加点
//            mPointContainer.addView(point, params);
//
//        }
//
//        // 给ViewPager初始化数据
//        viewpagerHomeUi.setAdapter(new HomeViewPagerAdapter());// adapter --->
//
//        // 添加ViewPager的监听
//        viewpagerHomeUi.setOnPageChangeListener(this);
////        viewpagerHomeUi.setPageTransformer(true, new ZoomOutPageTransformer());
//
//        // 设置title的默认值
////        mTvTitle.setText(mPicDatas.get(0).getIntro().toString());
//
//        // 开启轮播图
//        if (mAutoSwitchTask == null) {
//            mAutoSwitchTask = new AutoSwitchPicTask();
//        }
//        mAutoSwitchTask.start();
//
//        // 设置ViewPager的touch的监听
//        viewpagerHomeUi.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.d(TAG, "按下去，停止轮播");
//                        // 如果手指按下去时，希望轮播停止，
//                        mAutoSwitchTask.stop();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//                        Log.d(TAG, "抬起，开始轮播");
//                        // 如果手指抬起时，图片进行轮播
//                        mAutoSwitchTask.start();
//                        break;
//                    default:
//                        break;
//                }
//
//                return false;
//            }
//        });
//
//    }
//
//
//    class HomeViewPagerAdapter extends PagerAdapter {
//        @Override
//        public int getCount() {
//            if (mPicDatas != null) {
//                return mPicDatas.size();
//            }
//            return 0;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            ImageView iv = new ImageView(UIUtils.getContext());
//            iv.setScaleType(ImageView.ScaleType.FIT_XY);
//            // 设置iv的image，设置默认值
//            iv.setImageResource(mPicDatas.get(position).getIconResId());
//            // 设置网络图片
//            // String uri = mPicDatas.get(position).topimage;
//            // mBitmapUtils.display(iv, uri);
//
////            String uri = mPicDatas.get(position);
////            mBitmapUtils.display(iv, uri);
//            container.addView(iv);
//            return iv;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            container.removeView((View) object);
//        }
//
//    }


    @Override
    public void initData() {

        gridViewBeanList = new ArrayList<>();

        HomeMenuBean addOilMenu = new HomeMenuBean(R.mipmap.home_tiyou_icon2, "提油");
        gridViewBeanList.add(addOilMenu);
        HomeMenuBean payMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "交接班");
        gridViewBeanList.add(payMenu);
//        HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.app_hone_yhhd, "优惠活动");
        HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "补给确认");
        gridViewBeanList.add(promotionMenu);
//        HomeMenuBean showProductMenu = new HomeMenuBean(R.mipmap.app_home_cpzhsh, "产品展示");
        HomeMenuBean showProductMenu = new HomeMenuBean(R.mipmap.home_message_icon2, "消息");
        gridViewBeanList.add(showProductMenu);
//        HomeMenuBean writeNFCMenu = new HomeMenuBean(R.mipmap.app_home_cpzhsh, "写NFC标签");
//        gridViewBeanList.add(writeNFCMenu);

//        for (int i = 0; i <8 ; i++) {
//            gridViewBeanList.add(new GridViewBean("柴油"+i));
//        }

    }


    private BaseAdapter mAdapter;

    public void initGridView() {
        mAdapter = new HomeFgGridViewAdapter<HomeMenuBean>(gridViewBeanList, R.layout.home_menu_item_layout) {
            @Override
            public void bindView(ViewHolder holder, HomeMenuBean obj) {
                holder.setImageResource(R.id.icon_menu, obj.getiId());
                holder.setText(R.id.title_menu, obj.getiName());
            }
        };

        homeMenu.setAdapter(mAdapter);

        homeMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(UIUtils.getContext(), "点击:" + i, Toast.LENGTH_SHORT).show();

                switch (i) {
                    case 0:// 跳转 添加 提油工单
                        startActivity(new Intent(UIUtils.getContext(), TiYouGongDanActivity.class));
                        break;
                    case 1:// 跳转 交接班
//                        startActivity(new Intent(UIUtils.getContext(), ChargeMoneyActivity.class));
                        startActivity(new Intent(UIUtils.getContext(), ChangeWkActivity.class));
                        break;
                    case 2:
//                        startActivity(new Intent(UIUtils.getContext(), WriteNFCTagActivity.class)); // 这个代码 跳转 写入 NFC 标签
                        startActivity(new Intent(UIUtils.getContext(), BuJiQueRenActivity.class));

                        break;
                    case 3:

                        startActivity(new Intent(UIUtils.getContext(), MsgActivity.class));

                        break;

                }

            }
        });

    }

//    class AutoSwitchPicTask extends Handler implements Runnable {
//        /**
//         * 开启任务
//         */
//        public void start() {
//            stop();
//            postDelayed(this, 5000);
//        }
//
//        /**
//         * 关闭任务
//         */
//        public void stop() {
//            removeCallbacks(this);
//        }
//
//        @Override
//        public void run() {
//            // ViewPager选中下一个，如果是最后一个就选中第一个
//            if (viewpagerHomeUi != null) {
//                int position = viewpagerHomeUi.getCurrentItem();
//                if (position != viewpagerHomeUi.getAdapter().getCount() - 1) {
//                    // 选中下一个
//                    viewpagerHomeUi.setCurrentItem(++position);
//                } else {
//                    // 如果是最后一个就选中第一个
//                    viewpagerHomeUi.setCurrentItem(0);
//                }
//
//            }
//            // 发送延时任务
//            postDelayed(this, 5000);
//        }
//
//    }

//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//        // 设置选中的点
//        int count = mPointContainer.getChildCount();
//        for (int i = 0; i < count; i++) {
//            View view = mPointContainer.getChildAt(i);
//            view.setBackgroundResource(position == i ? R.drawable.dot_focus : R.mipmap.dot_normal);
//        }
//
//        // 设置文本
//        tvIntroHomeFg.setText(mPicDatas.get(position).getIntro().toString());
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }


    @Override
    public void onStart() {
        super.onStart();
        initLocation();

        startLocation();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.call_iv:

                IntentCallPhone("4008989520");

                break;

            case R.id.me_iv:

                startActivity(new Intent(UIUtils.getContext(), UserInfoActivity.class));
                break;

        }


    }


    private void IntentCallPhone(String phoneNum) {

        if (Build.VERSION.SDK_INT >= 23) {

            //判断有没有拨打电话权限
            if (PermissionChecker.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                //请求拨打电话权限
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, Constant.REQUEST_CODE);

            } else {
                callPhone(phoneNum);
            }

        } else {
            callPhone(phoneNum);
        }


    }


    private void callPhone(String phoneNum) {
        //直接拨号
        Uri uri = Uri.parse("tel:" + phoneNum);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //此处不判断就会报错
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            startActivity(intent);
        }
    }


    /**
     * 初始化定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void initLocation() {
        //初始化client
        locationClient = new AMapLocationClient(getActivity());
        locationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
    }

    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            if (null != location) {

//                StringBuffer sb = new StringBuffer();
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {


                    String provinceName = location.getProvince();

                    getCodeByProvinceName(provinceName);

                    stopLocation();
//                    sb.append("定位成功" + "\n");
//                    sb.append("定位类型: " + location.getLocationType() + "\n");
//                    sb.append("经    度    : " + location.getLongitude() + "\n");
//                    sb.append("纬    度    : " + location.getLatitude() + "\n");
//                    sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
//                    sb.append("提供者    : " + location.getProvider() + "\n");
//
//                    sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
//                    sb.append("角    度    : " + location.getBearing() + "\n");
//                    // 获取当前提供定位服务的卫星个数
//                    sb.append("星    数    : " + location.getSatellites() + "\n");
//                    sb.append("国    家    : " + location.getCountry() + "\n");
//                    sb.append("省            : " + location.getProvince() + "\n");
//                    sb.append("市            : " + location.getCity() + "\n");
//                    sb.append("城市编码 : " + location.getCityCode() + "\n");
//                    sb.append("区            : " + location.getDistrict() + "\n");
//                    sb.append("区域 码   : " + location.getAdCode() + "\n");
//                    sb.append("地    址    : " + location.getAddress() + "\n");
//                    sb.append("兴趣点    : " + location.getPoiName() + "\n");
//                    //定位完成的时间
//                    sb.append("定位时间: " + Utils.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                } else {
                    //定位失败
//                    sb.append("定位失败" + "\n");
//                    sb.append("错误码:" + location.getErrorCode() + "\n");
//                    sb.append("错误信息:" + location.getErrorInfo() + "\n");
//                    sb.append("错误描述:" + location.getLocationDetail() + "\n");
                }
//                sb.append("***定位质量报告***").append("\n");
//                sb.append("* WIFI开关：").append(location.getLocationQualityReport().isWifiAble() ? "开启":"关闭").append("\n");
//                sb.append("* GPS状态：").append(getGPSStatusString(location.getLocationQualityReport().getGPSStatus())).append("\n");
//                sb.append("* GPS星数：").append(location.getLocationQualityReport().getGPSSatellites()).append("\n");
//                sb.append("****************").append("\n");
//                //定位之后的回调时间
//                sb.append("回调时间: " + Utils.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss") + "\n");
//
//                //解析定位结果，
//                String result = sb.toString();
//                tvResult.setText(result);
            } else {
//                tvResult.setText("定位失败，loc is null");

            }
        }
    };


    /**
     * 开始定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void startLocation() {
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }

    /**
     * 停止定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void stopLocation() {
        // 停止定位
        Log.i(TAG, "stopLocation: =============停止定位=================");
        locationClient.stopLocation();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }


    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }


    public void getCodeByProvinceName(String province) {

        if (TextUtils.isEmpty(province)) {
            return;
        }

        ProvinceReq provinceReq = new ProvinceReq();
        provinceReq.setProvince(province);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(provinceReq);
        HttpManger.getHttpMangerInstance().getServices().getCodeByProvinceName(requestBody).enqueue(new Callback<ProvinceCodeRespBean>() {
            @Override
            public void onResponse(Call<ProvinceCodeRespBean> call, Response<ProvinceCodeRespBean> response) {

                ProvinceCodeRespBean body = response.body();
                if (body != null) {
                    ProvinceCodeRespBean.BringBean bring = body.getBring();

                    if (bring != null) {

//获取到城市编码 了

                        Log.i(TAG, "onResponse:=>> " + new Gson().toJson(bring) + ";;" + bring.getCode());

//                        oilRequestBean.setArea(bring.getCode());
                        String provinceCode = bring.getCode();

                        SPUtils.saveContent("cityCode", provinceCode);

                        getMarqueenData(provinceCode);
                    }

//                    else {
//
//                        Toasty.info(MainUI.this, "暂不支持该城市", Toast.LENGTH_SHORT, true).show();
//                        return;
//                    }


                }


            }

            @Override
            public void onFailure(Call<ProvinceCodeRespBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void getMarqueenData(String provinceCode) {

        MarQueenDataReqBean marQueenDataReqBean = new MarQueenDataReqBean();

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo != null) {
            marQueenDataReqBean.setUserId(userInfo.getUserId());
        }
        marQueenDataReqBean.setProvince(provinceCode);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(marQueenDataReqBean);
        HttpManger.getHttpMangerInstance().getServices().findOilPricesByUserId(requestBody).enqueue(new Callback<FindOilPriceRespBean>() {
            @Override
            public void onResponse(Call<FindOilPriceRespBean> call, Response<FindOilPriceRespBean> response) {

                FindOilPriceRespBean body = response.body();

                if (body != null) {
                    List<FindOilPriceRespBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        StartMarqueen(bring);

                    }

                }

            }

            @Override
            public void onFailure(Call<FindOilPriceRespBean> call, Throwable t) {

            }
        });

    }

    private void StartMarqueen(List<FindOilPriceRespBean.BringBean> bring) {

        List<Marquee> marqueeList = new ArrayList<>();
        for (int i = 0; i < bring.size(); i++) {
            Marquee marquee = new Marquee();
            FindOilPriceRespBean.BringBean bringBean = bring.get(i);
            marquee.setOilTitle(bringBean.getGBName() + bringBean.getOilTypeName());
//            marquee.setOilPrice(bringBean.getPerformAmount());
            marquee.setOilPrice(bringBean.getPerformAmount());
            marquee.setOilNormal(bringBean.getAreaPrice());
            marquee.setOilPercent(bringBean.getPrePrice());
            marqueeList.add(marquee);
        }

        marqueeView.startWithList(marqueeList);

    }


    private class ProvinceReq {

        /**
         * province : 山东省
         */

        private String province;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        @Override
        public String toString() {
            return "ProvinceReq{" +
                    "province='" + province + '\'' +
                    '}';
        }
    }


}