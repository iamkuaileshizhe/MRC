package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/31.
 * <p>
 * 查询所有结算记录 请求bean
 */

public class DailyBalanceReqBean implements Serializable {

    private String userId;
    private String id;
    private String payStatus;
    private String startTime;
    private String endTime;
    private String beginNum;
    private String endNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }
}
