package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.adapter.AddressListAdapter;
import com.neocom.mobilerefueling.bean.AddressListRequest;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.neocom.mobilerefueling.view.TopTitleBar;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/8/14.
 */

public class AddressListActivity extends BaseActivity implements View.OnClickListener {

    private List<AddressListRequest.BringBean> listBeanList;
    //    private Button addAddress;
    Gson gson;
    private AddressListAdapter listAdapter;
    public static List<AddressListRequest.BringBean> listAddressSelect;
    private ListView addressListLv;
    private LinearLayout addAddressLl;
    private String DEFAULT_ADDRESS = "1";

    @Override
    public void initContentView() {

        setContentView(R.layout.address_list_activity);

    }

    @Override
    public void initView() {

        TopTitleBar topTitleBar = (TopTitleBar) findViewById(R.id.address_list_top);
        topTitleBar.setTitleText("选择地址");

        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary).fitsSystemWindows(true).init();
        addressListLv = (ListView) findViewById(R.id.address_list_lv);

//        addAddress = (Button) findViewById(R.id.add_addres);

        addAddressLl = (LinearLayout) findViewById(R.id.add_address_ll);
        addAddressLl.setOnClickListener(this);


        topTitleBar.getFinishLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        topTitleBar.getOKLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Toast.makeText(UIUtils.getContext(), "选好了", Toast.LENGTH_SHORT).show();

                Log.i(TAG, "onClick: " + listAddressSelect.toString());

                String selectBeanToJson = null;
                for (int i = 0; i < listAddressSelect.size(); i++) {
                    AddressListRequest.BringBean bean = listAddressSelect.get(i);

                    if (bean.isChecked()) {

                        Log.i(TAG, "onClick: " + bean.toString());

                        selectBeanToJson = gson.toJson(bean);
                    }

                }

                if (selectBeanToJson == null) {

                    for (int i = 0; i < listAddressSelect.size(); i++) {
                        AddressListRequest.BringBean bean = listAddressSelect.get(i);
                        if (DEFAULT_ADDRESS.equals(bean.getIsDefault())) {
                            selectBeanToJson = gson.toJson(bean);
                        }

                    }

                }

                Intent intent = new Intent();
                intent.putExtra("address", selectBeanToJson);
                setResult(Constant.ADDRESS_RESP, intent);
                finish();

            }
        });


        addressListLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                startActivityForResult();

                startActivity(new Intent(UIUtils.getContext(), ChooseAddress.class));

            }
        });
        gson = new Gson();
        listAddressSelect = new ArrayList<>();
    }

    @Override
    public void initData() {

//        listBeanList = new ArrayList<>();
//
//        for (int i = 0; i < 6; i++) {
//
//            AddressListBean addressListBean = new AddressListBean();
//
//            addressListBean.setProvince("山东" + i);
////            addressListBean.setCity("济南" + i);
////            addressListBean.setArea("高新区" + i);
//            addressListBean.setDetail("详细地址" + i);
//            addressListBean.setUserName("张三" + i);
//            addressListBean.setUserPhone("电话" + i);
//
//            listBeanList.add(addressListBean);
//        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        getDataFromServer();
    }

    private void getDataFromServer() {

        RequestAddressUserId userId = new RequestAddressUserId(GetUserInfoUtils.getUserInfo().getUserId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(userId);
        Call<AddressListRequest> call = HttpManger.getHttpMangerInstance().getServices().searchAddressListByUserId(requestBody);
        call.enqueue(new Callback<AddressListRequest>() {
            @Override
            public void onResponse(Call<AddressListRequest> call, Response<AddressListRequest> response) {


                AddressListRequest body = response.body();

                if (body != null) {

                    List<AddressListRequest.BringBean> bringBeen = body.getBring();

                    if (bringBeen == null) {
                        Log.i(TAG, "onResponse: 数据为空");
                    } else {
                        parseBean(bringBeen);
                    }

                }

            }

            @Override
            public void onFailure(Call<AddressListRequest> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });


    }

    private void parseBean(List<AddressListRequest.BringBean> bringBeen) {

        listAdapter = new AddressListAdapter(AddressListActivity.this, bringBeen);
        addressListLv.setAdapter(listAdapter);


    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, ChooseAddress.class);
        intent.putExtra("type", "add");
        startActivityForResult(intent, Constant.ADDRESS_LIST_REQUESTCODE);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        Toast.makeText(UIUtils.getContext(), ">>" + requestCode + ";;" + resultCode + "::" + data.getStringExtra("address_data").toString(), Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onActivityResult:外" + data.getStringExtra("address_data").toString());
        if (Constant.ADDRESS_LIST_REQUESTCODE == requestCode && Constant.ADDRESS_LIST_RESP == resultCode) {
            String dataJson = data.getStringExtra("address_data").toString();
//            data.getStringExtra()
            Log.i(TAG, "onActivityResult:" + dataJson);

            AddressListRequest.BringBean addressAdd = gson.fromJson(dataJson, AddressListRequest.BringBean.class);

            Log.i(TAG, "onActivityResult: addressAdd" + addressAdd.toString());
            listBeanList.add(addressAdd);
            listAdapter.notifyDataSetChanged();


        }


    }


    public class RequestAddressUserId {

        private String userId;

        public RequestAddressUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        @Override
        public String toString() {
            return "RequestAddressUserId{" +
                    "userId='" + userId + '\'' +
                    '}';
        }
    }


}
