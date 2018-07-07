package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/16.
 */

public class AllCostReqBean implements Serializable {


    /**
     * deliveryId : efae093fbe734c06930404e7e969d18a
     * oilAmount : 50
     */

    private String deliveryId;
    private String oilAmount;
    private String settleUnit ;

    public String getSettleUnit() {
        return settleUnit;
    }

    public void setSettleUnit(String settleUnit) {
        this.settleUnit = settleUnit;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getOilAmount() {
        return oilAmount;
    }

    public void setOilAmount(String oilAmount) {
        this.oilAmount = oilAmount;
    }
}
