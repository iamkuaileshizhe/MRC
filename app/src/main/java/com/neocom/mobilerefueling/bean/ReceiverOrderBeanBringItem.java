package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/24.
 */

public class ReceiverOrderBeanBringItem implements Serializable {


//    "vehicleId" : "78234238c5384e358dc427574928365c",
//            "relateId" : "2bd7345898284b6b909164e8a54628d8",
//            "relateType" : "0",
//            "vehicleCode" : "鲁A45678",
//            "pName" : "2",
//            "telphone" : "2",
//            "oilType" : "2",
//            "tankSize" : "2"

    private String vehicleId;
    private String relateId;
    private String relateType;
    private String vehicleCode;
    private String pName;
    private String telphone;
    private String oilType;
    private String tankSize;


    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRelateId() {
        return relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public String getRelateType() {
        return relateType;
    }

    public void setRelateType(String relateType) {
        this.relateType = relateType;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
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


    @Override
    public String toString() {
        return "ReceiverOrderBeanBringItem{" +
                "vehicleId='" + vehicleId + '\'' +
                ", relateId='" + relateId + '\'' +
                ", relateType='" + relateType + '\'' +
                ", vehicleCode='" + vehicleCode + '\'' +
                ", pName='" + pName + '\'' +
                ", telphone='" + telphone + '\'' +
                ", oilType='" + oilType + '\'' +
                ", tankSize='" + tankSize + '\'' +
                '}';
    }
}
