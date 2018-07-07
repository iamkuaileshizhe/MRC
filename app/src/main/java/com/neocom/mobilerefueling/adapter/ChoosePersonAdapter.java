package com.neocom.mobilerefueling.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ChoosePersonBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by admin on 2017/11/23.
 */

public class ChoosePersonAdapter extends BaseAdapter {

    List<ChoosePersonBean.BringBean> bring;
    Context context;

    public ChoosePersonAdapter(Context context, List<ChoosePersonBean.BringBean> bring) {
        this.bring = bring;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bring == null ? 0 : bring.size();
    }

    @Override
    public ChoosePersonBean.BringBean getItem(int i) {
        return bring.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.pesion_layout);
            holder.sexyAvtar = convertView.findViewById(R.id.sex_img);
            holder.userName = convertView.findViewById(R.id.user_name);
            holder.phoneTv = convertView.findViewById(R.id.phone);
            holder.selectItem = convertView.findViewById(R.id.select_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ChoosePersonBean.BringBean item = getItem(position);
        holder.userName.setText(item.getUserName());


        final String phone = item.getUserInfoMobile();
        holder.phoneTv.setText(phone);

        holder.phoneTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phone)) {
                    Toasty.info(context, "电话号码为空", Toast.LENGTH_SHORT, true).show();
                    return;
                }
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


        holder.selectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //跳转 个人详情 shiftUser
                Intent intent = new Intent();
                intent.putExtra("shiftUser", getItem(position).getUserName());
                intent.putExtra("shiftUserId", getItem(position).getUserInfoUserId());
                ((Activity) context).setResult(2, intent);
                ((Activity) context).finish();

            }
        });

        return convertView;
    }

    static class ViewHolder {

        ImageView sexyAvtar;
        TextView userName;
        TextView phoneTv;
        RelativeLayout selectItem;


    }

}
