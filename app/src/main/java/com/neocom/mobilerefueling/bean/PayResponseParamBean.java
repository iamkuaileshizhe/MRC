package com.neocom.mobilerefueling.bean;

/**
 * Created by admin on 2017/11/22.
 */

public class PayResponseParamBean extends BaseBean {
    /**
     * bring : {"id":"12cee9c3133b416cae0ea34f10d6e278","returnStr":"435747125722494291200"}
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
         * id : 12cee9c3133b416cae0ea34f10d6e278
         * returnStr : 435747125722494291200
         */

        private String id;
        private String returnStr;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getReturnStr() {
            return returnStr;
        }

        public void setReturnStr(String returnStr) {
            this.returnStr = returnStr;
        }
    }


//    private String bring;
//
//    public String getBring() {
//        return bring;
//    }
//
//    public void setBring(String bring) {
//        this.bring = bring;
//    }
//
//    @Override
//    public String toString() {
//        return "PayResponseParamBean{" +
//                "bring='" + bring + '\'' +
//                '}';
//    }
}
