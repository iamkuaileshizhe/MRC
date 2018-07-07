package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2018/1/8.
 */

public class PaiSongDanOilPriceRespBean extends BaseBean {


    /**
     * bring : {"id":"9a7377b336f14866b78f1eca917a580b","oilType":"3","startTime":"2017-09-29 00:00:00","oilPrice":"20","nationalStandard":"1","area":"620000","areaName":null,"prePrice":"0.5"}
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
         * id : 9a7377b336f14866b78f1eca917a580b
         * oilType : 3
         * startTime : 2017-09-29 00:00:00
         * oilPrice : 20
         * nationalStandard : 1
         * area : 620000
         * areaName : null
         * prePrice : 0.5
         */

        private String id;
        private String oilType;
        private String startTime;
        private String oilPrice;
        private String nationalStandard;
        private String area;
        private String areaName;
        private String prePrice;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getOilPrice() {
            return oilPrice;
        }

        public void setOilPrice(String oilPrice) {
            this.oilPrice = oilPrice;
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

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getPrePrice() {
            return prePrice;
        }

        public void setPrePrice(String prePrice) {
            this.prePrice = prePrice;
        }

        @Override
        public String toString() {
            return "BringBean{" +
                    "id='" + id + '\'' +
                    ", oilType='" + oilType + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", oilPrice='" + oilPrice + '\'' +
                    ", nationalStandard='" + nationalStandard + '\'' +
                    ", area='" + area + '\'' +
                    ", areaName='" + areaName + '\'' +
                    ", prePrice='" + prePrice + '\'' +
                    '}';
        }
    }
}
