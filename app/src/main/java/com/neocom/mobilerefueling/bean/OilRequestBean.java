package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/15.
 */

public class OilRequestBean implements Serializable {


    /**
     * oilType : 3
     * area : 620000
     * nationalStandard : 1
     * time :
     */

    private String oilType;
    private String area;
    private String nationalStandard;
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OilRequestBean{" +
                "oilType='" + oilType + '\'' +
                ", area='" + area + '\'' +
                ", nationalStandard='" + nationalStandard + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
