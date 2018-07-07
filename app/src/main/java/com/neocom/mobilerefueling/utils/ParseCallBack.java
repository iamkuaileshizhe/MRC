package com.neocom.mobilerefueling.utils;

/**
 * Created by Administrator on 2018/4/27.
 * <p>
 * Json 解析 接口回调
 */

public interface ParseCallBack {

    /**
     * 解析成功
     *
     * @param success
     */
    void onSuccess(Object success);

    /**
     * 解析 接口 失败
     */
    void onFail(String msg);

    /**
     * 解析接口错误
     */
    void onError();
}
