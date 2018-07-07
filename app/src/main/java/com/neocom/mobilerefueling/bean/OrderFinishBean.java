package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/30.
 */

public class OrderFinishBean implements Serializable {

    private String carNum;
    private String oilCount;


    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getOilCount() {
        return oilCount;
    }

    public void setOilCount(String oilCount) {
        this.oilCount = oilCount;
    }


    @Override
    public String toString() {
        return "OrderFinishBean{" +
                "carNum='" + carNum + '\'' +
                ", oilCount='" + oilCount + '\'' +
                '}';
    }
}
