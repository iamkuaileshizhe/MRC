package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */

public class OrderResponseBean extends BaseBean {


    /**
     * code : message.common.0000
     * message : 成功
     * bring : {"linkMan":"小李","indentCode":"C000023","indentAddress":"山东省菏泽市某某大厦","oilsInfo":[{"oilPrice":"10","oilType":"6","payAmount":"123"}],"title":null,"amount":null,"orderStatus":"已完成","payType":null,"companyAccount":null,"delStatus":"0","invArea":null,"taxCode":null,"companyAddress":null,"realCost":null,"invoiceName":null,"oilAmount":null,"deliveryType":null,"companyPhone":null,"invAddress":null,"deliveryTime":"2017-10-12 10:58:31","email":null,"prepayAmount":null,"phone":"13500000000","companyName":null,"invtelphone":null,"estimateCost":"1230","bankName":null,"indentStatus":"10","indentId":"4498f59771914a41acfbb955621818e1","remark":"","content":null,"indentTime":"2017-10-12 10:58:31"}
     * res : true
     * purl : properties/code.properties
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
         * linkMan : 小李
         * indentCode : C000023
         * indentAddress : 山东省菏泽市某某大厦
         * oilsInfo : [{"oilPrice":"10","oilType":"6","payAmount":"123"}]
         * title : null
         * amount : null
         * orderStatus : 已完成
         * payType : null
         * companyAccount : null
         * delStatus : 0
         * invArea : null
         * taxCode : null
         * companyAddress : null
         * realCost : null
         * invoiceName : null
         * oilAmount : null
         * deliveryType : null
         * companyPhone : null
         * invAddress : null
         * deliveryTime : 2017-10-12 10:58:31
         * email : null
         * prepayAmount : null
         * phone : 13500000000
         * companyName : null
         * invtelphone : null
         * estimateCost : 1230
         * bankName : null
         * indentStatus : 10
         * indentId : 4498f59771914a41acfbb955621818e1
         * remark :
         * content : null
         * indentTime : 2017-10-12 10:58:31
         */

        private String linkMan;
        private String indentCode;
        private String indentAddress;
        private String title;
        private String amount;
        private String orderStatus;
        private String payType;
        private String companyAccount;
        private String delStatus;
        private String invArea;
        private String taxCode;
        private String companyAddress;
        private String realCost;
        private String invoiceName;
        private String oilAmount;
        private String deliveryType;
        private String companyPhone;
        private String invAddress;
        private String deliveryTime;
        private String email;
        private String prepayAmount;
        private String phone;
        private String companyName;
        private String invtelphone;
        private String estimateCost;
        private String bankName;
        private String indentStatus;
        private String indentId;
        private String remark;
        private String content;
        private String indentTime;
        private List<OilsInfoBean> oilsInfo;

        public String getLinkMan() {
            return linkMan;
        }

        public void setLinkMan(String linkMan) {
            this.linkMan = linkMan;
        }

        public String getIndentCode() {
            return indentCode;
        }

        public void setIndentCode(String indentCode) {
            this.indentCode = indentCode;
        }

        public String getIndentAddress() {
            return indentAddress;
        }

        public void setIndentAddress(String indentAddress) {
            this.indentAddress = indentAddress;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getCompanyAccount() {
            return companyAccount;
        }

        public void setCompanyAccount(String companyAccount) {
            this.companyAccount = companyAccount;
        }

        public String getDelStatus() {
            return delStatus;
        }

        public void setDelStatus(String delStatus) {
            this.delStatus = delStatus;
        }

        public String getInvArea() {
            return invArea;
        }

        public void setInvArea(String invArea) {
            this.invArea = invArea;
        }

        public String getTaxCode() {
            return taxCode;
        }

        public void setTaxCode(String taxCode) {
            this.taxCode = taxCode;
        }

        public String getCompanyAddress() {
            return companyAddress;
        }

        public void setCompanyAddress(String companyAddress) {
            this.companyAddress = companyAddress;
        }

        public String getRealCost() {
            return realCost;
        }

        public void setRealCost(String realCost) {
            this.realCost = realCost;
        }

        public String getInvoiceName() {
            return invoiceName;
        }

        public void setInvoiceName(String invoiceName) {
            this.invoiceName = invoiceName;
        }

        public String getOilAmount() {
            return oilAmount;
        }

        public void setOilAmount(String oilAmount) {
            this.oilAmount = oilAmount;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public String getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(String companyPhone) {
            this.companyPhone = companyPhone;
        }

        public String getInvAddress() {
            return invAddress;
        }

        public void setInvAddress(String invAddress) {
            this.invAddress = invAddress;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPrepayAmount() {
            return prepayAmount;
        }

        public void setPrepayAmount(String prepayAmount) {
            this.prepayAmount = prepayAmount;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getInvtelphone() {
            return invtelphone;
        }

        public void setInvtelphone(String invtelphone) {
            this.invtelphone = invtelphone;
        }

        public String getEstimateCost() {
            return estimateCost;
        }

        public void setEstimateCost(String estimateCost) {
            this.estimateCost = estimateCost;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getIndentStatus() {
            return indentStatus;
        }

        public void setIndentStatus(String indentStatus) {
            this.indentStatus = indentStatus;
        }

        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getIndentTime() {
            return indentTime;
        }

        public void setIndentTime(String indentTime) {
            this.indentTime = indentTime;
        }

        public List<OilsInfoBean> getOilsInfo() {
            return oilsInfo;
        }

        public void setOilsInfo(List<OilsInfoBean> oilsInfo) {
            this.oilsInfo = oilsInfo;
        }

        public static class OilsInfoBean {
            /**
             * oilPrice : 10
             * oilType : 6
             * payAmount : 123
             */

            private String oilPrice;
            private String oilType;
            private String payAmount;

            public String getOilPrice() {
                return oilPrice;
            }

            public void setOilPrice(String oilPrice) {
                this.oilPrice = oilPrice;
            }

            public String getOilType() {
                return oilType;
            }

            public void setOilType(String oilType) {
                this.oilType = oilType;
            }

            public String getPayAmount() {
                return payAmount;
            }

            public void setPayAmount(String payAmount) {
                this.payAmount = payAmount;
            }
        }
    }
}
