package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.PaiSongDanCommitBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/12/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyRecyclerAdapterViewHolder> {

    private static final String TAG ="RecyclerAdapter" ;
    private final LayoutInflater mLayoutInflater;
    private Context context;
    List<PaiSongDanCommitBean.CarListBean> carListBeen;

    private int TYPE_CHEPAIHAO = 100;
    private int TYPE_LIANXIREN = 110;
    private int TYPE_LIANXIDIANHUA = 120;
    private int TYPE_JIAYOULIANG = 130;

    public RecyclerAdapter(Context context, List<PaiSongDanCommitBean.CarListBean> carListBeen) {
        this.context = context;
        this.carListBeen = carListBeen;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public RecyclerAdapter(List<PaiSongDanCommitBean.CarListBean> carListBeen) {
        this.carListBeen = carListBeen;
        mLayoutInflater = LayoutInflater.from(context);
    }

//添加 一辆车
    public void addOneItem(PaiSongDanCommitBean.CarListBean beanItem) {

        if (beanItem != null) {
            Log.i(TAG, "addOneItem:之前 "+carListBeen.size());
            carListBeen.add(0,beanItem);

            notifyItemInserted(0);
            Log.i(TAG, "addOneItem: 新增了一条"+beanItem.toString());

            Log.i(TAG, "addOneItem:之后 "+carListBeen.size());
        }
    }

    //    添加 列表数据
    public void addList(List<PaiSongDanCommitBean.CarListBean> carListdata) {
        if (carListdata != null) {
            carListBeen.addAll(carListdata);
            notifyItemInserted(carListBeen.size());

        }
    }

    // 删除一条数据

    public void deleteOneItem(int position) {
        carListBeen.remove(position);
//        notifyDataSetChanged();
        notifyItemRemoved(position);
    }

    public List<PaiSongDanCommitBean.CarListBean> getAllItemData() {
        return carListBeen;
    }

    @Override
    public MyRecyclerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRecyclerAdapterViewHolder(mLayoutInflater.inflate(R.layout.paisongdan_rec_item_data_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapterViewHolder holder, int position) {

        PaiSongDanCommitBean.CarListBean carListBean = carListBeen.get(position);

        holder.itemChepaihao.setText(carListBean.getVehicleCode());
        holder.itemLianxiren.setText(carListBean.getPName());
        holder.itemLianxidianhua.setText(carListBean.getTelphone());
        holder.itemFinishTime.setText(carListBean.getFinishTime());
        holder.itemYoupinleixing.setText(GetOrderStateUtil.getOilType(carListBean.getOilType()));
        holder.itemGuobiao.setText(carListBean.getNationalStandard());
        holder.itemJiayouliang.setText(carListBean.getOilTotal());
//        holder.itemDanjia.setTitle("单价");
//        holder.itemDanjia.setContet(carListBean.getOilBalance());
//        holder.itemFee.setTitle("本次费用(元)");
//        holder.itemFee.setContet(carListBean.getJinEMoney());
//        holder.itemFee.setTag(position);
//        getItem(position).setTankSize("");


        if (holder.itemChepaihao.getTag() instanceof RecTextWatcher){
            holder.itemChepaihao.removeTextChangedListener((RecTextWatcher) holder.itemChepaihao.getTag());
        }
        if (holder.itemLianxiren.getTag() instanceof RecTextWatcher){
            holder.itemLianxiren.removeTextChangedListener((RecTextWatcher) holder.itemLianxiren.getTag());
        }
        if (holder.itemLianxidianhua.getTag() instanceof RecTextWatcher){
            holder.itemLianxidianhua.removeTextChangedListener((RecTextWatcher) holder.itemLianxidianhua.getTag());
        }
        if (holder.itemJiayouliang.getTag() instanceof RecTextWatcher){
            holder.itemJiayouliang.removeTextChangedListener((RecTextWatcher) holder.itemJiayouliang.getTag());
        }



//      车牌号
        holder.itemChepaihao.setText(carListBean.getVehicleCode());

        RecTextWatcher chePaiHaoTextWatcher = new RecTextWatcher(holder, holder.itemChepaihao, position, TYPE_CHEPAIHAO);
        holder.itemChepaihao.addTextChangedListener(chePaiHaoTextWatcher);

//        联系人
        holder.itemLianxiren.setText(carListBean.getPName());
        RecTextWatcher lianXiRenTextWatcher = new RecTextWatcher(holder, holder.itemLianxiren, position, TYPE_LIANXIREN);
        holder.itemLianxiren.addTextChangedListener(lianXiRenTextWatcher);

//        联系电话

        holder.itemLianxidianhua.setText(carListBean.getTelphone());

        RecTextWatcher lianxiRenDHTextWatcher = new RecTextWatcher(holder, holder.itemLianxidianhua, position, TYPE_LIANXIDIANHUA);
        holder.itemLianxidianhua.addTextChangedListener(lianxiRenDHTextWatcher);

//        单价
        holder.itemDanjiaEt.setText(carListBean.getOilBalance());

        RecTextWatcher jiaYouLiangTextWatcher = new RecTextWatcher(holder, holder.itemJiayouliang, position, TYPE_JIAYOULIANG);
        holder.itemJiayouliang.addTextChangedListener(jiaYouLiangTextWatcher);

    }

    class RecTextWatcher implements TextWatcher {
        MyRecyclerAdapterViewHolder holderEt;
        TextView whichTv;
        int positionEtInParent;
        int whichType;

        public RecTextWatcher(MyRecyclerAdapterViewHolder holder, TextView whichTv, int position, int whichType) {

            this.holderEt = holder;
            this.whichTv = whichTv;
            this.positionEtInParent=position;
            this.whichType=whichType;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {


            if (whichType==TYPE_CHEPAIHAO){
                Log.i(TAG, "afterTextChanged: 车牌号"+s.toString());
            }
            if (whichType==TYPE_LIANXIREN){
                Log.i(TAG, "afterTextChanged: 联系人"+s.toString());
            }
            if (whichType==TYPE_LIANXIDIANHUA){
                Log.i(TAG, "afterTextChanged: 联系电话"+s.toString());
            }
            if (whichType==TYPE_JIAYOULIANG){
                Log.i(TAG, "afterTextChanged: 加油量"+s.toString());
            }
        }
    }


    @Override
    public int getItemCount() {
        Log.i("", "getItemCount:执行了么.... ");
        return carListBeen == null ? 0 : carListBeen.size();
    }

    public static class MyRecyclerAdapterViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.item_chepaihao)
        EditText itemChepaihao;
        @BindView(R.id.item_lianxiren)
        EditText itemLianxiren;
        @BindView(R.id.item_lianxidianhua)
        EditText itemLianxidianhua;
        @BindView(R.id.item_finish_time)
        TextView itemFinishTime;
        @BindView(R.id.item_youpinleixing)
        TextView itemYoupinleixing;
        @BindView(R.id.item_guobiao)
        TextView itemGuobiao;
        @BindView(R.id.item_jiayouliang)
        EditText itemJiayouliang;
        @BindView(R.id.item_danjia_Et)
        TextView itemDanjiaEt;
        @BindView(R.id.item_feiyong_Et)
        TextView itemFeiyongEt;
        @BindView(R.id.save_tv)
        TextView saveTv;
        @BindView(R.id.bottom_ll)
        LinearLayout bottomLl;


        public MyRecyclerAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        @OnClick(R.id.save_tv)
        void onItemClick() {

            Log.i("适配器", "onItemClick: ==>" + getPosition());

        }
//        @OnClick(R.id.save_tv)
//        void onItemClick(){
//
//            Log.i("适配器","onItemClick: ==>"+getPosition());
//        }

    }


}
