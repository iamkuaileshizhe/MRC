package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/28.
 */

public class AddressBean {


    /**
     * ID : 110000
     * typeName : 北京市
     * children : [{"ID":"110100","typeName":"东城区","children":[],"pid":"110000"},{"ID":"110200","typeName":"西城区","children":[],"pid":"110000"},{"ID":"110500","typeName":"朝阳区","children":[],"pid":"110000"},{"ID":"110600","typeName":"丰台区","children":[],"pid":"110000"},{"ID":"110700","typeName":"石景山区","children":[],"pid":"110000"},{"ID":"110800","typeName":"海淀区","children":[],"pid":"110000"},{"ID":"110900","typeName":"门头沟区","children":[],"pid":"110000"},{"ID":"111100","typeName":"房山区","children":[],"pid":"110000"},{"ID":"111200","typeName":"通州区","children":[],"pid":"110000"},{"ID":"111300","typeName":"顺义区","children":[],"pid":"110000"},{"ID":"111400","typeName":"昌平区","children":[],"pid":"110000"},{"ID":"111500","typeName":"大兴区","children":[],"pid":"110000"},{"ID":"111600","typeName":"怀柔区","children":[],"pid":"110000"},{"ID":"111700","typeName":"平谷区","children":[],"pid":"110000"},{"ID":"112800","typeName":"密云县","children":[],"pid":"110000"},{"ID":"112900","typeName":"延庆县","children":[],"pid":"110000"}]
     * pid : 0
     */

    private String ID;
    private String typeName;
    private String pid;
    private List<AddressBean> children;

    public AddressBean() {
    }

    public AddressBean(String ID, String typeName) {
        this.ID = ID;
        this.typeName = typeName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<AddressBean> getChildren() {
        return children;
    }

    public void setChildren(List<AddressBean> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "AddressBean{" +
                "ID='" + ID + '\'' +
                ", typeName='" + typeName + '\'' +
                ", pid='" + pid + '\'' +
                ", children=" + children +
                '}';
    }
}
