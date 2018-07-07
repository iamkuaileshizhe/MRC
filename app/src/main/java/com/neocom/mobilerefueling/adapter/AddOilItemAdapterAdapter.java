package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.SubmitOrderOilsBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/10/17.
 */

public class AddOilItemAdapterAdapter extends BaseAdapter {
    List<SubmitOrderOilsBean> orderItemOils;

    public AddOilItemAdapterAdapter(List<SubmitOrderOilsBean> orderItemOils) {
        this.orderItemOils = orderItemOils;
    }

    @Override
    public int getCount() {
        return orderItemOils == null ? 0 : orderItemOils.size();
    }

    @Override
    public SubmitOrderOilsBean getItem(int i) {
        return orderItemOils.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView = UIUtils.inflate(R.layout.pop_menuitem);
            holder.itemOil=convertView.findViewById(R.id.menuitem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SubmitOrderOilsBean item = getItem(position);
        if (item!=null){
            holder.itemOil.setText(GetOrderStateUtil.getOilType(item.getOilType()));
        }

        return convertView;
    }

    class ViewHolder{

        TextView itemOil;

    }

}
