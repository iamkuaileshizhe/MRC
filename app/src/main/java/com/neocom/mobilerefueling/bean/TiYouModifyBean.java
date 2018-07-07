package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/3.
 */

public class TiYouModifyBean implements Serializable {


    /**
     * id : a3b900bcd5a94ec491bfa9f8a58f05c8
     * driver : zhangsan
     * telphone : 1366666666
     * surplusOil : 200
     * purchaseNum : 10
     * purchaseTime : 2018-03-02 08:37:10
     * oilCode : 2
     * oilPlace : 济南市
     * poundsBefore : 200
     * poundsAfter : 210
     * completePeople : 7865f13164664435815a505a6acc859e
     * completeTime : 2018-03-02 08:37:10
     */

    private String id;
    private String driver;
    private String telphone;
    private String surplusOil;
    private String purchaseNum;
    private String purchaseTime;
    private String oilCode;
    private String oilPlace;
    private String poundsBefore;
    private String poundsAfter;
    private String completePeople;
    private String completeTime;
//    private String insConfirmStatus;
    private String recordStatus;
    private String unit;


    //        surplusOil	String	N	剩余油量
//        purchaseTime	String	N	提取时间


//    "insConfirmStatus": "0",//指令确认状态 1:已确认 0:未确认


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }


//    public String getInsConfirmStatus() {
//        return insConfirmStatus;
//    }
//
//    public void setInsConfirmStatus(String insConfirmStatus) {
//        this.insConfirmStatus = insConfirmStatus;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getSurplusOil() {
        return surplusOil;
    }

    public void setSurplusOil(String surplusOil) {
        this.surplusOil = surplusOil;
    }

    public String getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(String purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getOilCode() {
        return oilCode;
    }

    public void setOilCode(String oilCode) {
        this.oilCode = oilCode;
    }

    public String getOilPlace() {
        return oilPlace;
    }

    public void setOilPlace(String oilPlace) {
        this.oilPlace = oilPlace;
    }

    public String getPoundsBefore() {
        return poundsBefore;
    }

    public void setPoundsBefore(String poundsBefore) {
        this.poundsBefore = poundsBefore;
    }

    public String getPoundsAfter() {
        return poundsAfter;
    }

    public void setPoundsAfter(String poundsAfter) {
        this.poundsAfter = poundsAfter;
    }

    public String getCompletePeople() {
        return completePeople;
    }

    public void setCompletePeople(String completePeople) {
        this.completePeople = completePeople;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }
}
