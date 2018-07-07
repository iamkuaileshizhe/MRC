package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.utils.LogUtil;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.GuanLianGoodsRespBean;
import com.neocom.mobilerefueling.utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/12.
 */

public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.BottomSheetViewHolder> {

    private Context context;
    List<GuanLianGoodsRespBean.BringBean> goodsEntities;

    boolean isShow = true; // 加减图标是否显示

    public BottomSheetAdapter(Context context, List<GuanLianGoodsRespBean.BringBean> goodsEntities) {
        this.context = context;
        this.goodsEntities = goodsEntities;
    }

    @Override
    public BottomSheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_goods_item_layout, parent, false);
        return new BottomSheetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BottomSheetViewHolder holder, final int position) {
        final GuanLianGoodsRespBean.BringBean bringBean = goodsEntities.get(position);

        String numStr = bringBean.getNum();
        if (TextUtils.isEmpty(numStr)) {
            numStr = "0";
        }

        holder.tvNameContent.setText(bringBean.getName());
        holder.tvNoContent.setText(bringBean.getNo());
        holder.numAccountTv.setText(bringBean.getNum());


        if (isShow) {
            holder.numRemoveIv.setVisibility(View.VISIBLE);
            holder.numAddIv.setVisibility(View.VISIBLE);
            holder.deleteIv.setVisibility(View.VISIBLE);


        } else {
            holder.numRemoveIv.setVisibility(View.GONE);
            holder.numAddIv.setVisibility(View.GONE);
            holder.deleteIv.setVisibility(View.GONE);
        }

        holder.deleteIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onRecycerItemViewClickListener != null) {
                    onRecycerItemViewClickListener.OnItemViewClick(position);
                }

            }
        });
        holder.numRemoveIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddOrRemove(bringBean, position, false);
            }
        });

        holder.numAddIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddOrRemove(bringBean, position, true);

            }
        });


    }

    @Override
    public int getItemCount() {
        return goodsEntities == null ? 0 : goodsEntities.size();
    }

    public class BottomSheetViewHolder extends RecyclerView.ViewHolder {


        public BottomSheetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @BindView(R.id.item_data)
        LinearLayout itemData;
        @BindView(R.id.tv_name_title)
        TextView tvNameTitle;
        @BindView(R.id.tv_name_content)
        TextView tvNameContent;
        @BindView(R.id.tv_no_title)
        TextView tvNoTitle;
        @BindView(R.id.tv_no_content)
        TextView tvNoContent;
        @BindView(R.id.delete_iv)
        ImageView deleteIv;
        @BindView(R.id.num_remove_iv)
        ImageView numRemoveIv;
        @BindView(R.id.num_account_tv)
        TextView numAccountTv;
        @BindView(R.id.num_add_iv)
        ImageView numAddIv;

    }


    OnRecycerItemViewClickListener onRecycerItemViewClickListener;

    public void setOnRecycerItemViewClickListener(OnRecycerItemViewClickListener onRecycerItemViewClickListener) {
        this.onRecycerItemViewClickListener = onRecycerItemViewClickListener;
    }

    public interface OnRecycerItemViewClickListener {

        void OnItemViewClick(int position);

    }


    public void AddOrRemove(GuanLianGoodsRespBean.BringBean bringBean, int position, boolean isAdd) {


        String num = bringBean.getNum();

        String useableNum = bringBean.getUseableNum();

        if (!TextUtils.isEmpty(num)) {

            int numInt = Integer.parseInt(num);

            if (isAdd) {
                numInt++;
                if (!TextUtils.isEmpty(useableNum)) {

                    int parseInt = Integer.parseInt(useableNum);

                    if (numInt > parseInt) {

                        Toast.makeText(context, "不能超过库存量", Toast.LENGTH_SHORT).show();
                        numInt = parseInt;
                    }
                }

//                else {
//
//                    int parseInt = Integer.parseInt(useableNum);
//
//                    if (numInt > parseInt) {
//
//                        Toast.makeText(context, "不能超过库存量", Toast.LENGTH_SHORT).show();
//                        numInt = parseInt;
//                    }
//
//                }


            } else {

                numInt--;
                if (numInt < 1) {
                    numInt = 1;

                    Toast.makeText(context, "至少选择1个", Toast.LENGTH_SHORT).show();
                }
            }

//                    Toast.makeText(context, "减去->" + position, Toast.LENGTH_SHORT).show();
            num = String.valueOf(numInt);
            bringBean.setNum(num);
            goodsEntities.set(position, bringBean);

            LogUtil.i("变化后-->" + GsonUtil.GsonString(goodsEntities));

            notifyDataSetChanged();
        }

    }


    /**
     * @param isShow true 显示 false 不显示
     */
    public void setAddAndRemoveGone(boolean isShow) {
        this.isShow = isShow;

    }

    public List<GuanLianGoodsRespBean.BringBean> getRecyclerData() {

//        List<GuanLianGoodsRespBean.BringBean> goodsEntities

        if (goodsEntities == null) {
            return new ArrayList<>();
        }
        return goodsEntities;
    }

    public void clearRecData() {

        if (goodsEntities != null) {

            goodsEntities.clear();
            notifyDataSetChanged();

        }

    }

    public void removeItemData(int position) {

        goodsEntities.remove(position);

        notifyItemRemoved(position);
//        notifyDataSetChanged();
    }


    public void addItemData(GuanLianGoodsRespBean.BringBean addData) {

        if (addData != null) {
            goodsEntities.add(addData);
            notifyDataSetChanged();
        }

    }

    public void addListDataAndClear(List<GuanLianGoodsRespBean.BringBean> addDatas) {


        if (addDatas != null) {

            if (goodsEntities != null) {
                goodsEntities.clear();
            }
            goodsEntities.addAll(addDatas);
            notifyDataSetChanged();
        }

    }

    public void addListDataButClear(List<GuanLianGoodsRespBean.BringBean> addDatas) {

        if (addDatas != null) {
            goodsEntities.addAll(addDatas);
            notifyDataSetChanged();
        }

    }


}
