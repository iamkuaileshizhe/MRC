package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class PayWayReqBean extends BaseBean {


    /**
     * code : null
     * bring : [{"payWayName":"支付宝","payWayCode":"2"},{"payWayName":"银联","payWayCode":"1"},{"payWayName":"微信","payWayCode":"3"}]
     */

    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * payWayName : 支付宝
         * payWayCode : 2
         */

        private String payWayName;
        private String payWayCode;

        public String getPayWayName() {
            return payWayName;
        }

        public void setPayWayName(String payWayName) {
            this.payWayName = payWayName;
        }

        public String getPayWayCode() {
            return payWayCode;
        }

        public void setPayWayCode(String payWayCode) {
            this.payWayCode = payWayCode;
        }
    }
}
