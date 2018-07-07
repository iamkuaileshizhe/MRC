package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/12/14.
 */

public class MsgBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 2c199745600a4f638c809dcd798ec953
         * sender : null
         * receiver : 917f2f6eb1ce42a5968ee3a76bcf07c9
         * type : 2
         * mark : 21
         * content : 您有未确认的订单【ORDER20171213000020】,请尽快处理.
         * subject : null
         * relatedId : b2e7d45bd99343fbbc83760493731b8b
         * senderName : null
         * receiverName : 于紫洋
         * status : 1
         * addTime : 2017-12-13 18:24:12
         * addUser : null
         * editTime : null
         * editUser : null
         */

        private String id;
        private String sender;
        private String receiver;
        private String type;
        private String mark;
        private String content;
        private String subject;
        private String relatedId;
        private String senderName;
        private String receiverName;
        private String status;
        private String addTime;
        private String addUser;
        private String editTime;
        private String editUser;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getRelatedId() {
            return relatedId;
        }

        public void setRelatedId(String relatedId) {
            this.relatedId = relatedId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
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

        public String getEditTime() {
            return editTime;
        }

        public void setEditTime(String editTime) {
            this.editTime = editTime;
        }

        public String getEditUser() {
            return editUser;
        }

        public void setEditUser(String editUser) {
            this.editUser = editUser;
        }
    }
}
