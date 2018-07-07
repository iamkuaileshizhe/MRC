package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/8/22.
 */

public class AllOrderBean extends BaseBean {

    private List<AllOrderListBean> bring;

    public List<AllOrderListBean> getBring() {
        return bring;
    }

    public void setBring(List<AllOrderListBean> bring) {
        this.bring = bring;
    }

    @Override
    public String toString() {
        return super.toString() + "AllOrderBean{" +
                "bring=" + bring +
                '}';
    }
}
