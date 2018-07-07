package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.SupplyListBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/1.
 */

public class SupplyListAdapter extends BaseAdapter {

    List<SupplyListBean.BringBean> bring;

    public SupplyListAdapter(List<SupplyListBean.BringBean> bring) {
        this.bring = bring;
    }

    @Override
    public int getCount() {
        return bring == null ? 0 : bring.size();
    }

    @Override
    public SupplyListBean.BringBean getItem(int position) {
        return bring.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.supply_list_item_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SupplyListBean.BringBean item = getItem(position);
        holder.supplyName.setRightString(item.getName());
        holder.supplyAddress.setRightString(item.getAddress());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.supply_name)
        SuperTextView supplyName;
        @BindView(R.id.supply_address)
        SuperTextView supplyAddress;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
