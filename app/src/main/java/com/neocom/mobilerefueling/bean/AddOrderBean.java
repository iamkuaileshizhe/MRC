package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class AddOrderBean implements Serializable {


    /**
     * userId : 917f2f6eb1ce42a5968ee3a76bcf07c9
     * indentAddress : 2017-8-28下午测试新增2
     * delStatus : 1
     * deliveryTime : 2017-8-23
     * payType  : 1
     * indentStatus : 1
     * linkMan : 冯七
     * phone : 13666666666666
     * remark : 1000
     * cars : [{"vehicleCode":"鲁A98765","oilType":"1","tankSize":"5L","pName":"小张","telphone":"666666"},{"vehicleCode":"鲁B678900","oilType":"1","tankSize":"5L","pName":"小王","telphone":"888888"}]
     */

    private String userId;
    private String indentAddress;
    private String delStatus;
    private String deliveryTime;
    private String payType;
    private String indentStatus;
    private String linkMan;
    private String phone;
    private String remark;
    private java.util.List<CarsBean> cars;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<CarsBean> getCars() {
        return cars;
    }

    public void setCars(List<CarsBean> cars) {
        this.cars = cars;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIndentAddress() {
        return indentAddress;
    }

    public void setIndentAddress(String indentAddress) {
        this.indentAddress = indentAddress;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public static class CarsBean {
        /**
         * vehicleCode : 鲁A98765
         * oilType : 1
         * tankSize : 5L
         * pName : 小张
         * telphone : 666666
         */

        private String vehicleCode;
        private String oilType;
        private String tankSize;
        private String pName;
        private String telphone;

        public String getVehicleCode() {
            return vehicleCode;
        }

        public void setVehicleCode(String vehicleCode) {
            this.vehicleCode = vehicleCode;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getTankSize() {
            return tankSize;
        }

        public void setTankSize(String tankSize) {
            this.tankSize = tankSize;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }
    }
}
