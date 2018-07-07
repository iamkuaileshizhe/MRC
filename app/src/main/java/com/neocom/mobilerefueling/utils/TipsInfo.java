package com.neocom.mobilerefueling.utils;

import android.app.Activity;
import android.text.TextUtils;

import me.leefeng.promptlibrary.PromptDialog;

/**
 * Created by Administrator on 2018/3/15.
 */

public class TipsInfo {
    private static final TipsInfo ourInstance = new TipsInfo();
    private static PromptDialog promptDialog;


    public static TipsInfo getInstance(Activity activity) {

        //创建对象
        promptDialog = new PromptDialog(activity);
        //设置自定义属性
        promptDialog.getDefaultBuilder().touchAble(true).round(3).loadingDuration(3000);

        return ourInstance;
    }

    private TipsInfo() {
    }

    public void showLoadingTip(String msg) {

        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showLoading(msg);

    }

    public void showWarnTip(String msg) {

        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showWarn(msg);

    }

    public void showSuccessTip(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showSuccess(msg);
    }

    public void showInfoTip(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showInfo(msg);
    }

    public void showErrorTip(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showError(msg);
    }

    public void showCustomDialogTip(int resId, String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        promptDialog.showCustom(resId, msg);

    }


}