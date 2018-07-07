package com.widget.jcdialog.bean;

import java.io.Serializable;

/**
 * 类名称：PopuBean
 * 描述：下拉列表的Bean对象
 */
public class PopuBean implements Serializable {
    /**
     * 下拉条目id
     */
    int id;
    /**
     * 下拉条目sid
     */
    String sid;
    /**
     * 下拉条目标题
     */
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
