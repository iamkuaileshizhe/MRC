package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/9/6.
 */

public class RequestGetOilPageBean implements Serializable {


    /**
     * userId : 6f480984195841ecab4c24946362b2ad
     * beginNum : 1
     * endNum : 2
     */

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
        return "RequestGetOilPageBean{" +
                "userId='" + userId + '\'' +
                ", beginNum='" + beginNum + '\'' +
                ", endNum='" + endNum + '\'' +
                '}';
    }
}
