package com.neocom.mobilerefueling.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ReceiverOrderBeanBring;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

/**
 * Created by admin on 2017/8/25.
 */

public class YunYouCheListAdapter extends BaseAdapter {

    List<YunYouCheResponseBean.BringBean> bringList;
//    private String state;

    public YunYouCheListAdapter(List<YunYouCheResponseBean.BringBean> bringList) {
        this.bringList = bringList;
//        this.state = state;
    }

    public void addMoreListData(List<YunYouCheResponseBean.BringBean> addedTo) {
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
    public YunYouCheResponseBean.BringBean getItem(int i) {
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
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.yunyouche_list_item_layout);
//            holder.deliveryCode = convertView.findViewById(R.id.receive_delivercode);
            holder.orderNoTv = convertView.findViewById(R.id.order_no_tv);
            holder.orderStateTv = convertView.findViewById(R.id.order_state_tv);
            holder.estimateTime = convertView.findViewById(R.id.receive_estamate_time);
            holder.oilAmount = convertView.findViewById(R.id.receive_oil_count);
            holder.deliveryAddress = convertView.findViewById(R.id.receive_address);
            holder.carList = convertView.findViewById(R.id.receive_carlist_count);
            holder.stateOrder = convertView.findViewById(R.id.receive_carlist_state);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        YunYouCheResponseBean.BringBean bringBean = bringList.get(position);

        /*************************************************************************/

//        holder.deliveryCode.setTitle();
//        holder.deliveryCode.setContet(bringBean.getDeliveryCode());
        holder.orderNoTv.setText(bringBean.getSupplyCode());

        holder.orderStateTv.setText(GetOrderStateUtil.getSendType(bringBean.getRecordStatus()));

        holder.estimateTime.setTitle("补给时间");
        holder.estimateTime.setContet(bringBean.getSupplyTime());

        holder.oilAmount.setTitle("补给油量");
        String supplyNum = bringBean.getSupplyNum();
        if (!TextUtils.isEmpty(supplyNum)) {
//            holder.oilAmount.setContet(supplyNum +"(千克)");
            holder.oilAmount.setContet(supplyNum );
        }

        holder.deliveryAddress.setTitle("运油车牌号");
        holder.deliveryAddress.setContet(bringBean.getSupplyCarCode());

        holder.carList.setTitle("运油司机");
        holder.carList.setContet(bringBean.getSupplyCarDriver());

        holder.stateOrder.setTitle("联系电话");
        holder.stateOrder.setContet(bringBean.getSupplyCarTelphone());


        return convertView;
    }

    static class ViewHolder {

//        OrderConbindView deliveryCode;

        TextView orderNoTv;
        TextView orderStateTv;

        OrderConbindView estimateTime;
        OrderConbindView oilAmount;
        OrderConbindView deliveryAddress;
        OrderConbindView carList;
        OrderConbindView stateOrder;

    }


}
