package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/6.
 */

public class DSHKeHuBean implements Serializable {

//    roleCode	String	Y	登陆角色code
//1:销售主任
//2:地区经理
//    nameSim	String	N	客户简称
//    currentPage	String	Y	第几页
//    pageSize	String	Y	显示多少条数据

    private String roleCode;
    private String nameSim;
    private String currentPage;
    private String pageSize;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getNameSim() {
        return nameSim;
    }

    public void setNameSim(String nameSim) {
        this.nameSim = nameSim;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
