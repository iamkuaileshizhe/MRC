package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/13.
 */

public class ResponseDingDanOrderBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : d1efa211cac440f0856c7fabfb5baffe
         * indentCode : C000013
         * indentTime : 2017-08-24 09:08:38
         * indentAddress : 山东0详细地址0
         * deliveryTime : 2017-08-24 09:08:38
         * payType : 1
         * estimateCost : 100
         * oilAmount : 20
         * realCost : 100
         * amount : 100
         * prepayAmount : 100
         * indentStatus : 0
         * delStatus : null
         * evaStatus : null
         * linkMan : 张三0
         * phone : 电话0
         * remark : 我是备注的
         * status : 1
         * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
         * c_dt : 2017-08-24 09:08:38
         * u_user :
         * u_dt :
         * orderStatus : 未提交
         */

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
        private String delStatus;
        private String evaStatus;
        private String linkMan;
        private String phone;
        private String remark;
        private String status;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private String orderStatus;

        public String getId() {
            return id==null?"":id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIndentCode() {
            return indentCode==null?"":indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getIndentTime() {
            return indentTime==null?"":indentTime;
        }

        public void setIndentTime(String indentTime) {
            this.indentTime = indentTime;
        }

        public String getIndentAddress() {
            return indentAddress==null?"":indentAddress;
        }

        public void setIndentAddress(String indentAddress) {
            this.indentAddress = indentAddress;
        }

        public String getDeliveryTime() {
            return deliveryTime==null?"":deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getPayType() {
            return payType==null?"":payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getEstimateCost() {
            return estimateCost==null?"":estimateCost;
        }

        public void setEstimateCost(String estimateCost) {
            this.estimateCost = estimateCost;
        }

        public String getOilAmount() {
            return oilAmount==null?"":oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getRealCost() {
            return realCost==null?"":realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getAmount() {
            return amount==null?"":amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPrepayAmount() {
            return prepayAmount==null?"":prepayAmount;
        }

        public void setPrepayAmount(String prepayAmount) {
            this.prepayAmount = prepayAmount;
        }

        public String getIndentStatus() {
            return indentStatus==null?"":indentStatus;
        }

        public void setIndentStatus(String indentStatus) {
            this.indentStatus = indentStatus;
        }

        public String getDelStatus() {
            return delStatus==null?"":delStatus;
        }

        public void setDelStatus(String delStatus) {
            this.delStatus = delStatus;
        }

        public String getEvaStatus() {
            return evaStatus==null?"":evaStatus;
        }

        public void setEvaStatus(String evaStatus) {
            this.evaStatus = evaStatus;
        }

        public String getLinkMan() {
            return linkMan==null?"":linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public String getPhone() {
            return phone==null?"":phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRemark() {
            return remark==null?"":remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status==null?"":status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getC_user() {
            return c_user==null?"":c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getC_dt() {
            return c_dt==null?"":c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public String getU_user() {
            return u_user==null?"":u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getU_dt() {
            return u_dt==null?"":u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getOrderStatus() {
            return orderStatus==null?"":orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        @Override
        public String toString() {
            return "BringBean{" +
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
                    ", delStatus=" + delStatus +
                    ", evaStatus=" + evaStatus +
                    ", linkMan='" + linkMan + '\'' +
                    ", phone='" + phone + '\'' +
                    ", remark='" + remark + '\'' +
                    ", status='" + status + '\'' +
                    ", c_user='" + c_user + '\'' +
                    ", c_dt='" + c_dt + '\'' +
                    ", u_user='" + u_user + '\'' +
                    ", u_dt='" + u_dt + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseDingDanOrderBean{" +
                "bring=" + bring +
                '}';
    }
}
