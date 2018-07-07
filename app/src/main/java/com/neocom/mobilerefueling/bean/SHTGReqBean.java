package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 */

public class SHTGReqBean implements Serializable {


    /**
     * id : 42026a34eb9042648341394b438a5071
     * isPassed : 1
     * userId : 086834ed141c46a9a255b6cf1766cd3a
     * roleCode : 1
     * province : 630000
     * settlement : 1
     * customerGrade : 1
     * customerPayment : 1
     * priceList : [{"oilType":"1","nationalStandard":"1","discountAmount":"1","performAmount":"1"}]
     */

    private String customerId;
    private String isPassed;
    private String userId;
    private String roleCode;
    private String province;
    private String settlement;
    private String customerGrade;
    private String customerPayment;
    private List<PriceListBean> priceList;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(String isPassed) {
        this.isPassed = isPassed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public String getCustomerPayment() {
        return customerPayment;
    }

    public void setCustomerPayment(String customerPayment) {
        this.customerPayment = customerPayment;
    }

    public List<PriceListBean> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceListBean> priceList) {
        this.priceList = priceList;
    }

    public static class PriceListBean {
        /**
         * oilType : 1
         * nationalStandard : 1
         * discountAmount : 1
         * performAmount : 1
         */

        private String oilType;
        private String nationalStandard;
        private String discountAmount;
        private String performAmount;

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
    }
}
