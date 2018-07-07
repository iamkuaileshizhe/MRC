package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/24.
 * 请求执行价格的 列表
 */

public class UserIdReqBean {

    /**
     * userId : faac2e7c12294911b79303c71a4e22fd
     */

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserIdReqOil{" +
                "userId='" + userId + '\'' +
                '}';
    }


}
