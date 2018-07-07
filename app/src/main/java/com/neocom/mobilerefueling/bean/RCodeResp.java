package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RCodeResp extends BaseBean {


    /**
     * code : null
     * bring : {"dURL":"192.168.1.134:8080/busi/appDownload/appForClient","recommCode":"598149"}
     */

    private BringBean bring;

    public BringBean getBring() {
        return bring;
    }

    public void setBring(BringBean bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * dURL : 192.168.1.134:8080/busi/appDownload/appForClient
         * recommCode : 598149
         */

        private String dURL;
        private String recommCode;

        public String getDURL() {
            return dURL;
        }

        public void setDURL(String dURL) {
            this.dURL = dURL;
        }

        public String getRecommCode() {
            return recommCode;
        }

        public void setRecommCode(String recommCode) {
            this.recommCode = recommCode;
        }
    }
}
