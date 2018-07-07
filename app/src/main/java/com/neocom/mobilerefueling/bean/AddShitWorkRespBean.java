package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/10/26.
 */

public class AddShitWorkRespBean extends BaseBean{
    /**
     * bring : {"id":"b1a5f14b807f46048b0b57e5e555a815","oilShiftNum":"JJB201803060049","carryUser":"测试司机","carryTel":"13666666666","carryNum":"a64dcc4712a34eff857f00d33d663f91","turnUser":"","turnTel":"","turnNum":"","shiftTime":"2018-03-06 19:43:56 ","shiftAddress":"山东省济南市历城区舜泰东路6292号靠近中国工商银行(山钢支行)","carNum":"鲁AY3K10","remainCarOil":null,"carsMileage":"1111","remainTankOil":"-182.00","joinType":"","isGroup":"","joinStatus":"2","remark":"嗯","oilShiftStatus":"0","status":"1","shiftStatus":"1","carryStatus":"1","confirmStatus":"1","c_user":"a64dcc4712a34eff857f00d33d663f91","c_dt":"2018-03-06 19:44:34","u_user":null,"u_dt":null,"carId":null,"confirmTime":"2018-03-06 19:44:35","openType":null}
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
         * id : b1a5f14b807f46048b0b57e5e555a815
         * oilShiftNum : JJB201803060049
         * carryUser : 测试司机
         * carryTel : 13666666666
         * carryNum : a64dcc4712a34eff857f00d33d663f91
         * turnUser : 
         * turnTel : 
         * turnNum : 
         * shiftTime : 2018-03-06 19:43:56 
         * shiftAddress : 山东省济南市历城区舜泰东路6292号靠近中国工商银行(山钢支行)
         * carNum : 鲁AY3K10
         * remainCarOil : null
         * carsMileage : 1111
         * remainTankOil : -182.00
         * joinType : 
         * isGroup : 
         * joinStatus : 2
         * remark : 嗯
         * oilShiftStatus : 0
         * status : 1
         * shiftStatus : 1
         * carryStatus : 1
         * confirmStatus : 1
         * c_user : a64dcc4712a34eff857f00d33d663f91
         * c_dt : 2018-03-06 19:44:34
         * u_user : null
         * u_dt : null
         * carId : null
         * confirmTime : 2018-03-06 19:44:35
         * openType : null
         */

        private String id;
        private String oilShiftNum;
        private String carryUser;
        private String carryTel;
        private String carryNum;
        private String turnUser;
        private String turnTel;
        private String turnNum;
        private String shiftTime;
        private String shiftAddress;
        private String carNum;
        private String remainCarOil;
        private String carsMileage;
        private String remainTankOil;
        private String joinType;
        private String isGroup;
        private String joinStatus;
        private String remark;
        private String oilShiftStatus;
        private String status;
        private String shiftStatus;
        private String carryStatus;
        private String confirmStatus;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private String carId;
        private String confirmTime;
        private String openType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOilShiftNum() {
            return oilShiftNum;
        }

        public void setOilShiftNum(String oilShiftNum) {
            this.oilShiftNum = oilShiftNum;
        }

        public String getCarryUser() {
            return carryUser;
        }

        public void setCarryUser(String carryUser) {
            this.carryUser = carryUser;
        }

        public String getCarryTel() {
            return carryTel;
        }

        public void setCarryTel(String carryTel) {
            this.carryTel = carryTel;
        }

        public String getCarryNum() {
            return carryNum;
        }

        public void setCarryNum(String carryNum) {
            this.carryNum = carryNum;
        }

        public String getTurnUser() {
            return turnUser;
        }

        public void setTurnUser(String turnUser) {
            this.turnUser = turnUser;
        }

        public String getTurnTel() {
            return turnTel;
        }

        public void setTurnTel(String turnTel) {
            this.turnTel = turnTel;
        }

        public String getTurnNum() {
            return turnNum;
        }

        public void setTurnNum(String turnNum) {
            this.turnNum = turnNum;
        }

        public String getShiftTime() {
            return shiftTime;
        }

        public void setShiftTime(String shiftTime) {
            this.shiftTime = shiftTime;
        }

        public String getShiftAddress() {
            return shiftAddress;
        }

        public void setShiftAddress(String shiftAddress) {
            this.shiftAddress = shiftAddress;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getRemainCarOil() {
            return remainCarOil;
        }

        public void setRemainCarOil(String remainCarOil) {
            this.remainCarOil = remainCarOil;
        }

        public String getCarsMileage() {
            return carsMileage;
        }

        public void setCarsMileage(String carsMileage) {
            this.carsMileage = carsMileage;
        }

        public String getRemainTankOil() {
            return remainTankOil;
        }

        public void setRemainTankOil(String remainTankOil) {
            this.remainTankOil = remainTankOil;
        }

        public String getJoinType() {
            return joinType;
        }

        public void setJoinType(String joinType) {
            this.joinType = joinType;
        }

        public String getIsGroup() {
            return isGroup;
        }

        public void setIsGroup(String isGroup) {
            this.isGroup = isGroup;
        }

        public String getJoinStatus() {
            return joinStatus;
        }

        public void setJoinStatus(String joinStatus) {
            this.joinStatus = joinStatus;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getOilShiftStatus() {
            return oilShiftStatus;
        }

        public void setOilShiftStatus(String oilShiftStatus) {
            this.oilShiftStatus = oilShiftStatus;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShiftStatus() {
            return shiftStatus;
        }

        public void setShiftStatus(String shiftStatus) {
            this.shiftStatus = shiftStatus;
        }

        public String getCarryStatus() {
            return carryStatus;
        }

        public void setCarryStatus(String carryStatus) {
            this.carryStatus = carryStatus;
        }

        public String getConfirmStatus() {
            return confirmStatus;
        }

        public void setConfirmStatus(String confirmStatus) {
            this.confirmStatus = confirmStatus;
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

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getConfirmTime() {
            return confirmTime;
        }

        public void setConfirmTime(String confirmTime) {
            this.confirmTime = confirmTime;
        }

        public String getOpenType() {
            return openType;
        }

        public void setOpenType(String openType) {
            this.openType = openType;
        }
    }


//
//
//    /**
//     * bring : {"id":"b07a237ec8e84213b05e7a6a6f863c57","oilShiftNum":"SD-C000001","carryUser":"9-4修改2","carryTel":"dafdfasd","carryUserId":"3f67e2778c944999a00692f493862c50","turnUser":"张三","turnTel":"dafdfasd","turnUserId":"39931489bb224746ba0d0e23d20a4ced","shiftTime":"2017-10-26 15:06:03","shiftAddress":"高新区舜泰","carCode":null,"remainCarOil":"222","carsMileage":"333","remainTankOil":"444","remark":"555","oilShiftStatus":null,"status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-26 15:05:27","u_user":null,"u_dt":null,"completOrder":null,"uncompletOrder":null}
//     */
//
//    private BringBean bring;
//
//    public BringBean getBring() {
//        return bring;
//    }
//
//    public void setBring(BringBean bring) {
//        this.bring = bring;
//    }
//
//    public static class BringBean {
//        /**
//         * id : b07a237ec8e84213b05e7a6a6f863c57
//         * oilShiftNum : SD-C000001
//         * carryUser : 9-4修改2
//         * carryTel : dafdfasd
//         * carryUserId : 3f67e2778c944999a00692f493862c50
//         * turnUser : 张三
//         * turnTel : dafdfasd
//         * turnUserId : 39931489bb224746ba0d0e23d20a4ced
//         * shiftTime : 2017-10-26 15:06:03
//         * shiftAddress : 高新区舜泰
//         * carCode : null
//         * remainCarOil : 222
//         * carsMileage : 333
//         * remainTankOil : 444
//         * remark : 555
//         * oilShiftStatus : null
//         * status : null
//         * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
//         * c_dt : 2017-10-26 15:05:27
//         * u_user : null
//         * u_dt : null
//         * completOrder : null
//         * uncompletOrder : null
//         */
//
//        private String id;
//        private String oilShiftNum;
//        private String carryUser;
//        private String carryTel;
//        private String carryUserId;
//        private String turnUser;
//        private String turnTel;
//        private String turnUserId;
//        private String shiftTime;
//        private String shiftAddress;
//        private String carCode;
//        private String remainCarOil;
//        private String carsMileage;
//        private String remainTankOil;
//        private String remark;
//        private String oilShiftStatus;
//        private String status;
//        private String c_user;
//        private String c_dt;
//        private String u_user;
//        private String u_dt;
//        private String completOrder;
//        private String uncompletOrder;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getOilShiftNum() {
//            return oilShiftNum;
//        }
//
//        public void setOilShiftNum(String oilShiftNum) {
//            this.oilShiftNum = oilShiftNum;
//        }
//
//        public String getCarryUser() {
//            return carryUser;
//        }
//
//        public void setCarryUser(String carryUser) {
//            this.carryUser = carryUser;
//        }
//
//        public String getCarryTel() {
//            return carryTel;
//        }
//
//        public void setCarryTel(String carryTel) {
//            this.carryTel = carryTel;
//        }
//
//        public String getCarryUserId() {
//            return carryUserId;
//        }
//
//        public void setCarryUserId(String carryUserId) {
//            this.carryUserId = carryUserId;
//        }
//
//        public String getTurnUser() {
//            return turnUser;
//        }
//
//        public void setTurnUser(String turnUser) {
//            this.turnUser = turnUser;
//        }
//
//        public String getTurnTel() {
//            return turnTel;
//        }
//
//        public void setTurnTel(String turnTel) {
//            this.turnTel = turnTel;
//        }
//
//        public String getTurnUserId() {
//            return turnUserId;
//        }
//
//        public void setTurnUserId(String turnUserId) {
//            this.turnUserId = turnUserId;
//        }
//
//        public String getShiftTime() {
//            return shiftTime;
//        }
//
//        public void setShiftTime(String shiftTime) {
//            this.shiftTime = shiftTime;
//        }
//
//        public String getShiftAddress() {
//            return shiftAddress;
//        }
//
//        public void setShiftAddress(String shiftAddress) {
//            this.shiftAddress = shiftAddress;
//        }
//
//        public String getCarCode() {
//            return carCode;
//        }
//
//        public void setCarCode(String carCode) {
//            this.carCode = carCode;
//        }
//
//        public String getRemainCarOil() {
//            return remainCarOil;
//        }
//
//        public void setRemainCarOil(String remainCarOil) {
//            this.remainCarOil = remainCarOil;
//        }
//
//        public String getCarsMileage() {
//            return carsMileage;
//        }
//
//        public void setCarsMileage(String carsMileage) {
//            this.carsMileage = carsMileage;
//        }
//
//        public String getRemainTankOil() {
//            return remainTankOil;
//        }
//
//        public void setRemainTankOil(String remainTankOil) {
//            this.remainTankOil = remainTankOil;
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
//        public String getOilShiftStatus() {
//            return oilShiftStatus;
//        }
//
//        public void setOilShiftStatus(String oilShiftStatus) {
//            this.oilShiftStatus = oilShiftStatus;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public String getC_user() {
//            return c_user;
//        }
//
//        public void setC_user(String c_user) {
//            this.c_user = c_user;
//        }
//
//        public String getC_dt() {
//            return c_dt;
//        }
//
//        public void setC_dt(String c_dt) {
//            this.c_dt = c_dt;
//        }
//
//        public String getU_user() {
//            return u_user;
//        }
//
//        public void setU_user(String u_user) {
//            this.u_user = u_user;
//        }
//
//        public String getU_dt() {
//            return u_dt;
//        }
//
//        public void setU_dt(String u_dt) {
//            this.u_dt = u_dt;
//        }
//
//        public String getCompletOrder() {
//            return completOrder;
//        }
//
//        public void setCompletOrder(String completOrder) {
//            this.completOrder = completOrder;
//        }
//
//        public String getUncompletOrder() {
//            return uncompletOrder;
//        }
//
//        public void setUncompletOrder(String uncompletOrder) {
//            this.uncompletOrder = uncompletOrder;
//        }
//    }
}
