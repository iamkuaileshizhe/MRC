package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class StartProcessBean {


    /**
     * purl : properties/code.properties
     * res : true
     * code : message.common.0000
     * message : 成功
     * bring : {"linkId":"af4154d095ee498f8df4dbaab1b20a80","workorderId":"2b4ca298ba874b0ebf59861f3e199581","workorderTable":"t_process_formbaseinfo","workorderTitle":"PURRK-201804006","workorderSummary":null,"workorderBusikey":"wf_purchaseInsert","bpmnId":null,"linkState":null,"procInstId":"112620","executionId":"112620","procDefId":"wf_purchaseInsert:7:110064","deploymentId":"110061","taskId":null,"jobId":null,"linkStatus":"1","createUser":"a47ecb957fa1469787cf07554a0a81f1\n","createDt":"2018-04-27 13:25:23","transName":null,"viewUrl":"/busi/process/common/toApproval/wf_purchaseInsert/","startInstId":null,"moniStatus":null,"priority":null,"processNo":"PURRK-201804006","processTime":null,"endTime":null,"handleUser":"a47ecb957fa1469787cf07554a0a81f1\n","isKnow":"0","knowTitle":"0","knowId":"0","currHandler":null}
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
         * linkId : af4154d095ee498f8df4dbaab1b20a80
         * workorderId : 2b4ca298ba874b0ebf59861f3e199581
         * workorderTable : t_process_formbaseinfo
         * workorderTitle : PURRK-201804006
         * workorderSummary : null
         * workorderBusikey : wf_purchaseInsert
         * bpmnId : null
         * linkState : null
         * procInstId : 112620
         * executionId : 112620
         * procDefId : wf_purchaseInsert:7:110064
         * deploymentId : 110061
         * taskId : null
         * jobId : null
         * linkStatus : 1
         * createUser : a47ecb957fa1469787cf07554a0a81f1

         * createDt : 2018-04-27 13:25:23
         * transName : null
         * viewUrl : /busi/process/common/toApproval/wf_purchaseInsert/
         * startInstId : null
         * moniStatus : null
         * priority : null
         * processNo : PURRK-201804006
         * processTime : null
         * endTime : null
         * handleUser : a47ecb957fa1469787cf07554a0a81f1

         * isKnow : 0
         * knowTitle : 0
         * knowId : 0
         * currHandler : null
         */

        private String linkId;
        private String workorderId;
        private String workorderTable;
        private String workorderTitle;
        private String workorderSummary;
        private String workorderBusikey;
        private String bpmnId;
        private String linkState;
        private String procInstId;
        private String executionId;
        private String procDefId;
        private String deploymentId;
        private String taskId;
        private String jobId;
        private String linkStatus;
        private String createUser;
        private String createDt;
        private String transName;
        private String viewUrl;
        private String startInstId;
        private String moniStatus;
        private String priority;
        private String processNo;
        private String processTime;
        private String endTime;
        private String handleUser;
        private String isKnow;
        private String knowTitle;
        private String knowId;
        private String currHandler;

        public String getLinkId() {
            return linkId;
        }

        public void setLinkId(String linkId) {
            this.linkId = linkId;
        }

        public String getWorkorderId() {
            return workorderId;
        }

        public void setWorkorderId(String workorderId) {
            this.workorderId = workorderId;
        }

        public String getWorkorderTable() {
            return workorderTable;
        }

        public void setWorkorderTable(String workorderTable) {
            this.workorderTable = workorderTable;
        }

        public String getWorkorderTitle() {
            return workorderTitle;
        }

        public void setWorkorderTitle(String workorderTitle) {
            this.workorderTitle = workorderTitle;
        }

        public String getWorkorderSummary() {
            return workorderSummary;
        }

        public void setWorkorderSummary(String workorderSummary) {
            this.workorderSummary = workorderSummary;
        }

        public String getWorkorderBusikey() {
            return workorderBusikey;
        }

        public void setWorkorderBusikey(String workorderBusikey) {
            this.workorderBusikey = workorderBusikey;
        }

        public String getBpmnId() {
            return bpmnId;
        }

        public void setBpmnId(String bpmnId) {
            this.bpmnId = bpmnId;
        }

        public String getLinkState() {
            return linkState;
        }

        public void setLinkState(String linkState) {
            this.linkState = linkState;
        }

        public String getProcInstId() {
            return procInstId;
        }

        public void setProcInstId(String procInstId) {
            this.procInstId = procInstId;
        }

        public String getExecutionId() {
            return executionId;
        }

        public void setExecutionId(String executionId) {
            this.executionId = executionId;
        }

        public String getProcDefId() {
            return procDefId;
        }

        public void setProcDefId(String procDefId) {
            this.procDefId = procDefId;
        }

        public String getDeploymentId() {
            return deploymentId;
        }

        public void setDeploymentId(String deploymentId) {
            this.deploymentId = deploymentId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public String getLinkStatus() {
            return linkStatus;
        }

        public void setLinkStatus(String linkStatus) {
            this.linkStatus = linkStatus;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getCreateDt() {
            return createDt;
        }

        public void setCreateDt(String createDt) {
            this.createDt = createDt;
        }

        public String getTransName() {
            return transName;
        }

        public void setTransName(String transName) {
            this.transName = transName;
        }

        public String getViewUrl() {
            return viewUrl;
        }

        public void setViewUrl(String viewUrl) {
            this.viewUrl = viewUrl;
        }

        public String getStartInstId() {
            return startInstId;
        }

        public void setStartInstId(String startInstId) {
            this.startInstId = startInstId;
        }

        public String getMoniStatus() {
            return moniStatus;
        }

        public void setMoniStatus(String moniStatus) {
            this.moniStatus = moniStatus;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getProcessNo() {
            return processNo;
        }

        public void setProcessNo(String processNo) {
            this.processNo = processNo;
        }

        public String getProcessTime() {
            return processTime;
        }

        public void setProcessTime(String processTime) {
            this.processTime = processTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getHandleUser() {
            return handleUser;
        }

        public void setHandleUser(String handleUser) {
            this.handleUser = handleUser;
        }

        public String getIsKnow() {
            return isKnow;
        }

        public void setIsKnow(String isKnow) {
            this.isKnow = isKnow;
        }

        public String getKnowTitle() {
            return knowTitle;
        }

        public void setKnowTitle(String knowTitle) {
            this.knowTitle = knowTitle;
        }

        public String getKnowId() {
            return knowId;
        }

        public void setKnowId(String knowId) {
            this.knowId = knowId;
        }

        public String getCurrHandler() {
            return currHandler;
        }

        public void setCurrHandler(String currHandler) {
            this.currHandler = currHandler;
        }
    }
}
