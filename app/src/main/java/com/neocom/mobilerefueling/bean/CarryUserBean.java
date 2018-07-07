package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/27.
 */

public class CarryUserBean implements Serializable {


    /**
     * beginNum : 1
     * carryUserId : 3f67e2778c944999a00692f493862c50
     * endNum : 10
     * shiftStatus :
     */

    private String beginNum;
    private String carryUserId;
    private String endNum;
    private String shiftStatus;

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getCarryUserId() {
        return carryUserId;
    }

    public void setCarryUserId(String carryUserId) {
        this.carryUserId = carryUserId;
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
        return "CarryUserBean{" +
                "beginNum='" + beginNum + '\'' +
                ", carryUserId='" + carryUserId + '\'' +
                ", endNum='" + endNum + '\'' +
                ", shiftStatus='" + shiftStatus + '\'' +
                '}';
    }
}
