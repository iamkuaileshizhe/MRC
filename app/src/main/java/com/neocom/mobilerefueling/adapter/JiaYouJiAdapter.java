package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.ChooseOilCarActivity;
import com.neocom.mobilerefueling.bean.ChooseCarBean;
import com.neocom.mobilerefueling.bean.JiaYouJiRespBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.OrderInfoView;

import java.util.List;

/**
 * Created by admin on 2017/11/30.
 */

public class JiaYouJiAdapter extends BaseAdapter {

    private Context context;

    private List<JiaYouJiRespBean.BringBean> datas;

    public JiaYouJiAdapter(Context context, List<JiaYouJiRespBean.BringBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<JiaYouJiRespBean.BringBean> getDatas() {
        return datas;
    }

    public void setDatas(List<JiaYouJiRespBean.BringBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public JiaYouJiRespBean.BringBean getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = UIUtils.inflate(R.layout.jia_you_ji_item_layout);
            viewHolder.allItem = convertView.findViewById(R.id.all_item);
            viewHolder.jiayouCb = convertView.findViewById(R.id.jiayou_cb);
            viewHolder.jiayouStartTime = convertView.findViewById(R.id.jiayou_start_time);
            viewHolder.jiayouEndTime = convertView.findViewById(R.id.jiayou_end_time);
            viewHolder.jiayouLeixing = convertView.findViewById(R.id.jiayou_leixing);
            viewHolder.jiayouDidian = convertView.findViewById(R.id.jiayou_didian);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        JiaYouJiRespBean.BringBean itemJiaYouJi = getItem(position);

        if (itemJiaYouJi != null) {

            viewHolder.jiayouStartTime.setText(itemJiaYouJi.getStartTime());
            viewHolder.jiayouEndTime.setText(itemJiaYouJi.getFinishTime());
            viewHolder.jiayouLeixing.setText(itemJiaYouJi.getNationalStandardName() + itemJiaYouJi.getOilName());
            viewHolder.jiayouDidian.setText(itemJiaYouJi.getRefuelAddress());
        }




        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean checked = viewHolder.jiayouCb.isChecked();
                viewHolder.jiayouCb.setChecked(!checked);
                getItem(position).setChecked(!checked);

                Log.i("=====", "onClick: ==>" + getItem(position).toString());
//                jiaYouJiClick.getJiaYouItem(viewHolder,position,getItem(position));


//                for (int i = 0; i <datas.size() ; i++) {
//                    boolean isChecked = getItem(i).isChecked();
//
//                    if (isChecked){
//                        viewHolder.jiayouCb.setChecked(isChecked);
//                        Log.i("选中", "onClick: "+position);
//                    }else{
//                        viewHolder.jiayouCb.setChecked(isChecked);
//                        Log.i("未选中", "onClick: "+position);
//                    }
//
//                }

            }
        });


        return convertView;
    }


    public List<JiaYouJiRespBean.BringBean>  getAllDatas(){

        return datas;
    }

//    OnJiaYouJiClick jiaYouJiClick;
//
//    public void setOnJiaYouJiClick(OnJiaYouJiClick jiaYouJiClick){
//     this.jiaYouJiClick=jiaYouJiClick;
//    }
//
//    public void setOnJiaItem(int clickPos) {
//
//
//
//    }


//    public interface OnJiaYouJiClick {
//
//        void getJiaYouItem(ViewHolder holder,int position,JiaYouJiRespBean.BringBean bringBean);
//
//    }

    public static class ViewHolder {
        CheckBox jiayouCb;
        TextView jiayouStartTime;
        TextView jiayouEndTime;
        TextView jiayouLeixing;
        TextView jiayouDidian;
        RelativeLayout allItem;
    }
}
