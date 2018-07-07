package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/30.
 */

public class JiaYouJiRespBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 123456
         * carNum : 京H12345
         * oilCar_id : 4dc2c5426f33496da3c77e0247a3c074
         * oilType : 2
         * oilName : 0号柴油
         * nationalStandard : 2
         * nationalStandardName : 国三
         * oilPrice : 20
         * tankerNum : JYJ000001
         * oilAmount : 50
         * startTime : 2017-10-22 07:26:00
         * finishTime : 2017-10-24 07:26:00
         * realCost : 1000
         * refuelAddress : 山东省济南市市中区大众广场
         * relateStatus : 0
         * status : 1
         * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
         * c_dt : 2017-10-25 08:45:00
         * u_user : 17c4520f6cfd1ab53d8745e84681eb49
         * u_dt : 2017-10-25 08:45:00
         */

        private String id;
        private String carNum;
        private String oilCar_id;
        private String oilType;
        private String oilName;
        private String nationalStandard;
        private String nationalStandardName;
        private String oilPrice;
        private String tankerNum;
        private String oilAmount;
        private String startTime;
        private String finishTime;
        private String realCost;
        private String refuelAddress;
        private String relateStatus;
        private String status;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getOilCar_id() {
            return oilCar_id;
        }

        public void setOilCar_id(String oilCar_id) {
            this.oilCar_id = oilCar_id;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getOilName() {
            return oilName;
        }

        public void setOilName(String oilName) {
            this.oilName = oilName;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getNationalStandardName() {
            return nationalStandardName;
        }

        public void setNationalStandardName(String nationalStandardName) {
            this.nationalStandardName = nationalStandardName;
        }

        public String getOilPrice() {
            return oilPrice;
        }

        public void setOilPrice(String oilPrice) {
            this.oilPrice = oilPrice;
        }

        public String getTankerNum() {
            return tankerNum;
        }

        public void setTankerNum(String tankerNum) {
            this.tankerNum = tankerNum;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public String getRealCost() {
            return realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getRefuelAddress() {
            return refuelAddress;
        }

        public void setRefuelAddress(String refuelAddress) {
            this.refuelAddress = refuelAddress;
        }

        public String getRelateStatus() {
            return relateStatus;
        }

        public void setRelateStatus(String relateStatus) {
            this.relateStatus = relateStatus;
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

        @Override
        public String toString() {
            return "BringBean{" +
                    "id='" + id + '\'' +
                    ", carNum='" + carNum + '\'' +
                    ", oilCar_id='" + oilCar_id + '\'' +
                    ", oilType='" + oilType + '\'' +
                    ", oilName='" + oilName + '\'' +
                    ", nationalStandard='" + nationalStandard + '\'' +
                    ", nationalStandardName='" + nationalStandardName + '\'' +
                    ", oilPrice='" + oilPrice + '\'' +
                    ", tankerNum='" + tankerNum + '\'' +
                    ", oilAmount='" + oilAmount + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", finishTime='" + finishTime + '\'' +
                    ", realCost='" + realCost + '\'' +
                    ", refuelAddress='" + refuelAddress + '\'' +
                    ", relateStatus='" + relateStatus + '\'' +
                    ", status='" + status + '\'' +
                    ", c_user='" + c_user + '\'' +
                    ", c_dt='" + c_dt + '\'' +
                    ", u_user='" + u_user + '\'' +
                    ", u_dt='" + u_dt + '\'' +
                    ", checked=" + checked +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JiaYouJiRespBean{" +
                "bring=" + bring +
                '}';
    }
}
