package com.neocom.mobilerefueling.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.OrderDetailBean;
import com.neocom.mobilerefueling.bean.OrderDetailItemBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.view.CircleImageAvtar;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.io.Serializable;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 订单详情
 */

public class OrderDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.order_detail_avtar_cv)
    CircleImageAvtar orderAvatar;
    @BindView(R.id.order_detail_name_tv)
    TextView orderUserName;
    @BindView(R.id.order_detail_phone_iv)
    ImageView orderPhone;
    @BindView(R.id.order_detail_tb)
    TopTitleBar orderDetailTb;
    @BindView(R.id.order_time_oc)
    OrderConbindView orderTimeOc;
    @BindView(R.id.order_address_oc)
    OrderConbindView orderAddressOc;
    @BindView(R.id.order_phone_oc)
    OrderConbindView orderPhoneOc;
    @BindView(R.id.order_expact_time_oc)
    OrderConbindView orderExpactTimeOc;
    @BindView(R.id.order_pay_type_oc)
    OrderConbindView orderPayTypeOc;
    @BindView(R.id.order_check_oc)
    OrderConbindView orderCheckOc;
    @BindView(R.id.order_note_oc)
    OrderConbindView orderNoteOc;
    @BindView(R.id.order_carnum_oc)
    OrderConbindView orderCarnumOc;
    @BindView(R.id.order_oil_type_oc)
    OrderConbindView orderOilTypeOc;
    @BindView(R.id.order_oil_mount_oc)
    OrderConbindView orderOilMountOc;
    @BindView(R.id.order_user_oc)
    OrderConbindView orderUserOc;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLl;
    @BindView(R.id.order_state_tv)
    TextView orderStateTv;
    @BindView(R.id.order_driver_phone_oc)
    OrderConbindView orderDriverPhoneOc;
    @BindView(R.id.pay_cancle)
    Button payCancle;

    @BindView(R.id.pay_now)
    Button payNow;
    private String userId;

    @Override
    public void initContentView() {
        setContentView(R.layout.order_layout_detail);
    }

    @Override
    public void initView() {
        TopTitleBar topTitleBar = (TopTitleBar) findViewById(R.id.order_detail_tb);
        topTitleBar.setTitleText("详情");
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).fitsSystemWindows(true).init();
        topTitleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        topTitleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderDetailActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });


        payCancle.setOnClickListener(this);
        payNow.setOnClickListener(this);
    }

    @Override
    public void initData() {
        userId = getIntent().getStringExtra("userId");
        if (TextUtils.isEmpty(userId)) {

            Toast.makeText(this, "获取参数错误", Toast.LENGTH_SHORT).show();
            finish();
        }

        IdBean uId = new IdBean();
        uId.setIndentId(userId);
        Log.i(TAG, "initData: " + new Gson().toJson(uId));

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(uId));

        Call<OrderDetailBean> call = HttpManger.getHttpMangerInstance().getServices().getOrderInfoById(requestBody);
        call.enqueue(new Callback<OrderDetailBean>() {
            @Override
            public void onResponse(Call<OrderDetailBean> call, Response<OrderDetailBean> response) {

                OrderDetailBean body = response.body();
                if (body != null) {
                    OrderDetailItemBean bring = body.getBring();
                    if (bring != null) {
                        showInView(bring);
                    }

                }


            }

            @Override
            public void onFailure(Call<OrderDetailBean> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


//    @BindView(R.id.order_expact_time_oc)
//    OrderConbindView orderExpactTimeOc;
//    @BindView(R.id.order_pay_type_oc)
//    OrderConbindView orderPayTypeOc;
//    @BindView(R.id.order_check_oc)
//    OrderConbindView orderCheckOc;
//    @BindView(R.id.order_note_oc)
//    OrderConbindView orderNoteOc;
//    @BindView(R.id.order_carnum_oc)
//    OrderConbindView orderCarnumOc;
//    @BindView(R.id.order_oil_type_oc)
//    OrderConbindView orderOilTypeOc;
//    @BindView(R.id.order_oil_mount_oc)
//    OrderConbindView orderOilMountOc;
//    @BindView(R.id.order_user_oc)
//    OrderConbindView orderUserOc;
//    @BindView(R.id.bottom_ll)
//    LinearLayout bottomLl;
//    @BindView(R.id.order_state_tv)
//    TextView orderStateTv;
//    @BindView(R.id.order_driver_phone_oc)
//    OrderConbindView orderDriverPhoneOc;


    private void showInView(OrderDetailItemBean bring) {

        orderTimeOc.setTitle("下单时间");
        orderTimeOc.setContet(bring.getIndentTime());
        orderUserName.setText(bring.getLinkMan());
        orderAddressOc.setTitle("收货地址");
        orderAddressOc.setContet(bring.getIndentAddress());
        orderPhoneOc.setTitle("联系电话");
        orderPhoneOc.setContet(bring.getPhone());
        orderExpactTimeOc.setTitle("期望时间");
        orderExpactTimeOc.setContet(bring.getDeliveryTime());
        orderPayTypeOc.setTitle("支付方式");
        orderPayTypeOc.setContet(bring.getPayType());
        orderCheckOc.setTitle("发票");
        orderCheckOc.setContet(bring.getRemark());

        orderNoteOc.setTitle("备注");
        orderNoteOc.setContet(bring.getRemark());

        orderOilTypeOc.setTitle("车辆信息");
        orderOilTypeOc.setContet(bring.getLinkMan());

        orderCarnumOc.setTitle("车牌号");
        orderCarnumOc.setContet(bring.getLinkMan());

        orderOilTypeOc.setTitle("燃油类型");
        orderOilTypeOc.setContet(bring.getOilAmount());

        orderOilMountOc.setTitle("燃油数量");
        orderOilMountOc.setContet(bring.getOilAmount());

        orderUserOc.setTitle("联系人");
        orderUserOc.setContet(bring.getU_user());

        orderDriverPhoneOc.setTitle("联系电话");
        orderDriverPhoneOc.setContet(bring.getPhone());
    }

    @Override
    public void onClick(View view) {

//        @BindView(R.id.pay_cancle)
//        Button payCancle;
//
//        @BindView(R.id.pay_now)
//        Button payNow;

        switch (view.getId()) {

            case R.id.pay_cancle:

                Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();

                break;
            case R.id.pay_now:

                Toast.makeText(this, "立即支付", Toast.LENGTH_SHORT).show();

                break;

        }


    }

    public class IdBean implements Serializable {

        private String indentId;


        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        @Override
        public String toString() {
            return "IdBean{" +
                    "indentId='" + indentId + '\'' +
                    '}';
        }
    }

}
