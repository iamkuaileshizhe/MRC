package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/1/29.
 */

public class loginRespBean extends BaseBean {


    /**
     * bring : {"carryStatus":"0","carNum":"青A92351","roleCode":"r_refuel_gmjy,"}
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
         * carryStatus : 0
         * carNum : 青A92351
         * roleCode : r_refuel_gmjy,
         */

        private String carryStatus;
        private String carNum;
        private String roleCode;

        public String getCarryStatus() {
            return carryStatus;
        }

        public void setCarryStatus(String carryStatus) {
            this.carryStatus = carryStatus;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getRoleCode() {
            return roleCode;
        }

        public void setRoleCode(String roleCode) {
            this.roleCode = roleCode;
        }
    }

}
