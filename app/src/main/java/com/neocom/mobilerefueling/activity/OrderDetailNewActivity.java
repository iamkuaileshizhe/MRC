package com.neocom.mobilerefueling.activity;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.OrderDetailAdapter;
import com.neocom.mobilerefueling.bean.CarId;
import com.neocom.mobilerefueling.bean.OrderResponseBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.view.ListViewWithScroll;
import com.neocom.mobilerefueling.view.OrderConbindView;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/10/24.
 */

public class OrderDetailNewActivity extends BaseActivity {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.order_no)
    OrderConbindView orderNo;
    @BindView(R.id.order_time)
    OrderConbindView orderTime;
    @BindView(R.id.order_address)
    OrderConbindView orderAddress;
    @BindView(R.id.order_phone)
    OrderConbindView orderPhone;
    @BindView(R.id.order_ticket)
    OrderConbindView orderTicket;
    @BindView(R.id.order_mark)
    OrderConbindView orderMark;
    @BindView(R.id.goods_detail)
    ListViewWithScroll goodsDetail;
    private String itemId;
    @BindView(R.id.order_state)
    TextView orderState;
    OrderDetailAdapter detailAdapter;

    @Override
    public void initContentView() {
        setContentView(R.layout.order_detail_new_activity);
    }

    @Override
    public void initView() {

        itemId = getIntent().getExtras().getString("itemId");
        Log.i(TAG, "initView: " + itemId);
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

        getDataFromServer();

    }

    private void getDataFromServer() {

        CarId carId = new CarId();

//        carId.setIndentId("4498f59771914a41acfbb955621818e1");
        carId.setIndentId(itemId);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(carId);

        Call<OrderResponseBean> call = HttpManger.getHttpMangerInstance().getServices().searchIndentInfoById(requestBody);

        call.enqueue(new Callback<OrderResponseBean>() {
            @Override
            public void onResponse(Call<OrderResponseBean> call, Response<OrderResponseBean> response) {

                OrderResponseBean body = response.body();

                if (body != null) {
                    OrderResponseBean.BringBean bring = body.getBring();

                    if (bring == null) {
                        Log.i(TAG, "onResponse: 获取数据为空....");
                    } else {
                        processData(bring);
                    }

                }




            }

            @Override
            public void onFailure(Call<OrderResponseBean> call, Throwable t) {
                Log.i(TAG, "onFailure: ==>>" + t.getMessage());
            }
        });

    }

    private void processData(OrderResponseBean.BringBean bring) {
        orderState.setText("状态:" + bring.getOrderStatus());
        orderNo.setTitle("订单编号:" + bring.getIndentCode());
        orderNo.setContet("订单处理信息 >");

        orderTime.setTitle("下单时间");
        orderTime.setContet(bring.getIndentTime());

        orderAddress.setTitle("收货地址");
        orderAddress.setContet(bring.getIndentAddress());
        orderPhone.setTitle("联系电话");
        orderPhone.setContet(bring.getPhone());

        orderTicket.setTitle("发票");
        orderTicket.setContet(bring.getInvoiceName());


        orderMark.setTitle("备注");
        orderMark.setContet(bring.getRemark());


        detailAdapter = new OrderDetailAdapter(bring.getOilsInfo());
        goodsDetail.setAdapter(detailAdapter);

    }


}
