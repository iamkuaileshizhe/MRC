package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2018/1/12.
 */

public class UnionParRespBean extends BaseBean {


    /**
     * bring : {"id":"d999e0cc03be4f3d9ec8f29847a59eff","model":"00","returnStr":"493840462356752328507"}
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
         * id : d999e0cc03be4f3d9ec8f29847a59eff
         * model : 00
         * returnStr : 493840462356752328507
         */

        private String id;
        private String model;
        private String returnStr;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getReturnStr() {
            return returnStr;
        }

        public void setReturnStr(String returnStr) {
            this.returnStr = returnStr;
        }
    }
}
