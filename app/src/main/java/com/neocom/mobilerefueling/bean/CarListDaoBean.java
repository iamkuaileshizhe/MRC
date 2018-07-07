package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/9/1.
 */

public class CarListDaoBean implements Serializable {


    /**
     * id : 6f542e58a3a54bdb816122797f47b7d4
     * relateId : 027160b3e2604aaba97cb96c7c4916b8
     * relateType : 0
     * vehicleCode : 看看看
     * pName : null
     * telphone : 18799999999
     * oilType : 去
     * tankSize : 999
     * num : null
     * finishTime : 2017-08-30 15:00:00
     * oilBalance : 100
     * fillTime : 2017-08-30 16:00:00
     * oilTypeName : null
     * dstate : 1
     * status : 1
     * c_user : 17c4520f6cfd1ab53d8745e84681eb49
     * c_dt : 2017-08-24 10:27:25
     * u_user : null
     * u_dt : null
     */

    private String id;
    private String relateId;
    private String relateType;
    private String vehicleCode;
    private String pName;
    private String telphone;
    private String oilType;
    private String tankSize;
    private String num;
    private String finishTime;
    private String oilBalance;
    private String fillTime;
    private String oilTypeName;
    private String dstate;
    private String status;
    private String c_user;
    private String c_dt;
    private String u_user;
    private String u_dt;

    public String getId() {
        return id==null?"":id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelateId() {
        return relateId==null?"":relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public String getRelateType() {
        return relateType==null?"":relateType;
    }

    public void setRelateType(String relateType) {
        this.relateType = relateType;
    }

    public String getVehicleCode() {
        return vehicleCode==null?"":vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getPName() {
        return pName==null?"":pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getTelphone() {
        return telphone==null?"":telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getOilType() {
        return oilType==null?"":oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getTankSize() {
        return tankSize==null?"":tankSize;
    }

    public void setTankSize(String tankSize) {
        this.tankSize = tankSize;
    }

    public String getNum() {
        return num==null?"":num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFinishTime() {
        return finishTime==null?"":finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getOilBalance() {
        return oilBalance==null?"":oilBalance;
    }

    public void setOilBalance(String oilBalance) {
        this.oilBalance = oilBalance;
    }

    public String getFillTime() {
        return fillTime==null?"":fillTime;
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime;
    }

    public String getOilTypeName() {
        return oilTypeName==null?"":oilTypeName;
    }

    public void setOilTypeName(String oilTypeName) {
        this.oilTypeName = oilTypeName;
    }

    public String getDstate() {
        return dstate==null?"":dstate;
    }

    public void setDstate(String dstate) {
        this.dstate = dstate;
    }

    public String getStatus() {
        return status==null?"":status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_user() {
        return c_user==null?"":c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }

    public String getC_dt() {
        return c_dt==null?"":c_dt;
    }

    public void setC_dt(String c_dt) {
        this.c_dt = c_dt;
    }

    public String getU_user() {
        return u_user==null?"":u_user;
    }

    public void setU_user(String u_user) {
        this.u_user = u_user;
    }

    public String getU_dt() {
        return u_dt==null?"":u_dt;
    }

    public void setU_dt(String u_dt) {
        this.u_dt = u_dt;
    }

    @Override
    public String toString() {
        return "CarListDaoBean{" +
                "id='" + id + '\'' +
                ", relateId='" + relateId + '\'' +
                ", relateType='" + relateType + '\'' +
                ", vehicleCode='" + vehicleCode + '\'' +
                ", pName=" + pName +
                ", telphone='" + telphone + '\'' +
                ", oilType='" + oilType + '\'' +
                ", tankSize='" + tankSize + '\'' +
                ", num=" + num +
                ", finishTime='" + finishTime + '\'' +
                ", oilBalance='" + oilBalance + '\'' +
                ", fillTime='" + fillTime + '\'' +
                ", oilTypeName=" + oilTypeName +
                ", dstate='" + dstate + '\'' +
                ", status='" + status + '\'' +
                ", c_user='" + c_user + '\'' +
                ", c_dt='" + c_dt + '\'' +
                ", u_user=" + u_user +
                ", u_dt=" + u_dt +
                '}';
    }
}
