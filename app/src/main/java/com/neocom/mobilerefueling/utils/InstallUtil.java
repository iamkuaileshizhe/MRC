package com.neocom.mobilerefueling.utils;

/**
 * Created by admin on 2018/1/3.
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;

public class InstallUtil {
    /**
     * @param context
     * @param apkPath  要安装的APK
     * @param rootMode 是否是Root模式
     */
    public static void install(Context context, String apkPath, boolean rootMode) {
//        if (rootMode){
//            installRoot(context,apkPath);
//        }else {
        installNormal(context, apkPath);
//        }
    }

    /**
     * 通过非Root模式安装
     *
     * @param context
     * @param apkPath
     */
    public static void install(Context context, String apkPath) {
        install(context, apkPath, false);
    }

    //普通安装
    private static void installNormal(Context context, String apkPath) {

        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            File apkFile = new File(apkPath);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                String authority = context.getPackageName() + ".fileProvider";
                Uri contentUri = FileProvider.getUriForFile(context, authority, apkFile);

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            }
            context.startActivity(intent);
//            if (callBack != null) {
//                callBack.onSuccess();
//            }
            //关闭当前
//            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
//            if (callBack != null) {
//                callBack.onFail(e);
//            }

            saveFile(e.getMessage());

        }


    }


    public static void saveFile(String str) {
        String filePath = null;
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) { // SD卡根目录的异常日志文件
            filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "zc_installException" + UIUtils.getCurrentTime() + ".txt";
        } else  // 系统下载缓存根目录的 异常日志文件
            filePath = Environment.getDownloadCacheDirectory().toString() + File.separator + "zc_installException_xx" + UIUtils.getCurrentTime() + ".txt";
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(file);
            outStream.write(str.getBytes());
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    //通过Root方式安装
//    private static void installRoot(Context context, String apkPath) {
//        Observable.just(apkPath)
//                .map(mApkPath -> "pm install -r " + mApkPath)
//                .map(SystemManager::RootCommand)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(integer -> {
//                    if (integer == 0) {
//                        Toast.makeText(context, "安装成功", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(context, "root权限获取失败,尝试普通安装", Toast.LENGTH_SHORT).show();
//                        install(context,apkPath);
//                    }
//                });
//    }


}