package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.GetOilPiCiDetailActivity;
import com.neocom.mobilerefueling.activity.HeTongDetailActivity;
import com.neocom.mobilerefueling.bean.HeTongResBean;
import com.neocom.mobilerefueling.bean.PiCiBringBean;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/11/13.
 */

public class HeTongAdapter extends BaseAdapter {

    List<HeTongResBean.BringBean> bringList;
//    List<PiCiBringBean> piCiBeanList;
    Context context;

    public HeTongAdapter(Context context,List<HeTongResBean.BringBean> bringList) {
        this.context=context;

        this.bringList = bringList;
    }

    public HeTongAdapter(List<HeTongResBean.BringBean> bringList) {
        this.bringList = bringList;
    }

    public void addMoreListData(List<HeTongResBean.BringBean> addedTo) {
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
    public HeTongResBean.BringBean getItem(int i) {
        return bringList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       ViewHolder holder;
        if (view == null) {
            view = UIUtils.inflate(R.layout.hetong_layout_item);
            holder = new ViewHolder(view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

//        GetPiCiBean getPiCiBean = piCiBeanList.get(i).getBring();
        HeTongResBean.BringBean item = getItem(i);
        holder.piciId.setText(item.getBatchNum());
        holder.oilType.setTitle("油品类型");
        holder.oilType.setContet(item.getFuelModelName());

        holder.oilGetOilTime.setTitle("采购时间");// supplyName
//        holder.oilGetOilTime.setContet(item.getSupplyName());
        holder.oilGetOilTime.setContet(item.getBuyTime());


//        holder.oilGetOilCount.setTitle("已提油量");// supplyName
//        holder.oilGetOilCount.setContet(item.getFuelDone());


        holder.oilGetter.setTitle("采购人");
        holder.oilGetter.setContet(item.getBuyer());

//        holder.oilGetterPhone.setTitle("采购人手机");
//        holder.oilGetterPhone.setContet(item.getBuyerTel());
//        holder.oilGetTime.setTitle("采购时间");
//        holder.oilGetTime.setContet(item.getBuyTime());

        holder.piciIdDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(context, "查看详情", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, HeTongDetailActivity.class);
                intent.putExtra("contractNum",getItem(i).getBatchNum());
                context.startActivity(intent);
            }
        });

        return view;
    }


    class ViewHolder {
        @BindView(R.id.pici_id)
        TextView piciId;
        @BindView(R.id.oil_type)
        OrderConbindView oilType;
        @BindView(R.id.oil_get_oil_time)
        OrderConbindView oilGetOilTime;
        @BindView(R.id.oil_getter)
        OrderConbindView oilGetter;
//        @BindView(R.id.oil_getter_phone)
//        OrderConbindView oilGetterPhone;
//        @BindView(R.id.oil_get_time)
//        OrderConbindView oilGetTime;
        @BindView(R.id.pici_id_detail)
        TextView piciIdDetail;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
