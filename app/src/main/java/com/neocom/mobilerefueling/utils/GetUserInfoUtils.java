package com.neocom.mobilerefueling.utils;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.bean.DictBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.globle.Constant;

import java.util.List;

/**
 * Created by admin on 2017/11/9.
 */

public class GetUserInfoUtils {

    public static LoginResponseBean.BringBean getUserInfo() {

        String loginContent = SPUtils.getLoginContent(Constant.SP_LOGIN_CONTENT);

        if (TextUtils.isEmpty(loginContent)) {
            return new LoginResponseBean.BringBean();

        } else {

            Gson gson = new Gson();
            LoginResponseBean.BringBean bringBean = gson.fromJson(loginContent, LoginResponseBean.BringBean.class);

            Log.i("获取到的用户信息", "getUserInfo: loginContent:" + loginContent + ";bringBean:" + bringBean.toString());
            gson = null;
            return bringBean;

        }
    }

    public static DictBean.BringBean getDicValue() {

        String dicValue = SPUtils.getContent(Constant.DIC_CONTENT);

        if (TextUtils.isEmpty(dicValue)) {

            return new DictBean.BringBean();
        } else {

            Gson gson = new Gson();

            DictBean.BringBean dicBringBean = gson.fromJson(dicValue, DictBean.BringBean.class);
            return dicBringBean;
        }

    }

    public static String getMenu() {

        String contentMenu = Constant.CONTENT_MENU;

        if (TextUtils.isEmpty(contentMenu)) {
            contentMenu = SPUtils.getContent(Constant.MENU_SAVE);

        }

        if (TextUtils.isEmpty(contentMenu)) {
            return "";
        }

        return contentMenu;
    }

//
//   static Gson gson;
//   static MenuBean menuBean;
//    static List<MenuBean.BringBean> menuItems;
//
//    public static boolean menuEqualServer(String menu) {
//
//        if (gson == null) {
//            gson = new Gson();
//        }
//
//        if (menuBean == null) {
//            menuBean = gson.fromJson(getMenu(), MenuBean.class);
//        }
//        if (menuItems == null || menuItems.size() == 0) {
//            menuItems = menuBean.getBring();
//        }
//
//
//        Log.i("xxxx", "menuEqualServer: " + new Gson().toJson(menuItems));
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
//        return false;
//    }


}
