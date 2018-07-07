package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.DailyBalanceBean;
import com.neocom.mobilerefueling.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/29.
 */

public class DailyBalanceDropAdapter extends BaseAdapter {

    private Context context;
    private List<DailyBalanceBean> list;
    private int checkItemPosition = 0;

    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }

    public DailyBalanceDropAdapter(Context context, List<DailyBalanceBean> list) {
        this.context = context;
        this.list = list;

        LogUtils.i("list==>"+list.size());

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DailyBalanceBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListDropDownAdapter.ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ListDropDownAdapter.ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_default_drop_down, null);
            viewHolder = new ListDropDownAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;
    }

    private void fillValue(int position, ListDropDownAdapter.ViewHolder viewHolder) {
        viewHolder.mText.setText(list.get(position).getValue());
        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_selected));
                viewHolder.mText.setBackgroundResource(R.color.gray_white);
            } else {
                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.drop_down_unselected));
                viewHolder.mText.setBackgroundResource(R.color.white);
            }
        }
    }

    static class ViewHolder {
        @BindView(R.id.text)
        TextView mText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

//    static class ViewHolder {
//        @InjectView(R.id.text)
//        TextView mText;
//
//        ViewHolder(View view) {
//            ButterKnife.inject(this, view);
//        }
//    }
}
