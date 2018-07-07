package com.neocom.mobilerefueling.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.KHDetailBringBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/8/25.
 */

public class ZSKHListAdapter extends BaseAdapter {

//    List<ReceiverOrderBeanBring.BringBean> bringList;

    List<KHDetailBringBean> bringList;

    public ZSKHListAdapter(List<KHDetailBringBean> bringList) {
        this.bringList = bringList;
    }

    public void addMoreListData(List<KHDetailBringBean> addedTo) {
        if (addedTo != null) {
            bringList.addAll(addedTo);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return bringList == null ? 0 : bringList.size();
    }

    @Override
    public KHDetailBringBean getItem(int i) {
        return bringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.zskh_item_layout);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        KHDetailBringBean bringBean = bringList.get(position);


        holder.kehuCompName.setText(bringBean.getNameSim());
        holder.kehuCompType.setText(GetOrderStateUtil.getKHType(bringBean.getCusType()));

//        /**
//         * 正常状态 都是蓝色
//         * 拒绝 和 终止 的异常状态 是 黄色  12 13 11
//         * 完成是 灰色  10
//         */
//        String status = bringBean.getCheckStatus();
//        Resources resources = UIUtils.getContext().getResources();
//        if (TextUtils.isEmpty(status)) {
//
//            Drawable drawable = resources.getDrawable(R.drawable.order_normal_state_shape);
//            holder.kehuCompState.setBackgroundDrawable(drawable);
////            普通蓝色
//        } else {
//
//            if (status.equals(Constant.WTJ) || status.equals(Constant.XSZR_DSH) || status.equals(Constant.DQJL_DSH)) {
//                Drawable drawable = resources.getDrawable(R.drawable.order_state_shape);
//                holder.kehuCompState.setBackgroundDrawable(drawable);
//            } else if (status.equals(Constant.XSZR_SHSB) || status.equals(Constant.DQJL_SHSB)) {
//
//                Drawable drawable = resources.getDrawable(R.drawable.order_exception_state_shape);
//                holder.kehuCompState.setBackgroundDrawable(drawable);
//
//            } else if (status.equals(Constant.SHCG)) {
//
//                Drawable drawable = resources.getDrawable(R.drawable.order_state_success_shape);
//                holder.kehuCompState.setBackgroundDrawable(drawable);
//
//            } else {
//                Drawable drawable = resources.getDrawable(R.drawable.order_state_shape);
//                holder.kehuCompState.setBackgroundDrawable(drawable);
//
//            }
//
//        }
//
//        holder.kehuCompState.setText(GetOrderStateUtil.getcheckStatus(status));


        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.kehu_comp_name)
        TextView kehuCompName;
        @BindView(R.id.kehu_comp_type)
        TextView kehuCompType;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
