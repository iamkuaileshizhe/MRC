package com.neocom.mobilerefueling.bean;


/**
 * Created by Administrator on 2018/5/16.
 */

public class ResetCarOilRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"id":"572d73e037864812a9c859ea827aaeba","remark":"1111111111111111111111111","curOilNum":"0.00_0.00","carNum":"鲁A99999","c_user":"eb7c0b4fcbf1429a9fb8c358697f3365","c_dt":"2018-05-16 14:31:42"}
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
         * id : 572d73e037864812a9c859ea827aaeba
         * remark : 1111111111111111111111111
         * curOilNum : 0.00_0.00
         * carNum : 鲁A99999
         * c_user : eb7c0b4fcbf1429a9fb8c358697f3365
         * c_dt : 2018-05-16 14:31:42
         */

        private String id;
        private String remark;
        private String curOilNum;
        private String carNum;
        private String c_user;
        private String c_dt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCurOilNum() {
            return curOilNum;
        }

        public void setCurOilNum(String curOilNum) {
            this.curOilNum = curOilNum;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
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
    }
}
