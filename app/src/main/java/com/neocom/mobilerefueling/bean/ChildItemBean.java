package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/4/25.
 */

public class ChildItemBean {
    private String itemType;
    private String itemId;
    private String itemValue;
    private String itemTelephone;
    private String itemLinkMan;
    private String itemAddress;
    private String itemSupplier;
    private String itemSupplyId;
    private String itemSupplyStatus;
    private int position;

    public String getItemSupplyId() {
        return itemSupplyId;
    }

    public void setItemSupplyId(String itemSupplyId) {
        this.itemSupplyId = itemSupplyId;
    }

    public String getItemSupplyStatus() {
        return itemSupplyStatus;
    }

    public void setItemSupplyStatus(String itemSupplyStatus) {
        this.itemSupplyStatus = itemSupplyStatus;
    }

    public String getItemSupplier() {
        return itemSupplier;
    }

    public void setItemSupplier(String itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    public String getItemAddress() {
        return itemAddress;
    }

    public void setItemAddress(String itemAddress) {
        this.itemAddress = itemAddress;
    }

    public String getItemLinkMan() {
        return itemLinkMan;
    }

    public void setItemLinkMan(String itemLinkMan) {
        this.itemLinkMan = itemLinkMan;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getItemTelephone() {
        return itemTelephone;
    }

    public void setItemTelephone(String itemTelephone) {
        this.itemTelephone = itemTelephone;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
