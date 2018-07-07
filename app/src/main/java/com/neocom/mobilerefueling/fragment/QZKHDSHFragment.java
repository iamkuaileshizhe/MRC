package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.globle.Constant;

/**
 * Created by Administrator on 2018/1/31.
 * <p>
 * 潜在客户 待审核
 */

public class QZKHDSHFragment extends QZKHFragment {

    @Override
    protected Intent jumpToActivity() {

//        Toast.makeText(getActivity(), "点击" + clickPosition, Toast.LENGTH_SHORT).show();
//        KHDetailBringBean item = receiveListAdapter.getItem(clickPosition - 1);
//        String idItem = item.getId();
//        String checkStatus = item.getCheckStatus();
//
//
//        Intent intent = new Intent(getActivity(), AddQianZaiKeHuActivity.class);
//        intent.putExtra("idItem", idItem);
//        intent.putExtra("checkStatus", checkStatus);


        KHDetailBringBean item = receiveListAdapter.getItem(clickPosition - 1);
        String idShenHeItem = item.getId(); // 提交时 用 此 ID
        String idItem = item.getCustomerId(); // 查询 详情 用 此 ID

        String checkStatus = item.getCheckStatus();

        Intent intent = new Intent(getActivity(), AddQianZaiKeHuActivity.class);
        if (TextUtils.isEmpty(idItem)) {
            intent.putExtra("idItem", idShenHeItem);
        } else {
            intent.putExtra("idItem", idItem);
        }
        intent.putExtra("shenHeId", idShenHeItem);
        intent.putExtra("checkStatus", checkStatus);

        return intent;
    }

    @Override
    protected String getCheckStatus() {
        return Constant.QZKH_DAISHENHE;
    }
}
