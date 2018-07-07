package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/30.
 */

public class DeliveryOrderRespBean extends BaseBean {
    /**
     * code : null
     * bring : {"id":"f922395493fa4e468b36c6e126890dca","deliveryCode":"D20180611000004","indentCode":"O20180611000004","estimateTime":"2018-06-11 10:32","carIds":null,"indentId":"07d260b76ec04149809cc3817cad5b65","indentStatus":null,"estimateCost":"0.00","realCost":null,"oilCarId":"91732e63c1004f4a8a4fae0ca95c3a35","senderName":"临时车辆司机","senderPhone":"15725100021","carNum":"宁C53236","deliveryId":"74ca8d25bfa24d4a965b95d9abbcd70e","deliveryName":"宫丹菊","telphone":null,"deliveryTime":null,"receiveTime":"2018-06-11 09:35:03","estimateArrivalTime":"2018-06-11 09:33:29","confirmTime":null,"oilAmount":"20.00吨","oilType":"2","oilTypeName":"0号柴油","oilCost":"6300元/吨","finishTime":null,"finishPerson":null,"paymentPerson":null,"paymentTime":null,"deliveryAddress":"青海省西宁市湟中县甘河滩工业园区西区大美煤业沙场","areaCode":"630000","payType":null,"payAmount":null,"remark":null,"delevaStatus":null,"orderTime":"2018-06-11 09:34:25","receiverName":"张俄邦","orderTel":"13997337223","status":"1","nationalStandard":"4","nationalStandardName":"国五","dstate":"6","addressCoor":"101.52504756635884,36.55244457152087","c_user":"4b54cbcb1855467f847e2c64ef8f4030","c_dt":"2018-06-11 09:34:25","u_user":null,"u_dt":null,"batchId":null,"orderStatusName":null,"timeLong":null,"settleUnit":"1","oilAmount_t":"20000.0","carList":[],"remarkList":[{"id":"e28caa6637cd4959b9ea20694a5d8fec","deliveryOrderId":"f922395493fa4e468b36c6e126890dca","text":"","status":"1","addUser":"4b54cbcb1855467f847e2c64ef8f4030","addTime":"2018-06-11 09:34:25","editUser":null,"editTime":null},{"id":"475bfbbb9abf4f33ac39c9d523b3cead","deliveryOrderId":"f922395493fa4e468b36c6e126890dca","text":"","status":"1","addUser":"87342145f3514103ac9f4d03405bdf42","addTime":"2018-06-11 09:35:03","editUser":null,"editTime":null}],"evaluationList":null,"customerSale":{"id":"ae5504872b0843bdbfe901b047947b05","customerId":"7415d36e7d4846199e56f7be5fe670f6","province":"630000","oilType":"2","guidePrice":"5.75","nationalStandard":"4","discountAmount":"0.25","performAmount":"5.5","performAmount_t":"6300","status":"1","c_user":null,"c_dt":"2018-05-31","u_user":null,"u_dt":null}}
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
         * id : f922395493fa4e468b36c6e126890dca
         * deliveryCode : D20180611000004
         * indentCode : O20180611000004
         * estimateTime : 2018-06-11 10:32
         * carIds : null
         * indentId : 07d260b76ec04149809cc3817cad5b65
         * indentStatus : null
         * estimateCost : 0.00
         * realCost : null
         * oilCarId : 91732e63c1004f4a8a4fae0ca95c3a35
         * senderName : 临时车辆司机
         * senderPhone : 15725100021
         * carNum : 宁C53236
         * deliveryId : 74ca8d25bfa24d4a965b95d9abbcd70e
         * deliveryName : 宫丹菊
         * telphone : null
         * deliveryTime : null
         * receiveTime : 2018-06-11 09:35:03
         * estimateArrivalTime : 2018-06-11 09:33:29
         * confirmTime : null
         * oilAmount : 20.00吨
         * oilType : 2
         * oilTypeName : 0号柴油
         * oilCost : 6300元/吨
         * finishTime : null
         * finishPerson : null
         * paymentPerson : null
         * paymentTime : null
         * deliveryAddress : 青海省西宁市湟中县甘河滩工业园区西区大美煤业沙场
         * areaCode : 630000
         * payType : null
         * payAmount : null
         * remark : null
         * delevaStatus : null
         * orderTime : 2018-06-11 09:34:25
         * receiverName : 张俄邦
         * orderTel : 13997337223
         * status : 1
         * nationalStandard : 4
         * nationalStandardName : 国五
         * dstate : 6
         * addressCoor : 101.52504756635884,36.55244457152087
         * c_user : 4b54cbcb1855467f847e2c64ef8f4030
         * c_dt : 2018-06-11 09:34:25
         * u_user : null
         * u_dt : null
         * batchId : null
         * orderStatusName : null
         * timeLong : null
         * settleUnit : 1
         * oilAmount_t : 20000.0
         * carList : []
         * remarkList : [{"id":"e28caa6637cd4959b9ea20694a5d8fec","deliveryOrderId":"f922395493fa4e468b36c6e126890dca","text":"","status":"1","addUser":"4b54cbcb1855467f847e2c64ef8f4030","addTime":"2018-06-11 09:34:25","editUser":null,"editTime":null},{"id":"475bfbbb9abf4f33ac39c9d523b3cead","deliveryOrderId":"f922395493fa4e468b36c6e126890dca","text":"","status":"1","addUser":"87342145f3514103ac9f4d03405bdf42","addTime":"2018-06-11 09:35:03","editUser":null,"editTime":null}]
         * evaluationList : null
         * customerSale : {"id":"ae5504872b0843bdbfe901b047947b05","customerId":"7415d36e7d4846199e56f7be5fe670f6","province":"630000","oilType":"2","guidePrice":"5.75","nationalStandard":"4","discountAmount":"0.25","performAmount":"5.5","performAmount_t":"6300","status":"1","c_user":null,"c_dt":"2018-05-31","u_user":null,"u_dt":null}
         */

        private String id;
        private String deliveryCode;
        private String indentCode;
        private String estimateTime;
        private String carIds;
        private String indentId;
        private String indentStatus;
        private String estimateCost;
        private String realCost;
        private String oilCarId;
        private String senderName;
        private String senderPhone;
        private String carNum;
        private String deliveryId;
        private String deliveryName;
        private String telphone;
        private String deliveryTime;
        private String receiveTime;
        private String estimateArrivalTime;
        private String confirmTime;
        private String oilAmount;
        private String oilType;
        private String oilTypeName;
        private String oilCost;
        private String finishTime;
        private String finishPerson;
        private String paymentPerson;
        private String paymentTime;
        private String deliveryAddress;
        private String areaCode;
        private String payType;
        private String payAmount;
        private String remark;
        private String delevaStatus;
        private String orderTime;
        private String receiverName;
        private String orderTel;
        private String status;
        private String nationalStandard;
        private String nationalStandardName;
        private String dstate;
        private String addressCoor;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private String batchId;
        private String orderStatusName;
        private String timeLong;
        private String settleUnit;
        private String oilAmount_t;
        private String evaluationList;
        private CustomerSaleBean customerSale;
        //        private List<?> carList;
        private List<CarListBean> carList;
        private List<RemarkListBean> remarkList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDeliveryCode() {
            return deliveryCode;
        }

        public void setDeliveryCode(String deliveryCode) {
            this.deliveryCode = deliveryCode;
        }

        public String getIndentCode() {
            return indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getEstimateTime() {
            return estimateTime;
        }

        public void setEstimateTime(String estimateTime) {
            this.estimateTime = estimateTime;
        }

        public String getCarIds() {
            return carIds;
        }

        public void setCarIds(String carIds) {
            this.carIds = carIds;
        }

        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        public String getIndentStatus() {
            return indentStatus;
        }

        public void setIndentStatus(String indentStatus) {
            this.indentStatus = indentStatus;
        }

        public String getEstimateCost() {
            return estimateCost;
        }

        public void setEstimateCost(String estimateCost) {
            this.estimateCost = estimateCost;
        }

        public String getRealCost() {
            return realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getOilCarId() {
            return oilCarId;
        }

        public void setOilCarId(String oilCarId) {
            this.oilCarId = oilCarId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getSenderPhone() {
            return senderPhone;
        }

        public void setSenderPhone(String senderPhone) {
            this.senderPhone = senderPhone;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getDeliveryId() {
            return deliveryId;
        }

        public void setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        public void setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getReceiveTime() {
            return receiveTime;
        }

        public void setReceiveTime(String receiveTime) {
            this.receiveTime = receiveTime;
        }

        public String getEstimateArrivalTime() {
            return estimateArrivalTime;
        }

        public void setEstimateArrivalTime(String estimateArrivalTime) {
            this.estimateArrivalTime = estimateArrivalTime;
        }

        public String getConfirmTime() {
            return confirmTime;
        }

        public void setConfirmTime(String confirmTime) {
            this.confirmTime = confirmTime;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getOilCost() {
            return oilCost;
        }

        public void setOilCost(String oilCost) {
            this.oilCost = oilCost;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public String getFinishPerson() {
            return finishPerson;
        }

        public void setFinishPerson(String finishPerson) {
            this.finishPerson = finishPerson;
        }

        public String getPaymentPerson() {
            return paymentPerson;
        }

        public void setPaymentPerson(String paymentPerson) {
            this.paymentPerson = paymentPerson;
        }

        public String getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(String paymentTime) {
            this.paymentTime = paymentTime;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDelevaStatus() {
            return delevaStatus;
        }

        public void setDelevaStatus(String delevaStatus) {
            this.delevaStatus = delevaStatus;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getOrderTel() {
            return orderTel;
        }

        public void setOrderTel(String orderTel) {
            this.orderTel = orderTel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getDstate() {
            return dstate;
        }

        public void setDstate(String dstate) {
            this.dstate = dstate;
        }

        public String getAddressCoor() {
            return addressCoor;
        }

        public void setAddressCoor(String addressCoor) {
            this.addressCoor = addressCoor;
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

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getOrderStatusName() {
            return orderStatusName;
        }

        public void setOrderStatusName(String orderStatusName) {
            this.orderStatusName = orderStatusName;
        }

        public String getTimeLong() {
            return timeLong;
        }

        public void setTimeLong(String timeLong) {
            this.timeLong = timeLong;
        }

        public String getSettleUnit() {
            return settleUnit;
        }

        public void setSettleUnit(String settleUnit) {
            this.settleUnit = settleUnit;
        }

        public String getOilAmount_t() {
            return oilAmount_t;
        }

        public void setOilAmount_t(String oilAmount_t) {
            this.oilAmount_t = oilAmount_t;
        }

        public String getEvaluationList() {
            return evaluationList;
        }

        public void setEvaluationList(String evaluationList) {
            this.evaluationList = evaluationList;
        }

        public CustomerSaleBean getCustomerSale() {
            return customerSale;
        }

        public void setCustomerSale(CustomerSaleBean customerSale) {
            this.customerSale = customerSale;
        }

        public List<CarListBean> getCarList() {
            return carList;
        }

        public void setCarList(List<CarListBean> carList) {
            this.carList = carList;
        }

        public List<RemarkListBean> getRemarkList() {
            return remarkList;
        }

        public void setRemarkList(List<RemarkListBean> remarkList) {
            this.remarkList = remarkList;
        }

        public static class CustomerSaleBean {
            /**
             * id : ae5504872b0843bdbfe901b047947b05
             * customerId : 7415d36e7d4846199e56f7be5fe670f6
             * province : 630000
             * oilType : 2
             * guidePrice : 5.75
             * nationalStandard : 4
             * discountAmount : 0.25
             * performAmount : 5.5
             * performAmount_t : 6300
             * status : 1
             * c_user : null
             * c_dt : 2018-05-31
             * u_user : null
             * u_dt : null
             */

            private String id;
            private String customerId;
            private String province;
            private String oilType;
            private String guidePrice;
            private String nationalStandard;
            private String discountAmount;
            private String performAmount;
            private String performAmount_t;
            private String status;
            private String c_user;
            private String c_dt;
            private String u_user;
            private String u_dt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public String getGuidePrice() {
                return guidePrice;
            }

            public void setGuidePrice(String guidePrice) {
                this.guidePrice = guidePrice;
            }

            public String getNationalStandard() {
                return nationalStandard;
            }

            public void setNationalStandard(String nationalStandard) {
                this.nationalStandard = nationalStandard;
            }

            public String getDiscountAmount() {
                return discountAmount;
            }

            public void setDiscountAmount(String discountAmount) {
                this.discountAmount = discountAmount;
            }

            public String getPerformAmount() {
                return performAmount;
            }

            public void setPerformAmount(String performAmount) {
                this.performAmount = performAmount;
            }

            public String getPerformAmount_t() {
                return performAmount_t;
            }

            public void setPerformAmount_t(String performAmount_t) {
                this.performAmount_t = performAmount_t;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public String getU_user() {
                return u_user;
            }

            public void setU_user(String u_user) {
                this.u_user = u_user;
            }

            public String getU_dt() {
                return u_dt;
            }

            public void setU_dt(String u_dt) {
                this.u_dt = u_dt;
            }
        }


        public static class CarListBean {
            /**
             * id : 9355b28768c44b228a15264cb19407c3
             * relateId : 5f41227568c14f599d48d5f42ef64f9b
             * relateType : 1
             * vehicleCode : 桶2
             * pName : null
             * telphone : 
             * oilType : 2
             * nationalStandard : 4
             * nationalStandardName : 国五
             * tankSize : 50
             * num : 0
             * finishTime : 2018-06-11 10:29:38
             * oilBalance : 5.50
             * oilBalance_show : 5.50元/升
             * tankSize_show : 50升
             * oilTotal : 275
             * fillTime : null
             * oilTypeName : 0号柴油
             * dstate : 1
             * docType : 0
             * settleUnit : 0
             * oilAmount_t : 42.0000
             * status : 1
             * c_user : null
             * c_dt : 2018-06-11 10:39:47
             * u_user : null
             * u_dt : 
             */

            private String id;
            private String relateId;
            private String relateType;
            private String vehicleCode;
            private String pName;
            private String telphone;
            private String oilType;
            private String nationalStandard;
            private String nationalStandardName;
            private String tankSize;
            private String num;
            private String finishTime;
            private String oilBalance;
            private String oilBalance_show;
            private String tankSize_show;
            private String oilTotal;
            private String fillTime;
            private String oilTypeName;
            private String dstate;
            private String docType;
            private String settleUnit;
            private String oilAmount_t;
            private String status;
            private String c_user;
            private String c_dt;
            private String u_user;
            private String u_dt;
            private String oilTotal_show;

            public String getOilTotal_show() {
                return oilTotal_show;
            }

            public void setOilTotal_show(String oilTotal_show) {
                this.oilTotal_show = oilTotal_show;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRelateId() {
                return relateId;
            }

            public void setRelateId(String relateId) {
                this.relateId = relateId;
            }

            public String getRelateType() {
                return relateType;
            }

            public void setRelateType(String relateType) {
                this.relateType = relateType;
            }

            public String getVehicleCode() {
                return vehicleCode;
            }

            public void setVehicleCode(String vehicleCode) {
                this.vehicleCode = vehicleCode;
            }

            public String getPName() {
                return pName;
            }

            public void setPName(String pName) {
                this.pName = pName;
            }

            public String getTelphone() {
                return telphone;
            }

            public void setTelphone(String telphone) {
                this.telphone = telphone;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
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

            public String getTankSize() {
                return tankSize;
            }

            public void setTankSize(String tankSize) {
                this.tankSize = tankSize;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(String finishTime) {
                this.finishTime = finishTime;
            }

            public String getOilBalance() {
                return oilBalance;
            }

            public void setOilBalance(String oilBalance) {
                this.oilBalance = oilBalance;
            }

            public String getOilBalance_show() {
                return oilBalance_show;
            }

            public void setOilBalance_show(String oilBalance_show) {
                this.oilBalance_show = oilBalance_show;
            }

            public String getTankSize_show() {
                return tankSize_show;
            }

            public void setTankSize_show(String tankSize_show) {
                this.tankSize_show = tankSize_show;
            }

            public String getOilTotal() {
                return oilTotal;
            }

            public void setOilTotal(String oilTotal) {
                this.oilTotal = oilTotal;
            }

            public String getFillTime() {
                return fillTime;
            }

            public void setFillTime(String fillTime) {
                this.fillTime = fillTime;
            }

            public String getOilTypeName() {
                return oilTypeName;
            }

            public void setOilTypeName(String oilTypeName) {
                this.oilTypeName = oilTypeName;
            }

            public String getDstate() {
                return dstate;
            }

            public void setDstate(String dstate) {
                this.dstate = dstate;
            }

            public String getDocType() {
                return docType;
            }

            public void setDocType(String docType) {
                this.docType = docType;
            }

            public String getSettleUnit() {
                return settleUnit;
            }

            public void setSettleUnit(String settleUnit) {
                this.settleUnit = settleUnit;
            }

            public String getOilAmount_t() {
                return oilAmount_t;
            }

            public void setOilAmount_t(String oilAmount_t) {
                this.oilAmount_t = oilAmount_t;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public String getU_user() {
                return u_user;
            }

            public void setU_user(String u_user) {
                this.u_user = u_user;
            }

            public String getU_dt() {
                return u_dt;
            }

            public void setU_dt(String u_dt) {
                this.u_dt = u_dt;
            }


//            /**
//             * id : 4aeddcd5e829416bad827d22937ddf0b
//             * relateId : e50c9b4940ba41feb1a63ea58048b752
//             * relateType : 1
//             * vehicleCode : 青A92351
//             * pName : null
//             * telphone :
//             * oilType : 3
//             * nationalStandard : 4
//             * nationalStandardName : 国五
//             * tankSize : 211
//             * num : 0
//             * finishTime : 2018-01-09 10:30:50
//             * oilBalance : 6.24
//             * oilTotal : 1316.64
//             * fillTime : null
//             * oilTypeName : -10号柴油
//             * dstate : 1
//             * docType : 0
//             * status : 1
//             * c_user : null
//             * c_dt : 2018-01-09 10:30:58
//             * u_user : null
//             * u_dt :
//             */
//
//            private String id;
//            private String relateId;
//            private String relateType;
//            private String vehicleCode;
//            private String pName;
//            private String telphone;
//            private String oilType;
//            private String nationalStandard;
//            private String nationalStandardName;
//            private String tankSize;
//            private String num;
//            private String finishTime;
//            private String oilBalance;
//            private String oilTotal;
//            private String fillTime;
//            private String oilTypeName;
//            private String dstate;
//            private String docType;
//            private String status;
//            private String c_user;
//            private String c_dt;
//            private String u_user;
//            private String u_dt;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getRelateId() {
//                return relateId;
//            }
//
//            public void setRelateId(String relateId) {
//                this.relateId = relateId;
//            }
//
//            public String getRelateType() {
//                return relateType;
//            }
//
//            public void setRelateType(String relateType) {
//                this.relateType = relateType;
//            }
//
//            public String getVehicleCode() {
//                return vehicleCode;
//            }
//
//            public void setVehicleCode(String vehicleCode) {
//                this.vehicleCode = vehicleCode;
//            }
//
//            public String getPName() {
//                return pName;
//            }
//
//            public void setPName(String pName) {
//                this.pName = pName;
//            }
//
//            public String getTelphone() {
//                return telphone;
//            }
//
//            public void setTelphone(String telphone) {
//                this.telphone = telphone;
//            }
//
//            public String getOilType() {
//                return oilType;
//            }
//
//            public void setOilType(String oilType) {
//                this.oilType = oilType;
//            }
//
//            public String getNationalStandard() {
//                return nationalStandard;
//            }
//
//            public void setNationalStandard(String nationalStandard) {
//                this.nationalStandard = nationalStandard;
//            }
//
//            public String getNationalStandardName() {
//                return nationalStandardName;
//            }
//
//            public void setNationalStandardName(String nationalStandardName) {
//                this.nationalStandardName = nationalStandardName;
//            }
//
//            public String getTankSize() {
//                return tankSize;
//            }
//
//            public void setTankSize(String tankSize) {
//                this.tankSize = tankSize;
//            }
//
//            public String getNum() {
//                return num;
//            }
//
//            public void setNum(String num) {
//                this.num = num;
//            }
//
//            public String getFinishTime() {
//                return finishTime;
//            }
//
//            public void setFinishTime(String finishTime) {
//                this.finishTime = finishTime;
//            }
//
//            public String getOilBalance() {
//                return oilBalance;
//            }
//
//            public void setOilBalance(String oilBalance) {
//                this.oilBalance = oilBalance;
//            }
//
//            public String getOilTotal() {
//                return oilTotal;
//            }
//
//            public void setOilTotal(String oilTotal) {
//                this.oilTotal = oilTotal;
//            }
//
//            public String getFillTime() {
//                return fillTime;
//            }
//
//            public void setFillTime(String fillTime) {
//                this.fillTime = fillTime;
//            }
//
//            public String getOilTypeName() {
//                return oilTypeName;
//            }
//
//            public void setOilTypeName(String oilTypeName) {
//                this.oilTypeName = oilTypeName;
//            }
//
//            public String getDstate() {
//                return dstate;
//            }
//
//            public void setDstate(String dstate) {
//                this.dstate = dstate;
//            }
//
//            public String getDocType() {
//                return docType;
//            }
//
//            public void setDocType(String docType) {
//                this.docType = docType;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getC_user() {
//                return c_user;
//            }
//
//            public void setC_user(String c_user) {
//                this.c_user = c_user;
//            }
//
//            public String getC_dt() {
//                return c_dt;
//            }
//
//            public void setC_dt(String c_dt) {
//                this.c_dt = c_dt;
//            }
//
//            public String getU_user() {
//                return u_user;
//            }
//
//            public void setU_user(String u_user) {
//                this.u_user = u_user;
//            }
//
//            public String getU_dt() {
//                return u_dt;
//            }
//
//            public void setU_dt(String u_dt) {
//                this.u_dt = u_dt;
//            }
        }


        public static class RemarkListBean {
            /**
             * id : e28caa6637cd4959b9ea20694a5d8fec
             * deliveryOrderId : f922395493fa4e468b36c6e126890dca
             * text :
             * status : 1
             * addUser : 4b54cbcb1855467f847e2c64ef8f4030
             * addTime : 2018-06-11 09:34:25
             * editUser : null
             * editTime : null
             */

            private String id;
            private String deliveryOrderId;
            private String text;
            private String status;
            private String addUser;
            private String addTime;
            private String editUser;
            private String editTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDeliveryOrderId() {
                return deliveryOrderId;
            }

            public void setDeliveryOrderId(String deliveryOrderId) {
                this.deliveryOrderId = deliveryOrderId;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getAddUser() {
                return addUser;
            }

            public void setAddUser(String addUser) {
                this.addUser = addUser;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getEditUser() {
                return editUser;
            }

            public void setEditUser(String editUser) {
                this.editUser = editUser;
            }

            public String getEditTime() {
                return editTime;
            }

            public void setEditTime(String editTime) {
                this.editTime = editTime;
            }
        }
    }


//    /**
//     * bring : {"id":"e50c9b4940ba41feb1a63ea58048b752","deliveryCode":"D20180108000015","indentCode":"ORDER20180108000015","estimateTime":"","carIds":null,"indentId":"7ee2badff3ab429dabbdc54bc65431b2","oilCarId":"d0f7b6505f28484b815ef08a154ed514","senderName":null,"senderPhone":null,"carNum":"鲁AY3K10","deliveryId":null,"deliveryName":null,"telphone":null,"receiveTime":"2018-01-08 18:39:59","estimateArrivalTime":"2018-12-08 18:40","confirmTime":null,"oilAmount":"123","oilType":"3","oilTypeName":"-10号柴油","oilCost":"6.24","finishTime":"2018-01-09 10:30:58","deliveryAddress":"山东省济南市市辖区历城区万达广场","areaCode":"370000","payType":null,"payAmount":null,"remark":null,"delevaStatus":null,"orderTime":"2018-01-08 18:23:43","receiverName":"鲁达","orderTel":"18953186913","status":"1","nationalStandard":"4","nationalStandardName":"国五","dstate":"3","addressCoor":"117.00973117602715,36.668846783375979","c_user":"beb7537c1eb743648cd1179e6dcde817","c_dt":"2018-01-08 18:23:44","u_user":null,"u_dt":null,"batchId":"BATCH20180101001","orderStatusName":null,"carList":[{"id":"4aeddcd5e829416bad827d22937ddf0b","relateId":"e50c9b4940ba41feb1a63ea58048b752","relateType":"1","vehicleCode":"青A92351","pName":null,"telphone":"","oilType":"3","nationalStandard":"4","nationalStandardName":"国五","tankSize":"211","num":"0","finishTime":"2018-01-09 10:30:50","oilBalance":"6.24","oilTotal":"1316.64","fillTime":null,"oilTypeName":"-10号柴油","dstate":"1","docType":"0","status":"1","c_user":null,"c_dt":"2018-01-09 10:30:58","u_user":null,"u_dt":""}],"remarkList":[{"id":"7a6014dc2ed043dcbe9229e5c312ccf1","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"李敏","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-08 18:23:44","editUser":null,"editTime":null},{"id":"e927f76fdbd44c1a9a55019fb0853694","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"鸣鸣面","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-08 18:39:59","editUser":null,"editTime":null},{"id":"021247b6c980412d86c30fdc117cf236","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-09 10:30:58","editUser":null,"editTime":null}],"evaluationList":null}
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
//         * id : e50c9b4940ba41feb1a63ea58048b752
//         * deliveryCode : D20180108000015
//         * indentCode : ORDER20180108000015
//         * estimateTime :
//         * carIds : null
//         * indentId : 7ee2badff3ab429dabbdc54bc65431b2
//         * oilCarId : d0f7b6505f28484b815ef08a154ed514
//         * senderName : null
//         * senderPhone : null
//         * carNum : 鲁AY3K10
//         * deliveryId : null
//         * deliveryName : null
//         * telphone : null
//         * receiveTime : 2018-01-08 18:39:59
//         * estimateArrivalTime : 2018-12-08 18:40
//         * confirmTime : null
//         * oilAmount : 123
//         * oilType : 3
//         * oilTypeName : -10号柴油
//         * oilCost : 6.24
//         * finishTime : 2018-01-09 10:30:58
//         * deliveryAddress : 山东省济南市市辖区历城区万达广场
//         * areaCode : 370000
//         * payType : null
//         * payAmount : null
//         * remark : null
//         * delevaStatus : null
//         * orderTime : 2018-01-08 18:23:43
//         * receiverName : 鲁达
//         * orderTel : 18953186913
//         * status : 1
//         * nationalStandard : 4
//         * nationalStandardName : 国五
//         * dstate : 3
//         * addressCoor : 117.00973117602715,36.668846783375979
//         * c_user : beb7537c1eb743648cd1179e6dcde817
//         * c_dt : 2018-01-08 18:23:44
//         * u_user : null
//         * u_dt : null
//         * batchId : BATCH20180101001
//         * orderStatusName : null
//         * carList : [{"id":"4aeddcd5e829416bad827d22937ddf0b","relateId":"e50c9b4940ba41feb1a63ea58048b752","relateType":"1","vehicleCode":"青A92351","pName":null,"telphone":"","oilType":"3","nationalStandard":"4","nationalStandardName":"国五","tankSize":"211","num":"0","finishTime":"2018-01-09 10:30:50","oilBalance":"6.24","oilTotal":"1316.64","fillTime":null,"oilTypeName":"-10号柴油","dstate":"1","docType":"0","status":"1","c_user":null,"c_dt":"2018-01-09 10:30:58","u_user":null,"u_dt":""}]
//         * remarkList : [{"id":"7a6014dc2ed043dcbe9229e5c312ccf1","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"李敏","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-08 18:23:44","editUser":null,"editTime":null},{"id":"e927f76fdbd44c1a9a55019fb0853694","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"鸣鸣面","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-08 18:39:59","editUser":null,"editTime":null},{"id":"021247b6c980412d86c30fdc117cf236","deliveryOrderId":"e50c9b4940ba41feb1a63ea58048b752","text":"","status":"1","addUser":"beb7537c1eb743648cd1179e6dcde817","addTime":"2018-01-09 10:30:58","editUser":null,"editTime":null}]
//         * evaluationList : null
//         */
//
//        private String id;
//        private String deliveryCode;
//        private String indentCode;
//        private String estimateTime;
//        private String carIds;
//        private String indentId;
//        private String oilCarId;
//        private String senderName;
//        private String senderPhone;
//        private String carNum;
//        private String deliveryId;
//        private String deliveryName;
//        private String telphone;
//        private String receiveTime;
//        private String estimateArrivalTime;
//        private String confirmTime;
//        private String oilAmount;
//        private String oilType;
//        private String oilTypeName;
//        private String oilCost;
//        private String finishTime;
//        private String deliveryAddress;
//        private String areaCode;
//        private String payType;
//        private String payAmount;
//        private String remark;
//        private String delevaStatus;
//        private String orderTime;
//        private String receiverName;
//        private String orderTel;
//        private String status;
//        private String nationalStandard;
//        private String nationalStandardName;
//        private String dstate;
//        private String addressCoor;
//        private String c_user;
//        private String c_dt;
//        private String u_user;
//        private String u_dt;
//        private String batchId;
//        private String orderStatusName;
//        private String evaluationList;
//        private List<CarListBean> carList;
//        private List<RemarkListBean> remarkList;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getDeliveryCode() {
//            return deliveryCode;
//        }
//
//        public void setDeliveryCode(String deliveryCode) {
//            this.deliveryCode = deliveryCode;
//        }
//
//        public String getIndentCode() {
//            return indentCode;
//        }
//
//        public void setIndentCode(String indentCode) {
//            this.indentCode = indentCode;
//        }
//
//        public String getEstimateTime() {
//            return estimateTime;
//        }
//
//        public void setEstimateTime(String estimateTime) {
//            this.estimateTime = estimateTime;
//        }
//
//        public String getCarIds() {
//            return carIds;
//        }
//
//        public void setCarIds(String carIds) {
//            this.carIds = carIds;
//        }
//
//        public String getIndentId() {
//            return indentId;
//        }
//
//        public void setIndentId(String indentId) {
//            this.indentId = indentId;
//        }
//
//        public String getOilCarId() {
//            return oilCarId;
//        }
//
//        public void setOilCarId(String oilCarId) {
//            this.oilCarId = oilCarId;
//        }
//
//        public String getSenderName() {
//            return senderName;
//        }
//
//        public void setSenderName(String senderName) {
//            this.senderName = senderName;
//        }
//
//        public String getSenderPhone() {
//            return senderPhone;
//        }
//
//        public void setSenderPhone(String senderPhone) {
//            this.senderPhone = senderPhone;
//        }
//
//        public String getCarNum() {
//            return carNum;
//        }
//
//        public void setCarNum(String carNum) {
//            this.carNum = carNum;
//        }
//
//        public String getDeliveryId() {
//            return deliveryId;
//        }
//
//        public void setDeliveryId(String deliveryId) {
//            this.deliveryId = deliveryId;
//        }
//
//        public String getDeliveryName() {
//            return deliveryName;
//        }
//
//        public void setDeliveryName(String deliveryName) {
//            this.deliveryName = deliveryName;
//        }
//
//        public String getTelphone() {
//            return telphone;
//        }
//
//        public void setTelphone(String telphone) {
//            this.telphone = telphone;
//        }
//
//        public String getReceiveTime() {
//            return receiveTime;
//        }
//
//        public void setReceiveTime(String receiveTime) {
//            this.receiveTime = receiveTime;
//        }
//
//        public String getEstimateArrivalTime() {
//            return estimateArrivalTime;
//        }
//
//        public void setEstimateArrivalTime(String estimateArrivalTime) {
//            this.estimateArrivalTime = estimateArrivalTime;
//        }
//
//        public String getConfirmTime() {
//            return confirmTime;
//        }
//
//        public void setConfirmTime(String confirmTime) {
//            this.confirmTime = confirmTime;
//        }
//
//        public String getOilAmount() {
//            return oilAmount;
//        }
//
//        public void setOilAmount(String oilAmount) {
//            this.oilAmount = oilAmount;
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
//        public String getOilTypeName() {
//            return oilTypeName;
//        }
//
//        public void setOilTypeName(String oilTypeName) {
//            this.oilTypeName = oilTypeName;
//        }
//
//        public String getOilCost() {
//            return oilCost;
//        }
//
//        public void setOilCost(String oilCost) {
//            this.oilCost = oilCost;
//        }
//
//        public String getFinishTime() {
//            return finishTime;
//        }
//
//        public void setFinishTime(String finishTime) {
//            this.finishTime = finishTime;
//        }
//
//        public String getDeliveryAddress() {
//            return deliveryAddress;
//        }
//
//        public void setDeliveryAddress(String deliveryAddress) {
//            this.deliveryAddress = deliveryAddress;
//        }
//
//        public String getAreaCode() {
//            return areaCode;
//        }
//
//        public void setAreaCode(String areaCode) {
//            this.areaCode = areaCode;
//        }
//
//        public String getPayType() {
//            return payType;
//        }
//
//        public void setPayType(String payType) {
//            this.payType = payType;
//        }
//
//        public String getPayAmount() {
//            return payAmount;
//        }
//
//        public void setPayAmount(String payAmount) {
//            this.payAmount = payAmount;
//        }
//
//        public String getRemark() {
//            return remark;
//        }
//
//        public void setRemark(String remark) {
//            this.remark = remark;
//        }
//
//        public String getDelevaStatus() {
//            return delevaStatus;
//        }
//
//        public void setDelevaStatus(String delevaStatus) {
//            this.delevaStatus = delevaStatus;
//        }
//
//        public String getOrderTime() {
//            return orderTime;
//        }
//
//        public void setOrderTime(String orderTime) {
//            this.orderTime = orderTime;
//        }
//
//        public String getReceiverName() {
//            return receiverName;
//        }
//
//        public void setReceiverName(String receiverName) {
//            this.receiverName = receiverName;
//        }
//
//        public String getOrderTel() {
//            return orderTel;
//        }
//
//        public void setOrderTel(String orderTel) {
//            this.orderTel = orderTel;
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
//        public String getNationalStandard() {
//            return nationalStandard;
//        }
//
//        public void setNationalStandard(String nationalStandard) {
//            this.nationalStandard = nationalStandard;
//        }
//
//        public String getNationalStandardName() {
//            return nationalStandardName;
//        }
//
//        public void setNationalStandardName(String nationalStandardName) {
//            this.nationalStandardName = nationalStandardName;
//        }
//
//        public String getDstate() {
//            return dstate;
//        }
//
//        public void setDstate(String dstate) {
//            this.dstate = dstate;
//        }
//
//        public String getAddressCoor() {
//            return addressCoor;
//        }
//
//        public void setAddressCoor(String addressCoor) {
//            this.addressCoor = addressCoor;
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
//        public String getC_dt() {
//            return c_dt;
//        }
//
//        public void setC_dt(String c_dt) {
//            this.c_dt = c_dt;
//        }
//
//        public String getU_user() {
//            return u_user;
//        }
//
//        public void setU_user(String u_user) {
//            this.u_user = u_user;
//        }
//
//        public String getU_dt() {
//            return u_dt;
//        }
//
//        public void setU_dt(String u_dt) {
//            this.u_dt = u_dt;
//        }
//
//        public String getBatchId() {
//            return batchId;
//        }
//
//        public void setBatchId(String batchId) {
//            this.batchId = batchId;
//        }
//
//        public String getOrderStatusName() {
//            return orderStatusName;
//        }
//
//        public void setOrderStatusName(String orderStatusName) {
//            this.orderStatusName = orderStatusName;
//        }
//
//        public String getEvaluationList() {
//            return evaluationList;
//        }
//
//        public void setEvaluationList(String evaluationList) {
//            this.evaluationList = evaluationList;
//        }
//
//        public List<CarListBean> getCarList() {
//            return carList;
//        }
//
//        public void setCarList(List<CarListBean> carList) {
//            this.carList = carList;
//        }
//
//        public List<RemarkListBean> getRemarkList() {
//            return remarkList;
//        }
//
//        public void setRemarkList(List<RemarkListBean> remarkList) {
//            this.remarkList = remarkList;
//        }
//
//        public static class CarListBean {
//            /**
//             * id : 4aeddcd5e829416bad827d22937ddf0b
//             * relateId : e50c9b4940ba41feb1a63ea58048b752
//             * relateType : 1
//             * vehicleCode : 青A92351
//             * pName : null
//             * telphone :
//             * oilType : 3
//             * nationalStandard : 4
//             * nationalStandardName : 国五
//             * tankSize : 211
//             * num : 0
//             * finishTime : 2018-01-09 10:30:50
//             * oilBalance : 6.24
//             * oilTotal : 1316.64
//             * fillTime : null
//             * oilTypeName : -10号柴油
//             * dstate : 1
//             * docType : 0
//             * status : 1
//             * c_user : null
//             * c_dt : 2018-01-09 10:30:58
//             * u_user : null
//             * u_dt :
//             */
//
//            private String id;
//            private String relateId;
//            private String relateType;
//            private String vehicleCode;
//            private String pName;
//            private String telphone;
//            private String oilType;
//            private String nationalStandard;
//            private String nationalStandardName;
//            private String tankSize;
//            private String num;
//            private String finishTime;
//            private String oilBalance;
//            private String oilTotal;
//            private String fillTime;
//            private String oilTypeName;
//            private String dstate;
//            private String docType;
//            private String status;
//            private String c_user;
//            private String c_dt;
//            private String u_user;
//            private String u_dt;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getRelateId() {
//                return relateId;
//            }
//
//            public void setRelateId(String relateId) {
//                this.relateId = relateId;
//            }
//
//            public String getRelateType() {
//                return relateType;
//            }
//
//            public void setRelateType(String relateType) {
//                this.relateType = relateType;
//            }
//
//            public String getVehicleCode() {
//                return vehicleCode;
//            }
//
//            public void setVehicleCode(String vehicleCode) {
//                this.vehicleCode = vehicleCode;
//            }
//
//            public String getPName() {
//                return pName;
//            }
//
//            public void setPName(String pName) {
//                this.pName = pName;
//            }
//
//            public String getTelphone() {
//                return telphone;
//            }
//
//            public void setTelphone(String telphone) {
//                this.telphone = telphone;
//            }
//
//            public String getOilType() {
//                return oilType;
//            }
//
//            public void setOilType(String oilType) {
//                this.oilType = oilType;
//            }
//
//            public String getNationalStandard() {
//                return nationalStandard;
//            }
//
//            public void setNationalStandard(String nationalStandard) {
//                this.nationalStandard = nationalStandard;
//            }
//
//            public String getNationalStandardName() {
//                return nationalStandardName;
//            }
//
//            public void setNationalStandardName(String nationalStandardName) {
//                this.nationalStandardName = nationalStandardName;
//            }
//
//            public String getTankSize() {
//                return tankSize;
//            }
//
//            public void setTankSize(String tankSize) {
//                this.tankSize = tankSize;
//            }
//
//            public String getNum() {
//                return num;
//            }
//
//            public void setNum(String num) {
//                this.num = num;
//            }
//
//            public String getFinishTime() {
//                return finishTime;
//            }
//
//            public void setFinishTime(String finishTime) {
//                this.finishTime = finishTime;
//            }
//
//            public String getOilBalance() {
//                return oilBalance;
//            }
//
//            public void setOilBalance(String oilBalance) {
//                this.oilBalance = oilBalance;
//            }
//
//            public String getOilTotal() {
//                return oilTotal;
//            }
//
//            public void setOilTotal(String oilTotal) {
//                this.oilTotal = oilTotal;
//            }
//
//            public String getFillTime() {
//                return fillTime;
//            }
//
//            public void setFillTime(String fillTime) {
//                this.fillTime = fillTime;
//            }
//
//            public String getOilTypeName() {
//                return oilTypeName;
//            }
//
//            public void setOilTypeName(String oilTypeName) {
//                this.oilTypeName = oilTypeName;
//            }
//
//            public String getDstate() {
//                return dstate;
//            }
//
//            public void setDstate(String dstate) {
//                this.dstate = dstate;
//            }
//
//            public String getDocType() {
//                return docType;
//            }
//
//            public void setDocType(String docType) {
//                this.docType = docType;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getC_user() {
//                return c_user;
//            }
//
//            public void setC_user(String c_user) {
//                this.c_user = c_user;
//            }
//
//            public String getC_dt() {
//                return c_dt;
//            }
//
//            public void setC_dt(String c_dt) {
//                this.c_dt = c_dt;
//            }
//
//            public String getU_user() {
//                return u_user;
//            }
//
//            public void setU_user(String u_user) {
//                this.u_user = u_user;
//            }
//
//            public String getU_dt() {
//                return u_dt;
//            }
//
//            public void setU_dt(String u_dt) {
//                this.u_dt = u_dt;
//            }
//        }
//
//        public static class RemarkListBean {
//            /**
//             * id : 7a6014dc2ed043dcbe9229e5c312ccf1
//             * deliveryOrderId : e50c9b4940ba41feb1a63ea58048b752
//             * text : 李敏
//             * status : 1
//             * addUser : beb7537c1eb743648cd1179e6dcde817
//             * addTime : 2018-01-08 18:23:44
//             * editUser : null
//             * editTime : null
//             */
//
//            private String id;
//            private String deliveryOrderId;
//            private String text;
//            private String status;
//            private String addUser;
//            private String addTime;
//            private String editUser;
//            private String editTime;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getDeliveryOrderId() {
//                return deliveryOrderId;
//            }
//
//            public void setDeliveryOrderId(String deliveryOrderId) {
//                this.deliveryOrderId = deliveryOrderId;
//            }
//
//            public String getText() {
//                return text;
//            }
//
//            public void setText(String text) {
//                this.text = text;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getAddUser() {
//                return addUser;
//            }
//
//            public void setAddUser(String addUser) {
//                this.addUser = addUser;
//            }
//
//            public String getAddTime() {
//                return addTime;
//            }
//
//            public void setAddTime(String addTime) {
//                this.addTime = addTime;
//            }
//
//            public String getEditUser() {
//                return editUser;
//            }
//
//            public void setEditUser(String editUser) {
//                this.editUser = editUser;
//            }
//
//            public String getEditTime() {
//                return editTime;
//            }
//
//            public void setEditTime(String editTime) {
//                this.editTime = editTime;
//            }
//        }
//    }
}
