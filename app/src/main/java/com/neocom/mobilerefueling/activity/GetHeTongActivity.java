package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.HeTongAdapter;
import com.neocom.mobilerefueling.bean.HeTongResBean;
import com.neocom.mobilerefueling.bean.RequestPageBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.view.XListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/13.
 */

public class GetHeTongActivity extends BaseActivity  {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
//    @BindView(R.id.pici_listview)
//    XListView piciListview;
//    private HeTongAdapter heTongAdapter;

    @Override
    public void initContentView() {
        setContentView(R.layout.hetong_layout);
    }

    @Override
    public void initView() {

//        piciListview.setPullLoadEnable(true);
//        piciListview.setXListViewListener(this);
        topBarTitleTv.setText("合同列表");
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        piciListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Intent intent = new Intent();
//                intent.putExtra("hetongId", heTongAdapter.getItem(i - 1).getBatchNum());
//                setResult(123, intent);
//                finish();
//            }
//        });


    }


//    @Override
//    public void onRefresh() {
//
//        getDataFromServer();
//
//    }
//
//    @Override
//    public void onLoadMore() {
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                piciListview.stopLoadMore();
//            }
//        }, 2000);
//    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        getDataFromServer();
//    }

//    private void getDataFromServer() {
//
//        RequestPageBean pageBean = new RequestPageBean();
//        pageBean.setBeginNum("1");
//        pageBean.setEndNum("10");
//
//        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(pageBean);
//        HttpManger.getHttpMangerInstance().getServices().searchContractList(requestBody).enqueue(new Callback<HeTongResBean>() {
//            @Override
//            public void onResponse(Call<HeTongResBean> call, Response<HeTongResBean> response) {
//
//                HeTongResBean body = response.body();
//
//                if (body != null) {
//                    List<HeTongResBean.BringBean> bring = body.getBring();
//                    if (bring != null) {
//                        parseBringBean(bring);
//                    } else {
//                        Toasty.info(GetHeTongActivity.this, "获取数据异常", Toast.LENGTH_SHORT, true).show();
//                        finish();
//                    }
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<HeTongResBean> call, Throwable t) {
//                Log.i(TAG, "onFailure: " + t.getMessage());
//
//                if (piciListview != null) {
//                    piciListview.stopRefresh(true);
//                }
//
//            }
//        });
//
//    }
//
//    private void parseBringBean(List<HeTongResBean.BringBean> bring) {
//
//        heTongAdapter = new HeTongAdapter(GetHeTongActivity.this, bring);
//
//        piciListview.setAdapter(heTongAdapter);
//
//        if (piciListview != null) {
//            piciListview.stopRefresh(true);
//        }
//
//    }


    @Override
    public void initData() {

    }

}
