package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.WaitDoResponse;
import com.neocom.mobilerefueling.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/5/26.
 */

public class WaitToDoAdapter extends RecyclerView.Adapter<WaitToDoAdapter.WaitToDoViewHolder> {


    private Context context;
    private List<WaitDoResponse.WaitDoItem> datas;
    private XRecyclerView recyclerView;

    public WaitToDoAdapter(Context context, XRecyclerView recyclerView, List<WaitDoResponse.WaitDoItem> datas) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.datas = datas;
    }

    public void addDatas(List<WaitDoResponse.WaitDoItem> addDatas) {

        if (addDatas != null && addDatas.size() > 0) {
            recyclerView.smoothScrollToPosition(datas.size());

            datas.addAll(addDatas);

            notifyDataSetChanged();
        }
    }


    @Override
    public WaitToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.waitdo, null, false);

        return new WaitToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaitToDoViewHolder holder, final int position) {

        final WaitDoResponse.WaitDoItem waitDoItem = datas.get(position);

        holder.time.setText(waitDoItem.getCreateDt());
        holder.type.setText(waitDoItem.getLinkState());
        holder.title.setText(waitDoItem.getWorkorderTitle());
        holder.status.setText(waitDoItem.getLinkState());

        holder.rl.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clickCallBack != null) {
                            clickCallBack.onItemClick(waitDoItem, position);
                        }
                    }
                }
        );


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public class WaitToDoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.waitdo_title)   //标题
                TextView title;
        @BindView(R.id.waitdo_status)//执行状态
            TextView status;//waitdo_type
        @BindView(R.id.waitdo_type)//执行状态
            TextView type;
        @BindView(R.id.waitdo_time)//时间
            TextView time;

        @BindView(R.id.rl)
        RelativeLayout rl;

        //        waitdo
        public WaitToDoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private ItemClickCallBack clickCallBack;

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(WaitDoResponse.WaitDoItem waitDoItem, int pos);
    }

}
