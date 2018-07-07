package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/6/2.
 */

public class WaitDoRequest implements Serializable {
    private String c_user;//流程创建用户标识//
    private String beginNum;//第几页//beginNum
    private String endNum;//显示多少条//endNum

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }


    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }


    public String getC_user() {
        return c_user;
    }

    public void setC_user(String c_user) {
        this.c_user = c_user;
    }


}
