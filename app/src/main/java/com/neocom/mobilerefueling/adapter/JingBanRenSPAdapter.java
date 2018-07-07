package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.allen.library.SuperTextView;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.JBRConListBean;
import com.neocom.mobilerefueling.bean.LabelDataBean;
import com.neocom.mobilerefueling.utils.LogUtils;

import java.util.List;


/**
 * Created by Administrator on 2018/4/23.
 */

public class JingBanRenSPAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int SP_HEADER_INFO = 0; // 审批 信息 头部
    private final int SP_ITEM_INFO = 1; // 审批 信息 条目
    private Context context;
    List<JBRConListBean> datas;

    @Override

    public int getItemViewType(int position) {

        if (position == 0) {
            return SP_HEADER_INFO;
        } else if (position == 1) {
            return SP_ITEM_INFO;
        } else {
            return SP_ITEM_INFO;
        }

    }


    public JingBanRenSPAdapter(Context context, List<JBRConListBean> conList) {

        this.context = context;
        this.datas = conList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        View view;
//        if (viewType == SP_HEADER_INFO) {
//
//            view = getView(R.layout.sp_head_info_layout);
//
//            HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
//            return headerViewHolder;
//
//        } else if (viewType == SP_ITEM_INFO) {
//            view = getView(R.layout.sp_item_info_layout);
//
//
//            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
//            return itemViewHolder;
//        } else {
//            view = getView(R.layout.sp_item_info_layout);
//
//            ItemViewHolder itemViewHolder = new ItemViewHolder(view);
//            return itemViewHolder;
//        }


        View view = getView(R.layout.sp_head_info_layout);

        HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
        return headerViewHolder;


    }


    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        SuperTextView menuTitleTv;
        RecyclerView menuContentRecyclerview;
        //        RecyclerView.LayoutManager manager;
        LinearLayoutManager manager;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            menuTitleTv = itemView.findViewById(R.id.menu_title_tv);
            menuContentRecyclerview = itemView.findViewById(R.id.menu_content_recyclerview);
            manager = new LinearLayoutManager(context);
            // 需要注意的是GridLayoutManager要设置setAutoMeasureEnabled(true)成自适应高度
            manager.setAutoMeasureEnabled(true);
            menuContentRecyclerview.setLayoutManager(manager);

        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {


//        private final SuperTextView spInfo;
//        private final EditText noteInfo;
//        private final isEditeTextView spSignInfoTv;
//        private final isEditeTextView spSignTimeTv;

        public ItemViewHolder(View itemView) {
            super(itemView);
//            spInfo = itemView.findViewById(R.id.sp_info);
//            noteInfo = itemView.findViewById(R.id.note_info);
//            spSignInfoTv = itemView.findViewById(R.id.sp_sign_info_tv);
//            spSignTimeTv = itemView.findViewById(R.id.sp_sign_time_tv);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

//        if (holder instanceof HeaderViewHolder) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

        //把内层的RecyclerView 绑定在外层的onBindViewHolder
        // 先判断一下是不是已经设置了Adapter

        JBRConListBean jbrConListBean = datas.get(position);
        String labelName = jbrConListBean.getLabelName();
        List<LabelDataBean> labelData = jbrConListBean.getLabelData();


        LogUtils.i("---labelData---" + new Gson().toJson(labelData));

        headerViewHolder.menuTitleTv.setLeftString(labelName);

//        if (headerViewHolder.menuContentRecyclerview.getAdapter() == null) {
        JBRChildAdapter childAdapter = new JBRChildAdapter(context, headerViewHolder.manager, labelData, position, jbrConListBean, datas);
        childAdapter.setHasStableIds(true);
        headerViewHolder.menuContentRecyclerview.setAdapter(childAdapter);
//        }


//            List<LabelDataBean> labelData = datas.get(0).getLabelData();
//
//
//            JBRChildAdapter childAdapter=new JBRChildAdapter(context,labelData);
//
//            menuContentRecyclerview.setAdapter(childAdapter);


//        }

//        else if (holder instanceof ItemViewHolder) {
////            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
////
////            itemViewHolder.spInfo.setRightString(datas.get(position).getLabelName() + "-->" + position);
//
//        }


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


    /**
     * 用来引入布局的方法
     */
    private View getView(int view) {
        View view1 = View.inflate(context, view, null);
        return view1;
    }

}
