package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.DailyBalanceReqBean;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/6/1.
 */

public class DailyBalanceListAdapter extends RecyclerView.Adapter<DailyBalanceListAdapter.DailyBalanceViewHolder> {


    private Context context;
    private List<DailyBalanceRespBean.BringBean> datas;

    public DailyBalanceListAdapter(Context context, List<DailyBalanceRespBean.BringBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public DailyBalanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.daily_balance_item_layout, null, false);
        return new DailyBalanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyBalanceViewHolder holder, final int position) {

        final DailyBalanceRespBean.BringBean bringBean = datas.get(position);

        holder.dailyCode.setText(bringBean.getDailyCode());
        holder.dailyCarCode.setTitle("车牌号");
        holder.dailyCarCode.setContet(bringBean.getCarNumber());
        holder.dailyStartTime.setTitle("结算开始时间");
        holder.dailyStartTime.setContet(bringBean.getSettlemenStart());
        holder.dailyEndTime.setTitle("结算结束时间");
        holder.dailyEndTime.setContet(bringBean.getSettlemenEnd());

        holder.orderStateTv.setText(GetOrderStateUtil.getDailyBlanceState(bringBean.getPayStatus()));


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
        return datas == null ? 0 : datas.size();
    }

    public class DailyBalanceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.daily_code)
        TextView dailyCode;
        @BindView(R.id.order_state_tv)
        TextView orderStateTv;
        @BindView(R.id.daily_car_code)
        OrderConbindView dailyCarCode;
        @BindView(R.id.daily_start_time)
        OrderConbindView dailyStartTime;
        @BindView(R.id.daily_end_time)
        OrderConbindView dailyEndTime;

        @BindView(R.id.root_ll)
        LinearLayout rootLl;

        public DailyBalanceViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }


    OnItemRecyclerViewClick itemRecyclerViewClick;

    public void setOnItemRecyclerViewClickListener(OnItemRecyclerViewClick itemRecyclerViewClick) {
        this.itemRecyclerViewClick = itemRecyclerViewClick;
    }

    public interface OnItemRecyclerViewClick {
        void OnItemClick(DailyBalanceRespBean.BringBean bringBean, int position);

    }

}
