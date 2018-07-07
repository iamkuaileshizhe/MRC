package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/12.
 */

public class AddressListRequest extends BaseBean {


    /**
     * purl : properties/code.properties
     * res : true
     * code : null
     * message : 数据查询成功！
     * bring : [{"region":null,"status":"1","u_dt":"2017-08-10 14:01:51","telphone":"范德萨","city":"110100","id":"e0cb977eb86b4931a89c68c584ceb296","area":"范德萨","address":"范德萨","isDefault":"1","userId":"c19c0ea8d8df468ab1e9e2582e0b2a00","c_user":"c19c0ea8d8df468ab1e9e2582e0b2a00","province":"110000","pname":"多大","cname":"范德萨","u_user":"c19c0ea8d8df468ab1e9e2582e0b2a00","c_dt":"2017-08-10 14:01:51"}]
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
         * region : null
         * status : 1
         * u_dt : 2017-08-10 14:01:51
         * telphone : 范德萨
         * city : 110100
         * id : e0cb977eb86b4931a89c68c584ceb296
         * area : 范德萨
         * address : 范德萨
         * isDefault : 1
         * userId : c19c0ea8d8df468ab1e9e2582e0b2a00
         * c_user : c19c0ea8d8df468ab1e9e2582e0b2a00
         * province : 110000
         * pname : 多大
         * cname : 范德萨
         * u_user : c19c0ea8d8df468ab1e9e2582e0b2a00
         * c_dt : 2017-08-10 14:01:51
         */

        private String region;
        private String status;
        private String u_dt;
        private String telphone;
        private String city;
        private String id;
        private String area;
        private String address;
        private String isDefault;
        private String userId;
        private String c_user;
        private String province;
        private String pname;
        private String cname;
        private String u_user;
        private String c_dt;
        private boolean isChecked;
        private String towns;

        @Override
        public String toString() {
            return "BringBean{" +
                    "region='" + region + '\'' +
                    ", status='" + status + '\'' +
                    ", u_dt='" + u_dt + '\'' +
                    ", telphone='" + telphone + '\'' +
                    ", city='" + city + '\'' +
                    ", id='" + id + '\'' +
                    ", area='" + area + '\'' +
                    ", address='" + address + '\'' +
                    ", isDefault='" + isDefault + '\'' +
                    ", userId='" + userId + '\'' +
                    ", c_user='" + c_user + '\'' +
                    ", province='" + province + '\'' +
                    ", pname='" + pname + '\'' +
                    ", cname='" + cname + '\'' +
                    ", u_user='" + u_user + '\'' +
                    ", c_dt='" + c_dt + '\'' +
                    ", isChecked=" + isChecked +
                    ", towns='" + towns + '\'' +
                    '}';
        }

        public String getTowns() {
            return towns;
        }

        public void setTowns(String towns) {
            this.towns = towns;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public String getRegion() {
            return region == null ? "" : region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getStatus() {
            return status == null ? "" : status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getU_dt() {
            return u_dt == null ? "" : u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getTelphone() {
            return telphone == null ? "" : telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getCity() {
            return city == null ? "" : city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getId() {
            return id == null ? "" : id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getArea() {
            return area == null ? "" : area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address == null ? "" : address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIsDefault() {
            return isDefault == null ? "" : isDefault;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }

        public String getUserId() {
            return userId == null ? "" : userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getC_user() {
            return c_user == null ? "" : c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getProvince() {
            return province == null ? "" : province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getPname() {
            return pname == null ? "" : pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getCname() {
            return cname == null ? "" : cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getU_user() {
            return u_user == null ? "" : u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getC_dt() {
            return c_dt == null ? "" : c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

    }

    @Override
    public String toString() {
        return "AddressListRequest{" +
                "bring=" + bring +
                '}';
    }
}
