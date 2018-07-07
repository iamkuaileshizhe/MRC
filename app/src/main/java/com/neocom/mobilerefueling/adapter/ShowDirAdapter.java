package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.neocom.mobilerefueling.R;

import java.util.List;

/**
 * Created by admin on 2017/10/30.
 */

public class ShowDirAdapter extends BaseAdapter {
    List<String > orderItemOils;
    Context context;

    public ShowDirAdapter(Context context, List<String> orderItemOils) {
        this.orderItemOils = orderItemOils;
        this.context = context;
    }

    @Override
    public int getCount() {
        return orderItemOils == null ? 0 : orderItemOils.size();
    }

    @Override
    public String getItem(int i) {
        return orderItemOils.get(i);
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
//            convertView = UIUtils.inflate(R.layout.pop_menuitem);
            convertView = View.inflate(context, R.layout.pop_menuitem, null);

            holder.itemOil = (TextView) convertView.findViewById(R.id.menuitem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String item = getItem(position);
        if (item != null) {
            holder.itemOil.setText(item.toString());
        }

        return convertView;
    }

    class ViewHolder {

        TextView itemOil;

    }

}
