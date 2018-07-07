package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/9.
 */

public class ModifyRecordSupply implements Serializable {

    private String id;
    private String recordStatus;
    private String confirmPeople;
    private String confirmTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getConfirmPeople() {
        return confirmPeople;
    }

    public void setConfirmPeople(String confirmPeople) {
        this.confirmPeople = confirmPeople;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Override
    public String toString() {
        return "ModifyRecordSupply{" +
                "id='" + id + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", confirmPeople='" + confirmPeople + '\'' +
                ", confirmTime='" + confirmTime + '\'' +
                '}';
    }
}
