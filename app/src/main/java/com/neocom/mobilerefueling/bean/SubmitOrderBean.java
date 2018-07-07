package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/10/16.
 */

public class SubmitOrderBean implements Serializable {


    /**
     * userId : 917f2f6eb1ce42a5968ee3a76bcf07c9
     * indentAddress : 2017-8-28下午测试新增2
     * addressCode : 370000;371700;371721
     * payType : 1
     * linkMan : 冯七
     * phone : 13666666666666
     * remark : 1000
     * haveInv : 1
     * invMess : {"invoiceType":"1","invtelphone":"123","invoiceName":"小明","invAddress":"山东济南","companyName":"中国地铁"}
     * oils : [{"oilPrice":"20","oilType":"1","amount":"20"},{"oilPrice":"60","oilType":"6","amount":"20"}]
     */

    private String userId;
    private String indentAddress;
    private String addressCode;
//    private String payType;
    private String linkMan;
    private String phone;
    private String remark;
    private String haveInv;
    private TicketSubmitBean invMess;
    private List<SubmitOrderOilsBean> oils;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIndentAddress() {
        return indentAddress;
    }

    public void setIndentAddress(String indentAddress) {
        this.indentAddress = indentAddress;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

//    public String getPayType() {
//        return payType;
//    }
//
//    public void setPayType(String payType) {
//        this.payType = payType;
//    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHaveInv() {
        return haveInv;
    }

    public void setHaveInv(String haveInv) {
        this.haveInv = haveInv;
    }

    public TicketSubmitBean getInvMess() {
        return invMess;
    }

    public void setInvMess(TicketSubmitBean invMess) {
        this.invMess = invMess;
    }

    public List<SubmitOrderOilsBean> getOils() {
        return oils;
    }

    public void setOils(List<SubmitOrderOilsBean> oils) {
        this.oils = oils;
    }

    @Override
    public String toString() {
        return "SubmitOrderBean{" +
                "userId='" + userId + '\'' +
                ", indentAddress='" + indentAddress + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", haveInv='" + haveInv + '\'' +
                ", invMess=" + invMess +
                ", oils=" + oils +
                '}';
    }
}
