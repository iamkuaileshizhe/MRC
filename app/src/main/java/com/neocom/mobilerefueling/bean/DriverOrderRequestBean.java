package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/9/8.
 * <p>
 * 1：已接单，2：已拒绝，3：已完成，0：待接单
 */

public class DriverOrderRequestBean implements Serializable {


    /**
     * carNum : 加油啊
     * ”dstate” : ”1”
     */
    public String carNum;
    public String dstate;

    public String currentPage;
    public String pageSize;


    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getDstate() {
        return dstate;
    }

    public void setDstate(String dstate) {
        this.dstate = dstate;
    }

    @Override
    public String toString() {
        return "DriverOrderRequestBean{" +
                "carNum='" + carNum + '\'' +
                ", dstate='" + dstate + '\'' +
                ", currentPage='" + currentPage + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
