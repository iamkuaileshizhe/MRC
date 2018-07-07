package com.neocom.mobilerefueling.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.MainActivity;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.AppUpdateReqBean;
import com.neocom.mobilerefueling.bean.ChildItemBean;
import com.neocom.mobilerefueling.bean.LoginBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.bean.UpdRespBean;
import com.neocom.mobilerefueling.bean.VersionUpdateBean;
import com.neocom.mobilerefueling.downServices.ConfirmDialog;
import com.neocom.mobilerefueling.downServices.DownloadService;
import com.neocom.mobilerefueling.download.Effectstype;
import com.neocom.mobilerefueling.downloaddialog.NiftyDialogBuilder;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.processor.profragment.MultiBottomFragment;
import com.neocom.mobilerefueling.utils.AndroidBug5497Workaround;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.MD5Util;
import com.neocom.mobilerefueling.utils.PermissionRequest;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.WeiboDialogUtils;
import com.yanzhenjie.alertdialog.AlertDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/24.
 */

public class APPLoginActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG = "APPLoginActivity";
    //    private ImageView logo;
    private ScrollView scrollView;
    private EditText et_mobile;
    private EditText et_password;
    private ImageView iv_clean_phone;
    private ImageView clean_password;
    private ImageView iv_show_pwd;
    private Button btn_login;

    private ImageView changeIpIv;

//    private Button btn_reg;

//    private TextView etCarNo;

    private CheckBox loginDefaultCb;

//    private TextView forget_password;

    private int screenHeight = 0;//屏幕高度
    private int keyHeight = 0; //软件盘弹起后所占高度
    private float scale = 0.6f; //logo缩放比例
    //    private View service;
    private View content;
    private int height = 0;


    //    carType(车辆类型) 0:加油车  1:补给车 2:普通车辆
//    fuelType(车辆燃油类型)混动 0:汽油  1:柴油 2:混动   ForgetPwdActivity
    private String CAR_TYPE_JIAYOUCHE = "0";
    private String CAR_TYPE_BUJICHE = "1";
    private TextView fogetPwd;

    private NiftyDialogBuilder dialogBuilder;

    private final String unForceUpgrade = "0"; //0非强制升级
    private final String forceUpgrade = "1";//1强制升级

    private PermissionRequest permissionRequest;
    private long[] mHits = new long[3];

    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (DownloadService.DownloadBinder) service;

            LogUtils.i("服务连接.......onServiceConnected..................");
            initPermissionReq();
            permissionRequest.request();
        }

    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).statusBarColor(R.color.white).statusBarDarkFont(true, 0.2f).init();
        setContentView(R.layout.app_login_activity);
        if (isFullScreen(this)) {
            AndroidBug5497Workaround.assistActivity(this);
        }
        initView();
        initListener();

//        initPermissionReq();
//        permissionRequest.request();

        if (connection == null) {

            connection = new ServiceConnection() {

                @Override
                public void onServiceDisconnected(ComponentName name) {
                }

                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    downloadBinder = (DownloadService.DownloadBinder) service;

                    LogUtils.i("服务连接.......onServiceConnected..................");
                    initPermissionReq();
                    permissionRequest.request();
                }

            };


        }


        Intent intent = new Intent(this, DownloadService.class);
        startService(intent); // 启动服务
        bindService(intent, connection, BIND_AUTO_CREATE); // 绑定服务
        LogUtils.i("启动服务...");



        String ipInUse = SPUtils.getContent(Constant.DEFAULT_IP_INUSE);

        if (!TextUtils.isEmpty(ipInUse)) {
            Constant.BASE_URL = ipInUse;
        }else {
            SPUtils.saveContent(Constant.DEFAULT_IP, Constant.BASE_URL);
        }

    }

    public boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags &
                WindowManager.LayoutParams.FLAG_FULLSCREEN) == WindowManager.LayoutParams.FLAG_FULLSCREEN;
    }

    private void initView() {
//        logo = (ImageView) findViewById(R.id.logo);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
//        et_mobile.setText("yuziyang");
        et_password = (EditText) findViewById(R.id.et_password);
//        et_password.setText("123456");
        iv_clean_phone = (ImageView) findViewById(R.id.iv_clean_phone);
        clean_password = (ImageView) findViewById(R.id.clean_password);
        iv_show_pwd = (ImageView) findViewById(R.id.iv_show_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        changeIpIv = findViewById(R.id.change_ip_iv);
//        btn_reg = (Button) findViewById(R.id.btn_reg);
//        etCarNo = findViewById(R.id.et_car_no);

        loginDefaultCb = findViewById(R.id.address_default_cb);

        fogetPwd = findViewById(R.id.foget_pwd);

//        forget_password = (TextView) findViewById(R.id.forget_password);
//        service = findViewById(R.id.service);
        content = findViewById(R.id.content);
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyHeight = screenHeight / 10;//弹起高度为屏幕高度的1/3
        btn_login.setOnClickListener(this);
//        btn_reg.setOnClickListener(this);
        fogetPwd.setOnClickListener(this);
        changeIpIv.setOnClickListener(this);


        findViewById(R.id.btn_reg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(APPLoginActivity.this, RegisterActivity.class));

            }
        });

        initState();

    }

    private void initState() {

        boolean rember = SPUtils.isRember();
        loginDefaultCb.setChecked(rember);
        if (rember) {
            HashMap<String, String> userMp = SPUtils.getUser();
            et_mobile.setText(userMp.get(Constant.SP_USERNAME));
            et_password.setText(userMp.get(Constant.SP_PASSWORD));
//            etCarNo.setText(SPUtils.getContent(Constant.CAR_NO));
        }


    }

    private void initListener() {
        iv_clean_phone.setOnClickListener(this);
        clean_password.setOnClickListener(this);
        iv_show_pwd.setOnClickListener(this);
        et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE);
                }
            }
        });


        et_mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {

                    String s = et_mobile.getText().toString();

                    if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                        iv_clean_phone.setVisibility(View.VISIBLE);
                        et_mobile.setSelection(s.length());
                    } else if (TextUtils.isEmpty(s)) {
                        iv_clean_phone.setVisibility(View.GONE);
                    }

                }

            }
        });


        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty()) {
                    return;
                }
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(APPLoginActivity.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    et_password.setSelection(s.length());
                }
            }
        });
//        /**
//         * 禁止键盘弹起的时候可以滚动
//         */
//        scrollView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//        scrollView.addOnLayoutChangeListener(new ViewGroup.OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
//              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
//                if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
//                    Log.e("wenzhihao", "up------>" + (oldBottom - bottom));
//                    int dist = content.getBottom() - bottom;
//                    if (dist > 0) {
//                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", 0.0f, -dist);
//                        mAnimatorTranslateY.setDuration(300);
//                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
//                        mAnimatorTranslateY.start();
//                        zoomIn(logo, dist);
//                    }
////                    service.setVisibility(View.INVISIBLE);
//
//                } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
//                    Log.e("wenzhihao", "down------>" + (bottom - oldBottom));
//                    if ((content.getBottom() - oldBottom) > 0) {
//                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", content.getTranslationY(), 0);
//                        mAnimatorTranslateY.setDuration(300);
//                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
//                        mAnimatorTranslateY.start();
//                        //键盘收回后，logo恢复原来大小，位置同样回到初始位置
//                        zoomOut(logo);
//                    }
////                    service.setVisibility(View.VISIBLE);
//                }
//            }
//        });
    }

//    /**
//     * 缩小
//     *
//     * @param view
//     */
//    public void zoomIn(final View view, float dist) {
//        view.setPivotY(view.getHeight());
//        view.setPivotX(view.getWidth() / 2);
//        AnimatorSet mAnimatorSet = new AnimatorSet();
//        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, scale);
//        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, scale);
//        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dist);
//
//        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX);
//        mAnimatorSet.play(mAnimatorScaleX).with(mAnimatorScaleY);
//        mAnimatorSet.setDuration(300);
//        mAnimatorSet.start();
//    }

//    /**
//     * f放大
//     *
//     * @param view
//     */
//    public void zoomOut(final View view) {
//        view.setPivotY(view.getHeight());
//        view.setPivotX(view.getWidth() / 2);
//        AnimatorSet mAnimatorSet = new AnimatorSet();
//
//        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", scale, 1.0f);
//        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", scale, 1.0f);
//        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0);
//
//        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX);
//        mAnimatorSet.play(mAnimatorScaleX).with(mAnimatorScaleY);
//        mAnimatorSet.setDuration(300);
//        mAnimatorSet.start();
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_login:

                LoginBean loginBean = new LoginBean();


                String userName = et_mobile.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }

                String userPwd = et_password.getText().toString().trim();

                if (TextUtils.isEmpty(userPwd)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
//                String carNo = etCarNo.getText().toString().trim();

//                if (TextUtils.isEmpty(carNo)) {
//                    Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                if (carNo == null) {
//                    loginBean.setCarNum("");
//                } else {
//                    loginBean.setCarNum(carNo);
//                }
                loginBean.setUserCode(userName);
                loginBean.setPwd(userPwd);
//                loginBean.setCarNum(carNo);
//                Toast.makeText(this, "开始登陆", Toast.LENGTH_SHORT).show();
                appLogin(loginBean);

//                startActivity(new Intent(UIUtils.getContext(), MainActivity.class));
                break;
//            case R.id.btn_reg:
//                startActivity(new Intent(UIUtils.getContext(), APPRegActivity.class));
//                break;
            case R.id.iv_clean_phone:
                et_mobile.setText("");
                break;
            case R.id.clean_password:
                et_password.setText("");
                break;
            case R.id.iv_show_pwd:
                if (et_password.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.pass_visuable);
                } else {
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.pass_gone);
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd)) {
                    et_password.setSelection(pwd.length());
                }
                break;

            case R.id.foget_pwd:
                startActivity(new Intent(UIUtils.getContext(), ForgetPwdActivity.class));
                break;


            case R.id.change_ip_iv:


                if (Constant.DEBUG) {


                    System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                    mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                    if (mHits[0] >= (SystemClock.uptimeMillis() - 500)) {
                        IPSettingActivity.ipSeetingStart(APPLoginActivity.this);

                    }
                }
                break;

            default:
                break;
        }
    }

    Dialog loadingDialog;


//    private void appLogin(LoginBean loginBean) {
//        List<ChildItemBean> itemBeen = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//
//            ChildItemBean itemBean = new ChildItemBean();
//            itemBean.setItemValue("value" + i);
//            itemBean.setItemId("id" + i);
//            itemBeen.add(itemBean);
//        }
//
//
//        final MultiBottomFragment bottomFragment = new MultiBottomFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("multiChoose", GsonUtil.GsonString(itemBeen));
//        bottomFragment.setArguments(bundle);
//
//        bottomFragment.show(getSupportFragmentManager(), "bottomFragment");
//
//        bottomFragment.setOnDataChange(new MultiBottomFragment.onNotifyDataChange() {
//            @Override
//            public void DataChange(List<ChildItemBean> selectDatas) {
//                LogUtils.i("---" + GsonUtil.GsonString(selectDatas));
//            }
//        });
//
//    }

    private void appLogin(final LoginBean loginBean) {


        boolean netState = CommonUtil.checkNetState(APPLoginActivity.this);
        if (!netState) {
            Toasty.info(APPLoginActivity.this, "请检查网络连接", Toast.LENGTH_SHORT, true).show();
            return;
        }


        loadingDialog = WeiboDialogUtils.createLoadingDialog(APPLoginActivity.this, "登录中...");
        final String loginBeanPwd = loginBean.getPwd();
        String userPwdMD5 = MD5Util.getMD5(loginBeanPwd);
        loginBean.setPwd(userPwdMD5);
        RequestBody body = HttpManger.getHttpMangerInstance().getRequestBody(loginBean);


//        Call<LoginResponseBean> call = HttpManger.getHttpMangerInstance().getServices().login(body);
        Call<LoginResponseBean> call = HttpManger.getHttpMangerInstance().getServices().enterpriseLogin(body);
        call.enqueue(new Callback<LoginResponseBean>() {
            @Override
            public void onResponse(Call<LoginResponseBean> call, Response<LoginResponseBean> response) {

                LoginResponseBean body = response.body();

                if (body != null) {
                    LoginResponseBean.BringBean bring = body.getBring();

                    if (bring != null) {

                        if (loginDefaultCb.isChecked()) {
                            SPUtils.setRember(true);
                            SPUtils.savaUser(loginBean.getUserCode(), loginBeanPwd);
//                            SPUtils.saveContent(Constant.CAR_NO, etCarNo.getText().toString());
                        }

                        SPUtils.saveLoginConten(Constant.SP_LOGIN_CONTENT, new Gson().toJson(bring));
                        Log.i(TAG, "onResponse: ===>" + bring.getCarryStatus());
                        SPUtils.saveContent(Constant.WORK_STATE, bring.getCarryStatus());
//                        SPUtils.saveContent(Constant.CAR_NUM,bring.getCarNum());
                        SPUtils.setSaveCar(bring.getCarNum());


                        getAppMenuFromServer(bring);

                    } else {

                        String message = body.getMessage();
                        WeiboDialogUtils.closeDialog(loadingDialog);
                        if (TextUtils.isEmpty(message)) {
                            Toasty.warning(APPLoginActivity.this, "登陆异常请重新登录", Toast.LENGTH_SHORT, true).show();
                            return;
                        } else {
                            Toasty.warning(APPLoginActivity.this, message, Toast.LENGTH_SHORT, true).show();
                            return;

                        }

                    }

                } else {

                    Toasty.warning(APPLoginActivity.this, "登陆异常请重新登录", Toast.LENGTH_SHORT, true).show();
                    return;

                }


            }

            @Override
            public void onFailure(Call<LoginResponseBean> call, Throwable t) {
                WeiboDialogUtils.closeDialog(loadingDialog);
                Toasty.warning(APPLoginActivity.this, "登录超时", Toast.LENGTH_SHORT, true).show();
                return;
            }
        });
    }


    private void getAppMenuFromServer(final LoginResponseBean.BringBean bringLogin) {
//        showLoadingDialog("请稍后...");
        HttpManger.getHttpMangerInstance().getService(Constant.MENU_URL).getUserAppMenus(GetUserInfoUtils.getUserInfo().getUserId()).enqueue(new Callback<MenuBean>() {
            @Override
            public void onResponse(Call<MenuBean> call, Response<MenuBean> response) {
                WeiboDialogUtils.closeDialog(loadingDialog);
//                disDialog();
                MenuBean body = response.body();
                if (body != null) {

                    List<MenuBean.BringBean> bring = body.getBring();

                    if (bring != null) {

                        String toJson = new Gson().toJson(body);

                        Log.i(TAG, "onResponse===>: " + toJson);

                        String content = SPUtils.getContent(Constant.MENU_SAVE);
                        if (!TextUtils.isEmpty(content)) {
                            SPUtils.saveContent(Constant.MENU_SAVE, "");
                        }

                        SPUtils.saveContent(Constant.MENU_SAVE, toJson);
                        Constant.CONTENT_MENU = toJson;

                        jumpByRole(bringLogin);

                    }

                }

            }

            @Override
            public void onFailure(Call<MenuBean> call, Throwable t) {
//                disDialog();
                WeiboDialogUtils.closeDialog(loadingDialog);
                Log.i(TAG, "onFailure: 获取 菜单错误 " + t.getMessage());
            }
        });

    }


    private void jumpByRole(LoginResponseBean.BringBean bring) {

        String roleCode = bring.getRoleCode();
        Log.i(TAG, "jumpByRole: ===>>>" + roleCode);
        if (TextUtils.isEmpty(roleCode)) {
            startActivity(new Intent(APPLoginActivity.this, MainActivity.class));
            SPUtils.saveContent(Constant.CAR_TYPE, Constant.CAR_TYPE_JIAYOU);
            finish();
        } else {
            if (roleCode.contains(Constant.ROLE_KEHU_SIJI)) {
                startActivity(new Intent(APPLoginActivity.this, MainActivity.class));
                SPUtils.saveContent(Constant.CAR_TYPE, Constant.CAR_TYPE_JIAYOU);
            } else if (roleCode.contains(Constant.ROLE_BUJU)) {
//                startActivity(new Intent(APPLoginActivity.this, MainTransActivity.class));
                startActivity(new Intent(APPLoginActivity.this, MainActivity.class));
                SPUtils.saveContent(Constant.CAR_TYPE, Constant.CAR_TYPE_BUJI);
            } else if (roleCode.contains(Constant.ROLE_JIAYOU)) {
                startActivity(new Intent(APPLoginActivity.this, MainActivity.class));
                SPUtils.saveContent(Constant.CAR_TYPE, Constant.CAR_TYPE_JIAYOU);
            } else {
                startActivity(new Intent(APPLoginActivity.this, MainActivity.class));
                SPUtils.saveContent(Constant.CAR_TYPE, Constant.CAR_TYPE_JIAYOU);
            }
            finish();
        }

    }


    private void requestAPPUpdate() {
        AppUpdateReqBean updateReqBean = new AppUpdateReqBean();
        updateReqBean.setVersionType("1"); // 司机端 升级参数
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(updateReqBean);
        HttpManger.getHttpMangerInstance().getServices().latestVersion(requestBody).enqueue(new Callback<UpdRespBean>() {
            @Override
            public void onResponse(Call<UpdRespBean> call, Response<UpdRespBean> response) {
                UpdRespBean body = response.body();

                if (body != null) {

                    List<UpdRespBean.BringBean> bring = body.getBring();

                    if (bring != null && bring.size() > 0) {

                        parseUpdBring(bring.get(0));


                    }

                }


            }

            @Override
            public void onFailure(Call<UpdRespBean> call, Throwable t) {

            }
        });

    }

    private void parseUpdBring(UpdRespBean.BringBean bring) {

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
//        String filePath = bring.getFilePath();
//
//        if (TextUtils.isEmpty(filePath)) {
//            return;
//        }
//
//        versionUpdateBean.url = Constant.BASE_URL + "/busi/interface/downloadFile/" + filePath + "/";
//        Log.i(TAG, "parseUpdBring: 下载地址 " + versionUpdateBean.url);
//
//        String versionInServer = bring.getVersionNo();
//        String versionName = UIUtils.getVersionName(APPLoginActivity.this);
//        Log.i(TAG, "parseUpdBring: ======>>" + versionName);
//        if (!TextUtils.isEmpty(versionInServer)) {
//            if (!versionInServer.equals(versionName)) {
//                setVersionInfo(versionUpdateBean);
//            }
//        }


        if (bring == null) {
            return;
        }


        VersionUpdateBean versionUpdateBean = new VersionUpdateBean();
        versionUpdateBean.versionDesc = bring.getDescription();


        versionUpdateBean.versionStatus = "2";//非强制更新

        String filePath = bring.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return;
        }
        versionUpdateBean.url = Constant.BASE_URL + "/busi/interface/downloadFile/" + filePath + "/";
        Log.i(TAG, "parseUpdBring: 下载地址 " + versionUpdateBean.url);

        String versionInServer = bring.getVersionNo();
        String versionName = UIUtils.getVersionName(APPLoginActivity.this);

        String upGrades = bring.getUpGrades();

        if (!TextUtils.isEmpty(upGrades)) {
            if (upGrades.equals(unForceUpgrade)) {
                versionUpdateBean.versionStatus = "2";//非强制更新

            } else {
                versionUpdateBean.versionStatus = "3";//强制更新
            }

        }


        Log.i(TAG, "parseUpdBring: ======>>" + versionName);
        if (!TextUtils.isEmpty(versionInServer)) {
            if (!versionInServer.equals(versionName)) {
//                setVersionInfo(versionUpdateBean);


                if (versionUpdateBean.versionStatus == "2") {


                    downInfo(versionInServer, versionUpdateBean, false);


                } else {


                    downInfo(versionInServer, versionUpdateBean, true);


                }


            }
        }


    }


    public void downInfo(String versionInServer, final VersionUpdateBean versionUpdateBean, final boolean isForceDown) {
        LogUtils.i("downInfo  服务...");
        if (downloadBinder == null) {
            return;
        }
        LogUtils.i("创建对话框...");
        ConfirmDialog confirmDialog = new ConfirmDialog(APPLoginActivity.this, new com.neocom.mobilerefueling.downServices.Callback() {
            @Override
            public void callback(int position) {

                switch (position) {

                    case 0:  //cancle
                        if (isForceDown) System.exit(0);
                        break;

                    case 1:  //sure

                        downloadBinder.startDownload(versionUpdateBean.url);

                        break;


                }


            }


        });

        if (isForceDown) {
            confirmDialog.setCancleBtnGone();
        }
        confirmDialog.setTips("发现新版本:" + versionInServer);
        String content = versionUpdateBean.versionDesc;

        confirmDialog.setContent(content);
        confirmDialog.setCancelable(false);
        confirmDialog.show();
        LogUtils.i("显示对话框...");

    }


    public void setVersionInfo(VersionUpdateBean obj) {
        int status = -1;
        if (obj != null) {
//			1:不需要更新 2：建议更新 3：强制更新
            if (obj.versionStatus != null) {
                status = Integer.parseInt(obj.versionStatus);
            }
            if (status == 2 || status == 3) {
                dialogBuilder = NiftyDialogBuilder.getInstance(APPLoginActivity.this);
                dialogBuilder
                        .withDuration(700)              //时间
                        .withEffect(Effectstype.Fadein)             //动画
                        .withMessage(obj.versionDesc)   //描述
                        .withButton1Text("暂不更新")     //按钮1
                        .withButton2Text("软件更新")     //按钮2
                        .setForceUp(Integer.parseInt(obj.versionStatus))                  //是否强制更新
                        .setForceUpFlag(3)              //强制更新的标志
                        .withButton3Text("软件更新")     //强制更新的文字
                        .withUrl(obj.url)               //更新软件的地址
                        .isCancelableOnTouchOutside(false)
//                        .setCustomView(R.layout.dialog_update,this); //自定义布局
//
//                dialogBuilder.findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
//                        dialogBuilder.dismiss();
//                    }
//                });
//
//                dialogBuilder.findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
//                        dialogBuilder.updateApp();
//                    }
//                });

                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                                dialogBuilder.dismiss();
                            }
                        })
                        .setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                                dialogBuilder.updateApp();
                            }
                        })
                        .setButton3Click(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
//                                Toast.makeText(v.getContext(), "i'm btn3", Toast.LENGTH_SHORT).show();
                                dialogBuilder.updateApp();
                            }
                        }).show();

            }
        }

    }

    private void initPermissionReq() {

        permissionRequest = new PermissionRequest(APPLoginActivity.this, new PermissionRequest.PermissionCallback() {
            @Override
            public void onSuccessful() {
//                Toast.makeText(APPLoginActivity.this, "成功", Toast.LENGTH_LONG).show();
                requestAPPUpdate();

            }

            @Override
            public void onFailure() {
//                Toast.makeText(APPLoginActivity.this, "失败", Toast.LENGTH_LONG).show();


                // 这里使用自定义对话框，如果不想自定义，用AndPermission默认对话框：
                // AndPermission.rationaleDialog(Context, Rationale).show();

                // 自定义对话框。
                AlertDialog.newBuilder(APPLoginActivity.this)
                        .setTitle(R.string.title_dialog)
                        .setMessage(R.string.message_permission_failed)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                permissionRequest.request();
//                            rationale.resume();
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();


//                            rationale.cancel();
                            }
                        }).show();


            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
        unbindService(connection);
    }
}
