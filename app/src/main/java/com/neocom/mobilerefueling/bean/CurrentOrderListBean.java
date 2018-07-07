package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/23.
 */

public class CurrentOrderListBean implements Serializable {

    private String userId;
    private String beginNum;
    private String endNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "CurrentOrderListBean{" +
                "userId='" + userId + '\'' +
                ", beginNum='" + beginNum + '\'' +
                ", endNum='" + endNum + '\'' +
                '}';
    }
}
