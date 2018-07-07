package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/6/4.
 */

public class DailyRecordRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"id":"0d20f8bb98f8442eb9539e73ed96b26b","dailyCode":"DAY0064","carNumber":"青A92351","driverName":"","driverCode":null,"driverTel":"","carSafteyName":"李永高","carSafteyCode":null,"carSafteyTel":"13519703320","carOilAmount":null,"carDeliveryNums":"null","carSupplyAmount":"3010.0000","onlinePay":"null","carOrderAmount":"null","userIndentAmount":"null","accountPay":"null","cashPay":"null","payable":"null","hasPay":"null","deliveryNums":"null","deliveryConfirm":"0","deliveryNoConfirm":"null","dissentDesc":null,"settlemenStart":"2018-06-02 18:23:05","settlemenEnd":"2018-06-02 18:24:14","payStatus":"0","cuser":"","cdt":"2018-06-02 18:24:50","uuser":null,"auditDesc":null,"udt":null,"status":null}
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
         * id : 0d20f8bb98f8442eb9539e73ed96b26b
         * dailyCode : DAY0064
         * carNumber : 青A92351
         * driverName :
         * driverCode : null
         * driverTel :
         * carSafteyName : 李永高
         * carSafteyCode : null
         * carSafteyTel : 13519703320
         * carOilAmount : null
         * carDeliveryNums : null
         * carSupplyAmount : 3010.0000
         * onlinePay : null
         * carOrderAmount : null
         * userIndentAmount : null
         * accountPay : null
         * cashPay : null
         * payable : null
         * hasPay : null
         * deliveryNums : null
         * deliveryConfirm : 0
         * deliveryNoConfirm : null
         * dissentDesc : null
         * settlemenStart : 2018-06-02 18:23:05
         * settlemenEnd : 2018-06-02 18:24:14
         * payStatus : 0
         * cuser :
         * cdt : 2018-06-02 18:24:50
         * uuser : null
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
        private String deliveryPayNums;
        private String payable_show;

        public String getPayable_show() {
            return payable_show;
        }

        public void setPayable_show(String payable_show) {
            this.payable_show = payable_show;
        }

        public String getDeliveryPayNums() {
            return deliveryPayNums;
        }

        public void setDeliveryPayNums(String deliveryPayNums) {
            this.deliveryPayNums = deliveryPayNums;
        }

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
