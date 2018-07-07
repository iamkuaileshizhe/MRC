package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.text.TextUtils;

import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.globle.Constant;

/**
 * Created by Administrator on 2018/1/31.
 *
 * 潜在客户 审核成功
 */

public class QZKHSHCGFragment extends QZKHFragment {

    @Override
    protected Intent jumpToActivity() {

//        QZKHRespBean.BringBean item = receiveListAdapter.getItem(clickPosition - 1);
//        String itemId = item.getId();
////        String paiDanState = item.getDstate();
////        String indentId = item.getIndentId();
//        Log.i(TAG, "onItemClick: " + itemId);
//
//        Intent intent = new Intent(UIUtils.getContext(), PaiSongDanJDDialogUI.class);
//        intent.putExtra("itemId", itemId);

//        Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();

//        return null;

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
        return Constant.QZKH_SHENHECHENGGONG;
    }
}
