package com.neocom.mobilerefueling.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.bean.TiYNewRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.isEditeTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/2.
 */

public class TiYouNewAdapter extends BaseAdapter {

    List<TiYNewRespBean.BringBean> datas;

    public TiYouNewAdapter(List<TiYNewRespBean.BringBean> datas) {
        this.datas = datas;
    }

    public void addMoreListData(List<TiYNewRespBean.BringBean> addedTo) {
        if (addedTo != null) {
            datas.addAll(addedTo);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public TiYNewRespBean.BringBean getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = UIUtils.inflate(R.layout.tiyou_list_item_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TiYNewRespBean.BringBean item = getItem(position);
        holder.tiyouId.setText(item.getPurchaseCode());
        holder.tiyouStateTv.setText(GetOrderStateUtil.getinsConfirmStatus(item.getRecordStatus()));
        holder.tiyouAmountNum.setTitle("预计提油量");
        holder.tiyouAmountNum.setContet(item.getInstructNum());
        holder.tiyouTime.setTitle("预计提油时间");
        holder.tiyouTime.setContet(item.getInstructTime());
        holder.tiyouCarnum.setTitle("提油车牌号");
        holder.tiyouCarnum.setContet(item.getCarCode());


        /**
         * 正常状态 都是蓝色
         * 拒绝 和 终止 的异常状态 是 黄色  12 13 11
         * 完成是 灰色  10
         */
        String status = item.getRecordStatus();
        Resources resources = UIUtils.getContext().getResources();
        if (TextUtils.isEmpty(status)) {

            Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
            holder.tiyouStateTv.setBackgroundDrawable(null);
//            holder.tiyouStateTv.setVisibility(View.INVISIBLE);
//            普通蓝色
        } else {

            if (status.equals("1")) { // 已完成
                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
                holder.tiyouStateTv.setBackgroundDrawable(drawable);
            } else if (status.equals("3")) { // 审核不通过

                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
                holder.tiyouStateTv.setBackgroundDrawable(drawable);

            } else {
                Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
                holder.tiyouStateTv.setBackgroundDrawable(drawable);

            }

        }


        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.tiyou_id)
        TextView tiyouId;
        @BindView(R.id.tiyou_state_tv)
        TextView tiyouStateTv;
        @BindView(R.id.tiyou_time)
        OrderConbindView tiyouTime;
        @BindView(R.id.tiyou_amount_num)
        OrderConbindView tiyouAmountNum;
        @BindView(R.id.tiyou_carnum)
        OrderConbindView tiyouCarnum;


        //        提油车牌号
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
