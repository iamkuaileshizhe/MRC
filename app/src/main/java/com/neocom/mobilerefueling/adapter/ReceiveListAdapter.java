package com.neocom.mobilerefueling.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ReceiverOrderBeanBring;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

/**
 * Created by admin on 2017/8/25.
 */

public class ReceiveListAdapter extends BaseAdapter {

    List<ReceiverOrderBeanBring.BringBean> bringList;

    public ReceiveListAdapter(List<ReceiverOrderBeanBring.BringBean> bringList) {
        this.bringList = bringList;
    }

    public void addMoreListData(List<ReceiverOrderBeanBring.BringBean> addedTo) {
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
    public ReceiverOrderBeanBring.BringBean getItem(int i) {
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
            convertView = UIUtils.inflate(R.layout.receive_list_item_layout);
//            holder.deliveryCode = convertView.findViewById(R.id.receive_delivercode);
            holder.orderNoTv = convertView.findViewById(R.id.order_no_tv);
            holder.orderStateTv = convertView.findViewById(R.id.order_state_tv);
            holder.estimateTime = convertView.findViewById(R.id.receive_estamate_time);
            holder.oilAmount = convertView.findViewById(R.id.receive_oil_count);
            holder.deliveryAddress = convertView.findViewById(R.id.receive_address);
            holder.carListAddress = convertView.findViewById(R.id.receive_carlist_count);
//            holder.stateOrder = convertView.findViewById(R.id.receive_carlist_state);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        ReceiverOrderBeanBring.BringBean bringBean = bringList.get(position);

//        holder.deliveryCode.setTitle();
//        holder.deliveryCode.setContet(bringBean.getDeliveryCode());
//        holder.orderNoTv.setText("派送单编号:" + bringBean.getDeliveryCode());

//        holder.estimateTime.setTitle("预约时间");
//        holder.estimateTime.setContet(bringBean.getEstimateTime());
//
//        holder.oilAmount.setTitle("加油量");
//        holder.oilAmount.setContet(bringBean.getOilAmount());
//
//        holder.deliveryAddress.setTitle("派送地址");
//        holder.deliveryAddress.setContet(bringBean.getDeliveryAddress());
//
//        holder.carList.setTitle("目标车辆数");
//        holder.carList.setContet(String.valueOf(bringBean.getCarList().size()));

        holder.orderNoTv.setText(bringBean.getDeliveryCode());
        holder.estimateTime.setTitle("下单人");
        holder.estimateTime.setContet(bringBean.getReceiverName());

        holder.oilAmount.setTitle("预约时间");
        String estimateTime = bringBean.getEstimateTime();
        if (TextUtils.isEmpty(estimateTime)) {
            holder.oilAmount.setContet("尽快派送");
        } else {
            holder.oilAmount.setContet(bringBean.getEstimateTime());
        }

        holder.deliveryAddress.setTitle("商品信息");
        holder.deliveryAddress.setContet(bringBean.getNationalStandardName() + bringBean.getOilTypeName());

        holder.carListAddress.setTitle("派送地址:");
        holder.carListAddress.setContet(bringBean.getDeliveryAddress());


//        holder.stateOrder.setTitle("订单状态");

//        Log.i("订单状态", "getView: ==》"+bringBean.getDstate());
//        holder.stateOrder.setContet(getOrderStateUtil.getPaiSongDanState(bringBean.getDstate()));


//        Resources resources = UIUtils.getContext().getResources();
//
//        String status = bringBean.getDstate();
//
//
//        Drawable drawable = resources.getDrawable(R.drawable.order_state_shape);
//        holder.orderStateTv.setBackgroundDrawable(drawable);


        /**
         * 正常状态 都是蓝色
         * 拒绝 和 终止 的异常状态 是 黄色  12 13 11
         * 完成是 灰色  10
         */
        String status = bringBean.getDstate();
        Resources resources = UIUtils.getContext().getResources();
        if (TextUtils.isEmpty(status)) {

            Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
            holder.orderStateTv.setBackgroundDrawable(drawable);
//            普通蓝色
        } else {

            if (status.equals(Constant.JD_YIWANCHENG)) {
                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);
            } else if (status.equals(Constant.JD_YIJUJUE)) {

                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);

            } else {
                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);
            }

        }
//
//        holder.orderStateTv.setBackgroundResource(R.drawable.order_state_shape);

        holder.orderStateTv.setText(GetOrderStateUtil.getPaiSongDanState(bringBean.getDstate()));

//        order_state_color

//
//        if (TextUtils.isEmpty(status)) {
//
//            Drawable drawable=resources.getDrawable(R.drawable.order_state_shape);
//            holder.orderStateTv.setBackgroundDrawable(drawable);
//
////            holder.orderStateTv.setBackgroundResource(R.drawable.order_state_shape);
//        } else {
//
//            holder.orderStateTv.setText(GetOrderStateUtil.getPaiSongDanState(status));
//
//            if (status.equals(Constant.JD_DAIJIEDAN)) {
//
////                UIUtils.getContext()
//
//                Drawable drawable=resources.getDrawable(R.drawable.order_state_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
//                holder.orderStateTv.setBackgroundResource(R.drawable.order_state_shape);
////                Constant.ORDER_STATE_PAIDANZHONG+","+Constant.ORDER_STATE_PAISONGZHONG
//            } else if (status.equals(Constant.ORDER_STATE_PAIDANZHONG) || status.equals(Constant.ORDER_STATE_PAISONGZHONG)) {
//
//                Drawable drawable=resources.getDrawable(R.drawable.order_state_paisongzhong_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
////                holder.orderStateTv.setBackgroundResource(R.drawable.order_state_paisongzhong_shape);
//            } else if (status.equals(Constant.ORDER_STATE_DAIQUEREN)) {
//
//                Drawable drawable=resources.getDrawable(R.drawable.order_state_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
////                holder.orderStateTv.setBackgroundResource(R.drawable.order_state_shape);
//            } else if (status.equals(Constant.ORDER_STATE_DAIPINGJIA) || status.equals(Constant.ORDER_STATE_YIJIESHU)) {
//
//                Drawable drawable=resources.getDrawable(R.drawable.order_state_success_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
////                holder.orderStateTv.setBackgroundResource(R.drawable.order_state_success_shape);
////                Constant.ORDER_STATE_DAIPINGJIA + "," + Constant.ORDER_STATE_YIJIESHU
//            } else {
//
//                Drawable drawable=resources.getDrawable(R.drawable.order_state_shape);
//                holder.orderStateTv.setBackgroundDrawable(drawable);
//
//
////                holder.orderStateTv.setBackgroundResource(R.drawable.order_state_shape);
//            }
//
//        }
//
//
//
//
//


        return convertView;
    }

    static class ViewHolder {

//        OrderConbindView deliveryCode;

        TextView orderNoTv;
        TextView orderStateTv;

        OrderConbindView estimateTime;
        OrderConbindView oilAmount;
        OrderConbindView deliveryAddress;
        OrderConbindView carListAddress;
//        OrderConbindView stateOrder;

    }


}
