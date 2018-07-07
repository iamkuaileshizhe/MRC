package com.neocom.mobilerefueling.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/8/25.
 */

public class ShitAdapter extends BaseAdapter {

    List<ShiftResponseBean.BringBean> bringList;

    public ShitAdapter(List<ShiftResponseBean.BringBean> bringList) {
        this.bringList = bringList;
    }


    public void addMoreListData(List<ShiftResponseBean.BringBean> addedTo) {
        if (addedTo != null) {
            bringList.addAll(addedTo);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return bringList == null ? 0 : bringList.size();
    }

    @Override
    public ShiftResponseBean.BringBean getItem(int i) {
        return bringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.shitt_item_view);
            holder.shitTime = convertView.findViewById(R.id.shit_time);
            holder.shitUser = convertView.findViewById(R.id.shit_user);
            holder.shitState = convertView.findViewById(R.id.shit_state);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        ShiftResponseBean.BringBean item = getItem(position);
        holder.shitTime.setText(item.getShiftTime());
        holder.shitUser.setText(item.getCarryUser());
        holder.shitState.setText(GetOrderStateUtil.getShitWorkType(item.getConfirmStatus()));
        /**
         * 正常状态 都是蓝色
         * 拒绝 和 终止 的异常状态 是 黄色  12 13 11
         * 完成是 灰色  10
         */

        ShiftResponseBean.BringBean bean = getItem(position);
        String confirmStatus = bean.getConfirmStatus();

        Resources resources = UIUtils.getContext().getResources();

        if (TextUtils.isEmpty(confirmStatus)) {
//
            holder.shitState.setBackgroundDrawable(null);
//            普通蓝色
        } else {
//            已拒绝

            if (confirmStatus.equals("0")) {
                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
                holder.shitState.setBackgroundDrawable(drawable);
            } else if (confirmStatus.equals("1")) {
                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
                holder.shitState.setBackgroundDrawable(drawable);
            } else if (confirmStatus.equals("2")) {
                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
                holder.shitState.setBackgroundDrawable(drawable);
            } else {
                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
                holder.shitState.setBackgroundDrawable(drawable);
            }


        }


//        String status = bringBean.getDstate();
//        Resources resources = UIUtils.getContext().getResources();
//        if (TextUtils.isEmpty(status)) {
//
//            Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
//            holder.orderStateTv.setBackgroundDrawable(drawable);
////            普通蓝色
//        } else {
//
//            if (status.equals(Constant.JD_YIWANCHENG)){
//                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//            }else if (status.equals(Constant.JD_YIJUJUE)){
//
//                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
//            }else {
//                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
//            }
//
//        }


        return convertView;
    }

    static class ViewHolder {
        TextView shitTime;
        TextView shitUser;
        TextView shitState;
    }


}
