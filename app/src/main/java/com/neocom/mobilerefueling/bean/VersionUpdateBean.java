package com.neocom.mobilerefueling.bean;

/**
 * 下载 更新 用到的 实体类
 */
public class VersionUpdateBean {
    public String versionDesc;// 描述
    public String url; //下载地址
    public String versionStatus;//1：不需要更新 2：建议更新 3:强制更新
}
