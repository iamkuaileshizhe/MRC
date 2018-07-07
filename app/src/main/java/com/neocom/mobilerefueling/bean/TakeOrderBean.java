package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/29.
 */

public class TakeOrderBean implements Serializable {
    private String id;
    private String dstate;
//    private String estimateTime;
    private String estimateArrivalTime;//  estimateTime 修改为 estimateArrivalTime
    private String remark;
    private String userId;
    private String indentId;

    public String getIndentId() {
        return indentId;
    }

    public void setIndentId(String indentId) {
        this.indentId = indentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEstimateArrivalTime() {
        return estimateArrivalTime;
    }

    public void setEstimateArrivalTime(String estimateArrivalTime) {
        this.estimateArrivalTime = estimateArrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDstate() {
        return dstate;
    }

    public void setDstate(String dstate) {
        this.dstate = dstate;
    }

//    public String getEstimateTime() {
//        return estimateTime;
//    }
//
//    public void setEstimateTime(String estimateTime) {
//        this.estimateTime = estimateTime;
//    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "TakeOrderBean{" +
                "id='" + id + '\'' +
                ", dstate='" + dstate + '\'' +
                ", estimateArrivalTime='" + estimateArrivalTime + '\'' +
                ", remark='" + remark + '\'' +
                ", userId='" + userId + '\'' +
                ", indentId='" + indentId + '\'' +
                '}';
    }
}
