package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/3/2.
 */

public class CarInfoRespBean extends BaseBean {


    /**
     * bring : {"seqCode":null,"model":"川","tankSize":"川","belong":null,"driverOne":"川A34995身份证号","remark":"川A34995川A34995","driverTwo":"川A34995身份证号","buyDate":"2017-08-11","id":"1198f7e10bc24410b26c24cd047a6c4f","carType":"5","frameNum":"川","buyPlace":"川","fuelType":"2","carNum":"川A34995","name":"陈一发","buyPrice":"川","telephone":"川A34995","review":"川","leaveDate":"2017-08-22"}
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
         * seqCode : null
         * model : 川
         * tankSize : 川
         * belong : null
         * driverOne : 川A34995身份证号
         * remark : 川A34995川A34995
         * driverTwo : 川A34995身份证号
         * buyDate : 2017-08-11
         * id : 1198f7e10bc24410b26c24cd047a6c4f
         * carType : 5
         * frameNum : 川
         * buyPlace : 川
         * fuelType : 2
         * carNum : 川A34995
         * name : 陈一发
         * buyPrice : 川
         * telephone : 川A34995
         * review : 川
         * leaveDate : 2017-08-22
         */

        private String seqCode;
        private String model;
        private String tankSize;
        private String belong;
        private String driverOne;
        private String remark;
        private String driverTwo;
        private String buyDate;
        private String id;
        private String carType;
        private String frameNum;
        private String buyPlace;
        private String fuelType;
        private String carNum;
        private String name;
        private String buyPrice;
        private String telephone;
        private String review;
        private String leaveDate;
        private String leaveOil;

        public String getLeaveOil() {
            return leaveOil;
        }

        public void setLeaveOil(String leaveOil) {
            this.leaveOil = leaveOil;
        }

        public String getSeqCode() {
            return seqCode;
        }

        public void setSeqCode(String seqCode) {
            this.seqCode = seqCode;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getTankSize() {
            return tankSize;
        }

        public void setTankSize(String tankSize) {
            this.tankSize = tankSize;
        }

        public String getBelong() {
            return belong;
        }

        public void setBelong(String belong) {
            this.belong = belong;
        }

        public String getDriverOne() {
            return driverOne;
        }

        public void setDriverOne(String driverOne) {
            this.driverOne = driverOne;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDriverTwo() {
            return driverTwo;
        }

        public void setDriverTwo(String driverTwo) {
            this.driverTwo = driverTwo;
        }

        public String getBuyDate() {
            return buyDate;
        }

        public void setBuyDate(String buyDate) {
            this.buyDate = buyDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getFrameNum() {
            return frameNum;
        }

        public void setFrameNum(String frameNum) {
            this.frameNum = frameNum;
        }

        public String getBuyPlace() {
            return buyPlace;
        }

        public void setBuyPlace(String buyPlace) {
            this.buyPlace = buyPlace;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(String buyPrice) {
            this.buyPrice = buyPrice;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getLeaveDate() {
            return leaveDate;
        }

        public void setLeaveDate(String leaveDate) {
            this.leaveDate = leaveDate;
        }
    }
}
