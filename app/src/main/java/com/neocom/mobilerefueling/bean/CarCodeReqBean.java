package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/2.
 */

public class CarCodeReqBean implements Serializable {

    private String carCode;

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }
}
