package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/12.
 */

public class ProcessRelGoodsBean implements Serializable {


    /**
     * josonList : [{"commodityId":"bae3537aa866448598c776dab2a42062","locId":"fb065202268f4afdbe51df20cd88ddec","circulateType":0,"unitPrice":"11223","num":"20","flag":1},{"commodityId":"d8735f2c59a5443e9dfa576992d9cc40","locId":"fb065202268f4afdbe51df20cd88ddec","circulateType":0,"unitPrice":null,"num":1,"flag":1}]
     * workOrderId : 4bae1febb3fc423c8ae4e0cc0eb2d0e8
     * userId : a47ecb957fa1469787cf07554a0a81f1
     *  opType : 0
     *  storeIn  :
     *  storeOut  :
     */

    private String josonList;
    private String workOrderId;
    private String userId;
    private String opType;
    private String storeIn;
    private String storeOut;

    public String getJosonList() {
        return josonList;
    }

    public void setJosonList(String josonList) {
        this.josonList = josonList;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getStoreIn() {
        return storeIn;
    }

    public void setStoreIn(String storeIn) {
        this.storeIn = storeIn;
    }

    public String getStoreOut() {
        return storeOut;
    }

    public void setStoreOut(String storeOut) {
        this.storeOut = storeOut;
    }
}
