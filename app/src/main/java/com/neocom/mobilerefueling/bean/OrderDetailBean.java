package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/8/22.
 */

public class OrderDetailBean extends BaseBean {
    OrderDetailItemBean bring;

    public OrderDetailItemBean getBring() {
        return bring;
    }

    public void setBring(OrderDetailItemBean bring) {
        this.bring = bring;
    }

    @Override
    public String toString() {
        return super.toString()+ "OrderDetailBean{" +
                "bring=" + bring +
                '}';
    }
}
