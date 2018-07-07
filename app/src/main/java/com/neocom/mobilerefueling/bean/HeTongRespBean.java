package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/11/13.
 */

public class HeTongRespBean extends BaseBean {


    /**
     * bring : {"id":"838391cb670d4c03bb7813e9a0458283","batchNum":"HT000002","contractNum":"测试合同","fuelModel":"3","fuelCode":null,"nationalStandard":"国三","fuelPosition":null,"fuelTotal":"123","fuelDone":"723","batchStatus":"未完成提油","price":"12312","payStatus":"已付款","supplyId":"c4c8c4338cc44ee9ac4d4ab9af2449ac","supplyName":"231","supplyTel":"23123","buyTime":"2017-11-04","buyer":"231231","buyerTel":"2312","remark":"3123123","createId":null,"createTime":"2017-11-03 10:14:27","updateId":null,"updateTime":"2017-11-10 10:58:17","status":null,"fileName":null,"createName":null,"updateName":null,"fuelModelName":"-10号柴油","fileList":null}
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
         * id : 838391cb670d4c03bb7813e9a0458283
         * batchNum : HT000002
         * contractNum : 测试合同
         * fuelModel : 3
         * fuelCode : null
         * nationalStandard : 国三
         * fuelPosition : null
         * fuelTotal : 123
         * fuelDone : 723
         * batchStatus : 未完成提油
         * price : 12312
         * payStatus : 已付款
         * supplyId : c4c8c4338cc44ee9ac4d4ab9af2449ac
         * supplyName : 231
         * supplyTel : 23123
         * buyTime : 2017-11-04
         * buyer : 231231
         * buyerTel : 2312
         * remark : 3123123
         * createId : null
         * createTime : 2017-11-03 10:14:27
         * updateId : null
         * updateTime : 2017-11-10 10:58:17
         * status : null
         * fileName : null
         * createName : null
         * updateName : null
         * fuelModelName : -10号柴油
         * fileList : null
         */

        private String id;
        private String batchNum;
        private String contractNum;
        private String fuelModel;
        private String fuelCode;
        private String nationalStandard;
        private String fuelPosition;
        private String fuelTotal;
        private String fuelDone;
        private String batchStatus;
        private String price;
        private String payStatus;
        private String supplyId;
        private String supplyName;
        private String supplyTel;
        private String buyTime;
        private String buyer;
        private String buyerTel;
        private String remark;
        private String createId;
        private String createTime;
        private String updateId;
        private String updateTime;
        private String status;
        private String fileName;
        private String createName;
        private String updateName;
        private String fuelModelName;
        private String fileList;
        private String supplyCusName;

        public String getSupplyCusName() {
            return supplyCusName;
        }

        public void setSupplyCusName(String supplyCusName) {
            this.supplyCusName = supplyCusName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(String batchNum) {
            this.batchNum = batchNum;
        }

        public String getContractNum() {
            return contractNum;
        }

        public void setContractNum(String contractNum) {
            this.contractNum = contractNum;
        }

        public String getFuelModel() {
            return fuelModel;
        }

        public void setFuelModel(String fuelModel) {
            this.fuelModel = fuelModel;
        }

        public String getFuelCode() {
            return fuelCode;
        }

        public void setFuelCode(String fuelCode) {
            this.fuelCode = fuelCode;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getFuelPosition() {
            return fuelPosition;
        }

        public void setFuelPosition(String fuelPosition) {
            this.fuelPosition = fuelPosition;
        }

        public String getFuelTotal() {
            return fuelTotal;
        }

        public void setFuelTotal(String fuelTotal) {
            this.fuelTotal = fuelTotal;
        }

        public String getFuelDone() {
            return fuelDone;
        }

        public void setFuelDone(String fuelDone) {
            this.fuelDone = fuelDone;
        }

        public String getBatchStatus() {
            return batchStatus;
        }

        public void setBatchStatus(String batchStatus) {
            this.batchStatus = batchStatus;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

        public String getSupplyId() {
            return supplyId;
        }

        public void setSupplyId(String supplyId) {
            this.supplyId = supplyId;
        }

        public String getSupplyName() {
            return supplyName;
        }

        public void setSupplyName(String supplyName) {
            this.supplyName = supplyName;
        }

        public String getSupplyTel() {
            return supplyTel;
        }

        public void setSupplyTel(String supplyTel) {
            this.supplyTel = supplyTel;
        }

        public String getBuyTime() {
            return buyTime;
        }

        public void setBuyTime(String buyTime) {
            this.buyTime = buyTime;
        }

        public String getBuyer() {
            return buyer;
        }

        public void setBuyer(String buyer) {
            this.buyer = buyer;
        }

        public String getBuyerTel() {
            return buyerTel;
        }

        public void setBuyerTel(String buyerTel) {
            this.buyerTel = buyerTel;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreateId() {
            return createId;
        }

        public void setCreateId(String createId) {
            this.createId = createId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateId() {
            return updateId;
        }

        public void setUpdateId(String updateId) {
            this.updateId = updateId;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public String getFuelModelName() {
            return fuelModelName;
        }

        public void setFuelModelName(String fuelModelName) {
            this.fuelModelName = fuelModelName;
        }

        public String getFileList() {
            return fileList;
        }

        public void setFileList(String fileList) {
            this.fileList = fileList;
        }
    }
}
