package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class JBRBringBean {


    private String templateId;
    private String label;
    private List<JBRConListBean> conList;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<JBRConListBean> getConList() {
        return conList;
    }

    public void setConList(List<JBRConListBean> conList) {
        this.conList = conList;
    }


}
