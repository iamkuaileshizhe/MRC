package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/31.
 */

public class HomeMenuBean implements Serializable {

    private int iId; // 首页的 菜单  ID
    private String iName;//  首页菜单的名字

    public HomeMenuBean(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    @Override
    public String toString() {
        return "HomeMenuBean{" +
                "iId=" + iId +
                ", iName='" + iName + '\'' +
                '}';
    }
}
