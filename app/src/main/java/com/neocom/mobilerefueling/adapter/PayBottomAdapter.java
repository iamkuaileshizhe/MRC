package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.PayWayReqBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/6/12.
 */

public class PayBottomAdapter extends RecyclerView.Adapter<PayBottomAdapter.PayBottomViewHolder> {


    private Context context;
    private List<PayWayReqBean.BringBean> datas;
    private int selected = -1;

    public PayBottomAdapter() {
    }

    public PayBottomAdapter(Context context, List<PayWayReqBean.BringBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setSelection(int position) {
        this.selected = position;
        notifyDataSetChanged();
    }

    public int getSelection() {

        return selected;
    }

    @Override
    public PayBottomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.pay_btm_item_layout, parent, false);

        return new PayBottomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PayBottomViewHolder holder, final int position) {
        final PayWayReqBean.BringBean payType = datas.get(position);

        holder.payTypeTv.setText(payType.getPayWayName());


        String payWayCode = payType.getPayWayCode();
        if (payWayCode.equals("1")) {
//            银联
            holder.payTypeLogoIv.setImageResource(R.mipmap.union_pay_icon);
        } else if (payWayCode.equals("2")) {
//            支付宝
            holder.payTypeLogoIv.setImageResource(R.mipmap.app_recharge_alipay);
        } else if ((payWayCode.equals("3"))) {
//            微信
            holder.payTypeLogoIv.setImageResource(R.mipmap.app_recharge_wxpay);
        }

//        holder.payTypeLogoIv.setImageResource(R.mipmap.app_recharge_alipay);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itemClickListener != null) {

                    itemClickListener.OnClick(payType, position);
                }

            }
        });

        if (position == selected) {

            holder.itemView.setSelected(true);
            holder.checkBox.setChecked(true);
        } else {

            holder.itemView.setSelected(false);
            holder.checkBox.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class PayBottomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.pay_type_tv)
        TextView payTypeTv;

        @BindView(R.id.pay_type_logo_iv)
        ImageView payTypeLogoIv;
        @BindView(R.id.checkbox)
        CheckBox checkBox;

        public PayBottomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnRecycerViewItemClickListener itemClickListener;

    public void setOnRecycerViewItemClickListener(OnRecycerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnRecycerViewItemClickListener {
        void OnClick(PayWayReqBean.BringBean payChooseBean, int position);
    }

}
