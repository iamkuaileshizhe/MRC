package com.neocom.mobilerefueling.bean;


public class Marquee {
    private String oilTitle; // 油品类型国标
    private String oilPrice; // 当前优惠后的价格
    private String oilPercent; // 优惠额度
    private String oilNormal; // 优惠之前的价格
    private String imgUrl; // 存在 链接 图片 的 url

    public String getOilNormal() {
        return oilNormal;
    }

    public void setOilNormal(String oilNormal) {
        this.oilNormal = oilNormal;
    }

    public String getOilTitle() {
        return oilTitle;
    }


    public void setOilTitle(String oilTitle) {
        this.oilTitle = oilTitle;
    }

    public String getOilPrice() {
        return oilPrice;
    }

    public void setOilPrice(String oilPrice) {
        this.oilPrice = oilPrice;
    }

    public String getOilPercent() {
        return oilPercent;
    }

    public void setOilPercent(String oilPercent) {
        this.oilPercent = oilPercent;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Marquee{" +
                "oilTitle='" + oilTitle + '\'' +
                ", oilPrice='" + oilPrice + '\'' +
                ", oilPercent='" + oilPercent + '\'' +
                ", oilNormal='" + oilNormal + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

}
