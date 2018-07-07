package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/23.
 */

public class RequestPageBean implements Serializable {

    private String beginNum;
    private String endNum;

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

    @Override
    public String toString() {
        return "RequestPageBean{" +
                "beginNum='" + beginNum + '\'' +
                ", endNum='" + endNum + '\'' +
                '}';
    }
}
