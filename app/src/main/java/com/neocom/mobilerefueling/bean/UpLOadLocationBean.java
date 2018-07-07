package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/8.
 */

public class UpLOadLocationBean implements Serializable {



//    carNum	String	Y	车牌号
//    longitude	String	Y	位置经度
//    dimension	String	Y	位置维度
//    userId	String	N	上传用户id
//    equId	String	N	上传设备唯一标识


    /**
     * userId :
     * equId :
     * carNum : 鲁A99999
     * longitude : 117.1015857968503
     * dimension : 36.65933857710188
     */

    private String userId;
    private String equId;
    private String carNum;
    private String longitude;
    private String dimension;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEquId() {
        return equId;
    }

    public void setEquId(String equId) {
        this.equId = equId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
