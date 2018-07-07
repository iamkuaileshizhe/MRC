package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by xyz on 2017/12/31.
 */

public class GetCarInfoReqBean implements Serializable {


    private String code;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GetCarInfoReqBean{" +
                "code='" + code + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    //    /**
//     * carNum : 京H12345
//     * deliveryCode : D000145
//     */
//
//    private String carNum;
//    private String deliveryCode;
//
//    public String getCarNum() {
//        return carNum;
//    }
//
//    public void setCarNum(String carNum) {
//        this.carNum = carNum;
//    }
//
//    public String getDeliveryCode() {
//        return deliveryCode;
//    }
//
//    public void setDeliveryCode(String deliveryCode) {
//        this.deliveryCode = deliveryCode;
//    }
//
//    @Override
//    public String toString() {
//        return "GetCarInfoReqBean{" +
//                "carNum='" + carNum + '\'' +
//                ", deliveryCode='" + deliveryCode + '\'' +
//                '}';
//    }
}
