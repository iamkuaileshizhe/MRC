package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/11/22.
 */

public class PayWXRespParaBean extends BaseBean {
    /**
     * code : null
     * bring : {"id":"7cde62af9649431190fd8a74ac2eee91","sign":"7EF3AAB96FBD699743FC6A4D907CB64871107F2448D5038AC588529149D6E205","appId":"wxfa7ab97dd028ff83","timeStamp":"1522485171","sjzf":"","partnerId":"1501238921","yezf":"","nonceStr":"ddvgRrzeY4y2if45","prepayId":"wx20180331163220e3303bbc3b0147060090"}
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
         * id : 7cde62af9649431190fd8a74ac2eee91
         * sign : 7EF3AAB96FBD699743FC6A4D907CB64871107F2448D5038AC588529149D6E205
         * appId : wxfa7ab97dd028ff83
         * timeStamp : 1522485171
         * sjzf :
         * partnerId : 1501238921
         * yezf :
         * nonceStr : ddvgRrzeY4y2if45
         * prepayId : wx20180331163220e3303bbc3b0147060090
         */

        private String id;
        private String sign;
        private String appId;
        private String timeStamp;
        private String sjzf;
        private String partnerId;
        private String yezf;
        private String nonceStr;
        private String prepayId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getSjzf() {
            return sjzf;
        }

        public void setSjzf(String sjzf) {
            this.sjzf = sjzf;
        }

        public String getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(String partnerId) {
            this.partnerId = partnerId;
        }

        public String getYezf() {
            return yezf;
        }

        public void setYezf(String yezf) {
            this.yezf = yezf;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }
    }


//    /**
//     * bring : {"id":"52cc84e70b734f679603ab066bafd518","sign":"E2401E7B738C09F38CAA6102B7FB8AAE6918775CB3082B5BD79B66B7043A9F01","timeStamp":"1514803328","partnerId":"wxc767e7fcd10bb1ac","nonceStr":"EeHZPRED0HAv18mB","prepayId":"wx20180101184208396711c5b80361044441"}
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
//         * id : 52cc84e70b734f679603ab066bafd518
//         * sign : E2401E7B738C09F38CAA6102B7FB8AAE6918775CB3082B5BD79B66B7043A9F01
//         * timeStamp : 1514803328
//         * partnerId : wxc767e7fcd10bb1ac
//         * nonceStr : EeHZPRED0HAv18mB
//         * prepayId : wx20180101184208396711c5b80361044441
//         */
//
//        private String id;
//        private String sign;
//        private String timeStamp;
//        private String partnerId;
//        private String nonceStr;
//        private String prepayId;
//
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getSign() {
//            return sign;
//        }
//
//        public void setSign(String sign) {
//            this.sign = sign;
//        }
//
//        public String getTimeStamp() {
//            return timeStamp;
//        }
//
//        public void setTimeStamp(String timeStamp) {
//            this.timeStamp = timeStamp;
//        }
//
//        public String getPartnerId() {
//            return partnerId;
//        }
//
//        public void setPartnerId(String partnerId) {
//            this.partnerId = partnerId;
//        }
//
//        public String getNonceStr() {
//            return nonceStr;
//        }
//
//        public void setNonceStr(String nonceStr) {
//            this.nonceStr = nonceStr;
//        }
//
//        public String getPrepayId() {
//            return prepayId;
//        }
//
//        public void setPrepayId(String prepayId) {
//            this.prepayId = prepayId;
//        }
//    }


//
//    /**
//     * bring : {"sign":"23167AEECBF447345F5CC4240BB00A6B3B2285E0CC858B339D7FA7612F9B867D","timeStamp":"1511337972","partnerId":"wxc767e7fcd10bb1ac","nonceStr":"8LMEyQmZWVTlyoOI","prepayId":"wx201711221606125b214ff1ae0300852106"}
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
//         * sign : 23167AEECBF447345F5CC4240BB00A6B3B2285E0CC858B339D7FA7612F9B867D
//         * timeStamp : 1511337972
//         * partnerId : wxc767e7fcd10bb1ac
//         * nonceStr : 8LMEyQmZWVTlyoOI
//         * prepayId : wx201711221606125b214ff1ae0300852106
//         */
//
//        private String sign;
//        private String timeStamp;
//        private String partnerId;
//        private String nonceStr;
//        private String prepayId;
//
//        public String getSign() {
//            return sign;
//        }
//
//        public void setSign(String sign) {
//            this.sign = sign;
//        }
//
//        public String getTimeStamp() {
//            return timeStamp;
//        }
//
//        public void setTimeStamp(String timeStamp) {
//            this.timeStamp = timeStamp;
//        }
//
//        public String getPartnerId() {
//            return partnerId;
//        }
//
//        public void setPartnerId(String partnerId) {
//            this.partnerId = partnerId;
//        }
//
//        public String getNonceStr() {
//            return nonceStr;
//        }
//
//        public void setNonceStr(String nonceStr) {
//            this.nonceStr = nonceStr;
//        }
//
//        public String getPrepayId() {
//            return prepayId;
//        }
//
//        public void setPrepayId(String prepayId) {
//            this.prepayId = prepayId;
//        }
//
//        @Override
//        public String toString() {
//            return "BringBean{" +
//                    "sign='" + sign + '\'' +
//                    ", timeStamp='" + timeStamp + '\'' +
//                    ", partnerId='" + partnerId + '\'' +
//                    ", nonceStr='" + nonceStr + '\'' +
//                    ", prepayId='" + prepayId + '\'' +
//                    '}';
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "PayWXRespParaBean{" +
//                "bring=" + bring +
//                '}';
//    }
}
