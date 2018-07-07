package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/2/3.
 */

public class DictBean extends BaseBean {


    /**
     * bring : {"JSFS":[{"dictValue":"2","dictCode":"ZQJS","dictName":"账期结算"},{"dictValue":"1","dictCode":"XJS","dictName":"现结算"}],"wf_firm_industry":[{"dictValue":"4","dictCode":"mining","dictName":"油气储运"},{"dictValue":"3","dictCode":"manufacture","dictName":"油气开采"},{"dictValue":"2","dictCode":"construction ","dictName":"石油炼化"},{"dictValue":"1","dictCode":"transportation","dictName":"交通运输"}],"supply_way":[{"dictValue":"2","dictCode":"Oil filling","dictName":"油罐"},{"dictValue":"1","dictCode":"Oil gun","dictName":"油枪"}],"wf_customer_source":[{"dictValue":"2","dictCode":"partner","dictName":"合作伙伴"},{"dictValue":"1","dictCode":"inward","dictName":"内部开发"}],"wf_customer_type":[{"dictValue":"2","dictCode":"personage","dictName":"个人"},{"dictValue":"1","dictCode":"company","dictName":"企业"}],"car_type":[{"dictValue":"3","dictCode":"Truck","dictName":"货车"},{"dictValue":"2","dictCode":"Passenger car","dictName":"客车"},{"dictValue":"1","dictCode":"Big truck","dictName":"工程机械"}],"wf_firm_type":[{"dictValue":"8","dictCode":"compareFirm","dictName":"股份合作企业"},{"dictValue":"7","dictCode":"personalFirm","dictName":"个人独资企业"},{"dictValue":"6","dictCode":"foreignFirm","dictName":"外商投资企业"},{"dictValue":"5","dictCode":"affiliatedFirm","dictName":"联营企业"},{"dictValue":"4","dictCode":"shareFirm","dictName":"股份制企业"},{"dictValue":"3","dictCode":"collectiveFirm","dictName":"集体企业"},{"dictValue":"2","dictCode":"nationFirm","dictName":"国有企业"},{"dictValue":"1","dictCode":"domesticFirm","dictName":"私营企业"}],"wf_manage_scope":[{"dictValue":"6","dictCode":"safeProject","dictName":"安防工程"},{"dictValue":"5","dictCode":" landscapeProject","dictName":"景观工程"},{"dictValue":"4","dictCode":"buildProject","dictName":"建筑装饰工程"},{"dictValue":"3","dictCode":"labourSubcontract","dictName":"劳务分包"},{"dictValue":"2","dictCode":"labourSpecially","dictName":"劳务专业承包"},{"dictValue":"1","dictCode":"labourTurnkey","dictName":"劳务总承包"}]}
     */

    private BringBean bring;

    public BringBean getBring() {
        return bring;
    }

    public void setBring(BringBean bring) {
        this.bring = bring;
    }

    public static class BringBean {
        private List<DicChildrenBean> JSFS;
        private List<DicChildrenBean> wf_firm_industry;
        private List<DicChildrenBean> supply_way;
        private List<DicChildrenBean> wf_customer_source;
        private List<DicChildrenBean> wf_customer_type;
        private List<DicChildrenBean> car_type;
        private List<DicChildrenBean> wf_firm_type;
        private List<DicChildrenBean> wf_manage_scope;
        private List<DicChildrenBean> customer_grade;
        private List<DicChildrenBean> wf_customer_payment;


//        customer_grade	客户等级	N	普通会员、黄金会员…
//        wf_customer_payment	客户账期	N	一个月、两个月…


        public List<DicChildrenBean> getCustomer_grade() {
            return customer_grade;
        }

        public void setCustomer_grade(List<DicChildrenBean> customer_grade) {
            this.customer_grade = customer_grade;
        }

        public List<DicChildrenBean> getWf_customer_payment() {
            return wf_customer_payment;
        }

        public void setWf_customer_payment(List<DicChildrenBean> wf_customer_payment) {
            this.wf_customer_payment = wf_customer_payment;
        }

        public List<DicChildrenBean> getJSFS() {
            return JSFS;
        }

        public void setJSFS(List<DicChildrenBean> JSFS) {
            this.JSFS = JSFS;
        }

        public List<DicChildrenBean> getWf_firm_industry() {
            return wf_firm_industry;
        }

        public void setWf_firm_industry(List<DicChildrenBean> wf_firm_industry) {
            this.wf_firm_industry = wf_firm_industry;
        }

        public List<DicChildrenBean> getSupply_way() {
            return supply_way;
        }

        public void setSupply_way(List<DicChildrenBean> supply_way) {
            this.supply_way = supply_way;
        }

        public List<DicChildrenBean> getWf_customer_source() {
            return wf_customer_source;
        }

        public void setWf_customer_source(List<DicChildrenBean> wf_customer_source) {
            this.wf_customer_source = wf_customer_source;
        }

        public List<DicChildrenBean> getWf_customer_type() {
            return wf_customer_type;
        }

        public void setWf_customer_type(List<DicChildrenBean> wf_customer_type) {
            this.wf_customer_type = wf_customer_type;
        }

        public List<DicChildrenBean> getCar_type() {
            return car_type;
        }

        public void setCar_type(List<DicChildrenBean> car_type) {
            this.car_type = car_type;
        }

        public List<DicChildrenBean> getWf_firm_type() {
            return wf_firm_type;
        }

        public void setWf_firm_type(List<DicChildrenBean> wf_firm_type) {
            this.wf_firm_type = wf_firm_type;
        }

        public List<DicChildrenBean> getWf_manage_scope() {
            return wf_manage_scope;
        }

        public void setWf_manage_scope(List<DicChildrenBean> wf_manage_scope) {
            this.wf_manage_scope = wf_manage_scope;
        }
    }
}
