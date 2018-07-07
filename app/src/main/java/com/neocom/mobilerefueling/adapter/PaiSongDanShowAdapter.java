package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.DeliveryOrderRespBean;
import com.neocom.mobilerefueling.bean.PaiSongDanCommitBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/12/16.
 */

public class PaiSongDanShowAdapter extends BaseAdapter {

//    List<PaiSongDanCommitBean.CarListBean> carListBeen;


    List<DeliveryOrderRespBean.BringBean.CarListBean> carListBeen;
    Context context;

    public PaiSongDanShowAdapter(Context context) {
        this.context = context;
    }

    public PaiSongDanShowAdapter(List<DeliveryOrderRespBean.BringBean.CarListBean> carListBeen) {
        this.carListBeen = carListBeen;
    }

    @Override
    public int getCount() {
        return carListBeen == null ? 0 : carListBeen.size();
    }

    @Override
    public DeliveryOrderRespBean.BringBean.CarListBean getItem(int position) {
        return carListBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = UIUtils.inflate(R.layout.psd_item_show_adapter_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        DeliveryOrderRespBean.BringBean.CarListBean carListBean = carListBeen.get(position);
        holder.itemChepaihao.setText(carListBean.getVehicleCode());
        holder.itemLianxiren.setText(carListBean.getPName());
        holder.itemLianxidianhua.setText(carListBean.getTelphone());
        holder.itemFinishTime.setText(carListBean.getFinishTime());
//        holder.itemYoupinleixing.setText(GetOrderStateUtil.getOilType(carListBean.getOilType()));
        holder.itemYoupinleixing.setText(carListBean.getNationalStandardName()+carListBean.getOilTypeName());
//        holder.itemGuobiao.setText(carListBean.getNationalStandardName());
        holder.itemJiayouliang.setText(carListBean.getTankSize_show() + "");
        holder.itemFeiyongEt.setText(carListBean.getOilTotal() + "元");
//        holder.itemFee.setTitle("总计");
//        holder.itemFee.setContet(carListBean.);
        holder.itemFee.setVisibility(View.GONE);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_chepaihao)
        TextView itemChepaihao;
        @BindView(R.id.item_lianxiren)
        TextView itemLianxiren;
        @BindView(R.id.item_lianxidianhua)
        TextView itemLianxidianhua;
        @BindView(R.id.item_finish_time)
        TextView itemFinishTime;
        @BindView(R.id.item_youpinleixing)
        TextView itemYoupinleixing;
//        @BindView(R.id.item_guobiao)
//        TextView itemGuobiao;
        @BindView(R.id.item_jiayouliang)
        TextView itemJiayouliang;
        @BindView(R.id.item_danjia_Et)
        TextView itemDanjiaEt;
        @BindView(R.id.item_feiyong_Et)
        TextView itemFeiyongEt;
        @BindView(R.id.item_fee)
        OrderConbindView itemFee;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
