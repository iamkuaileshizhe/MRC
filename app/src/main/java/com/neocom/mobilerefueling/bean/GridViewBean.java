package com.neocom.mobilerefueling.bean;

import com.neocom.mobilerefueling.R;

/**
 * Created by admin on 2017/7/17.
 * <p>
 * gridViwe 的 item Bean
 */

public class GridViewBean {
    private int iId; // 首页的 菜单  ID
    private String iName;//  首页菜单的名字
    private String price; //首页菜单 顺序
    private String num; //首页菜单的 图标
    private String upDown;

    public GridViewBean() {
    }

    public GridViewBean(String iName) {
//        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
//        因为 图标固定了 所以 返回值 先这么固定，加入修改了在改回来
        return R.mipmap.lv_icon;
//        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUpDown() {
        return upDown;
    }

    public void setUpDown(String upDown) {
        this.upDown = upDown;
    }

    @Override
    public String toString() {
        return "GridViewBean{" +
                "iId=" + iId +
                ", iName='" + iName + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", upDown='" + upDown + '\'' +
                '}';
    }
}
