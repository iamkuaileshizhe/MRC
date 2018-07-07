package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/27.
 */

public class TurnedUserBean implements Serializable {


    /**
     * beginNum : 1
     * turnUserId : 3f67e2778c944999a00692f493862c50
     * endNum : 10
     * shiftStatus : 0
     */

    private String beginNum;
    private String turnUserId;
    private String endNum;
    private String shiftStatus;

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getTurnUserId() {
        return turnUserId;
    }

    public void setTurnUserId(String turnUserId) {
        this.turnUserId = turnUserId;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getShiftStatus() {
        return shiftStatus;
    }

    public void setShiftStatus(String shiftStatus) {
        this.shiftStatus = shiftStatus;
    }

    @Override
    public String toString() {
        return "TurnedUserBean{" +
                "beginNum='" + beginNum + '\'' +
                ", turnUserId='" + turnUserId + '\'' +
                ", endNum='" + endNum + '\'' +
                ", shiftStatus='" + shiftStatus + '\'' +
                '}';
    }
}
