package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 * 潜在客户
 */

public class QZKHRespBean extends BaseBean {


    private List<KHDetailBringBean> bring;

    public List<KHDetailBringBean> getBring() {
        return bring;
    }

    public void setBring(List<KHDetailBringBean> bring) {
        this.bring = bring;
    }


}
