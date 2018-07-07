package com.neocom.mobilerefueling.bean;


/**
 * Created by admin on 2017/8/28.
 */

public class EmptyBringGetOilBean extends BaseBean {

    String bring;

    public String getBring() {
        return bring == null ? "" : bring;
    }

    public void setBring(String bring) {
        this.bring = bring;
    }

    @Override
    public String toString() {
        return "EmptyBringGetOilBean{" +
                "bring='" + bring + '\'' +
                '}';
    }
}
