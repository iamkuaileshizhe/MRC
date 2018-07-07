package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/10/25.
 */

public class PiciDetailBean implements Serializable {
    /**
     * purl : properties/code.properties
     * res : true
     * code : message.common.0001
     * message : 新建成功
     * bring : {"id":"8b94df0a96df4572a1cc206d7d9a8ca5","batchNum":"P20180322003","batchNo":null,"fuelModel":"2","fuelModelName":"0号柴油","nationalStandard":"4","standardName":"国五","fuelDensity":"0.85","supplyId":"84c3b6d7443d4eb69c5ea0f53847a7fb","supplyName":"","supplyName1":"山东中石化公司","supplyTel":"","fileName":null,"remark":"","fileList":[{"id":"175b1de7a965409b906aa549cfa9d833","fileName":"20180322135905432.pdf","fileOldname":"20170822-407（调和封罐） 普通柴油质量分析报告.pdf","fileUploaddate":"2018-03-22 13:59:05","fileType":".pdf","fileUrl":"20180322135905432.pdf","fileStatus":null,"fileRemark":"225233.00","addTime":null,"addUser":"superadmin","editTime":null,"editUser":null,"status":null,"fileSize":null,"user":{"userId":null,"userCode":null,"password":null,"deptId":null,"cdt":null,"cuser":null,"uuser":null,"udt":null,"status":null,"checked":null,"userName":null,"userInfoEmail":null,"userInfoMobile":null,"userInfoQq":null,"userInfoWeixin":null,"id":"175b1de7a965409b906aa549cfa9d833","dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null},"group":{"groupId":null,"groupName":null,"groupRemark":null,"userNumber":null,"checked":null,"groupDept":null,"dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}},"userInfo":{"userInfoId":null,"userName":null,"userInfoUserId":null,"sex":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoStatus":null,"userInfoQq":null,"userInfoWeixin":null},"moduleId":null,"roleId":null,"deptName":null,"deptlist":null,"rolelist":null,"modulelist":null,"operationlist":null,"grouplist":null,"rmolist":null}}],"status":null,"createName":null,"updateName":null,"c_user":"17c4520f6cfd1ab53d8745e84681eb49","c_dt":"2018-03-22 13:59:05","u_user":"","u_dt":"","sampleNo":"S001","auditStatus":"1","authUser":"17c4520f6cfd1ab53d8745e84681eb49","authTime":"2018-03-22 13:59:05"}
     */

    private String purl;
    private boolean res;
    private String code;
    private String message;
    private BringBean bring;

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BringBean getBring() {
        return bring;
    }

    public void setBring(BringBean bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 8b94df0a96df4572a1cc206d7d9a8ca5
         * batchNum : P20180322003
         * batchNo : null
         * fuelModel : 2
         * fuelModelName : 0号柴油
         * nationalStandard : 4
         * standardName : 国五
         * fuelDensity : 0.85
         * supplyId : 84c3b6d7443d4eb69c5ea0f53847a7fb
         * supplyName :
         * supplyName1 : 山东中石化公司
         * supplyTel :
         * fileName : null
         * remark :
         * fileList : [{"id":"175b1de7a965409b906aa549cfa9d833","fileName":"20180322135905432.pdf","fileOldname":"20170822-407（调和封罐） 普通柴油质量分析报告.pdf","fileUploaddate":"2018-03-22 13:59:05","fileType":".pdf","fileUrl":"20180322135905432.pdf","fileStatus":null,"fileRemark":"225233.00","addTime":null,"addUser":"superadmin","editTime":null,"editUser":null,"status":null,"fileSize":null,"user":{"userId":null,"userCode":null,"password":null,"deptId":null,"cdt":null,"cuser":null,"uuser":null,"udt":null,"status":null,"checked":null,"userName":null,"userInfoEmail":null,"userInfoMobile":null,"userInfoQq":null,"userInfoWeixin":null,"id":"175b1de7a965409b906aa549cfa9d833","dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null},"group":{"groupId":null,"groupName":null,"groupRemark":null,"userNumber":null,"checked":null,"groupDept":null,"dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}},"userInfo":{"userInfoId":null,"userName":null,"userInfoUserId":null,"sex":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoStatus":null,"userInfoQq":null,"userInfoWeixin":null},"moduleId":null,"roleId":null,"deptName":null,"deptlist":null,"rolelist":null,"modulelist":null,"operationlist":null,"grouplist":null,"rmolist":null}}]
         * status : null
         * createName : null
         * updateName : null
         * c_user : 17c4520f6cfd1ab53d8745e84681eb49
         * c_dt : 2018-03-22 13:59:05
         * u_user :
         * u_dt :
         * sampleNo : S001
         * auditStatus : 1
         * authUser : 17c4520f6cfd1ab53d8745e84681eb49
         * authTime : 2018-03-22 13:59:05
         */

        private String id;
        private String batchNum;
        private String batchNo;
        private String fuelModel;
        private String fuelModelName;
        private String nationalStandard;
        private String standardName;
        private String fuelDensity;
        private String supplyId;
        private String supplyName;
        private String supplyName1;
        private String supplyTel;
        private String fileName;
        private String remark;
        private String status;
        private String createName;
        private String updateName;
        private String c_user;
        private String c_dt;
        private String u_user;
        private String u_dt;
        private String sampleNo;
        private String auditStatus;
        private String authUser;
        private String authTime;
        private List<FileListBean> fileList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(String batchNum) {
            this.batchNum = batchNum;
        }

        public String getBatchNo() {
            return batchNo;
        }

        public void setBatchNo(String batchNo) {
            this.batchNo = batchNo;
        }

        public String getFuelModel() {
            return fuelModel;
        }

        public void setFuelModel(String fuelModel) {
            this.fuelModel = fuelModel;
        }

        public String getFuelModelName() {
            return fuelModelName;
        }

        public void setFuelModelName(String fuelModelName) {
            this.fuelModelName = fuelModelName;
        }

        public String getNationalStandard() {
            return nationalStandard;
        }

        public void setNationalStandard(String nationalStandard) {
            this.nationalStandard = nationalStandard;
        }

        public String getStandardName() {
            return standardName;
        }

        public void setStandardName(String standardName) {
            this.standardName = standardName;
        }

        public String getFuelDensity() {
            return fuelDensity;
        }

        public void setFuelDensity(String fuelDensity) {
            this.fuelDensity = fuelDensity;
        }

        public String getSupplyId() {
            return supplyId;
        }

        public void setSupplyId(String supplyId) {
            this.supplyId = supplyId;
        }

        public String getSupplyName() {
            return supplyName;
        }

        public void setSupplyName(String supplyName) {
            this.supplyName = supplyName;
        }

        public String getSupplyName1() {
            return supplyName1;
        }

        public void setSupplyName1(String supplyName1) {
            this.supplyName1 = supplyName1;
        }

        public String getSupplyTel() {
            return supplyTel;
        }

        public void setSupplyTel(String supplyTel) {
            this.supplyTel = supplyTel;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getUpdateName() {
            return updateName;
        }

        public void setUpdateName(String updateName) {
            this.updateName = updateName;
        }

        public String getC_user() {
            return c_user;
        }

        public void setC_user(String c_user) {
            this.c_user = c_user;
        }

        public String getC_dt() {
            return c_dt;
        }

        public void setC_dt(String c_dt) {
            this.c_dt = c_dt;
        }

        public String getU_user() {
            return u_user;
        }

        public void setU_user(String u_user) {
            this.u_user = u_user;
        }

        public String getU_dt() {
            return u_dt;
        }

        public void setU_dt(String u_dt) {
            this.u_dt = u_dt;
        }

        public String getSampleNo() {
            return sampleNo;
        }

        public void setSampleNo(String sampleNo) {
            this.sampleNo = sampleNo;
        }

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getAuthUser() {
            return authUser;
        }

        public void setAuthUser(String authUser) {
            this.authUser = authUser;
        }

        public String getAuthTime() {
            return authTime;
        }

        public void setAuthTime(String authTime) {
            this.authTime = authTime;
        }

        public List<FileListBean> getFileList() {
            return fileList;
        }

        public void setFileList(List<FileListBean> fileList) {
            this.fileList = fileList;
        }

        public static class FileListBean {
            /**
             * id : 175b1de7a965409b906aa549cfa9d833
             * fileName : 20180322135905432.pdf
             * fileOldname : 20170822-407（调和封罐） 普通柴油质量分析报告.pdf
             * fileUploaddate : 2018-03-22 13:59:05
             * fileType : .pdf
             * fileUrl : 20180322135905432.pdf
             * fileStatus : null
             * fileRemark : 225233.00
             * addTime : null
             * addUser : superadmin
             * editTime : null
             * editUser : null
             * status : null
             * fileSize : null
             * user : {"userId":null,"userCode":null,"password":null,"deptId":null,"cdt":null,"cuser":null,"uuser":null,"udt":null,"status":null,"checked":null,"userName":null,"userInfoEmail":null,"userInfoMobile":null,"userInfoQq":null,"userInfoWeixin":null,"id":"175b1de7a965409b906aa549cfa9d833","dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null},"group":{"groupId":null,"groupName":null,"groupRemark":null,"userNumber":null,"checked":null,"groupDept":null,"dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}},"userInfo":{"userInfoId":null,"userName":null,"userInfoUserId":null,"sex":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoStatus":null,"userInfoQq":null,"userInfoWeixin":null},"moduleId":null,"roleId":null,"deptName":null,"deptlist":null,"rolelist":null,"modulelist":null,"operationlist":null,"grouplist":null,"rmolist":null}
             */

            private String id;
            private String fileName;
            private String fileOldname;
            private String fileUploaddate;
            private String fileType;
            private String fileUrl;
            private String fileStatus;
            private String fileRemark;
            private String addTime;
            private String addUser;
            private String editTime;
            private String editUser;
            private String status;
            private String fileSize;
            private UserBean user;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getFileOldname() {
                return fileOldname;
            }

            public void setFileOldname(String fileOldname) {
                this.fileOldname = fileOldname;
            }

            public String getFileUploaddate() {
                return fileUploaddate;
            }

            public void setFileUploaddate(String fileUploaddate) {
                this.fileUploaddate = fileUploaddate;
            }

            public String getFileType() {
                return fileType;
            }

            public void setFileType(String fileType) {
                this.fileType = fileType;
            }

            public String getFileUrl() {
                return fileUrl;
            }

            public void setFileUrl(String fileUrl) {
                this.fileUrl = fileUrl;
            }

            public String getFileStatus() {
                return fileStatus;
            }

            public void setFileStatus(String fileStatus) {
                this.fileStatus = fileStatus;
            }

            public String getFileRemark() {
                return fileRemark;
            }

            public void setFileRemark(String fileRemark) {
                this.fileRemark = fileRemark;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getFileSize() {
                return fileSize;
            }

            public void setFileSize(String fileSize) {
                this.fileSize = fileSize;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * userId : null
                 * userCode : null
                 * password : null
                 * deptId : null
                 * cdt : null
                 * cuser : null
                 * uuser : null
                 * udt : null
                 * status : null
                 * checked : null
                 * userName : null
                 * userInfoEmail : null
                 * userInfoMobile : null
                 * userInfoQq : null
                 * userInfoWeixin : null
                 * id : 175b1de7a965409b906aa549cfa9d833
                 * dept : {"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}
                 * group : {"groupId":null,"groupName":null,"groupRemark":null,"userNumber":null,"checked":null,"groupDept":null,"dept":{"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}}
                 * userInfo : {"userInfoId":null,"userName":null,"userInfoUserId":null,"sex":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoStatus":null,"userInfoQq":null,"userInfoWeixin":null}
                 * moduleId : null
                 * roleId : null
                 * deptName : null
                 * deptlist : null
                 * rolelist : null
                 * modulelist : null
                 * operationlist : null
                 * grouplist : null
                 * rmolist : null
                 */

                private String userId;
                private String userCode;
                private String password;
                private String deptId;
                private String cdt;
                private String cuser;
                private String uuser;
                private String udt;
                private String status;
                private String checked;
                private String userName;
                private String userInfoEmail;
                private String userInfoMobile;
                private String userInfoQq;
                private String userInfoWeixin;
                private String id;
                private DeptBean dept;
                private GroupBean group;
                private UserInfoBean userInfo;
                private String moduleId;
                private String roleId;
                private String deptName;
                private String deptlist;
                private String rolelist;
                private String modulelist;
                private String operationlist;
                private String grouplist;
                private String rmolist;

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public String getUserCode() {
                    return userCode;
                }

                public void setUserCode(String userCode) {
                    this.userCode = userCode;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getDeptId() {
                    return deptId;
                }

                public void setDeptId(String deptId) {
                    this.deptId = deptId;
                }

                public String getCdt() {
                    return cdt;
                }

                public void setCdt(String cdt) {
                    this.cdt = cdt;
                }

                public String getCuser() {
                    return cuser;
                }

                public void setCuser(String cuser) {
                    this.cuser = cuser;
                }

                public String getUuser() {
                    return uuser;
                }

                public void setUuser(String uuser) {
                    this.uuser = uuser;
                }

                public String getUdt() {
                    return udt;
                }

                public void setUdt(String udt) {
                    this.udt = udt;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getChecked() {
                    return checked;
                }

                public void setChecked(String checked) {
                    this.checked = checked;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getUserInfoEmail() {
                    return userInfoEmail;
                }

                public void setUserInfoEmail(String userInfoEmail) {
                    this.userInfoEmail = userInfoEmail;
                }

                public String getUserInfoMobile() {
                    return userInfoMobile;
                }

                public void setUserInfoMobile(String userInfoMobile) {
                    this.userInfoMobile = userInfoMobile;
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

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public DeptBean getDept() {
                    return dept;
                }

                public void setDept(DeptBean dept) {
                    this.dept = dept;
                }

                public GroupBean getGroup() {
                    return group;
                }

                public void setGroup(GroupBean group) {
                    this.group = group;
                }

                public UserInfoBean getUserInfo() {
                    return userInfo;
                }

                public void setUserInfo(UserInfoBean userInfo) {
                    this.userInfo = userInfo;
                }

                public String getModuleId() {
                    return moduleId;
                }

                public void setModuleId(String moduleId) {
                    this.moduleId = moduleId;
                }

                public String getRoleId() {
                    return roleId;
                }

                public void setRoleId(String roleId) {
                    this.roleId = roleId;
                }

                public String getDeptName() {
                    return deptName;
                }

                public void setDeptName(String deptName) {
                    this.deptName = deptName;
                }

                public String getDeptlist() {
                    return deptlist;
                }

                public void setDeptlist(String deptlist) {
                    this.deptlist = deptlist;
                }

                public String getRolelist() {
                    return rolelist;
                }

                public void setRolelist(String rolelist) {
                    this.rolelist = rolelist;
                }

                public String getModulelist() {
                    return modulelist;
                }

                public void setModulelist(String modulelist) {
                    this.modulelist = modulelist;
                }

                public String getOperationlist() {
                    return operationlist;
                }

                public void setOperationlist(String operationlist) {
                    this.operationlist = operationlist;
                }

                public String getGrouplist() {
                    return grouplist;
                }

                public void setGrouplist(String grouplist) {
                    this.grouplist = grouplist;
                }

                public String getRmolist() {
                    return rmolist;
                }

                public void setRmolist(String rmolist) {
                    this.rmolist = rmolist;
                }

                public static class DeptBean {
                    /**
                     * deptId : null
                     * id : 175b1de7a965409b906aa549cfa9d833
                     * name : null
                     * deptName : null
                     * deptParentId : null
                     * parentName : null
                     * deptRemark : null
                     * status : null
                     * checked : null
                     * userNumber : null
                     * deptAddress : null
                     * deptType : null
                     * deptDistrict : null
                     * deptIdentify : null
                     * items : null
                     * treeId : null
                     * pid : null
                     */

                    private String deptId;
                    private String id;
                    private String name;
                    private String deptName;
                    private String deptParentId;
                    private String parentName;
                    private String deptRemark;
                    private String status;
                    private String checked;
                    private String userNumber;
                    private String deptAddress;
                    private String deptType;
                    private String deptDistrict;
                    private String deptIdentify;
                    private String items;
                    private String treeId;
                    private String pid;

                    public String getDeptId() {
                        return deptId;
                    }

                    public void setDeptId(String deptId) {
                        this.deptId = deptId;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getDeptName() {
                        return deptName;
                    }

                    public void setDeptName(String deptName) {
                        this.deptName = deptName;
                    }

                    public String getDeptParentId() {
                        return deptParentId;
                    }

                    public void setDeptParentId(String deptParentId) {
                        this.deptParentId = deptParentId;
                    }

                    public String getParentName() {
                        return parentName;
                    }

                    public void setParentName(String parentName) {
                        this.parentName = parentName;
                    }

                    public String getDeptRemark() {
                        return deptRemark;
                    }

                    public void setDeptRemark(String deptRemark) {
                        this.deptRemark = deptRemark;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getChecked() {
                        return checked;
                    }

                    public void setChecked(String checked) {
                        this.checked = checked;
                    }

                    public String getUserNumber() {
                        return userNumber;
                    }

                    public void setUserNumber(String userNumber) {
                        this.userNumber = userNumber;
                    }

                    public String getDeptAddress() {
                        return deptAddress;
                    }

                    public void setDeptAddress(String deptAddress) {
                        this.deptAddress = deptAddress;
                    }

                    public String getDeptType() {
                        return deptType;
                    }

                    public void setDeptType(String deptType) {
                        this.deptType = deptType;
                    }

                    public String getDeptDistrict() {
                        return deptDistrict;
                    }

                    public void setDeptDistrict(String deptDistrict) {
                        this.deptDistrict = deptDistrict;
                    }

                    public String getDeptIdentify() {
                        return deptIdentify;
                    }

                    public void setDeptIdentify(String deptIdentify) {
                        this.deptIdentify = deptIdentify;
                    }

                    public String getItems() {
                        return items;
                    }

                    public void setItems(String items) {
                        this.items = items;
                    }

                    public String getTreeId() {
                        return treeId;
                    }

                    public void setTreeId(String treeId) {
                        this.treeId = treeId;
                    }

                    public String getPid() {
                        return pid;
                    }

                    public void setPid(String pid) {
                        this.pid = pid;
                    }
                }

                public static class GroupBean {
                    /**
                     * groupId : null
                     * groupName : null
                     * groupRemark : null
                     * userNumber : null
                     * checked : null
                     * groupDept : null
                     * dept : {"deptId":null,"id":"175b1de7a965409b906aa549cfa9d833","name":null,"deptName":null,"deptParentId":null,"parentName":null,"deptRemark":null,"status":null,"checked":null,"userNumber":null,"deptAddress":null,"deptType":null,"deptDistrict":null,"deptIdentify":null,"items":null,"treeId":null,"pid":null}
                     */

                    private String groupId;
                    private String groupName;
                    private String groupRemark;
                    private String userNumber;
                    private String checked;
                    private String groupDept;
                    private DeptBeanX dept;

                    public String getGroupId() {
                        return groupId;
                    }

                    public void setGroupId(String groupId) {
                        this.groupId = groupId;
                    }

                    public String getGroupName() {
                        return groupName;
                    }

                    public void setGroupName(String groupName) {
                        this.groupName = groupName;
                    }

                    public String getGroupRemark() {
                        return groupRemark;
                    }

                    public void setGroupRemark(String groupRemark) {
                        this.groupRemark = groupRemark;
                    }

                    public String getUserNumber() {
                        return userNumber;
                    }

                    public void setUserNumber(String userNumber) {
                        this.userNumber = userNumber;
                    }

                    public String getChecked() {
                        return checked;
                    }

                    public void setChecked(String checked) {
                        this.checked = checked;
                    }

                    public String getGroupDept() {
                        return groupDept;
                    }

                    public void setGroupDept(String groupDept) {
                        this.groupDept = groupDept;
                    }

                    public DeptBeanX getDept() {
                        return dept;
                    }

                    public void setDept(DeptBeanX dept) {
                        this.dept = dept;
                    }

                    public static class DeptBeanX {
                        /**
                         * deptId : null
                         * id : 175b1de7a965409b906aa549cfa9d833
                         * name : null
                         * deptName : null
                         * deptParentId : null
                         * parentName : null
                         * deptRemark : null
                         * status : null
                         * checked : null
                         * userNumber : null
                         * deptAddress : null
                         * deptType : null
                         * deptDistrict : null
                         * deptIdentify : null
                         * items : null
                         * treeId : null
                         * pid : null
                         */

                        private String deptId;
                        private String id;
                        private String name;
                        private String deptName;
                        private String deptParentId;
                        private String parentName;
                        private String deptRemark;
                        private String status;
                        private String checked;
                        private String userNumber;
                        private String deptAddress;
                        private String deptType;
                        private String deptDistrict;
                        private String deptIdentify;
                        private String items;
                        private String treeId;
                        private String pid;

                        public String getDeptId() {
                            return deptId;
                        }

                        public void setDeptId(String deptId) {
                            this.deptId = deptId;
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getDeptName() {
                            return deptName;
                        }

                        public void setDeptName(String deptName) {
                            this.deptName = deptName;
                        }

                        public String getDeptParentId() {
                            return deptParentId;
                        }

                        public void setDeptParentId(String deptParentId) {
                            this.deptParentId = deptParentId;
                        }

                        public String getParentName() {
                            return parentName;
                        }

                        public void setParentName(String parentName) {
                            this.parentName = parentName;
                        }

                        public String getDeptRemark() {
                            return deptRemark;
                        }

                        public void setDeptRemark(String deptRemark) {
                            this.deptRemark = deptRemark;
                        }

                        public String getStatus() {
                            return status;
                        }

                        public void setStatus(String status) {
                            this.status = status;
                        }

                        public String getChecked() {
                            return checked;
                        }

                        public void setChecked(String checked) {
                            this.checked = checked;
                        }

                        public String getUserNumber() {
                            return userNumber;
                        }

                        public void setUserNumber(String userNumber) {
                            this.userNumber = userNumber;
                        }

                        public String getDeptAddress() {
                            return deptAddress;
                        }

                        public void setDeptAddress(String deptAddress) {
                            this.deptAddress = deptAddress;
                        }

                        public String getDeptType() {
                            return deptType;
                        }

                        public void setDeptType(String deptType) {
                            this.deptType = deptType;
                        }

                        public String getDeptDistrict() {
                            return deptDistrict;
                        }

                        public void setDeptDistrict(String deptDistrict) {
                            this.deptDistrict = deptDistrict;
                        }

                        public String getDeptIdentify() {
                            return deptIdentify;
                        }

                        public void setDeptIdentify(String deptIdentify) {
                            this.deptIdentify = deptIdentify;
                        }

                        public String getItems() {
                            return items;
                        }

                        public void setItems(String items) {
                            this.items = items;
                        }

                        public String getTreeId() {
                            return treeId;
                        }

                        public void setTreeId(String treeId) {
                            this.treeId = treeId;
                        }

                        public String getPid() {
                            return pid;
                        }

                        public void setPid(String pid) {
                            this.pid = pid;
                        }
                    }
                }

                public static class UserInfoBean {
                    /**
                     * userInfoId : null
                     * userName : null
                     * userInfoUserId : null
                     * sex : null
                     * userInfoEmail : null
                     * userInfoAddress : null
                     * userInfoMobile : null
                     * userInfoPost : null
                     * userInfoStatus : null
                     * userInfoQq : null
                     * userInfoWeixin : null
                     */

                    private String userInfoId;
                    private String userName;
                    private String userInfoUserId;
                    private String sex;
                    private String userInfoEmail;
                    private String userInfoAddress;
                    private String userInfoMobile;
                    private String userInfoPost;
                    private String userInfoStatus;
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

                    public String getUserInfoAddress() {
                        return userInfoAddress;
                    }

                    public void setUserInfoAddress(String userInfoAddress) {
                        this.userInfoAddress = userInfoAddress;
                    }

                    public String getUserInfoMobile() {
                        return userInfoMobile;
                    }

                    public void setUserInfoMobile(String userInfoMobile) {
                        this.userInfoMobile = userInfoMobile;
                    }

                    public String getUserInfoPost() {
                        return userInfoPost;
                    }

                    public void setUserInfoPost(String userInfoPost) {
                        this.userInfoPost = userInfoPost;
                    }

                    public String getUserInfoStatus() {
                        return userInfoStatus;
                    }

                    public void setUserInfoStatus(String userInfoStatus) {
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
        }
    }


//
//    /**
//     * code : message.common.0001
//     * message : 新建成功
//     * bring : {"batchStatus":"0","status":null,"buyer":"2222","fuelDone":"24","supplyName":"供油商2","updateTime":"2017-09-06 09:16:26","buyTime":"2017-09-06","updateName":null,"fuelModel":"1","fileName":null,"buyerTel":"212","fuelCode":"3333","id":"8be8230cc9d244dabc52a1f7d481c112","supplyId":"5d1b05cc4fad4413a4d3d707849aeaab","createId":null,"fuelTotal":"100","batchNum":"BATCH000001","updateId":null,"payStatus":"1","fuelModelName":"5号柴油","fileList":[{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"fileName":"20170906091519591.txt","fileSize":null,"user":{"cdt":null,"cuser":null,"deptlist":null,"udt":null,"status":null,"userInfoQq":null,"modulelist":null,"grouplist":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null},"operationlist":null,"deptId":null,"userInfo":{"userInfoUserId":null,"userName":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoQq":null,"userInfoStatus":null,"userInfoWeixin":null,"sex":null,"userInfoId":null},"userInfoWeixin":null,"userInfoEmail":null,"group":{"checked":null,"userNumber":null,"groupRemark":null,"groupName":null,"groupDept":null,"groupId":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}},"roleId":null,"rolelist":null,"id":"5d5fe1e1802a4354a2bad375d8f6df8f","userInfoMobile":null,"userCode":null,"deptName":null,"checked":null,"rmolist":null,"userName":null,"password":null,"moduleId":null,"uuser":null,"userId":null},"addUser":"superadmin","editUser":null,"fileRemark":"15408.00","addTime":null,"fileUploaddate":"2017-09-06 09:15:19","fileType":".txt","fileUrl":"20170906091519591.txt","fileOldname":"20170902135608.txt","fileStatus":null,"editTime":null}],"createTime":"2017-09-06 09:15:19","price":"223","remark":"222","createName":null,"fuelPosition":"3333"}
//     * res : true
//     * purl : properties/code.properties
//     */
//
//    private String code;
//    private String message;
//    private BringBean bring;
//    private boolean res;
//    private String purl;
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public BringBean getBring() {
//        return bring;
//    }
//
//    public void setBring(BringBean bring) {
//        this.bring = bring;
//    }
//
//    public boolean isRes() {
//        return res;
//    }
//
//    public void setRes(boolean res) {
//        this.res = res;
//    }
//
//    public String getPurl() {
//        return purl;
//    }
//
//    public void setPurl(String purl) {
//        this.purl = purl;
//    }
//
//    public static class BringBean {
//        /**
//         * batchStatus : 0
//         * status : null
//         * buyer : 2222
//         * fuelDone : 24
//         * supplyName : 供油商2
//         * updateTime : 2017-09-06 09:16:26
//         * buyTime : 2017-09-06
//         * updateName : null
//         * fuelModel : 1
//         * fileName : null
//         * buyerTel : 212
//         * fuelCode : 3333
//         * id : 8be8230cc9d244dabc52a1f7d481c112
//         * supplyId : 5d1b05cc4fad4413a4d3d707849aeaab
//         * createId : null
//         * fuelTotal : 100
//         * batchNum : BATCH000001
//         * updateId : null
//         * payStatus : 1
//         * fuelModelName : 5号柴油
//         * fileList : [{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"fileName":"20170906091519591.txt","fileSize":null,"user":{"cdt":null,"cuser":null,"deptlist":null,"udt":null,"status":null,"userInfoQq":null,"modulelist":null,"grouplist":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null},"operationlist":null,"deptId":null,"userInfo":{"userInfoUserId":null,"userName":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoQq":null,"userInfoStatus":null,"userInfoWeixin":null,"sex":null,"userInfoId":null},"userInfoWeixin":null,"userInfoEmail":null,"group":{"checked":null,"userNumber":null,"groupRemark":null,"groupName":null,"groupDept":null,"groupId":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}},"roleId":null,"rolelist":null,"id":"5d5fe1e1802a4354a2bad375d8f6df8f","userInfoMobile":null,"userCode":null,"deptName":null,"checked":null,"rmolist":null,"userName":null,"password":null,"moduleId":null,"uuser":null,"userId":null},"addUser":"superadmin","editUser":null,"fileRemark":"15408.00","addTime":null,"fileUploaddate":"2017-09-06 09:15:19","fileType":".txt","fileUrl":"20170906091519591.txt","fileOldname":"20170902135608.txt","fileStatus":null,"editTime":null}]
//         * createTime : 2017-09-06 09:15:19
//         * price : 223
//         * remark : 222
//         * createName : null
//         * fuelPosition : 3333
//         */
//
//        private String batchStatus;
//        private String status;
//        private String buyer;
//        private String fuelDone;
//        private String supplyName;
//        private String updateTime;
//        private String buyTime;
//        private String updateName;
//        private String fuelModel;
//        private String fileName;
//        private String buyerTel;
//        private String fuelCode;
//        private String id;
//        private String supplyId;
//        private String createId;
//        private String fuelTotal;
//        private String batchNum;
//        private String updateId;
//        private String payStatus;
//        private String fuelModelName;
//        private String createTime;
//        private String price;
//        private String remark;
//        private String createName;
//        private String fuelPosition;
//        private List<FileListBean> fileList;
//        private String standardName;
//        private String supplyTel;
//        private String fuelDensity;
//
//        public String getFuelDensity() {
//            return fuelDensity;
//        }
//
//        public void setFuelDensity(String fuelDensity) {
//            this.fuelDensity = fuelDensity;
//        }
//
//        public String getSupplyTel() {
//            return supplyTel;
//        }
//
//        public void setSupplyTel(String supplyTel) {
//            this.supplyTel = supplyTel;
//        }
//
//        public String getStandardName() {
//            return standardName;
//        }
//
//        public void setStandardName(String standardName) {
//            this.standardName = standardName;
//        }
//
//        public String getBatchStatus() {
//            return batchStatus;
//        }
//
//        public void setBatchStatus(String batchStatus) {
//            this.batchStatus = batchStatus;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public String getBuyer() {
//            return buyer;
//        }
//
//        public void setBuyer(String buyer) {
//            this.buyer = buyer;
//        }
//
//        public String getFuelDone() {
//            return fuelDone;
//        }
//
//        public void setFuelDone(String fuelDone) {
//            this.fuelDone = fuelDone;
//        }
//
//        public String getSupplyName() {
//            return supplyName;
//        }
//
//        public void setSupplyName(String supplyName) {
//            this.supplyName = supplyName;
//        }
//
//        public String getUpdateTime() {
//            return updateTime;
//        }
//
//        public void setUpdateTime(String updateTime) {
//            this.updateTime = updateTime;
//        }
//
//        public String getBuyTime() {
//            return buyTime;
//        }
//
//        public void setBuyTime(String buyTime) {
//            this.buyTime = buyTime;
//        }
//
//        public String getUpdateName() {
//            return updateName;
//        }
//
//        public void setUpdateName(String updateName) {
//            this.updateName = updateName;
//        }
//
//        public String getFuelModel() {
//            return fuelModel;
//        }
//
//        public void setFuelModel(String fuelModel) {
//            this.fuelModel = fuelModel;
//        }
//
//        public String getFileName() {
//            return fileName;
//        }
//
//        public void setFileName(String fileName) {
//            this.fileName = fileName;
//        }
//
//        public String getBuyerTel() {
//            return buyerTel;
//        }
//
//        public void setBuyerTel(String buyerTel) {
//            this.buyerTel = buyerTel;
//        }
//
//        public String getFuelCode() {
//            return fuelCode;
//        }
//
//        public void setFuelCode(String fuelCode) {
//            this.fuelCode = fuelCode;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getSupplyId() {
//            return supplyId;
//        }
//
//        public void setSupplyId(String supplyId) {
//            this.supplyId = supplyId;
//        }
//
//        public String getCreateId() {
//            return createId;
//        }
//
//        public void setCreateId(String createId) {
//            this.createId = createId;
//        }
//
//        public String getFuelTotal() {
//            return fuelTotal;
//        }
//
//        public void setFuelTotal(String fuelTotal) {
//            this.fuelTotal = fuelTotal;
//        }
//
//        public String getBatchNum() {
//            return batchNum;
//        }
//
//        public void setBatchNum(String batchNum) {
//            this.batchNum = batchNum;
//        }
//
//        public String getUpdateId() {
//            return updateId;
//        }
//
//        public void setUpdateId(String updateId) {
//            this.updateId = updateId;
//        }
//
//        public String getPayStatus() {
//            return payStatus;
//        }
//
//        public void setPayStatus(String payStatus) {
//            this.payStatus = payStatus;
//        }
//
//        public String getFuelModelName() {
//            return fuelModelName;
//        }
//
//        public void setFuelModelName(String fuelModelName) {
//            this.fuelModelName = fuelModelName;
//        }
//
//        public String getCreateTime() {
//            return createTime;
//        }
//
//        public void setCreateTime(String createTime) {
//            this.createTime = createTime;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
//        }
//
//        public String getRemark() {
//            return remark;
//        }
//
//        public void setRemark(String remark) {
//            this.remark = remark;
//        }
//
//        public String getCreateName() {
//            return createName;
//        }
//
//        public void setCreateName(String createName) {
//            this.createName = createName;
//        }
//
//        public String getFuelPosition() {
//            return fuelPosition;
//        }
//
//        public void setFuelPosition(String fuelPosition) {
//            this.fuelPosition = fuelPosition;
//        }
//
//        public List<FileListBean> getFileList() {
//            return fileList;
//        }
//
//        public void setFileList(List<FileListBean> fileList) {
//            this.fileList = fileList;
//        }
//
//        public static class FileListBean {
//            /**
//             * id : 5d5fe1e1802a4354a2bad375d8f6df8f
//             * status : null
//             * fileName : 20170906091519591.txt
//             * fileSize : null
//             * user : {"cdt":null,"cuser":null,"deptlist":null,"udt":null,"status":null,"userInfoQq":null,"modulelist":null,"grouplist":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null},"operationlist":null,"deptId":null,"userInfo":{"userInfoUserId":null,"userName":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoQq":null,"userInfoStatus":null,"userInfoWeixin":null,"sex":null,"userInfoId":null},"userInfoWeixin":null,"userInfoEmail":null,"group":{"checked":null,"userNumber":null,"groupRemark":null,"groupName":null,"groupDept":null,"groupId":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}},"roleId":null,"rolelist":null,"id":"5d5fe1e1802a4354a2bad375d8f6df8f","userInfoMobile":null,"userCode":null,"deptName":null,"checked":null,"rmolist":null,"userName":null,"password":null,"moduleId":null,"uuser":null,"userId":null}
//             * addUser : superadmin
//             * editUser : null
//             * fileRemark : 15408.00
//             * addTime : null
//             * fileUploaddate : 2017-09-06 09:15:19
//             * fileType : .txt
//             * fileUrl : 20170906091519591.txt
//             * fileOldname : 20170902135608.txt
//             * fileStatus : null
//             * editTime : null
//             */
//
//            private String id;
//            private String status;
//            private String fileName;
//            private String fileSize;
//            private UserBean user;
//            private String addUser;
//            private String editUser;
//            private String fileRemark;
//            private String addTime;
//            private String fileUploaddate;
//            private String fileType;
//            private String fileUrl;
//            private String fileOldname;
//            private String fileStatus;
//            private String editTime;
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
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
//            public String getFileName() {
//                return fileName;
//            }
//
//            public void setFileName(String fileName) {
//                this.fileName = fileName;
//            }
//
//            public String getFileSize() {
//                return fileSize;
//            }
//
//            public void setFileSize(String fileSize) {
//                this.fileSize = fileSize;
//            }
//
//            public UserBean getUser() {
//                return user;
//            }
//
//            public void setUser(UserBean user) {
//                this.user = user;
//            }
//
//            public String getAddUser() {
//                return addUser;
//            }
//
//            public void setAddUser(String addUser) {
//                this.addUser = addUser;
//            }
//
//            public String getEditUser() {
//                return editUser;
//            }
//
//            public void setEditUser(String editUser) {
//                this.editUser = editUser;
//            }
//
//            public String getFileRemark() {
//                return fileRemark;
//            }
//
//            public void setFileRemark(String fileRemark) {
//                this.fileRemark = fileRemark;
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
//            public String getFileUploaddate() {
//                return fileUploaddate;
//            }
//
//            public void setFileUploaddate(String fileUploaddate) {
//                this.fileUploaddate = fileUploaddate;
//            }
//
//            public String getFileType() {
//                return fileType;
//            }
//
//            public void setFileType(String fileType) {
//                this.fileType = fileType;
//            }
//
//            public String getFileUrl() {
//                return fileUrl;
//            }
//
//            public void setFileUrl(String fileUrl) {
//                this.fileUrl = fileUrl;
//            }
//
//            public String getFileOldname() {
//                return fileOldname;
//            }
//
//            public void setFileOldname(String fileOldname) {
//                this.fileOldname = fileOldname;
//            }
//
//            public String getFileStatus() {
//                return fileStatus;
//            }
//
//            public void setFileStatus(String fileStatus) {
//                this.fileStatus = fileStatus;
//            }
//
//            public String getEditTime() {
//                return editTime;
//            }
//
//            public void setEditTime(String editTime) {
//                this.editTime = editTime;
//            }
//
//            public static class UserBean {
//                /**
//                 * cdt : null
//                 * cuser : null
//                 * deptlist : null
//                 * udt : null
//                 * status : null
//                 * userInfoQq : null
//                 * modulelist : null
//                 * grouplist : null
//                 * dept : {"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}
//                 * operationlist : null
//                 * deptId : null
//                 * userInfo : {"userInfoUserId":null,"userName":null,"userInfoEmail":null,"userInfoAddress":null,"userInfoMobile":null,"userInfoPost":null,"userInfoQq":null,"userInfoStatus":null,"userInfoWeixin":null,"sex":null,"userInfoId":null}
//                 * userInfoWeixin : null
//                 * userInfoEmail : null
//                 * group : {"checked":null,"userNumber":null,"groupRemark":null,"groupName":null,"groupDept":null,"groupId":null,"dept":{"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}}
//                 * roleId : null
//                 * rolelist : null
//                 * id : 5d5fe1e1802a4354a2bad375d8f6df8f
//                 * userInfoMobile : null
//                 * userCode : null
//                 * deptName : null
//                 * checked : null
//                 * rmolist : null
//                 * userName : null
//                 * password : null
//                 * moduleId : null
//                 * uuser : null
//                 * userId : null
//                 */
//
//                private String cdt;
//                private String cuser;
//                private String deptlist;
//                private String udt;
//                private String status;
//                private String userInfoQq;
//                private String modulelist;
//                private String grouplist;
//                private DeptBean dept;
//                private String operationlist;
//                private String deptId;
//                private UserInfoBean userInfo;
//                private String userInfoWeixin;
//                private String userInfoEmail;
//                private GroupBean group;
//                private String roleId;
//                private String rolelist;
//                private String id;
//                private String userInfoMobile;
//                private String userCode;
//                private String deptName;
//                private String checked;
//                private String rmolist;
//                private String userName;
//                private String password;
//                private String moduleId;
//                private String uuser;
//                private String userId;
//
//                public String getCdt() {
//                    return cdt;
//                }
//
//                public void setCdt(String cdt) {
//                    this.cdt = cdt;
//                }
//
//                public String getCuser() {
//                    return cuser;
//                }
//
//                public void setCuser(String cuser) {
//                    this.cuser = cuser;
//                }
//
//                public String getDeptlist() {
//                    return deptlist;
//                }
//
//                public void setDeptlist(String deptlist) {
//                    this.deptlist = deptlist;
//                }
//
//                public String getUdt() {
//                    return udt;
//                }
//
//                public void setUdt(String udt) {
//                    this.udt = udt;
//                }
//
//                public String getStatus() {
//                    return status;
//                }
//
//                public void setStatus(String status) {
//                    this.status = status;
//                }
//
//                public String getUserInfoQq() {
//                    return userInfoQq;
//                }
//
//                public void setUserInfoQq(String userInfoQq) {
//                    this.userInfoQq = userInfoQq;
//                }
//
//                public String getModulelist() {
//                    return modulelist;
//                }
//
//                public void setModulelist(String modulelist) {
//                    this.modulelist = modulelist;
//                }
//
//                public String getGrouplist() {
//                    return grouplist;
//                }
//
//                public void setGrouplist(String grouplist) {
//                    this.grouplist = grouplist;
//                }
//
//                public DeptBean getDept() {
//                    return dept;
//                }
//
//                public void setDept(DeptBean dept) {
//                    this.dept = dept;
//                }
//
//                public String getOperationlist() {
//                    return operationlist;
//                }
//
//                public void setOperationlist(String operationlist) {
//                    this.operationlist = operationlist;
//                }
//
//                public String getDeptId() {
//                    return deptId;
//                }
//
//                public void setDeptId(String deptId) {
//                    this.deptId = deptId;
//                }
//
//                public UserInfoBean getUserInfo() {
//                    return userInfo;
//                }
//
//                public void setUserInfo(UserInfoBean userInfo) {
//                    this.userInfo = userInfo;
//                }
//
//                public String getUserInfoWeixin() {
//                    return userInfoWeixin;
//                }
//
//                public void setUserInfoWeixin(String userInfoWeixin) {
//                    this.userInfoWeixin = userInfoWeixin;
//                }
//
//                public String getUserInfoEmail() {
//                    return userInfoEmail;
//                }
//
//                public void setUserInfoEmail(String userInfoEmail) {
//                    this.userInfoEmail = userInfoEmail;
//                }
//
//                public GroupBean getGroup() {
//                    return group;
//                }
//
//                public void setGroup(GroupBean group) {
//                    this.group = group;
//                }
//
//                public String getRoleId() {
//                    return roleId;
//                }
//
//                public void setRoleId(String roleId) {
//                    this.roleId = roleId;
//                }
//
//                public String getRolelist() {
//                    return rolelist;
//                }
//
//                public void setRolelist(String rolelist) {
//                    this.rolelist = rolelist;
//                }
//
//                public String getId() {
//                    return id;
//                }
//
//                public void setId(String id) {
//                    this.id = id;
//                }
//
//                public String getUserInfoMobile() {
//                    return userInfoMobile;
//                }
//
//                public void setUserInfoMobile(String userInfoMobile) {
//                    this.userInfoMobile = userInfoMobile;
//                }
//
//                public String getUserCode() {
//                    return userCode;
//                }
//
//                public void setUserCode(String userCode) {
//                    this.userCode = userCode;
//                }
//
//                public String getDeptName() {
//                    return deptName;
//                }
//
//                public void setDeptName(String deptName) {
//                    this.deptName = deptName;
//                }
//
//                public String getChecked() {
//                    return checked;
//                }
//
//                public void setChecked(String checked) {
//                    this.checked = checked;
//                }
//
//                public String getRmolist() {
//                    return rmolist;
//                }
//
//                public void setRmolist(String rmolist) {
//                    this.rmolist = rmolist;
//                }
//
//                public String getUserName() {
//                    return userName;
//                }
//
//                public void setUserName(String userName) {
//                    this.userName = userName;
//                }
//
//                public String getPassword() {
//                    return password;
//                }
//
//                public void setPassword(String password) {
//                    this.password = password;
//                }
//
//                public String getModuleId() {
//                    return moduleId;
//                }
//
//                public void setModuleId(String moduleId) {
//                    this.moduleId = moduleId;
//                }
//
//                public String getUuser() {
//                    return uuser;
//                }
//
//                public void setUuser(String uuser) {
//                    this.uuser = uuser;
//                }
//
//                public String getUserId() {
//                    return userId;
//                }
//
//                public void setUserId(String userId) {
//                    this.userId = userId;
//                }
//
//                public static class DeptBean {
//                    /**
//                     * id : 5d5fe1e1802a4354a2bad375d8f6df8f
//                     * status : null
//                     * deptName : null
//                     * deptParentId : null
//                     * checked : null
//                     * pid : null
//                     * deptDistrict : null
//                     * deptId : null
//                     * treeId : null
//                     * deptAddress : null
//                     * deptRemark : null
//                     * deptType : null
//                     * deptIdentify : null
//                     * items : null
//                     * userNumber : null
//                     * name : null
//                     * parentName : null
//                     */
//
//                    private String id;
//                    private String status;
//                    private String deptName;
//                    private String deptParentId;
//                    private String checked;
//                    private String pid;
//                    private String deptDistrict;
//                    private String deptId;
//                    private String treeId;
//                    private String deptAddress;
//                    private String deptRemark;
//                    private String deptType;
//                    private String deptIdentify;
//                    private String items;
//                    private String userNumber;
//                    private String name;
//                    private String parentName;
//
//                    public String getId() {
//                        return id;
//                    }
//
//                    public void setId(String id) {
//                        this.id = id;
//                    }
//
//                    public String getStatus() {
//                        return status;
//                    }
//
//                    public void setStatus(String status) {
//                        this.status = status;
//                    }
//
//                    public String getDeptName() {
//                        return deptName;
//                    }
//
//                    public void setDeptName(String deptName) {
//                        this.deptName = deptName;
//                    }
//
//                    public String getDeptParentId() {
//                        return deptParentId;
//                    }
//
//                    public void setDeptParentId(String deptParentId) {
//                        this.deptParentId = deptParentId;
//                    }
//
//                    public String getChecked() {
//                        return checked;
//                    }
//
//                    public void setChecked(String checked) {
//                        this.checked = checked;
//                    }
//
//                    public String getPid() {
//                        return pid;
//                    }
//
//                    public void setPid(String pid) {
//                        this.pid = pid;
//                    }
//
//                    public String getDeptDistrict() {
//                        return deptDistrict;
//                    }
//
//                    public void setDeptDistrict(String deptDistrict) {
//                        this.deptDistrict = deptDistrict;
//                    }
//
//                    public String getDeptId() {
//                        return deptId;
//                    }
//
//                    public void setDeptId(String deptId) {
//                        this.deptId = deptId;
//                    }
//
//                    public String getTreeId() {
//                        return treeId;
//                    }
//
//                    public void setTreeId(String treeId) {
//                        this.treeId = treeId;
//                    }
//
//                    public String getDeptAddress() {
//                        return deptAddress;
//                    }
//
//                    public void setDeptAddress(String deptAddress) {
//                        this.deptAddress = deptAddress;
//                    }
//
//                    public String getDeptRemark() {
//                        return deptRemark;
//                    }
//
//                    public void setDeptRemark(String deptRemark) {
//                        this.deptRemark = deptRemark;
//                    }
//
//                    public String getDeptType() {
//                        return deptType;
//                    }
//
//                    public void setDeptType(String deptType) {
//                        this.deptType = deptType;
//                    }
//
//                    public String getDeptIdentify() {
//                        return deptIdentify;
//                    }
//
//                    public void setDeptIdentify(String deptIdentify) {
//                        this.deptIdentify = deptIdentify;
//                    }
//
//                    public String getItems() {
//                        return items;
//                    }
//
//                    public void setItems(String items) {
//                        this.items = items;
//                    }
//
//                    public String getUserNumber() {
//                        return userNumber;
//                    }
//
//                    public void setUserNumber(String userNumber) {
//                        this.userNumber = userNumber;
//                    }
//
//                    public String getName() {
//                        return name;
//                    }
//
//                    public void setName(String name) {
//                        this.name = name;
//                    }
//
//                    public String getParentName() {
//                        return parentName;
//                    }
//
//                    public void setParentName(String parentName) {
//                        this.parentName = parentName;
//                    }
//                }
//
//                public static class UserInfoBean {
//                    /**
//                     * userInfoUserId : null
//                     * userName : null
//                     * userInfoEmail : null
//                     * userInfoAddress : null
//                     * userInfoMobile : null
//                     * userInfoPost : null
//                     * userInfoQq : null
//                     * userInfoStatus : null
//                     * userInfoWeixin : null
//                     * sex : null
//                     * userInfoId : null
//                     */
//
//                    private String userInfoUserId;
//                    private String userName;
//                    private String userInfoEmail;
//                    private String userInfoAddress;
//                    private String userInfoMobile;
//                    private String userInfoPost;
//                    private String userInfoQq;
//                    private String userInfoStatus;
//                    private String userInfoWeixin;
//                    private String sex;
//                    private String userInfoId;
//
//                    public String getUserInfoUserId() {
//                        return userInfoUserId;
//                    }
//
//                    public void setUserInfoUserId(String userInfoUserId) {
//                        this.userInfoUserId = userInfoUserId;
//                    }
//
//                    public String getUserName() {
//                        return userName;
//                    }
//
//                    public void setUserName(String userName) {
//                        this.userName = userName;
//                    }
//
//                    public String getUserInfoEmail() {
//                        return userInfoEmail;
//                    }
//
//                    public void setUserInfoEmail(String userInfoEmail) {
//                        this.userInfoEmail = userInfoEmail;
//                    }
//
//                    public String getUserInfoAddress() {
//                        return userInfoAddress;
//                    }
//
//                    public void setUserInfoAddress(String userInfoAddress) {
//                        this.userInfoAddress = userInfoAddress;
//                    }
//
//                    public String getUserInfoMobile() {
//                        return userInfoMobile;
//                    }
//
//                    public void setUserInfoMobile(String userInfoMobile) {
//                        this.userInfoMobile = userInfoMobile;
//                    }
//
//                    public String getUserInfoPost() {
//                        return userInfoPost;
//                    }
//
//                    public void setUserInfoPost(String userInfoPost) {
//                        this.userInfoPost = userInfoPost;
//                    }
//
//                    public String getUserInfoQq() {
//                        return userInfoQq;
//                    }
//
//                    public void setUserInfoQq(String userInfoQq) {
//                        this.userInfoQq = userInfoQq;
//                    }
//
//                    public String getUserInfoStatus() {
//                        return userInfoStatus;
//                    }
//
//                    public void setUserInfoStatus(String userInfoStatus) {
//                        this.userInfoStatus = userInfoStatus;
//                    }
//
//                    public String getUserInfoWeixin() {
//                        return userInfoWeixin;
//                    }
//
//                    public void setUserInfoWeixin(String userInfoWeixin) {
//                        this.userInfoWeixin = userInfoWeixin;
//                    }
//
//                    public String getSex() {
//                        return sex;
//                    }
//
//                    public void setSex(String sex) {
//                        this.sex = sex;
//                    }
//
//                    public String getUserInfoId() {
//                        return userInfoId;
//                    }
//
//                    public void setUserInfoId(String userInfoId) {
//                        this.userInfoId = userInfoId;
//                    }
//                }
//
//                public static class GroupBean {
//                    /**
//                     * checked : null
//                     * userNumber : null
//                     * groupRemark : null
//                     * groupName : null
//                     * groupDept : null
//                     * groupId : null
//                     * dept : {"id":"5d5fe1e1802a4354a2bad375d8f6df8f","status":null,"deptName":null,"deptParentId":null,"checked":null,"pid":null,"deptDistrict":null,"deptId":null,"treeId":null,"deptAddress":null,"deptRemark":null,"deptType":null,"deptIdentify":null,"items":null,"userNumber":null,"name":null,"parentName":null}
//                     */
//
//                    private String checked;
//                    private String userNumber;
//                    private String groupRemark;
//                    private String groupName;
//                    private String groupDept;
//                    private String groupId;
//                    private DeptBeanX dept;
//
//                    public String getChecked() {
//                        return checked;
//                    }
//
//                    public void setChecked(String checked) {
//                        this.checked = checked;
//                    }
//
//                    public String getUserNumber() {
//                        return userNumber;
//                    }
//
//                    public void setUserNumber(String userNumber) {
//                        this.userNumber = userNumber;
//                    }
//
//                    public String getGroupRemark() {
//                        return groupRemark;
//                    }
//
//                    public void setGroupRemark(String groupRemark) {
//                        this.groupRemark = groupRemark;
//                    }
//
//                    public String getGroupName() {
//                        return groupName;
//                    }
//
//                    public void setGroupName(String groupName) {
//                        this.groupName = groupName;
//                    }
//
//                    public String getGroupDept() {
//                        return groupDept;
//                    }
//
//                    public void setGroupDept(String groupDept) {
//                        this.groupDept = groupDept;
//                    }
//
//                    public String getGroupId() {
//                        return groupId;
//                    }
//
//                    public void setGroupId(String groupId) {
//                        this.groupId = groupId;
//                    }
//
//                    public DeptBeanX getDept() {
//                        return dept;
//                    }
//
//                    public void setDept(DeptBeanX dept) {
//                        this.dept = dept;
//                    }
//
//                    public static class DeptBeanX {
//                        /**
//                         * id : 5d5fe1e1802a4354a2bad375d8f6df8f
//                         * status : null
//                         * deptName : null
//                         * deptParentId : null
//                         * checked : null
//                         * pid : null
//                         * deptDistrict : null
//                         * deptId : null
//                         * treeId : null
//                         * deptAddress : null
//                         * deptRemark : null
//                         * deptType : null
//                         * deptIdentify : null
//                         * items : null
//                         * userNumber : null
//                         * name : null
//                         * parentName : null
//                         */
//
//                        private String id;
//                        private String status;
//                        private String deptName;
//                        private String deptParentId;
//                        private String checked;
//                        private String pid;
//                        private String deptDistrict;
//                        private String deptId;
//                        private String treeId;
//                        private String deptAddress;
//                        private String deptRemark;
//                        private String deptType;
//                        private String deptIdentify;
//                        private String items;
//                        private String userNumber;
//                        private String name;
//                        private String parentName;
//
//                        public String getId() {
//                            return id;
//                        }
//
//                        public void setId(String id) {
//                            this.id = id;
//                        }
//
//                        public String getStatus() {
//                            return status;
//                        }
//
//                        public void setStatus(String status) {
//                            this.status = status;
//                        }
//
//                        public String getDeptName() {
//                            return deptName;
//                        }
//
//                        public void setDeptName(String deptName) {
//                            this.deptName = deptName;
//                        }
//
//                        public String getDeptParentId() {
//                            return deptParentId;
//                        }
//
//                        public void setDeptParentId(String deptParentId) {
//                            this.deptParentId = deptParentId;
//                        }
//
//                        public String getChecked() {
//                            return checked;
//                        }
//
//                        public void setChecked(String checked) {
//                            this.checked = checked;
//                        }
//
//                        public String getPid() {
//                            return pid;
//                        }
//
//                        public void setPid(String pid) {
//                            this.pid = pid;
//                        }
//
//                        public String getDeptDistrict() {
//                            return deptDistrict;
//                        }
//
//                        public void setDeptDistrict(String deptDistrict) {
//                            this.deptDistrict = deptDistrict;
//                        }
//
//                        public String getDeptId() {
//                            return deptId;
//                        }
//
//                        public void setDeptId(String deptId) {
//                            this.deptId = deptId;
//                        }
//
//                        public String getTreeId() {
//                            return treeId;
//                        }
//
//                        public void setTreeId(String treeId) {
//                            this.treeId = treeId;
//                        }
//
//                        public String getDeptAddress() {
//                            return deptAddress;
//                        }
//
//                        public void setDeptAddress(String deptAddress) {
//                            this.deptAddress = deptAddress;
//                        }
//
//                        public String getDeptRemark() {
//                            return deptRemark;
//                        }
//
//                        public void setDeptRemark(String deptRemark) {
//                            this.deptRemark = deptRemark;
//                        }
//
//                        public String getDeptType() {
//                            return deptType;
//                        }
//
//                        public void setDeptType(String deptType) {
//                            this.deptType = deptType;
//                        }
//
//                        public String getDeptIdentify() {
//                            return deptIdentify;
//                        }
//
//                        public void setDeptIdentify(String deptIdentify) {
//                            this.deptIdentify = deptIdentify;
//                        }
//
//                        public String getItems() {
//                            return items;
//                        }
//
//                        public void setItems(String items) {
//                            this.items = items;
//                        }
//
//                        public String getUserNumber() {
//                            return userNumber;
//                        }
//
//                        public void setUserNumber(String userNumber) {
//                            this.userNumber = userNumber;
//                        }
//
//                        public String getName() {
//                            return name;
//                        }
//
//                        public void setName(String name) {
//                            this.name = name;
//                        }
//
//                        public String getParentName() {
//                            return parentName;
//                        }
//
//                        public void setParentName(String parentName) {
//                            this.parentName = parentName;
//                        }
//                    }
//                }
//            }
//        }
//    }
}
