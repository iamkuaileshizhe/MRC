package com.neocom.mobilerefueling.fragment;

import java.util.HashMap;

/**
 * Created by admin on 2017/10/26.
 */

public class ChangeWorkFactory {

    public static HashMap<Integer, BaseFragment> mFragmentMap = new HashMap<>();


    public static BaseFragment createFragment(int position) {
//    先从 集合中获取，如果没有在去 创建对象 以提高性能
        BaseFragment fragment = mFragmentMap.get(position);

        if (fragment == null) {
            switch (position) {
                case 0:// 待接班
                    fragment = new UnChangeWorkFrament();
                    break;
                case 1: // 已接班
                    fragment = new ChangedWorkFrament();
                    break;
                case 2: // 交办
                    fragment = new ToChangeWorkFragment();
                    break;
            }
        }
        return fragment;
    }




}
