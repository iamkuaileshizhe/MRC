package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.MsgBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/12/14.
 */

public class MsgAdapter extends BaseAdapter {

    List<MsgBean.BringBean> datas;
    private Context context;

    public MsgAdapter(List<MsgBean.BringBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public MsgAdapter(List<MsgBean.BringBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public MsgBean.BringBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.mag_item_layout);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();

        }
        MsgBean.BringBean item = getItem(position);
        holder.titleTv.setText(item.getSubject());

        holder.timeTv.setText(item.getAddTime());
        holder.moneyCount.setText(item.getContent());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.pay_type_logo)
        ImageView payTypeLogo;
        @BindView(R.id.pay_type_tv)
        TextView titleTv;
        @BindView(R.id.time_tv)
        TextView timeTv;
        @BindView(R.id.money_count)
        TextView moneyCount;
        @BindView(R.id.me_fg_menu_guid)
        ImageView meFgMenuGuid;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
