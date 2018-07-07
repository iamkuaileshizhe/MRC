package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/8/24.
 */

public class ReceiverOrderBeanBring extends BaseBean {
    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : e50c9b4940ba41feb1a63ea58048b752
         * deliveryCode : D20180108000015
         * indentCode : ORDER20180108000015
         * estimateTime : 
         * carIds : null
         * indentId : 7ee2badff3ab429dabbdc54bc65431b2
         * oilCarId : d0f7b6505f28484b815ef08a154ed514
         * senderName : null
         * senderPhone : null
         * carNum : 鲁AY3K10
         * deliveryId : null
         * deliveryName : null
         * telphone : null
         * receiveTime : 2018-01-08 18:39:59
         * estimateArrivalTime : 2018-12-08 18:40
         * confirmTime : null
         * oilAmount : 123
         * oilType : 3
         * oilTypeName : -10号柴油
         * oilCost : 6.24
         * finishTime : null
         * deliveryAddress : 山东省济南市市辖区历城区万达广场
         * areaCode : 370000
         * payType : null
         * payAmount : null
         * remark : null
         * delevaStatus : null
         * orderTime : 2018-01-08 18:23:43
         * receiverName : 鲁达
         * orderTel : 18953186913
         * status : 1
         * nationalStandard : 4
         * nationalStandardName : 国五
         * dstate : 1
         * addressCoor : 117.00973117602715,36.668846783375979
         * c_user : null
         * c_dt : 2018-01-08 18:23:44
         * u_user : null
         * u_dt : null
         * batchId : null
         * orderStatusName : null
         * carList : null
         * remarkList : null
         * evaluationList : null
         */

        private String id;
        private String deliveryCode;
        private String indentCode;
        private String estimateTime;
        private String carIds;
        private String indentId;
        private String oilCarId;
        private String senderName;
        private String senderPhone;
        private String carNum;
        private String deliveryId;
        private String deliveryName;
        private String telphone;
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
        private String carList;
        private String remarkList;
        private String evaluationList;

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

        public String getCarList() {
            return carList;
        }

        public void setCarList(String carList) {
            this.carList = carList;
        }

        public String getRemarkList() {
            return remarkList;
        }

        public void setRemarkList(String remarkList) {
            this.remarkList = remarkList;
        }

        public String getEvaluationList() {
            return evaluationList;
        }

        public void setEvaluationList(String evaluationList) {
            this.evaluationList = evaluationList;
        }
    }


//
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
//         * id : db6ab6af781b4c5ebb98bd0f03874982
//         * deliveryCode : D-B000001
//         * indentCode : C000003
//         * estimateTime : null
//         * carIds : null
//         * indentId : 034c06d773324e568bfa656ccd2cd192
//         * oilCarId : f5026f72270f44d3acd301682a96bd04
//         * senderName : 加油车测试21
//         * senderPhone : null
//         * carNum : 京H12345
//         * deliveryId : null
//         * deliveryName : null
//         * telphone : null
//         * receiveTime : null
//         * estimateArrivalTime : 2017-11-14 16:08:39
//         * confirmTime : null
//         * oilAmount : 300
//         * oilType : 5号柴油
//         * oilCost : 0
//         * finishTime : null
//         * deliveryAddress : 甘肃省兰州市市辖区城关区 小王
//         * areaCode : 甘肃省兰州市市辖区城关区
//         * payType : null
//         * payAmount : null
//         * remark : null
//         * delevaStatus : null
//         * orderTime : 2017-11-14 15:08:10
//         * receiverName : ggg
//         * orderTel : 555
//         * status : 1
//         * nationalStandard : 1
//         * nationalStandardName : 国二
//         * dstate : 1
//         * addressCoor : 103.851571,36.054008
//         * c_user : null
//         * c_dt : 2017-11-14 15:08:12
//         * u_user : null
//         * u_dt : null
//         * carList : []
//         * remarkList : [{"id":"6c027eb20d32472cb608634c9072da51","deliveryOrderId":"db6ab6af781b4c5ebb98bd0f03874982","text":"","status":"1","addUser":"c43df91e354e4bea934004fdf29e4e6d","addTime":"2017-11-14 15:08:12","editUser":null,"editTime":null},{"id":"33f4477915ca424c84005dd4d7c16b94","deliveryOrderId":"db6ab6af781b4c5ebb98bd0f03874982","text":"","status":"1","addUser":null,"addTime":"2017-11-14 15:08:45","editUser":null,"editTime":null}]
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
//        private String evaluationList;
//        private List<?> carList;
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
//        public String getEvaluationList() {
//            return evaluationList;
//        }
//
//        public void setEvaluationList(String evaluationList) {
//            this.evaluationList = evaluationList;
//        }
//
//        public List<?> getCarList() {
//            return carList;
//        }
//
//        public void setCarList(List<?> carList) {
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
//        public static class RemarkListBean {
//            /**
//             * id : 6c027eb20d32472cb608634c9072da51
//             * deliveryOrderId : db6ab6af781b4c5ebb98bd0f03874982
//             * text :
//             * status : 1
//             * addUser : c43df91e354e4bea934004fdf29e4e6d
//             * addTime : 2017-11-14 15:08:12
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
