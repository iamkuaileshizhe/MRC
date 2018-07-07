package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/2.
 */

public class CarCodeRespBean extends BaseBean {


    /**
     * code : null
     * bring : [{"id":"dfdcc0dd76be4a058487f6acd1bae8ee","carId":"91732e63c1004f4a8a4fae0ca95c3a35","carNum":"宁C53236","carType":"1","driverId":"87342145f3514103ac9f4d03405bdf42","driveName":"临时车辆司机","driveTel":"15725100021","safeId":"e2c1742bc2554d1f802447cf8af98945","safeName":"临时车辆押运员","safeTel":"15725100022","leaveOil":"-12.0699_-14472.3016","oilNum":"2","nationalStandard":"4","carState":"0","status":"1","c_user":"6f5561d31e17481191226b49a3fb5826","c_dt":"2018-05-25 11:24:06","u_user":"e2c1742bc2554d1f802447cf8af98945","u_dt":"2018-05-25 12:25:46","leaveOilForT":"-12.07","leaveOilForL":"-14472.30","batchNo":"P20180525001","coordinate":"117.15380680822517,36.67095150954468","mlng":null,"mlat":null,"oilTypeName":null,"nationalStandardName":null,"isDestroy":null,"destroyReason":null,"pictureURL":null,"orderQuantity":null,"source":null,"sourceName":null},{"id":"c7cf0989f3eb48caa2cd047f6363d3c5","carId":"cd10315b160c42ea8867d76a01dcd870","carNum":"鲁AY3K10","carType":"0","driverId":null,"driveName":null,"driveTel":null,"safeId":"e0d5650ded42470d8e82794f7f53fdfb","safeName":"吴健群","safeTel":"15105310726","leaveOil":"0.00_0.00","oilNum":null,"nationalStandard":null,"carState":"0","status":"1","c_user":"e0d5650ded42470d8e82794f7f53fdfb","c_dt":"2018-05-19 17:10:31","u_user":"","u_dt":"","leaveOilForT":"0.00","leaveOilForL":"0.00","batchNo":null,"coordinate":"117.140664,36.664404","mlng":null,"mlat":null,"oilTypeName":null,"nationalStandardName":null,"isDestroy":null,"destroyReason":null,"pictureURL":null,"orderQuantity":null,"source":null,"sourceName":null},{"id":"69b399e64471421c9e446b1dbc0b0b6d","carId":"4e95b5be3d0047d393c6a0706070e49b","carNum":"青A92351","carType":"0","driverId":"4ed9a8a55da841df8f7517c508d90c35","driveName":"李永高","driveTel":"13519703320","safeId":"36c645a895234c99a1f4761c7daaf822","safeName":"车占福","safeTel":"15003609858","leaveOil":"23.1678_27779.0959","oilNum":"2","nationalStandard":"4","carState":"0","status":"1","c_user":"74ca8d25bfa24d4a965b95d9abbcd70e","c_dt":"2018-04-25 14:39:40","u_user":"4ed9a8a55da841df8f7517c508d90c35","u_dt":"2018-05-25 12:40:13","leaveOilForT":"23.17","leaveOilForL":"27779.10","batchNo":"P20180525001","coordinate":"117.15384905455753,36.670943746258665","mlng":null,"mlat":null,"oilTypeName":null,"nationalStandardName":null,"isDestroy":null,"destroyReason":null,"pictureURL":null,"orderQuantity":null,"source":null,"sourceName":null}]
     */

    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : dfdcc0dd76be4a058487f6acd1bae8ee
         * carId : 91732e63c1004f4a8a4fae0ca95c3a35
         * carNum : 宁C53236
         * carType : 1
         * driverId : 87342145f3514103ac9f4d03405bdf42
         * driveName : 临时车辆司机
         * driveTel : 15725100021
         * safeId : e2c1742bc2554d1f802447cf8af98945
         * safeName : 临时车辆押运员
         * safeTel : 15725100022
         * leaveOil : -12.0699_-14472.3016
         * oilNum : 2
         * nationalStandard : 4
         * carState : 0
         * status : 1
         * c_user : 6f5561d31e17481191226b49a3fb5826
         * c_dt : 2018-05-25 11:24:06
         * u_user : e2c1742bc2554d1f802447cf8af98945
         * u_dt : 2018-05-25 12:25:46
         * leaveOilForT : -12.07
         * leaveOilForL : -14472.30
         * batchNo : P20180525001
         * coordinate : 117.15380680822517,36.67095150954468
         * mlng : null
         * mlat : null
         * oilTypeName : null
         * nationalStandardName : null
         * isDestroy : null
         * destroyReason : null
         * pictureURL : null
         * orderQuantity : null
         * source : null
         * sourceName : null
         */

        private String id;
        private String carId;
        private String carNum;
        private String carType;
        private String driverId;
        private String driveName;
        private String driveTel;
        private String safeId;
        private String safeName;
        private String safeTel;
        private String leaveOil;
        private String oilNum;
        private String nationalStandard;
        private String carState;
        private String status;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private String leaveOilForT;
        private String leaveOilForL;
        private String batchNo;
        private String coordinate;
        private String mlng;
        private String mlat;
        private String oilTypeName;
        private String nationalStandardName;
        private String isDestroy;
        private String destroyReason;
        private String pictureURL;
        private String orderQuantity;
        private String source;
        private String sourceName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getDriveName() {
            return driveName;
        }

        public void setDriveName(String driveName) {
            this.driveName = driveName;
        }

        public String getDriveTel() {
            return driveTel;
        }

        public void setDriveTel(String driveTel) {
            this.driveTel = driveTel;
        }

        public String getSafeId() {
            return safeId;
        }

        public void setSafeId(String safeId) {
            this.safeId = safeId;
        }

        public String getSafeName() {
            return safeName;
        }

        public void setSafeName(String safeName) {
            this.safeName = safeName;
        }

        public String getSafeTel() {
            return safeTel;
        }

        public void setSafeTel(String safeTel) {
            this.safeTel = safeTel;
        }

        public String getLeaveOil() {
            return leaveOil;
        }

        public void setLeaveOil(String leaveOil) {
            this.leaveOil = leaveOil;
        }

        public String getOilNum() {
            return oilNum;
        }

        public void setOilNum(String oilNum) {
            this.oilNum = oilNum;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getCarState() {
            return carState;
        }

        public void setCarState(String carState) {
            this.carState = carState;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getLeaveOilForT() {
            return leaveOilForT;
        }

        public void setLeaveOilForT(String leaveOilForT) {
            this.leaveOilForT = leaveOilForT;
        }

        public String getLeaveOilForL() {
            return leaveOilForL;
        }

        public void setLeaveOilForL(String leaveOilForL) {
            this.leaveOilForL = leaveOilForL;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(String coordinate) {
            this.coordinate = coordinate;
        }

        public String getMlng() {
            return mlng;
        }

        public void setMlng(String mlng) {
            this.mlng = mlng;
        }

        public String getMlat() {
            return mlat;
        }

        public void setMlat(String mlat) {
            this.mlat = mlat;
        }

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getNationalStandardName() {
            return nationalStandardName;
        }

        public void setNationalStandardName(String nationalStandardName) {
            this.nationalStandardName = nationalStandardName;
        }

        public String getIsDestroy() {
            return isDestroy;
        }

        public void setIsDestroy(String isDestroy) {
            this.isDestroy = isDestroy;
        }

        public String getDestroyReason() {
            return destroyReason;
        }

        public void setDestroyReason(String destroyReason) {
            this.destroyReason = destroyReason;
        }

        public String getPictureURL() {
            return pictureURL;
        }

        public void setPictureURL(String pictureURL) {
            this.pictureURL = pictureURL;
        }

        public String getOrderQuantity() {
            return orderQuantity;
        }

        public void setOrderQuantity(String orderQuantity) {
            this.orderQuantity = orderQuantity;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }
    }
}
