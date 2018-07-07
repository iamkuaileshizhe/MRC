package com.neocom.mobilerefueling.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.OilLXGBBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/10/17.
 */

public class OilTypeAdapter extends BaseAdapter {

    List<OilLXGBBean.BringBean> oilType;

    public OilTypeAdapter(List<OilLXGBBean.BringBean> oilType) {
        this.oilType = oilType;
    }

    @Override
    public int getCount() {
        return oilType == null ? 0 : oilType.size();
    }

    @Override
    public OilLXGBBean.BringBean getItem(int i) {
        return oilType.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView = UIUtils.inflate(R.layout.pop_menuitem);
            holder.itemOil=convertView.findViewById(R.id.menuitem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        OilLXGBBean.BringBean item = getItem(position);
        if (item!=null){
            holder.itemOil.setText(item.getDictName());
        }else {
            holder.itemOil.setText("");
        }

        return convertView;
    }

    class ViewHolder{

        TextView itemOil;

    }

}
