package com.neocom.mobilerefueling.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.AppUpdateReqBean;
import com.neocom.mobilerefueling.bean.UpdRespBean;
import com.neocom.mobilerefueling.bean.VersionUpdateBean;
import com.neocom.mobilerefueling.downServices.ConfirmDialog;
import com.neocom.mobilerefueling.downServices.DownloadService;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/7/6.
 */

public class CurrentVersionAndIntroActivity extends BaseActivity implements SuperTextView.OnSuperTextViewClickListener {
    @BindView(R.id.setting_topbar)
    TopTitleBar settingTopbar;
    @BindView(R.id.version_code)
    SuperTextView versionCode;
    @BindView(R.id.about_us)
    SuperTextView aboutUs;

    private DownloadService.DownloadBinder downloadBinder;

    private ServiceConnection connection;
    private final String unForceUpgrade = "0"; //0非强制升级

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_current);
    }

    @Override
    public void initView() {
        settingTopbar.setOnleftFinishOnclickListener(new TopTitleBar.leftFinishOnclickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }
        });

        versionCode.setOnSuperTextViewClickListener(this);
        aboutUs.setOnSuperTextViewClickListener(this);

        versionCode.setRightString(UIUtils.getVersionName(this));
    }

    @Override
    public void initData() {
        connection = new ServiceConnection() {

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                downloadBinder = (DownloadService.DownloadBinder) service;

                LogUtils.i("服务连接.......onServiceConnected..................");

            }

        };

        startService();
    }

    @Override
    public void onClickListener(SuperTextView superTextView) {


        switch (superTextView.getId()) {

            case R.id.version_code:


                if (downloadBinder == null) {


                    connection = new ServiceConnection() {

                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                        }

                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            downloadBinder = (DownloadService.DownloadBinder) service;

                            LogUtils.i("服务连接.......onServiceConnected..................");

                            requestAPPUpdate();
                        }

                    };

                    startService();

                } else {

                    requestAPPUpdate();
                }


                break;
            case R.id.about_us:

                startActivity(new Intent(UIUtils.getContext(), AboutUSActivity.class));
                break;


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
        String versionName = UIUtils.getVersionName(CurrentVersionAndIntroActivity.this);

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
            if (versionInServer.equals(versionName)) {

                Toast.makeText(this, "当前已是最新版本", Toast.LENGTH_SHORT).show();

            } else {

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

//        versionUpdateBean.url="https://down.2144gy.com/dtxxz/dtxxz_66585.apk";

        LogUtils.i("创建对话框...");
        ConfirmDialog confirmDialog = new ConfirmDialog(CurrentVersionAndIntroActivity.this, new com.neocom.mobilerefueling.downServices.Callback() {
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


    private void startService() {


        Intent intent = new Intent(this, DownloadService.class);
        startService(intent); // 启动服务
        bindService(intent, connection, BIND_AUTO_CREATE); // 绑定服务
        LogUtils.i("启动服务...");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
