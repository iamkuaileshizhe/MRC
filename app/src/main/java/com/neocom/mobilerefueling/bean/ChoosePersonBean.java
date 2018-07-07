package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/23.
 */

public class ChoosePersonBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * userInfoId : 2b253cc303f747e293261e0d1899c02f
         * userName : 李四
         * userInfoUserId : c1e520bd6f5a47719346eb377ab52a6a
         * sex : 1
         * userInfoEmail : aaaa
         * userInfoAddress : null
         * userInfoMobile : aaaa
         * userInfoPost : null
         * userInfoStatus : null
         * userInfoQq : aaaa
         * userInfoWeixin : aaaa
         */

        private String userInfoId;
        private String userName;
        private String userInfoUserId;
        private String sex;
        private String userInfoEmail;
        private Object userInfoAddress;
        private String userInfoMobile;
        private Object userInfoPost;
        private Object userInfoStatus;
        private String userInfoQq;
        private String userInfoWeixin;

        public String getUserInfoId() {
            return userInfoId;
        }

        public void setUserInfoId(String userInfoId) {
            this.userInfoId = userInfoId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserInfoUserId() {
            return userInfoUserId;
        }

        public void setUserInfoUserId(String userInfoUserId) {
            this.userInfoUserId = userInfoUserId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUserInfoEmail() {
            return userInfoEmail;
        }

        public void setUserInfoEmail(String userInfoEmail) {
            this.userInfoEmail = userInfoEmail;
        }

        public Object getUserInfoAddress() {
            return userInfoAddress;
        }

        public void setUserInfoAddress(Object userInfoAddress) {
            this.userInfoAddress = userInfoAddress;
        }

        public String getUserInfoMobile() {
            return userInfoMobile;
        }

        public void setUserInfoMobile(String userInfoMobile) {
            this.userInfoMobile = userInfoMobile;
        }

        public Object getUserInfoPost() {
            return userInfoPost;
        }

        public void setUserInfoPost(Object userInfoPost) {
            this.userInfoPost = userInfoPost;
        }

        public Object getUserInfoStatus() {
            return userInfoStatus;
        }

        public void setUserInfoStatus(Object userInfoStatus) {
            this.userInfoStatus = userInfoStatus;
        }

        public String getUserInfoQq() {
            return userInfoQq;
        }

        public void setUserInfoQq(String userInfoQq) {
            this.userInfoQq = userInfoQq;
        }

        public String getUserInfoWeixin() {
            return userInfoWeixin;
        }

        public void setUserInfoWeixin(String userInfoWeixin) {
            this.userInfoWeixin = userInfoWeixin;
        }
    }
}
