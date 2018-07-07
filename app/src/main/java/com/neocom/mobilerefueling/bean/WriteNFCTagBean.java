package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/7.
 */

public class WriteNFCTagBean implements Serializable {

    private String cartype; // 要写入的  补给车类型

    private String carnum;

    private String writer;

    private String nfcId;

    public String getNfcId() {
        return nfcId;
    }

    public void setNfcId(String nfcId) {
        this.nfcId = nfcId;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    @Override
    public String toString() {
        return "WriteNFCTagBean{" +
                "cartype='" + cartype + '\'' +
                ", carnum='" + carnum + '\'' +
                ", writer='" + writer + '\'' +
                ", nfcId='" + nfcId + '\'' +
                '}';
    }
}
