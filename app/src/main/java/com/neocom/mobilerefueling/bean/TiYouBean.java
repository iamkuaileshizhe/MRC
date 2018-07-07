package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/10.
 */

public class TiYouBean implements Serializable {


    /**
     * carCode : 京H12345
     * driver : 123
     * telphone : 123
     * surplusOil : 123
     * purchaseNum : 100
     * purchaseTime : 2017-11-10
     * batchId : BATCH000004
     * contractId : HT000002
     * oilCode : 123
     * oilPlace : 济南
     * recordStatus : 1
     * confirmPeople : 管理员
     * confirmTime : 2017-11-10
     * c_user : 17c4520f6cfd1ab53d8745e84681eb49
     * c_dt : 2017-11-10
     */

    private String carCode;
    private String driver;
    private String telphone;
    private String surplusOil;
    private String purchaseNum;
    private String purchaseTime;
    private String batchId;
    private String contractId;
    private String oilCode;
    private String oilPlace;
    private String recordStatus;
    private String confirmPeople;
    private String confirmTime;
    private String c_user;
    private String c_dt;

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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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
}
