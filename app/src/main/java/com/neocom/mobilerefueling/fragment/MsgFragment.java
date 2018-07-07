package com.neocom.mobilerefueling.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.MsgBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/2.
 */

public class MsgFragment extends BaseFragment {
    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = UIUtils.inflate(R.layout.msg_fg_layout);

        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getdataFromServer();
    }

    private void getdataFromServer() {
        ReqId reqId = new ReqId();
        reqId.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(reqId);
        HttpManger.getHttpMangerInstance().getServices().getAllMessage(requestBody).enqueue(new Callback<MsgBean>() {
            @Override
            public void onResponse(Call<MsgBean> call, Response<MsgBean> response) {

            }

            @Override
            public void onFailure(Call<MsgBean> call, Throwable t) {

            }
        });
    }


    public class ReqId {

        private String userId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ReqId{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }
}
