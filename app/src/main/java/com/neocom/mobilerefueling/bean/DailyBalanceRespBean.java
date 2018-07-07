package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/31.
 * <p>
 * 查询所有结算记录 返回
 */

public class DailyBalanceRespBean extends BaseBean {


    /**
     * code : null
     * bring : [{"id":"d24b62f7af1c49c58a5cd9665d18858e","dailyCode":"DAY0053","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"0.0000","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":"超低价家酒店巴登巴登内诶","settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"2","cuser":"李永高","cdt":"2018-05-31 14:10:34","uuser":"17c4520f6cfd1ab53d8745e84681eb49","auditDesc":null,"udt":null,"status":null},{"id":"d57bd0d6160f4a1d88887b750adcdce7","dailyCode":"DAY0050","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0.00","carOrderAmount":"2704.00","userIndentAmount":"0.00","accountPay":"0","cashPay":"0.00","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":null,"settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"2","cuser":"李永高","cdt":"2018-05-31 11:21:16","uuser":"17c4520f6cfd1ab53d8745e84681eb49","auditDesc":"6666","udt":null,"status":null},{"id":"e2f7db136f7e4640a43c343d7267d356","dailyCode":"DAY0058","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"39019.3100","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":"1577777","settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"1","cuser":"李永高","cdt":"2018-06-01 15:56:37","uuser":null,"auditDesc":null,"udt":null,"status":null},{"id":"f1104a6e6d8a4ff8998bc1111b1b9299","dailyCode":"DAY0052","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"0.0000","userIndentAmount":null,"accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":null,"settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"2","cuser":"李永高","cdt":"2018-05-31 14:01:41","uuser":"4ed9a8a55da841df8f7517c508d90c35","auditDesc":null,"udt":null,"status":null},{"id":"0e9d379b590242c9bddf134852eb80c9","dailyCode":"DAY0049","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"0.0000","userIndentAmount":null,"accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":null,"settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"0","cuser":"李永高","cdt":"2018-05-31 11:09:04","uuser":null,"auditDesc":null,"udt":null,"status":null},{"id":"244c56368fa04602ad7158e0d111edbc","dailyCode":"DAY0057","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"39019.3100","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":"g\u2006g","settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"1","cuser":"李永高","cdt":"2018-06-01 14:06:26","uuser":null,"auditDesc":null,"udt":null,"status":null},{"id":"6b3dde05a1824205bb937a61c90395d2","dailyCode":"DAY0051","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"022","carOrderAmount":"360.0000","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":null,"settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"2","cuser":"李永高","cdt":"2018-05-31 13:49:01","uuser":"17c4520f6cfd1ab53d8745e84681eb49","auditDesc":"888","udt":null,"status":null},{"id":"94a135dcfc6749f19afe7a44671c4d94","dailyCode":"DAY0054","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"360.0000","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":"　6月9日至10日，上海合作组织成员国元首理事会第十八次会议将在山东省青岛市举行。中国国家主席习近平将主持会议并举行相关活动。","settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"2","cuser":"李永高","cdt":"2018-05-31 17:39:53","uuser":"17c4520f6cfd1ab53d8745e84681eb49","auditDesc":"6月9日至10日，上海合作组织成员国元首理事会第十八次会议将在山东省青岛市举行。中国国家主席习近平将主持会议并举行相关活动。6月9日至10日，上海合作组织成员国元首理事会第十八次会议将在山东省青岛市举行。中国国家主席习近平将主持会议并举行相关活动。6月9日至10日，上海合作组织成员国元首理事会第十八次会议将在山东省青岛市举行。中国国家主席习近平将主持会议并举行相关活动。","udt":null,"status":null},{"id":"4c486d51e60e49b68fe3ebc97cbcce28","dailyCode":"DAY0056","carNumber":"青A92351","driverName":"测试司机","driverCode":null,"driverTel":"18953186913","carSafteyName":"车占福","carSafteyCode":null,"carSafteyTel":"15003609858","carOilAmount":null,"carDeliveryNums":"12","carSupplyAmount":"3010.0000","onlinePay":"0","carOrderAmount":"39019.3100","userIndentAmount":"0","accountPay":"0","cashPay":"0","payable":"0","hasPay":null,"deliveryNums":"0","deliveryConfirm":"0","deliveryNoConfirm":"0","dissentDesc":"除进行考察阶段","settlemenStart":"2018-05-05 09:48:18","settlemenEnd":"2018-05-21 09:47:51","payStatus":"1","cuser":"李永高","cdt":"2018-06-01 13:56:34","uuser":null,"auditDesc":null,"udt":null,"status":null}]
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
         * id : d24b62f7af1c49c58a5cd9665d18858e
         * dailyCode : DAY0053
         * carNumber : 青A92351
         * driverName : 测试司机
         * driverCode : null
         * driverTel : 18953186913
         * carSafteyName : 车占福
         * carSafteyCode : null
         * carSafteyTel : 15003609858
         * carOilAmount : null
         * carDeliveryNums : 12
         * carSupplyAmount : 3010.0000
         * onlinePay : 0
         * carOrderAmount : 0.0000
         * userIndentAmount : 0
         * accountPay : 0
         * cashPay : 0
         * payable : 0
         * hasPay : null
         * deliveryNums : 0
         * deliveryConfirm : 0
         * deliveryNoConfirm : 0
         * dissentDesc : 超低价家酒店巴登巴登内诶
         * settlemenStart : 2018-05-05 09:48:18
         * settlemenEnd : 2018-05-21 09:47:51
         * payStatus : 2
         * cuser : 李永高
         * cdt : 2018-05-31 14:10:34
         * uuser : 17c4520f6cfd1ab53d8745e84681eb49
         * auditDesc : null
         * udt : null
         * status : null
         */

        private String id;
        private String dailyCode;
        private String carNumber;
        private String driverName;
        private String driverCode;
        private String driverTel;
        private String carSafteyName;
        private String carSafteyCode;
        private String carSafteyTel;
        private String carOilAmount;
        private String carDeliveryNums;
        private String carSupplyAmount;
        private String onlinePay;
        private String carOrderAmount;
        private String userIndentAmount;
        private String accountPay;
        private String cashPay;
        private String payable;
        private String hasPay;
        private String deliveryNums;
        private String deliveryConfirm;
        private String deliveryNoConfirm;
        private String dissentDesc;
        private String settlemenStart;
        private String settlemenEnd;
        private String payStatus;
        private String cuser;
        private String cdt;
        private String uuser;
        private String auditDesc;
        private String udt;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDailyCode() {
            return dailyCode;
        }

        public void setDailyCode(String dailyCode) {
            this.dailyCode = dailyCode;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getDriverTel() {
            return driverTel;
        }

        public void setDriverTel(String driverTel) {
            this.driverTel = driverTel;
        }

        public String getCarSafteyName() {
            return carSafteyName;
        }

        public void setCarSafteyName(String carSafteyName) {
            this.carSafteyName = carSafteyName;
        }

        public String getCarSafteyCode() {
            return carSafteyCode;
        }

        public void setCarSafteyCode(String carSafteyCode) {
            this.carSafteyCode = carSafteyCode;
        }

        public String getCarSafteyTel() {
            return carSafteyTel;
        }

        public void setCarSafteyTel(String carSafteyTel) {
            this.carSafteyTel = carSafteyTel;
        }

        public String getCarOilAmount() {
            return carOilAmount;
        }

        public void setCarOilAmount(String carOilAmount) {
            this.carOilAmount = carOilAmount;
        }

        public String getCarDeliveryNums() {
            return carDeliveryNums;
        }

        public void setCarDeliveryNums(String carDeliveryNums) {
            this.carDeliveryNums = carDeliveryNums;
        }

        public String getCarSupplyAmount() {
            return carSupplyAmount;
        }

        public void setCarSupplyAmount(String carSupplyAmount) {
            this.carSupplyAmount = carSupplyAmount;
        }

        public String getOnlinePay() {
            return onlinePay;
        }

        public void setOnlinePay(String onlinePay) {
            this.onlinePay = onlinePay;
        }

        public String getCarOrderAmount() {
            return carOrderAmount;
        }

        public void setCarOrderAmount(String carOrderAmount) {
            this.carOrderAmount = carOrderAmount;
        }

        public String getUserIndentAmount() {
            return userIndentAmount;
        }

        public void setUserIndentAmount(String userIndentAmount) {
            this.userIndentAmount = userIndentAmount;
        }

        public String getAccountPay() {
            return accountPay;
        }

        public void setAccountPay(String accountPay) {
            this.accountPay = accountPay;
        }

        public String getCashPay() {
            return cashPay;
        }

        public void setCashPay(String cashPay) {
            this.cashPay = cashPay;
        }

        public String getPayable() {
            return payable;
        }

        public void setPayable(String payable) {
            this.payable = payable;
        }

        public String getHasPay() {
            return hasPay;
        }

        public void setHasPay(String hasPay) {
            this.hasPay = hasPay;
        }

        public String getDeliveryNums() {
            return deliveryNums;
        }

        public void setDeliveryNums(String deliveryNums) {
            this.deliveryNums = deliveryNums;
        }

        public String getDeliveryConfirm() {
            return deliveryConfirm;
        }

        public void setDeliveryConfirm(String deliveryConfirm) {
            this.deliveryConfirm = deliveryConfirm;
        }

        public String getDeliveryNoConfirm() {
            return deliveryNoConfirm;
        }

        public void setDeliveryNoConfirm(String deliveryNoConfirm) {
            this.deliveryNoConfirm = deliveryNoConfirm;
        }

        public String getDissentDesc() {
            return dissentDesc;
        }

        public void setDissentDesc(String dissentDesc) {
            this.dissentDesc = dissentDesc;
        }

        public String getSettlemenStart() {
            return settlemenStart;
        }

        public void setSettlemenStart(String settlemenStart) {
            this.settlemenStart = settlemenStart;
        }

        public String getSettlemenEnd() {
            return settlemenEnd;
        }

        public void setSettlemenEnd(String settlemenEnd) {
            this.settlemenEnd = settlemenEnd;
        }

        public String getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(String payStatus) {
            this.payStatus = payStatus;
        }

        public String getCuser() {
            return cuser;
        }

        public void setCuser(String cuser) {
            this.cuser = cuser;
        }

        public String getCdt() {
            return cdt;
        }

        public void setCdt(String cdt) {
            this.cdt = cdt;
        }

        public String getUuser() {
            return uuser;
        }

        public void setUuser(String uuser) {
            this.uuser = uuser;
        }

        public String getAuditDesc() {
            return auditDesc;
        }

        public void setAuditDesc(String auditDesc) {
            this.auditDesc = auditDesc;
        }

        public String getUdt() {
            return udt;
        }

        public void setUdt(String udt) {
            this.udt = udt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
