package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ResponseDingDanDetailBean;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;


/**
 * Created by admin on 2017/9/14.
 */

public class ResponseDingDanDetailAdapter extends BaseAdapter {

    List<ResponseDingDanDetailBean.BringBean.CarsInfoBean> carsInfo;

    public ResponseDingDanDetailAdapter(List<ResponseDingDanDetailBean.BringBean.CarsInfoBean> carsInfo) {
        this.carsInfo = carsInfo;
    }

    @Override
    public int getCount() {
        return carsInfo == null ? 0 : carsInfo.size();
    }

    @Override
    public ResponseDingDanDetailBean.BringBean.CarsInfoBean getItem(int i) {
        return carsInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = UIUtils.inflate(R.layout.ordinary);

            holder.vehicleCode = view.findViewById(R.id.vehicleCode);
            holder.oilType = view.findViewById(R.id.oilType);
            holder.tankSize = view.findViewById(R.id.tankSize);
            holder.pName = view.findViewById(R.id.pName);
            holder.dstate = view.findViewById(R.id.dstate);
            holder.telphone = view.findViewById(R.id.telphone);

            view.setTag(holder);
        } else {

            holder = (ViewHolder) view.getTag();

        }

        ResponseDingDanDetailBean.BringBean.CarsInfoBean carsInfoBean = getItem(i);
        holder.vehicleCode.setTitle("车牌号");
        holder.vehicleCode.setContet(carsInfoBean.getVehicleCode());
        holder.oilType.setTitle("燃油类型");
        holder.oilType.setContet(carsInfoBean.getOilType());
        holder.tankSize.setTitle("燃油数量");
        holder.tankSize.setContet(carsInfoBean.getTankSize());

        holder.pName.setTitle("联系人");
        holder.pName.setContet(carsInfoBean.getPName());

        holder.dstate.setTitle("车辆状态");
        holder.dstate.setContet(carsInfoBean.getDstate());

        holder.telphone.setTitle("联系电话");
        holder.telphone.setContet(carsInfoBean.getTelphone());
        return view;
    }


    class ViewHolder {
        //        @BindView(R.id.vehicleCode)
        OrderConbindView vehicleCode;
        //        @BindView(R.id.oilType)
        OrderConbindView oilType;
        //        @BindView(R.id.tankSize)
        OrderConbindView tankSize;
        //        @BindView(R.id.pName)
        OrderConbindView pName;
        //        @BindView(R.id.dstate)
        OrderConbindView dstate;
        //        @BindView(R.id.telphone)
        OrderConbindView telphone;

//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
    }
}
