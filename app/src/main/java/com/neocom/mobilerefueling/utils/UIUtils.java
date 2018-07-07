package com.neocom.mobilerefueling.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.neocom.mobilerefueling.globle.ItsmsApplication;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.huanyu.itsms.globle.ItsmsApplication;

/**
 * Created by admin on 2017/7/17.
 * 常用的  UI工具类
 */

public class UIUtils {

    public static Context getContext() {
        return ItsmsApplication.getContext();
    }

    public static Handler getHandler() {
        return ItsmsApplication.getHandler();
    }

    public static int getMainThreadId() {
        return ItsmsApplication.getMainThreadId();
    }

    //////////////////// 加载资源文件//////////////////////
    // 获取字符串

    public static String getString(int id) {
        return getContext().getResources().getString(id);

    }
    // 获取字符串数组

    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    // 获取图片
    public static Drawable getDrawable(int id) {
        return getContext().getResources().getDrawable(id);
    }

    // 获取颜色
    public static int getColor(int id) {
        return getContext().getResources().getColor(id);
    }

    /**
     * 根据 ID 获取颜色状态选择器
     */
    public static ColorStateList getColorStateList(int id) {
        // TODO Auto-generated method stub
        return getContext().getResources().getColorStateList(id);
    }

    // 获取尺寸
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id); // 返回 具体
        // 像素值
    }
    //////////////////// 加载资源文件//////////////////////

    public static int dip2px(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dip + 0.5f);
    }

    public static float px2dip(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    //////////////////// 加载布局文件//////////////////////

    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    //////////////////// 判断 是否运行在 主线程UI/////////////////

    public static boolean isRunOnUIThread() {

        int myTid = android.os.Process.myTid();

        if (myTid == getMainThreadId()) {
            return true;
        }

        return false;
    }

    public static void runOnUIThread(Runnable r) {

        if (isRunOnUIThread()) {
            // 已经是的 就直接运行
            r.run();
        } else {

            getHandler().post(r);

        }

    }

    public static String getCurrentTime(){

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);

        return str;
    }
    public static String getCurrentHm(){

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm ");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);

        return str;
    }


    /**
     * get App versionCode
     * @param context
     * @return
     */
    public String getVersionCode(Context context){
        PackageManager packageManager=context.getPackageManager();
        PackageInfo packageInfo;
        String versionCode="";
        try {
            packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            versionCode=packageInfo.versionCode+"";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * get App versionName
     * @param context
     * @return
     */
    public static String getVersionName(Context context){
        PackageManager packageManager=context.getPackageManager();
        PackageInfo packageInfo;
        String versionName="";
        try {
            packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            versionName=packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


    /**
     *
     * 将 double 格式化 成 两位 数 转化为 String
     * @param value
     * @return
     */
    public static String formatDoub(double value,int module) {

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(module);
 /*
  * setMinimumFractionDigits设置成2
  *
  * 如果不这么做，那么当value的值是100.00的时候返回100
  *
  * 而不是100.00
  */
        nf.setMinimumFractionDigits(module);
        nf.setRoundingMode(RoundingMode.HALF_UP);
 /*
  * 如果想输出的格式用逗号隔开，可以设置成true
  */
        nf.setGroupingUsed(false);
        return nf.format(value);
    }

}
