package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/7.
 */

public class LoginResponseBean extends BaseBean {
    /**
     * bring : {"deptName":null,"carId":"4e95b5be3d0047d393c6a0706070e49b","carryStatus":"0","carNum":"青A92351","userInfoMobile":"13519703320","userId":"4ed9a8a55da841df8f7517c508d90c35","userInfoEmail":"","userName":"李永高","roleCode":"r_refuel_j_gmjy,","deptId":null,"listSetting":[{"id":"1","uiValue":"0","c_user":"87342145f3514103ac9f4d03405bdf42","uiKey":"item_quality","userId":"87342145f3514103ac9f4d03405bdf42","c_dt":"2018-06-21 15:08"}]}
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
         * deptName : null
         * carId : 4e95b5be3d0047d393c6a0706070e49b
         * carryStatus : 0
         * carNum : 青A92351
         * userInfoMobile : 13519703320
         * userId : 4ed9a8a55da841df8f7517c508d90c35
         * userInfoEmail :
         * userName : 李永高
         * roleCode : r_refuel_j_gmjy,
         * deptId : null
         * listSetting : [{"id":"1","uiValue":"0","c_user":"87342145f3514103ac9f4d03405bdf42","uiKey":"item_quality","userId":"87342145f3514103ac9f4d03405bdf42","c_dt":"2018-06-21 15:08"}]
         */

        private String deptName;
        private String carId;
        private String carryStatus;
        private String carNum;
        private String userInfoMobile;
        private String userId;
        private String userInfoEmail;
        private String userName;
        private String roleCode;
        private String deptId;
        private ListSettingBean listSetting;

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getCarId() {
            return carId;
        }

        public void setCarId(String carId) {
            this.carId = carId;
        }

        public String getCarryStatus() {
            return carryStatus;
        }

        public void setCarryStatus(String carryStatus) {
            this.carryStatus = carryStatus;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getUserInfoMobile() {
            return userInfoMobile;
        }

        public void setUserInfoMobile(String userInfoMobile) {
            this.userInfoMobile = userInfoMobile;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserInfoEmail() {
            return userInfoEmail;
        }

        public void setUserInfoEmail(String userInfoEmail) {
            this.userInfoEmail = userInfoEmail;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRoleCode() {
            return roleCode;
        }

        public void setRoleCode(String roleCode) {
            this.roleCode = roleCode;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public ListSettingBean getListSetting() {
            return listSetting;
        }

        public void setListSetting(ListSettingBean listSetting) {
            this.listSetting = listSetting;
        }


    }


//    
//    
//    /**
//     * bring : {"deptName":"北京哥们加油网络科技有限公司","carryStatus":"0","carNum":"青A92351","userInfoMobile":"13153031529","userId":"497765600da547cea7c7d30dccff67fb","userInfoEmail":"lmyou512@163.com","userName":"欧书梦","roleCode":"r_refuel_gmjy,","deptId":"43813637c5364d638147a0e1bd3b22b2"}
//     */
//
//    /**
//     * carryStatus	String	Y	在班状态：0在班，1下班
//     * carNum	String	Y	车牌号
//     * deptName	String	Y	部门名称
//     * userInfoMobile	String	Y	联系方式
//     * userId	String	Y	用户标识
//     * userInfoEmail	String	Y	用户邮箱
//     * userName	String	Y	用户姓名
//     * roleCode	String	Y	用户角色编码
//     * deptId	String	Y	用户部门标识
//     */
//
//
//    private BringBean bring;
//
//    public BringBean getBring() {
//        return bring;
//    }
//
//    public void setBring(BringBean bring) {
//        this.bring = bring;
//    }
//
//    public static class BringBean {
//        /**
//         * deptName : 北京哥们加油网络科技有限公司
//         * carryStatus : 0
//         * carNum : 青A92351
//         * userInfoMobile : 13153031529
//         * userId : 497765600da547cea7c7d30dccff67fb
//         * userInfoEmail : lmyou512@163.com
//         * userName : 欧书梦
//         * roleCode : r_refuel_gmjy,
//         * deptId : 43813637c5364d638147a0e1bd3b22b2
//         */
//
//        private String deptName;
//        private String carryStatus;
//        private String carNum;
//        private String userInfoMobile;
//        private String userId;
//        private String userInfoEmail;
//        private String userName;
//        private String roleCode;
//        private String deptId;
//        private String carId;
//
//        public String getCarId() {
//            return carId;
//        }
//
//        public void setCarId(String carId) {
//            this.carId = carId;
//        }
//
//        public String getDeptName() {
//            return deptName;
//        }
//
//        public void setDeptName(String deptName) {
//            this.deptName = deptName;
//        }
//
//        public String getCarryStatus() {
//            return carryStatus;
//        }
//
//        public void setCarryStatus(String carryStatus) {
//            this.carryStatus = carryStatus;
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
//        public String getUserInfoMobile() {
//            return userInfoMobile;
//        }
//
//        public void setUserInfoMobile(String userInfoMobile) {
//            this.userInfoMobile = userInfoMobile;
//        }
//
//        public String getUserId() {
//            return userId;
//        }
//
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//
//        public String getUserInfoEmail() {
//            return userInfoEmail;
//        }
//
//        public void setUserInfoEmail(String userInfoEmail) {
//            this.userInfoEmail = userInfoEmail;
//        }
//
//        public String getUserName() {
//            return userName;
//        }
//
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//
//        public String getRoleCode() {
//            return roleCode;
//        }
//
//        public void setRoleCode(String roleCode) {
//            this.roleCode = roleCode;
//        }
//
//        public String getDeptId() {
//            return deptId;
//        }
//
//        public void setDeptId(String deptId) {
//            this.deptId = deptId;
//        }
//
//        @Override
//        public String toString() {
//            return "BringBean{" +
//                    "deptName='" + deptName + '\'' +
//                    ", carryStatus='" + carryStatus + '\'' +
//                    ", carNum='" + carNum + '\'' +
//                    ", userInfoMobile='" + userInfoMobile + '\'' +
//                    ", userId='" + userId + '\'' +
//                    ", userInfoEmail='" + userInfoEmail + '\'' +
//                    ", userName='" + userName + '\'' +
//                    ", roleCode='" + roleCode + '\'' +
//                    ", deptId='" + deptId + '\'' +
//                    '}';
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "LoginResponseBean{" +
//                "bring=" + bring +
//                '}';
//    }
}
