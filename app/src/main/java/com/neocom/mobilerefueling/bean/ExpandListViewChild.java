package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/7/18.
 */

public class ExpandListViewChild implements Serializable {

    private int icon;
    private String name;


    public ExpandListViewChild(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpandListViewChild{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                '}';
    }
}
