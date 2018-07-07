package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2018/1/1.
 */

public class MarQueenDataReqBean implements Serializable {


    /**
     * userId : faac2e7c12294911b79303c71a4e22fd
     * province : 110000
     */

    private String userId;
    private String province;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "MarQueenDataReqBean{" +
                "userId='" + userId + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
