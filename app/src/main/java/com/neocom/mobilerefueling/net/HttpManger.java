package com.neocom.mobilerefueling.net;

//import com.huanyu.itsms.globle.Constant;

import android.util.Log;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.listener.ProgressListener;

import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by admin_xyz on 2017/7/20.
 * 创建人：xyz
 * 创建日期:2017/7/20
 * 描述: 网络请求管理
 */

public class HttpManger {
    private static HttpManger httpManger;


    private HttpManger() {
    }

    /**
     * @return 管理实例
     * <p>
     * 获取管理管理请求实例
     */
    public static HttpManger getHttpMangerInstance() {
        if (httpManger == null) {
            httpManger = new HttpManger();
        }
        return httpManger;
    }

    /**
     * @param baseUrl 需要 访问的 主机ＩＰ：端口　或　名称
     * @return　返回 接口 service
     */
    public IRequestServices getService(String baseUrl) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRequestServices service = retrofit.create(IRequestServices.class);


        return service;
    }


    /**
     * @return 返回 接口 service
     */
    public IRequestServices getStringServices() {

        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient().newBuilder();
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
//                .baseUrl(Constant.MENU_URL)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        IRequestServices service = retrofit.create(IRequestServices.class);

        return service;
    }

    /**
     * @return 返回 接口 service
     */
    public IRequestServices getServices() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRequestServices service = retrofit.create(IRequestServices.class);

        return service;
    }

    public IRequestServices getServices(ProgressListener progressListener) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRequestServices service = retrofit.create(IRequestServices.class);

        return service;
    }


    public Retrofit getRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


    public RequestBody getRequestBody(Object obj) {
        Gson gson = new Gson();

        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(obj));

    }

    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("xyz", "网络日志:==>>" + message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        //OkHttp进行添加拦截器loggingInterceptor
        return httpClientBuilder.build();
    }


}
