package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/5/12.
 * <p>
 * 14	流程关联商品接口 bean
 */

public class CangKuGoodsBean {

    private String commodityId;
    private String locId;
    private String unitPrice;
    private String num;
    private String serialNumber;
    private String circulateType;
    private String flag;
    private String storeIn;
    private String storeOut;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCirculateType() {
        return circulateType;
    }

    public void setCirculateType(String circulateType) {
        this.circulateType = circulateType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStoreIn() {
        return storeIn;
    }

    public void setStoreIn(String storeIn) {
        this.storeIn = storeIn;
    }

    public String getStoreOut() {
        return storeOut;
    }

    public void setStoreOut(String storeOut) {
        this.storeOut = storeOut;
    }
}
