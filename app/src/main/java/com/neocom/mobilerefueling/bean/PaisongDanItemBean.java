package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/8.
 */

public class PaisongDanItemBean extends BaseBean {


    /**
     * bring : {"oilTypeName":"-20号柴油","nationalStandard":"4","nationalStandardName":"国五","oilType":"4"}
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
         * oilTypeName : -20号柴油
         * nationalStandard : 4
         * nationalStandardName : 国五
         * oilType : 4
         */

        private String oilTypeName;
        private String nationalStandard;
        private String nationalStandardName;
        private String oilType;

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
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

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        @Override
        public String toString() {
            return "BringBean{" +
                    "oilTypeName='" + oilTypeName + '\'' +
                    ", nationalStandard='" + nationalStandard + '\'' +
                    ", nationalStandardName='" + nationalStandardName + '\'' +
                    ", oilType='" + oilType + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PaisongDanItemBean{" +
                "bring=" + bring +
                '}';
    }
}
