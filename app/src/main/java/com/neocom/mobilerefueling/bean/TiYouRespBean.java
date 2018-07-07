package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/22.
 */

public class TiYouRespBean extends BaseBean {


    /**
     * bring : {"id":"b92b4f5b69bc45f69075c3e4f662cb59","purchaseCode":"TY201712220008","carCode":"鲁A99910","driver":"于紫阳","telphone":"18953186912","surplusOil":"12","purchaseNum":"14","purchaseTime":"2017-12-22 09:57:10","contractId":"HT000002","batchId":"BATCH000003","oilCode":"有网长安","oilPlace":"舜泰广场","recordStatus":null,"confirmPeople":null,"confirmTime":null,"oilPrice":null,"c_user":"0bfa441e3fc5463b8b49d96c5e0766e6","c_dt":null,"u_user":null,"u_dt":null,"status":"1","remarks":null}
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
         * id : b92b4f5b69bc45f69075c3e4f662cb59
         * purchaseCode : TY201712220008
         * carCode : 鲁A99910
         * driver : 于紫阳
         * telphone : 18953186912
         * surplusOil : 12
         * purchaseNum : 14
         * purchaseTime : 2017-12-22 09:57:10
         * contractId : HT000002
         * batchId : BATCH000003
         * oilCode : 有网长安
         * oilPlace : 舜泰广场
         * recordStatus : null
         * confirmPeople : null
         * confirmTime : null
         * oilPrice : null
         * c_user : 0bfa441e3fc5463b8b49d96c5e0766e6
         * c_dt : null
         * u_user : null
         * u_dt : null
         * status : 1
         * remarks : null
         */

        private String id;
        private String purchaseCode;
        private String carCode;
        private String driver;
        private String telphone;
        private String surplusOil;
        private String purchaseNum;
        private String purchaseTime;
        private String contractId;
        private String batchId;
        private String oilCode;
        private String oilPlace;
        private Object recordStatus;
        private Object confirmPeople;
        private Object confirmTime;
        private Object oilPrice;
        private String c_user;
        private Object c_dt;
        private Object u_user;
        private Object u_dt;
        private String status;
        private Object remarks;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPurchaseCode() {
            return purchaseCode;
        }

        public void setPurchaseCode(String purchaseCode) {
            this.purchaseCode = purchaseCode;
        }

        public String getCarCode() {
            return carCode;
        }

        public void setCarCode(String carCode) {
            this.carCode = carCode;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getSurplusOil() {
            return surplusOil;
        }

        public void setSurplusOil(String surplusOil) {
            this.surplusOil = surplusOil;
        }

        public String getPurchaseNum() {
            return purchaseNum;
        }

        public void setPurchaseNum(String purchaseNum) {
            this.purchaseNum = purchaseNum;
        }

        public String getPurchaseTime() {
            return purchaseTime;
        }

        public void setPurchaseTime(String purchaseTime) {
            this.purchaseTime = purchaseTime;
        }

        public String getContractId() {
            return contractId;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getOilCode() {
            return oilCode;
        }

        public void setOilCode(String oilCode) {
            this.oilCode = oilCode;
        }

        public String getOilPlace() {
            return oilPlace;
        }

        public void setOilPlace(String oilPlace) {
            this.oilPlace = oilPlace;
        }

        public Object getRecordStatus() {
            return recordStatus;
        }

        public void setRecordStatus(Object recordStatus) {
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

        public Object getOilPrice() {
            return oilPrice;
        }

        public void setOilPrice(Object oilPrice) {
            this.oilPrice = oilPrice;
        }

        public String getC_user() {
            return c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public Object getC_dt() {
            return c_dt;
        }

        public void setC_dt(Object c_dt) {
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }
}
