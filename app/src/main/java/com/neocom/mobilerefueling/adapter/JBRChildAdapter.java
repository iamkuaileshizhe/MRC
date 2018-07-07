package com.neocom.mobilerefueling.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.Gson;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.ChildItemBean;
import com.neocom.mobilerefueling.bean.ChildTagBean;
import com.neocom.mobilerefueling.bean.JBRConListBean;
import com.neocom.mobilerefueling.bean.LabelDataBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.processor.JingBanRenSPActivity;
import com.neocom.mobilerefueling.processor.profragment.MultiBottomFragment;
import com.neocom.mobilerefueling.utils.GetOrderStateUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.JsonStringToIdBeanUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.view.MultiLineEditText;
import com.neocom.mobilerefueling.view.isEditeTextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/4/24.
 * <p>
 * 经办人 菜单 展示 适配器
 */

public class JBRChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<LabelDataBean> labelData;
    private Context context;
    private int parentPosition;
    private final int TYPE_SINGLE_LINE_TEXT = 0;// 单行文本
    private final int TYPE_SELECT = 1; //  下拉选择
    private final int TYPE_DATE_PICKER = 2; // 日期选择器
    private final int TYPE_MULTY_TV = 3; // 多行文本框
    private final int TYPE_MULTY_SELECT = 4; // 多选
    private final int TYPE_NONE = -1;// 服务器 没有返回 任何类型
    JBRConListBean jbrConListBean;
    List<JBRConListBean> conList;
    //    RecyclerView.LayoutManager manager;
    LinearLayoutManager manager;

    private String oilPrice;
    private String oilAmount;


    public JBRChildAdapter(Context context, LinearLayoutManager manager, List<LabelDataBean> labelData, int parentPosition, JBRConListBean jbrConListBean, List<JBRConListBean> conList) {
        this.labelData = labelData;

        LogUtils.i("孩子的 =labelData=》" + new Gson().toJson(labelData));

        this.context = context;
        this.parentPosition = parentPosition;
        this.jbrConListBean = jbrConListBean;
        this.conList = conList;
        this.manager = manager;
    }

    @Override
    public int getItemViewType(int position) {
        String colType = labelData.get(position).getColType();
        if (!TextUtils.isEmpty(colType)) {

//            codeRule simple text

            if (colType.equals("codeRule") || colType.equals("simple") || colType.equals("text")) {

                return TYPE_SINGLE_LINE_TEXT;
            } else if (colType.equals("select")) {

                return TYPE_SELECT;

            } else if (colType.equals("time")) {

                return TYPE_DATE_PICKER;
            } else if (colType.equals("textarea")) {

                return TYPE_MULTY_TV;
            } else if (colType.equals("multiSelect")) {

                return TYPE_MULTY_SELECT;
            } else {
                return TYPE_NONE;
            }

        } else {
            return TYPE_NONE;
        }

    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if (viewType == TYPE_NONE) {
            View view = View.inflate(context, R.layout.jbr_child_item_layout, null);

            JBRChildViewHolder childViewHolder = new JBRChildViewHolder(view);

            return childViewHolder;

        } else {

            View view;
            if (viewType == TYPE_SINGLE_LINE_TEXT) {

//                View view = View.inflate(context, R.layout.jbr_child_item_layout, null);
                view = getView(R.layout.jbr_child_item_layout);

                JBRChildViewHolder childViewHolder = new JBRChildViewHolder(view);

                return childViewHolder;

            } else if (viewType == TYPE_SELECT) {

                view = getView(R.layout.jbr_child_item_menu_layout);
                SelectListDownViewHolder selectListDownViewHolder = new SelectListDownViewHolder(view);

                return selectListDownViewHolder;
            } else if (viewType == TYPE_DATE_PICKER) {


                view = getView(R.layout.jbr_child_timechoose_layout);

                TimePickerViewHolder timePickerViewHolder = new TimePickerViewHolder(view);

                return timePickerViewHolder;
            } else if (viewType == TYPE_MULTY_TV) {

                view = getView(R.layout.jbr_child_multy_layout);

                MultyInputViewHolder multyInputViewHolder = new MultyInputViewHolder(view);

                return multyInputViewHolder;
            } else if (viewType == TYPE_MULTY_SELECT) {
                view = getView(R.layout.jbr_child_multychoose_layout);
                MultyChooseViewHolder multyChooseViewHolder = new MultyChooseViewHolder(view);
                return multyChooseViewHolder;
            } else {
                view = View.inflate(context, R.layout.jbr_child_item_layout, null);

                JBRChildViewHolder childViewHolder = new JBRChildViewHolder(view);

                return childViewHolder;
            }

        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        LabelDataBean labelDataBean = labelData.get(position);
//        String colname = labelDataBean.getColname();
//        holder.itemView.setTag(new ChildTagBean(position, colname)); // 给 每一个 View 打标记
        holder.itemView.setTag(position); // 给 每一个 View 打标记

        if (holder instanceof JBRChildViewHolder) {


            JBRChildViewHolder childViewHolder = (JBRChildViewHolder) holder;
            childViewHolder.isEditeTextView.setTag(position);
            setJBRChildViewHolder(childViewHolder, position);


        } else if (holder instanceof SelectListDownViewHolder) {

            SelectListDownViewHolder selectListDownViewHolder = (SelectListDownViewHolder) holder;
            selectListDownViewHolder.showDropDown.setTag(position);
            setSelectListDownViewHolder(selectListDownViewHolder, position);
        } else if (holder instanceof TimePickerViewHolder) {

            TimePickerViewHolder timePickerViewHolder = (TimePickerViewHolder) holder;

            setTimePickerViewHolder(timePickerViewHolder, position);
        } else if (holder instanceof MultyInputViewHolder) {
            MultyInputViewHolder multyInputViewHolder = (MultyInputViewHolder) holder;
            multyInputViewHolder.multiLineEditText.setTag(position);
            setMuiltyViewHolder(multyInputViewHolder, position);

        } else if (holder instanceof MultyChooseViewHolder) {

            LogUtils.i("----多选-");
            MultyChooseViewHolder multyChooseViewHolder = (MultyChooseViewHolder) holder;

            setMultiChoose(multyChooseViewHolder, position);

        }


//        ((JBRChildViewHolder) holder).isEditeTextView.setContent(labelData.get(position).getColtext());


    }

    private void setMultiChoose(final MultyChooseViewHolder multyChooseViewHolder, final int position) {

        LogUtils.i("-------调起来 多选--");

        final LabelDataBean dataBean = labelData.get(position);

        final List<ChildItemBean> childItemBeen = (List<ChildItemBean>) dataBean.getDataValue();


        multyChooseViewHolder.multiTitle.setText(dataBean.getColtext());

        String showValue = dataBean.getShowValue();
        if (!TextUtils.isEmpty(showValue)) {

            multyChooseViewHolder.multiContent.setText(showValue);
        }

        multyChooseViewHolder.multiContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Map<String, String> stringMap = new HashMap<>();
                final MultiBottomFragment bottomFragment = new MultiBottomFragment();
                Bundle bundle = new Bundle();
                bundle.putString("multiChoose", GsonUtil.GsonString(childItemBeen));
                bottomFragment.setArguments(bundle);

                bottomFragment.show(((JingBanRenSPActivity) context).getSupportFragmentManager(), String.valueOf(position));

                bottomFragment.setOnDataChange(new MultiBottomFragment.onNotifyDataChange() {
                    @Override
                    public void DataChange(List<ChildItemBean> selectDatas) {

                        LogUtils.i("---" + GsonUtil.GsonString(selectDatas));


                        StringBuilder carNums = new StringBuilder();
                        for (int i = 0; i < selectDatas.size(); i++) {
                            ChildItemBean itemBean = selectDatas.get(i);

                            String itemValue = itemBean.getItemValue();
                            StringBuilder append = carNums.append(itemValue);

                            if (i != selectDatas.size() - 1) {
                                append.append(",");

                            }

                        }

                        multyChooseViewHolder.multiContent.setText(carNums.toString());

//                        if (TextUtils.isEmpty(carNums.toString())){
//                            multyChooseViewHolder.multiLineEditText.setContent(carNums.toString());
//                        }

                        stringMap.put(dataBean.getColname(), carNums.toString());

                        setListData(position, stringMap);
                    }
                });


            }
        });


    }

    private void setMuiltyViewHolder(MultyInputViewHolder multyInputViewHolder, final int position) {

//        List<LabelDataBean> labelData = jbrConListBean.getLabelData();
//        labelData.get(parentPosition).get

        int tagPos = (int) multyInputViewHolder.multiLineEditText.getTag();
//        ChildTagBean childTagBean = (ChildTagBean) multyInputViewHolder.multiLineEditText.getTag();

        LogUtils.i("=tag==" + tagPos + ";;" + position);

        if (position == tagPos) {
            final LabelDataBean dataBean = this.labelData.get(position);

            final Map<String, String> stringMap = new HashMap<>();
            String coltext = dataBean.getColtext();
            String dataValue = (String) dataBean.getDataValue();
            String isEditor = dataBean.getIsEditor();


            if (isEditor.equals(Constant.TV_CAN_EDIT)) {
                multyInputViewHolder.multiLineEditText.isEdit(true);
            } else {
                multyInputViewHolder.multiLineEditText.isEdit(false);
            }

            String value = dataBean.getValue();

            LogUtils.i("--输入框中的->>>" + value + ";位置;" + position + "；父为之；" + parentPosition + ";bean;" + GsonUtil.GsonString(dataBean));

            if (TextUtils.isEmpty(value)) {
                multyInputViewHolder.multiLineEditText.setContent("");

            } else {
                multyInputViewHolder.multiLineEditText.setContent(value);


            }


            if (TextUtils.isEmpty(coltext)) {
                multyInputViewHolder.multiLineEditText.setTitle("");

            } else {
                multyInputViewHolder.multiLineEditText.setTitle(coltext);

            }


            RxTextView.textChanges(multyInputViewHolder.multiLineEditText.getNoteInfoEdittext())
                    .debounce(1, TimeUnit.SECONDS)
//                    .skip(1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CharSequence>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(CharSequence value) {

                            stringMap.put(dataBean.getColname(), value.toString());

                            setListData(position, stringMap);


                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }


    }


    private void setTimePickerViewHolder(TimePickerViewHolder timePickerViewHolder, int position) {


        LabelDataBean dataBean = labelData.get(position);

        String coltext = dataBean.getColtext();
        String value = dataBean.getValue();

        String isEditor = dataBean.getIsEditor();

        if (!TextUtils.isEmpty(isEditor) && isEditor.equals(Constant.TV_CAN_EDIT)) {

            timePickerViewHolder.timeChooseStv.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
                @Override
                public void onClickListener(SuperTextView superTextView) {

                    pvCustomTime.show();
                }
            });
            timePickerViewHolder.timeChooseStv.setRightIcon(R.drawable.arrow_down);

        } else {
            timePickerViewHolder.timeChooseStv.setOnSuperTextViewClickListener(null);
            timePickerViewHolder.timeChooseStv.setRightIcon(null);
        }

        if (TextUtils.isEmpty(value)) {
            String time = getTime(new Date());

            timePickerViewHolder.timeChooseStv.setLeftString(coltext);

            timePickerViewHolder.timeChooseStv.setRightString(time);

            //  时间选择  ViewHolder
            initCustomTimePicker(timePickerViewHolder, position, time);

//            timePickerViewHolder.timeChooseStv.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
//                @Override
//                public void onClickListener(SuperTextView superTextView) {
//
//                    pvCustomTime.show();
//                }
//            });
//            timePickerViewHolder.timeChooseStv.setRightIcon(R.drawable.arrow_down);
        } else {

            timePickerViewHolder.timeChooseStv.setLeftString(coltext);
            timePickerViewHolder.timeChooseStv.setRightString(value);
//            timePickerViewHolder.timeChooseStv.setRightIcon(null);
//            timePickerViewHolder.timeChooseStv.setOnSuperTextViewClickListener(null);
            //  时间选择  ViewHolder
//            initCustomTimePicker(timePickerViewHolder, position, value);

        }


    }


    private void setSelectListDownViewHolder(final SelectListDownViewHolder selectListDownViewHolder, final int position) {
// 时间 选择 控件 ViewHolder

        LabelDataBean dataBean = labelData.get(position);
//      final   List<ChildItemBean> childItemBeen=null;

        Object dataValue = dataBean.getDataValue();

        LogUtils.i("=======" + new Gson().toJson(dataValue));
        String s = new Gson().toJson(dataValue);

        String coltext = dataBean.getColtext();
        selectListDownViewHolder.showDropDown.setLeftString(coltext);
        if (s != null && s.length() > 0) {

            if (!s.contains("[]")) {

                final List<ChildItemBean> childItemBeen = (List<ChildItemBean>) dataValue;


                String value = dataBean.getValue();
                String showValue = dataBean.getShowValue();
                final Map<String, String> stringMap = new HashMap<>();
                if (TextUtils.isEmpty(showValue)) {

//                    String itemsNameByName = getItemsNameByName(value, childItemBeen);
//                    selectListDownViewHolder.showDropDown.setRightString(itemsNameByName);
                    selectListDownViewHolder.showDropDown.setRightString(value);

                    String colname = labelData.get(position).getColname();
                    String isEditor = labelData.get(position).getIsEditor();
                    stringMap.put(colname, value);
                    LogUtils.i("这里看 条件" + JingBanRenSPActivity.chuRuKuType + ";isEditor;" + isEditor);
                    if (JingBanRenSPActivity.chuRuKuType.equals("0") && !TextUtils.isEmpty(isEditor) && isEditor.equals(Constant.TV_CAN_EDIT)) {
                        setListData(position, stringMap);
                    }


                } else {

                    selectListDownViewHolder.showDropDown.setRightString(showValue);

                    String colname = labelData.get(position).getColname();
                    String isEditor = labelData.get(position).getIsEditor();
                    String value1 = labelData.get(position).getValue();
                    stringMap.put(colname, value1);
                    LogUtils.i("这里看 条件" + JingBanRenSPActivity.chuRuKuType + ";isEditor;" + isEditor);
                    if (JingBanRenSPActivity.chuRuKuType.equals("0") && !TextUtils.isEmpty(isEditor) && isEditor.equals(Constant.TV_CAN_EDIT)) {
                        setListData(position, stringMap);
                    }
                }
            }


        }

        String isEditor = dataBean.getIsEditor();

        if (isEditor.equals(Constant.TV_CAN_EDIT)) {


            selectListDownViewHolder.showDropDown.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
                @Override
                public void onClickListener(SuperTextView superTextView) {


                    LabelDataBean dataBean = labelData.get(position);

                    Object dataValue = dataBean.getDataValue();

                    List<ChildItemBean> childItemBeen1 = (List<ChildItemBean>) dataValue;
                    if (childItemBeen1 != null && childItemBeen1.size() > 0) {

                        showPopItems(childItemBeen1, selectListDownViewHolder, selectListDownViewHolder.showDropDown, position);

                    } else {
                        Toast.makeText(context, "暂无数据", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        } else {

            selectListDownViewHolder.showDropDown.setOnSuperTextViewClickListener(null);
            selectListDownViewHolder.showDropDown.setRightIcon(null);


        }


    }


    public String getItemsNameByName(String value, List<ChildItemBean> dataList) {


        if (dataList != null && dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {

                ChildItemBean childItemBean = dataList.get(i);

                if (value.equals(childItemBean.getItemId())) {

                    return childItemBean.getItemValue();
                }

            }
            return "";
        } else {

            return "";

        }


    }


    private PopupWindow popLeft;
    private View layoutLeft;
    private ListView menulistLeft;

    private void showPopItems(List<ChildItemBean> datas, final SelectListDownViewHolder selectListDownViewHolder, final View parenr, final int parentItemPos) {
        if (datas == null && datas.size() == 0) {
            return;
        }

//        if (canSuperTextViewClick) {
//            return;
//        }
        final Map<String, String> stringMap = new HashMap<>();
        if (popLeft != null && popLeft.isShowing()) {
            popLeft.dismiss();
        } else {

            layoutLeft = View.inflate(context, R.layout.pop_menulist, null);
            menulistLeft = (ListView) layoutLeft.findViewById(R.id.menulist);

            final IBRChildDropDownAdapter adapter = new IBRChildDropDownAdapter(context, datas);
            menulistLeft.setAdapter(adapter);

            menulistLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                    Toast.makeText(context, "选择的是" + adapter.getItem(position).toString(), Toast.LENGTH_SHORT).show();

//                    String chooseStr = adapter.getItem(position).getItemValue();

                    String chooseStr = "";
                    ChildItemBean item = adapter.getItem(position);

//                    String itemType = item.getItemType();

//                    if (TextUtils.isEmpty(itemType)) {
//                        return;
//                    }
//                    if (itemType.equals(Constant.DIC_BEAN)) {
//                        chooseStr = item.getItemValue();
//                    } else if (itemType.equals(Constant.ID_BEAN)) {
//                        chooseStr = item.getItemId();
//                    } else {
//                        chooseStr = item.getItemId();
//                    }
//                    chooseStr = item.getItemValue();
                    chooseStr = item.getItemId();
//                    Toast.makeText(context, chooseStr, Toast.LENGTH_SHORT).show();
                    selectListDownViewHolder.showDropDown.setRightString(item.getItemValue());
                    String colname = labelData.get(parentItemPos).getColname();
                    stringMap.put(colname, chooseStr);
//                    ((JingBanRenSPActivity) context).saveListData(parentPosition, position, stringMap);

                    if (!TextUtils.isEmpty(colname)) {

                        String itemTelephone = item.getItemTelephone();

                        fillAndshowData(selectListDownViewHolder, colname, parentItemPos, item);

                    }

                    setListData(position, stringMap);
                    // 隐藏弹出窗口
                    if (popLeft != null && popLeft.isShowing()) {
                        popLeft.dismiss();
                    }


                }
            });


            // 创建弹出窗口
            // 窗口内容为layoutLeft，里面包含一个ListView
            // 窗口宽度跟tvLeft一样
            popLeft = new PopupWindow(layoutLeft, parenr.getWidth(),
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
            int topBarHeight = parenr.getBottom();
            popLeft.showAsDropDown(parenr, 0,
                    2);
//            (topBarHeight - parenr.getHeight()) / 2
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

    private void fillAndshowData(SelectListDownViewHolder selectListDownViewHolder, String colnameValue, int parentPos, ChildItemBean itemChoose) {

//        ChildTagBean childTagBean = (ChildTagBean) selectListDownViewHolder.itemView.getTag();

        int childCount = manager.getChildCount();

//        int tagPos = (int) selectListDownViewHolder.itemView.getTag();
//        ChildTagBean childTagBean = (ChildTagBean) selectListDownViewHolder.itemView.getTag();

//        LogUtils.i("--获取的tag--" + GsonUtil.GsonString(childTagBean));


//        int position = childTagBean.getPosition();
//        String key = childTagBean.getKey();


        if (colnameValue.equals("form_supplier")) {

            for (int i = 0; i < labelData.size(); i++) {

                LabelDataBean dataBean = labelData.get(i);

                if (dataBean != null && !TextUtils.isEmpty(dataBean.getColname())) {

                    LogUtils.i("--------点我 赋值--form_phone--");

                    String colname = dataBean.getColname();
                    if (colname.equals("form_phone")) {
                        final Map<String, String> stringMapPhone = new HashMap<>();
                        if (itemChoose != null) {
                            String itemTelephone = itemChoose.getItemTelephone();
                            dataBean.setValue(itemTelephone);
                            notifyItemChanged(i);
                            stringMapPhone.put("form_phone", itemTelephone);
                            setListData(parentPos, stringMapPhone);
                        }


                    }
                    if (colname.equals("form_contacts")) {
                        final Map<String, String> stringMapContacts = new HashMap<>();
                        if (itemChoose != null) {
                            String itemLinkman = itemChoose.getItemLinkMan();
                            dataBean.setValue(itemLinkman);
                            notifyItemChanged(i);
                            stringMapContacts.put("form_contacts", itemLinkman);
                            setListData(parentPos, stringMapContacts);
                        }

                    }

                    if (colname.equals("form_address")) {

                        LogUtils.i("--供应商地址-");
                        if (itemChoose != null) {
                            final Map<String, String> stringMapAddr = new HashMap<>();
                            LogUtils.i("地址item值" + GsonUtil.GsonString(itemChoose));
                            String itemAddress = itemChoose.getItemAddress();
                            dataBean.setValue(itemAddress);
                            dataBean.setShowValue(itemAddress);
                            notifyItemChanged(i);
                            stringMapAddr.put("form_address", itemAddress);
                            setListData(parentPos, stringMapAddr);
                        }


                    }
                    if (colname.equals("var_process_supplier")) {

                        if (itemChoose != null) {
//GetOrderStateUtil.getSupplierValue();
                            final Map<String, String> stringMapSupplier = new HashMap<>();
                            LogUtils.i("地址item值==var_process_supplier=" + GsonUtil.GsonString(itemChoose));
                            String itemSupplyStatus = itemChoose.getItemSupplyStatus();
                            dataBean.setValue(itemSupplyStatus);
                            dataBean.setShowValue(itemSupplyStatus);
                            notifyItemChanged(i);
                            stringMapSupplier.put("var_process_supplier", itemSupplyStatus);
                            setListData(parentPos, stringMapSupplier);
                        }

                    }
                    if (colname.equals("form_contract")) {

                        if (itemChoose != null) {
                            final Map<String, String> stringMapSupplier = new HashMap<>();
                            LogUtils.i("地址item值==contract=" + GsonUtil.GsonString(itemChoose));
//                            String contractId = itemChoose.getItemId();

//                            dataBean.setValue(itemSupplyStatus);
//                            dataBean.setShowValue(itemSupplyStatus);
//                            notifyItemChanged(i);
//                            stringMapSupplier.put("form_contract", itemSupplyStatus);
//                            setListData(parentPos, stringMapSupplier);

                            List<ChildItemBean> contractFilter = JsonStringToIdBeanUtil.contractFilter(itemChoose.getItemId());

                            dataBean.setDataValue(contractFilter);

                            notifyItemChanged(i);
                        }

                    }





                }


            }


        }


        if (colnameValue.equals("form_transport")) {

            final Map<String, String> stringMap = new HashMap<>();
            for (int i = 0; i < labelData.size(); i++) {

                LabelDataBean dataBean = labelData.get(i);

                if (dataBean != null && !TextUtils.isEmpty(dataBean.getColname())) {

                    LogUtils.i("--------点我 赋值--form_ysphone--");

                    String colname = dataBean.getColname();
                    if (colname.equals("form_ysphone")) {
                        String itemTelephone = itemChoose.getItemTelephone();
                        dataBean.setValue(itemTelephone);
                        notifyItemChanged(i);
                        stringMap.put(colname, itemTelephone);
                        setListData(parentPos, stringMap);
                    }

                    if (colname.equals("form_yscontact")) {
                        String itemLinkMan = itemChoose.getItemLinkMan();
                        dataBean.setValue(itemLinkMan);
                        notifyItemChanged(i);
                        stringMap.put(colname, itemLinkMan);
                        setListData(parentPos, stringMap);
                    }


                }


            }


        }


//        for (int i = 0; i < labelData.size(); i++) {
//            LabelDataBean dataBean = labelData.get(i);
//
//            if (dataBean != null && !TextUtils.isEmpty(dataBean.getColname())) {
//
//                String colname = dataBean.getColname();
//                if (colname.equals("form_phone") || colname.equals("form_yscontact")) {
////                if (key.equals("form_phone")) {
//
//                    LogUtils.i("--------点我 赋值--form_phone--");
////                    notifyDataSetChanged();
////                    notifyItemChanged(Integer.parseInt(dataBean.getShoworder()));
//
//                    if (childTagBean.getPosition() == parentPos) {
//
//                        LogUtils.i("==复制改变了==" + childTagBean.getPosition());
//                        dataBean.setValue(itemTelephone);
//                        notifyItemChanged(i);
//
//                    }
//
//
////                    manager.findViewByPosition()
//
//                }
//
//
////                String colname1 = dataBean.getColname();
////
////                if (colname1.equals("form_yscontact")) {
////
////                    dataBean.setValue(itemTelephone);
////                    LogUtils.i("--------点我 赋值-form_yscontact---");
//////                    notifyDataSetChanged();
////                    notifyItemChanged(Integer.parseInt(dataBean.getShoworder()));
////
////                }
//
//            }
//
//
//        }


    }


    private void setJBRChildViewHolder(final JBRChildViewHolder childViewHolder, final int position) {

//        Object dataValue = labelDataBean.getDataValue();

        final LabelDataBean labelDataBean = labelData.get(position);

        LogUtils.i("-->>>>::::" + GsonUtil.GsonString(labelDataBean));

//        Object dataValue = labelDataBean.getDataValue();
        String dataValue = labelDataBean.getValue();
        String defaultValue1 = labelDataBean.getDefaultValue();

        LogUtils.i("--常规孩子的 内容--" + new Gson().toJson(dataValue));
        LogUtils.i("--常规孩子的 内容--" + dataValue);


        if (TextUtils.isEmpty(dataValue)) {
//                    childViewHolder.isEditeTextView.setContent("");

            if (TextUtils.isEmpty(defaultValue1)) {
                childViewHolder.isEditeTextView.setContent("");
            } else {
                childViewHolder.isEditeTextView.setContent(defaultValue1);
            }

        } else {
            childViewHolder.isEditeTextView.setContent(dataValue);
        }


        final Map<String, String> stringMap = new HashMap<>();
        childViewHolder.isEditeTextView.setTitle(labelDataBean.getColtext());

        String defaultValue = labelDataBean.getDefaultValue();
        String value = labelDataBean.getValue();
        if (defaultValue.equals("#{hc_process_userName}") && TextUtils.isEmpty(value)) {

//            childViewHolder.isEditeTextView.setTitle(StaticUtils.App_RealName);
            childViewHolder.isEditeTextView.setContent(GetUserInfoUtils.getUserInfo().getUserName());

            stringMap.put(labelDataBean.getColname(), GetUserInfoUtils.getUserInfo().getUserName());

            setListData(position, stringMap);

        }

        String isEditor = labelDataBean.getIsEditor();

        LogUtils.i("==" + parentPosition + ";;" + position + ",," + isEditor);

        if (TextUtils.isEmpty(isEditor)) {
            childViewHolder.isEditeTextView.isEdit(false);
        } else {
            if (isEditor.equals(Constant.TV_CAN_EDIT)) {
                childViewHolder.isEditeTextView.isEdit(true);

            } else {
                childViewHolder.isEditeTextView.isEdit(false);
            }
        }

//        childViewHolder.isEditeTextView.setTag(position);


        RxTextView.textChanges(childViewHolder.isEditeTextView.getEdittext())
                .debounce(1, TimeUnit.SECONDS)
                .skip(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CharSequence>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        LogUtils.i("--开始 输入了--" + d.isDisposed());

                    }

                    @Override
                    public void onNext(CharSequence value) {

                        int tagPos = (int) childViewHolder.isEditeTextView.getTag();

                        if (tagPos==position){

                            stringMap.put(labelDataBean.getColname(), value.toString());

                            setListData(position, stringMap);
//                        ((JingBanRenSPActivity) context).saveListData(parentPosition, position, stringMap);


                            String colname = labelDataBean.getColname();

                            if (colname.equals("form_price")) {
                                oilPrice = value.toString();
                            }

                            if (colname.equals("form_buyoil")) {
                                oilAmount = value.toString();
                            }

                            if (colname.equals("form_price") || colname.equals("form_buyoil")) {
//购油价格(元/吨)

                                if (!TextUtils.isEmpty(oilPrice) && !TextUtils.isEmpty(oilAmount)) {


                                    BigDecimal oilPriceDecimal = new BigDecimal(oilPrice);
                                    BigDecimal oilAmountDecimal = new BigDecimal(oilAmount);

                                    BigDecimal oilCost = oilPriceDecimal.multiply(oilAmountDecimal);
                                    String costMoney = oilCost.toPlainString();
                                    if (!TextUtils.isEmpty(oilPrice) && !TextUtils.isEmpty(oilAmount)) {


                                        final Map<String, String> stringMap = new HashMap<>();
                                        for (int i = 0; i < labelData.size(); i++) {

                                            LabelDataBean dataBean = labelData.get(i);

                                            if (dataBean != null && !TextUtils.isEmpty(dataBean.getColname())) {

                                                LogUtils.i("--------点我 赋值--form_cost--");

                                                String colnameCost = dataBean.getColname();
                                                if (colnameCost.equals("form_cost")) {

                                                    dataBean.setValue(costMoney);
                                                    notifyItemChanged(i);
                                                    stringMap.put("form_cost", costMoney);
                                                    setListData(position, stringMap);
                                                }

                                            }


                                        }


                                    }

                                }
                            }



                        }



                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.i("onComplete");
                    }
                });


    }

    @Override
    public int getItemCount() {
        return labelData == null ? 0 : labelData.size();
    }

    private class TimePickerViewHolder extends RecyclerView.ViewHolder {

        SuperTextView timeChooseStv;

        public TimePickerViewHolder(View itemView) {
            super(itemView);
            timeChooseStv = itemView.findViewById(R.id.time_choose_stv);
        }
    }


    public class JBRChildViewHolder extends RecyclerView.ViewHolder {

        isEditeTextView isEditeTextView;

        public JBRChildViewHolder(View itemView) {
            super(itemView);

            isEditeTextView = itemView.findViewById(R.id.child_menu_text);

        }
    }


    private class SelectListDownViewHolder extends RecyclerView.ViewHolder {


        SuperTextView showDropDown;

        public SelectListDownViewHolder(View itemView) {
            super(itemView);

            showDropDown = itemView.findViewById(R.id.doropdown_choose_stv);

        }
    }


    private class MultyChooseViewHolder extends RecyclerView.ViewHolder {

        //        MultiLineEditText multiLineEditText;
        TextView multiTitle;
        TextView multiContent;

        public MultyChooseViewHolder(View itemView) {
            super(itemView);

//            multiLineEditText = itemView.findViewById(R.id.jbr_child_multichoose_tv);

            multiTitle = itemView.findViewById(R.id.multi_select_title);
            multiContent = itemView.findViewById(R.id.multi_select_title_content);


        }
    }

    private class MultyInputViewHolder extends RecyclerView.ViewHolder {

        MultiLineEditText multiLineEditText;

        public MultyInputViewHolder(View itemView) {
            super(itemView);

            multiLineEditText = itemView.findViewById(R.id.jbr_child_multi_tv);

        }
    }


    private View getView(int view) {
        View view1 = View.inflate(context, view, null);
        return view1;
    }


    private TimePickerView pvCustomTime;

    /**
     * 设置 时间范围
     */
    private void initCustomTimePicker(final TimePickerViewHolder timePickerViewHolder, final int position, final String time) {

        final Map<String, String> stringMap = new HashMap<>();
        stringMap.put(labelData.get(position).getColname(), time);
        setListData(position, stringMap);
        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
//        Calendar startDate = Calendar.getInstance();
//        startDate.set(2018, 2, 23,12,12);
//        Calendar endDate = Calendar.getInstance();
//        endDate.set(2018, 2, 28,13,13);

        Calendar startDate = Calendar.getInstance();
        startDate.set(selectedDate.get(GregorianCalendar.YEAR), selectedDate.get(GregorianCalendar.MONTH), selectedDate.get(GregorianCalendar.DAY_OF_MONTH), selectedDate.get(GregorianCalendar.HOUR), selectedDate.get(GregorianCalendar.MINUTE));
//        startDate.set(2018, 2, 23, 12, 12);

        long timeCurrent = System.currentTimeMillis();
//        startDate.setTimeInMillis(timeCurrent);
        Calendar endDate = Calendar.getInstance();

        endDate.set(selectedDate.get(GregorianCalendar.YEAR), selectedDate.get(GregorianCalendar.MONTH), selectedDate.get(GregorianCalendar.DAY_OF_MONTH), selectedDate.get(GregorianCalendar.HOUR) + 12, selectedDate.get(GregorianCalendar.MINUTE));
//        endDate.set(2018, 5, 28, 15, 15);

        pvCustomTime = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                timePickerViewHolder.timeChooseStv.setRightString(getTime(date));

//                Toast.makeText(context, "时间是" + getTime(date), Toast.LENGTH_SHORT).show();

                pvCustomTime.dismiss();

                stringMap.put(labelData.get(position).getColname(), time);
                setListData(position, stringMap);

            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentTextSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.animGravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();

                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, true, true, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .setOutSideCancelable(false)
                .build();

    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }


    private void setListData(int childPosition, Map<String, String> stringMap) {

//        Toast.makeText(context, "父类：" + parentPosition + ";孩子;" + childPosition, Toast.LENGTH_SHORT).show();
//        LogUtil.i("--值-->" + stringMap.);

        for (Map.Entry<String, String> entyy : stringMap.entrySet()) {

            LogUtils.i("==键=" + entyy.getKey() + ":值:" + entyy.getValue());

        }

        ((JingBanRenSPActivity) context).saveListData(parentPosition, childPosition, stringMap);

    }

}
