package com.neocom.mobilerefueling.activity;

import android.Manifest;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.AddSurplyBean;
import com.neocom.mobilerefueling.bean.BuJiRespBean;
import com.neocom.mobilerefueling.bean.CarCodeRespBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.ListSettingBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.WriteNFCReqBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.GsonUtil;
import com.neocom.mobilerefueling.utils.LogUtils;
import com.neocom.mobilerefueling.utils.SPUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.utils.Utils;
import com.neocom.mobilerefueling.view.HintDialogFragment;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.neocom.mobilerefueling.view.OrderEdittext;
import com.neocom.mobilerefueling.view.isEditeTextView;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIDateTimeSaveListener;
import com.widget.jcdialog.listener.DialogUIListener;
import com.widget.jcdialog.widget.DateSelectorWheelView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/15.
 * <p>
 * 添加 补给
 */

public class AddgetOilActivity extends BaseActivity implements View.OnClickListener, HintDialogFragment.DialogFragmentCallback {
    //    @BindView(R.id.supply_car_code)
//    OrderEdittext supplyCarCode;
    @BindView(R.id.supply_car_code_istv)
    isEditeTextView supplyCarCodeIstv;
    @BindView(R.id.supply_car_driver)
    OrderEdittext supplyCarDriver;
    @BindView(R.id.supply_car_telphone)
    OrderEdittext supplyCarTelphone;
    //    @BindView(R.id.move_car_code)
//    OrderEdittext moveCarCode;
    @BindView(R.id.move_car_code_istv)
    isEditeTextView moveCarCodeIstv;
    @BindView(R.id.move_car_driver)
    OrderEdittext moveCarDriver;
    @BindView(R.id.move_car_telphone)
    OrderEdittext moveCarTelphone;
    //    @BindView(R.id.surplus_oil)
//    OrderEdittext surplusOil;
    @BindView(R.id.surplus_num)
    OrderEdittext surplusNum;
    @BindView(R.id.surplus_time)
    TextView surplusTime;
    @BindView(R.id.surplus_address)
    OrderEdittext surplusAddress;
    @BindView(R.id.remark_info)
    EditText remarkInfo;
    @BindView(R.id.submit_now)
    Button submitNow;
    @BindView(R.id.oil_pici)
    OrderConbindView oilPici;

    //    @BindView(R.id.add_car)
//    ImageView addCar;
    @BindView(R.id.add_car_ll)
    LinearLayout addCarLi;
    @BindView(R.id.surplus_num_danwei)
    TextView surplusNumDanwei;

    private static final int LOCATION_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    //BdPoiActivity
    @Override
    public void initContentView() {
        setContentView(R.layout.add_get_oil_activity);
    }

    @Override
    public void initData() {
        checkStorageAndLocationPermission();//初始化请求权限，存储权限
    }

    public NFCTagBean parseStrToBean(String nfcdata) {

        NFCTagBean nfcTagBean = null;
        if (!TextUtils.isEmpty(nfcdata)) {

            Log.i(TAG, "initView: nfcdata==>" + nfcdata);
            NFCTagBean tagBean = new NFCTagBean();
            Gson gson = new Gson();
            nfcTagBean = gson.fromJson(nfcdata, NFCTagBean.class);
            return nfcTagBean;
        } else {
            Log.i(TAG, "initView: nfcdata为空");
            return null;
        }

    }


    @Override
    public void initView() {
        Intent intent = getIntent();
        String nfcdata = intent.getStringExtra("nfcdata");
        NFCTagBean nfcTagBean = parseStrToBean(nfcdata);
        LoginResponseBean.BringBean userInfo = GetUserInfoUtils.getUserInfo();
        surplusAddress.setOnClickListener(this);
        surplusTime.setOnClickListener(this);
        oilPici.setOnClickListener(this);
//        supplyCarCode.setEditTitle("补给车牌号");
//        supplyCarCode.setEditContent(SPUtils.getSaveCar());
        supplyCarCodeIstv.setContent(SPUtils.getSaveCar());

//        if (nfcTagBean != null) {
//            supplyCarCode.setEditContent(nfcTagBean.getCarnum());
//        } else {
//            supplyCarCode.setEditContent("");
//        }


//        supplyCarDriver.setEditTitle("补给车司机");
        supplyCarDriver.setEditTitle("联系人名称");

        supplyCarDriver.setEditContent(userInfo.getUserName());

//        supplyCarTelphone.setEditTitle("补给车电话");
        supplyCarTelphone.setEditTitle("联系人电话");
        supplyCarTelphone.setEditContent(userInfo.getUserInfoMobile());

//        moveCarCode.setEditTitle("加油车牌号");
//        moveCarCode.setEditContent(userInfo.getCarNum());

        if (nfcTagBean != null) {
//            moveCarCode.setEditContent(nfcTagBean.getCarnum());
            moveCarCodeIstv.setContent(nfcTagBean.getCarnum());
        } else {
//            moveCarCode.setEditContent("");
            moveCarCodeIstv.setContent("");
        }

//        moveCarDriver.setEditTitle("加油车司机");
        moveCarDriver.setEditTitle("联系人名称");

//        moveCarTelphone.setEditTitle("加油车电话");
        moveCarTelphone.setEditTitle("联系人电话");

//        surplusOil.setEditTitle("剩余油量(吨)");

        surplusNum.setEditTitle("补给油量");

//        surplusTime.setEditTitle("补给时间");

        surplusAddress.setEditTitle("补给地点");
        oilPici.setTitle("油品批次");

        submitNow.setOnClickListener(this);
        addCarLi.setOnClickListener(this);

//        Log.i(TAG, "initView: ===01="+locationService);
//        locationService = new LocationServicess(UIUtils.getContext());
//        Log.i(TAG, "initView: ===02="+locationService);

        findViewById(R.id.top_bar_finish_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        surplusTime.setText(UIUtils.getCurrentTime());

//        //初始化定位
        initLocation();

        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
        initDanWei();
    }


    private void initDanWei() {
        String DUN = "吨";
        String QIANKE = "千克";

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
        if (listSetting != null) {
            String item_quality = listSetting.getItem_quality();
            if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_KG_L)) {

//                tiYouModifyBean.setUnit(Constant.DANWEI_KG_L);
                surplusNumDanwei.setText(QIANKE);

            } else {
//                tiYouModifyBean.setUnit(Constant.DANWEI_T);
                surplusNumDanwei.setText(DUN);
            }

        } else {
            surplusNumDanwei.setText(DUN);
        }


    }

    private void initLocation() {

        //初始化client
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);


    }


    /**
     * 默认的定位参数
     *
     * @author hongming.wang
     * @since 2.8.0
     */
    private AMapLocationClientOption getDefaultOption() {
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(false);//可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(30000);//可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(2000);//可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(true);//可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(false);//可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(false);//可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);//可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(false);//可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(true); //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(true); //可选，设置是否使用缓存定位，默认为true
        return mOption;
    }

    public void submitInfo() {
        AddSurplyBean addSurplyBean = new AddSurplyBean();
//        String supplyCarCodeStr = supplyCarCode.getEditContent();
        String supplyCarCodeStr = supplyCarCodeIstv.getContent();
        if (TextUtils.isEmpty(supplyCarCodeStr)) {
            Toast.makeText(this, "没有补给车牌号", Toast.LENGTH_SHORT).show();
            return;
        }


        String supplyCarDriverStr = supplyCarDriver.getEditContent();

        if (TextUtils.isEmpty(supplyCarDriverStr)) {
            Toast.makeText(this, "请输入补给车司机", Toast.LENGTH_SHORT).show();
            return;
        }


        String supplyCarTelphoneStr = supplyCarTelphone.getEditContent();
        if (TextUtils.isEmpty(supplyCarTelphoneStr)) {
            Toast.makeText(this, "请输入补给车司机电话", Toast.LENGTH_SHORT).show();
            return;
        }


        String moveCarCodeStr = moveCarCodeIstv.getContent();

        if (TextUtils.isEmpty(moveCarCodeStr)) {
            Toast.makeText(this, "加油车车牌号为空", Toast.LENGTH_SHORT).show();
            return;
        }


        String moveCarDriverStr = moveCarDriver.getEditContent();

        if (TextUtils.isEmpty(moveCarDriverStr)) {
            Toast.makeText(this, "请输入加油车司机姓名", Toast.LENGTH_SHORT).show();
            return;
        }


        String moveCarTelphoneStr = moveCarTelphone.getEditContent();

        if (TextUtils.isEmpty(moveCarTelphoneStr)) {
            Toast.makeText(this, "请输入加油车司机电话", Toast.LENGTH_SHORT).show();
            return;
        }


//        String surplusOilStr = surplusOil.getEditContent();
//        if (TextUtils.isEmpty(surplusOilStr)) {
//            Toast.makeText(this, "请输入剩余油量", Toast.LENGTH_SHORT).show();
//            return;
//        }


        String surplusNumStr = surplusNum.getEditContent();
        if (TextUtils.isEmpty(surplusNumStr)) {
            Toast.makeText(this, "请输入补给油量", Toast.LENGTH_SHORT).show();
            return;
        }


//        String surplusTimeStr = surplusTime.getEditContent();

        String surplusTimeStr = surplusTime.getText().toString();

        if (TextUtils.isEmpty(surplusTimeStr)) {
            Toast.makeText(this, "请输入补给时间", Toast.LENGTH_SHORT).show();
            return;
        }
        addSurplyBean.setSupplyTime(surplusTimeStr);
        String surplusAddressStr = surplusAddress.getEditContent();

        if (TextUtils.isEmpty(surplusAddressStr)) {
            Toast.makeText(this, "请输入补给地点", Toast.LENGTH_SHORT).show();
            return;
        }


        addSurplyBean.setSupplyCarDriver(supplyCarDriverStr);
        addSurplyBean.setSupplyCarTelphone(supplyCarTelphoneStr);
        addSurplyBean.setMoveCarCode(moveCarCodeStr);
        addSurplyBean.setMoveCarDriver(moveCarDriverStr);
        addSurplyBean.setMoveCarTelphone(moveCarTelphoneStr);
//        addSurplyBean.setSurplusOil(surplusOilStr);
        addSurplyBean.setSupplyNum(surplusNumStr);
        addSurplyBean.setSupplyCarCode(supplyCarCodeStr);

        addSurplyBean.setSupplyAddress(surplusAddressStr);
        String remarkInfoStr = remarkInfo.getText().toString().trim();
//这是 备注 只是暂时 服务端好还没有增加，此处预留字段
        if (TextUtils.isEmpty(remarkInfoStr)) {
            addSurplyBean.setRemarks("");
        } else {
            addSurplyBean.setRemarks(remarkInfoStr);
        }
        addSurplyBean.setC_dt(UIUtils.getCurrentTime());
        addSurplyBean.setC_user(GetUserInfoUtils.getUserInfo().getUserId());

        submitInfoToserver(addSurplyBean);

    }

    private void submitInfoToserver(AddSurplyBean addSurplyBean) {

        showLoadingDialog("提交中...");

        ListSettingBean listSetting = GetUserInfoUtils.getUserInfo().getListSetting();
        if (listSetting != null) {
            String item_quality = listSetting.getItem_quality();
            if (!TextUtils.isEmpty(item_quality) && item_quality.equals(Constant.DANWEI_KG_L)) {

                addSurplyBean.setUnit(Constant.DANWEI_KG_L);
//                surplusNumDanwei.setText(QIANKE);
            } else {
                addSurplyBean.setUnit(Constant.DANWEI_T);
//                surplusNumDanwei.setText(DUN);
            }


        } else {
            addSurplyBean.setUnit(Constant.DANWEI_T);
        }


        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(addSurplyBean);
        Call<BuJiRespBean> call = HttpManger.getHttpMangerInstance().getServices().addSupply(requestBody);

        call.enqueue(new Callback<BuJiRespBean>() {
            @Override
            public void onResponse(Call<BuJiRespBean> call, Response<BuJiRespBean> response) {
                disDialog();


                BuJiRespBean body = response.body();
                if (body != null) {

                    String message = body.getMessage();

                    boolean res = body.isRes();
                    if (res) {

                        if (message == null) {

                            showTipDialog("添加成功");

                        } else {

                            showTipDialog(message);
                        }

                        return;
                    } else {

                        if (message == null) {
                            Toasty.info(AddgetOilActivity.this, "提交失败", Toast.LENGTH_SHORT, true).show();
                            return;
                        } else {

                            Toasty.info(AddgetOilActivity.this, message, Toast.LENGTH_SHORT, true).show();
                            return;
                        }

                    }

                }

            }

            @Override
            public void onFailure(Call<BuJiRespBean> call, Throwable t) {
                disDialog();
                Log.i(TAG, "onFailure: " + t.getMessage());
                Toasty.info(AddgetOilActivity.this, "提交失败", Toast.LENGTH_SHORT, true).show();
                return;
            }
        });

    }


    public void showTipDialog(String mag) {


        DialogUtils.showAlert(AddgetOilActivity.this, "提示", mag, "", "", "我知道了", "", true, new DialogUIListener() {
            @Override
            public void onPositive() {
//                showToast("onPositive");
                finish();
            }

            @Override
            public void onNegative() {
//                showToast("onNegative");
            }

        }).show();


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.surplus_address:

//                Toast.makeText(this, "点击重新定位", Toast.LENGTH_SHORT).show();
//                locationService.start();// 定位SDK
                startLocatin();
                break;
            case R.id.submit_now:
//                Toast.makeText(this, "提交信息", Toast.LENGTH_SHORT).show();
                submitInfo();
                break;
            case R.id.oil_pici:

//startActivityForResult();

                break;
            case R.id.add_car_ll:

//                startToGetCarNum();

//                Intent intent = new Intent(AddgetOilActivity.this, JiaoJieBanCarListActivity.class);
//
//                startActivityForResult(intent, 103);

//                if (!EventBus.getDefault().isRegistered(AddgetOilActivity.this)) {
//                    EventBus.getDefault().register(AddgetOilActivity.this);
//                }

                Intent intent = new Intent(AddgetOilActivity.this, GetCarListStateActivity.class);

                startActivityForResult(intent, 103);


//                GetCarListStateActivity


                break;

            case R.id.surplus_time:

            {
                DialogUtils.showDatePick(AddgetOilActivity.this, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

//                        Toast.makeText(ReceiveListDetailActivity.this, "时间："+selectedDate, Toast.LENGTH_SHORT).show();
                        surplusTime.setText(selectedDate);

                    }
                }).show();
            }

            break;

        }
    }


//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void OnGetChooseCarState(CarCodeRespBean.BringBean bringBean) {
//
//        LogUtils.i("---选中返回---->" + GsonUtil.GsonString(bringBean));
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 103 && resultCode == 104) {

            final String carInfo = data.getStringExtra("carInfo");

            final CarCodeRespBean.BringBean bringBean = GsonUtil.GsonToBean(carInfo, CarCodeRespBean.BringBean.class);


            LogUtils.i("---选中返回---->" + GsonUtil.GsonString(bringBean));

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    shitCarNo.setText(carNum);
//                    addShitWorkBean.setCarId(carId);

                    moveCarCodeIstv.setContent(bringBean.getCarNum());

                    moveCarDriver.setEditContent(bringBean.getDriveName());

//        moveCarTelphone.setEditTitle("加油车电话");
                    moveCarTelphone.setEditContent(bringBean.getDriveTel());

                }
            });


        }

    }

    public class NFCTagBean {


        /**
         * carnum : 鲁A12345
         * cartype : 补给车
         */

        private String carnum;
        private String cartype;

        public String getCarnum() {
            return carnum;
        }

        public void setCarnum(String carnum) {
            this.carnum = carnum;
        }

        public String getCartype() {
            return cartype;
        }

        public void setCartype(String cartype) {
            this.cartype = cartype;
        }

        @Override
        public String toString() {
            return "NFCTagBean{" +
                    "carnum='" + carnum + '\'' +
                    ", cartype='" + cartype + '\'' +
                    '}';
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//// -----------location config ------------
////        locationService = new LocationServicess(this);
//        locationService = ((ItsmsApplication) (UIUtils.getContext())).locationService;
////获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
//        locationService.registerListener(mListener);
//        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
//        startLocatin();
    }

    public void startLocatin() {
//        locationService.start();// 定位SDK
        // start之后会默认发起一次定位请求，开发者无须判断isstart并主动调用request
    }

    public void stopLocation() {
//        locationService.stop();
    }


    private void checkStorageAndLocationPermission() {
        // 检查是否有存储的读写权限
        // 检查权限的方法: ContextCompat.checkSelfPermission()两个参数分别是Context和权限名.
        // 返回PERMISSION_GRANTED是有权限，PERMISSION_DENIED没有权限
        if (ContextCompat.checkSelfPermission(AddgetOilActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //没有权限，向系统申请该权限。
            Log.i("MY", "没有权限");
            requestPermission(STORAGE_PERMISSION_CODE);
        } else {
            //同组的权限，只要有一个已经授权，则系统会自动授权同一组的所有权限，比如WRITE_EXTERNAL_STORAGE和READ_EXTERNAL_STORAGE
            Log.i(TAG, "checkStorageAndLocationPermission: 已获取存储的读写权限");
        }
        if (ContextCompat.checkSelfPermission(AddgetOilActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Log.i(TAG, "checkStorageAndLocationPermission: 没有授予获取位置的权限");
            requestPermission(LOCATION_PERMISSION_CODE);
        } else {
            //同组的权限，只要有一个已经授权，则系统会自动授权同一组的所有权限，比如WRITE_EXTERNAL_STORAGE和READ_EXTERNAL_STORAGE
            Log.i(TAG, "checkStorageAndLocationPermission: 已获取定位权限权限");

        }
    }


    private void requestPermission(int permissioncode) {
        String permission = getPermissionString(permissioncode);
        if (!IsEmptyOrNullString(permission)) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(AddgetOilActivity.this,
                    permission)) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                if (permissioncode == LOCATION_PERMISSION_CODE) {
                    DialogFragment newFragment = HintDialogFragment.newInstance(R.string.location_description_title,
                            R.string.location_description_why_we_need_the_permission,
                            permissioncode);
                    newFragment.show(getFragmentManager(), HintDialogFragment.class.getSimpleName());
                } else if (permissioncode == STORAGE_PERMISSION_CODE) {
                    DialogFragment newFragment = HintDialogFragment.newInstance(R.string.storage_description_title,
                            R.string.storage_description_why_we_need_the_permission,
                            permissioncode);
                    newFragment.show(getFragmentManager(), HintDialogFragment.class.getSimpleName());
                }
            } else {
                Log.i("MY", "返回false 不需要解释为啥要权限，可能是第一次请求，也可能是勾选了不再询问");
                ActivityCompat.requestPermissions(AddgetOilActivity.this,
                        new String[]{permission}, permissioncode);
            }
        }
    }


    @Override
    public void doPositiveClick(int requestCode) {
        String permission = getPermissionString(requestCode);
        if (!IsEmptyOrNullString(permission)) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                ActivityCompat.requestPermissions(AddgetOilActivity.this,
                        new String[]{permission},
                        requestCode);
            } else {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        }
    }

    @Override
    public void doNegativeClick(int requestCode) {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(AddgetOilActivity.this, "定位权限已获取", Toast.LENGTH_SHORT).show();
                    Log.i("MY", "定位权限已获取");
                    startLocatin();
                } else {
                    Toast.makeText(AddgetOilActivity.this, "定位权限被拒绝", Toast.LENGTH_SHORT).show();
                    Log.i("MY", "定位权限被拒绝");
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        DialogFragment newFragment = HintDialogFragment.newInstance(R.string.location_description_title,
                                R.string.location_description_why_we_need_the_permission,
                                requestCode);
                        newFragment.show(getFragmentManager(), HintDialogFragment.class.getSimpleName());
                        Log.i("MY", "false 勾选了不再询问，并引导用户去设置中手动设置");

                        return;
                    }
                }
                return;
            }
            case STORAGE_PERMISSION_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(AddgetOilActivity.this, "存储权限已获取", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddgetOilActivity.this, "存储权限被拒绝", Toast.LENGTH_SHORT).show();
                    Log.i("MY", "定位权限被拒绝");
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        DialogFragment newFragment = HintDialogFragment.newInstance(R.string.storage_description_title,
                                R.string.storage_description_why_we_need_the_permission,
                                requestCode);
                        newFragment.show(getFragmentManager(), HintDialogFragment.class.getSimpleName());
                        Log.i("MY", "false 勾选了不再询问，并引导用户去设置中手动设置");
                    }
                    return;
                }
            }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private String getPermissionString(int requestCode) {
        String permission = "";
        switch (requestCode) {
            case LOCATION_PERMISSION_CODE:
                permission = Manifest.permission.ACCESS_FINE_LOCATION;
                break;
            case STORAGE_PERMISSION_CODE:
                permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
                break;
        }
        return permission;
    }

    public static boolean IsEmptyOrNullString(String s) {
        return (s == null) || (s.trim().length() == 0);
    }


    @Override
    public void onNewIntent(Intent intent) {
        //1.获取Tag对象
        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        //2.获取Ndef的实例

        if (detectedTag != null) {
            Ndef ndef = Ndef.get(detectedTag);
//        mTagText = ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n";

//            Toast.makeText(this, "==onNewIntent>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n", Toast.LENGTH_SHORT).show();
//            Log.i(TAG, "onNewIntent: ==>>>" + ndef.getType() + "\nmaxsize:" + ndef.getMaxSize() + "bytes\n\n");

            if (ndef == null) {

                jumpToAddTag();

            }

            readNfcTag(intent);


//        mNfcText.setText(mTagText);
        }
    }

    private void jumpToAddTag() {


        DialogUtils.showAlert(AddgetOilActivity.this, "", "发现空标签是否前去添加", "", "", "确定", "取消", false, new DialogUIListener() {
            @Override
            public void onPositive() {

                startActivity(new Intent(UIUtils.getContext(), WriteNFCUI.class));

            }

            @Override
            public void onNegative() {


            }

        }).show();

    }

    /**
     * 读取NFC标签文本数据
     */
    private void readNfcTag(Intent intent) {
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
                    NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage msgs[] = null;
            int contentSize = 0;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                    contentSize += msgs[i].toByteArray().length;
                }
            }
            try {
                if (msgs != null) {
                    NdefRecord record = msgs[0].getRecords()[0];
                    String textRecord = parseTextRecord(record);
//                    mTagText += textRecord + "\n\ntext\n" + contentSize + " bytes";
//                    Toast.makeText(this, "数据" + textRecord + "\n\ntext\n" + contentSize + " bytes", Toast.LENGTH_SHORT).show();


//                    getDataFromServer(textRecord);
                    Log.i(TAG, "readNfcTag: " + textRecord + "\n\ntext\n" + contentSize + " bytes");

                    if (TextUtils.isEmpty(textRecord)) {
                        Toast.makeText(this, "读取数据错误，请重新扫描标签", Toast.LENGTH_SHORT).show();
//                        supplyCarCode.setEditContent("");
                        moveCarCodeIstv.setContent("");
                    } else {
//                        Intent intetJump = new Intent(UIUtils.getContext(), AddgetOilActivity.class);
//                        intetJump.putExtra("nfcdata", textRecord);
//                        startActivity(intetJump);

                        NFCTagBean tagBean = parseStrToBean(textRecord);

                        if (tagBean != null) {
//                            supplyCarCode.setEditContent(tagBean.getCarnum());
//                            moveCarCode.setEditContent(tagBean.getCarnum());
                            moveCarCodeIstv.setContent(tagBean.getCarnum());

                            getCarInfoFromServer();

                        } else {
//                            supplyCarCode.setEditContent("");
//                            moveCarCode.setEditContent("");
                            moveCarCodeIstv.setContent("");
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    private void getCarInfoFromServer() {


    }


    /**
     * 解析NDEF文本数据，从第三个字节开始，后面的文本数据
     *
     * @param ndefRecord
     * @return
     */
    public static String parseTextRecord(NdefRecord ndefRecord) {
        /**
         * 判断数据是否为NDEF格式
         */
        //判断TNF
        if (ndefRecord.getTnf() != NdefRecord.TNF_WELL_KNOWN) {
            return null;
        }
        //判断可变的长度的类型
        if (!Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
            return null;
        }
        try {
            //获得字节数组，然后进行分析
            byte[] payload = ndefRecord.getPayload();
            //下面开始NDEF文本数据第一个字节，状态字节
            //判断文本是基于UTF-8还是UTF-16的，取第一个字节"位与"上16进制的80，16进制的80也就是最高位是1，
            //其他位都是0，所以进行"位与"运算后就会保留最高位
            String textEncoding = ((payload[0] & 0x80) == 0) ? "UTF-8" : "UTF-16";
            //3f最高两位是0，第六位是1，所以进行"位与"运算后获得第六位
            int languageCodeLength = payload[0] & 0x3f;
            //下面开始NDEF文本数据第二个字节，语言编码
            //获得语言编码
            String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            //下面开始NDEF文本数据后面的字节，解析出文本
            String textRecord = new String(payload, languageCodeLength + 1,
                    payload.length - languageCodeLength - 1, textEncoding);
            return textRecord;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    protected void onStop() {
//        locationService.unregisterListener(mListener); //注销掉监听
//        locationService.stop(); //停止定位服务
        super.onStop();
    }

    /**
     * 定位监听
     */
    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation location) {
            if (null != location) {

                StringBuffer sb = new StringBuffer();
                //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
                if (location.getErrorCode() == 0) {

                    surplusAddress.setEditContent(location.getAddress());
//                    //定位完成的时间
                    sb.append("定位时间: " + Utils.formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                } else {
                    //定位失败

                    Toasty.info(AddgetOilActivity.this, "定位失败请手动输入", Toast.LENGTH_SHORT, true).show();

                }


                if (locationClient != null) {
                    // 停止定位
                    locationClient.stopLocation();
                }

            } else {
//                tvResult.setText("定位失败，loc is null");

                Log.i(TAG, "onLocationChanged: " + "定位失败，loc is null");

            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }

    /**
     * 销毁定位
     *
     * @author hongming.wang
     * @since 2.8.0
     */
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

}
