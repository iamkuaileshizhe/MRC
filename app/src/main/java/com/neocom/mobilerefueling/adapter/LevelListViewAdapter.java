package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.AddressBean;

import java.util.List;

/**
 * Success is the sum of small efforts, repeated day in and day out.
 * 成功就是日复一日那一点点小小努力的积累。
 */
public class LevelListViewAdapter extends BaseAdapter {
    private Context mContext;
    private View.OnClickListener onClickListener;
    private OnItemClickListener mOnItemClickListener;
    private int selectedPos = -1;
    private String selectedText = "";
    private AddressBean itemBeanSelected=new AddressBean();
    private List<AddressBean> mData;

    public LevelListViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public LevelListViewAdapter(Context context, List<AddressBean> level) {
        this.mContext=context;
        this.mData=level;
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPos = (Integer) view.getTag();
                setSelectedPosition(selectedPos);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, selectedPos);
                }
            }
        };
    }
    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }
    @Override
    public AddressBean getItem(int position) {
        return mData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 设置选中的position,但不通知刷新
     */
    public void setSelectedPositionNoNotify(int pos,List<AddressBean> level) {
        selectedPos = pos;
        mData = level;
        if (mData != null && pos < mData.size()) {
//            selectedText = mData.get(pos).getPlacename();
            selectedText = mData.get(pos).getTypeName();
        }
    }
    /**
     * 设置选中的position,并通知刷新其它列表
     */
    public void setSelectedPosition(int pos) {
        if (mData != null && pos < mData.size()) {
            selectedPos = pos;
//            selectedText = mData.get(pos).getPlacename();
            selectedText = mData.get(pos).getTypeName();
            notifyDataSetChanged();
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.adapter_levellistview, null);
        TextView continent_text = (TextView) view.findViewById(R.id.continent_text);
//        String placeName = mData.get(position).getPlacename();
        String placeName = mData.get(position).getTypeName();
        continent_text.setText(placeName);
        if (selectedText != null && selectedText.equals(placeName)) {
            continent_text.setBackgroundResource(R.drawable.choose_item_selected);
            Log.i("选择的是=>>", "getView: "+selectedText);
            itemBeanSelected= mData.get(position);
        } else {
            continent_text.setBackgroundResource(R.drawable.choose_eara_item_selector);
//            Log.i("选择的是=>>置空", "getView: "+selectedText);
        }
        view.setTag(position);
        view.setOnClickListener(onClickListener);

//        Log.i("选择的是=确定>>", "getView: ====>"+selectedText);

        return view;
    }
    /**
     * 重新定义菜单选项单击接口
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }

    public AddressBean ItemSelected(){



        return itemBeanSelected;
    }

}
