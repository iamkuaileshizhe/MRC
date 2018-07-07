package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.neocom.mobilerefueling.activity.ChooseOilCarActivity;
import com.neocom.mobilerefueling.bean.ChooseCarBean;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderInfoView;

import java.util.List;

/**
 * Created by admin on 2017/8/11.
 */

public class AddedCarAdapter extends BaseAdapter {
    private static final String TAG = "AddedCarAdapter";
    List<ChooseCarBean> carBeanList;
    Context context;


    public AddedCarAdapter(Context context, List<ChooseCarBean> carBeanList) {
        this.context = context;
        this.carBeanList = carBeanList;
    }


    @Override
    public int getCount() {

        if (carBeanList != null && carBeanList.size() > 0) {
//            Log.i(TAG, "getCount: "+carBeanList.size());
            return carBeanList.size();
        }
        return 0;
    }

    @Override
    public ChooseCarBean getItem(int i) {
        return carBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

//        Log.i(TAG, "getView: getView1111111111111111111111111111111111111111111111111");
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = new OrderInfoView(context);
            viewHolder.orderInfoView = (OrderInfoView) convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChooseCarBean carBeanItem = getItem(position);

        if (carBeanItem != null) {
            Log.i(TAG, "getView: 设置值");
            viewHolder.orderInfoView.setCbVisibility(View.GONE);
            viewHolder.orderInfoView.setCarNumText(carBeanItem.getCarNum());
            viewHolder.orderInfoView.setCarOilTypeText(carBeanItem.getFuelType());
            viewHolder.orderInfoView.setCarOilCountText(carBeanItem.getTankSize());
            viewHolder.orderInfoView.setCarDriverText(carBeanItem.getName());
            viewHolder.orderInfoView.setCarDriverPhoneText(carBeanItem.getTelephone());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = viewHolder.orderInfoView.isChecked();
                viewHolder.orderInfoView.setChecked(!b);
                carBeanList.get(position).setChecked(!b);

                ChooseOilCarActivity.lastgroups = carBeanList;

                Log.i(TAG, "onClick: ==>" + carBeanList.toString());
            }
        });

        viewHolder.orderInfoView.setOnClickPullListener(new OrderInfoView.OnClickPullListener() {
            @Override
            public void ClickPull(int pos, String conten) {

                carBeanList.get(position).setFuelType(conten);
                Toast.makeText(UIUtils.getContext(), "位置："+pos+"；内容："+conten, Toast.LENGTH_SHORT).show();

            }
        });


        return convertView;
    }

    public static class ViewHolder {

        // 先这样试试 可能会 出现问题
        OrderInfoView orderInfoView; //= new OrderInfoView(UIUtils.getContext());

    }


}
