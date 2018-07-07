package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

public class JieSuanRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"deliveryCode":"D20171224000010","estimateTime":null,"deliveryName":null,"u_dt":null,"dstate":"0","id":"31b92e85e477477592fe743252f3ddfe","confirmTime":null,"oilAmount":null,"driverId":"37758be815e3446cba39cdd831f64157","indentCode":"ORDER20171222000001","finishTime":null,"senderPhone":"15111111235","nationalStandardName":"国五","driverName":"陈近南","c_dt":"2017-12-24 17:18:46","oilTypeName":"5号柴油","payAmount":null,"nationalStandard":"4","oilCarId":"54a6ecf5f9a644c292969e8b1581c18e","status":"1","oilType":"1","oilCost":"7.43","deliveryId":null,"senderName":"陈近南","receiveTime":null,"indentId":"a16d547ef08d41f5b81bea9fd8728380","payType":null,"dstateName":"派单中","deliveryAddress":"山东省济南市市辖区历下区齐鲁软件园","u_user":null}
     */


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }


    //    private BringBean bring;
//
//    public BringBean getBring() {
//        return bring;
//    }

//    public void setBring(BringBean bring) {
//        this.bring = bring;
//    }

    public static class BringBean {
        /**
         * deliveryCode : D20171224000010
         * estimateTime : null
         * deliveryName : null
         * u_dt : null
         * dstate : 0
         * id : 31b92e85e477477592fe743252f3ddfe
         * confirmTime : null
         * oilAmount : null
         * driverId : 37758be815e3446cba39cdd831f64157
         * indentCode : ORDER20171222000001
         * finishTime : null
         * senderPhone : 15111111235
         * nationalStandardName : 国五
         * driverName : 陈近南
         * c_dt : 2017-12-24 17:18:46
         * oilTypeName : 5号柴油
         * payAmount : null
         * nationalStandard : 4
         * oilCarId : 54a6ecf5f9a644c292969e8b1581c18e
         * status : 1
         * oilType : 1
         * oilCost : 7.43
         * deliveryId : null
         * senderName : 陈近南
         * receiveTime : null
         * indentId : a16d547ef08d41f5b81bea9fd8728380
         * payType : null
         * dstateName : 派单中
         * deliveryAddress : 山东省济南市市辖区历下区齐鲁软件园
         * u_user : null
         */

        private String deliveryCode;
        private String estimateTime;
        private String deliveryName;
        private String u_dt;
        private String dstate;
        private String id;
        private String confirmTime;
        private String oilAmount;
        private String driverId;
        private String indentCode;
        private String finishTime;
        private String senderPhone;
        private String nationalStandardName;
        private String driverName;
        private String c_dt;
        private String oilTypeName;
        private String payAmount;
        private String nationalStandard;
        private String oilCarId;
        private String status;
        private String oilType;
        private String oilCost;
        private String deliveryId;
        private String senderName;
        private String receiveTime;
        private String indentId;
        private String payType;
        private String dstateName;
        private String deliveryAddress;
        private String u_user;

        public String getDeliveryCode() {
            return deliveryCode;
        }

        public void setDeliveryCode(String deliveryCode) {
            this.deliveryCode = deliveryCode;
        }

        public String getEstimateTime() {
            return estimateTime;
        }

        public void setEstimateTime(String estimateTime) {
            this.estimateTime = estimateTime;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        public void setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getDstate() {
            return dstate;
        }

        public void setDstate(String dstate) {
            this.dstate = dstate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getConfirmTime() {
            return confirmTime;
        }

        public void setConfirmTime(String confirmTime) {
            this.confirmTime = confirmTime;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getIndentCode() {
            return indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public String getSenderPhone() {
            return senderPhone;
        }

        public void setSenderPhone(String senderPhone) {
            this.senderPhone = senderPhone;
        }

        public String getNationalStandardName() {
            return nationalStandardName;
        }

        public void setNationalStandardName(String nationalStandardName) {
            this.nationalStandardName = nationalStandardName;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getC_dt() {
            return c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getOilCarId() {
            return oilCarId;
        }

        public void setOilCarId(String oilCarId) {
            this.oilCarId = oilCarId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getOilCost() {
            return oilCost;
        }

        public void setOilCost(String oilCost) {
            this.oilCost = oilCost;
        }

        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getDstateName() {
            return dstateName;
        }

        public void setDstateName(String dstateName) {
            this.dstateName = dstateName;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }
    }
}
