package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/12/7.
 */

public class PaiSongDanCommitBean implements Serializable {


    /**
     * u_user : 39931489bb224746ba0d0e23d20a4ced
     * remark :
     * oilAmount : 50
     * id : 33822a894efd4198aa6c0df3f9504ce3
     * payType : 0
     * carList : [{"telphone":"0531-22220001","tankSize":"50","oilType":"2","oilBalance":"20","oilTotal":"1000","nationalStandard":"2","pName":"小明","vehicleCode":"鲁A88899","finishTime":"2017-10-24 07:26:00"}]
     * payAmount : 1000
     */

    private String u_user;
    private String remark;
    private String oilAmount;
    private String id;
    private String payType;
    private String payAmount;
    private String finishPerson;
    private List<CarListBean> carList;


    public String getFinishPerson() {
        return finishPerson;
    }

    public void setFinishPerson(String finishPerson) {
        this.finishPerson = finishPerson;
    }

    public String getU_user() {
        return u_user;
    }

    public void setU_user(String u_user) {
        this.u_user = u_user;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOilAmount() {
        return oilAmount;
    }

    public void setOilAmount(String oilAmount) {
        this.oilAmount = oilAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<CarListBean> getCarList() {
        return carList;
    }

    public void setCarList(List<CarListBean> carList) {
        this.carList = carList;
    }

    public static class CarListBean {
        /**
         * telphone : 0531-22220001
         * tankSize : 50
         * oilType : 2
         * oilBalance : 20
         * oilTotal : 1000
         * nationalStandard : 2
         * pName : 小明
         * vehicleCode : 鲁A88899
         * finishTime : 2017-10-24 07:26:00
         */

        private String telphone;
        private String tankSize;
        private String oilType;
        private String oilTypeName;
        private String oilBalance;
        private String oilTotal;
        private String nationalStandard;
        private String nationalStandardName;
        private String pName;
        private String vehicleCode;
        private String finishTime;
        private String docType;
        private String settleUnit;

        private String oilBalance_show;
        private String tankSize_show;
        private String oilTotal_show;

//          "oilBalance": "5.5 ",  //油品单价(计算值)
//                  "oilBalance_show":"5.5元/升", //油品单价(展示值)
//                  "tankSize": "2000",//加油量(计算值)
//                  " tankSize_show ": "2000.00升",  //加油量(展示值)


        public String getOilTotal_show() {
            return oilTotal_show;
        }

        public void setOilTotal_show(String oilTotal_show) {
            this.oilTotal_show = oilTotal_show;
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

        public String getSettleUnit() {
            return settleUnit;
        }

        public void setSettleUnit(String settleUnit) {
            this.settleUnit = settleUnit;
        }

        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

        //        private String jinEMoney;

//        public String getJinEMoney() {
//            return jinEMoney;
//        }
//
//        public void setJinEMoney(String jinEMoney) {
//            this.jinEMoney = jinEMoney;
//        }

        public String getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(String oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getNationalStandardName() {
            return nationalStandardName;
        }

        public void setNationalStandardName(String nationalStandardName) {
            this.nationalStandardName = nationalStandardName;
        }


        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getTankSize() {
            return tankSize;
        }

        public void setTankSize(String tankSize) {
            this.tankSize = tankSize;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getOilBalance() {
            return oilBalance;
        }

        public void setOilBalance(String oilBalance) {
            this.oilBalance = oilBalance;
        }

        public String getOilTotal() {
            return oilTotal;
        }

        public void setOilTotal(String oilTotal) {
            this.oilTotal = oilTotal;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public String getVehicleCode() {
            return vehicleCode;
        }

        public void setVehicleCode(String vehicleCode) {
            this.vehicleCode = vehicleCode;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return "CarListBean{" +
                    "telphone='" + telphone + '\'' +
                    ", tankSize='" + tankSize + '\'' +
                    ", oilType='" + oilType + '\'' +
                    ", oilTypeName='" + oilTypeName + '\'' +
                    ", oilBalance='" + oilBalance + '\'' +
                    ", oilTotal='" + oilTotal + '\'' +
                    ", nationalStandard='" + nationalStandard + '\'' +
                    ", nationalStandardName='" + nationalStandardName + '\'' +
                    ", pName='" + pName + '\'' +
                    ", vehicleCode='" + vehicleCode + '\'' +
                    ", finishTime='" + finishTime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PaiSongDanCommitBean{" +
                "u_user='" + u_user + '\'' +
                ", remark='" + remark + '\'' +
                ", oilAmount='" + oilAmount + '\'' +
                ", id='" + id + '\'' +
                ", payType='" + payType + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", carList=" + carList +
                '}';
    }
}
