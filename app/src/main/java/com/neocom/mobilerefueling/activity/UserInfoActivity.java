package com.neocom.mobilerefueling.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;

/**
 * Created by admin on 2017/11/21.
 * 用户信息 从 SP中获取
 */

public class UserInfoActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.user_name)
    OrderConbindView userName;
    @BindView(R.id.dept_id)
    OrderConbindView deptId;
    @BindView(R.id.user_info_mobile)
    OrderConbindView userInfoMobile;
    @BindView(R.id.car_num)
    OrderConbindView carNum;
//    @BindView(R.id.car_type)
//    OrderConbindView carType;
//    @BindView(R.id.fuel_type)
//    OrderConbindView fuelType;
//    @BindView(R.id.driver_one)
//    OrderConbindView driverOne;
//    @BindView(R.id.driver_two)
//    OrderConbindView driverTwo;

    @Override
    public void initContentView() {
        setContentView(R.layout.user_info_layout);
    }

    @Override
    public void initView() {

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initTitle();

    }

    private void initTitle() {
        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();

        userName.setTitle("用户名");
        userName.setContet(userInfo.getUserName());
        deptId.setTitle("部门名称");
        deptId.setContet(userInfo.getDeptName());
        userInfoMobile.setTitle("手机号");
        userInfoMobile.setContet(userInfo.getUserInfoMobile());
        carNum.setTitle("车牌号");


//        String carNo = SPUtils.getContent(Constant.CAR_NUM);
        String carNo = SPUtils.getSaveCar();

        carNum.setContet(carNo);

//        if (TextUtils.isEmpty(carNo)) {
//            carNum.setContet("");
//        } else {
//            carNum.setContet(carNo);
//
//        }

//        carType.setTitle("车辆类型");
//        carType.setContet(GetOrderStateUtil.getCarType(userInfo.getCarType()));
//        fuelType.setTitle("燃油类型");
//        fuelType.setContet(GetOrderStateUtil.getFuelType(userInfo.getFuelType()));
//        driverOne.setTitle("第一驾驶员工号");
//        driverOne.setContet(userInfo.getDriverOne());
//        driverTwo.setTitle("第二驾驶员工号");
//        driverTwo.setContet(userInfo.getDriverTwo());
    }

    @Override
    public void initData() {

    }

}
