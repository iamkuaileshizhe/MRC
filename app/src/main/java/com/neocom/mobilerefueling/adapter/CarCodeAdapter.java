package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.CarCodeRespBean;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/6/2.
 */

public class CarCodeAdapter extends RecyclerView.Adapter<CarCodeAdapter.CarCodeViewHolder> {


    private Context context;
    private List<CarCodeRespBean.BringBean> beanList;

    public CarCodeAdapter(Context context, List<CarCodeRespBean.BringBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public CarCodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.car_code_item_layout, null, false);

        return new CarCodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarCodeViewHolder holder, final int position) {
        final CarCodeRespBean.BringBean bringBean = beanList.get(position);
        holder.carDriverName.setTitle("司机姓名");
        holder.carDriverName.setContet(bringBean.getDriveName());
        holder.carDriverTel.setTitle("司机联系方式");
        holder.carDriverTel.setContet(bringBean.getDriveTel());
        holder.carSafeName.setTitle("押运员姓名");
        holder.carSafeName.setContet(bringBean.getSafeName());
        holder.carSafeTel.setTitle("押运员联系方式");
        holder.carSafeTel.setContet(bringBean.getSafeTel());
        holder.carCode.setTitle("车牌号");
        holder.carCode.setContet(bringBean.getCarNum());
        holder.rootLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemRecyclerViewClick != null) {

                    itemRecyclerViewClick.OnItemClick(bringBean, position);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return beanList == null ? 0 : beanList.size();
    }

    public class CarCodeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.car_driver_name)
        OrderConbindView carDriverName;
        @BindView(R.id.car_driver_tel)
        OrderConbindView carDriverTel;
        @BindView(R.id.car_safe_name)
        OrderConbindView carSafeName;
        @BindView(R.id.car_safe_tel)
        OrderConbindView carSafeTel;
        @BindView(R.id.car_code)
        OrderConbindView carCode;
        @BindView(R.id.root_ll)
        LinearLayout rootLl;

        public CarCodeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnItemRecyclerViewClick itemRecyclerViewClick;

    public void setOnItemRecyclerViewClickListener(OnItemRecyclerViewClick itemRecyclerViewClick) {
        this.itemRecyclerViewClick = itemRecyclerViewClick;
    }

    public interface OnItemRecyclerViewClick {
        void OnItemClick(CarCodeRespBean.BringBean bringBean, int position);

    }

}
