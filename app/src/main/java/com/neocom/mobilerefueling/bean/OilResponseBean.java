package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/11/15.
 */

public class OilResponseBean extends BaseBean {


    /**
     * bring : {"id":"0caef9be19ac4cdd8fbabd0a19d89ba7","oilType":"2","startTime":"2017-10-20 00:00:00","endTime":null,"oilPrice":"123","status":null,"addTime":"2017-10-20 16:09:36","addUser":"17c4520f6cfd1ab53d8745e84681eb49","editTime":null,"editUser":null,"remark":"","oilTypeName":null,"nationalStandard":"1","nationalStandardName":null,"area":"110000","areaName":null}
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
         * id : 0caef9be19ac4cdd8fbabd0a19d89ba7
         * oilType : 2
         * startTime : 2017-10-20 00:00:00
         * endTime : null
         * oilPrice : 123
         * status : null
         * addTime : 2017-10-20 16:09:36
         * addUser : 17c4520f6cfd1ab53d8745e84681eb49
         * editTime : null
         * editUser : null
         * remark :
         * oilTypeName : null
         * nationalStandard : 1
         * nationalStandardName : null
         * area : 110000
         * areaName : null
         */

        private String id;
        private String oilType;
        private String startTime;
        private Object endTime;
        private String oilPrice;
        private Object status;
        private String addTime;
        private String addUser;
        private Object editTime;
        private Object editUser;
        private String remark;
        private Object oilTypeName;
        private String nationalStandard;
        private Object nationalStandardName;
        private String area;
        private Object areaName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getOilPrice() {
            return oilPrice;
        }

        public void setOilPrice(String oilPrice) {
            this.oilPrice = oilPrice;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getAddUser() {
            return addUser;
        }

        public void setAddUser(String addUser) {
            this.addUser = addUser;
        }

        public Object getEditTime() {
            return editTime;
        }

        public void setEditTime(Object editTime) {
            this.editTime = editTime;
        }

        public Object getEditUser() {
            return editUser;
        }

        public void setEditUser(Object editUser) {
            this.editUser = editUser;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getOilTypeName() {
            return oilTypeName;
        }

        public void setOilTypeName(Object oilTypeName) {
            this.oilTypeName = oilTypeName;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public Object getNationalStandardName() {
            return nationalStandardName;
        }

        public void setNationalStandardName(Object nationalStandardName) {
            this.nationalStandardName = nationalStandardName;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Object getAreaName() {
            return areaName;
        }

        public void setAreaName(Object areaName) {
            this.areaName = areaName;
        }
    }
}
