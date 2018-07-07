package com.neocom.mobilerefueling.fragment;

import java.util.HashMap;

/**
 * Created by admin on 2017/9/8.
 */

public class YunYouCheFactory {

    public static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();


    public static BaseFragment createFragment(int position) {
//    先从 集合中获取，如果没有在去 创建对象 以提高性能
        BaseFragment fragment = mFragmentMap.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:// 运油车全部
                    fragment = new YunAllListFragment();
                    break;
                case 1: // 运油车未确认
                    fragment = new YunWeiQueRenListFragment();
                    break;
                case 2: // 运油车确认未通过
                    fragment = new YunWeiTongGuoListFragment();
                    break;
                case 3:// 运油车确认已通过
                    fragment = new YunYiTongGuoListFragment();
                    break;
            }
        }
        return fragment;
    }
}
