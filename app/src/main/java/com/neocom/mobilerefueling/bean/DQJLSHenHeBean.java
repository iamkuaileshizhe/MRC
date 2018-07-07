package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/6.
 * <p>
 * 地区经理 审核 Bean
 */

public class DQJLSHenHeBean implements Serializable {


    /**
     * id : 42026a34eb9042648341394b438a5071
     * isPassed : 1
     * userId : 086834ed141c46a9a255b6cf1766cd3a
     * roleCode : 2
     */

    private String customerId;
    private String isPassed;
    private String userId;
    private String roleCode;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(String isPassed) {
        this.isPassed = isPassed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
