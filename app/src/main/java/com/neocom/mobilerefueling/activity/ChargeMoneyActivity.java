package com.neocom.mobilerefueling.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ConstellationAdapter;
import com.neocom.mobilerefueling.adapter.PayTypeAdapter;
import com.neocom.mobilerefueling.bean.PayTypeChooseBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/11/1.
 */

public class ChargeMoneyActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.charge_top_title_bar)
    LinearLayout chargeTopTitleBar;
    @BindView(R.id.remain_money_rl)
    RelativeLayout remainMoneyRl;
    @BindView(R.id.charge_select_num)
    GridView chargeSelectNum;
    @BindView(R.id.charge_menu)
    RelativeLayout chargeMenu;
    private String constellations[] = {"100.00元", "500.00元", "1000.00元", "1500.00元", "2000.00元", "其他"};
    private int constellationPosition = 0;
    private ConstellationAdapter constellationAdapter;

    private int payTypeChoosePosition = -1;

    @BindView(R.id.choose_paytype_lv)
    ListView choosePaytypeLv;

    @Override
    public void initContentView() {

        setContentView(R.layout.charge_money_layout);

    }

    @Override
    public void initView() {

        initGrideView();
        initListView();

    }

    private void initListView() {

        List<PayTypeChooseBean> typeChooseBeen = new ArrayList<>();
        PayTypeChooseBean aliPayChoose = new PayTypeChooseBean(R.mipmap.app_recharge_alipay, "支付宝支付", R.mipmap.app_recharge_pay_select);
        PayTypeChooseBean wxPayChoose = new PayTypeChooseBean(R.mipmap.app_recharge_wxpay, "微信支付", R.mipmap.app_recharge_pay_select);
        typeChooseBeen.add(aliPayChoose);
        typeChooseBeen.add(wxPayChoose);
//668068920416
        final PayTypeAdapter payTypeAdapter = new PayTypeAdapter(ChargeMoneyActivity.this, typeChooseBeen);

        payTypeAdapter.setCheckItem(payTypeChoosePosition);

        choosePaytypeLv.setAdapter(payTypeAdapter);

        choosePaytypeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                payTypeAdapter.setCheckItem(i);
                payTypeChoosePosition = i;


            }
        });


    }

    private void initGrideView() {

        constellationAdapter = new ConstellationAdapter(this, Arrays.asList(constellations));
        chargeSelectNum.setAdapter(constellationAdapter);
        constellationAdapter.setCheckItem(constellationPosition);

        chargeSelectNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                constellationAdapter.setCheckItem(position);
                constellationPosition = position;
            }
        });
    }

    @Override
    public void initData() {

    }

}
