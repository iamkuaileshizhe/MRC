package com.neocom.mobilerefueling.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/7.
 */

public class ChooseCarBeanBring extends BaseBean {

    private BringBean bring;


    public BringBean getBring() {
        return bring;
    }

    public void setBring(BringBean bring) {
        this.bring = bring;
    }

    public static class BringBean {
        private List<ChooseCarBean> carList;

        public List<ChooseCarBean> getCarList() {
            return carList;
        }

        public void setCarList(List<ChooseCarBean> carList) {
            this.carList = carList;
        }

    }
}
