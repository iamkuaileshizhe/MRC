package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/16.
 */

public class OderCarInfoBean implements Serializable {
    String orderCarNum;
    String orderCarOilType;
    String orderCarOilCount;
    String orderCarDriver;
    String orderCarDriverPhone;


    public String getOrderCarNum() {
        return orderCarNum;
    }

    public void setOrderCarNum(String orderCarNum) {
        this.orderCarNum = orderCarNum;
    }

    public String getOrderCarOilType() {
        return orderCarOilType;
    }

    public void setOrderCarOilType(String orderCarOilType) {
        this.orderCarOilType = orderCarOilType;
    }

    public String getOrderCarOilCount() {
        return orderCarOilCount;
    }

    public void setOrderCarOilCount(String orderCarOilCount) {
        this.orderCarOilCount = orderCarOilCount;
    }

    public String getOrderCarDriver() {
        return orderCarDriver;
    }

    public void setOrderCarDriver(String orderCarDriver) {
        this.orderCarDriver = orderCarDriver;
    }

    public String getOrderCarDriverPhone() {
        return orderCarDriverPhone;
    }

    public void setOrderCarDriverPhone(String orderCarDriverPhone) {
        this.orderCarDriverPhone = orderCarDriverPhone;
    }


    @Override
    public String toString() {
        return "OderCarInfoBean{" +
                "orderCarNum='" + orderCarNum + '\'' +
                ", orderCarOilType='" + orderCarOilType + '\'' +
                ", orderCarOilCount='" + orderCarOilCount + '\'' +
                ", orderCarDriver='" + orderCarDriver + '\'' +
                ", orderCarDriverPhone='" + orderCarDriverPhone + '\'' +
                '}';
    }


}
