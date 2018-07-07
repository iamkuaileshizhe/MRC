package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/26.
 */

public class batchNum implements Serializable {
    private String id;
    private String batchNum;

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
}
