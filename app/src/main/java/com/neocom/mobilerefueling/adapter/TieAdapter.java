package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.widget.jcdialog.adapter.SuperAdapter;
import com.widget.jcdialog.bean.TieBean;
import com.widget.jcdialog.holder.SuperItemHolder;
import com.widget.jcdialog.holder.TieItemHolder;

import java.util.List;

/**
 * Created by admin on 2017/9/6.
 */

public class TieAdapter extends SuperAdapter<TieBean> {
    public TieAdapter(Context mContext, List<TieBean> list) {
        super(mContext, list);
    }

    @Override
    public SuperItemHolder getItemHolder(ViewGroup parent, int viewType) {
        return new TieItemHolder(mContext, mListener, LayoutInflater.from(mContext).
                inflate(com.widget.jcdialog.R.layout.dialogui_holder_item_tie, parent, false));
    }
}
