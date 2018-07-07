package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/22.
 * <p>
 * 参数名称	参数说明	备注
 * userId	用户id	登录账号的userId
 * payWay	支付方式	1银联2支付宝3微信4扣款（从账户扣款）
 * amount	交易金额	（单位元，最多保留两位小数）
 * type	交易类型	交易类型1充值2退款3支付（金钱使用）
 * goodsType	商品类型	1充值2油品
 * relationId	关联单号id	派送单or其他单id关联单号
 */

public class PayRequestParamBean implements Serializable {

    private String userId;
    private String payWay;
    private String amount;
    private String type;
    private String goodsType;
    private String relationId;
    private String useBalance;

    public String getUseBalance() {
        return useBalance;
    }

    public void setUseBalance(String useBalance) {
        this.useBalance = useBalance;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PayRequestParamBean{" +
                "userId='" + userId + '\'' +
                ", payWay='" + payWay + '\'' +
                ", amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", relationId='" + relationId + '\'' +
                '}';
    }
}
