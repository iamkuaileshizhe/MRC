package com.neocom.mobilerefueling.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.activity.AddQianZaiKeHuActivity;
import com.neocom.mobilerefueling.bean.KHBringBean;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.UIUtils;

/**
 * Created by Administrator on 2018/1/31.
 * <p>
 * 潜在客户 未提交
 */

public class QZKHWTJFragment extends QZKHFragment {

    @Override
    protected Intent jumpToActivity() {

//        Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
//        KHDetailBringBean item = receiveListAdapter.getItem(clickPosition - 1);
//
//        Gson gson = new Gson();
//        String itemContent = gson.toJson(item);
//        Intent intent = new Intent(UIUtils.getContext(), AddQianZaiKeHuActivity.class);
//        intent.putExtra("itemContent", itemContent);
//        return intent;


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
        return Constant.QZKH_WEITIJIAO;
    }
}
