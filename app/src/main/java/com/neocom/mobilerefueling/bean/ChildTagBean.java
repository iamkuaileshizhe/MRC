package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/7/2.
 */

public class ChildTagBean {
    private int position;
    private String key;

    public ChildTagBean(int position, String key) {
        this.position = position;
        this.key = key;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
