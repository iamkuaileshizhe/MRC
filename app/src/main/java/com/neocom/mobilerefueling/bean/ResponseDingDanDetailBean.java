package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/14.
 * 订单详情 返回 实体类
 *
 */

public class ResponseDingDanDetailBean extends BaseBean {


    /**
     * bring : {"phone":"1366666666666","status":"1","remark":null,"indentStatus":"10","carsInfo":[{"tankSize":"川","pName":"陈一发","vehicleId":"45234f3557734827a405c463b276f0df","vehicleCode":"川A34995","dstate":null,"oilType":"2","relateType":"0","telphone":"川A34995"},{"tankSize":"123","pName":"汤唯","vehicleId":"ec67ba1336614ea6945a279b950628e1","vehicleCode":"川A666661","dstate":null,"oilType":"2","relateType":"0","telphone":"123"}],"u_dt":"","orderStatus":"已完成","indentTime":"2017-08-23 13:58:18","amount":null,"realCost":null,"estimateCost":"666万","deliveryTime":"2017-08-23","linkMan":"于总","oilAmount":null,"c_user":"17c4520f6cfd1ab53d8745e84681eb49","indentId":"9744095cc05543bcbc2a7b481e32bb9d","indentCode":"C000029","payType":"3","prepayAmount":null,"indentAddress":"滨州市","u_user":"","delStatus":"","c_dt":"2017-08-23 13:58:18"}
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
         * phone : 1366666666666
         * status : 1
         * remark : null
         * indentStatus : 10
         * carsInfo : [{"tankSize":"川","pName":"陈一发","vehicleId":"45234f3557734827a405c463b276f0df","vehicleCode":"川A34995","dstate":null,"oilType":"2","relateType":"0","telphone":"川A34995"},{"tankSize":"123","pName":"汤唯","vehicleId":"ec67ba1336614ea6945a279b950628e1","vehicleCode":"川A666661","dstate":null,"oilType":"2","relateType":"0","telphone":"123"}]
         * u_dt :
         * orderStatus : 已完成
         * indentTime : 2017-08-23 13:58:18
         * amount : null
         * realCost : null
         * estimateCost : 666万
         * deliveryTime : 2017-08-23
         * linkMan : 于总
         * oilAmount : null
         * c_user : 17c4520f6cfd1ab53d8745e84681eb49
         * indentId : 9744095cc05543bcbc2a7b481e32bb9d
         * indentCode : C000029
         * payType : 3
         * prepayAmount : null
         * indentAddress : 滨州市
         * u_user :
         * delStatus :
         * c_dt : 2017-08-23 13:58:18
         */

        private String phone;
        private String status;
        private String remark;
        private String indentStatus;
        private String u_dt;
        private String orderStatus;
        private String indentTime;
        private String amount;
        private String realCost;
        private String estimateCost;
        private String deliveryTime;
        private String linkMan;
        private String oilAmount;
        private String c_user;
        private String indentId;
        private String indentCode;
        private String payType;
        private String prepayAmount;
        private String indentAddress;
        private String u_user;
        private String delStatus;
        private String c_dt;
        private List<CarsInfoBean> carsInfo;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getIndentStatus() {
            return indentStatus;
        }

        public void setIndentStatus(String indentStatus) {
            this.indentStatus = indentStatus;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getIndentTime() {
            return indentTime;
        }

        public void setIndentTime(String indentTime) {
            this.indentTime = indentTime;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getRealCost() {
            return realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getEstimateCost() {
            return estimateCost;
        }

        public void setEstimateCost(String estimateCost) {
            this.estimateCost = estimateCost;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getLinkMan() {
            return linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getC_user() {
            return c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        public String getIndentCode() {
            return indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getPrepayAmount() {
            return prepayAmount;
        }

        public void setPrepayAmount(String prepayAmount) {
            this.prepayAmount = prepayAmount;
        }

        public String getIndentAddress() {
            return indentAddress;
        }

        public void setIndentAddress(String indentAddress) {
            this.indentAddress = indentAddress;
        }

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getDelStatus() {
            return delStatus;
        }

        public void setDelStatus(String delStatus) {
            this.delStatus = delStatus;
        }

        public String getC_dt() {
            return c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public List<CarsInfoBean> getCarsInfo() {
            return carsInfo;
        }

        public void setCarsInfo(List<CarsInfoBean> carsInfo) {
            this.carsInfo = carsInfo;
        }

        public static class CarsInfoBean {
            /**
             * tankSize : 川
             * pName : 陈一发
             * vehicleId : 45234f3557734827a405c463b276f0df
             * vehicleCode : 川A34995
             * dstate : null
             * oilType : 2
             * relateType : 0
             * telphone : 川A34995
             */

            private String tankSize;
            private String pName;
            private String vehicleId;
            private String vehicleCode;
            private String dstate;
            private String oilType;
            private String relateType;
            private String telphone;

            public String getTankSize() {
                return tankSize;
            }

            public void setTankSize(String tankSize) {
                this.tankSize = tankSize;
            }

            public String getPName() {
                return pName;
            }

            public void setPName(String pName) {
                this.pName = pName;
            }

            public String getVehicleId() {
                return vehicleId;
            }

            public void setVehicleId(String vehicleId) {
                this.vehicleId = vehicleId;
            }

            public String getVehicleCode() {
                return vehicleCode;
            }

            public void setVehicleCode(String vehicleCode) {
                this.vehicleCode = vehicleCode;
            }

            public String getDstate() {
                return dstate;
            }

            public void setDstate(String dstate) {
                this.dstate = dstate;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public String getRelateType() {
                return relateType;
            }

            public void setRelateType(String relateType) {
                this.relateType = relateType;
            }

            public String getTelphone() {
                return telphone;
            }

            public void setTelphone(String telphone) {
                this.telphone = telphone;
            }
        }

        @Override
        public String toString() {
            return "BringBean{" +
                    "phone='" + phone + '\'' +
                    ", status='" + status + '\'' +
                    ", remark='" + remark + '\'' +
                    ", indentStatus='" + indentStatus + '\'' +
                    ", u_dt='" + u_dt + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", indentTime='" + indentTime + '\'' +
                    ", amount='" + amount + '\'' +
                    ", realCost='" + realCost + '\'' +
                    ", estimateCost='" + estimateCost + '\'' +
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", linkMan='" + linkMan + '\'' +
                    ", oilAmount='" + oilAmount + '\'' +
                    ", c_user='" + c_user + '\'' +
                    ", indentId='" + indentId + '\'' +
                    ", indentCode='" + indentCode + '\'' +
                    ", payType='" + payType + '\'' +
                    ", prepayAmount='" + prepayAmount + '\'' +
                    ", indentAddress='" + indentAddress + '\'' +
                    ", u_user='" + u_user + '\'' +
                    ", delStatus='" + delStatus + '\'' +
                    ", c_dt='" + c_dt + '\'' +
                    ", carsInfo=" + carsInfo +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseDingDanDetailBean{" +
                "bring=" + bring +
                '}';
    }
}
