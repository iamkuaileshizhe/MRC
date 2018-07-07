package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/10.
 */

public class CheLiangRespBean implements Serializable {


    /**
     * purl : properties/code.properties
     * res : true
     * code : null
     * message :

     * bring : [{"id":"038446c9d3ca4653b003f6c4737b94cc","seqCode":"VEH201801170004","carNum":"青A99912","frameNum":"","model":"","leaveDate":"","fuelType":"","tankSize":"","carType":"0","carTypeName":null,"buyPrice":"","buyPlace":"","buyDate":"","review":"","driverOne":null,"driverTwo":null,"belong":null,"remark":"","createId":null,"createTime":null,"updateId":null,"updateTime":null,"status":null,"belongName":null,"leaveOil":null},{"id":"1c13dbb8b3c4407ea37a1b347267ebfc","seqCode":"VEH201801050003","carNum":"青A92351","frameNum":"","model":"","leaveDate":"","fuelType":"0","tankSize":"","carType":"0","carTypeName":null,"buyPrice":"","buyPlace":"","buyDate":"","review":"","driverOne":null,"driverTwo":null,"belong":"0801867185a741ae9411056abcfe623f","remark":"","createId":null,"createTime":null,"updateId":null,"updateTime":null,"status":null,"belongName":null,"leaveOil":null}]
     */

    private String purl;
    private boolean res;
    private String code;
    private String message;
    private List<BringBean> bring;

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 038446c9d3ca4653b003f6c4737b94cc
         * seqCode : VEH201801170004
         * carNum : 青A99912
         * frameNum :
         * model :
         * leaveDate :
         * fuelType :
         * tankSize :
         * carType : 0
         * carTypeName : null
         * buyPrice :
         * buyPlace :
         * buyDate :
         * review :
         * driverOne : null
         * driverTwo : null
         * belong : null
         * remark :
         * createId : null
         * createTime : null
         * updateId : null
         * updateTime : null
         * status : null
         * belongName : null
         * leaveOil : null
         */

        private String id;
        private String seqCode;
        private String carNum;
        private String frameNum;
        private String model;
        private String leaveDate;
        private String fuelType;
        private String tankSize;
        private String carType;
        private String carTypeName;
        private String buyPrice;
        private String buyPlace;
        private String buyDate;
        private String review;
        private String driverOne;
        private String driverTwo;
        private String belong;
        private String remark;
        private String createId;
        private String createTime;
        private String updateId;
        private String updateTime;
        private String status;
        private String belongName;
        private String leaveOil;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSeqCode() {
            return seqCode;
        }

        public void setSeqCode(String seqCode) {
            this.seqCode = seqCode;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getFrameNum() {
            return frameNum;
        }

        public void setFrameNum(String frameNum) {
            this.frameNum = frameNum;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getLeaveDate() {
            return leaveDate;
        }

        public void setLeaveDate(String leaveDate) {
            this.leaveDate = leaveDate;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getTankSize() {
            return tankSize;
        }

        public void setTankSize(String tankSize) {
            this.tankSize = tankSize;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getCarTypeName() {
            return carTypeName;
        }

        public void setCarTypeName(String carTypeName) {
            this.carTypeName = carTypeName;
        }

        public String getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(String buyPrice) {
            this.buyPrice = buyPrice;
        }

        public String getBuyPlace() {
            return buyPlace;
        }

        public void setBuyPlace(String buyPlace) {
            this.buyPlace = buyPlace;
        }

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getDriverOne() {
            return driverOne;
        }

        public void setDriverOne(String driverOne) {
            this.driverOne = driverOne;
        }

        public String getDriverTwo() {
            return driverTwo;
        }

        public void setDriverTwo(String driverTwo) {
            this.driverTwo = driverTwo;
        }

        public String getBelong() {
            return belong;
        }

        public void setBelong(String belong) {
            this.belong = belong;
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

        public String getBelongName() {
            return belongName;
        }

        public void setBelongName(String belongName) {
            this.belongName = belongName;
        }

        public String getLeaveOil() {
            return leaveOil;
        }

        public void setLeaveOil(String leaveOil) {
            this.leaveOil = leaveOil;
        }
    }
}
