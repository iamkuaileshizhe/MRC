package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/10.
 */

public class JiaoJieSubmitBean implements Serializable {
    private String shiftId;
    private String userId;
    private String flag;

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
