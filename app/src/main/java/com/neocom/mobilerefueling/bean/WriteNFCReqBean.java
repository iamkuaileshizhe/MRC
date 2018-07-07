package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/29.
 */

public class WriteNFCReqBean implements Serializable {


    /**
     * NFCId : 测试Id
     * userId : 917f2f6eb1ce42a5968ee3a76bcf07c9
     * carType : 1
     * carCode : 鲁A123456
     */

    private String NFCId;
    private String userId;
    private String carType;
    private String carCode;

    public String getNFCId() {
        return NFCId;
    }

    public void setNFCId(String NFCId) {
        this.NFCId = NFCId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    @Override
    public String toString() {
        return "WriteNFCReqBean{" +
                "NFCId='" + NFCId + '\'' +
                ", userId='" + userId + '\'' +
                ", carType='" + carType + '\'' +
                ", carCode='" + carCode + '\'' +
                '}';
    }
}
