package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ExpandListViewChild;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

//import com.huanyu.itsms.R;
//import com.huanyu.itsms.bean.ExpandListViewChild;
//import com.huanyu.itsms.utils.UIUtils;
//
//import java.util.List;

/**
 * Created by admin on 2017/7/19.
 */

public class MeFunctionMenuAdapter extends BaseAdapter {
    private List<ExpandListViewChild> listMenu;

    public MeFunctionMenuAdapter(List<ExpandListViewChild> listMenu) {
        this.listMenu = listMenu;
    }

    @Override
    public int getCount() {
        if (listMenu != null) {
            return listMenu.size();
        } else {
            return 0;
        }
    }

    @Override
    public ExpandListViewChild getItem(int position) {
        return listMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.me_fc_list_item);
            holder.menuIcon = convertView.findViewById(R.id.me_fg_menu_icon_iv);
            holder.menuText = convertView.findViewById(R.id.me_fg_menu_txt_tv);
            holder.memuArrowGuid = convertView.findViewById(R.id.me_fg_menu_guid);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ExpandListViewChild menuChild = listMenu.get(position);
        holder.menuIcon.setImageResource(menuChild.getIcon());
        holder.menuText.setText(menuChild.getName());

        return convertView;
    }


    static class ViewHolder {
        ImageView menuIcon;
        TextView menuText;
        ImageView memuArrowGuid;
    }
}
