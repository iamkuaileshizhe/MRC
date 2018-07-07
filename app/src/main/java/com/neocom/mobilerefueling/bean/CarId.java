package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/24.
 */

public class CarId implements Serializable {

    public String indentId;

    public String getIndentId() {
        return indentId;
    }

    public void setIndentId(String indentId) {
        this.indentId = indentId;
    }

    @Override
    public String toString() {
        return "CarId{" +
                "indentId='" + indentId + '\'' +
                '}';
    }
}
