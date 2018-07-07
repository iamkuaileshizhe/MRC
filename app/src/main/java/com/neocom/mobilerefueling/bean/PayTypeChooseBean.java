package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/2.
 */

public class PayTypeChooseBean implements Serializable {

    private int payTypeLogo;
    private String payTypeText;
    private int payTypeState;
    private boolean isChecked;


    public PayTypeChooseBean(int payTypeLogo, String payTypeText, int payTypeState) {
        this.payTypeLogo = payTypeLogo;
        this.payTypeText = payTypeText;
        this.payTypeState = payTypeState;
    }

    public int getPayTypeLogo() {
        return payTypeLogo;
    }

    public void setPayTypeLogo(int payTypeLogo) {
        this.payTypeLogo = payTypeLogo;
    }

    public String getPayTypeText() {
        return payTypeText;
    }

    public void setPayTypeText(String payTypeText) {
        this.payTypeText = payTypeText;
    }

    public int getPayTypeState() {
        return payTypeState;
    }

    public void setPayTypeState(int payTypeState) {
        this.payTypeState = payTypeState;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "PayTypeChooseBean{" +
                "payTypeLogo=" + payTypeLogo +
                ", payTypeText='" + payTypeText + '\'' +
                ", payTypeState=" + payTypeState +
                ", isChecked=" + isChecked +
                '}';
    }
}
