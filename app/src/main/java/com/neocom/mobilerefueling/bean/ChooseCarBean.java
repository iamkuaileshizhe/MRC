package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/11.
 */

public class ChooseCarBean implements Serializable {


    /**
     * seqCode : lubbbb
     * model : 123
     * tankSize : 123
     * belong : 81315e2dcb294cc8b6799dc81843465f
     * driverOne : 3708021994904444444444
     * remark : 123
     * driverTwo : 37080219940966666666666
     * buyDate : 2017-08-01
     * id : 1e48be2d5393480bbcda8cc085f9941c
     * carType : 5
     * frameNum : 123123
     * buyPlace : 123
     * fuelType : 1
     * carNum : 鲁BBBBB
     * name : 林志玲
     * buyPrice : 123
     * telephone : 123
     * review : 123
     * leaveDate : 2017-08-09
     */

    private String seqCode;
    private String model;
    private String tankSize;
    private String belong;
    private String driverOne;
    private String remark;
    private String driverTwo;
    private String buyDate;
    private String id;
    private String carType;
    private String frameNum;
    private String buyPlace;
    private String fuelType;
    private String carNum;
    private String name;
    private String buyPrice;
    private String telephone;
    private String review;
    private String leaveDate;

    private boolean checked;

//    public Boolean getChecked() {
//        return checked;
//    }
//
//    public void setChecked(Boolean checked) {
//        this.checked = checked;
//    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getSeqCode() {
        return seqCode;
    }

    public void setSeqCode(String seqCode) {
        this.seqCode = seqCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTankSize() {
        return tankSize;
    }

    public void setTankSize(String tankSize) {
        this.tankSize = tankSize;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getDriverOne() {
        return driverOne;
    }

    public void setDriverOne(String driverOne) {
        this.driverOne = driverOne;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDriverTwo() {
        return driverTwo;
    }

    public void setDriverTwo(String driverTwo) {
        this.driverTwo = driverTwo;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum;
    }

    public String getBuyPlace() {
        return buyPlace;
    }

    public void setBuyPlace(String buyPlace) {
        this.buyPlace = buyPlace;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Override
    public String toString() {
        return "ChooseCarBean{" +
                "seqCode='" + seqCode + '\'' +
                ", model='" + model + '\'' +
                ", tankSize='" + tankSize + '\'' +
                ", belong='" + belong + '\'' +
                ", driverOne='" + driverOne + '\'' +
                ", remark='" + remark + '\'' +
                ", driverTwo='" + driverTwo + '\'' +
                ", buyDate='" + buyDate + '\'' +
                ", id='" + id + '\'' +
                ", carType='" + carType + '\'' +
                ", frameNum='" + frameNum + '\'' +
                ", buyPlace='" + buyPlace + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", carNum='" + carNum + '\'' +
                ", name='" + name + '\'' +
                ", buyPrice='" + buyPrice + '\'' +
                ", telephone='" + telephone + '\'' +
                ", review='" + review + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                ", checked=" + checked +
                '}';
    }
}
