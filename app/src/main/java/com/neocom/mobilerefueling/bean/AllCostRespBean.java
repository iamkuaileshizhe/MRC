package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/3/16.
 */

public class AllCostRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"nationalStandard":"4","deliveryId":"efae093fbe734c06930404e7e969d18a","oilUnitPrice":"6.5","oilTotalPrice":"325.00","oilType":"3"}
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
         * nationalStandard : 4
         * deliveryId : efae093fbe734c06930404e7e969d18a
         * oilUnitPrice : 6.5
         * oilTotalPrice : 325.00
         * oilType : 3
         * "unit": "元/吨",
         */

        private String nationalStandard;
        private String deliveryId;
        private String oilUnitPrice;
        private String oilTotalPrice;
        private String oilType;
        private String unit;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }

        public String getOilUnitPrice() {
            return oilUnitPrice;
        }

        public void setOilUnitPrice(String oilUnitPrice) {
            this.oilUnitPrice = oilUnitPrice;
        }

        public String getOilTotalPrice() {
            return oilTotalPrice;
        }

        public void setOilTotalPrice(String oilTotalPrice) {
            this.oilTotalPrice = oilTotalPrice;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }
    }
}
