package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.PayTypeChooseBean;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.List;

/**
 * Created by admin on 2017/11/2.
 */

public class PayTypeAdapter extends BaseAdapter {

    private Context context;
    private List<PayTypeChooseBean> payTypeChooseBeen;

    private int checkItemPosition = 0;
    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }


    public PayTypeAdapter(Context context, List<PayTypeChooseBean> payTypeChooseBeen) {
        this.context = context;
        this.payTypeChooseBeen = payTypeChooseBeen;
    }

    @Override
    public int getCount() {
        return payTypeChooseBeen == null ? 0 : payTypeChooseBeen.size();
    }

    @Override
    public PayTypeChooseBean getItem(int i) {
        return payTypeChooseBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.paytype_choose_item);
            viewHolder.payTypeLogo = convertView.findViewById(R.id.pay_type_logo);
            viewHolder.payTypeTitle = convertView.findViewById(R.id.pay_type_title);
            viewHolder.payTypeChecked = convertView.findViewById(R.id.pay_type_checked);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        PayTypeChooseBean item = getItem(position);
        viewHolder.payTypeLogo.setBackgroundResource(item.getPayTypeLogo());

        viewHolder.payTypeTitle.setText(item.getPayTypeText());
        fillValue(position, viewHolder);
        return convertView;
    }


    private void fillValue(int position, ViewHolder viewHolder) {

        if (checkItemPosition != -1) {
            if (checkItemPosition == position) {
//                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.white));
//                viewHolder.mText.setBackgroundResource(R.drawable.check_bg);

                viewHolder.payTypeChecked.setBackgroundResource(R.mipmap.app_recharge_pay_selected);

            } else {
//                viewHolder.mText.setTextColor(context.getResources().getColor(R.color.text_black));
//                viewHolder.mText.setBackgroundResource(R.drawable.uncheck_bg);
                viewHolder.payTypeChecked.setBackgroundResource(R.mipmap.app_recharge_pay_select);
            }
        }




    }


    class ViewHolder {
        ImageView payTypeLogo;
        TextView payTypeTitle;
        ImageView payTypeChecked;
    }

}
