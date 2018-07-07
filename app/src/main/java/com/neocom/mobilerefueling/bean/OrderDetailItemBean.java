package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/8/22.
 */

public class OrderDetailItemBean extends BaseBean {


//    "id" : "e7140e86139f4c368871ebaf32d2247b",
//            "indentCode" : "C000002",
//            "indentTime" : "2017-08-21 08:10:04",
//            "indentAddress" : "哈哈哈",
//            "deliveryTime" : null,
//            "payType" : "2",
//            "estimateCost" : null,
//            "oilAmount" : null,
//            "realCost" : null,
//            "amount" : null,
//            "prepayAmount" : null,
//            "indentStatus" : null,
//            "linkMan" : "测试2",
//            "phone" : "123",
//            "remark" : null,
//            "status" : "1",
//            "c_user" : "17c4520f6cfd1ab53d8745e84681eb49",
//            "c_dt" : "2017-08-21 08:10:04",
//            "u_user" : null,
//            "u_dt" : "2017-08-21 11:04:58"


    private String id;
    private String indentCode;
    private String indentTime;
    private String indentAddress;
    private String deliveryTime;
    private String payType;
    private String estimateCost;
    private String oilAmount;
    private String realCost;
    private String amount;
    private String prepayAmount;
    private String indentStatus;
    private String linkMan;
    private String phone;
    private String remark;
    private String status;
    private String c_user;
    private String c_dt;
    private String u_user;
    private String u_dt;


    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndentCode() {
        return indentCode == null ? "" : indentCode;
    }

    public void setIndentCode(String indentCode) {
        this.indentCode = indentCode;
    }

    public String getIndentTime() {
        return indentTime == null ? "" : indentTime;
    }

    public void setIndentTime(String indentTime) {
        this.indentTime = indentTime;
    }

    public String getIndentAddress() {
        return indentAddress == null ? "" : indentAddress;
    }

    public void setIndentAddress(String indentAddress) {
        this.indentAddress = indentAddress;
    }

    public String getDeliveryTime() {
        return deliveryTime == null ? "" : deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPayType() {
        return payType == null ? "" : payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getEstimateCost() {
        return estimateCost == null ? "" : estimateCost;
    }

    public void setEstimateCost(String estimateCost) {
        this.estimateCost = estimateCost;
    }

    public String getOilAmount() {
        return oilAmount == null ? "" : oilAmount;
    }

    public void setOilAmount(String oilAmount) {
        this.oilAmount = oilAmount;
    }

    public String getRealCost() {
        return realCost == null ? "" : realCost;
    }

    public void setRealCost(String realCost) {
        this.realCost = realCost;
    }

    public String getAmount() {
        return amount == null ? "" : amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrepayAmount() {
        return prepayAmount == null ? "" : prepayAmount;
    }

    public void setPrepayAmount(String prepayAmount) {
        this.prepayAmount = prepayAmount;
    }

    public String getIndentStatus() {
        return indentStatus == null ? "" : indentStatus;
    }

    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getLinkMan() {
        return linkMan == null ? "" : linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone == null ? "" : phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_user() {
        return c_user == null ? "" : c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }

    public String getC_dt() {
        return c_dt == null ? "" : c_dt;
    }

    public void setC_dt(String c_dt) {
        this.c_dt = c_dt;
    }

    public String getU_user() {
        return u_user == null ? "" : u_user;
    }

    public void setU_user(String u_user) {
        this.u_user = u_user;
    }

    public String getU_dt() {
        return u_dt == null ? "" : u_dt;
    }

    public void setU_dt(String u_dt) {
        this.u_dt = u_dt;
    }


    @Override
    public String toString() {
        return "OrderDetailItemBean{" +
                "id='" + id + '\'' +
                ", indentCode='" + indentCode + '\'' +
                ", indentTime='" + indentTime + '\'' +
                ", indentAddress='" + indentAddress + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", payType='" + payType + '\'' +
                ", estimateCost='" + estimateCost + '\'' +
                ", oilAmount='" + oilAmount + '\'' +
                ", realCost='" + realCost + '\'' +
                ", amount='" + amount + '\'' +
                ", prepayAmount='" + prepayAmount + '\'' +
                ", indentStatus='" + indentStatus + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", c_user='" + c_user + '\'' +
                ", c_dt='" + c_dt + '\'' +
                ", u_user='" + u_user + '\'' +
                ", u_dt='" + u_dt + '\'' +
                '}';
    }
}
