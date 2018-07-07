package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/8/28.
 */

public class GetPiCiBean extends BaseBean {


    private List<PiCiBringBean> bring;

    public List<PiCiBringBean> getBring() {
        return bring;
    }

    public void setBring(List<PiCiBringBean> bring) {
        this.bring = bring;
    }

}
