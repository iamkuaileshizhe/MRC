package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/12/25.
 */

public class ProvinceCodeRespBean extends BaseBean {


    /**
     * purl : properties/code.properties
     * res : true
     * code : message.common.0007
     * message : 查询成功
     * bring : {"code":"370000"}
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
         * code : 370000
         */

        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
