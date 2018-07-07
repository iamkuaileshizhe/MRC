package com.neocom.mobilerefueling.globle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.SpeechUtility;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.crash.NeverCrash;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * ,%%%%%%%%,
 * ,%%/\%%%%/\%%
 * ,%%%\c "" J/%%%
 * %.       %%%%/ o  o \%%%
 * `%%.     %%%%    _  |%%%
 * `%%     `%%%%(__Y__)%%'
 * //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%'
 * \\    .'          |
 * \\  /       \  | |
 * \\/         ) | |
 * \         /_ | |__
 * (___________)))))))
 * <p>
 * <p>
 * _       _
 * __   _(_)_   _(_) __ _ _ __
 * \ \ / / \ \ / / |/ _` | '_ \
 * \ V /| |\ V /| | (_| | | | |
 * \_/ |_| \_/ |_|\__,_|_| |_|
 */


public class ItsmsApplication extends Application {
    private static final String TAG = "ItsmsApplication";
    private static Context context;

    private static Handler handler;

    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();


        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();


        SpeechUtility.createUtility(ItsmsApplication.this, "appid=" + getString(R.string.app_id));

        UMConfigure.setLogEnabled(true);

        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");
        Config.DEBUG = true;

        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.e("报错啦==>", "看这里: " + Log.getStackTraceString(e));
            }
        });
        ReportStrategy();
    }


    //各个平台的配置，建议放在全局Application或者程序入口
    {
//        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
//        PlatformConfig.setWeixin("wx9f084059c925a62a", "83875db12d18e61fd36b9ef891bec029");
        PlatformConfig.setWeixin("wxc32dfaf0814beab5","fc3df327f1c5d1197e0ef384ac6bcabd");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
//        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        PlatformConfig.setQQZone("1106675995", "H8cVmZovdaUspLKq");
        PlatformConfig.setQQZone("1106712189", "Is5ioW4COayvltdl");
//        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
//        PlatformConfig.setAlipay("2015111700822536");
//        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
//        PlatformConfig.setPinterest("1439206");
//        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
//        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
//        PlatformConfig.setVKontakte("5764965", "5My6SNliAaLxEm3Lyd9J");
//        PlatformConfig.setDropbox("oz8v5apet3arcdy", "h7p2pjbzkkxt02a");

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }


    public static Handler getHandler() {
        return handler;
    }


    public static int getMainThreadId() {
        return mainThreadId;
    }

    private void ReportStrategy() {
// 获取当前包名
        String packageName = context.getPackageName();
// 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
// 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
// 初始化Bugly
        CrashReport.initCrashReport(context, Constant.BUGLY_APPID, true, strategy);
// 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
// CrashReport.initCrashReport(context, strategy);

    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

}
