package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.bean.JieSuanRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018/6/1.
 */

public class JieSuanDailyBalanceListAdapter extends RecyclerView.Adapter<JieSuanDailyBalanceListAdapter.DailyBalanceViewHolder> {

    private Context context;
    private List<JieSuanRespBean.BringBean> datas;

    public JieSuanDailyBalanceListAdapter(Context context, List<JieSuanRespBean.BringBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public DailyBalanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.jiesuan_item_layout, null, false);
        return new DailyBalanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyBalanceViewHolder holder, final int position) {

        final JieSuanRespBean.BringBean bringBean = datas.get(position);

//        holder.dailyCode.setText(bringBean.getDailyCode());
//        holder.dailyCarCode.setTitle("车牌号");
//        holder.dailyCarCode.setContet(bringBean.getCarNumber());
//        holder.dailyStartTime.setTitle("结算开始时间");
//        holder.dailyStartTime.setContet(bringBean.getSettlemenStart());
//        holder.dailyEndTime.setTitle("结算结束时间");
//        holder.dailyEndTime.setContet(bringBean.getSettlemenEnd());
//

        holder.yuyueTime.setTitle("预约时间");
        holder.yuyueTime.setContet(bringBean.getEstimateTime());
        holder.shangpinInfo.setTitle("商品信息");
        holder.shangpinInfo.setContet(bringBean.getNationalStandard() + bringBean.getOilTypeName());

        holder.paisongAddr.setTitle("派送地址");
        holder.paisongAddr.setContet(bringBean.getDeliveryAddress());

        holder.orderNoTv.setText(bringBean.getDeliveryCode());

        holder.orderStateTv.setText(GetOrderStateUtil.getPaiSongDanState(bringBean.getDstate()));

        /**
         * 正常状态 都是蓝色
         * 拒绝 和 终止 的异常状态 是 黄色  12 13 11
         * 完成是 灰色  10
         */
        String status = bringBean.getDstate();
        Resources resources = UIUtils.getContext().getResources();
        if (TextUtils.isEmpty(status)) {

            Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
            holder.orderStateTv.setBackgroundDrawable(drawable);
//            普通蓝色
        } else {

            if (status.equals(Constant.JD_YIWANCHENG)) {
                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);
            } else if (status.equals(Constant.JD_YIJUJUE)) {

                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);

            } else {
                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
                holder.orderStateTv.setBackgroundDrawable(drawable);
            }

        }


        holder.jieRootLl.setOnClickListener(new View.OnClickListener() {
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


        @BindView(R.id.order_no_tv)
        TextView orderNoTv;
        @BindView(R.id.order_state_tv)
        TextView orderStateTv;
        @BindView(R.id.yuyue_time)
        OrderConbindView yuyueTime;
        @BindView(R.id.shangpin_info)
        OrderConbindView shangpinInfo;
        @BindView(R.id.paisong_addr)
        OrderConbindView paisongAddr;
        @BindView(R.id.jie_root_ll)
        LinearLayout jieRootLl;


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
        void OnItemClick(JieSuanRespBean.BringBean bringBean, int position);

    }

}
