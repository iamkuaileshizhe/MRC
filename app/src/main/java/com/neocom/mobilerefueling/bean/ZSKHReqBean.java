package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/2.
 */

public class ZSKHReqBean implements Serializable{


    /**
     * userId : 3b6ddbe91a7444a3bec1d96bc20f5d29
     * nameSim :
     * beginNum : 1
     * endNum : 10
     */

    private String userId;
    private String nameSim;
    private String beginNum;
    private String endNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNameSim() {
        return nameSim;
    }

    public void setNameSim(String nameSim) {
        this.nameSim = nameSim;
    }

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }
}
