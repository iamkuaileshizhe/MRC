package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/16.
 */

public class SubmitOrderOilsBean implements Serializable {


    /**
     * oilPrice : 20
     * oilType : 1
     * amount : 20
     */

    private String oilPrice;
    private String oilType;
    private String amount;

    public String getOilPrice() {
        return oilPrice;
    }

    public void setOilPrice(String oilPrice) {
        this.oilPrice = oilPrice;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SubmitOrderOilsBean{" +
                "oilPrice='" + oilPrice + '\'' +
                ", oilType='" + oilType + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
