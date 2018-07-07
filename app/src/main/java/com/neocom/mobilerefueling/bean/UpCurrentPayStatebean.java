package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2018/1/1.
 */

public class UpCurrentPayStatebean implements Serializable {

    private String recordId;
    private String status;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpCurrentPayStatebean{" +
                "recordId='" + recordId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
