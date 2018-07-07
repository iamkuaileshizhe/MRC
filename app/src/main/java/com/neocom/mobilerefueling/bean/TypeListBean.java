package com.neocom.mobilerefueling.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class TypeListBean {

    public String id;
    public String typeName;
    public String parentId;
    public List<TypeListBean> items;

    //层级
    public int level;
    //是否打开的状态
    public boolean open;


    public List<TypeListBean> getItems() {
        return items;
    }

    public void setItems(List<TypeListBean> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public boolean hasChild() {
        return items != null && items.size() > 0;
    }

    public void addChildren(LinkedList<TypeListBean> children) {
        this.items.clear();
        this.items.addAll(children);
    }


}
