package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/6.
 */

public class ResponseGetOilPageBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * c_dt : 2017-09-06 09:15:17
         * purchaseCode : TY-C2017090601
         * c_user : c43df91e354e4bea934004fdf29e4e6d
         * fileOldName : 20170902135608.txt
         * batchNum : BATCH000001
         * confirmTime :
         * batchId : BATCH000001
         * u_dt : 2017-09-06 10:33:09
         * u_user : c43df91e354e4bea934004fdf29e4e6d
         * confirmPeople :
         * recordStatus : 1
         * carCode : 123
         * driver : cc
         * telphone : 13432343243
         * purchaseTime : 2017-09-06 09:15:21
         * id : 2726edb137444f10b6267a848f8c7ab1
         * purchaseNum : 22
         * remarks : cccc
         * surplusOil : 111
         * status : 1
         * fileId : 5d5fe1e1802a4354a2bad375d8f6df8f
         */

        private String c_dt;
        private String purchaseCode;
        private String c_user;
        private String fileOldName;
        private String batchNum;
        private String confirmTime;
        private String batchId;
        private String u_dt;
        private String u_user;
        private String confirmPeople;
        private String recordStatus;
        private String carCode;
        private String driver;
        private String telphone;
        private String purchaseTime;
        private String id;
        private String purchaseNum;
        private String remarks;
        private String surplusOil;
        private String status;
        private String fileId;

        public String getC_dt() {
            return c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public String getPurchaseCode() {
            return purchaseCode;
        }

        public void setPurchaseCode(String purchaseCode) {
            this.purchaseCode = purchaseCode;
        }

        public String getC_user() {
            return c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getFileOldName() {
            return fileOldName;
        }

        public void setFileOldName(String fileOldName) {
            this.fileOldName = fileOldName;
        }

        public String getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(String batchNum) {
            this.batchNum = batchNum;
        }

        public String getConfirmTime() {
            return confirmTime;
        }

        public void setConfirmTime(String confirmTime) {
            this.confirmTime = confirmTime;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getConfirmPeople() {
            return confirmPeople;
        }

        public void setConfirmPeople(String confirmPeople) {
            this.confirmPeople = confirmPeople;
        }

        public String getRecordStatus() {
            return recordStatus;
        }

        public void setRecordStatus(String recordStatus) {
            this.recordStatus = recordStatus;
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

        public String getPurchaseTime() {
            return purchaseTime;
        }

        public void setPurchaseTime(String purchaseTime) {
            this.purchaseTime = purchaseTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPurchaseNum() {
            return purchaseNum;
        }

        public void setPurchaseNum(String purchaseNum) {
            this.purchaseNum = purchaseNum;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getSurplusOil() {
            return surplusOil;
        }

        public void setSurplusOil(String surplusOil) {
            this.surplusOil = surplusOil;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        @Override
        public String toString() {
            return "BringBean{" +
                    "c_dt='" + c_dt + '\'' +
                    ", purchaseCode='" + purchaseCode + '\'' +
                    ", c_user='" + c_user + '\'' +
                    ", fileOldName='" + fileOldName + '\'' +
                    ", batchNum='" + batchNum + '\'' +
                    ", confirmTime='" + confirmTime + '\'' +
                    ", batchId='" + batchId + '\'' +
                    ", u_dt='" + u_dt + '\'' +
                    ", u_user='" + u_user + '\'' +
                    ", confirmPeople='" + confirmPeople + '\'' +
                    ", recordStatus='" + recordStatus + '\'' +
                    ", carCode='" + carCode + '\'' +
                    ", driver='" + driver + '\'' +
                    ", telphone='" + telphone + '\'' +
                    ", purchaseTime='" + purchaseTime + '\'' +
                    ", id='" + id + '\'' +
                    ", purchaseNum='" + purchaseNum + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", surplusOil='" + surplusOil + '\'' +
                    ", status='" + status + '\'' +
                    ", fileId='" + fileId + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseGetOilPageBean{" +
                "bring=" + bring +
                '}';
    }
}
