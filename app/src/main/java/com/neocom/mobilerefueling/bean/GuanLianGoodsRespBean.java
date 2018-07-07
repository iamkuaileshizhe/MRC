package com.neocom.mobilerefueling.bean;


import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class GuanLianGoodsRespBean extends BaseBean {


    /**
     * purl : properties/code.properties
     * code : null
     * bring : [{"id":"738499fe3c704aea894ced9dc840470d","no":"00000008","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"test222123","brand":"","specis":"123","unit":"4","barCode":"1233211","unitPrice":"","sysStatus":"1","memo":"","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-05-04 12:10:07","editUser":null,"editTime":null,"status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"bae3537aa866448598c776dab2a42062","no":"00000007","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"123","brand":"22","specis":"11","unit":"6","barCode":"212","unitPrice":"11223","sysStatus":"1","memo":"2121","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-18 15:20:13","editUser":"17c4520f6cfd1ab53d8745e84681eb49","editTime":"2018-04-18 15:21:26","status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"d8735f2c59a5443e9dfa576992d9cc40","no":"00000006","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"1","brand":"","specis":"1122","unit":"6","barCode":"","unitPrice":"","sysStatus":"1","memo":"","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-18 11:21:15","editUser":null,"editTime":null,"status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"2ce3fb1861bc4d4dbeb16267e14d5fac","no":"00000005","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"123","brand":"22","specis":"e1","unit":"1","barCode":"3121","unitPrice":"112","sysStatus":"1","memo":"2212","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-18 10:22:35","editUser":"17c4520f6cfd1ab53d8745e84681eb49","editTime":"2018-04-18 10:23:06","status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"25aa090737704c928efb2f5b09eb2996","no":"00000004","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"111111","brand":"","specis":"1122","unit":"6","barCode":"","unitPrice":"","sysStatus":"0","memo":"","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-17 14:36:27","editUser":null,"editTime":null,"status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"3719ea50af8c469cb5d6cfd8a1754944","no":"00000003","gclassId":"0d70c229b34545268e8ebba0980d69d5","gclassName":"第三级","name":"test333","brand":"113","specis":"11223","unit":"2","barCode":"33","unitPrice":"113321","sysStatus":"0","memo":"113","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-17 14:14:16","editUser":"17c4520f6cfd1ab53d8745e84681eb49","editTime":"2018-04-18 15:21:47","status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"f6e04c1482164b9589ac11f713d12bb9","no":"00000002","gclassId":"0d70c229b34545268e8ebba0980d69d5","gclassName":"第三级","name":"test2","brand":"22","specis":"333","unit":"5","barCode":"12355","unitPrice":"111","sysStatus":"0","memo":"1122","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-17 13:31:07","editUser":null,"editTime":null,"status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null},{"id":"1cc27bdf5aad41d7b282620fee34c435","no":"00000001","gclassId":"38d7da4834cd428792659340b70a9b7a","gclassName":"test","name":"test1222","brand":"1122","specis":"1122","unit":"6","barCode":"1232","unitPrice":"0.02","sysStatus":"0","memo":"1aaa22","addUser":"17c4520f6cfd1ab53d8745e84681eb49","addTime":"2018-04-17 13:29:51","editUser":"17c4520f6cfd1ab53d8745e84681eb49","editTime":"2018-04-23 09:23:55","status":"1","totalPrice":null,"inNumber":null,"serialNumber":null,"useableNum":null,"converUnit":null,"converNum":null,"checked":null}]
     */

    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 738499fe3c704aea894ced9dc840470d
         * no : 00000008
         * gclassId : 38d7da4834cd428792659340b70a9b7a
         * gclassName : test
         * name : test222123
         * brand :
         * specis : 123
         * unit : 4
         * barCode : 1233211
         * unitPrice :
         * sysStatus : 1
         * memo :
         * addUser : 17c4520f6cfd1ab53d8745e84681eb49
         * addTime : 2018-05-04 12:10:07
         * editUser : null
         * editTime : null
         * status : 1
         * totalPrice : null
         * inNumber : null
         * serialNumber : null
         * useableNum : null
         * converUnit : null
         * converNum : null
         * checked : null
         */

        private String id;
        private String no;
        private String gclassId;
        private String gclassName;
        private String name;
        private String brand;
        private String specis;
        private String unit;
        private String barCode;
        private String unitPrice;
        private String sysStatus;
        private String memo;
        private String addUser;
        private String addTime;
        private String editUser;
        private String editTime;
        private String status;
        private String totalPrice;
        //        private String inNumber;
        private String serialNumber;
        private String useableNum;
        private String converUnit;
        private String converNum;
        private String checked;
        private String num;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getGclassId() {
            return gclassId;
        }

        public void setGclassId(String gclassId) {
            this.gclassId = gclassId;
        }

        public String getGclassName() {
            return gclassName;
        }

        public void setGclassName(String gclassName) {
            this.gclassName = gclassName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getSpecis() {
            return specis;
        }

        public void setSpecis(String specis) {
            this.specis = specis;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getBarCode() {
            return barCode;
        }

        public void setBarCode(String barCode) {
            this.barCode = barCode;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getSysStatus() {
            return sysStatus;
        }

        public void setSysStatus(String sysStatus) {
            this.sysStatus = sysStatus;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

//        public String getInNumber() {
//            return inNumber;
//        }
//
//        public void setInNumber(String inNumber) {
//            this.inNumber = inNumber;
//        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getUseableNum() {
            return useableNum;
        }

        public void setUseableNum(String useableNum) {
            this.useableNum = useableNum;
        }

        public String getConverUnit() {
            return converUnit;
        }

        public void setConverUnit(String converUnit) {
            this.converUnit = converUnit;
        }

        public String getConverNum() {
            return converNum;
        }

        public void setConverNum(String converNum) {
            this.converNum = converNum;
        }

        public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }
    }
}
