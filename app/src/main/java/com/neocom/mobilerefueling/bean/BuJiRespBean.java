package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/22.
 */

public class BuJiRespBean extends BaseBean {


    /**
     * bring : {"id":"653caf88d34d4090a27a0a09678d9d33","supplyCode":"BJ201712220002","supplyCarCode":"鲁A99910","supplyCarDriver":null,"supplyCarTelphone":null,"moveCarCode":null,"moveCarDriver":"于紫阳","moveCarTelphone":"18953186912","surplusOil":"18","supplyNum":"20","supplyTime":"30","supplyAddress":"1515","batchId":"BATCH000002","recordStatus":"0","confirmPeople":null,"confirmTime":null,"sendFlag":null,"oldId":null,"c_user":"0bfa441e3fc5463b8b49d96c5e0766e6","c_dt":"2017-12-22 12:57:11 ","u_user":null,"u_dt":null,"remarks":"不急","status":"1"}
     */

    private BringBean bring;

    public BringBean getBring() {
        return bring;
    }

    public void setBring(BringBean bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 653caf88d34d4090a27a0a09678d9d33
         * supplyCode : BJ201712220002
         * supplyCarCode : 鲁A99910
         * supplyCarDriver : null
         * supplyCarTelphone : null
         * moveCarCode : null
         * moveCarDriver : 于紫阳
         * moveCarTelphone : 18953186912
         * surplusOil : 18
         * supplyNum : 20
         * supplyTime : 30
         * supplyAddress : 1515
         * batchId : BATCH000002
         * recordStatus : 0
         * confirmPeople : null
         * confirmTime : null
         * sendFlag : null
         * oldId : null
         * c_user : 0bfa441e3fc5463b8b49d96c5e0766e6
         * c_dt : 2017-12-22 12:57:11
         * u_user : null
         * u_dt : null
         * remarks : 不急
         * status : 1
         */

        private String id;
        private String supplyCode;
        private String supplyCarCode;
        private Object supplyCarDriver;
        private Object supplyCarTelphone;
        private Object moveCarCode;
        private String moveCarDriver;
        private String moveCarTelphone;
        private String surplusOil;
        private String supplyNum;
        private String supplyTime;
        private String supplyAddress;
        private String batchId;
        private String recordStatus;
        private Object confirmPeople;
        private Object confirmTime;
        private Object sendFlag;
        private Object oldId;
        private String c_user;
        private String c_dt;
        private Object u_user;
        private Object u_dt;
        private String remarks;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSupplyCode() {
            return supplyCode;
        }

        public void setSupplyCode(String supplyCode) {
            this.supplyCode = supplyCode;
        }

        public String getSupplyCarCode() {
            return supplyCarCode;
        }

        public void setSupplyCarCode(String supplyCarCode) {
            this.supplyCarCode = supplyCarCode;
        }

        public Object getSupplyCarDriver() {
            return supplyCarDriver;
        }

        public void setSupplyCarDriver(Object supplyCarDriver) {
            this.supplyCarDriver = supplyCarDriver;
        }

        public Object getSupplyCarTelphone() {
            return supplyCarTelphone;
        }

        public void setSupplyCarTelphone(Object supplyCarTelphone) {
            this.supplyCarTelphone = supplyCarTelphone;
        }

        public Object getMoveCarCode() {
            return moveCarCode;
        }

        public void setMoveCarCode(Object moveCarCode) {
            this.moveCarCode = moveCarCode;
        }

        public String getMoveCarDriver() {
            return moveCarDriver;
        }

        public void setMoveCarDriver(String moveCarDriver) {
            this.moveCarDriver = moveCarDriver;
        }

        public String getMoveCarTelphone() {
            return moveCarTelphone;
        }

        public void setMoveCarTelphone(String moveCarTelphone) {
            this.moveCarTelphone = moveCarTelphone;
        }

        public String getSurplusOil() {
            return surplusOil;
        }

        public void setSurplusOil(String surplusOil) {
            this.surplusOil = surplusOil;
        }

        public String getSupplyNum() {
            return supplyNum;
        }

        public void setSupplyNum(String supplyNum) {
            this.supplyNum = supplyNum;
        }

        public String getSupplyTime() {
            return supplyTime;
        }

        public void setSupplyTime(String supplyTime) {
            this.supplyTime = supplyTime;
        }

        public String getSupplyAddress() {
            return supplyAddress;
        }

        public void setSupplyAddress(String supplyAddress) {
            this.supplyAddress = supplyAddress;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getRecordStatus() {
            return recordStatus;
        }

        public void setRecordStatus(String recordStatus) {
            this.recordStatus = recordStatus;
        }

        public Object getConfirmPeople() {
            return confirmPeople;
        }

        public void setConfirmPeople(Object confirmPeople) {
            this.confirmPeople = confirmPeople;
        }

        public Object getConfirmTime() {
            return confirmTime;
        }

        public void setConfirmTime(Object confirmTime) {
            this.confirmTime = confirmTime;
        }

        public Object getSendFlag() {
            return sendFlag;
        }

        public void setSendFlag(Object sendFlag) {
            this.sendFlag = sendFlag;
        }

        public Object getOldId() {
            return oldId;
        }

        public void setOldId(Object oldId) {
            this.oldId = oldId;
        }

        public String getC_user() {
            return c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getC_dt() {
            return c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public Object getU_user() {
            return u_user;
        }

        public void setU_user(Object u_user) {
            this.u_user = u_user;
        }

        public Object getU_dt() {
            return u_dt;
        }

        public void setU_dt(Object u_dt) {
            this.u_dt = u_dt;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
