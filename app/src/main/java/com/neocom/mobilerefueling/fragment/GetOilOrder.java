//package com.neocom.mobilerefueling.fragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.neocom.mobilerefueling.R;
//import com.neocom.mobilerefueling.activity.GetPiCiActivity;
//import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
//import com.neocom.mobilerefueling.bean.GetOilOrderBean;
//import com.neocom.mobilerefueling.globle.Constant;
//import com.neocom.mobilerefueling.net.HttpManger;
//import com.neocom.mobilerefueling.utils.GetUserInfoUtils;
//import com.neocom.mobilerefueling.utils.UIUtils;
//import com.widget.jcdialog.DialogUtils;
//import com.widget.jcdialog.listener.DialogUIDateTimeSaveListener;
//import com.widget.jcdialog.listener.DialogUIListener;
//import com.widget.jcdialog.widget.DateSelectorWheelView;
//
//import butterknife.BindView;
//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by admin on 2017/8/28.
// */
//
//public class GetOilOrder extends BaseFragment implements View.OnClickListener {
//
//    @BindView(R.id.get_oil_carno)
//    TextView getOilCarno;
//    @BindView(R.id.car_no_et)
//    EditText carNoEt;
//    @BindView(R.id.car_driver_et)
//    EditText carDriverEt;
//    @BindView(R.id.car_driver_phone_et)
//    EditText carDriverPhoneEt;
//    @BindView(R.id.car_no_remain_et)
//    EditText carNoRemainEt;
//    @BindView(R.id.car_get_oil_et)
//    EditText carGetOilEt;
//    @BindView(R.id.car_get_oil_time_et)
//    TextView carGetOilTimeEt;
//    @BindView(R.id.car_get_oil_pici_et)
//    TextView carGetOilPiciEt;
//    @BindView(R.id.car_get_note_et)
//    EditText carGetNoteEt;
//    @BindView(R.id.commit)
//    Button commit;
//    //    Unbinder unbinder;
//    private View view;
//
//    @BindView(R.id.pici_ll)
//    LinearLayout piciLl;
//
//    @BindView(R.id.choose_oil_time)
//    LinearLayout chooseTime;
//    private int reqCode= 202;
//
//    @Override
//    public View initContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//
//        view = UIUtils.inflate(R.layout.get_oil_layout);
//
//        return view;
//    }
//
//    @Override
//    public void initView() {
//
//        commit.setOnClickListener(this);
//        chooseTime.setOnClickListener(this);
//        piciLl.setOnClickListener(this);
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//
//            case R.id.commit:
////                提交
//                Toast.makeText(UIUtils.getContext(), "提交", Toast.LENGTH_SHORT).show();
//                getOilCommit();
//                break;
//
//
//            case  R.id.choose_oil_time:
//
//            {
//                DialogUtils.showDatePick(getActivity(), Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
//                    @Override
//                    public void onSaveSelectedDate(int tag, String selectedDate) {
//
//                        carGetOilTimeEt.setText(selectedDate);
//
//                    }
//                }).show();
//            }
//
//                break;
//
//            case R.id.pici_ll:
//
//                Intent intent=new Intent(UIUtils.getContext(), GetPiCiActivity.class);
//
////                startActivityForResult(intent, reqCode);
//                startActivity(intent);
//
//                break;
//
//
//        }
//
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
//
////        if (requestCode==reqCode)
//
//
//    }
//
//    public void getOilCommit() {
//        String carNo = carNoEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carNo)) {
//            Toast.makeText(UIUtils.getContext(), "请输入车牌号", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        String carDriverName = carDriverEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carDriverName)) {
//            Toast.makeText(UIUtils.getContext(), "请输入提油司机", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        String carDriverPhone = carDriverPhoneEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carDriverPhone)) {
//            Toast.makeText(UIUtils.getContext(), "请输入提油司机电话", Toast.LENGTH_SHORT).show();
//            return;
//
//        }
//
//        String carNoRemain = carNoRemainEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carNoRemain)) {
//            Toast.makeText(UIUtils.getContext(), "请输入剩余油量", Toast.LENGTH_SHORT).show();
//            return;
//
//        }
//
//        String carGetOil = carGetOilEt.getText().toString().trim();
//
//
//        if (TextUtils.isEmpty(carGetOil)) {
//            Toast.makeText(UIUtils.getContext(), "请输入提取油量", Toast.LENGTH_SHORT).show();
//            return;
//
//        }
//
//        String carGetOilTime = carGetOilTimeEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carGetOilTime)) {
//            Toast.makeText(UIUtils.getContext(), "请输入提油时间", Toast.LENGTH_SHORT).show();
//            return;
//
//        }
//
//
//        String carGetOilPici = carGetOilPiciEt.getText().toString().trim();
//
//        if (TextUtils.isEmpty(carGetOilPici)) {
//            Toast.makeText(UIUtils.getContext(), "请输入油品批次", Toast.LENGTH_SHORT).show();
//            return;
////            carGetOilPici = "3aa74abad7ff49198c9ee93a9789b513";
//        }
//
//        String carGetNote = carGetNoteEt.getText().toString().trim();
//        if (TextUtils.isEmpty(carGetNote)) {
//            carGetNote = "";
//        }
//
//        GetOilOrderBean getOilOrderBean = new GetOilOrderBean();
//
//        getOilOrderBean.setCarCode(carNo);
//        getOilOrderBean.setDriver(carDriverName);
//        getOilOrderBean.setTelphone(carDriverPhone);
//
//        getOilOrderBean.setSurplusOil(carNoRemain);
//
//        getOilOrderBean.setPurchaseNum(carGetOil);
//
//        String carGetOilTimeNew= carGetOilTime.replace("年","-").replace("月","-").replace("日","-");
//
//        getOilOrderBean.setPurchaseTime(carGetOilTimeNew);
//
//
//        getOilOrderBean.setBatchId(carGetOilPici);
//
//        getOilOrderBean.setConfirmPeople("");
//        getOilOrderBean.setConfirmTime("");
//        getOilOrderBean.setC_dt(UIUtils.getCurrentTime());
//        getOilOrderBean.setC_user(GetUserInfoUtils.getUserInfo().getUserId());
//        getOilOrderBean.setRemarks(carGetNote);
//        getOilOrderBean.setRecordStatus("1");
//
//        String toJson = new Gson().toJson(getOilOrderBean);
//
//
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJson);
//
//        Call<EmptyBringGetOilBean> call = HttpManger.getHttpMangerInstance().getServices().addPurchase(requestBody);
//        call.enqueue(new Callback<EmptyBringGetOilBean>() {
//            @Override
//            public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
////                Log.i(TAG, "onResponse: " + response.body().toString());
//                EmptyBringGetOilBean body = response.body();
//
//                if (body != null) {
//
//
//                    if (body.isRes()){
//
//                        showDialog("订单提交成功");
//
//                    }else{
//
//                        showDialog("订单提交失败，请检查");
//                    }
//
//                }
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
//
//                Log.i(TAG, "onFailure: " + t.getMessage());
//                showDialog("订单提交失败，请检查");
//            }
//        });
//
//    }
//
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
////        // TODO: inflate a fragment view
////        View rootView = super.onCreateView(inflater, container, savedInstanceState);
////        unbinder = ButterKnife.bind(this, rootView);
////        return rootView;
////    }
//
////    @Override
////    public void onDestroyView() {
////        super.onDestroyView();
////        unbinder.unbind();
////    }
//
//
//
//    public void showDialog(String mag){
//
//
//
//        DialogUtils.showAlert(getActivity(), "提示", mag, "", "", "我知道了", "", true, new DialogUIListener() {
//            @Override
//            public void onPositive() {
////                showToast("onPositive");
//            }
//
//            @Override
//            public void onNegative() {
////                showToast("onNegative");
//            }
//
//        }).show();
//
//
//    }
//
//
//}
