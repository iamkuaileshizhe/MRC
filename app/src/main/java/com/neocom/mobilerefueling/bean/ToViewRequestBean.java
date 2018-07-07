package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class ToViewRequestBean {


    /**
     * id : 4eba5c7faec547d6943d85b640ed7cd0
     * isFlag : 0
     * opFlag : update
     * processDefId : wf_purchaseInsert
     * userId : a47ecb957fa1469787cf07554a0a81f1
     */

    private String id;
    private String isFlag;
    private String opFlag;
    private String processDefId;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    public String getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }

    public String getProcessDefId() {
        return processDefId;
    }

    public void setProcessDefId(String processDefId) {
        this.processDefId = processDefId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
