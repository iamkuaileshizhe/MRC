package com.neocom.mobilerefueling.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.CheLiangRespBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/10.
 */

public class CarListAdapter extends BaseAdapter {

    List<CheLiangRespBean.BringBean> datas;

    Context context;

    public CarListAdapter(List<CheLiangRespBean.BringBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public CheLiangRespBean.BringBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.carliat_item);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.carInfo.setRightString(datas.get(position).getCarNum());

        holder.carInfo.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {

                Intent intent = ((Activity) context).getIntent();

                intent.putExtra("carNum", getItem(position).getCarNum());
                intent.putExtra("carId", getItem(position).getId());

                ((Activity) context).setResult(104, intent);
                ((Activity) context).finish();


            }
        });

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.car_info)
        SuperTextView carInfo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
