package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by xyz on 2017/12/31.
 */

public class GetCarInfoRespBean extends BaseBean {
    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * seqCode : VEH201801010003
         * model :
         * tankSize :
         * belong : dc9c4f114a9646d3a9a040d1069f3616
         * driverOne : 2702356795265023
         * remark :
         * driverTwo :
         * buyDate :
         * id : ea11e5f9a1e44918bb4ebb062a97cb2c
         * carType :
         * frameNum :
         * buyPlace :
         * fuelType :
         * carNum : 鲁A98765
         * name : 胡新学
         * buyPrice :
         * telephone :
         * review :
         * leaveDate :
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


//    private List<BringBean> bring;
//
//    public List<BringBean> getBring() {
//        return bring;
//    }
//
//    public void setBring(List<BringBean> bring) {
//        this.bring = bring;
//    }
//
//    public static class BringBean {
//        /**
//         * id : 76f7d809dbce4fc78dcac340943993ee
//         * seqCode : null
//         * carNum : 京H12333
//         * frameNum : 国D6222081608002302676
//         * model : a3 sportback 30 tfsi
//         * leaveDate : 2017-08-02
//         * fuelType : 0
//         * tankSize : 3000
//         * carType : 0
//         * carTypeName : null
//         * buyPrice : 21万
//         * buyPlace : 山东济宁
//         * buyDate : 2017-08-01
//         * review : 云南省工商行政管理局
//         * driverOne : 370802199409033337
//         * driverTwo : 370802199409033339
//         * belong : 094cf699058b493f98ec98d673ad0286
//         * remark : 唐宁康和吴强
//         * createId : null
//         * createTime : null
//         * updateId : null
//         * updateTime : null
//         * status : null
//         * belongName : null
//         */
//
//        private String id;
//        private Object seqCode;
//        private String carNum;
//        private String frameNum;
//        private String model;
//        private String leaveDate;
//        private String fuelType;
//        private String tankSize;
//        private String carType;
//        private Object carTypeName;
//        private String buyPrice;
//        private String buyPlace;
//        private String buyDate;
//        private String review;
//        private String driverOne;
//        private String driverTwo;
//        private String belong;
//        private String remark;
//        private Object createId;
//        private Object createTime;
//        private Object updateId;
//        private Object updateTime;
//        private Object status;
//        private Object belongName;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public Object getSeqCode() {
//            return seqCode;
//        }
//
//        public void setSeqCode(Object seqCode) {
//            this.seqCode = seqCode;
//        }
//
//        public String getCarNum() {
//            return carNum;
//        }
//
//        public void setCarNum(String carNum) {
//            this.carNum = carNum;
//        }
//
//        public String getFrameNum() {
//            return frameNum;
//        }
//
//        public void setFrameNum(String frameNum) {
//            this.frameNum = frameNum;
//        }
//
//        public String getModel() {
//            return model;
//        }
//
//        public void setModel(String model) {
//            this.model = model;
//        }
//
//        public String getLeaveDate() {
//            return leaveDate;
//        }
//
//        public void setLeaveDate(String leaveDate) {
//            this.leaveDate = leaveDate;
//        }
//
//        public String getFuelType() {
//            return fuelType;
//        }
//
//        public void setFuelType(String fuelType) {
//            this.fuelType = fuelType;
//        }
//
//        public String getTankSize() {
//            return tankSize;
//        }
//
//        public void setTankSize(String tankSize) {
//            this.tankSize = tankSize;
//        }
//
//        public String getCarType() {
//            return carType;
//        }
//
//        public void setCarType(String carType) {
//            this.carType = carType;
//        }
//
//        public Object getCarTypeName() {
//            return carTypeName;
//        }
//
//        public void setCarTypeName(Object carTypeName) {
//            this.carTypeName = carTypeName;
//        }
//
//        public String getBuyPrice() {
//            return buyPrice;
//        }
//
//        public void setBuyPrice(String buyPrice) {
//            this.buyPrice = buyPrice;
//        }
//
//        public String getBuyPlace() {
//            return buyPlace;
//        }
//
//        public void setBuyPlace(String buyPlace) {
//            this.buyPlace = buyPlace;
//        }
//
//        public String getBuyDate() {
//            return buyDate;
//        }
//
//        public void setBuyDate(String buyDate) {
//            this.buyDate = buyDate;
//        }
//
//        public String getReview() {
//            return review;
//        }
//
//        public void setReview(String review) {
//            this.review = review;
//        }
//
//        public String getDriverOne() {
//            return driverOne;
//        }
//
//        public void setDriverOne(String driverOne) {
//            this.driverOne = driverOne;
//        }
//
//        public String getDriverTwo() {
//            return driverTwo;
//        }
//
//        public void setDriverTwo(String driverTwo) {
//            this.driverTwo = driverTwo;
//        }
//
//        public String getBelong() {
//            return belong;
//        }
//
//        public void setBelong(String belong) {
//            this.belong = belong;
//        }
//
//        public String getRemark() {
//            return remark;
//        }
//
//        public void setRemark(String remark) {
//            this.remark = remark;
//        }
//
//        public Object getCreateId() {
//            return createId;
//        }
//
//        public void setCreateId(Object createId) {
//            this.createId = createId;
//        }
//
//        public Object getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(Object createTime) {
//            this.createTime = createTime;
//        }
//
//        public Object getUpdateId() {
//            return updateId;
//        }
//
//        public void setUpdateId(Object updateId) {
//            this.updateId = updateId;
//        }
//
//        public Object getUpdateTime() {
//            return updateTime;
//        }
//
//        public void setUpdateTime(Object updateTime) {
//            this.updateTime = updateTime;
//        }
//
//        public Object getStatus() {
//            return status;
//        }
//
//        public void setStatus(Object status) {
//            this.status = status;
//        }
//
//        public Object getBelongName() {
//            return belongName;
//        }
//
//        public void setBelongName(Object belongName) {
//            this.belongName = belongName;
//        }
//    }
}
