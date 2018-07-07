package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/22.
 */

public class AllOrderListBean implements Serializable {

//    c_dt	2017-08-21 08:20:53
//    c_user	17c4520f6cfd1ab53d8745e84681eb49
//    id	027160b3e2604aaba97cb96c7c4916b8
//    indentAddress	132
//    indentCode	C000003
//    indentTime	2017-08-21 08:20:53
//    linkMan	adsf
//    payType	3
//    phone	123
//    status	1
//    u_dt	2017-08-21 12:24:33

    /**
     * userId，用户Id
     * indentCode;//订单编码
     * indentTime;//下单日期
     * indentAddress;//订单地址
     * deliveryTime;//配送时间 空为尽快 ，有时间值就按照预约时间点
     * payType;//支付方式  0预付，加油后系统自动从账号中扣除费用；1在线支付押金，加油结束后支付实际油费。
     * estimateCost;//预估费用
     * oilAmount;//加油量，记录所有子订单的加油量
     * realCost;//实际费用，记录所有子订单的加油费用
     * amount;  //剩余额度
     * prepayAmount;//预付金额
     * indentStatus;//订单状态 0未提交，1审核中，2派单中，3司机已接单，4派送中，5已到场，6加油中，7加油完成，8结算完成，9客户已确认，10已完成，11撤单，12审核不通过
     * linkMan;//联系人
     * phone;//联系电话
     * remark;//备注
     */


    private String c_dt;
    private String c_user;
    private String id;
    private String indentAddress;
    private String indentCode;
    private String indentTime;
    private String linkMan;
    /**
     * payType = 0 预付款
     * payType = 1 在线支付
     * payType = 2 货到付款
     * payType = 3 公司转账
     */
    private String payType;
    private String phone;
    private String status;
    private String u_dt;

    public String getC_dt() {
        return c_dt == null ? "" : c_dt;
    }

    public void setC_dt(String c_dt) {
        this.c_dt = c_dt;
    }

    public String getC_user() {
        return c_user == null ? "" : c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndentAddress() {
        return indentAddress == null ? "" : indentAddress;
    }

    public void setIndentAddress(String indentAddress) {
        this.indentAddress = indentAddress;
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

    public String getLinkMan() {
        return linkMan == null ? "" : linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPayType() {
        return payType==null?"":payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPhone() {
        return phone == null ? "" : phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getU_dt() {
        return u_dt == null ? "" : u_dt;
    }

    public void setU_dt(String u_dt) {
        this.u_dt = u_dt;
    }

    @Override
    public String toString() {
        return super.toString() + "AllOrderListBean{" +
                "c_dt='" + c_dt + '\'' +
                ", c_user='" + c_user + '\'' +
                ", id='" + id + '\'' +
                ", indentAddress='" + indentAddress + '\'' +
                ", indentCode='" + indentCode + '\'' +
                ", indentTime='" + indentTime + '\'' +
                ", linkMan='" + linkMan + '\'' +
                ", payType=" + payType +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", u_dt='" + u_dt + '\'' +
                '}';
    }
}
