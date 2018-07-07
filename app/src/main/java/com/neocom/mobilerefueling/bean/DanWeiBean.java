package com.neocom.mobilerefueling.bean;


import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class DanWeiBean extends BaseBean {


    List<UnitBean> unitList;
    List<TypeListBean> typeList;

    public List<UnitBean> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<UnitBean> unitList) {
        this.unitList = unitList;
    }

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

}
