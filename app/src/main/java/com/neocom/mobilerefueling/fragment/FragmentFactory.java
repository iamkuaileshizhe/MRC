package com.neocom.mobilerefueling.fragment;

import java.util.HashMap;

/**
 * Created by admin on 2017/7/17.
 * 生产 潜在客户 fragment的工厂
 */

public class FragmentFactory {

    public static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();

    public static BaseFragment createFragment(int position) {
//    先从 集合中获取，如果没有在去 创建对象 以提高性能
        BaseFragment fragment = mFragmentMap.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:// 所有潜在客户列表
                    fragment = new QianZaiKeHuAllFragment();
                    break;
                case 1: // 未提交
                    fragment = new QZKHWTJFragment();
                    break;
                case 2: // 待审核
                    fragment = new QZKHDSHFragment();
                    break;
                case 3:// 审核未通过
                    fragment = new QZKHSHSBFragment();
                    break;
                case 4:// 审核通过
                    fragment = new QZKHSHCGFragment();
                    break;

            }


        }


        return fragment;
    }


}
