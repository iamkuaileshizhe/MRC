package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RecmentReqListBean implements Serializable {


    /**
     * userId : a153c763485b4f41bdb1cf5686d14334
     * page : -1
     * pageSize : 10
     */

    private String userId;
    private String page;
    private String pageSize;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
