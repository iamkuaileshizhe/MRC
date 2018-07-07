package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.OrderResponseBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/10/24.
 */

public class OrderDetailAdapter extends BaseAdapter {

    private List<OrderResponseBean.BringBean.OilsInfoBean> oilsInfoBeen;

    public OrderDetailAdapter(List<OrderResponseBean.BringBean.OilsInfoBean> oilsInfoBeen) {
        this.oilsInfoBeen = oilsInfoBeen;
    }

    @Override
    public int getCount() {
        return oilsInfoBeen == null ? 0 : oilsInfoBeen.size();
    }

    @Override
    public OrderResponseBean.BringBean.OilsInfoBean getItem(int i) {
        return oilsInfoBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.order_detail_item_layout);
            viewHolder.selectOilType = convertView.findViewById(R.id.oil_type);
            viewHolder.oilPriceTv = convertView.findViewById(R.id.oil_price_tv);
            viewHolder.oilCountEt = convertView.findViewById(R.id.oil_count_et);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        OrderResponseBean.BringBean.OilsInfoBean item = getItem(position);

        viewHolder.selectOilType.setText(item.getOilType());
        viewHolder.oilPriceTv.setText(item.getOilPrice());
        viewHolder.oilCountEt.setText(item.getPayAmount());

        return convertView;
    }


    class ViewHolder {
        TextView selectOilType;
        TextView oilPriceTv;
        EditText oilCountEt;
    }


}
