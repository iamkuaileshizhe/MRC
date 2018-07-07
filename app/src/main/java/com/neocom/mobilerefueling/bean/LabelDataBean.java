package com.neocom.mobilerefueling.bean;

/**
 * Created by Administrator on 2018/4/23.
 */

public class LabelDataBean<T> {
    /**
     * coltext : 入库编号
     * value : PURRK-201804005
     * colType : codeRule
     * showorder : 0
     * required :
     * defaultValue :
     * colname : form_processNo
     * dataValue :
     * isEditor : 2
     */

    private String coltext;
    private String value;
    private String colType;
    private String showorder;
    private String required;
    private String defaultValue;
    private String colname;
    private T dataValue;
    private String isEditor;
    private String showValue;
    private String controlValue;
    private String controlText;


    /**
     * 扩展字段
     * 0:data为对象
     * 1:data为集合
     * 2:date为空或者null字段
     * 3:date 为 String 字符串
     */
    public int dataType;

    public String getShowValue() {
        return showValue;
    }

    public void setShowValue(String showValue) {
        this.showValue = showValue;
    }

    public String getControlValue() {
        return controlValue;
    }

    public void setControlValue(String controlValue) {
        this.controlValue = controlValue;
    }

    public String getControlText() {
        return controlText;
    }

    public void setControlText(String controlText) {
        this.controlText = controlText;
    }

    public String getColtext() {
        return coltext;
    }

    public void setColtext(String coltext) {
        this.coltext = coltext;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getShoworder() {
        return showorder;
    }

    public void setShoworder(String showorder) {
        this.showorder = showorder;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    public T getDataValue() {
        return dataValue;
    }

    public void setDataValue(T dataValue) {
        this.dataValue = dataValue;
    }

    public String getIsEditor() {
        return isEditor;
    }

    public void setIsEditor(String isEditor) {
        this.isEditor = isEditor;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

}
