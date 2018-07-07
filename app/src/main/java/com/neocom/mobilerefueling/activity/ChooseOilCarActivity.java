package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.ChooseCarAdapter;
import com.neocom.mobilerefueling.bean.ChooseCarBean;
import com.neocom.mobilerefueling.bean.ChooseCarBeanBring;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.view.SearchEditText;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.io.Serializable;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/11.
 */

public class ChooseOilCarActivity extends BaseActivity implements SearchEditText.OnSearchClickListener {

    private TopTitleBar topTitleBar;
    //    private List<ChooseCarBean> carBeanList;
    private ChooseCarAdapter chooseCarAdapter;
    public static List<ChooseCarBean> lastgroups;//最后一次变化后的值
    private ListView listViewCar;
    private SearchEditText searchEditText;

    @Override
    public void initContentView() {
        setContentView(R.layout.choose_oil_car_layout);
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).fitsSystemWindows(true).init();
    }

    @Override
    public void initView() {
        topTitleBar = (TopTitleBar) findViewById(R.id.choose_oil_car_title);
        topTitleBar.setTitleText("选择车辆");

        listViewCar = (ListView) findViewById(R.id.choose_oil_car_lv);
        searchEditText = (SearchEditText) findViewById(R.id.searchEditText);

        topTitleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        topTitleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChooseOilCarActivity.this, "确定", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.putExtra("addcar_data", (Serializable) lastgroups);
//                intent.putListExtra("addcar_data", (Serializable) lastgroups)
                setResult(Constant.ADDCAR_RESP, intent);
                finish();

            }
        });


        //搜索事件
        searchEditText.setOnSearchClickListener(this);


    }

    @Override
    public void initData() {

//        carBeanList = new ArrayList<>();

//        for (int i = 0; i < 5; i++) {
//
//            ChooseCarBean carBean = new ChooseCarBean();
//            carBean.setCarNum("鲁" + i);
//            carBean.setCarOilType("柴油" + i);
//            carBean.setCarOilCount("容量" + i);
//            carBean.setCarDriver("张三" + i);
//            carBean.setCarDriverPhone("手机" + i);
//            carBeanList.add(carBean);
//        }

//        lastgroups = carBeanList;//开始的时候默认最后一次变化的值是初始化的值
    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//        ChooseCarBean carBean = carBeanList.get(i);
//        carBean.setChecked(!carBean.isChecked());
//        chooseCarAdapter.notifyDataSetChanged();
//
//    }


    @Override
    protected void onStart() {
        super.onStart();

        getDataFromServer();

    }

    private void getDataFromServer() {

        GetCarUserId getCarUserId = new GetCarUserId();
        getCarUserId.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(getCarUserId);

        Call<ChooseCarBeanBring> call = HttpManger.getHttpMangerInstance().getServices().findCarListByUserId(requestBody);

        call.enqueue(new Callback<ChooseCarBeanBring>() {
            @Override
            public void onResponse(Call<ChooseCarBeanBring> call, Response<ChooseCarBeanBring> response) {

                ChooseCarBeanBring body = response.body();

                if (body != null) {
                    ChooseCarBeanBring.BringBean bringBean = body.getBring();
                    if (bringBean != null) {
                        parseBringBen(bringBean);
                    }
                }

            }

            @Override
            public void onFailure(Call<ChooseCarBeanBring> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());

            }
        });

    }

    private void parseBringBen(ChooseCarBeanBring.BringBean bringBean) {

        List<ChooseCarBean> carList = bringBean.getCarList();

        Log.i(TAG, "initData: 000000000000000000000000");
        chooseCarAdapter = new ChooseCarAdapter(ChooseOilCarActivity.this, carList);
        listViewCar.setAdapter(chooseCarAdapter);

    }

    /**
     * 搜索事件
     */
    @Override
    public void onSearchClick(View view, String keyword) {
        if (!TextUtils.isEmpty(keyword)) {
            //在这里处理逻辑
            Toast.makeText(this, keyword, Toast.LENGTH_SHORT).show();
        }
    }


    public class GetCarUserId {

        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "getCarUserId{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }

}
