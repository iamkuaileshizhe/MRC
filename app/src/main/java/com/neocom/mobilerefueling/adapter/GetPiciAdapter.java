package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.GetOilPiCiDetailActivity;
import com.neocom.mobilerefueling.bean.HeTongResBean;
import com.neocom.mobilerefueling.bean.PiCiBringBean;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/8/28.
 */

public class GetPiciAdapter extends BaseAdapter {

    List<PiCiBringBean> piCiBeanList;
    Context context;

    public GetPiciAdapter(Context context,List<PiCiBringBean> piCiBeanList) {
        this.context=context;

        this.piCiBeanList = piCiBeanList;
    }

    public GetPiciAdapter(List<PiCiBringBean> piCiBeanList) {
        this.piCiBeanList = piCiBeanList;
    }

    public void addMoreListData(List<PiCiBringBean> addedTo) {
        if (addedTo != null) {
            piCiBeanList.addAll(addedTo);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return piCiBeanList == null ? 0 : piCiBeanList.size();
    }

    @Override
    public PiCiBringBean getItem(int i) {
        return piCiBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = UIUtils.inflate(R.layout.pici_layout_item);
            holder = new ViewHolder(view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

//        GetPiCiBean getPiCiBean = piCiBeanList.get(i).getBring();
        PiCiBringBean item = getItem(i);
        holder.piciId.setText(item.getBatchNum());
        holder.oilType.setTitle("燃油类型");
        holder.oilType.setContet(item.getStandardName()+item.getFuelModelName());

        holder.oilGetOilCount.setTitle("供油商");// supplyName
        holder.oilGetOilCount.setContet(item.getSupplyName());


//        holder.oilGetOilCount.setTitle("已提油量");// supplyName
//        holder.oilGetOilCount.setContet(item.getFuelDone());


//        holder.oilGetter.setTitle("采购人");
//        holder.oilGetter.setContet(item.getBuyer());
//
//        holder.oilGetterPhone.setTitle("采购人手机");
//        holder.oilGetterPhone.setContet(item.getBuyerTel());
//        holder.oilGetTime.setTitle("采购时间");
//        holder.oilGetTime.setContet(item.getBuyTime());

        holder.piciIdDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(context, "查看详情", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, GetOilPiCiDetailActivity.class);
                intent.putExtra("batchNum",getItem(i).getBatchNum());
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
        @BindView(R.id.oil_get_oil_count)
        OrderConbindView oilGetOilCount;
        @BindView(R.id.oil_getter)
        OrderConbindView oilGetter;
        @BindView(R.id.oil_getter_phone)
        OrderConbindView oilGetterPhone;
        @BindView(R.id.oil_get_time)
        OrderConbindView oilGetTime;
        @BindView(R.id.pici_id_detail)
        TextView piciIdDetail;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
