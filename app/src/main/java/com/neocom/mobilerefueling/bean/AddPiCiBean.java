package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/3.
 */

public class AddPiCiBean implements Serializable {


    /**
     * fuelModel : 1
     * nationalStandard : 1
     * supplyId : 43a7cd3df9ef49229b844b65856ff77b
     * sampleNo : dsssssdf
     * fuelDensity : 10
     * supplyName : 张三丰
     * supplyTel : 13153031526
     * remark : 我的w我的我de我的我的beizhu
     * c_user : 497765600da547cea7c7d30dccff67fb
     */

    private String fuelModel;
    private String nationalStandard;
    private String supplyId;
    private String sampleNo;
    private String fuelDensity;
    private String supplyName;
    private String supplyTel;
    private String remark;
    private String c_user;

    public String getFuelModel() {
        return fuelModel;
    }

    public void setFuelModel(String fuelModel) {
        this.fuelModel = fuelModel;
    }

    public String getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(String nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

    public String getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getFuelDensity() {
        return fuelDensity;
    }

    public void setFuelDensity(String fuelDensity) {
        this.fuelDensity = fuelDensity;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplyTel() {
        return supplyTel;
    }

    public void setSupplyTel(String supplyTel) {
        this.supplyTel = supplyTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getC_user() {
        return c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }
}
