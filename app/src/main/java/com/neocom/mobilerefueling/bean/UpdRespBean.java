package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/12/20.
 */

public class UpdRespBean extends BaseBean {
    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 35cf1a7920164388b2c7a6640ca71ae3
         * versionNo : 1.0.7
         * versionType : 1
         * versionState : 1
         * description : 1、本次更新由于改动比较大，需要卸载已安装的版本。
         2、测试一下啊 
         * filePath : 20180116092819731.0.6.apk
         * addTime : 2018-01-15 16:47:40
         * addUser : 17c4520f6cfd1ab53d8745e84681eb49
         * editTime : null
         * editUser : null
         * fileName : 哥们加油_用户端_1.0.6.apk
         * fileJson : null
         * fileList : null
         */

        private String id;
        private String versionNo;
        private String versionType;
        private String versionState;
        private String description;
        private String filePath;
        private String addTime;
        private String addUser;
        private String editTime;
        private String editUser;
        private String fileName;
        private String fileJson;
        private String fileList;
        private String upGrades;

        public String getUpGrades() {
            return upGrades;
        }

        public void setUpGrades(String upGrades) {
            this.upGrades = upGrades;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVersionNo() {
            return versionNo;
        }

        public void setVersionNo(String versionNo) {
            this.versionNo = versionNo;
        }

        public String getVersionType() {
            return versionType;
        }

        public void setVersionType(String versionType) {
            this.versionType = versionType;
        }

        public String getVersionState() {
            return versionState;
        }

        public void setVersionState(String versionState) {
            this.versionState = versionState;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
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

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileJson() {
            return fileJson;
        }

        public void setFileJson(String fileJson) {
            this.fileJson = fileJson;
        }

        public String getFileList() {
            return fileList;
        }

        public void setFileList(String fileList) {
            this.fileList = fileList;
        }
    }


//
//    /**
//     * bring : {"content":"1、优化了部分bug。 \\\\n 2、新增订单模块。 \\010 3、新增支付模块","appAddress":"https://pro-app-qn.fir.im/3e4a8ed2e11617739c5fdfd7e7c6002cce576279.apk?attname=%E7%94%A8%E6%88%B7%E7%AB%AF.apk_1.0.apk&e=1513675707&token=LOvmia8oXF4xnLh0IdH05XMYpH6ENHNpARlmPc-T:UBqsV5vAFIEQlEOIajVRuRLuPFA=","upgrateType":"0","appVersion":"V1.1","forceUpgrade":"1"}
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
//         * content : 1、优化了部分bug。 \\n 2、新增订单模块。 \010 3、新增支付模块
//         * appAddress : https://pro-app-qn.fir.im/3e4a8ed2e11617739c5fdfd7e7c6002cce576279.apk?attname=%E7%94%A8%E6%88%B7%E7%AB%AF.apk_1.0.apk&e=1513675707&token=LOvmia8oXF4xnLh0IdH05XMYpH6ENHNpARlmPc-T:UBqsV5vAFIEQlEOIajVRuRLuPFA=
//         * upgrateType : 0
//         * appVersion : V1.1
//         * forceUpgrade : 1
//         */
//
//        private String content;
//        private String appAddress;
//        private String upgrateType;
//        private String appVersion;
//        private String forceUpgrade;
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public String getAppAddress() {
//            return appAddress;
//        }
//
//        public void setAppAddress(String appAddress) {
//            this.appAddress = appAddress;
//        }
//
//        public String getUpgrateType() {
//            return upgrateType;
//        }
//
//        public void setUpgrateType(String upgrateType) {
//            this.upgrateType = upgrateType;
//        }
//
//        public String getAppVersion() {
//            return appVersion;
//        }
//
//        public void setAppVersion(String appVersion) {
//            this.appVersion = appVersion;
//        }
//
//        public String getForceUpgrade() {
//            return forceUpgrade;
//        }
//
//        public void setForceUpgrade(String forceUpgrade) {
//            this.forceUpgrade = forceUpgrade;
//        }
//    }
}
