package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/28.
 */

public class GetOilOrderBean implements Serializable {


//
//    carCode	String	N	运油车牌号
//    driver	String	N	司机
//    telphone	String	N	电话
//    surplusOil	String	N	剩余油量
//    purchaseNum	String	N	提取油量
//    purchaseTime	String	N	提取时间
//    batchId	String	N	油品批次id
//    recordStatus	String	N	提油记录确认状态
//    confirmPeople	String	N	确认人
//    confirmTime	String	N	确认时间
//    c_user	String	Y	创建人
//    c_dt	String	Y	创建时间


    private String carCode;
    private String driver;
    private String telphone;
    private String surplusOil;
    private String purchaseNum;
    private String purchaseTime;
    private String batchId;
    private String recordStatus;
    private String confirmPeople;
    private String confirmTime;
    private String c_user;
    private String c_dt;
    private String remarks;


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
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

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getConfirmPeople() {
        return confirmPeople;
    }

    public void setConfirmPeople(String confirmPeople) {
        this.confirmPeople = confirmPeople;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getC_user() {
        return c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }

    public String getC_dt() {
        return c_dt;
    }

    public void setC_dt(String c_dt) {
        this.c_dt = c_dt;
    }


    @Override
    public String toString() {
        return "GetOilOrderBean{" +
                "carCode='" + carCode + '\'' +
                ", driver='" + driver + '\'' +
                ", telphone='" + telphone + '\'' +
                ", surplusOil='" + surplusOil + '\'' +
                ", purchaseNum='" + purchaseNum + '\'' +
                ", purchaseTime='" + purchaseTime + '\'' +
                ", batchId='" + batchId + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", confirmPeople='" + confirmPeople + '\'' +
                ", confirmTime='" + confirmTime + '\'' +
                ", c_user='" + c_user + '\'' +
                ", c_dt='" + c_dt + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }


}
