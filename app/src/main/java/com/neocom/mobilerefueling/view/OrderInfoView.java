package com.neocom.mobilerefueling.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.widget.jcdialog.bean.PopuBean;
import com.widget.jcdialog.listener.TdataListener;
import com.widget.jcdialog.widget.PopuWindowView;

import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;

import java.util.List;

import static com.widget.jcdialog.utils.ToastUitl.showToast;

/**
 * Created by admin on 2017/8/10.
 */

public class OrderInfoView extends RelativeLayout implements View.OnClickListener {


    Context context;
    private TextView carOilType;
    private TextView carNum;
    private TextView carOilCount;
    private TextView carDriverName;
    private TextView carDriverPhone;
    private CheckBox carSelect;
    private RelativeLayout orderRlOilType;

    public OrderInfoView(Context context) {
        super(context);
        initView(context);

    }


    public OrderInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public OrderInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {

        this.context = context;

        View.inflate(context, R.layout.order_info_layout, OrderInfoView.this);
        // 车牌号
        carNum = this.findViewById(R.id.order_layout_carnum);
        // 车牌号
        carOilType = this.findViewById(R.id.order_tv_choose_oil);
        // 车牌号
        carOilCount = this.findViewById(R.id.order_tv_oil_num);
        // 车牌号
        carDriverName = this.findViewById(R.id.order_tv_driver_name);
        // 车牌号
        carDriverPhone = this.findViewById(R.id.order_tv_phone);
        TextView carOilCountMinus = this.findViewById(R.id.order_tv_minus);// 车牌号
        TextView carOilCountPlus = this.findViewById(R.id.order_tv_plus);// 车牌号

        carSelect = this.findViewById(R.id.order_layout_cb);

        orderRlOilType = this.findViewById(R.id.order_rl_oil_type);

        carOilType.setOnClickListener(this);
        orderRlOilType.setOnClickListener(this);

    }

    public void setCbVisibility(int visibility) {

        carSelect.setVisibility(visibility);

    }

    public void setCarNumText(String carNumText) {

        if (!TextUtils.isEmpty(carNumText)) {
            carNum.setText(carNumText);
        } else {
            carNum.setText("");
        }

    }

    public void setCarOilTypeText(String oilTypeText) {

        if (!TextUtils.isEmpty(oilTypeText)) {
            carOilType.setText(oilTypeText);
        } else {
            carOilType.setText("");
        }

    }

    public void setCarOilCountText(String oilCountText) {

        if (!TextUtils.isEmpty(oilCountText)) {
            carOilCount.setText(oilCountText);
        } else {
            carOilCount.setText("");
        }

    }

    public void setCarDriverText(String carDriverNameText) {

        if (!TextUtils.isEmpty(carDriverNameText)) {
            carDriverName.setText(carDriverNameText);
        } else {
            carDriverName.setText("");
        }

    }

    public void setCarDriverPhoneText(String carDriverPhoneText) {

        if (!TextUtils.isEmpty(carDriverPhoneText)) {
            carDriverPhone.setText(carDriverPhoneText);
        } else {
            carDriverPhone.setText("");
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.order_tv_choose_oil:
            case R.id.order_rl_oil_type:

                showOilTypePop();


                break;

        }
    }

    private void showOilTypePop() {
        final PopuWindowView popuWindowView = new PopuWindowView(context, LinearLayout.LayoutParams.MATCH_PARENT);
        popuWindowView.initPupoData(new TdataListener() {
            @Override
            public void initPupoData(List<PopuBean> lists) {
//                for (int i = 0; i < 5; i++) {
//                    PopuBean popu = new PopuBean();
//                    popu.setTitle("item" + i);
//                    popu.setId(i);
//                    lists.add(popu);
//                }


                PopuBean oilType1 = new PopuBean();
                oilType1.setTitle("5号柴油");
                oilType1.setId(1);
                lists.add(oilType1);
                PopuBean oilType2 = new PopuBean();
                oilType2.setTitle("0号柴油");
                oilType2.setId(2);
                lists.add(oilType2);
                PopuBean oilType3 = new PopuBean();
                oilType3.setTitle("-10号柴油");
                oilType3.setId(3);
                lists.add(oilType3);
                PopuBean oilType4 = new PopuBean();
                oilType4.setTitle("-20号柴油");
                oilType4.setId(4);
                lists.add(oilType4);
                PopuBean oilType5 = new PopuBean();
                oilType5.setTitle("-35号柴油");
                oilType5.setId(5);
                lists.add(oilType5);
                PopuBean oilType6 = new PopuBean();
                oilType6.setTitle("-50号柴油");
                oilType6.setId(6);
                lists.add(oilType6);
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position) {
//                showToast(popuWindowView.getTitle(position));
                setCarOilTypeText(popuWindowView.getTitle(position));
//                Toast.makeText(context, "0>>" + popuWindowView.getTitle(position), Toast.LENGTH_SHORT).show();
                popuWindowView.dismiss();
//                Toast.makeText(context, "000000", Toast.LENGTH_SHORT).show();
                if (clickPullListener != null) {
                    Toast.makeText(context, "00111111111", Toast.LENGTH_SHORT).show();
                    clickPullListener.ClickPull(position, popuWindowView.getTitle(position));
                }
            }
        });
        popuWindowView.showing(carOilType);
    }

    /**
     * 检验控件是否被选中
     */

    public boolean isChecked() {

        return carSelect.isChecked();

    }

    /**
     * 设置 控件选中 状态
     */
    public void setChecked(boolean checked) {
        carSelect.setChecked(checked);
    }


    public void setOnClickPullListener(OnClickPullListener clickPullListener) {

        this.clickPullListener = clickPullListener;
    }


    public interface OnClickPullListener {
        void ClickPull(int position, String conten);

    }

    OnClickPullListener clickPullListener;
}
