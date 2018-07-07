package com.neocom.mobilerefueling.activity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/5.
 */

public class DeviceInfo implements Serializable {


    /**
     * ipAddress : 192.168.1.1
     * systemModel : android7.0
     * equModel : MI NOTE
     * width : 222
     * height : 666
     */

    private String ipAddress;
    private String systemModel;
    private String equModel;
    private String width;
    private String height;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(String systemModel) {
        this.systemModel = systemModel;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
