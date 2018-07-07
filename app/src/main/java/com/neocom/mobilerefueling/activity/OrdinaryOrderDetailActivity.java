package com.neocom.mobilerefueling.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ResponseDingDanDetailAdapter;
import com.neocom.mobilerefueling.bean.ResponseDingDanDetailBean;
import com.neocom.mobilerefueling.view.ListViewWithScroll;
import com.neocom.mobilerefueling.view.OrderConbindView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/9/13.
 */

public class OrdinaryOrderDetailActivity extends BaseActivity implements View.OnClickListener {

    String JSON = "{\n" +
            "\t\"purl\" : \"properties/code.properties\",\n" +
            "\t\"res\" : true,\n" +
            "\t\"code\" : \"message.common.0000\",\n" +
            "\t\"message\" : \"成功\",\n" +
            "\t\"bring\" : {\n" +
            "\t\t\"phone\" : \"1366666666666\", \n" +
            "\t\t\"status\" : \"1\",\n" +
            "\t\t\"remark\" : null,\n" +
            "\t\t\"indentStatus\" : \"10\",\n" +
            "\t\t\"carsInfo\" : [{\n" +
            "\t\t\t\t\"tankSize\" : \"川\",\n" +
            "\t\t\t\t\"pName\" : \"陈一发\",\n" +
            "\t\t\t\t\"vehicleId\" : \"45234f3557734827a405c463b276f0df\",\n" +
            "\t\t\t\t\"vehicleCode\" : \"川A34995\",\n" +
            "\t\t\t\t\"dstate\" : null,\n" +
            "\t\t\t\t\"oilType\" : \"2\",\n" +
            "\t\t\t\t\"relateType\" : \"0\",\n" +
            "\t\t\t\t\"telphone\" : \"川A34995\"\n" +
            "\t\t\t}, {\n" +
            "\t\t\t\t\"tankSize\" : \"123\",\n" +
            "\t\t\t\t\"pName\" : \"汤唯\",\n" +
            "\t\t\t\t\"vehicleId\" : \"ec67ba1336614ea6945a279b950628e1\",\n" +
            "\t\t\t\t\"vehicleCode\" : \"川A666661\",\n" +
            "\t\t\t\t\"dstate\" : null,\n" +
            "\t\t\t\t\"oilType\" : \"2\",\n" +
            "\t\t\t\t\"relateType\" : \"0\",\n" +
            "\t\t\t\t\"telphone\" : \"123\"\n" +
            "\t\t\t}\n" +
            "\t\t],\n" +
            "\t\t\"u_dt\" : \"\",\n" +
            "\t\t\"orderStatus\" : \"已完成\",\n" +
            "\t\t\"indentTime\" : \"2017-08-23 13:58:18\",\n" +
            "\t\t\"amount\" : null,\n" +
            "\t\t\"realCost\" : null,\n" +
            "\t\t\"estimateCost\" : \"666万\",\n" +
            "\t\t\"deliveryTime\" : \"2017-08-23\",\n" +
            "\t\t\"linkMan\" : \"于总\",\n" +
            "\t\t\"oilAmount\" : null,\n" +
            "\t\t\"c_user\" : \"17c4520f6cfd1ab53d8745e84681eb49\",\n" +
            "\t\t\"indentId\" : \"9744095cc05543bcbc2a7b481e32bb9d\",\n" +
            "\t\t\"indentCode\" : \"C000029\",\n" +
            "\t\t\"payType\" : \"3\",\n" +
            "\t\t\"prepayAmount\" : null,\n" +
            "\t\t\"indentAddress\" : \"滨州市\",\n" +
            "\t\t\"u_user\" : \"\",\n" +
            "\t\t\"delStatus\" : \"\",\n" +
            "\t\t\"c_dt\" : \"2017-08-23 13:58:18\"\n" +
            "\t}\n" +
            "}\n";
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.ordinary_order_status)
    TextView ordinaryOrderStatus;
    @BindView(R.id.receive_base_no)
    OrderConbindView receiveBaseNo;
    @BindView(R.id.ordinary_order_time)
    OrderConbindView ordinaryOrderTime;
    @BindView(R.id.ordinary_order_address)
    OrderConbindView ordinaryOrderAddress;
    @BindView(R.id.ordinary_order_connect_phone)
    OrderConbindView ordinaryOrderConnectPhone;
    @BindView(R.id.ordinary_order_expect_timr)
    OrderConbindView ordinaryOrderExpectTimr;
    @BindView(R.id.ordinary_order_ticket)
    OrderConbindView ordinaryOrderTicket;
    @BindView(R.id.ordinary_order_remark_note)
    OrderConbindView ordinaryOrderRemarkNote;
    @BindView(R.id.receive_list)
    ListViewWithScroll receiveList;
    @BindView(R.id.pay_cancle)
    Button payCancle;
    @BindView(R.id.pay_now)
    Button payNow;
    @BindView(R.id.bottom_ll)
    LinearLayout bottomLl;


    private String itemId;

    @Override
    public void initContentView() {
        setContentView(R.layout.ordinary_order_detail_layout);
    }

    @Override
    public void initView() {

        itemId = getIntent().getStringExtra("itemId");
        Log.i(TAG, "initView: itemId:" + itemId);

        topBarFinishLl.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!TextUtils.isEmpty(itemId)) {
//            getDataFromServer();
        }
    }

//    private void getDataFromServer() {
//        ItemId itemIdBean = new ItemId();
//        itemIdBean.setIndentId(itemId);
//        Call<ResponseDingDanDetailBean> call = HttpManger.getHttpMangerInstance().getServices().searchIndentInfoById(HttpManger.getHttpMangerInstance().getRequestBody(itemIdBean));
//        call.enqueue(new Callback<ResponseDingDanDetailBean>() {
//            @Override
//            public void onResponse(Call<ResponseDingDanDetailBean> call, Response<ResponseDingDanDetailBean> response) {
//                Log.i(TAG, "onResponse: " + response.body().toString());
//
//                ResponseDingDanDetailBean.BringBean bringBean = response.body().getBring();
//
//                parseBringBean(bringBean);
//            }
//
//            @Override
//            public void onFailure(Call<ResponseDingDanDetailBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//
//    }

    private void parseBringBean(ResponseDingDanDetailBean.BringBean bringBean) {
        ordinaryOrderStatus.setText("状态：" + bringBean.getOrderStatus());
        receiveBaseNo.setTitle("订单编号");
        receiveBaseNo.setContet(bringBean.getIndentCode());

        ordinaryOrderTime.setTitle("下单时间");
        ordinaryOrderTime.setContet(bringBean.getIndentTime());

        ordinaryOrderAddress.setTitle("收货地址");
        ordinaryOrderAddress.setContet(bringBean.getIndentAddress());

        ordinaryOrderConnectPhone.setTitle("联系电话");
        ordinaryOrderConnectPhone.setContet(bringBean.getPhone());

        ordinaryOrderExpectTimr.setTitle("期望时间");
        ordinaryOrderExpectTimr.setContet(bringBean.getDelStatus());

        ordinaryOrderTicket.setTitle("发票");
        ordinaryOrderTicket.setContet("");

        ordinaryOrderRemarkNote.setTitle("备注");
        ordinaryOrderRemarkNote.setContet(bringBean.getRemark());

        List<ResponseDingDanDetailBean.BringBean.CarsInfoBean> carsInfo = bringBean.getCarsInfo();

        ResponseDingDanDetailAdapter detailAdapter = new ResponseDingDanDetailAdapter(carsInfo);

        receiveList.setAdapter(detailAdapter);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.top_bar_finish_ll:
                finish();
                break;
        }
    }


    public class ItemId {
        private String indentId;

        public String getIndentId() {
            return indentId;
        }

        public void setIndentId(String indentId) {
            this.indentId = indentId;
        }

        @Override
        public String toString() {
            return "ItemId{" +
                    "indentId='" + indentId + '\'' +
                    '}';
        }
    }

}
