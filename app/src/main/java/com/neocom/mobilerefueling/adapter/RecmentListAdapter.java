package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.RecmentRespListBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/5.
 */

public class RecmentListAdapter extends BaseAdapter {


    //    List<RecmentRespListBean.BringBean> datas;
    List<RecmentRespListBean.BringBean.RecomListBean> datas;

    public RecmentListAdapter(List<RecmentRespListBean.BringBean.RecomListBean> datas) {
        this.datas = datas;
    }

    public void addMoreListData(List<RecmentRespListBean.BringBean.RecomListBean> addedTo) {
        if (addedTo != null) {
            datas.addAll(addedTo);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public RecmentRespListBean.BringBean.RecomListBean getItem(int position) {
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
            convertView = UIUtils.inflate(R.layout.recment_list_item_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RecmentRespListBean.BringBean.RecomListBean item = getItem(position);
        holder.regCname.setText(item.getCname()+"  "+item.getMobile());
        holder.regAddtime.setText(item.getAddTime());
//        holder.regCno.setText(item.getCno());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.reg_cname)
        TextView regCname;
//        @BindView(R.id.reg_cno)
//        TextView regCno;
        @BindView(R.id.reg_addtime)
        TextView regAddtime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
