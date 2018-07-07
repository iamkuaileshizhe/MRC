package com.neocom.mobilerefueling.services;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;

import com.neocom.mobilerefueling.MainActivity;
import com.neocom.mobilerefueling.utils.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/4/8.
 */
//boolean Flag= ServiceUtil.isServiceRunning(this,"zph.zhjx.com.chat.service.LocationService");
public class ServiceUtil {


    public static void startUpLocServices(Context context) {

        boolean serviceRunning = isServiceRunning(context, "com.neocom.mobilerefueling.services");

        LogUtils.d(" 开始 位置上传服务 是否 运行中" + serviceRunning);

        Intent intent = new Intent(context, UploadService.class);
        context.startService(intent);
    }

    public static void stopUpLocServices(Context context) {

        boolean serviceRunning = isServiceRunning(context, "com.neocom.mobilerefueling.services");

        LogUtils.d(" 停止 位置上传服务 是否 运行中" + serviceRunning);

        Intent intent = new Intent(context, UploadService.class);
        context.stopService(intent);

    }


    /**
     * 用来判断某个服务是否开启
     */
    public static boolean isServiceRunning(Context mContext, String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)
                mContext.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList
                = activityManager.getRunningServices(30);
        if (!(serviceList.size() > 0)) {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }


    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isOPen(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }

        return false;
    }


    /**
     * 强制帮用户打开GPS
     *
     * @param context
     */
    public static final void openGPS(Context context) {
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings",
                "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(context, 0, GPSIntent, 0).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }
}