package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class JBRConListBean {


    private String labelOrder;
    private String labelName;
    private List<LabelDataBean> labelData;

    public String getLabelOrder() {
        return labelOrder;
    }

    public void setLabelOrder(String labelOrder) {
        this.labelOrder = labelOrder;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public List<LabelDataBean> getLabelData() {
        return labelData;
    }

    public void setLabelData(List<LabelDataBean> labelData) {
        this.labelData = labelData;
    }


}
