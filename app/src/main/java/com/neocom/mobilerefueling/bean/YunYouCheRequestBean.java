package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/11/8.
 */

public class YunYouCheRequestBean {


    /**
     * beginNum : 1
     * userId : c43df91e354e4bea934004fdf29e4e6d
     * endNum : 10
     * recordStatus :
     *
     * "carNum":"青A99991",
     */

    private String beginNum;
    private String userId;
    private String carNum;
    private String endNum;
    private String recordStatus;
    private String opFlag;

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
