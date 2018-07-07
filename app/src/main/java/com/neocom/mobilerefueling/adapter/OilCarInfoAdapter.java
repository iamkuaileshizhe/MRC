package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.GetCarInfoRespBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xyz on 2017/12/31.
 */

public class OilCarInfoAdapter extends RecyclerView.Adapter<OilCarInfoAdapter.OilCarInfoViewHolder> {

    List<GetCarInfoRespBean.BringBean> datas;
    private Context context;

    public OilCarInfoAdapter(Context context, List<GetCarInfoRespBean.BringBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    public void setDatas(List<GetCarInfoRespBean.BringBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public OilCarInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        OilCarInfoViewHolder infoViewHolder = new OilCarInfoViewHolder(LayoutInflater.from(context).inflate(R.layout.oil_car_item_info_layout, null, false));

        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(OilCarInfoViewHolder holder, int position) {

        final GetCarInfoRespBean.BringBean bringBean = datas.get(position);

        holder.oilCarNum.setText(bringBean.getCarNum());
        holder.oilCarUsername.setText(bringBean.getName());
        holder.oilCarUserphone.setText(bringBean.getTelephone());
//将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemContainer.setTag(position);

        holder.itemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mOnItemClickListener != null) {
                    //注意这里使用getTag方法获取position
                    mOnItemClickListener.onItemClick(view, (int) view.getTag(),bringBean);
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class OilCarInfoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.oil_car_num)
        TextView oilCarNum;
        @BindView(R.id.oil_car_username)
        TextView oilCarUsername;
        @BindView(R.id.oil_car_userphone)
        TextView oilCarUserphone;
        @BindView(R.id.item_container)
        LinearLayout itemContainer;

        public OilCarInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position,GetCarInfoRespBean.BringBean bringBean);
    }


}
