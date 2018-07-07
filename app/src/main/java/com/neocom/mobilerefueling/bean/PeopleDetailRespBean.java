package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/3/7.
 */

public class PeopleDetailRespBean extends BaseBean {
    /**
     * bring : {"carNum":"青A92351","userStatus":"0","joinType":"1"}
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
         * carNum : 青A92351
         * userStatus : 0
         * joinType : 1
         */

        ////       joinType  岗位类型  安全员 或者是 司机
////        userStatus 上班0  或者是 下班 1

        private String carNum;
        private String userStatus;
        private String joinType;

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getJoinType() {
            return joinType;
        }

        public void setJoinType(String joinType) {
            this.joinType = joinType;
        }
    }


//
//    /**
//     * bring : {"carNum":"鲁A6661","joinStatus":"1","userStatus":"1"}
//     */
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
//         * carNum : 鲁A6661
//         * joinStatus : 1
//         * userStatus : 1
//         */
//
//        private String carNum;
//        private String joinStatus;
//
//        private String joinType;
//        private String userStatus;
//
////       joinType  岗位类型  安全员 或者是 司机
////        userStatus 上班0  或者是 下班 1
//
//
//        public String getJoinType() {
//            return joinType;
//        }
//
//        public void setJoinType(String joinType) {
//            this.joinType = joinType;
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
//        public String getJoinStatus() {
//            return joinStatus;
//        }
//
//        public void setJoinStatus(String joinStatus) {
//            this.joinStatus = joinStatus;
//        }
//
//        public String getUserStatus() {
//            return userStatus;
//        }
//
//        public void setUserStatus(String userStatus) {
//            this.userStatus = userStatus;
//        }
//    }
}
