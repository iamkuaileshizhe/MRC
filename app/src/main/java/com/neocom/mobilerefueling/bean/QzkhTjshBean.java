package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/3.
 * <p>
 * 潜在客户 提交审核
 */

public class QzkhTjshBean implements Serializable {


    /**
     * userId : 3b6ddbe91a7444a3bec1d96bc20f5d29
     * customerId : 55495a0d5942405099f86033e7266d4d
     */

    private String userId;
    private String customerId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
