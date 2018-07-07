package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RecmentRespListBean extends BaseBean {
    /**
     * code : null
     * bring : {"total":1,"rUserName":null,"recomList":[{"id":"a595378325a54d38a10c0dd866e04c41","ruserId":"3079b9844f9f4b25a06cf3a0224f8f37","recommCode":"259295","cid":"22a49551de7f4e21a5882970dcd72d04","addTime":"2018-03-29 16:38:34","status":"1","cname":"小迷糊","cno":"C20180329007","cuser":"d373aa6c41384993b8b37fb24d24fc65","mobile":"17778198225"}]}
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
         * total : 1
         * rUserName : null
         * recomList : [{"id":"a595378325a54d38a10c0dd866e04c41","ruserId":"3079b9844f9f4b25a06cf3a0224f8f37","recommCode":"259295","cid":"22a49551de7f4e21a5882970dcd72d04","addTime":"2018-03-29 16:38:34","status":"1","cname":"小迷糊","cno":"C20180329007","cuser":"d373aa6c41384993b8b37fb24d24fc65","mobile":"17778198225"}]
         */

        private String total;
        private String rUserName;
        private List<RecomListBean> recomList;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getRUserName() {
            return rUserName;
        }

        public void setRUserName(String rUserName) {
            this.rUserName = rUserName;
        }

        public List<RecomListBean> getRecomList() {
            return recomList;
        }

        public void setRecomList(List<RecomListBean> recomList) {
            this.recomList = recomList;
        }

        public static class RecomListBean {
            /**
             * id : a595378325a54d38a10c0dd866e04c41
             * ruserId : 3079b9844f9f4b25a06cf3a0224f8f37
             * recommCode : 259295
             * cid : 22a49551de7f4e21a5882970dcd72d04
             * addTime : 2018-03-29 16:38:34
             * status : 1
             * cname : 小迷糊
             * cno : C20180329007
             * cuser : d373aa6c41384993b8b37fb24d24fc65
             * mobile : 17778198225
             */

            private String id;
            private String ruserId;
            private String recommCode;
            private String cid;
            private String addTime;
            private String status;
            private String cname;
            private String cno;
            private String cuser;
            private String mobile;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRuserId() {
                return ruserId;
            }

            public void setRuserId(String ruserId) {
                this.ruserId = ruserId;
            }

            public String getRecommCode() {
                return recommCode;
            }

            public void setRecommCode(String recommCode) {
                this.recommCode = recommCode;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getCno() {
                return cno;
            }

            public void setCno(String cno) {
                this.cno = cno;
            }

            public String getCuser() {
                return cuser;
            }

            public void setCuser(String cuser) {
                this.cuser = cuser;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }
        }
    }


//    /**
//     * code : null
//     * bring : {"total":1,"rUserName":null,"recomList":[{"id":"a595378325a54d38a10c0dd866e04c41","ruserId":"3079b9844f9f4b25a06cf3a0224f8f37","recommCode":"259295","cid":"22a49551de7f4e21a5882970dcd72d04","addTime":"2018-03-29 16:38:34","status":"1","cname":"小迷糊","cno":"C20180329007"}]}
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
//         * total : 1
//         * rUserName : null
//         * recomList : [{"id":"a595378325a54d38a10c0dd866e04c41","ruserId":"3079b9844f9f4b25a06cf3a0224f8f37","recommCode":"259295","cid":"22a49551de7f4e21a5882970dcd72d04","addTime":"2018-03-29 16:38:34","status":"1","cname":"小迷糊","cno":"C20180329007"}]
//         */
//
//        private String total;
//        private String rUserName;
//        private List<RecomListBean> recomList;
//
//        public String getTotal() {
//            return total;
//        }
//
//        public void setTotal(String total) {
//            this.total = total;
//        }
//
//        public String getRUserName() {
//            return rUserName;
//        }
//
//        public void setRUserName(String rUserName) {
//            this.rUserName = rUserName;
//        }
//
//        public List<RecomListBean> getRecomList() {
//            return recomList;
//        }
//
//        public void setRecomList(List<RecomListBean> recomList) {
//            this.recomList = recomList;
//        }
//
//        public static class RecomListBean {
//            /**
//             * id : a595378325a54d38a10c0dd866e04c41
//             * ruserId : 3079b9844f9f4b25a06cf3a0224f8f37
//             * recommCode : 259295
//             * cid : 22a49551de7f4e21a5882970dcd72d04
//             * addTime : 2018-03-29 16:38:34
//             * status : 1
//             * cname : 小迷糊
//             * cno : C20180329007
//             */
//
//            private String id;
//            private String ruserId;
//            private String recommCode;
//            private String cid;
//            private String addTime;
//            private String status;
//            private String cname;
//            private String cno;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getRuserId() {
//                return ruserId;
//            }
//
//            public void setRuserId(String ruserId) {
//                this.ruserId = ruserId;
//            }
//
//            public String getRecommCode() {
//                return recommCode;
//            }
//
//            public void setRecommCode(String recommCode) {
//                this.recommCode = recommCode;
//            }
//
//            public String getCid() {
//                return cid;
//            }
//
//            public void setCid(String cid) {
//                this.cid = cid;
//            }
//
//            public String getAddTime() {
//                return addTime;
//            }
//
//            public void setAddTime(String addTime) {
//                this.addTime = addTime;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getCname() {
//                return cname;
//            }
//
//            public void setCname(String cname) {
//                this.cname = cname;
//            }
//
//            public String getCno() {
//                return cno;
//            }
//
//            public void setCno(String cno) {
//                this.cno = cno;
//            }
//        }
//    }

}
