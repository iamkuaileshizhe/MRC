package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/11.
 */

public class SubmintAddressBean implements Serializable {


    /**
     * id : 60c3ff8f52144f84a0af23faf671abe5
     * userId : 917f2f6eb1ce42a5968ee3a76bcf07c9
     * openType : update
     * province : 哈哈哈
     * city : 测试城市
     * region : 测试区
     * towns : 测试乡镇
     * area : 详细地址
     * cname : 测试别名
     * pname : 小张
     * telphone : 123456
     * isDefault : 1
     */

    private String id;
    private String userId;
    private String openType;
    private String province;
    private String city;
    private String region;
    private String towns;
    private String area;
    private String cname;
    private String pname;
    private String telphone;
    private String isDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTowns() {
        return towns;
    }

    public void setTowns(String towns) {
        this.towns = towns;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
