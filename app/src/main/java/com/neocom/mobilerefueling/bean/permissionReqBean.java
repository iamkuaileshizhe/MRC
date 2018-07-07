package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/23.
 */

public class permissionReqBean implements Serializable {

//    processDefId	String	Y	流程定义标识，在平台中就是流程类别，在系统的字典中能找到相关的数据维护，如图1-1
//    formCode	String	N	表单编码，表示着每一个流程工单的唯一，可在web找到相应表单编码维护，如图：1-2
//    不填，将使用默认表单模板。推荐不填
//    userId	String	Y	当前登录用户的id

    private String processDefId;
    private String formCode;
    private String userId;
    private String workOrderId;
    private String executionId;

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(String processDefId) {
        this.processDefId = processDefId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

//
//    /**
//     * processDefId : wf_purchaseInsert
//     * workOrderId : 04a301e06e75441aa0811278ce25ff19
//     * curTaskId : wf_purchaseInsert_start
//     * formCode : form_bb_insert
//     */
//
//
//
//    private String processDefId;
//    private String workOrderId;
//    private String curTaskId;
//    private String formCode;
//    private String userId;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getProcessDefId() {
//        return processDefId;
//    }
//
//    public void setProcessDefId(String processDefId) {
//        this.processDefId = processDefId;
//    }
//
//    public String getWorkOrderId() {
//        return workOrderId;
//    }
//
//    public void setWorkOrderId(String workOrderId) {
//        this.workOrderId = workOrderId;
//    }
//
//    public String getCurTaskId() {
//        return curTaskId;
//    }
//
//    public void setCurTaskId(String curTaskId) {
//        this.curTaskId = curTaskId;
//    }
//
//    public String getFormCode() {
//        return formCode;
//    }
//
//    public void setFormCode(String formCode) {
//        this.formCode = formCode;
//    }
}
