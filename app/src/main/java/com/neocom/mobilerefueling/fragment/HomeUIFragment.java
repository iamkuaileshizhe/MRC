package com.neocom.mobilerefueling.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.AddChangeWorkActivity;
import com.neocom.mobilerefueling.activity.AddgetOilActivity;
import com.neocom.mobilerefueling.activity.BuJiQueRenActivity;
import com.neocom.mobilerefueling.activity.BuJiRecActivity;
import com.neocom.mobilerefueling.activity.ChangeWkActivity;
import com.neocom.mobilerefueling.activity.ChargeMoneyActivity;
import com.neocom.mobilerefueling.activity.DailyBalanceActivity;
import com.neocom.mobilerefueling.activity.DingDanListActivity;
import com.neocom.mobilerefueling.activity.DingDanWanChengActivity;
import com.neocom.mobilerefueling.activity.JieDanAtivity;
import com.neocom.mobilerefueling.activity.MsgActivity;
import com.neocom.mobilerefueling.activity.ShitWorkDetailActiivty;
import com.neocom.mobilerefueling.activity.TiYouListActivity;
import com.neocom.mobilerefueling.activity.TiYouNewActivity;
import com.neocom.mobilerefueling.activity.UserInfoActivity;
import com.neocom.mobilerefueling.activity.WriteNFCTagActivity;
import com.neocom.mobilerefueling.activity.WriteNFCUI;
import com.neocom.mobilerefueling.activity.ZSKHListActivity;
import com.neocom.mobilerefueling.adapter.BannerViewpagerAdapter;
import com.neocom.mobilerefueling.adapter.HomeFgGridViewAdapter;
import com.neocom.mobilerefueling.anim.ZoomOutPageTransformer;
import com.neocom.mobilerefueling.bean.CarStateRespBean;
import com.neocom.mobilerefueling.bean.FindOilPriceRespBean;
import com.neocom.mobilerefueling.bean.HomeMenuBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MarQueenDataReqBean;
import com.neocom.mobilerefueling.bean.Marquee;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.bean.ProvinceCodeRespBean;
import com.neocom.mobilerefueling.bean.ResetCarOilReqBean;
import com.neocom.mobilerefueling.bean.ResetCarOilRespBean;
import com.neocom.mobilerefueling.bean.ViewPagerInfoBean;
import com.neocom.mobilerefueling.bean.permissionReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.processor.HaveDoneActivity;
import com.neocom.mobilerefueling.processor.JingBanRenSPActivity;
import com.neocom.mobilerefueling.processor.WaitTodoActivity;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.BannerView;
import com.neocom.mobilerefueling.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import me.leefeng.promptlibrary.PromptButton;
import me.leefeng.promptlibrary.PromptButtonListener;
import me.leefeng.promptlibrary.PromptDialog;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/31.
 */

public class HomeUIFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.home_menu)
    GridView homeMenu;
    @BindView(R.id.me_iv)
    ImageView meIv;
    @BindView(R.id.call_iv)
    ImageView callIv;

    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.rl_banner)
    RelativeLayout rlBanner;
    @BindView(R.id.clear_car_info)
    SuperTextView clearCarInfo;

    private BannerView bannerView;
    private BannerViewpagerAdapter pagerAdapter;

    private List<HomeMenuBean> gridViewBeanList;
    private View view;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;
    private int[] pics;
    private String menuContent;

    private final String menuNameItem_buji = "补给";
    private final String menuNameItem_jiaojieban = "交接班";
    private final String menuNameItem_nfc = "增加车辆标签";
    private final String menuNameItem_jiedan = "接单";
    private final String menuNameItem_bujirec = "补给记录";

    private PromptDialog promptAlertDialog;

    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = UIUtils.inflate(R.layout.home_ui_layout);
        return view;
    }

    @Override
    public void initView() {
//        initViewPager();

        initGridView();
        marqueeView.setImage(false);
        meIv.setOnClickListener(this);
        callIv.setOnClickListener(this);
        if (pics == null) {
            pics = new int[]{R.mipmap.banner001, R.mipmap.banner002, R.mipmap.banner003, R.mipmap.banner004, R.mipmap.banner005};
        }

        initBannerView();

        clearCarInfo.setRightBottomTvClickListener(new SuperTextView.OnRightBottomTvClickListener() {
            @Override
            public void onClickListener() {
                showPopAlertTip("确定要清零么");
            }
        });

    }


    public void showPopAlertTip(String msg) {


        if (promptAlertDialog == null) {
            //创建对象
            promptAlertDialog = new PromptDialog(getActivity());
            //设置自定义属性
            promptAlertDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);
        }

        //按钮的定义，创建一个按钮的对象
        PromptButton confirm = new PromptButton("确定", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
//                Toast.makeText(BaseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
//                finish();

                startResestOil();

            }
        });
        confirm.setTextColor(Color.parseColor("#DAA520"));
        confirm.setFocusBacColor(Color.parseColor("#FAFAD2"));
        confirm.setDelyClick(true);//点击后，是否再对话框消失后响应按钮的监听事件

        PromptButton cancleBtn = new PromptButton("取消", new PromptButtonListener() {
            @Override
            public void onClick(PromptButton button) {
//                Toast.makeText(BaseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        promptAlertDialog.showWarnAlert(msg, confirm, cancleBtn);


    }


    private void startResestOil() {

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo != null) {

            ResetCarOilReqBean resetCarOilReqBean = new ResetCarOilReqBean();
            resetCarOilReqBean.setUserId(userInfo.getUserId());
            resetCarOilReqBean.setCarNum(userInfo.getCarNum());
            resetCarOilReqBean.setRemark("");

            RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(resetCarOilReqBean);

//            Call<ResetCarOilRespBean> respBeanCall = HttpManger.getHttpMangerInstance().getService("http://192.168.1.208:8080").resetCarOil(requestBody);
            Call<ResetCarOilRespBean> respBeanCall = HttpManger.getHttpMangerInstance().getServices().resetCarOil(requestBody);

            respBeanCall.enqueue(new Callback<ResetCarOilRespBean>() {
                @Override
                public void onResponse(Call<ResetCarOilRespBean> call, Response<ResetCarOilRespBean> response) {

                    ResetCarOilRespBean body = response.body();
                    if (body != null) {
                        boolean res = body.isRes();
                        String message = body.getMessage();
                        if (res) {
                            ResetCarOilRespBean.BringBean bring = body.getBring();


                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(getContext(), "清零成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                            }

                            String curOilNum = bring.getCurOilNum();

                            if (TextUtils.isEmpty(curOilNum)) {
                                clearCarInfo.setCenterString("0.00 吨");
                            } else {
//                                String[] split = curOilNum.split("_");
//
//                                if (split != null) {
//                                    clearCarInfo.setCenterString(split[0] + "吨");
//                                }
                                getCarInfoByCarNum();

                            }


                        } else {
                            if (TextUtils.isEmpty(message)) {

                                Toast.makeText(getContext(), "获取数据有误", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                            }
                        }

                    } else {

                        Toast.makeText(getContext(), "数据异常", Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onFailure(Call<ResetCarOilRespBean> call, Throwable t) {
//                    Toast.makeText(getContext(), "获取数据有误", Toast.LENGTH_SHORT).show();

                }
            });
//        resetCarOil

        }


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menuContent = GetUserInfoUtils.getMenu();

        initMenu();
    }

    /**
     * 这样虽然会严重拖慢 速度 但是  呵呵
     */
    private void initMenu() {

//        if (menuContent.contains(Constant.MENU_BUSI_SUPPLYOIL)) {
//
//            HomeMenuBean addOilMenu = new HomeMenuBean(R.mipmap.home_buji_icon2, menuNameItem_buji);
//            gridViewBeanList.add(addOilMenu);
//
//        } else

        boolean b = menuEqualServer(Constant.MENU_BUSI_ORDER_PICKUP);
        Log.i(TAG, "initMenu: ============" + b);

//        if (menuContent.contains(Constant.MENU_BUSI_ORDER_PICKUP)) {
        if (menuEqualServer(Constant.MENU_BUSI_ORDER_PICKUP)) {
//        if (menuEqualServer(Constant.MENU_BUSI_ORDER_PICKUP)) {
            HomeMenuBean jieDanMenu = new HomeMenuBean(R.mipmap.home_message_icon2, menuNameItem_jiedan);
            gridViewBeanList.add(jieDanMenu);
        }

//        if (menuContent.contains(Constant.MENU_BUSI_ORDER_LIST)) {
//        if (menuEqualServer(Constant.MENU_BUSI_ORDER_LIST)) {
//
//            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "订单列表");
//            gridViewBeanList.add(promotionMenu);
//
//        }

//        if (menuContent.contains(Constant.MENU_BUSI_ORDER_FINISH)) {
//        if (menuEqualServer(Constant.MENU_BUSI_ORDER_FINISH)) {
//
//            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "完成订单");
//            gridViewBeanList.add(promotionMenu);
//
//        }


//        if (menuContent.contains(Constant.MENU_BUSI_HANDOVER)) {
        if (menuEqualServer(Constant.MENU_BUSI_HANDOVER)) {

            HomeMenuBean payMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, menuNameItem_jiaojieban);
            gridViewBeanList.add(payMenu);

        }

//        if (menuContent.contains(Constant.MENU_BUSI_HANDOVER_AUTH)) {
////
//            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "交接班确认");
//            gridViewBeanList.add(promotionMenu);
//// 不知道 这是 什么鬼
//
//        }

//        if (menuContent.contains(Constant.MENU_BUSI_NFC)) {
        if (menuEqualServer(Constant.MENU_BUSI_NFC)) {

            HomeMenuBean writeNFCMenu = new HomeMenuBean(R.mipmap.scan_nfc, menuNameItem_nfc);
            gridViewBeanList.add(writeNFCMenu);

        }

//        if (menuContent.contains(Constant.MENU_BUSI_SUPPLYOIL)) {
        if (menuEqualServer(Constant.MENU_BUSI_SUPPLYOIL)) {


            HomeMenuBean bujiHisMenu = new HomeMenuBean(R.mipmap.home_message_icon2, menuNameItem_bujirec);
            gridViewBeanList.add(bujiHisMenu);

        }
//        if (menuContent.contains(Constant.MENU_BUSI_SUPPLYOIL_AUTH)) {
        if (menuEqualServer(Constant.MENU_BUSI_SUPPLYOIL_AUTH)) {

            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "补给确认");
            gridViewBeanList.add(promotionMenu);
//            BuJiQueRenActivity
        }

//        if (menuContent.contains(Constant.MENU_BUSI_PURCHASEOIL)) {
        if (menuEqualServer(Constant.MENU_BUSI_PURCHASEOIL)) {

//            BuJiQueRenActivity

            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "提油记录");
            gridViewBeanList.add(promotionMenu);

        }
        if (menuEqualServer(Constant.CUSTOMER_SEARCH)) {

//            BuJiQueRenActivity

            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "B类客户查询");
            gridViewBeanList.add(promotionMenu);

        }

        if (menuEqualServer(Constant.WAIT_TO_DO)) {
            HomeMenuBean waiToDo = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "待办事项");
            gridViewBeanList.add(waiToDo);
        }

        if (menuEqualServer(Constant.HAVE_DONE)) {
            HomeMenuBean haveDone = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "已办事项");
            gridViewBeanList.add(haveDone);
        }
        if (menuEqualServer(Constant.PURCHASEOIL)) {
            HomeMenuBean oilBuy = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "油品采购");
            gridViewBeanList.add(oilBuy);
        }

        if (menuEqualServer(Constant.busiDaily)) {

            HomeMenuBean dailyBlance = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "日清日结");
            gridViewBeanList.add(dailyBlance);

        }

        HomeMenuBean oilBuy = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "油品采购");
        gridViewBeanList.add(oilBuy);

        HomeMenuBean haveDone = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "已办事项");
        gridViewBeanList.add(haveDone);

        HomeMenuBean waiToDo = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "待办事项");
        gridViewBeanList.add(waiToDo);
//
        HomeMenuBean dailyBlance = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "日清日结");
        gridViewBeanList.add(dailyBlance);

//        else

//            if (menuContent.contains(Constant.MENU_BUSI_PURCHASEOIL)){
//
//            HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "补给记录列表");
//            gridViewBeanList.add(promotionMenu);
////            YunYouCheListFragment
//        }else


//            if (menuContent.contains(Constant.MENU_BUSI_HANDOVER)) {
//
//                HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "交接班");
//                gridViewBeanList.add(promotionMenu);
//
//
//            }


//        DingDanListActivity

//        HomeMenuBean addOilMenu = new HomeMenuBean(R.mipmap.home_tiyou_icon2, "提油");
//        gridViewBeanList.add(addOilMenu);
//        HomeMenuBean payMenu = new HomeMenuBean(R.mipmap.home_jjb_icon2, "交接班");
//        gridViewBeanList.add(payMenu);
//        //        HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.app_hone_yhhd, "优惠活动");
//        HomeMenuBean promotionMenu = new HomeMenuBean(R.mipmap.home_bjqr_icon2, "补给确认");
//        gridViewBeanList.add(promotionMenu);
//        //        HomeMenuBean showProductMenu = new HomeMenuBean(R.mipmap.app_home_cpzhsh, "产品展示");
//        HomeMenuBean showProductMenu = new HomeMenuBean(R.mipmap.home_message_icon2, "消息");
//        gridViewBeanList.add(showProductMenu);


    }

    Gson gson;
    MenuBean menuBean;
    List<MenuBean.BringBean> menuItems;

    public boolean menuEqualServer(String menu) {

        if (gson == null) {
            gson = new Gson();
        }

        if (menuBean == null) {
            menuBean = gson.fromJson(menuContent, MenuBean.class);
        }
        if (menuItems == null || menuItems.size() == 0) {
            menuItems = menuBean.getBring();
        }


        Log.i(TAG, "menuEqualServer: " + new Gson().toJson(menuItems));

        for (int i = 0; i < menuItems.size(); i++) {

            String code = menuItems.get(i).getCode();

            if (code.equals(menu)) {
//                Log.i(TAG, "menuEqualServer:内 " + code + ";menu;" + menu + "->" + i);
                return true;
            }
//            Log.i(TAG, "menuEqualServer: 外" + code + ";menu;" + menu + "->" + i);
        }


        return false;
    }


    private void initBannerView() {

        pagerAdapter = new BannerViewpagerAdapter(UIUtils.getContext(), pics);
        bannerView = new BannerView(UIUtils.getContext(), pics, pagerAdapter, R.layout.customviewpager);
        //将bannerview添加到需引入控件即可
        rlBanner.addView(bannerView.getBannerView());

    }


    private void getCarInfoByCarNum() {

        String carNum = GetUserInfoUtils.getUserInfo().getCarNum();

        if (TextUtils.isEmpty(carNum)) {
            return;
        }

        carInfoNum carInfoNum = new carInfoNum();
        carInfoNum.setCode(carNum);
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carInfoNum);
        HttpManger.getHttpMangerInstance().getServices().findCarStateByCode(requestBody).enqueue(new Callback<CarStateRespBean>() {
            @Override
            public void onResponse(Call<CarStateRespBean> call, Response<CarStateRespBean> response) {

                CarStateRespBean body = response.body();

                LogUtils.d("-返回车辆信息-" + new Gson().toJson(body));

                if (body != null) {
                    boolean res = body.isRes();
                    if (res) {
                        CarStateRespBean.BringBean bring = body.getBring();

                        if (bring != null) {

//                            String leaveOil = bring.getLeaveOilForT();
//                            remainCarOil.setText(leaveOil);
////                            setRemain
//
//                            addShitWorkBean.setRemainTankOil(leaveOil);
                            clearCarInfo.setVisibility(View.VISIBLE);
                            clearCarInfo.setCenterString(bring.getLeaveOilForT());

                        }


                    } else {

                        String message = body.getMessage();

                        if (TextUtils.isEmpty(message)) {
                            Toast.makeText(getContext(), "获取油量信息失败", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                        }


                    }


                }


            }

            @Override
            public void onFailure(Call<CarStateRespBean> call, Throwable t) {
                Toast.makeText(getContext(), "连接超时,获取油量失败", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();

        initLocation();

        startLocation();


        resetWorkState();
    }

    private void resetWorkState() {


        String carryStatus = SPUtils.getContent(Constant.WORK_STATE);
        Log.i(TAG, "initWorkState: " + carryStatus);
        if (TextUtils.isEmpty(carryStatus)) {
//            meFgSinatureTv.setText(Constant.WORK_STATE_OFF);
//            signOut.setVisibility(View.GONE);
            clearCarInfo.setVisibility(View.GONE);
//            下班中
        } else {
//            meFgSinatureTv.setText(GetOrderStateUtil.getWorkState(carryStatus));

            if (carryStatus.equals(Constant.UN_WORK)) {
//                隐藏 信息
                clearCarInfo.setVisibility(View.GONE);
            } else if (carryStatus.equals(Constant.IN_WORK)) {
//            获取信息    显示信息
                getCarInfoByCarNum();
            }


        }


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


    @Override
    public void initData() {
//        initViewPagerData();


//        SPUtils.saveContent(Constant.MENU_SAVE, toJson);

//        menuContent = SPUtils.getContent(Constant.MENU_SAVE);
//        menuContent = SPUtils.getContent(Constant.MENU_SAVE);

        gridViewBeanList = new ArrayList<>();


    }

    private BaseAdapter mAdapter;

    public void initGridView() {
        mAdapter = new HomeFgGridViewAdapter<HomeMenuBean>(gridViewBeanList, R.layout.home_menu_item_layout) {
            @Override
            public void bindView(HomeFgGridViewAdapter.ViewHolder holder, HomeMenuBean obj) {
                holder.setImageResource(R.id.icon_menu, obj.getiId());
                holder.setText(R.id.title_menu, obj.getiName());
            }
        };

        homeMenu.setAdapter(mAdapter);
        homeMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HomeMenuBean item = (HomeMenuBean) mAdapter.getItem(i);

                String menuName = item.getiName();


                switch (menuName) {


                    case menuNameItem_buji:// 跳转 添加 补给工单
                        startActivity(new Intent(UIUtils.getContext(), AddgetOilActivity.class));
                        break;
                    case menuNameItem_jiaojieban:// 跳转 交接班
//                        startActivity(new Intent(UIUtils.getContext(), ChargeMoneyActivity.class));
                        startActivity(new Intent(UIUtils.getContext(), ChangeWkActivity.class));

                        break;
                    case menuNameItem_nfc:
//                        startActivity(new Intent(UIUtils.getContext(), WriteNFCTagActivity.class));
                        startActivity(new Intent(UIUtils.getContext(), WriteNFCUI.class));
                        break;
//                    case 3:
//                        startActivity(new Intent(UIUtils.getContext(), MsgActivity.class));
//                        break;
                    case menuNameItem_jiedan:
                        startActivity(new Intent(UIUtils.getContext(), JieDanAtivity.class));
                        break;
                    case menuNameItem_bujirec:
                        startActivity(new Intent(UIUtils.getContext(), BuJiRecActivity.class));
                        break;
//                    case "订单列表":
//                        startActivity(new Intent(UIUtils.getContext(), DingDanListActivity.class));
//                        break;
//                    case "完成订单":
//                        startActivity(new Intent(UIUtils.getContext(), DingDanWanChengActivity.class));
//                        break;
//                    case "交接班确认":
//                        startActivity(new Intent(UIUtils.getContext(), ShitWorkDetailActiivty.class));
//                        break;
                    case "提油记录":
//                        startActivity(new Intent(UIUtils.getContext(), TiYouListActivity.class));
                        startActivity(new Intent(UIUtils.getContext(), TiYouNewActivity.class));
                        break;
                    case "补给确认":
                        startActivity(new Intent(UIUtils.getContext(), BuJiQueRenActivity.class));
                        break;
                    case "B类客户查询":
                        startActivity(new Intent(UIUtils.getContext(), ZSKHListActivity.class));
                        break;
                    case "日清日结":

                        startActivity(new Intent(UIUtils.getContext(), DailyBalanceActivity.class));

                        break;
                    case "油品采购":

//                        permissionReqBean reqBean = new permissionReqBean();
//                        reqBean.setProcessDefId("wf_event");
////                reqBean.setWorkOrderId("");
////                reqBean.setCurTaskId("wf_ypsq_start");
//                        reqBean.setFormCode("");
//
//                        JingBanRenSPActivity.actionStartWithProcessValue(getActivity(), "add", "0", reqBean);


                        permissionReqBean reqBeanPlan = new permissionReqBean();
                        reqBeanPlan.setProcessDefId("wf_plan");
                        reqBeanPlan.setFormCode("");

                        JingBanRenSPActivity.actionStartWithProcessValue(getActivity(), "add", "0", reqBeanPlan);


                        break;

                    case "待办事项":
                        startActivity(new Intent(getContext(), WaitTodoActivity.class));

                        break;
                    case "已办事项":
                        startActivity(new Intent(getContext(), HaveDoneActivity.class));

                        break;


                }

            }
        });

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
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
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


    class carInfoNum {


        /**
         * code : 川A34995
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
