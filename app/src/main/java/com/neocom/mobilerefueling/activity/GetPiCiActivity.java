package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.GetPiciAdapter;

import butterknife.BindView;

/**
 * Created by admin on 2017/8/28.
 */

public class GetPiCiActivity extends BaseActivity {
    //@BindView(R.id.pici_listview)
// XListView piciListview;
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.submit_now)
    Button submitNow;
    private GetPiciAdapter piciAdapter;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;

    @Override
    public void initContentView() {

        setContentView(R.layout.pici_layout);

//        intent.putExtra("show", "show");


    }

    @Override
    public void initView() {

        String show = getIntent().getStringExtra("show");


        if (!TextUtils.isEmpty(show)) {
            if (show.equals("show")) {

                submitNow.setVisibility(View.VISIBLE);

            }


        }

//        piciListview.setPullLoadEnable(true);
//        piciListview.setXListViewListener(this);
        topBarTitleTv.setText("油品批次");
//        piciListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = new Intent();
//                intent.putExtra("batchId", piciAdapter.getItem(i - 1).getBatchNum());
//                setResult(112, intent);
//                finish();
//            }
//        });

        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        submitNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: 新增批次");

                startActivity(new Intent(GetPiCiActivity.this, AddPiCiActivity.class));

            }
        });


    }


    @Override
    public void initData() {


    }


//    @Override
//    public void onRefresh() {
//
//        getDataFromServer();
////        new Handler().postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                piciListview.stopRefresh(true);
////            }
////        }, 2000);
//
//
//    }
//
//    @Override
//    public void onLoadMore() {
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                piciListview.stopLoadMore();
//            }
//        }, 2000);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//
//        getDataFromServer();
//    }
//
//    private void getDataFromServer() {
//
//        RequestPageBean pageBean = new RequestPageBean();
//        pageBean.setBeginNum("1");
//        pageBean.setEndNum("10");
//
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(pageBean));
//
//        Call<GetPiCiBean> call = HttpManger.getHttpMangerInstance().getServices().searchBatchList(requestBody);
//
//        call.enqueue(new Callback<GetPiCiBean>() {
//            @Override
//            public void onResponse(Call<GetPiCiBean> call, Response<GetPiCiBean> response) {
////                Log.i(TAG, "onResponse: " + response.body().toString());
//
//                GetPiCiBean body = response.body();
//                if (body != null) {
//
//                    List<PiCiBringBean> bring = body.getBring();
//
//                    if (bring != null && bring.size() > 0) {
//                        parseBean(bring);
//                    } else {
//                        Log.i(TAG, "onResponse: 可能是获取数据错误...");
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<GetPiCiBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: " + t.getMessage());
//
//                if (piciListview != null) {
//                    piciListview.stopRefresh(true);
//                }
//
//            }
//        });
//    }
//
//    private void parseBean(List<PiCiBringBean> bring) {
//
//        if (piciListview != null) {
//            piciListview.stopRefresh(true);
//        }
//        piciAdapter = new GetPiciAdapter(GetPiCiActivity.this,bring);
//
//        piciListview.setAdapter(piciAdapter);
//
//    }


}
