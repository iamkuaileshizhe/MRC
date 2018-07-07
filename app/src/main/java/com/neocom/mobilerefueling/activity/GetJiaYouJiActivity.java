package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.JiaYouJiAdapter;
import com.neocom.mobilerefueling.bean.JiaYouJiRespBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/30.
 */

public class GetJiaYouJiActivity extends BaseActivity {
    @BindView(R.id.jiayouji_title)
    TopTitleBar jiayoujiTitle;
    @BindView(R.id.jiayouj_lv)
    ListView jiayoujLv;
    private JiaYouJiAdapter jiaYouJiAdapter;

//    List<JiaYouJiRespBean.BringBean> datasSelect=new ArrayList<>();

    @Override
    public void initContentView() {
        setContentView(R.layout.jiayouji_layout);
    }

    @Override
    public void initView() {
        showLoadingDialog("加载中...");
        jiayoujiTitle.setTitleText("加油机数据");

        jiayoujiTitle.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        jiayoujiTitle.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showLoadingDialog("数据添加中...");

                List<JiaYouJiRespBean.BringBean> allDatas = jiaYouJiAdapter.getAllDatas();

                for (int i = 0; i < allDatas.size(); i++) {
                    Log.i(TAG, "onClick: " + allDatas.get(i).toString());

                    JiaYouJiRespBean.BringBean bringBean = allDatas.get(i);

//                    if (bringBean.isChecked()){
//                        PaiSongDanJieDanActivity.datasSelect.add(bringBean);
//                    }
                }
                disDialog();

                Intent intent = new Intent();
                setResult(2, intent);
                finish();

//                Intent intent = new Intent();
//                intent.putExtra("addcar_data", (Serializable) lastgroups);
////                intent.putListExtra("addcar_data", (Serializable) lastgroups)
//                setResult(Constant.ADDCAR_RESP, intent);
//                finish();

//                Log.i(TAG, "onClick: "+jiaYouJiAdapter.getItem(i));

//                jiayoujLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                        jiaYouJiAdapter.getItem(i).setChecked();
//
//                        jiaYouJiAdapter.setOnJiaItem(i);
//
//                    }
//                });

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        getDataFromServer();
    }

    private void getDataFromServer() {

        GetCarJiaYouJi getCarJiaYouJi = new GetCarJiaYouJi();
        getCarJiaYouJi.setCarNum(GetUserInfoUtils.getUserInfo().getCarNum());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(getCarJiaYouJi);

        HttpManger.getHttpMangerInstance().getServices().findFuelDiaryByCarNum(requestBody).enqueue(new Callback<JiaYouJiRespBean>() {
            @Override
            public void onResponse(Call<JiaYouJiRespBean> call, Response<JiaYouJiRespBean> response) {
                disDialog();
                JiaYouJiRespBean body = response.body();

                if (body != null) {

                    List<JiaYouJiRespBean.BringBean> bring = body.getBring();
                    if (bring != null) {
                        parseBring(bring);
                    }

                }

            }

            @Override
            public void onFailure(Call<JiaYouJiRespBean> call, Throwable t) {
                disDialog();
                Toasty.error(GetJiaYouJiActivity.this, "获取数据异常", Toast.LENGTH_SHORT, true).show();

            }
        });

    }

    private void parseBring(List<JiaYouJiRespBean.BringBean> bring) {

        jiaYouJiAdapter = new JiaYouJiAdapter(GetJiaYouJiActivity.this, bring);


        jiayoujLv.setAdapter(jiaYouJiAdapter);

//        jiaYouJiAdapter.setOnJiaYouJiClick(new JiaYouJiAdapter.OnJiaYouJiClick() {
//            @Override
//            public void getJiaYouItem(JiaYouJiAdapter.ViewHolder holder, int position, JiaYouJiRespBean.BringBean bringBean) {
//
//                Toasty.info(GetJiaYouJiActivity.this, position+"", Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }


    @Override
    public void initData() {

    }


    public class GetCarJiaYouJi {

        private String carNum;


        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }


        @Override
        public String toString() {
            return "GetCarJiaYouJi{" +
                    "carNum='" + carNum + '\'' +
                    '}';
        }
    }

}
