package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/9/13.
 */

public class RequestDingdanOrderBean implements Serializable {

//    {
//	“userId”:” 917f2f6eb1ce42a5968ee3a76bcf07c9”
//        "indentStatus":"1",
//“beginNum”:”1”,
//	“endNum”:”10”
//    }

    private String userId;
    private String indentStatus;
    private String beginNum;
    private String endNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getBeginNum() {
        return beginNum;
    }

    public void setBeginNum(String beginNum) {
        this.beginNum = beginNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    @Override
    public String toString() {
        return "RequestDingdanOrderBean{" +
                "userId='" + userId + '\'' +
                ", indentStatus='" + indentStatus + '\'' +
                ", beginNum='" + beginNum + '\'' +
                ", endNum='" + endNum + '\'' +
                '}';
    }
}
