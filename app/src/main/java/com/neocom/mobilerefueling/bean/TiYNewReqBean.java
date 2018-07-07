package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/2.
 */

public class TiYNewReqBean implements Serializable {


    /**
     *  carCode  : 鲁AY3K10
     *  insConfirmStatus  : 0
     * beginNum : 1
     * endNum : 2
     */

    private String carCode;
//    private String insConfirmStatus;
    private String recordStatus;
    private String beginNum;
    private String endNum;

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

//    public String getInsConfirmStatus() {
//        return insConfirmStatus;
//    }
//
//    public void setInsConfirmStatus(String insConfirmStatus) {
//        this.insConfirmStatus = insConfirmStatus;
//    }

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
