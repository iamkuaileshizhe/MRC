package com.neocom.mobilerefueling.bean;

import java.io.Serializable;


public class BaseBean implements Serializable {


//    bring	Array
//    code	message.common.0007
//    message	查询成功
//    purl	properties/code.properties
//    res	true
    private String purl;// 服务端用
    private boolean res; // 是否成功
    private String code; // 服务端result类中返回的编码
    private String message; // 返回信息


    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "BaseBean{" +
                "purl='" + purl + '\'' +
                ", res=" + res +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
