package com.neocom.mobilerefueling.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.MainActivity;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.APPLoginActivity;
import com.neocom.mobilerefueling.activity.AboutUSActivity;
import com.neocom.mobilerefueling.activity.AccountSafeActivity;
import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.activity.CitySelecterActivity;
import com.neocom.mobilerefueling.activity.CurrentVersionAndIntroActivity;
import com.neocom.mobilerefueling.activity.CustomerMangerActivity;
import com.neocom.mobilerefueling.activity.DPFListActivity;
import com.neocom.mobilerefueling.activity.DSHKeHuAllActivity;
import com.neocom.mobilerefueling.activity.DailyBalanceActivity;
import com.neocom.mobilerefueling.activity.GetQianZaiKeHuListUI;
import com.neocom.mobilerefueling.activity.JGSHListActivity;
import com.neocom.mobilerefueling.activity.MyRecommentActivity;
import com.neocom.mobilerefueling.activity.QrCodeActivity;
import com.neocom.mobilerefueling.activity.RecmentListActivity;
import com.neocom.mobilerefueling.activity.SupplyListActivity;
import com.neocom.mobilerefueling.activity.UpdatePwd;
import com.neocom.mobilerefueling.activity.UserInfoActivity;
import com.neocom.mobilerefueling.activity.UserSettingActivity;
import com.neocom.mobilerefueling.activity.UserSysSetting;
import com.neocom.mobilerefueling.activity.ZSKHListActivity;
import com.neocom.mobilerefueling.adapter.MeFunctionMenuAdapter;
import com.neocom.mobilerefueling.bean.AppUpdateReqBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.ExpandListViewChild;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.bean.RCodeResp;
import com.neocom.mobilerefueling.bean.UpdRespBean;
import com.neocom.mobilerefueling.bean.UserIdReqBean;
import com.neocom.mobilerefueling.bean.VersionUpdateBean;
import com.neocom.mobilerefueling.bean.permissionReqBean;
import com.neocom.mobilerefueling.downServices.ConfirmDialog;
import com.neocom.mobilerefueling.downServices.DownloadService;
import com.neocom.mobilerefueling.download.Effectstype;
import com.neocom.mobilerefueling.downloaddialog.NiftyDialogBuilder;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.processor.HaveDoneActivity;
import com.neocom.mobilerefueling.processor.JingBanRenSPActivity;
import com.neocom.mobilerefueling.processor.WaitTodoActivity;
import com.neocom.mobilerefueling.services.ServiceUtil;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.BottomMenuDialog;
import com.neocom.mobilerefueling.view.WeiboDialogUtils;
import com.neocom.mobilerefueling.view.userview.FloatCircleImage;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 2017/7/17.
 */

public class MeViFragment extends BaseFragment implements View.OnClickListener, SuperTextView.OnSuperTextViewClickListener {

    @BindView(R.id.me_fg_nick_name)
    TextView meFgNickName;
    @BindView(R.id.me_fg_sinature_tv)
    TextView meFgSinatureTv;
    @BindView(R.id.avtar_ll)
    LinearLayout avtarLl;
    //    @BindView(R.id.title)
//    TextView title;
//    @BindView(R.id.title_middle)
//    TextView titleMiddle;
//    @BindView(R.id.user_info)
//    SuperTextView userInfo;
//    @BindView(R.id.upd_pwd)
//    SuperTextView updPwd;
//    @BindView(R.id.tts_speach)
//    SuperTextView ttsSpeach;
//    @BindView(R.id.version_code)
//    SuperTextView versionCode;

    @BindView(R.id.me_fg_exit_btn)
    Button meFgExitBtn;
    //    @BindView(R.id.qianzai_kehu)
//    SuperTextView qianzaiKehu;
//    @BindView(R.id.qianzai_kehu_list)
//    SuperTextView qianzaiKehuList;
//    @BindView(R.id.zs_kehu_list)
//    SuperTextView zsKehuList;
//    @BindView(R.id.dpf_list)
//    SuperTextView dpfList;
//    @BindView(R.id.dsh_list)
//    SuperTextView dshList;
//    @BindView(R.id.jgsh_list)
//    SuperTextView jgshList;
    @BindView(R.id.supply_list)
    SuperTextView supplyList;
    //    @BindView(R.id.share_friend)
//    SuperTextView shareFriend;
//    @BindView(R.id.rec_list)
//    SuperTextView recList;
//    @BindView(R.id.daily_balance_stv)
//    SuperTextView dailyBalanceStv;

    @BindView(R.id.kehu_manger)
    SuperTextView kehuManger;

//    @BindView(R.id.process_stv)
//    SuperTextView processStv;
//    @BindView(R.id.process_plan_stv)
//    SuperTextView processPlanStv;
//    @BindView(R.id.process_wait_todo_stv)
//    SuperTextView processWaitTodoStv;
//    @BindView(R.id.process_have_done_stv)
//    SuperTextView processHaveDoneStv;

    @BindView(R.id.me_fg_user_avatar)
    FloatCircleImage meFgUserAvatar;

    @BindView(R.id.me_fg_comp_name)
    TextView compName;


    private View view;
    private NiftyDialogBuilder dialogBuilder;
//    private final String unForceUpgrade = "0"; //0非强制升级

    //    private final String IN_WORK = "0"; // 上班中
//    private final String UN_WORK = "1"; // 下班中
    private String menuContent;

//    private DownloadService.DownloadBinder downloadBinder;
//
//    private ServiceConnection connection;

    @BindView(R.id.me_account_safe_stv)
    SuperTextView meAccountSafeStv;

    @BindView(R.id.user_setting_stv)
    SuperTextView userSettingStv;

    @BindView(R.id.me_recommend_stv)
    SuperTextView meRecommendStv;

    @BindView(R.id.about_us)
    SuperTextView aboutUs;


    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = UIUtils.inflate(R.layout.me_vi_ui_fragment);

        return view;
    }

    @Override
    public void initView() {


        /******************************************************************/

        meAccountSafeStv.setOnSuperTextViewClickListener(this);
        userSettingStv.setOnSuperTextViewClickListener(this);
        meRecommendStv.setOnSuperTextViewClickListener(this);
        aboutUs.setOnSuperTextViewClickListener(this);
//        recList.setOnSuperTextViewClickListener(this);
        /******************************************************************/


//        userInfo.setOnSuperTextViewClickListener(this);
//        updPwd.setOnSuperTextViewClickListener(this);
//        versionCode.setOnSuperTextViewClickListener(this);

//        qianzaiKehu.setOnSuperTextViewClickListener(this);
//        dpfList.setOnSuperTextViewClickListener(this);
//        qianzaiKehuList.setOnSuperTextViewClickListener(this);
//        zsKehuList.setOnSuperTextViewClickListener(this);
//        dshList.setOnSuperTextViewClickListener(this);
//        jgshList.setOnSuperTextViewClickListener(this);
        kehuManger.setOnSuperTextViewClickListener(this);
        supplyList.setOnSuperTextViewClickListener(this);
//        shareFriend.setOnSuperTextViewClickListener(this);

        meFgExitBtn.setOnClickListener(this);
        meFgUserAvatar.setOnClickListener(this);
//        dailyBalanceStv.setOnSuperTextViewClickListener(this);
//        processStv.setOnSuperTextViewClickListener(this);
//        processWaitTodoStv.setOnSuperTextViewClickListener(this);
//        processHaveDoneStv.setOnSuperTextViewClickListener(this);
//
//        processPlanStv.setOnSuperTextViewClickListener(this);
//        signOut.setOnClickListener(this);

//        connection = new ServiceConnection() {
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//            }
//
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                downloadBinder = (DownloadService.DownloadBinder) service;
//
//                LogUtils.i("服务连接.......onServiceConnected..................");
//
//            }
//
//        };


        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        if (userInfo != null) {
            meFgNickName.setText(userInfo.getUserName());
        }
//        boolean ttsState = SPUtils.getTTSState();
//
//        ttsSpeach.setSwitchIsChecked(ttsState);

//        versionCode.setRightString(UIUtils.getVersionName(getActivity()));

//        TTSSetting();

//        initWorkState();
//        initShare();

//        startService();
    }


//    private void startService() {
//
//
//        Intent intent = new Intent(getActivity(), DownloadService.class);
//        getActivity().startService(intent); // 启动服务
//        getActivity().bindService(intent, connection, getActivity().BIND_AUTO_CREATE); // 绑定服务
//        LogUtils.i("启动服务...");
//
//
//    }


//    private UMShareListener mShareListener;
//    private ShareAction mShareAction;
//    private String sharUrl;
//
//    private void initShare() {
//        mShareListener = new CustomShareListener();
//         /*增加自定义按钮的分享面板*/
//
////         等 微信申请下来了 在添加
////        SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
//        mShareAction = new ShareAction(getActivity()).setDisplayList(
//
//                SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QZONE)
//                .addButton("二维码", "专属二维码", "qr_code", "qr_code")
//                .setShareboardclickCallback(new ShareBoardlistener() {
//                    @Override
//                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
////                Toast.makeText(getContext(), "点击"+snsPlatform.mShowWord, Toast.LENGTH_SHORT).show();
//
//                        if (snsPlatform.mShowWord.equals("二维码")) {
////                    Toast.makeText(getContext(), "二维码", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(UIUtils.getContext(), QrCodeActivity.class);
//                            intent.putExtra("sharUrl", sharUrl);
//
//                            startActivity(intent);
//                        } else {
//                            if (TextUtils.isEmpty(sharUrl)) {
//                                return;
//                            }
//
//                            UMWeb umWeb = new UMWeb(sharUrl);
//                            umWeb.setTitle("来自哥们加油的分享");
//                            umWeb.setDescription("北京哥们加油网络科技有限公司是集油品销售与运输为一体，率先在国内提供移动式现场加油的服务商。");
//                            umWeb.setThumb(new UMImage(getActivity(), R.drawable.appicon));
//                            new ShareAction(getActivity()).withMedia(umWeb)
//                                    .setPlatform(share_media)
//                                    .setCallback(mShareListener).share();
//
//                        }
//
//
//                    }
//                });
//
//
//    }


    @Override
    public void onStart() {
        super.onStart();
        initWorkState();
    }

    private void initWorkState() {

        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        if (userInfo != null) {
            compName.setText(userInfo.getDeptName());

//            SPUtils.saveContent(Constant.WORK_STATE,bring.getCarryStatus());

//            String carryStatus = userInfo.getCarryStatus();

//            if (carryStatus.equals(Constant.IN_WORK)) {
//                meFgSinatureTv.setText("上班中");
//            } else if (carryStatus.equals(Constant.UN_WORK)) {
//                meFgSinatureTv.setText("已下班");
//            } else {
//                meFgSinatureTv.setText("已下班");
//            }

        }

        String carryStatus = SPUtils.getContent(Constant.WORK_STATE);
        Log.i(TAG, "initWorkState: " + carryStatus);
        if (TextUtils.isEmpty(carryStatus)) {
            meFgSinatureTv.setText(Constant.WORK_STATE_OFF);
//            signOut.setVisibility(View.GONE);
        } else {
            meFgSinatureTv.setText(GetOrderStateUtil.getWorkState(carryStatus));

//            if (carryStatus.equals(Constant.IN_WORK)) {
//                signOut.setVisibility(View.VISIBLE);
//            } else {
//                signOut.setVisibility(View.GONE);
//            }

        }

    }

//    private void TTSSetting() {
//        ttsSpeach.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
//            @Override
//            public void onClickListener(SuperTextView superTextView) {
//                superTextView.setSwitchIsChecked(!superTextView.getSwitchIsChecked());
//            }
//        }).setSwitchCheckedChangeListener(new SuperTextView.OnSwitchCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                SPUtils.setTTSState(isChecked);
//
//            }
//        });
//
//
//    }


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


    @Override
    public void initData() {
        menuContent = SPUtils.getContent(Constant.MENU_SAVE);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.me_fg_user_avatar:

                startActivity(new Intent(UIUtils.getContext(), UserInfoActivity.class));

                break;

//            case R.id.sign_out:
//
////                DialogUtils.showAlert(getActivity(), "", "确定要签退么", "", "", "确定", "取消", false, new DialogUIListener() {
////                    @Override
////                    public void onPositive() {
////
////                        signOutFromServer();
////
////
////                    }
////
////                    @Override
////                    public void onNegative() {
////
////
////                    }
////
////                }).show();
//
////                showBottomDialog();
//
//
//                break;

            case R.id.me_fg_exit_btn:

                DialogUtils.showAlert(getActivity(), "", "确定要退出登录么", "", "", "确定", "取消", false, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        startActivity(new Intent(UIUtils.getContext(), APPLoginActivity.class));
                        getActivity().finish();

                        ServiceUtil.stopUpLocServices(getActivity());

                    }

                    @Override
                    public void onNegative() {


                    }

                }).show();


                break;


        }


    }


//    private void signOutFromServer() {
//
//        UserIdReqBean userIdReqBean = new UserIdReqBean();
//
//        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
//
//        HttpManger.getHttpMangerInstance().getServices().submitQuit(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
//            @Override
//            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
//
//                EmptyBringGetOilBean body = response.body();
//                if (body != null) {
//
//                    boolean res = body.isRes();
//                    String message = body.getMessage();
//
//                    if (res) {
//
//                        if (TextUtils.isEmpty(message)) {
////                            Toast.makeText(getContext(), "签退成功", Toast.LENGTH_SHORT).show();
//                            showDialogTips("签退成功");
//                        } else {
////                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//                            showDialogTips(message);
//                        }
//
//
//                    } else {
//                        if (TextUtils.isEmpty(message)) {
////                            Toast.makeText(getContext(), "签退失败", Toast.LENGTH_SHORT).show();
//                            showDialogTips("签退失败");
//                        } else {
////                            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//                            showDialogTips(message);
//                        }
//
//                    }
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: " + t.getMessage());
//
//            }
//        });
//
//
//    }
//
//
//    public void showDialogTips(String msg) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("签退");
//        builder.setMessage(msg);
//        builder.setInverseBackgroundForced(true);
//        // builder.setCustomTitle();
//        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.create().show();
//
//
//    }

//
//    Gson gson;
//    MenuBean menuBean;
//    List<MenuBean.BringBean> menuItems;
//
//    public boolean menuEqualServer(String menu) {
//
//        if (gson == null) {
//            gson = new Gson();
//        }
//
//        if (menuBean == null) {
//            menuBean = gson.fromJson(menuContent, MenuBean.class);
//        }
//        if (menuItems == null || menuItems.size() == 0) {
//            menuItems = menuBean.getBring();
//        }
//
//
//        Log.i(TAG, "menuEqualServer: " + new Gson().toJson(menuItems));
//
//        for (int i = 0; i < menuItems.size(); i++) {
//
//            String code = menuItems.get(i).getCode();
//
//            if (code.equals(menu)) {
////                Log.i(TAG, "menuEqualServer:内 " + code + ";menu;" + menu + "->" + i);
//                return true;
//            }
////            Log.i(TAG, "menuEqualServer: 外" + code + ";menu;" + menu + "->" + i);
//        }
//
//
//        return false;
//    }


    @Override
    public void onClickListener(SuperTextView superTextView) {

        int id = superTextView.getId();

        switch (id) {

            case R.id.me_account_safe_stv:

                startActivity(new Intent(UIUtils.getContext(), AccountSafeActivity.class));
                break;
            case R.id.user_setting_stv:
                startActivity(new Intent(getContext(), UserSysSetting.class));

                break;

            case R.id.me_recommend_stv:
//                startActivity(new Intent(UIUtils.getContext(), RecmentListActivity.class));
                startActivity(new Intent(getContext(), MyRecommentActivity.class));
                break;

            case R.id.about_us:

                startActivity(new Intent(UIUtils.getContext(), CurrentVersionAndIntroActivity.class));
                break;


//            case R.id.user_info:
//                startActivity(new Intent(UIUtils.getContext(), UserInfoActivity.class));
//                break;
            case R.id.supply_list:
                startActivity(new Intent(UIUtils.getContext(), SupplyListActivity.class));
                break;
//            case R.id.upd_pwd:
//                startActivity(new Intent(UIUtils.getContext(), UpdatePwd.class));
//
//                break;

//            case R.id.version_code:
////                检测更新
////                requestAPPUpdate();
//
//                if (downloadBinder == null) {
//
//
//                    connection = new ServiceConnection() {
//
//                        @Override
//                        public void onServiceDisconnected(ComponentName name) {
//                        }
//
//                        @Override
//                        public void onServiceConnected(ComponentName name, IBinder service) {
//                            downloadBinder = (DownloadService.DownloadBinder) service;
//
//                            LogUtils.i("服务连接.......onServiceConnected..................");
//
//                            requestAPPUpdate();
//                        }
//
//                    };
//
//                    startService();
//
//                } else {
//
//                    requestAPPUpdate();
//                }
//
//
//                break;


            case R.id.kehu_manger:

                startActivity(new Intent(UIUtils.getContext(), CustomerMangerActivity.class));
                break;
//            case R.id.qianzai_kehu:
//
//                startActivity(new Intent(UIUtils.getContext(), AddQianZaiKeHuActivity.class));
//                break;
//            case R.id.qianzai_kehu_list:
//
//                startActivity(new Intent(UIUtils.getContext(), GetQianZaiKeHuListUI.class));
//                break;
//            case R.id.zs_kehu_list:
//
//                startActivity(new Intent(UIUtils.getContext(), ZSKHListActivity.class));
//                break;
//            case R.id.dpf_list:
//                startActivity(new Intent(UIUtils.getContext(), DPFListActivity.class));
//                break;
//
//            case R.id.dsh_list:
//                startActivity(new Intent(UIUtils.getContext(), DSHKeHuAllActivity.class));
//                break;
//            case R.id.jgsh_list:
//                startActivity(new Intent(UIUtils.getContext(), JGSHListActivity.class));
//                break;


//            case R.id.share_friend:
//                getUrlAndRcodeByUerId();
//
//                break;
//            case R.id.daily_balance_stv:
//                startActivity(new Intent(UIUtils.getContext(), DailyBalanceActivity.class));
//                break;
//            case R.id.process_stv:
//                permissionReqBean reqBean = new permissionReqBean();
//                reqBean.setProcessDefId("wf_event");
////                reqBean.setWorkOrderId("");
////                reqBean.setCurTaskId("wf_ypsq_start");
//                reqBean.setFormCode("");
//
//                JingBanRenSPActivity.actionStartWithProcessValue(getActivity(), "add", "0", reqBean);
//
//                break;
//            case R.id.process_plan_stv:
//                permissionReqBean reqBeanPlan = new permissionReqBean();
//                reqBeanPlan.setProcessDefId("wf_plan");
////                reqBean.setWorkOrderId("");
////                reqBean.setCurTaskId("wf_ypsq_start");
//                reqBeanPlan.setFormCode("");
//
//                JingBanRenSPActivity.actionStartWithProcessValue(getActivity(), "add", "0", reqBeanPlan);
//
////                "curTaskId" : "wf_plan_start",
////                    "formCode" : "form_plan",
////                    "processDefId" : "wf_plan",
//
//                break;
//            case R.id.process_wait_todo_stv:
//                startActivity(new Intent(getContext(), WaitTodoActivity.class));
//                break;
//            case R.id.process_have_done_stv:
//                startActivity(new Intent(getContext(), HaveDoneActivity.class));
//                break;


        }
    }


//    Dialog loadingDialog;

//    private void getUrlAndRcodeByUerId() {
//        loadingDialog = WeiboDialogUtils.createLoadingDialog(getContext(), "邀请码获取中...");
//        UserIdReqBean userIdReqBean = new UserIdReqBean();
//        userIdReqBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userIdReqBean);
//        HttpManger.getHttpMangerInstance().getServices().getUrlAndRcodeByUerId(requestBody).enqueue(new Callback<RCodeResp>() {
//            @Override
//            public void onResponse(Call<RCodeResp> call, Response<RCodeResp> response) {
//                WeiboDialogUtils.closeDialog(loadingDialog);
//
//                RCodeResp body = response.body();
//
//                if (body != null) {
//
//                    boolean res = body.isRes();
//
//                    if (res) {
//                        RCodeResp.BringBean bring = body.getBring();
//
//                        String recommCode = bring.getRecommCode();
//
//                        if (TextUtils.isEmpty(recommCode)) {
//                            String message = body.getMessage();
//                            Toast.makeText(getContext(), "" + message, Toast.LENGTH_SHORT).show();
//                        } else {
//                            showToShare(recommCode, bring.getDURL());
//                        }
//
//                    }
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<RCodeResp> call, Throwable t) {
//                WeiboDialogUtils.closeDialog(loadingDialog);
//
//                Log.i(TAG, "onFailure: " + t.getMessage());
//                Toast.makeText(getContext(), "获取邀请码失败", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//
//    private void showToShare(String code, String inviteUrl) {
//
//        ShareBoardConfig config = new ShareBoardConfig();
//        config.setTitleText("推荐给好友，邀请码" + code);
//        config.setShareboardPostion(ShareBoardConfig.SHAREBOARD_POSITION_CENTER);
//        sharUrl = inviteUrl + "?recommCode=" + code;
//        Log.i(TAG, "showToShare: ===》" + sharUrl);
//        mShareAction.open(config);
//
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        /** attention to this below ,must add this**/
//        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
//    }

//    private void requestAPPUpdate() {
//        AppUpdateReqBean updateReqBean = new AppUpdateReqBean();
//        updateReqBean.setVersionType("1"); // 司机端 升级参数
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(updateReqBean);
//
//        HttpManger.getHttpMangerInstance().getServices().latestVersion(requestBody).enqueue(new Callback<UpdRespBean>() {
//            @Override
//            public void onResponse(Call<UpdRespBean> call, Response<UpdRespBean> response) {
//                UpdRespBean body = response.body();
//
//                if (body != null) {
//
//                    List<UpdRespBean.BringBean> bring = body.getBring();
//
//                    if (bring != null && bring.size() > 0) {
//
//                        parseUpdBring(bring.get(0));
//
//
//                    }
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<UpdRespBean> call, Throwable t) {
//
//            }
//        });
//
//
//    }


//    private void parseUpdBring(UpdRespBean.BringBean bring) {
//
//        if (bring == null) {
//            return;
//        }
//
//
//        VersionUpdateBean versionUpdateBean = new VersionUpdateBean();
//        versionUpdateBean.versionDesc = bring.getDescription();
//
//
//        versionUpdateBean.versionStatus = "2";//非强制更新
//
//        String filePath = bring.getFilePath();
//        if (TextUtils.isEmpty(filePath)) {
//            return;
//        }
//        versionUpdateBean.url = Constant.BASE_URL + "/busi/interface/downloadFile/" + filePath + "/";
//        Log.i(TAG, "parseUpdBring: 下载地址 " + versionUpdateBean.url);
//
//        String versionInServer = bring.getVersionNo();
//        String versionName = UIUtils.getVersionName(getActivity());
//
//        String upGrades = bring.getUpGrades();
//
//        if (!TextUtils.isEmpty(upGrades)) {
//            if (upGrades.equals(unForceUpgrade)) {
//                versionUpdateBean.versionStatus = "2";//非强制更新
//
//            } else {
//                versionUpdateBean.versionStatus = "3";//强制更新
//            }
//
//        }
//
//
//        Log.i(TAG, "parseUpdBring: ======>>" + versionName);
//        if (!TextUtils.isEmpty(versionInServer)) {
//            if (versionInServer.equals(versionName)) {
//
//                Toast.makeText(getActivity(), "当前已是最新版本", Toast.LENGTH_SHORT).show();
//
//            } else {
//
//                if (versionUpdateBean.versionStatus == "2") {
//
//                    downInfo(versionInServer, versionUpdateBean, false);
//
//                } else {
//
//
//                    downInfo(versionInServer, versionUpdateBean, true);
//                }
//
//            }
//        }
//
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        getActivity().unbindService(connection);
    }

//    public void downInfo(String versionInServer, final VersionUpdateBean versionUpdateBean, final boolean isForceDown) {
//        LogUtils.i("downInfo  服务...");
//        if (downloadBinder == null) {
//            return;
//        }
//
////        versionUpdateBean.url="https://down.2144gy.com/dtxxz/dtxxz_66585.apk";
//
//        LogUtils.i("创建对话框...");
//        ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), new com.neocom.mobilerefueling.downServices.Callback() {
//            @Override
//            public void callback(int position) {
//
//                switch (position) {
//
//                    case 0:  //cancle
//                        if (isForceDown) System.exit(0);
//                        break;
//
//                    case 1:  //sure
//
//                        downloadBinder.startDownload(versionUpdateBean.url);
//
//                        break;
//
//
//                }
//
//
//            }
//
//
//        });
//
//        if (isForceDown) {
//            confirmDialog.setCancleBtnGone();
//        }
//
//
//        confirmDialog.setTips("发现新版本:" + versionInServer);
//        String content = versionUpdateBean.versionDesc;
//
//        confirmDialog.setContent(content);
//        confirmDialog.setCancelable(false);
//        confirmDialog.show();
//        LogUtils.i("显示对话框...");
//
//    }


//    private void parseUpdBring(UpdRespBean.BringBean bring) {
//
//        if (bring == null) {
//            return;
//        }
//
//        VersionUpdateBean versionUpdateBean = new VersionUpdateBean();
//        versionUpdateBean.versionDesc = bring.getDescription();
//
//
//        versionUpdateBean.versionStatus = "3";//强制更新
//
//        String upGrades = bring.getUpGrades();
//
//        if (!TextUtils.isEmpty(upGrades)) {
//            if (upGrades.equals(unForceUpgrade)) {
//                versionUpdateBean.versionStatus = "2";//非强制更新
//            } else {
//                versionUpdateBean.versionStatus = "3";//强制更新
//            }
//
//        }
//
//        String filePath = bring.getFilePath();
//        if (TextUtils.isEmpty(filePath)) {
//            return;
//        }
//
//        versionUpdateBean.url = Constant.BASE_URL + "/busi/interface/downloadFile/" + filePath + "/";
//        Log.i(TAG, "parseUpdBring: 下载地址 " + versionUpdateBean.url);
//
//        String versionInServer = bring.getVersionNo();
//        String versionName = UIUtils.getVersionName(getActivity());
//        Log.i(TAG, "parseUpdBring: ======>>" + versionName);
//        if (!TextUtils.isEmpty(versionInServer)) {
//            if (versionInServer.equals(versionName)) {
//                Toast.makeText(getActivity(), "已是最新版本", Toast.LENGTH_SHORT).show();
//            } else {
//                setVersionInfo(versionUpdateBean);
//            }
//        }
//
//    }


//    public void setVersionInfo(VersionUpdateBean obj) {
//        int status = -1;
//        if (obj != null) {
////			1:不需要更新 2：建议更新 3：强制更新
//            if (obj.versionStatus != null) {
//                status = Integer.parseInt(obj.versionStatus);
//            }
//            if (status == 2 || status == 3) {
//                dialogBuilder = NiftyDialogBuilder.getInstance(getActivity());
//                dialogBuilder
//                        .withDuration(700)              //时间
//                        .withEffect(Effectstype.Fadein)             //动画
//                        .withMessage(obj.versionDesc)   //描述
//                        .withButton1Text("暂不更新")     //按钮1
//                        .withButton2Text("软件更新")     //按钮2
//                        .setForceUp(Integer.parseInt(obj.versionStatus))                  //是否强制更新
//                        .setForceUpFlag(3)              //强制更新的标志
//                        .withButton3Text("软件更新")     //强制更新的文字
//                        .withUrl(obj.url)               //更新软件的地址
//                        .isCancelableOnTouchOutside(false)
//
//                        .setButton1Click(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialogBuilder.dismiss();
//                            }
//                        })
//                        .setButton2Click(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialogBuilder.updateApp();
//                            }
//                        })
//                        .setButton3Click(new View.OnClickListener() {
//
//                            @Override
//                            public void onClick(View v) {
//                                dialogBuilder.updateApp();
//                            }
//                        }).show();
//
//            }
//        }
//
//    }


//    private class CustomShareListener implements UMShareListener {
//
////        private WeakReference<ShareMenuActivity> mActivity;
////
////        private CustomShareListener(ShareMenuActivity activity) {
////            mActivity = new WeakReference(activity);
////        }
//
//        @Override
//        public void onStart(SHARE_MEDIA platform) {
////            Toast.makeText(UIUtils.getContext(), "onStart："+platform, Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onResult(SHARE_MEDIA platform) {
////            Toast.makeText(UIUtils.getContext(), "onResult："+platform, Toast.LENGTH_SHORT).show();
//            if (platform.name().equals("WEIXIN_FAVORITE")) {
//                Toast.makeText(UIUtils.getContext(), platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
//            } else {
//                if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
//                        && platform != SHARE_MEDIA.EMAIL
//                        && platform != SHARE_MEDIA.FLICKR
//                        && platform != SHARE_MEDIA.FOURSQUARE
//                        && platform != SHARE_MEDIA.TUMBLR
//                        && platform != SHARE_MEDIA.POCKET
//                        && platform != SHARE_MEDIA.PINTEREST
//
//                        && platform != SHARE_MEDIA.INSTAGRAM
//                        && platform != SHARE_MEDIA.GOOGLEPLUS
//                        && platform != SHARE_MEDIA.YNOTE
//                        && platform != SHARE_MEDIA.EVERNOTE) {
//                    Toast.makeText(UIUtils.getContext(), platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        }
//
//        @Override
//        public void onError(SHARE_MEDIA platform, Throwable t) {
//            Toast.makeText(UIUtils.getContext(), "onResult：" + platform + ";;" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            if (platform != SHARE_MEDIA.MORE && platform != SHARE_MEDIA.SMS
//                    && platform != SHARE_MEDIA.EMAIL
//                    && platform != SHARE_MEDIA.FLICKR
//                    && platform != SHARE_MEDIA.FOURSQUARE
//                    && platform != SHARE_MEDIA.TUMBLR
//                    && platform != SHARE_MEDIA.POCKET
//                    && platform != SHARE_MEDIA.PINTEREST
//
//                    && platform != SHARE_MEDIA.INSTAGRAM
//                    && platform != SHARE_MEDIA.GOOGLEPLUS
//                    && platform != SHARE_MEDIA.YNOTE
//                    && platform != SHARE_MEDIA.EVERNOTE) {
//                Toast.makeText(UIUtils.getContext(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
//                if (t != null) {
//                    com.umeng.socialize.utils.Log.d("throw", "throw:" + t.getMessage());
//                }
//            }
//
//        }
//
//        @Override
//        public void onCancel(SHARE_MEDIA platform) {
//
//            Toast.makeText(UIUtils.getContext(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
//        }
//    }


}
