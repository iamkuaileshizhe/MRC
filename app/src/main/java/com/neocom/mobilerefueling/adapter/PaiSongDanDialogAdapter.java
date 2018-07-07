package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.PaiSongDanJDDialogUI;
import com.neocom.mobilerefueling.bean.DeliveryOrderRespBean;
import com.neocom.mobilerefueling.bean.PaiSongDanCommitBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/12/20.
 */

public class PaiSongDanDialogAdapter extends BaseAdapter {

//PaiSongDanJDDialogUI.addedToCommitCarList;

    @Override
    public int getCount() {
        return PaiSongDanJDDialogUI.addedToCommitCarList == null ? 0 : PaiSongDanJDDialogUI.addedToCommitCarList.size();
    }

    @Override
    public PaiSongDanCommitBean.CarListBean getItem(int position) {
        return PaiSongDanJDDialogUI.addedToCommitCarList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = UIUtils.inflate(R.layout.pai_song_dan_show_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        PaiSongDanCommitBean.CarListBean carListBean = PaiSongDanJDDialogUI.addedToCommitCarList.get(position);
        holder.itemChepaihao.setText(carListBean.getVehicleCode());
        holder.itemLianxiren.setText(carListBean.getPName());
//        holder.itemLianxidianhua.setText(carListBean.getTelphone());
        holder.itemFinishTime.setText(carListBean.getFinishTime());
//        holder.itemYoupinleixing.setText(GetOrderStateUtil.getOilType(carListBean.getOilType()));
        holder.itemYoupinleixing.setText(carListBean.getOilTypeName());
        holder.itemGuobiao.setText(carListBean.getNationalStandardName());
        holder.itemJiayouliang.setText(carListBean.getTankSize_show());
        holder.itemDanjiaEt.setText(carListBean.getOilBalance_show());
        holder.itemFee.setTitle("费用");
        holder.itemFee.setContet(carListBean.getOilTotal_show());

        String settleUnit = carListBean.getSettleUnit();

//        if (settleUnit.equals("0")) {
//            holder.itemCalTlTv.setText("升");
//        } else {
//            holder.itemCalTlTv.setText("吨");
//        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_chepaihao)
        TextView itemChepaihao;
        @BindView(R.id.item_lianxiren)
        TextView itemLianxiren;
//        @BindView(R.id.item_lianxidianhua)
//        TextView itemLianxidianhua;
        @BindView(R.id.item_finish_time)
        TextView itemFinishTime;
        @BindView(R.id.item_youpinleixing)
        TextView itemYoupinleixing;
        @BindView(R.id.item_guobiao)
        TextView itemGuobiao;
        @BindView(R.id.item_jiayouliang)
        TextView itemJiayouliang;
        @BindView(R.id.item_danjia_Et)
        TextView itemDanjiaEt;
        @BindView(R.id.item_feiyong_Et)
        TextView itemFeiyongEt;
        @BindView(R.id.item_fee)
        OrderConbindView itemFee;
        @BindView(R.id.lv_content)
        LinearLayout lvContent;
//        @BindView(R.id.item_cal_tl_tv)
//        TextView itemCalTlTv;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
