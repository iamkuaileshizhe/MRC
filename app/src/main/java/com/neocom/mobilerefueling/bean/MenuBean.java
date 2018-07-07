package com.neocom.mobilerefueling.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/9.
 */

public class MenuBean implements Serializable {


    /**
     * purl : properties/code.properties
     * res : true
     * code : null
     * message :
     * <p>
     * bring : [{"id":"8e12cfc785a54ec4b1927ec86d9085ce","name":"订单列表","operations":[],"code":"busi_order_list"},{"id":"7bc30d6032bc4c31957be3215d171ee8","name":"车辆标签","operations":[],"code":"busi_nfc"},{"id":"1a48590753fc4c6f87a98b487eef0468","name":"交接班管理","operations":[],"code":"busi_handOver"},{"id":"cf8d3b9224f34302ba51f7204a6666c7","name":"交接班确认","operations":[],"code":"busi_handOver_auth"},{"id":"4be035c8ce9a47fe920ef9db9267b872","name":"完成订单","operations":[],"code":"busi_order_finish"},{"id":"b9ad10e838344f7fa8d6770c4c51ba50","name":"补给记录管理","operations":[],"code":"busi_supplyOil"},{"id":"cab16a8007084e738b6170a487cf2810","name":"接单","operations":[],"code":"busi_order_pickUp"}]
     */

    private String purl;
    private boolean res;
    private Object code;
    private String message;
    private List<BringBean> bring;

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * id : 8e12cfc785a54ec4b1927ec86d9085ce
         * name : 订单列表
         * operations : []
         * code : busi_order_list
         */

        private String id;
        private String name;
        private String code;
        private List<?> operations;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<?> getOperations() {
            return operations;
        }

        public void setOperations(List<?> operations) {
            this.operations = operations;
        }
    }
}
