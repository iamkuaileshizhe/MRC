package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/3.
 */

public class DictReqBean implements Serializable {


    /**
     * JSFS : JSFS
     * wf_manage_scope : wf_manage_scope
     * wf_firm_industry : wf_firm_industry
     * wf_firm_type : wf_firm_type
     * wf_customer_type : wf_customer_type
     * wf_customer_source : wf_customer_source
     * car_type : car_type
     * supply_way : supply_way
     */

//    map	Map	Y	参数类型集合
//
//    参数分类
//    参数类型	参数名称	是否必输	描述
//    JSFS	客户结算方式	N	现结算、账期结算
//    wf_manage_scope	经营范围	N	劳务总承包、劳务专业承包…
//    wf_firm_industry	所属行业	N	交通运输、石油炼化…
//    wf_firm_type	企业类型	N	私营企业、国有企业…
//    wf_customer_type	客户类型	N	企业、个人
//    wf_customer_source	客户来源	N	内部开发、合作伙伴
//    car_type	车辆类型	N	客车、货车…
//    supply_way	补给方式	N	油枪、油罐…
//    customer_grade	客户等级	N	普通会员、黄金会员…
//    wf_customer_payment	客户账期	N	一个月、两个月…


    private String JSFS;
    private String wf_manage_scope;
    private String wf_firm_industry;
    private String wf_firm_type;
    private String wf_customer_type;
    private String wf_customer_source;
    private String car_type;
    private String supply_way;
    private String customer_grade;
    private String wf_customer_payment;


    public String getCustomer_grade() {
        return customer_grade;
    }

    public void setCustomer_grade(String customer_grade) {
        this.customer_grade = customer_grade;
    }

    public String getWf_customer_payment() {
        return wf_customer_payment;
    }

    public void setWf_customer_payment(String wf_customer_payment) {
        this.wf_customer_payment = wf_customer_payment;
    }

    public String getJSFS() {
        return JSFS;
    }

    public void setJSFS(String JSFS) {
        this.JSFS = JSFS;
    }

    public String getWf_manage_scope() {
        return wf_manage_scope;
    }

    public void setWf_manage_scope(String wf_manage_scope) {
        this.wf_manage_scope = wf_manage_scope;
    }

    public String getWf_firm_industry() {
        return wf_firm_industry;
    }

    public void setWf_firm_industry(String wf_firm_industry) {
        this.wf_firm_industry = wf_firm_industry;
    }

    public String getWf_firm_type() {
        return wf_firm_type;
    }

    public void setWf_firm_type(String wf_firm_type) {
        this.wf_firm_type = wf_firm_type;
    }

    public String getWf_customer_type() {
        return wf_customer_type;
    }

    public void setWf_customer_type(String wf_customer_type) {
        this.wf_customer_type = wf_customer_type;
    }

    public String getWf_customer_source() {
        return wf_customer_source;
    }

    public void setWf_customer_source(String wf_customer_source) {
        this.wf_customer_source = wf_customer_source;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getSupply_way() {
        return supply_way;
    }

    public void setSupply_way(String supply_way) {
        this.supply_way = supply_way;
    }
}
