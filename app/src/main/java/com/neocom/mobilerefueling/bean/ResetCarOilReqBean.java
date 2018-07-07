package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/16.
 */

public class ResetCarOilReqBean implements Serializable {


    /**
     * carNum : 鲁A99999
     * userId : eb7c0b4fcbf1429a9fb8c358697f3365
     * remark : 1111111111111111111111111
     */

    private String carNum;
    private String userId;
    private String remark;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
