package com.neocom.mobilerefueling.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.UpLOadLocationBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.CommonUtil;
import com.neocom.mobilerefueling.utils.GPSUtil;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadService extends Service {


    public final String TAG = "LocationService";
    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = new AMapLocationClientOption();
    private Timer mTimer;
    private LatLng last_latlng;


    public UploadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
//        Notification noti = new Notification();
//        noti.flags = Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;
//        startForeground(1, noti);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String carryStatus = SPUtils.getContent(Constant.WORK_STATE);

        boolean equals = carryStatus.equals(Constant.IN_WORK);

        LogUtils.d(" 0 上班上班：" + carryStatus);

        if (equals) {

            LogUtils.d("上班中 需要上传位置");
            mTimer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    initLocation();
                    locationClient.startLocation();
                }
            };
            mTimer.scheduleAtFixedRate(task, 0, 30 * 1000);


        } else {

            LogUtils.d("没上班 不需要上传位置");

            stopSelf();
        }


//        flags = START_STICKY;
        return START_STICKY;

    }


    @Override
    public void onDestroy() {
//        Toast.makeText(getApplicationContext(), "onDestroy", 0).show();
        if (locationClient != null) {
            locationClient.stopLocation();
            destroyLocation();
        }
        if (null != mTimer) {
            mTimer.cancel();
        }


        super.onDestroy();
    }

    private void initLocation() {
        if (locationClient == null) {
            //初始化client
            locationClient = new AMapLocationClient(this.getApplicationContext());
        }

        //初始化定位参数
        initLocationOption();

        //设置定位参数

        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
    }


    private void initLocationOption() {

        if (null == locationOption) {
            locationOption = new AMapLocationClientOption();
        }
        //定位精度:高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位缓存策略
        locationOption.setLocationCacheEnable(false);
        //gps定位优先
        locationOption.setGpsFirst(false);
        //设置定位间隔
//        locationOption.setInterval(3000);
        locationOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是ture
        locationOption.setOnceLocation(true);//可选，设置是否单次定位。默认是false
        locationOption.setOnceLocationLatest(true);//true表示获取最近3s内精度最高的一次定位结果；false表示使用默认的连续定位策略。
        locationOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        //AMapLocationClientOption.setLocationProtocol(AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP


    }


    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation loc) {
            if (null != loc) {//定位成功

//              Toast.makeText(getApplicationContext(), loc.getLatitude()+"---"+loc.getLongitude(),0).show();
                Log.i(TAG, "定位成功");
                Log.i(TAG, "定位的经度位置是：" + loc.getLatitude());
                Log.i(TAG, "定位的维度位置是：" + loc.getLongitude());
                Log.i(TAG, "用户是：" + GetUserInfoUtils.getUserInfo().getUserName());


//                if(isCurrentInTimeScope()) {
                UpDate(loc);
//                }
            } else {//定位失败
                Log.i(TAG, "定位失败");
            }

            locationClient.stopLocation();
            destroyLocation();


        }
    };


    /**
     * 上传更新
     */
    private void UpDate(AMapLocation loc) {

        UpLOadLocationBean upLOadLocationBean = new UpLOadLocationBean();

        upLOadLocationBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());
        upLOadLocationBean.setCarNum(SPUtils.getSaveCar());
        upLOadLocationBean.setEquId(CommonUtil.getDeviceId(UploadService.this));

        double[] doubles = GPSUtil.gcj02_To_Bd09(loc.getLatitude(), loc.getLongitude());
        upLOadLocationBean.setLongitude(String.valueOf(doubles[1]));
        upLOadLocationBean.setDimension(String.valueOf(doubles[0]));

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(upLOadLocationBean);
        HttpManger.getHttpMangerInstance().getServices().uploadGps(requestBody).enqueue(new Callback<EmptyBringGetOilBean>() {
            @Override
            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                EmptyBringGetOilBean body = response.body();
                if (body != null) {

                    boolean res = body.isRes();

                    if (res) {

                        LogUtils.d("位置上传成功");

                    } else {

                        LogUtils.d("位置上传成功返回失败");

                    }

                }

            }

            @Override
            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                LogUtils.d("异常" + t.getMessage());

            }
        });


    }


    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }

    /**
     * 判断两个点之间的距离大于规定的距离
     */
    private boolean IsDistanceMoreOneMile(LatLng last, LatLng news) {
        if (last == null) {
            Log.i(TAG, "第一次为空");
            return true;
        }
        float mi = AMapUtils.calculateLineDistance(last, news);
        Log.i(TAG, "两次的间隔为：" + mi);
        if (mi > 2.0f) {
            return true;
        } else
            return false;
    }

//    /***
//     * 判断当前时间是否在规定的时间段范围内
//     * */
//    public static boolean isCurrentInTimeScope() {
//        int beginHour=5;
//        int beginMin=0;
//        int endHour=23;
//        int endMin=0;
//        boolean result = false;
//        final long aDayInMillis = 1000 * 60 * 60 * 24;
//        final long currentTimeMillis = System.currentTimeMillis();
//        Time now = new Time();
//        now.set(currentTimeMillis);
//        Time startTime = new Time();
//        startTime.set(currentTimeMillis);
//        startTime.hour = beginHour;
//        startTime.minute = beginMin;
//        Time endTime = new Time();
//        endTime.set(currentTimeMillis);
//        endTime.hour = endHour;
//        endTime.minute = endMin;
//        if (!startTime.before(endTime)) {
//            // 跨天的特殊情况（比如22:00-8:00）
//            startTime.set(startTime.toMillis(true) - aDayInMillis);
//            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
//            Time startTimeInThisDay = new Time();
//            startTimeInThisDay.set(startTime.toMillis(true) + aDayInMillis);
//            if (!now.before(startTimeInThisDay)) {
//                result = true;
//            }
//        } else {
//            // 普通情况(比如 8:00 - 14:00)
//            result = !now.before(startTime) && !now.after(endTime); // startTime <= now <= endTime
//        }
//        Log.i("LocationService","是否在时间间隔中"+result);
//        return result;
//    }
//}

}
