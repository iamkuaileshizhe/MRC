package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.xunfei.TtsDemo;

/**
 * Created by admin on 2017/8/9.
 */

public class ExampleActivity extends BaseActivity implements View.OnClickListener {
    //    private XListView listview;
//    private boolean b;
    @Override
    public void initContentView() {
        setContentView(R.layout.example_layout);
    }

    @Override
    public void initView() {


        findViewById(R.id.ex_btn_alipay).setOnClickListener(this);
        findViewById(R.id.ex_btn_wx).setOnClickListener(this);
        findViewById(R.id.ex_btn_baidu_map).setOnClickListener(this);
        findViewById(R.id.ex_btn_process).setOnClickListener(this);
        findViewById(R.id.ex_btn_orderinfi).setOnClickListener(this);
        findViewById(R.id.ex_btn_gesture).setOnClickListener(this);
        findViewById(R.id.ex_btn_open_pdf).setOnClickListener(this);
        findViewById(R.id.ex_btn_order_finish).setOnClickListener(this);
        findViewById(R.id.ex_btn_get_price).setOnClickListener(this);
        findViewById(R.id.bd_loc_test_btn).setOnClickListener(this);
        findViewById(R.id.bd_loc_navi).setOnClickListener(this);

//OrderDetailActivity


//        listview = (XListView) findViewById(R.id.listview);
//        listview.setPullLoadEnable(true);
//        listview.setXListViewListener(this);
//        listview.setAdapter(new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return 10;
//            }
//
//            @Override
//            public Object getItem(int i) {
//                return i;
//            }
//
//            @Override
//            public long getItemId(int i) {
//                return i;
//            }
//
//            @Override
//            public View getView(int i, View view, ViewGroup viewGroup) {
//                TextView view1 = new TextView(ExampleActivity.this);
//                view1.setText("leefeng.me" + i);
//                view1.setHeight(100);
//                return view1;
//            }
//        });
//


    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ex_btn_alipay:
                Toast.makeText(this, "导航", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ex_btn_baidu_map:
                Toast.makeText(this, "导航", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ex_btn_wx:
                Toast.makeText(this, "导航", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ex_btn_process:
                intent = new Intent(UIUtils.getContext(), OrderDeliveryDetail.class);
                startActivity(intent);
                break;
            case R.id.ex_btn_orderinfi:
                intent = new Intent(UIUtils.getContext(), OrderDetailActivity.class);
                startActivity(intent);
                break;
//            case R.id.ex_btn_gesture:
//                intent = new Intent(UIUtils.getContext(), GestureMainActivity.class);
//                startActivity(intent);
//                break;
            case R.id.ex_btn_open_pdf:
                intent = new Intent(UIUtils.getContext(), PDFViewActivity.class);
                startActivity(intent);
                break;
            case R.id.ex_btn_order_finish:

                intent = new Intent(UIUtils.getContext(), ChargeMoneyActivity.class);
                startActivity(intent);

                break;
            case R.id.ex_btn_get_price:

                break;
            case R.id.bd_loc_test_btn:

                break;
            case R.id.bd_loc_navi:
//                Toast.makeText(this, "导航", Toast.LENGTH_SHORT).show();

                intent = new Intent(UIUtils.getContext(), TtsDemo.class);
                startActivity(intent);


                break;
        }

    }


//    @Override
//    public void onRefresh() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                listview.stopRefresh(b);
//                b = !b;
//            }
//        }, 2000);
//    }
//
//    @Override
//    public void onLoadMore() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                listview.stopLoadMore();
//            }
//        }, 2000);
//    }
}
