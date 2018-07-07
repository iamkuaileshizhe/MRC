package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2018/1/8.
 */

public class PaiSongDanOilPriceReqBean implements Serializable {


    /**
     * oilType : 3
     * area : 620000
     * nationalStandard : 1
     * userId : faac2e7c12294911b79303c71a4e22fd1
     */

    private String oilType;
    private String area;
    private String nationalStandard;
    private String userId;

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(String nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
