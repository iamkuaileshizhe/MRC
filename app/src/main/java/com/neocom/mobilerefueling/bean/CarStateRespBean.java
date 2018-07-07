package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/3/6.
 */

public class CarStateRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"id":"7abe96eb8fc049e09f307a6507153ea0","carId":"d0f7b6505f28484b815ef08a154ed514","carNum":"鲁AY3K10","carType":"0","driverId":null,"driveName":null,"driveTel":null,"safeId":"82d388ab008f463ebbd03fa5d1433fd4","safeName":"胡新学","safeTel":"18953186913","leaveOil":"-182.0000_-145.6000","oilNum":"1","nationalStandard":"4","carState":"0","status":"1","c_user":"82d388ab008f463ebbd03fa5d1433fd4","c_dt":"2018-03-06 11:48:14","u_user":"","u_dt":"","leaveOilForT":"-182.00","leaveOilForL":"-145.60"}
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
         * id : 7abe96eb8fc049e09f307a6507153ea0
         * carId : d0f7b6505f28484b815ef08a154ed514
         * carNum : 鲁AY3K10
         * carType : 0
         * driverId : null
         * driveName : null
         * driveTel : null
         * safeId : 82d388ab008f463ebbd03fa5d1433fd4
         * safeName : 胡新学
         * safeTel : 18953186913
         * leaveOil : -182.0000_-145.6000
         * oilNum : 1
         * nationalStandard : 4
         * carState : 0
         * status : 1
         * c_user : 82d388ab008f463ebbd03fa5d1433fd4
         * c_dt : 2018-03-06 11:48:14
         * u_user :
         * u_dt :
         * leaveOilForT : -182.00
         * leaveOilForL : -145.60
         */

        private String id;
        private String carId;
        private String carNum;
        private String carType;
        private Object driverId;
        private Object driveName;
        private Object driveTel;
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

        public Object getDriverId() {
            return driverId;
        }

        public void setDriverId(Object driverId) {
            this.driverId = driverId;
        }

        public Object getDriveName() {
            return driveName;
        }

        public void setDriveName(Object driveName) {
            this.driveName = driveName;
        }

        public Object getDriveTel() {
            return driveTel;
        }

        public void setDriveTel(Object driveTel) {
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
    }
}
