package com.neocom.mobilerefueling.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class KHDetailBringBean {

    /**
     * id : 55495a0d5942405099f86033e7266d4d
     * cusname : 济南铁路(测试用)改1
     * nameNum : C20180130002
     * nameSim : 济南铁路改
     * cusType : 1
     * cusSource : 2
     * customerPayment : 1
     * firmNum : company_123
     * firmLoc : 济南市顺泰广场
     * firmCapital : 2000
     * firmLegal : 张总
     * firmDate : 2018-01-30
     * firmType : 2
     * firmBuscope : 6
     * firmIndustry : 4
     * linkmanOne : 3242a379eb3c400a8f32edf0d0c17c83
     * linkmanTwo : null
     * salesMan : 3b6ddbe91a7444a3bec1d96bc20f5d29
     * other : 测试客户
     * cuser : 3b6ddbe91a7444a3bec1d96bc20f5d29
     * cdt : 2018-01-30 13:42:41
     * uuser : null
     * udt : null
     * checkStatus : 5
     * customerStatus : null
     * status : 1
     * settlement : 1
     * customerGrade : 1
     * changeType : null
     * oilType : 1
     * oilTypesName : 5号柴油
     * payWay : 2
     * billAsk : 无要求
     * carNum : 200
     * carType : 2
     * supplyRate : 2次/天
     * supplyNum : 200L/次
     * supplyWay : 2
     * wishArea : 山东省济南市
     * wishOil : 无
     * otherSer : 无
     * linkmanName : null
     * linkmanPhone : null
     * linkManMess : {"createTime":"2018-01-30 13:42:39","sex":"3","birth":"2018-01-29","belong":"55495a0d5942405099f86033e7266d4d","type":"0","licenceNum":null,"id":"3242a379eb3c400a8f32edf0d0c17c83","userInfoId":"3b10bb1a5aa5401785f367e37f1c42f9","name":"张强改","driverAge":null,"userId":"3b10bb1a5aa5401785f367e37f1c42f9","weChat":"wechat1","createId":null,"licenceType":null,"userCode":"GMJY000150","status":null,"updateTime":"2018-01-30 16:52:37","driverLev":null,"updateId":null,"workNum":null,"code":null,"createName":null,"updateName":"市场经理","email":"ceshi1@163.com","driverRemark":null,"telephone":"6666666","qqNum":"769609901","mobile":"1388888888"}
     * saleManMess : {"userTel":"13666666666","userName":"业务员","userEmail":"lmyou512@163.com"}
     * otherMess : {"customerSourceName":"合作伙伴","firmBuscopeName":"安防工程","settlementName":"现结算","customerTypeName":"企业","carTypeName":"客车","firmTypeName":"国有企业","firmIndustryName":"油气储运","payWayName":"账期结算","supplyWayName":"油罐"}
     * strikePriceList : [{"id":"584c69ee89e74dd184553ed9a04825fe","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.1","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"1"},{"id":"1b6494bea41e4e49a75b9a09e96aaa24","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.2","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"2"},{"id":"c0c105a53098422b84680907219ba479","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.3","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"3"},{"id":"c92343b7665d4be1a505d86376e407fe","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.4","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"4"},{"id":"4123ad9f4bb04e969bea24bfcb1fae91","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.5","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"5"},{"id":"4e7c8b7dd2264e1185df07037e9cb57f","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.6","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"6"}]
     后加 "customerId" : "4fc55826857c497a95a35cc75e3175f5",

     */



    private String id;
    private String customerId;
    private String cusname;
    private String nameNum;
    private String nameSim;
    private String cusType;
    private String cusSource;
    private String customerPayment;
    private String firmNum;
    private String firmLoc;
    private String firmCapital;
    private String firmLegal;
    private String firmDate;
    private String firmType;
    private String firmBuscope;
    private String firmIndustry;
    private String linkmanOne;
    private String linkmanTwo;
    private String salesMan;
    private String other;
    private String cuser;
    private String cdt;
    private String uuser;
    private String udt;
    private String checkStatus;
    private String customerStatus;
    private String status;
    private String settlement;
    private String customerGrade;
    private String changeType;
    private String oilType;
    private String oilTypesName;
    private String payWay;
    private String billAsk;
    private String carNum;
    private String carType;
    private String supplyRate;
    private String supplyNum;
    private String supplyWay;
    private String wishArea;
    private String wishOil;
    private String otherSer;
    private String linkmanName;
    private String linkmanPhone;
    private LinkManMessBean linkManMess;
    private SaleManMessBean saleManMess;
    private OtherMessBean otherMess;
    private List<StrikePriceListBean> strikePriceList;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getNameNum() {
        return nameNum;
    }

    public void setNameNum(String nameNum) {
        this.nameNum = nameNum;
    }

    public String getNameSim() {
        return nameSim;
    }

    public void setNameSim(String nameSim) {
        this.nameSim = nameSim;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getCusSource() {
        return cusSource;
    }

    public void setCusSource(String cusSource) {
        this.cusSource = cusSource;
    }

    public String getCustomerPayment() {
        return customerPayment;
    }

    public void setCustomerPayment(String customerPayment) {
        this.customerPayment = customerPayment;
    }

    public String getFirmNum() {
        return firmNum;
    }

    public void setFirmNum(String firmNum) {
        this.firmNum = firmNum;
    }

    public String getFirmLoc() {
        return firmLoc;
    }

    public void setFirmLoc(String firmLoc) {
        this.firmLoc = firmLoc;
    }

    public String getFirmCapital() {
        return firmCapital;
    }

    public void setFirmCapital(String firmCapital) {
        this.firmCapital = firmCapital;
    }

    public String getFirmLegal() {
        return firmLegal;
    }

    public void setFirmLegal(String firmLegal) {
        this.firmLegal = firmLegal;
    }

    public String getFirmDate() {
        return firmDate;
    }

    public void setFirmDate(String firmDate) {
        this.firmDate = firmDate;
    }

    public String getFirmType() {
        return firmType;
    }

    public void setFirmType(String firmType) {
        this.firmType = firmType;
    }

    public String getFirmBuscope() {
        return firmBuscope;
    }

    public void setFirmBuscope(String firmBuscope) {
        this.firmBuscope = firmBuscope;
    }

    public String getFirmIndustry() {
        return firmIndustry;
    }

    public void setFirmIndustry(String firmIndustry) {
        this.firmIndustry = firmIndustry;
    }

    public String getLinkmanOne() {
        return linkmanOne;
    }

    public void setLinkmanOne(String linkmanOne) {
        this.linkmanOne = linkmanOne;
    }

    public String getLinkmanTwo() {
        return linkmanTwo;
    }

    public void setLinkmanTwo(String linkmanTwo) {
        this.linkmanTwo = linkmanTwo;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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

    public String getUdt() {
        return udt;
    }

    public void setUdt(String udt) {
        this.udt = udt;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getOilTypesName() {
        return oilTypesName;
    }

    public void setOilTypesName(String oilTypesName) {
        this.oilTypesName = oilTypesName;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getBillAsk() {
        return billAsk;
    }

    public void setBillAsk(String billAsk) {
        this.billAsk = billAsk;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getSupplyRate() {
        return supplyRate;
    }

    public void setSupplyRate(String supplyRate) {
        this.supplyRate = supplyRate;
    }

    public String getSupplyNum() {
        return supplyNum;
    }

    public void setSupplyNum(String supplyNum) {
        this.supplyNum = supplyNum;
    }

    public String getSupplyWay() {
        return supplyWay;
    }

    public void setSupplyWay(String supplyWay) {
        this.supplyWay = supplyWay;
    }

    public String getWishArea() {
        return wishArea;
    }

    public void setWishArea(String wishArea) {
        this.wishArea = wishArea;
    }

    public String getWishOil() {
        return wishOil;
    }

    public void setWishOil(String wishOil) {
        this.wishOil = wishOil;
    }

    public String getOtherSer() {
        return otherSer;
    }

    public void setOtherSer(String otherSer) {
        this.otherSer = otherSer;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public LinkManMessBean getLinkManMess() {
        return linkManMess;
    }

    public void setLinkManMess(LinkManMessBean linkManMess) {
        this.linkManMess = linkManMess;
    }

    public SaleManMessBean getSaleManMess() {
        return saleManMess;
    }

    public void setSaleManMess(SaleManMessBean saleManMess) {
        this.saleManMess = saleManMess;
    }

    public OtherMessBean getOtherMess() {
        return otherMess;
    }

    public void setOtherMess(OtherMessBean otherMess) {
        this.otherMess = otherMess;
    }

    public List<StrikePriceListBean> getStrikePriceList() {
        return strikePriceList;
    }

    public void setStrikePriceList(List<StrikePriceListBean> strikePriceList) {
        this.strikePriceList = strikePriceList;
    }

    public static class LinkManMessBean {
        /**
         * createTime : 2018-01-30 13:42:39
         * sex : 3
         * birth : 2018-01-29
         * belong : 55495a0d5942405099f86033e7266d4d
         * type : 0
         * licenceNum : null
         * id : 3242a379eb3c400a8f32edf0d0c17c83
         * userInfoId : 3b10bb1a5aa5401785f367e37f1c42f9
         * name : 张强改
         * driverAge : null
         * userId : 3b10bb1a5aa5401785f367e37f1c42f9
         * weChat : wechat1
         * createId : null
         * licenceType : null
         * userCode : GMJY000150
         * status : null
         * updateTime : 2018-01-30 16:52:37
         * driverLev : null
         * updateId : null
         * workNum : null
         * code : null
         * createName : null
         * updateName : 市场经理
         * email : ceshi1@163.com
         * driverRemark : null
         * telephone : 6666666
         * qqNum : 769609901
         * mobile : 1388888888
         */

        private String createTime;
        private String sex;
        private String birth;
        private String belong;
        private String type;
        private String licenceNum;
        private String id;
        private String userInfoId;
        private String name;
        private String driverAge;
        private String userId;
        private String weChat;
        private String createId;
        private String licenceType;
        private String userCode;
        private String status;
        private String updateTime;
        private String driverLev;
        private String updateId;
        private String workNum;
        @SerializedName("code")
        private String codeX;
        private String createName;
        private String updateName;
        private String email;
        private String driverRemark;
        private String telephone;
        private String qqNum;
        private String mobile;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getBelong() {
            return belong;
        }

        public void setBelong(String belong) {
            this.belong = belong;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLicenceNum() {
            return licenceNum;
        }

        public void setLicenceNum(String licenceNum) {
            this.licenceNum = licenceNum;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserInfoId() {
            return userInfoId;
        }

        public void setUserInfoId(String userInfoId) {
            this.userInfoId = userInfoId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDriverAge() {
            return driverAge;
        }

        public void setDriverAge(String driverAge) {
            this.driverAge = driverAge;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWeChat() {
            return weChat;
        }

        public void setWeChat(String weChat) {
            this.weChat = weChat;
        }

        public String getCreateId() {
            return createId;
        }

        public void setCreateId(String createId) {
            this.createId = createId;
        }

        public String getLicenceType() {
            return licenceType;
        }

        public void setLicenceType(String licenceType) {
            this.licenceType = licenceType;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getDriverLev() {
            return driverLev;
        }

        public void setDriverLev(String driverLev) {
            this.driverLev = driverLev;
        }

        public String getUpdateId() {
            return updateId;
        }

        public void setUpdateId(String updateId) {
            this.updateId = updateId;
        }

        public String getWorkNum() {
            return workNum;
        }

        public void setWorkNum(String workNum) {
            this.workNum = workNum;
        }

        public String getCodeX() {
            return codeX;
        }

        public void setCodeX(String codeX) {
            this.codeX = codeX;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDriverRemark() {
            return driverRemark;
        }

        public void setDriverRemark(String driverRemark) {
            this.driverRemark = driverRemark;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getQqNum() {
            return qqNum;
        }

        public void setQqNum(String qqNum) {
            this.qqNum = qqNum;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public static class SaleManMessBean {
        /**
         * userTel : 13666666666
         * userName : 业务员
         * userEmail : lmyou512@163.com
         */

        private String userTel;
        private String userName;
        private String userEmail;

        public String getUserTel() {
            return userTel;
        }

        public void setUserTel(String userTel) {
            this.userTel = userTel;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
    }

    public static class OtherMessBean {
        /**
         * customerSourceName : 合作伙伴
         * firmBuscopeName : 安防工程
         * settlementName : 现结算
         * customerTypeName : 企业
         * carTypeName : 客车
         * firmTypeName : 国有企业
         * firmIndustryName : 油气储运
         * payWayName : 账期结算
         * supplyWayName : 油罐
         */

        private String customerSourceName;
        private String firmBuscopeName;
        private String settlementName;
        private String customerTypeName;
        private String carTypeName;
        private String firmTypeName;
        private String firmIndustryName;
        private String payWayName;
        private String supplyWayName;
        private String customerPaymentName;
        private String customerGradeName;

        public String getCustomerPaymentName() {
            return customerPaymentName;
        }

        public void setCustomerPaymentName(String customerPaymentName) {
            this.customerPaymentName = customerPaymentName;
        }

        public String getCustomerGradeName() {
            return customerGradeName;
        }

        public void setCustomerGradeName(String customerGradeName) {
            this.customerGradeName = customerGradeName;
        }

        public String getCustomerSourceName() {
            return customerSourceName;
        }

        public void setCustomerSourceName(String customerSourceName) {
            this.customerSourceName = customerSourceName;
        }

        public String getFirmBuscopeName() {
            return firmBuscopeName;
        }

        public void setFirmBuscopeName(String firmBuscopeName) {
            this.firmBuscopeName = firmBuscopeName;
        }

        public String getSettlementName() {
            return settlementName;
        }

        public void setSettlementName(String settlementName) {
            this.settlementName = settlementName;
        }

        public String getCustomerTypeName() {
            return customerTypeName;
        }

        public void setCustomerTypeName(String customerTypeName) {
            this.customerTypeName = customerTypeName;
        }

        public String getCarTypeName() {
            return carTypeName;
        }

        public void setCarTypeName(String carTypeName) {
            this.carTypeName = carTypeName;
        }

        public String getFirmTypeName() {
            return firmTypeName;
        }

        public void setFirmTypeName(String firmTypeName) {
            this.firmTypeName = firmTypeName;
        }

        public String getFirmIndustryName() {
            return firmIndustryName;
        }

        public void setFirmIndustryName(String firmIndustryName) {
            this.firmIndustryName = firmIndustryName;
        }

        public String getPayWayName() {
            return payWayName;
        }

        public void setPayWayName(String payWayName) {
            this.payWayName = payWayName;
        }

        public String getSupplyWayName() {
            return supplyWayName;
        }

        public void setSupplyWayName(String supplyWayName) {
            this.supplyWayName = supplyWayName;
        }
    }

    public static class StrikePriceListBean {
        /**
         * id : 584c69ee89e74dd184553ed9a04825fe
         * nationalStandard : 4
         * customerId : 55495a0d5942405099f86033e7266d4d
         * performAmount : 5.1
         * province : 630000
         * provinceName : 青海省
         * discountAmount : 1
         * oilType : 1
         */

        private String id;
        private String nationalStandard;
        private String customerId;
        private String performAmount;
        private String province;
        private String provinceName;
        private String discountAmount;
        private String oilType;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getPerformAmount() {
            return performAmount;
        }

        public void setPerformAmount(String performAmount) {
            this.performAmount = performAmount;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(String discountAmount) {
            this.discountAmount = discountAmount;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }
    }


}
