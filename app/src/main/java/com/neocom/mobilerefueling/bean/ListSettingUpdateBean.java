package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ListSettingUpdateBean {
    private String userId;
    private ListSettingBean listSetting;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ListSettingBean getListSetting() {
        return listSetting;
    }

    public void setListSetting(ListSettingBean listSetting) {
        this.listSetting = listSetting;
    }
}
