package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/13.
 */

public class HeTongResBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
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
         * supplyId : null
         * supplyName : 231
         * supplyTel : 23123
         * buyTime : 2017-11-04
         * buyer : 231231
         * buyerTel : 2312
         * remark : 3123123
         * createId : 17c4520f6cfd1ab53d8745e84681eb49
         * createTime : null
         * updateId : null
         * updateTime : null
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
        private Object fuelCode;
        private String nationalStandard;
        private Object fuelPosition;
        private String fuelTotal;
        private String fuelDone;
        private String batchStatus;
        private String price;
        private String payStatus;
        private Object supplyId;
        private String supplyName;
        private String supplyTel;
        private String buyTime;
        private String buyer;
        private String buyerTel;
        private String remark;
        private String createId;
        private Object createTime;
        private Object updateId;
        private Object updateTime;
        private Object status;
        private Object fileName;
        private Object createName;
        private Object updateName;
        private String fuelModelName;
        private Object fileList;

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

        public Object getFuelCode() {
            return fuelCode;
        }

        public void setFuelCode(Object fuelCode) {
            this.fuelCode = fuelCode;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public Object getFuelPosition() {
            return fuelPosition;
        }

        public void setFuelPosition(Object fuelPosition) {
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

        public Object getSupplyId() {
            return supplyId;
        }

        public void setSupplyId(Object supplyId) {
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

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateId() {
            return updateId;
        }

        public void setUpdateId(Object updateId) {
            this.updateId = updateId;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getFileName() {
            return fileName;
        }

        public void setFileName(Object fileName) {
            this.fileName = fileName;
        }

        public Object getCreateName() {
            return createName;
        }

        public void setCreateName(Object createName) {
            this.createName = createName;
        }

        public Object getUpdateName() {
            return updateName;
        }

        public void setUpdateName(Object updateName) {
            this.updateName = updateName;
        }

        public String getFuelModelName() {
            return fuelModelName;
        }

        public void setFuelModelName(String fuelModelName) {
            this.fuelModelName = fuelModelName;
        }

        public Object getFileList() {
            return fileList;
        }

        public void setFileList(Object fileList) {
            this.fileList = fileList;
        }
    }
}
