package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */

public class RescheduRespBean extends BaseBean {


    /**
     * code : null
     * bring : {"id":"000141a568f24591bf5df32689c9b36f","deliveryCode":"D20180201002420","indentCode":"ORDER20180201000128","estimateTime":"","carIds":null,"indentId":"22ff77855da94f86b7b531fb0f769eb5","indentStatus":null,"estimateCost":null,"realCost":null,"oilCarId":null,"senderName":null,"senderPhone":null,"carNum":null,"deliveryId":null,"deliveryName":null,"telphone":null,"deliveryTime":null,"receiveTime":null,"estimateArrivalTime":null,"confirmTime":null,"oilAmount":"13","oilType":"3","oilTypeName":null,"oilCost":"7","finishTime":null,"deliveryAddress":"山东省济南市市辖区历下区舜泰广场对面就是这样的地方就是","areaCode":"370000;370100;370101","payType":null,"payAmount":null,"remark":"我测试下","delevaStatus":null,"orderTime":"2018-02-01 09:25:44","receiverName":"胡新学","orderTel":"18953186913","status":"1","nationalStandard":"4","nationalStandardName":null,"dstate":"9","addressCoor":null,"c_user":"5481cba967b64e6991291c5e505a33ce","c_dt":"2018-02-01 09:25:44","u_user":"beb7537c1eb743648cd1179e6dcde817","u_dt":"2018-03-13 18:31:30","batchId":null,"orderStatusName":null,"timeLong":null,"carList":[],"remarkList":[{"id":"fc36f1d044864242aa68251ca81734b0","deliveryOrderId":"000141a568f24591bf5df32689c9b36f","text":"国五测试","status":"1","addUser":"5481cba967b64e6991291c5e505a33ce","addTime":"2018-02-01 09:25:44","editUser":null,"editTime":null}],"evaluationList":null}
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
         * id : 000141a568f24591bf5df32689c9b36f
         * deliveryCode : D20180201002420
         * indentCode : ORDER20180201000128
         * estimateTime : 
         * carIds : null
         * indentId : 22ff77855da94f86b7b531fb0f769eb5
         * indentStatus : null
         * estimateCost : null
         * realCost : null
         * oilCarId : null
         * senderName : null
         * senderPhone : null
         * carNum : null
         * deliveryId : null
         * deliveryName : null
         * telphone : null
         * deliveryTime : null
         * receiveTime : null
         * estimateArrivalTime : null
         * confirmTime : null
         * oilAmount : 13
         * oilType : 3
         * oilTypeName : null
         * oilCost : 7
         * finishTime : null
         * deliveryAddress : 山东省济南市市辖区历下区舜泰广场对面就是这样的地方就是
         * areaCode : 370000;370100;370101
         * payType : null
         * payAmount : null
         * remark : 我测试下
         * delevaStatus : null
         * orderTime : 2018-02-01 09:25:44
         * receiverName : 胡新学
         * orderTel : 18953186913
         * status : 1
         * nationalStandard : 4
         * nationalStandardName : null
         * dstate : 9
         * addressCoor : null
         * c_user : 5481cba967b64e6991291c5e505a33ce
         * c_dt : 2018-02-01 09:25:44
         * u_user : beb7537c1eb743648cd1179e6dcde817
         * u_dt : 2018-03-13 18:31:30
         * batchId : null
         * orderStatusName : null
         * timeLong : null
         * carList : []
         * remarkList : [{"id":"fc36f1d044864242aa68251ca81734b0","deliveryOrderId":"000141a568f24591bf5df32689c9b36f","text":"国五测试","status":"1","addUser":"5481cba967b64e6991291c5e505a33ce","addTime":"2018-02-01 09:25:44","editUser":null,"editTime":null}]
         * evaluationList : null
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
        private String evaluationList;
        private List<?> carList;
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

        public String getEvaluationList() {
            return evaluationList;
        }

        public void setEvaluationList(String evaluationList) {
            this.evaluationList = evaluationList;
        }

        public List<?> getCarList() {
            return carList;
        }

        public void setCarList(List<?> carList) {
            this.carList = carList;
        }

        public List<RemarkListBean> getRemarkList() {
            return remarkList;
        }

        public void setRemarkList(List<RemarkListBean> remarkList) {
            this.remarkList = remarkList;
        }

        public static class RemarkListBean {
            /**
             * id : fc36f1d044864242aa68251ca81734b0
             * deliveryOrderId : 000141a568f24591bf5df32689c9b36f
             * text : 国五测试
             * status : 1
             * addUser : 5481cba967b64e6991291c5e505a33ce
             * addTime : 2018-02-01 09:25:44
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
}
