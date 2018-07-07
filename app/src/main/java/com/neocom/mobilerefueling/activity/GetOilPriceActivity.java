package com.neocom.mobilerefueling.activity;

import android.widget.Button;
import android.widget.TextView;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.UIUtils;

import butterknife.BindView;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by admin on 2017/9/4.
 */

public class GetOilPriceActivity extends BaseActivity {
    @BindView(R.id.get_oil_price_btn)
    Button getOilPriceBtn;
    @BindView(R.id.oil_price_tv)
    TextView oilPriceTv;

    @Override
    public void initContentView() {
        setContentView(R.layout.get_oil_price_layout);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        getDataFromServer();

    }

    public void getDataFromServer() {
        GetoilPriceBean priceBean=new GetoilPriceBean();

        priceBean.setCurrentTime(UIUtils.getCurrentTime());
        priceBean.setOilType("2");

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(priceBean);

        Call<Object> call = HttpManger.getHttpMangerInstance().getServices().getCurrentOilPrice(requestBody);



    }


    public class GetoilPriceBean {
        /**
         * currentTime : 2017-08-30 15:00:00
         * oilType : 2
         */
//    {"currentTime":"2017-08-30 15:00:00","oilType":"2"}
        private String currentTime;
        private String oilType;

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getOilType() {
            return oilType;
        }

        public void setOilType(String oilType) {
            this.oilType = oilType;
        }

        @Override
        public String toString() {
            return "GetoilPriceBean{" +
                    "currentTime='" + currentTime + '\'' +
                    ", oilType='" + oilType + '\'' +
                    '}';
        }
    }

}
