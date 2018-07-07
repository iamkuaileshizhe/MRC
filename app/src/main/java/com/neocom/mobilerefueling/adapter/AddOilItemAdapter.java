package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.SubmitOrderOilsBean;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import static com.widget.jcdialog.utils.ToastUitl.showToast;

/**
 * Created by admin on 2017/10/16.
 */

public class AddOilItemAdapter extends BaseAdapter {
    private Context context;
    private List<SubmitOrderOilsBean> oilsBeen;
    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;
    ListView listView;
//    private String InputAmount;

    public AddOilItemAdapter(Context context, ListView listView, List<SubmitOrderOilsBean> oilsBeen) {
        this.listView = listView;
        this.context = context;
        this.oilsBeen = oilsBeen;
    }

    @Override
    public int getCount() {
        return oilsBeen == null ? 0 : oilsBeen.size();
    }

    @Override
    public SubmitOrderOilsBean getItem(int i) {
        return oilsBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.add_oil_item_layout);
            holder = new ViewHolder(convertView, position);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SubmitOrderOilsBean item = getItem(position);
        holder.oilCountEt.setTag(position);
        holder.selectOilType.setText(GetOrderStateUtil.getOilType(item.getOilType()));
        holder.oilPriceTv.setText(item.getOilPrice());
        holder.selectOilType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "选择" + position, Toast.LENGTH_SHORT).show();
                showPopItem(holder.selectOilType, holder.oilPriceTv, holder.oilCountEt, position);

            }
        });

        holder.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "删除" + position, Toast.LENGTH_SHORT).show();

                if (getOilAmountListener != null) {
                    getOilAmountListener.GetOilAmount(getItem(position), position);
                }
                oilsBeen.remove(position);
                notifyDataSetChanged();
            }
        });


//        Log.i("输入的是：", "afterTextChanged=position " + position);
        holder.oilCountEt.addTextChangedListener(new MyWatcher(holder, position));


//        if (convertView != null) {
//            // 解决getview多次调用问题
//            if (((ListViewWithScroll) parent).isOnMeasure) {
//                return convertView;
//            }
//        }

        return convertView;
    }


    public class MyWatcher implements TextWatcher {
        int pos;
        ViewHolder holder;

        public MyWatcher(ViewHolder holder, int pos) {
            this.pos = pos;
            this.holder = holder;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.i("位置是", "beforeTextChanged: " + pos);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.i("位置是", "onTextChanged: " + pos);
        }

        @Override
        public void afterTextChanged(Editable editable) {
//            Log.i("输入的是：", "afterTextChanged: " + editable.toString() + ";;" + holder.oilCountEt.getText().toString());
            if (getOilAmountListener != null) {
//                Log.i("位置是", "afterTextChanged: " + pos);
//                Log.i("位置是", "afterTextChanged: 这是 第几个..pos." + pos + "；标记；" + holder.oilCountEt.getTag());
                if (pos == (int) holder.oilCountEt.getTag()) {
//                    Log.i("位置是=======", "afterTextChanged: 这是 第几个..pos." + pos + "；标记；" + holder.oilCountEt.getTag());

                    getItem(pos).setAmount(holder.oilCountEt.getText().toString().trim());
                    getOilAmountListener.GetOilAmount(getItem(pos), pos);

                }


//                    if (TextUtils.isEmpty(editable.toString())){
//                        InputAmount=holder.oilCountEt.getText().toString().trim();
//                    }else{
//                        InputAmount="0";
//                    }

            }
        }
    }

//    TextWatcher textWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            Log.i("位置是", "beforeTextChanged: "+position);
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            Log.i("位置是", "onTextChanged: "+position);
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            Log.i("输入的是：", "afterTextChanged: " + editable.toString() + ";;" + holder.oilCountEt.getText().toString());
//            if (getOilAmountListener != null) {
//                Log.i("位置是", "afterTextChanged: "+position);
//                getItem(position).setAmount(holder.oilCountEt.getText().toString().trim());
//                getOilAmountListener.GetOilAmount(getItem(position), position);
////                    if (TextUtils.isEmpty(editable.toString())){
////                        InputAmount=holder.oilCountEt.getText().toString().trim();
////                    }else{
////                        InputAmount="0";
////                    }
//
//            }
//        }
//    };


    private List<SubmitOrderOilsBean> orderItemOil = new ArrayList<>();

    private void showPopItem(final TextView viewType, final TextView viewPrice, final EditText oilCountEt, final int position) {

        if (orderItemOil.size() == 0) {
            SubmitOrderOilsBean oilsBean1 = new SubmitOrderOilsBean();

            oilsBean1.setOilType("1");
            oilsBean1.setOilPrice("1");
            oilsBean1.setAmount("1");
            orderItemOil.add(oilsBean1);
            SubmitOrderOilsBean oilsBean2 = new SubmitOrderOilsBean();

            oilsBean2.setOilType("2");
            oilsBean2.setOilPrice("2");
            oilsBean2.setAmount("2");
            orderItemOil.add(oilsBean2);

            SubmitOrderOilsBean oilsBean3 = new SubmitOrderOilsBean();

            oilsBean3.setOilType("3");
            oilsBean3.setOilPrice("3");
            oilsBean3.setAmount("3");
            orderItemOil.add(oilsBean3);
            SubmitOrderOilsBean oilsBean4 = new SubmitOrderOilsBean();

            oilsBean4.setOilType("4");
            oilsBean4.setOilPrice("4");
            oilsBean4.setAmount("4");
            orderItemOil.add(oilsBean4);
            SubmitOrderOilsBean oilsBean5 = new SubmitOrderOilsBean();

            oilsBean5.setOilType("5");
            oilsBean5.setOilPrice("5");
            oilsBean5.setAmount("5");
            orderItemOil.add(oilsBean5);
            SubmitOrderOilsBean oilsBean6 = new SubmitOrderOilsBean();

            oilsBean6.setOilType("6");
            oilsBean6.setOilPrice("6");
            oilsBean6.setAmount("6");
            orderItemOil.add(oilsBean6);

        }

        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {
            layoutLeft = UIUtils.inflate(
                    R.layout.pop_menulist);
            menulistLeft = (ListView) layoutLeft
                    .findViewById(R.id.menulist);

            final AddOilItemAdapterAdapter oilItemAdapterAdapter = new AddOilItemAdapterAdapter(orderItemOil);

            menulistLeft.setAdapter(oilItemAdapterAdapter);

            // 点击listview中item的处理
            menulistLeft
                    .setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0,
                                                View arg1, int arg2, long arg3) {
                            // 改变顶部对应TextView值
                            SubmitOrderOilsBean strItem = oilItemAdapterAdapter.getItem(arg2);

                            String pricr = strItem.getOilPrice();
                            String type = strItem.getOilType();
                            viewType.setText(GetOrderStateUtil.getOilType(type));
                            viewPrice.setText(pricr);
                            SubmitOrderOilsBean itemOrder = getItem(position);
                            itemOrder.setOilPrice(pricr);
                            itemOrder.setOilType(type);
                            if (getOilAmountListener != null) {
                                itemOrder.setAmount(oilCountEt.getText().toString().trim());
                                getOilAmountListener.GetOilAmount(itemOrder, position);
                            }

                            // 隐藏弹出窗口
                            if (popLeft != null && popLeft.isShowing()) {
                                popLeft.dismiss();
                            }
                        }
                    });

            // 创建弹出窗口
            // 窗口内容为layoutLeft，里面包含一个ListView
            // 窗口宽度跟tvLeft一样
            popLeft = new PopupWindow(layoutLeft, viewType.getWidth(),
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            ColorDrawable cd = new ColorDrawable(Color.BLACK);
            popLeft.setBackgroundDrawable(cd);
            popLeft.setAnimationStyle(R.style.PopupAnimation);
            popLeft.update();
            popLeft.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            popLeft.setTouchable(true); // 设置popupwindow可点击
            popLeft.setOutsideTouchable(true); // 设置popupwindow外部可点击
            popLeft.setFocusable(true); // 获取焦点

            // 设置popupwindow的位置（相对tvLeft的位置）
            int topBarHeight = viewType.getBottom();
            popLeft.showAsDropDown(viewType, 0,
                    (topBarHeight - viewType.getHeight()) / 2);

            popLeft.setTouchInterceptor(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // 如果点击了popupwindow的外部，popupwindow也会消失
                    if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                        popLeft.dismiss();
                        return true;
                    }
                    return false;
                }
            });
        }

    }

    class ViewHolder {
        TextView selectOilType;
        TextView oilPriceTv;
        EditText oilCountEt;
        ImageView itemDelete;

        public ViewHolder(View convertView, int position) {

            selectOilType = convertView.findViewById(R.id.select_oil_type);
            oilPriceTv = convertView.findViewById(R.id.oil_price_tv);
            oilCountEt = convertView.findViewById(R.id.oil_count_et);
            oilCountEt.setTag(position);
            itemDelete = convertView.findViewById(R.id.item_delete);


        }
    }


//    OnGetOilTypeValueListener onGetOilTypeValueListener;
//
//    public interface OnGetOilTypeValueListener {
//        void getOilTypeValue(int position,SubmitOrderOilsBean itemOrder);
//    }
//
//    public void setOnGetOilTypeValueListener(OnGetOilTypeValueListener onGetOilTypeValueListener) {
//        this.onGetOilTypeValueListener = onGetOilTypeValueListener;
//    }

    OnGetOilAmountListener getOilAmountListener;

    public interface OnGetOilAmountListener {
        void GetOilAmount(SubmitOrderOilsBean orderOilsBean, int position);
    }

    public void setOnGetOilAmountListener(OnGetOilAmountListener getOilAmountListener) {
        this.getOilAmountListener = getOilAmountListener;
    }
}
