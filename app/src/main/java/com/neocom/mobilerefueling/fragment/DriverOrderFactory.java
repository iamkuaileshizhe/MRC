package com.neocom.mobilerefueling.fragment;

import java.util.HashMap;

/**
 * Created by admin on 2017/9/8.
 */

public class DriverOrderFactory {

    public static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();


    public static BaseFragment createFragment(int position) {
//    先从 集合中获取，如果没有在去 创建对象 以提高性能
        BaseFragment fragment = mFragmentMap.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:// 运油车 全部订单
                    fragment = new ReceiveListFragment();
                    break;
                case 1: // 运油车 待接单
                    fragment = new DriverOrderWaitFragment();
                    break;
                case 2: // 已接单
                    fragment = new DriverOrderReceiveFragment();
                    break;
                case 3:// 完成
                    fragment = new DriverOrderFnishFragment();
                    break;
                case 4:// 已拒绝
                    fragment = new DriverOrderRefuseFragment();
                    break;
            }
        }
        return fragment;
    }
}
