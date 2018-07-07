package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/3.
 */

public class DicChildrenBean implements Serializable {

    /**
     * dictValue : 2
     * dictCode : ZQJS
     * dictName : 账期结算
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
