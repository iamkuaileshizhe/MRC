package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/16.
 */

public class OrdeInfoBean implements Serializable {
    String orderTime;
    String orderAddress;
    String orderPhone;
    String orderArrivalTime;
    String orderPayType;
    String orderCheck;
    String orderNote;

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderArrivalTime() {
        return orderArrivalTime;
    }

    public void setOrderArrivalTime(String orderArrivalTime) {
        this.orderArrivalTime = orderArrivalTime;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getOrderCheck() {
        return orderCheck;
    }

    public void setOrderCheck(String orderCheck) {
        this.orderCheck = orderCheck;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    @Override
    public String toString() {
        return "OrdeInfoBean{" +
                "orderTime='" + orderTime + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderArrivalTime='" + orderArrivalTime + '\'' +
                ", orderPayType='" + orderPayType + '\'' +
                ", orderCheck='" + orderCheck + '\'' +
                ", orderNote='" + orderNote + '\'' +
                '}';
    }
}
