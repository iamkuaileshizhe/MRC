package com.neocom.mobilerefueling.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.neocom.mobilerefueling.globle.Constant;

import java.util.HashMap;

/**
 * Created by admin on 2017/11/7.
 * 创建人：xyz
 * 描述: 用于 保存 和读取 常用的数据 例如 用户名 密码 等
 */

public class SPUtils {


    private static SharedPreferences sharedPreferences;

    /**
     * @return 静态 sharedPreferences
     * 获取  Sp内保存的值
     */
    private static SharedPreferences getSharedPrefernce() {

        if (sharedPreferences == null) {

            sharedPreferences = UIUtils.getContext().getSharedPreferences(Constant.SP_USER, Context.MODE_PRIVATE);
        }

        return sharedPreferences;
    }

    /**
     * @param userName
     * @param passWord 保存 用户名 和 密码
     */
    public static void savaUser(String userName, String passWord) {


        SharedPreferences.Editor editor = getSharedPrefernce().edit();

        editor.putString(Constant.SP_USERNAME, userName);
        editor.putString(Constant.SP_PASSWORD, passWord);

        editor.commit();
    }

    public static HashMap<String, String> getUser() {

        SharedPreferences prefernce = getSharedPrefernce();
        HashMap<String, String> userMap = new HashMap<>();
        String userName = prefernce.getString(Constant.SP_USERNAME, "");
        String userPassword = prefernce.getString(Constant.SP_PASSWORD, "");
        userMap.put(Constant.SP_USERNAME, userName);
        userMap.put(Constant.SP_PASSWORD, userPassword);

        return userMap;

    }

    /**
     * @param isAutoLogin <p>
     *                    设置自动登录
     */
    public static void setAutoLogin(boolean isAutoLogin) {

        SharedPreferences.Editor loginEditor = getSharedPrefernce().edit();
        loginEditor.putBoolean(Constant.SP_AUTO_LOGIN, isAutoLogin);
        loginEditor.commit();

    }


    /**
     * @return 是否自动登录
     */
    public static boolean isAotiLogin() {

        SharedPreferences booleanEditor = getSharedPrefernce();
        boolean autoLogin = booleanEditor.getBoolean(Constant.SP_AUTO_LOGIN, false);
        return autoLogin;
    }

    /**
     * @param isAutoLogin <p>
     *                    设置自动登录
     */
    public static void setRember(boolean isAutoLogin) {

        SharedPreferences.Editor loginEditor = getSharedPrefernce().edit();
        loginEditor.putBoolean(Constant.SP_REMBER, isAutoLogin);
        loginEditor.commit();

    }


    public static void setTTSState(boolean state) {

        SharedPreferences.Editor loginEditor = getSharedPrefernce().edit();
        loginEditor.putBoolean(Constant.TTS_SWITCH, state);
        loginEditor.commit();

    }


    public static boolean getTTSState() {

        SharedPreferences booleanEditor = getSharedPrefernce();
        boolean autoLogin = booleanEditor.getBoolean(Constant.TTS_SWITCH, true);
        return autoLogin;
    }


    /**
     * @return 是否自动登录
     */
    public static boolean isRember() {

        SharedPreferences booleanEditor = getSharedPrefernce();
        boolean autoLogin = booleanEditor.getBoolean(Constant.SP_REMBER, false);
        return autoLogin;
    }


    public static void saveContent(String key, String value) {

        LogUtils.i("--->" + key + "====>" + value);

        SharedPreferences.Editor editor = getSharedPrefernce().edit();
        editor.putString(key, value).commit();

    }

    public static String getContent(String key) {

        SharedPreferences preferences = getSharedPrefernce();
        String string = preferences.getString(key, "");

        return string;
    }


    public static String getWebPort(String key) {

        SharedPreferences preferences = getSharedPrefernce();
        String string = preferences.getString(key, "");
        return string;
    }

    public static String getProcessPort(String key) {

        SharedPreferences preferences = getSharedPrefernce();
        String string = preferences.getString(key, "");

        return string;
    }

    public static void saveLoginConten(String key, String value) {

        SharedPreferences.Editor edit = getSharedPrefernce().edit();
        edit.putString(key, value).commit();
    }

    public static String getLoginContent(String key) {

        String loginContent = getSharedPrefernce().getString(key, "");
        return loginContent;
    }


    public static void setSaveCar(String value) {

        if (TextUtils.isEmpty(value)){
            saveContent(Constant.CAR_NUM, "");
        }else {
            saveContent(Constant.CAR_NUM, value);
        }



    }

    public static String getSaveCar() {
        String carNum = SPUtils.getContent(Constant.CAR_NUM);

        if (TextUtils.isEmpty(carNum)) {
            carNum = "";
        }
        return carNum;
    }

}
