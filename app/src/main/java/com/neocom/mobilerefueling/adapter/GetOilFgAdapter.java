package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ResponseGetOilPageBean;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/9/6.
 */

public class GetOilFgAdapter extends BaseAdapter {

    List<ResponseGetOilPageBean.BringBean> bring;

    public GetOilFgAdapter(List<ResponseGetOilPageBean.BringBean> bring) {
        this.bring = bring;
    }

    public void addMoreListData(List<ResponseGetOilPageBean.BringBean> addedTo) {
        if (addedTo != null) {
            bring.addAll(addedTo);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return bring == null ? 0 : bring.size();
    }

    @Override
    public ResponseGetOilPageBean.BringBean getItem(int i) {
        return bring.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = UIUtils.inflate(R.layout.get_oil_list_fg_item);
            holder = new ViewHolder(view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

        ResponseGetOilPageBean.BringBean bringBean = bring.get(i);

        holder.tyId.setText(bringBean.getPurchaseCode());

        holder.getOilTimeOc.setTitle("提油时间");
        holder.getOilTimeOc.setContet(bringBean.getPurchaseTime());

        holder.getOilCountOc.setTitle("提油量");
        holder.getOilCountOc.setContet(bringBean.getPurchaseNum());

        holder.getOilCarNoOc.setTitle("运油车牌号");
        holder.getOilCarNoOc.setContet(bringBean.getCarCode());

        holder.getOilCarDriverOc.setTitle("运油司机");
        holder.getOilCarDriverOc.setContet(bringBean.getDriver());

        holder.getOilCarDriverPhoneOc.setTitle("联系电话");
        holder.getOilCarDriverPhoneOc.setContet(bringBean.getTelphone());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.ty_id)
        TextView tyId;
        @BindView(R.id.get_oil_time_oc)
        OrderConbindView getOilTimeOc;
        @BindView(R.id.get_oil_count_oc)
        OrderConbindView getOilCountOc;
        @BindView(R.id.get_oil_car_no_oc)
        OrderConbindView getOilCarNoOc;
        @BindView(R.id.get_oil_car_driver_oc)
        OrderConbindView getOilCarDriverOc;
        @BindView(R.id.get_oil_car_driver_phone_oc)
        OrderConbindView getOilCarDriverPhoneOc;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
