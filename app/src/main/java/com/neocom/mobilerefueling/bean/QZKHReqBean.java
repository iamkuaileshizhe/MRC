package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/31.
 * <p>
 * checkStatus	String	Y	审核状态:
 * 0.未提交;
 * 1.待审核;
 * 2.审核失败;
 * 3.审核成功;
 * roleCode	String	Y	角色code:
 * 0:销售经理(显示自己的)
 * 1:销售主任(显示全部的)
 * nameSim	String	N	客户简称
 * userId	String	N	用户Id(角色为销售主任时,可不传)
 */

public class QZKHReqBean implements Serializable {


    /**
     * checkStatus : 3
     * roleCode : 0
     * nameSim :
     * userId : 3b6ddbe91a7444a3bec1d96bc20f5d29
     */

    private String checkStatus;
    private String roleCode;
    private String nameSim;
    private String userId;

    private String beginNum; // 第几页
    private String endNum; // 显示多少条数据

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getNameSim() {
        return nameSim;
    }

    public void setNameSim(String nameSim) {
        this.nameSim = nameSim;
    }

    @Override
    public String toString() {
        return "QZKHReqBean{" +
                "checkStatus='" + checkStatus + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", nameSim='" + nameSim + '\'' +
                ", userId='" + userId + '\'' +
                ", beginNum='" + beginNum + '\'' +
                ", endNum='" + endNum + '\'' +
                '}';
    }
}
