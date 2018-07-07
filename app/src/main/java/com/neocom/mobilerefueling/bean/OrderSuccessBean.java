package com.neocom.mobilerefueling.bean;


import java.util.List;

/**
 * Created by admin on 2017/8/24.
 */

public class OrderSuccessBean extends BaseBean {

    /**
     * purl : properties/code.properties
     * res : true
     * code : message.common.0001
     * message : 新建成功
     * bring : {"id":"d1a09d614f7f4668881b5d13cca4a457","indentCode":"C000001","indentTime":"2017-10-24 10:31:12","indentAddress":"中国天津市南开区嘻嘻嘻嘻嘻嘻","deliveryTime":"2017-10-24 10:31:12","payType":null,"estimateCost":"25","oilAmount":"20","realCost":"100","amount":"100","prepayAmount":"100","indentStatus":null,"addressCode":"0;120000;120400;嘻嘻嘻嘻嘻嘻","delStatus":"0","evaStatus":null,"linkMan":"测试2","phone":"1388888888888","remark":"备注","coordinate":null,"status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null,"orderStatus":null,"carsNum":"2","oilType":{"id":"1f5fda4af80346579f6b41bd6894dd46","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"3","area":"0","num":"1","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null},"relateOilList":[{"id":"8ae96198dcc24b999c9afa761c105779","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"2","area":"0","num":"0","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null},{"id":"1f5fda4af80346579f6b41bd6894dd46","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"3","area":"0","num":"1","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null}]}
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
         * id : d1a09d614f7f4668881b5d13cca4a457
         * indentCode : C000001
         * indentTime : 2017-10-24 10:31:12
         * indentAddress : 中国天津市南开区嘻嘻嘻嘻嘻嘻
         * deliveryTime : 2017-10-24 10:31:12
         * payType : null
         * estimateCost : 25
         * oilAmount : 20
         * realCost : 100
         * amount : 100
         * prepayAmount : 100
         * indentStatus : null
         * addressCode : 0;120000;120400;嘻嘻嘻嘻嘻嘻
         * delStatus : 0
         * evaStatus : null
         * linkMan : 测试2
         * phone : 1388888888888
         * remark : 备注
         * coordinate : null
         * status : null
         * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
         * c_dt : 2017-10-24 10:31:12
         * u_user : null
         * u_dt : null
         * orderStatus : null
         * carsNum : 2
         * oilType : {"id":"1f5fda4af80346579f6b41bd6894dd46","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"3","area":"0","num":"1","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null}
         * relateOilList : [{"id":"8ae96198dcc24b999c9afa761c105779","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"2","area":"0","num":"0","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null},{"id":"1f5fda4af80346579f6b41bd6894dd46","relateId":"d1a09d614f7f4668881b5d13cca4a457","oilType":"1","oilPrice":"5","amoumt":"3","area":"0","num":"1","status":null,"c_user":"917f2f6eb1ce42a5968ee3a76bcf07c9","c_dt":"2017-10-24 10:31:12","u_user":null,"u_dt":null}]
         */

        private String id;
        private String indentCode;
        private String indentTime;
        private String indentAddress;
        private String deliveryTime;
        private Object payType;
        private String estimateCost;
        private String oilAmount;
        private String realCost;
        private String amount;
        private String prepayAmount;
        private Object indentStatus;
        private String addressCode;
        private String delStatus;
        private Object evaStatus;
        private String linkMan;
        private String phone;
        private String remark;
        private Object coordinate;
        private Object status;
        private String c_user;
        private String c_dt;
        private Object u_user;
        private Object u_dt;
        private Object orderStatus;
        private String carsNum;
        private OilTypeBean oilType;
        private List<RelateOilListBean> relateOilList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIndentCode() {
            return indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getIndentTime() {
            return indentTime;
        }

        public void setIndentTime(String indentTime) {
            this.indentTime = indentTime;
        }

        public String getIndentAddress() {
            return indentAddress;
        }

        public void setIndentAddress(String indentAddress) {
            this.indentAddress = indentAddress;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public Object getPayType() {
            return payType;
        }

        public void setPayType(Object payType) {
            this.payType = payType;
        }

        public String getEstimateCost() {
            return estimateCost;
        }

        public void setEstimateCost(String estimateCost) {
            this.estimateCost = estimateCost;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getRealCost() {
            return realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPrepayAmount() {
            return prepayAmount;
        }

        public void setPrepayAmount(String prepayAmount) {
            this.prepayAmount = prepayAmount;
        }

        public Object getIndentStatus() {
            return indentStatus;
        }

        public void setIndentStatus(Object indentStatus) {
            this.indentStatus = indentStatus;
        }

        public String getAddressCode() {
            return addressCode;
        }

        public void setAddressCode(String addressCode) {
            this.addressCode = addressCode;
        }

        public String getDelStatus() {
            return delStatus;
        }

        public void setDelStatus(String delStatus) {
            this.delStatus = delStatus;
        }

        public Object getEvaStatus() {
            return evaStatus;
        }

        public void setEvaStatus(Object evaStatus) {
            this.evaStatus = evaStatus;
        }

        public String getLinkMan() {
            return linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Object coordinate) {
            this.coordinate = coordinate;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
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

        public Object getU_user() {
            return u_user;
        }

        public void setU_user(Object u_user) {
            this.u_user = u_user;
        }

        public Object getU_dt() {
            return u_dt;
        }

        public void setU_dt(Object u_dt) {
            this.u_dt = u_dt;
        }

        public Object getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(Object orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getCarsNum() {
            return carsNum;
        }

        public void setCarsNum(String carsNum) {
            this.carsNum = carsNum;
        }

        public OilTypeBean getOilType() {
            return oilType;
        }

        public void setOilType(OilTypeBean oilType) {
            this.oilType = oilType;
        }

        public List<RelateOilListBean> getRelateOilList() {
            return relateOilList;
        }

        public void setRelateOilList(List<RelateOilListBean> relateOilList) {
            this.relateOilList = relateOilList;
        }

        public static class OilTypeBean {
            /**
             * id : 1f5fda4af80346579f6b41bd6894dd46
             * relateId : d1a09d614f7f4668881b5d13cca4a457
             * oilType : 1
             * oilPrice : 5
             * amoumt : 3
             * area : 0
             * num : 1
             * status : null
             * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
             * c_dt : 2017-10-24 10:31:12
             * u_user : null
             * u_dt : null
             */

            private String id;
            private String relateId;
            private String oilType;
            private String oilPrice;
            private String amoumt;
            private String area;
            private String num;
            private Object status;
            private String c_user;
            private String c_dt;
            private Object u_user;
            private Object u_dt;

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

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public String getOilPrice() {
                return oilPrice;
            }

            public void setOilPrice(String oilPrice) {
                this.oilPrice = oilPrice;
            }

            public String getAmoumt() {
                return amoumt;
            }

            public void setAmoumt(String amoumt) {
                this.amoumt = amoumt;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
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

            public Object getU_user() {
                return u_user;
            }

            public void setU_user(Object u_user) {
                this.u_user = u_user;
            }

            public Object getU_dt() {
                return u_dt;
            }

            public void setU_dt(Object u_dt) {
                this.u_dt = u_dt;
            }

            @Override
            public String toString() {
                return "OilTypeBean{" +
                        "id='" + id + '\'' +
                        ", relateId='" + relateId + '\'' +
                        ", oilType='" + oilType + '\'' +
                        ", oilPrice='" + oilPrice + '\'' +
                        ", amoumt='" + amoumt + '\'' +
                        ", area='" + area + '\'' +
                        ", num='" + num + '\'' +
                        ", status=" + status +
                        ", c_user='" + c_user + '\'' +
                        ", c_dt='" + c_dt + '\'' +
                        ", u_user=" + u_user +
                        ", u_dt=" + u_dt +
                        '}';
            }
        }

        public static class RelateOilListBean {
            /**
             * id : 8ae96198dcc24b999c9afa761c105779
             * relateId : d1a09d614f7f4668881b5d13cca4a457
             * oilType : 1
             * oilPrice : 5
             * amoumt : 2
             * area : 0
             * num : 0
             * status : null
             * c_user : 917f2f6eb1ce42a5968ee3a76bcf07c9
             * c_dt : 2017-10-24 10:31:12
             * u_user : null
             * u_dt : null
             */

            private String id;
            private String relateId;
            private String oilType;
            private String oilPrice;
            private String amoumt;
            private String area;
            private String num;
            private Object status;
            private String c_user;
            private String c_dt;
            private Object u_user;
            private Object u_dt;

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

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public String getOilPrice() {
                return oilPrice;
            }

            public void setOilPrice(String oilPrice) {
                this.oilPrice = oilPrice;
            }

            public String getAmoumt() {
                return amoumt;
            }

            public void setAmoumt(String amoumt) {
                this.amoumt = amoumt;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
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

            public Object getU_user() {
                return u_user;
            }

            public void setU_user(Object u_user) {
                this.u_user = u_user;
            }

            public Object getU_dt() {
                return u_dt;
            }

            public void setU_dt(Object u_dt) {
                this.u_dt = u_dt;
            }

            @Override
            public String toString() {
                return "RelateOilListBean{" +
                        "id='" + id + '\'' +
                        ", relateId='" + relateId + '\'' +
                        ", oilType='" + oilType + '\'' +
                        ", oilPrice='" + oilPrice + '\'' +
                        ", amoumt='" + amoumt + '\'' +
                        ", area='" + area + '\'' +
                        ", num='" + num + '\'' +
                        ", status=" + status +
                        ", c_user='" + c_user + '\'' +
                        ", c_dt='" + c_dt + '\'' +
                        ", u_user=" + u_user +
                        ", u_dt=" + u_dt +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "BringBean{" +
                    "id='" + id + '\'' +
                    ", indentCode='" + indentCode + '\'' +
                    ", indentTime='" + indentTime + '\'' +
                    ", indentAddress='" + indentAddress + '\'' +
                    ", deliveryTime='" + deliveryTime + '\'' +
                    ", payType=" + payType +
                    ", estimateCost='" + estimateCost + '\'' +
                    ", oilAmount='" + oilAmount + '\'' +
                    ", realCost='" + realCost + '\'' +
                    ", amount='" + amount + '\'' +
                    ", prepayAmount='" + prepayAmount + '\'' +
                    ", indentStatus=" + indentStatus +
                    ", addressCode='" + addressCode + '\'' +
                    ", delStatus='" + delStatus + '\'' +
                    ", evaStatus=" + evaStatus +
                    ", linkMan='" + linkMan + '\'' +
                    ", phone='" + phone + '\'' +
                    ", remark='" + remark + '\'' +
                    ", coordinate=" + coordinate +
                    ", status=" + status +
                    ", c_user='" + c_user + '\'' +
                    ", c_dt='" + c_dt + '\'' +
                    ", u_user=" + u_user +
                    ", u_dt=" + u_dt +
                    ", orderStatus=" + orderStatus +
                    ", carsNum='" + carsNum + '\'' +
                    ", oilType=" + oilType +
                    ", relateOilList=" + relateOilList +
                    '}';
        }
    }
}
