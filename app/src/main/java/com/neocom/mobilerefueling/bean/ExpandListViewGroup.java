package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/7/18.
 */

public class ExpandListViewGroup implements Serializable {

    private int gicon;
    private String gname;
    private List<ExpandListViewChild> children;

    public ExpandListViewGroup(int gicon, String gname) {
        this.gicon = gicon;
        this.gname = gname;
        children=new ArrayList<>();
    }

    public int getGicon() {
        return gicon;
    }

    public void setGicon(int gicon) {
        this.gicon = gicon;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public List<ExpandListViewChild> getChildren() {
        return children;
    }

    public void setChildren(List<ExpandListViewChild> children) {
        this.children = children;
    }

    public void addChildrenItem(ExpandListViewChild child) {

        children.add(child);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public ExpandListViewChild getChildItem(int index) {
        return children.get(index);
    }

}
