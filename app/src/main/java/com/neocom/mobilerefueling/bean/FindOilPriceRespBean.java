package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/12/23.
 */

public class FindOilPriceRespBean extends BaseBean {
    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * oilTypeName : -50号柴油
         * id : 1bbdd3402cb6400599710f0d3e67504d
         * nationalStandard : 4
         * area : 110000
         * performAmount : 9.49
         * GBName : 国五
         * oilType : 6
         * areaPrice : 10.49
         * prePrice : 1
         *
         * 后来修改
         *
         *  "oilTypeName": "-50号柴油",
         "id": "9930aaef6c904bf9b553b82c16f6dfa1",
         "nationalStandard": "4",
         "performAmount": "16.65",
         "province": "630000",
         "GBName": "国五",
         "oilType": "6",
         "areaPrice": "16.65",
         "prePrice": "16.65"
         *
         *
         */

        private String oilTypeName;
        private String id;
        private String nationalStandard;
        private String area;
        private String performAmount;
        private String GBName;
        private String oilType;
        private String areaPrice;
        private String prePrice;

        private String province;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getPerformAmount() {
            return performAmount;
        }

        public void setPerformAmount(String performAmount) {
            this.performAmount = performAmount;
        }

        public String getGBName() {
            return GBName;
        }

        public void setGBName(String GBName) {
            this.GBName = GBName;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getAreaPrice() {
            return areaPrice;
        }

        public void setAreaPrice(String areaPrice) {
            this.areaPrice = areaPrice;
        }

        public String getPrePrice() {
            return prePrice;
        }

        public void setPrePrice(String prePrice) {
            this.prePrice = prePrice;
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
//         * oilTypeName : -50号柴油
//         * nationalStandard : 4
//         * status : 1
//         * u_dt : null
//         * discountAmount : 1
//         * oilType : 6
//         * id : 1c2cba9c0f8a4de59498d1cec6d9abd4
//         * customerId : d8a9d6f7c8834f2c80d6dd456ae13b48
//         * c_user : 4d9dddf8120e4c578d30f245faed0b55
//         * performAmount : 14
//         * province : 370000
//         * GBName : 国五
//         * u_user : null
//         * c_dt : 2017-12-23 17:43:04
//         */
//
//        private String oilTypeName;
//        private String nationalStandard;
//        private String status;
//        private Object u_dt;
//        private String discountAmount;
//        private String oilType;
//        private String id;
//        private String customerId;
//        private String c_user;
//        private String performAmount;
//        private String province;
//        private String GBName;
//        private Object u_user;
//        private String c_dt;
//
//        public String getOilTypeName() {
//            return oilTypeName;
//        }
//
//        public void setOilTypeName(String oilTypeName) {
//            this.oilTypeName = oilTypeName;
//        }
//
//        public String getNationalStandard() {
//            return nationalStandard;
//        }
//
//        public void setNationalStandard(String nationalStandard) {
//            this.nationalStandard = nationalStandard;
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
//        public Object getU_dt() {
//            return u_dt;
//        }
//
//        public void setU_dt(Object u_dt) {
//            this.u_dt = u_dt;
//        }
//
//        public String getDiscountAmount() {
//            return discountAmount;
//        }
//
//        public void setDiscountAmount(String discountAmount) {
//            this.discountAmount = discountAmount;
//        }
//
//        public String getOilType() {
//            return oilType;
//        }
//
//        public void setOilType(String oilType) {
//            this.oilType = oilType;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getCustomerId() {
//            return customerId;
//        }
//
//        public void setCustomerId(String customerId) {
//            this.customerId = customerId;
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
//        public String getPerformAmount() {
//            return performAmount;
//        }
//
//        public void setPerformAmount(String performAmount) {
//            this.performAmount = performAmount;
//        }
//
//        public String getProvince() {
//            return province;
//        }
//
//        public void setProvince(String province) {
//            this.province = province;
//        }
//
//        public String getGBName() {
//            return GBName;
//        }
//
//        public void setGBName(String GBName) {
//            this.GBName = GBName;
//        }
//
//        public Object getU_user() {
//            return u_user;
//        }
//
//        public void setU_user(Object u_user) {
//            this.u_user = u_user;
//        }
//
//        public String getC_dt() {
//            return c_dt;
//        }
//
//        public void setC_dt(String c_dt) {
//            this.c_dt = c_dt;
//        }
//    }
}
