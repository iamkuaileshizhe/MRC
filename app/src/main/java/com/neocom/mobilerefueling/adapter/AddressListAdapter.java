package com.neocom.mobilerefueling.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.activity.AddressListActivity;
import com.neocom.mobilerefueling.activity.ChooseAddress;
import com.neocom.mobilerefueling.bean.AddressListRequest;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.utils.UIUtils;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.widget.jcdialog.utils.ToastUitl.showToast;

/**
 * Created by admin on 2017/8/14.
 */

public class AddressListAdapter extends BaseAdapter {

    private List<AddressListRequest.BringBean> listBeanList;
    ViewHolder holder;
    Context context;

    public AddressListAdapter(Context context, List<AddressListRequest.BringBean> listBeanList) {
        this.listBeanList = listBeanList;
        this.context = context;
    }

    @Override
    public int getCount() {

        if (listBeanList != null && listBeanList.size() > 0) {
            return listBeanList.size();
        }
        return 0;
    }

    @Override
    public AddressListRequest.BringBean getItem(int i) {
        return listBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            holder = new ViewHolder();
            convertView = UIUtils.inflate(R.layout.address_list_layout);

            holder.province = convertView.findViewById(R.id.address_list_province_tv);
//            holder.city = convertView.findViewById(R.id.address_list_city_tv);
//            holder.area = convertView.findViewById(R.id.address_list_area_tv);
            holder.detail = convertView.findViewById(R.id.address_list_detail_tv);
            holder.name = convertView.findViewById(R.id.address_list_name_tv);
            holder.phone = convertView.findViewById(R.id.address_list_phone_tv);
            holder.defaultAddress = convertView.findViewById(R.id.address_default_cb);
            holder.addressAllInfo = convertView.findViewById(R.id.address_all_info);
            holder.addressChecked = convertView.findViewById(R.id.address_checked);

            holder.addressItemEditLl = convertView.findViewById(R.id.address_item_edit_ll);
            holder.addressDelete = convertView.findViewById(R.id.address_delete);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();

        }
        AddressListRequest.BringBean addressListBean = (AddressListRequest.BringBean) getItem(position);

        if (addressListBean != null) {
//            holder.province.setText(addressListBean.getProvince().toString().trim()+addressListBean.getCity().toString().trim()+addressListBean.getRegion().toString().trim());
            holder.province.setText(addressListBean.getAddress());
//            holder.detail.setText(addressListBean.getArea()); // 详细地址
            holder.name.setText(addressListBean.getPname());
            holder.phone.setText(addressListBean.getTelphone());
        }

        if (("1").equals(listBeanList.get(position).getIsDefault())) {

            ((AddressListRequest.BringBean) getItem(position)).setIsDefault("1");
            holder.defaultAddress.setChecked(true);
            holder.defaultAddress.setText("默认地址");
            notifyDataSetChanged();
        } else {
            holder.defaultAddress.setChecked(false);
            holder.defaultAddress.setText("设为默认");
        }

        holder.defaultAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// 0 表示 不是 默认地址 1 表示 是默认地址
                for (AddressListRequest.BringBean bean : listBeanList) {
                    bean.setIsDefault("0");
                    holder.defaultAddress.setChecked(false);
                    holder.defaultAddress.setText("设为默认");
                }
                ((AddressListRequest.BringBean) getItem(position)).setIsDefault("1");
                holder.defaultAddress.setText("默认地址");
                notifyDataSetChanged();
            }
        });


        holder.addressAllInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (AddressListRequest.BringBean bean : listBeanList) {

                    bean.setChecked(false);
                    holder.addressChecked.setVisibility(View.GONE);

                }
                holder.addressChecked.setVisibility(View.VISIBLE);
                ((AddressListRequest.BringBean) getItem(position)).setChecked(true);
                notifyDataSetChanged();
            }
        });

        holder.addressItemEditLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "跳转地址编辑", Toast.LENGTH_SHORT).show();
                AddressListRequest.BringBean bringBean = listBeanList.get(position);
                Intent intent = new Intent(context, ChooseAddress.class);
                intent.putExtra("type", "update");
                intent.putExtra("pname", bringBean.getPname());
                intent.putExtra("telphone", bringBean.getTelphone());
                intent.putExtra("id", bringBean.getId());

                intent.putExtra("continentId", bringBean.getProvince());
                intent.putExtra("countryId", bringBean.getCity());
                intent.putExtra("provinceId", bringBean.getRegion());
                intent.putExtra("cityId", bringBean.getTowns());
                intent.putExtra("area", bringBean.getArea());
                intent.putExtra("address", bringBean.getAddress());
                context.startActivity(intent);

            }
        });

        holder.addressDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "删除地址", Toast.LENGTH_SHORT).show();

                DialogUtils.showAlert((Activity) context, "提示", "确定删除该地址么", "", "", "确定", "取消", false, new DialogUIListener() {
                    @Override
                    public void onPositive() {

                       String  deleteBringBeanId = listBeanList.get(position).getId();

//                        Toast.makeText(context, "确定", Toast.LENGTH_SHORT).show();

                        if (TextUtils.isEmpty(deleteBringBeanId)){
                            Toast.makeText(context, "删除异常请稍后重试", Toast.LENGTH_SHORT).show();
                        }else{
                            DeleteId deleteId=new DeleteId();
                            deleteId.setId(deleteBringBeanId);
                            deleteAddress(deleteId,position);
                        }

                    }

                    @Override
                    public void onNegative() {
//                        Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                    }

                }).show();

            }
        });


//        if (((AddressListRequest.BringBean) getItem(position)).isChecked()) {
//            holder.defaultAddress.setChecked(true);
//            holder.defaultAddress.setText("默认地址");
//        } else {
//            holder.defaultAddress.setChecked(false);
//            holder.defaultAddress.setText("设为默认");
//        }

        if (((AddressListRequest.BringBean) getItem(position)).isChecked()) {
            holder.addressChecked.setVisibility(View.VISIBLE);
        } else {
            holder.addressChecked.setVisibility(View.GONE);

        }
//        Log.i("data==>", "getView单个: "+getItem(position).toString());
//        Log.i("data==>", "getView全部: "+listBeanList.toString());

        AddressListActivity.listAddressSelect = listBeanList;
        return convertView;
    }

    private void deleteAddress(DeleteId deleteId, final int position) {


        RequestBody body = HttpManger.getHttpMangerInstance().getRequestBody(deleteId);
        Call<EmptyBringGetOilBean> call = HttpManger.getHttpMangerInstance().getServices().deleteAddress(body);
call.enqueue(new Callback<EmptyBringGetOilBean>() {
    @Override
    public void onResponse(Call<EmptyBringGetOilBean> call, Response<EmptyBringGetOilBean> response) {
        listBeanList.remove(position);
        notifyDataSetChanged();
//        Log.i("删除成功", "onResponse: "+response.body().toString());
    }

    @Override
    public void onFailure(Call<EmptyBringGetOilBean> call, Throwable t) {
        Log.i("删除失败", "onFailure: "+t.getMessage());
    }
});
    }


    public class DeleteId{

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "deleteId{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

//    @Override
//    public void onClick(View view) {
//
//
////        listBeanList
//
//
//
//
//    }

    static class ViewHolder {
        TextView province;
        //        TextView city;
//        TextView area;
        TextView detail;
        TextView name;
        TextView phone;
        CheckBox defaultAddress;
        LinearLayout addressAllInfo;
        ImageView addressChecked;

        LinearLayout addressItemEditLl;
        LinearLayout addressDelete;

    }


}
