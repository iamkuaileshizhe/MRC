package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.SubmintAddressBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/11.
 */

public class ChooseAddress extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    //    AddressListBean addressListBean;
    private EditText addressDetail;
    private CheckBox addressDefault;
    private TextView addressName;
    private TextView addressPhone;
    private TextView addressChoose;
    //    private String tx;
    private int reqtCode = 200;
    SubmintAddressBean addressBean;

    @Override
    public void initContentView() {
        setContentView(R.layout.choose_address_layout);
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).fitsSystemWindows(true).init();

        addressBean = new SubmintAddressBean();
//        addressListBean = new AddressListBean();

//        openType=”add” 新增地址
//        openType=”update” 修改地址


    }

    @Override
    public void initView() {

        TopTitleBar topTitleBar = (TopTitleBar) findViewById(R.id.choose_address_top);

        topTitleBar.setTitleText("编辑地址");

        RelativeLayout addressChooseZone = (RelativeLayout) findViewById(R.id.choose_address_zone);
        addressChooseZone.setOnClickListener(this);

        addressDetail = (EditText) findViewById(R.id.choose_address_detail);
        addressDefault = (CheckBox) findViewById(R.id.default_cb);
        addressPhone = (TextView) findViewById(R.id.choose_address_phone);
        addressName = (TextView) findViewById(R.id.choose_address_name);
        addressChoose = (TextView) findViewById(R.id.choose_address_addr);

        Button okBtn = (Button) findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);
        addressDefault.setOnCheckedChangeListener(this);
        topTitleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        topTitleBar.setOKLayoutVisibility(View.GONE);

//        topTitleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(UIUtils.getContext(), "选好了", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.putExtra("address", "这时返回值");
//                setResult(Constant.ADDRESS_RESP,intent);
//                finish();
//
//            }
//        });


        Intent intent = getIntent();

        String type = intent.getStringExtra("type");
        if ("add".equals(type)) {
            addressBean.setOpenType("add");
            addressBean.setCname("");
        } else if ("update".equals(type)) {

//            intent.putExtra("type", "update");
//            intent.putExtra("address", bringBean.getAddress());
//            intent.putExtra("area", bringBean.getArea());
//            intent.putExtra("pname", bringBean.getPname());
//            intent.putExtra("telphone", bringBean.getTelphone());
//
//            intent.putExtra("continentId", bringBean.getProvince());
//            intent.putExtra("countryId", bringBean.getCity());
//            intent.putExtra("provinceId", bringBean.getRegion());
//            intent.putExtra("cityId", bringBean.getTowns());

            String id = intent.getStringExtra("id");
            addressBean.setId(id);
            String address = intent.getStringExtra("address");
            addressChoose.setText(address);
            String area = intent.getStringExtra("area");
            addressDetail.setText(area);
            String pname = intent.getStringExtra("pname");
            addressName.setText(pname);
            String telphone = intent.getStringExtra("telphone");
            addressPhone.setText(telphone);
            String continentId = intent.getStringExtra("continentId");
            addressBean.setProvince(continentId);
            String countryId = intent.getStringExtra("countryId");
            addressBean.setCity(countryId);
            String provinceId = intent.getStringExtra("provinceId");
            addressBean.setRegion(provinceId);
            String cityId = intent.getStringExtra("cityId");
            addressBean.setTowns(cityId);

        }

    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.choose_address_zone:

                startGetAddress();

                break;

            case R.id.ok_btn:
//                Toast.makeText(UIUtils.getContext(), "选好了", Toast.LENGTH_SHORT).show();

//                if (TextUtils.isEmpty(tx)) {
//                    Toast.makeText(this, "请选择区域", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                String pName = addressName.getText().toString().trim();

                if (TextUtils.isEmpty(pName)) {
                    Toast.makeText(UIUtils.getContext(), "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    addressBean.setPname(pName);
                }

                String telphone = addressPhone.getText().toString().trim();

                if (TextUtils.isEmpty(telphone)) {
                    Toast.makeText(UIUtils.getContext(), "请输入联系电话", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    addressBean.setTelphone(telphone);
                }

//                addressBean.setProvince(continentId);
//                addressBean.setCity(countryId);

                if (TextUtils.isEmpty(addressBean.getProvince()) || TextUtils.isEmpty(addressBean.getCity())) {
                    Toast.makeText(UIUtils.getContext(), "请选择地址", Toast.LENGTH_SHORT).show();
                    return;
                }


                String addressDetail = this.addressDetail.getText().toString().trim();
                if (TextUtils.isEmpty(addressDetail)) {
                    Toast.makeText(UIUtils.getContext(), "请填写详细地址", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    addressBean.setArea(addressDetail);
                }

                addressBean.setUserId(GetUserInfoUtils.getUserInfo().getUserId());

//                addressListBean.setDetail(addressDetail);
//
//                addressListBean.setDefault(addressDefault.isChecked());
//
//                addressListBean.setUserName(addressName.getText().toString().trim());
//
//                addressListBean.setUserPhone(addressPhone.getText().toString().trim());


//                Gson gson = new Gson();
//                String toJson = gson.toJson(addressListBean);
//                Log.i(TAG, "onClick: ->" + toJson);
//                Intent intent = new Intent();
//                intent.putExtra("address_data", toJson);
//                setResult(Constant.ADDRESS_LIST_RESP, intent);
//                finish();

                Log.i(TAG, "onClick: ---" + new Gson().toJson(addressBean));

                RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(addressBean);
                Call<EmptyBringGetOilBean> call = HttpManger.getHttpMangerInstance().getServices().saveOrUpdateAddress(requestBody);
                call.enqueue(new Callback<EmptyBringGetOilBean>() {
                    @Override
                    public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {

                        EmptyBringGetOilBean body = response.body();

                        if (body == null) {
                            showDialog("提交异常");
                        } else {
//                            showDialog(body.getMessage());
                            Toast.makeText(ChooseAddress.this, "更新成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
                        Log.i(TAG, "onFailure: " + t.getMessage());
                        showDialog("提交失败");
                    }
                });


                break;

        }
    }


    public void showDialog(String msg) {

        DialogUtils.showAlert(ChooseAddress.this, "提示", msg, "", "", "我知道了", "", true, new DialogUIListener() {
            @Override
            public void onPositive() {
//                showToast("onPositive");
            }

            @Override
            public void onNegative() {
//                showToast("onNegative");
            }

        }).show();


    }


    private void startGetAddress() {

        Intent i = new Intent(this, SelectAddRessActivity.class);

        startActivityForResult(i, reqtCode);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == reqtCode && resultCode == 201) {

            String continent = data.getStringExtra("continent");
            String continentId = data.getStringExtra("continentId");
            String country = data.getStringExtra("country");
            String countryId = data.getStringExtra("countryId");
            String province = data.getStringExtra("province");
            String provinceId = data.getStringExtra("provinceId");
            String city = data.getStringExtra("city");
            String cityId = data.getStringExtra("cityId");

            Log.i(TAG, "onActivityResult: ==>>" + continent + "==" + country + "==" + province + "==" + city);
            Log.i(TAG, "onActivityResult: ========================================================");
            Log.i(TAG, "onActivityResult: ==>>" + continentId + "==" + countryId + "==" + provinceId + "==" + cityId);

            addressChoose.setText(continent + country + (province == null ? "" : province) + (city == null ? "" : city));

            addressBean.setProvince(continentId);
            addressBean.setCity(countryId);
            addressBean.setRegion(provinceId);
            addressBean.setTowns(cityId);

        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            addressBean.setIsDefault("1");// 设置 default 默认
        } else {
            addressBean.setIsDefault("0");// 不是 默认
        }

    }
}
