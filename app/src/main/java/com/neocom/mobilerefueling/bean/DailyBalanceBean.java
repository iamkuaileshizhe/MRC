package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29.
 */

public class DailyBalanceBean implements Serializable {

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
