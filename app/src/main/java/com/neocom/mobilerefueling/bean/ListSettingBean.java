package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ListSettingBean implements Serializable {

//  "item_ quality": "0",   // 按钮key:按钮value
//          "item_ density": "1"

    private String item_quality;
    private String item_density;

    public String getItem_quality() {
        return item_quality;
    }

    public void setItem_quality(String item_quality) {
        this.item_quality = item_quality;
    }

    public String getItem_density() {
        return item_density;
    }

    public void setItem_density(String item_density) {
        this.item_density = item_density;
    }
}
