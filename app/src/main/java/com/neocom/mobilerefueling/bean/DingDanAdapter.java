package com.neocom.mobilerefueling.bean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/9/13.
 */

public class DingDanAdapter extends BaseAdapter {


    List<ResponseDingDanOrderBean.BringBean> datas;

    public DingDanAdapter(List<ResponseDingDanOrderBean.BringBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public ResponseDingDanOrderBean.BringBean getItem(int i) {
        return datas.get(i);
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
            convertView = UIUtils.inflate(R.layout.order_view_item);

            holder.orderTimeTv = convertView.findViewById(R.id.order_time_tv);
            holder.orderOrderTv = convertView.findViewById(R.id.order_no_tv);
            holder.orderAddressTv = convertView.findViewById(R.id.order_address_tv);
            holder.orderPhoneTv = convertView.findViewById(R.id.order_phone_tv);
            holder.orderStateTv = convertView.findViewById(R.id.order_state_tv);
            holder.orderArrow = convertView.findViewById(R.id.order_arrow);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ResponseDingDanOrderBean.BringBean orderBean = (ResponseDingDanOrderBean.BringBean) getItem(position);
        if (orderBean != null) {
            String orderState = orderBean.getStatus().toString().trim();
            holder.orderTimeTv.setText(orderBean.getIndentTime().toString().trim());
            holder.orderAddressTv.setText(orderBean.getIndentAddress().trim().toString());
            holder.orderOrderTv.setText("订单编号:" + orderBean.getIndentCode().toString().trim());
            holder.orderStateTv.setText(orderBean.getOrderStatus());
            holder.orderPhoneTv.setText(orderBean.getPhone().toString().trim());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView orderOrderTv;
        TextView orderTimeTv;
        TextView orderPhoneTv;
        TextView orderStateTv;
        TextView orderAddressTv;
        ImageView orderArrow;
    }
}
