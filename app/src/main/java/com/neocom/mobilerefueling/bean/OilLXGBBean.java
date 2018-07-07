package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/14.
 */

public class OilLXGBBean extends BaseBean {


    private List<BringBean> bring;

    public List<BringBean> getBring() {
        return bring;
    }

    public void setBring(List<BringBean> bring) {
        this.bring = bring;
    }

    public static class BringBean {
        /**
         * dictValue : 1
         * dictCode : GB2
         * dictName : 国二
         */

        private String dictValue;
        private String dictCode;
        private String dictName;

        public String getDictValue() {
            return dictValue;
        }

        public void setDictValue(String dictValue) {
            this.dictValue = dictValue;
        }

        public String getDictCode() {
            return dictCode;
        }

        public void setDictCode(String dictCode) {
            this.dictCode = dictCode;
        }

        public String getDictName() {
            return dictName;
        }

        public void setDictName(String dictName) {
            this.dictName = dictName;
        }
    }
}
