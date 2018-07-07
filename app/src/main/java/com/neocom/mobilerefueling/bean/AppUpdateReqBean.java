package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/12/21.
 */

public class AppUpdateReqBean implements Serializable {


    /**
     * appCode : android_server
     */

    private String versionType;

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }
}
