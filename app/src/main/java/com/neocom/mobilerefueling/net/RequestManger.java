package com.neocom.mobilerefueling.net;

import com.neocom.mobilerefueling.processor.RequestCallBack;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/4/26.
 */

public class RequestManger {

    private static RequestManger requestManger;


    public RequestManger() {
    }


    public static RequestManger getRequestManger() {

        if (requestManger == null) {
            requestManger = new RequestManger();
        }

        return requestManger;
    }

    public void startProcess(String gsonString, final RequestCallBack callBack) {
//    public void startProcess(Map<String,String> stringMapJson, RequestCallBack callBack){

//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gsonString);


        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gsonString);


        HttpManger.getHttpMangerInstance().getStringServices().startProcess(requestBody).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {



                if (callBack != null) {
                    callBack.onSuccess(response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (callBack != null) {
                    callBack.onFailure(t.getMessage());
                }
            }
        });

    }

}
