package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/15.
 */

public class RescheduReqBean implements Serializable {


    /**
     * deliveryId : 000141a568f24591bf5df32689c9b36f
     * userId : beb7537c1eb743648cd1179e6dcde817
     * remark : 我测试下
     */

    private String deliveryId;
    private String userId;
    private String remark;

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
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
