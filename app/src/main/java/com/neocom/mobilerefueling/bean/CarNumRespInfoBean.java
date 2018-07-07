package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/9.
 */

public class CarNumRespInfoBean extends BaseBean {


    /**
     * bring : {"seqCode":"VEHCLE000005","model":"123","tankSize":"123","belong":null,"driverOne":"加油车测试21","remark":"123","driverTwo":"究极加油车22","buyDate":"2017-08-03","id":"f5026f72270f44d3acd301682a96bd04","carType":"0","frameNum":"123","buyPlace":"123","fuelType":"1","carNum":"京H12345","name":"古巨基","buyPrice":"123","telephone":"18458196336","review":"123","leaveDate":"2017-08-09"}
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
         * seqCode : VEHCLE000005
         * model : 123
         * tankSize : 123
         * belong : null
         * driverOne : 加油车测试21
         * remark : 123
         * driverTwo : 究极加油车22
         * buyDate : 2017-08-03
         * id : f5026f72270f44d3acd301682a96bd04
         * carType : 0
         * frameNum : 123
         * buyPlace : 123
         * fuelType : 1
         * carNum : 京H12345
         * name : 古巨基
         * buyPrice : 123
         * telephone : 18458196336
         * review : 123
         * leaveDate : 2017-08-09
         */

        private String seqCode;
        private String model;
        private String tankSize;
        private Object belong;
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

        public Object getBelong() {
            return belong;
        }

        public void setBelong(Object belong) {
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
