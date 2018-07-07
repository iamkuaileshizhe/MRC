package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/7.
 */

public class LoginBean implements Serializable {


    /**
     * userCode : yuziyang
     * pwd : e10adc3949ba59abbe56e057f20f883e
     * carNum : 京H12345
     */

    private String userCode;
    private String pwd;
    private String carNum;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }
}
