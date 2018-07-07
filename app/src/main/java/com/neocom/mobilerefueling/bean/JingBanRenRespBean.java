package com.neocom.mobilerefueling.bean;


/**
 * Created by Administrator on 2018/4/23.
 */

public class JingBanRenRespBean extends BaseBean {


    private String purl;
    private JBRBringBean bring;

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public JBRBringBean getBring() {
        return bring;
    }

    public void setBring(JBRBringBean bring) {
        this.bring = bring;
    }


}
