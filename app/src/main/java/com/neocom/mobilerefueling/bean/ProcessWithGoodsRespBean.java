package com.neocom.mobilerefueling.bean;


import java.util.List;

/**
 * Created by Administrator on 2018/5/10.
 */

public class ProcessWithGoodsRespBean extends BaseBean {


    /**
     * purl : properties/code.properties
     * code : null
     * bring : [{"circulateId":"70d71546682542bd8309684c2cd4b58e","circulateType":"0","flag":"1","commodityId":"bae3537aa866448598c776dab2a42062","unitPrice":"11223","num":"20","serialNumber":null,"status":null,"locId":"fb065202268f4afdbe51df20cd88ddec","storeIn":null,"storeOut":null},{"circulateId":"4f447c8e032c4f0d819366a7ccab3d38","circulateType":"0","flag":"1","commodityId":"d8735f2c59a5443e9dfa576992d9cc40","unitPrice":null,"num":"1","serialNumber":null,"status":null,"locId":"fb065202268f4afdbe51df20cd88ddec","storeIn":null,"storeOut":null}]
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
         * circulateId : 70d71546682542bd8309684c2cd4b58e
         * circulateType : 0
         * flag : 1
         * commodityId : bae3537aa866448598c776dab2a42062
         * unitPrice : 11223
         * num : 20
         * serialNumber : null
         * status : null
         * locId : fb065202268f4afdbe51df20cd88ddec
         * storeIn : null
         * storeOut : null
         */

        private String circulateId;
        private String circulateType;
        private String flag;
        private String commodityId;
        private String unitPrice;
        private String num;
        private String serialNumber;
        private String status;
        private String locId;
        private String storeIn;
        private String storeOut;

        public String getCirculateId() {
            return circulateId;
        }

        public void setCirculateId(String circulateId) {
            this.circulateId = circulateId;
        }

        public String getCirculateType() {
            return circulateType;
        }

        public void setCirculateType(String circulateType) {
            this.circulateType = circulateType;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLocId() {
            return locId;
        }

        public void setLocId(String locId) {
            this.locId = locId;
        }

        public String getStoreIn() {
            return storeIn;
        }

        public void setStoreIn(String storeIn) {
            this.storeIn = storeIn;
        }

        public String getStoreOut() {
            return storeOut;
        }

        public void setStoreOut(String storeOut) {
            this.storeOut = storeOut;
        }
    }
}
