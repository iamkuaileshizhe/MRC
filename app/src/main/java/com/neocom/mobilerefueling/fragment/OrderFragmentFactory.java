package com.neocom.mobilerefueling.fragment;

import java.util.HashMap;

/**
 * Created by admin on 2017/8/9.
 * <p>
 * <item>审核中</item>
 * <item>配送中</item>
 * <item>待付款</item>
 * <item>已完成</item>
 * <item>全部</item>
 */

public class OrderFragmentFactory {

    public static HashMap<Integer, BaseFragment> mOrderFragmentMap = new HashMap<>();

    public static BaseFragment createOrderFragment(int position) {
//    先从 集合中获取，如果没有在去 创建对象 以提高性能
        BaseFragment fragment = mOrderFragmentMap.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:// 未提交
                    fragment = new WaitToCommitFragment();
                    break;

                case 1:// 审核中
                    fragment = new CheckOrderFragment();
                    break;
                case 2: // 配送中
                    fragment = new DeliveryOrderFragment();
                    break;
                case 3:// 已完成
                    fragment = new FinishOrderFragment();
                    break;

                case 4: // 已评价

                    fragment = new AlreadyPingJiaFragment();
                    break;
                case 5: // 已撤销

                    fragment = new AlreadyCheXiaoFragment();
                    break;


                case 6: // 审核 未通过
                    fragment = new PaymentOrderFragment();
                    break;

                case 7:// 全部
//                    fragment = new AllOrderFragment(); // 管理员 调用此页面
//                    fragment = new AllCurrentOrderFragment(); // 当前普通登录用户 调用此页面

                    fragment = new AlreadyAllFragment();
                    break;

            }


        }


        return fragment;
    }


}
