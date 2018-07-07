package com.neocom.mobilerefueling.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.neo.mobilerefueling.R;
//import com.neo.mobilerefueling.bean.FindOilPriceRespBean;
//
//import java.util.List;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.FindOilPriceRespBean;
import com.neocom.mobilerefueling.utils.KeyBoardUtil;

import java.math.BigDecimal;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/12/23.
 */

public class ZhiXingPriceAdapter extends RecyclerView.Adapter<ZhiXingPriceAdapter.ZXPriceViewHolder> {

    List<FindOilPriceRespBean.BringBean> datas;
    Context context;
    String roleCode;
    private final LayoutInflater mLayoutInflater;


    //    private boolean isFirstLoad = true;
    private int digits = 2;
    private boolean flag = true;

    public ZhiXingPriceAdapter(List<FindOilPriceRespBean.BringBean> datas, String roleCode, Context context) {
        this.datas = datas;
        this.context = context;
        this.roleCode = roleCode;
        mLayoutInflater = LayoutInflater.from(context);
    }

    //
    @Override
    public ZXPriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZXPriceViewHolder(mLayoutInflater.inflate(R.layout.yhjg_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final ZXPriceViewHolder holder, final int position) {
        FindOilPriceRespBean.BringBean bringBean = datas.get(position);
        holder.oilType.setText(bringBean.getGBName() + bringBean.getOilTypeName());
        holder.oilGuobiao.setText(bringBean.getAreaPrice() + "元");

        if (roleCode.equals("2")) {
            holder.oilPriceTv.setText(bringBean.getPrePrice() + "元");

            holder.oilPriceTv.setBackgroundDrawable(null);
            holder.oilCountEt.setText(bringBean.getPerformAmount() + "元");

        }

        if (roleCode.equals("1")) {

            holder.oilPriceTv.setBackgroundResource(R.drawable.et_bg);
            holder.oilPriceTv.setHint("请输入金额");
            holder.oilPriceTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Toast.makeText(context, "点击改价", Toast.LENGTH_SHORT).show();
//                isFirstLoad = false;
                    showInputDialog(holder, position);


                }
            });


        }


    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public List<FindOilPriceRespBean.BringBean> getZXJGData() {
        return datas;
    }

    public static class ZXPriceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.oil_type)
        TextView oilType;
        @BindView(R.id.oil_guobiao)
        TextView oilGuobiao;
        @BindView(R.id.oil_price_tv)
        TextView oilPriceTv;
        @BindView(R.id.oil_count_et)
        TextView oilCountEt;
        //        @BindView(R.id.iv_delete)
//        ImageView ivDelete;
        @BindView(R.id.lv_container)
        LinearLayout lvContainer;
//        @BindView(R.id.cv_item)
//        CardView cvItem;


        public ZXPriceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

    //    BigDecimal maxInout;
    private boolean canOKClick = false;

    private void showInputDialog(final ZXPriceViewHolder holder, final int position) {
//      final   BigDecimal before;
        final AlertDialog alertDialog;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.zxjg_edit_layout, null, false);
        builder.setView(view);
//        builder.setTitle("输入修改金额");
        builder.setCancelable(false);
        alertDialog = builder.create();

        String areaPrice = datas.get(position).getAreaPrice();// 修改之前价格

        final BigDecimal before = new BigDecimal(areaPrice);


        final EditText jineEt = view.findViewById(R.id.jine_et_input);

        view.findViewById(R.id.xg_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cunJinE = jineEt.getText().toString().trim();

                if (TextUtils.isEmpty(cunJinE)) {
                    Toast.makeText(context, "请输入金额", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (canOKClick) {
                    return;
                }

                BigDecimal cutCount = new BigDecimal(cunJinE);


                String zxPrice = before.subtract(cutCount).toString();

                datas.get(position).setPrePrice(cutCount.toString());
                datas.get(position).setPerformAmount(zxPrice);

                alertDialog.dismiss();
                notifyItemChanged(position);
                showAndHideInout(false);

            }
        });

        view.findViewById(R.id.xg_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


        alertDialog.show();
        showAndHideInout(true);


        jineEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //删除“.”后面超过2位后的数据
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > digits) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + digits + 1);
                        jineEt.setText(s);
                        jineEt.setSelection(s.length()); //光标移到最后
                    }
                }
                //如果"."在起始位置,则起始位置自动补0
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    jineEt.setText(s);
                    jineEt.setSelection(2);
                }

                //如果起始位置为0,且第二位跟的不是".",则无法后续输入
                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        jineEt.setText(s.subSequence(0, 1));
                        jineEt.setSelection(1);
                        return;
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!TextUtils.isEmpty(s.toString()) && flag) {
                    BigDecimal result;
                    String temp = s.toString();
                    int posDot = temp.indexOf(".");
                    try {
                        if (posDot == s.length() - 1) {
                            return;
                        }
                        result = new BigDecimal(s.toString());
                    } catch (Exception e) {
                        return;
                    }

//                    //不允许超出最大值
                    if (result.compareTo(before) == 1) {
                        temp = before.toString();
//                        ToastUtils.show("当前最多转出" + totalAmountStr + "元");
                        Toast.makeText(context, "最多修改为" + before + "元", Toast.LENGTH_SHORT).show();
                        canOKClick = true;
                    } else {
                        canOKClick = false;
                    }

                    //保留两位小数
                    flag = false;
                    s.clear();
                    if (posDot > 0 && temp.length() - posDot - 1 > 2) {
                        temp = temp.substring(0, posDot + 3);
                    }
                    s.append(temp);
                    flag = true;
                }


            }
        });


    }


    private void showAndHideInout(final boolean isShow) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Activity activity = getActivity();
//                KeyBoardUtil.hide(activity);

                if (isShow) {
                    KeyBoardUtil.show((Activity) context);
                } else {
                    KeyBoardUtil.hide((Activity) context);
                }


            }
        }, 200);

    }


}
