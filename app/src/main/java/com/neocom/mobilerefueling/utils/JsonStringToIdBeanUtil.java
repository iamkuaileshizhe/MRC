package com.neocom.mobilerefueling.utils;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neocom.mobilerefueling.bean.ChildItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */

public class JsonStringToIdBeanUtil {

    public static List<ChildItemBean> contractList = new ArrayList<>();

    public static List<ChildItemBean> handleJson(String key, String value, String json) {


        List<ChildItemBean> childItemBeen = new ArrayList<>();
        JsonParser parser = new JsonParser();

        JsonArray jsonArray = parser.parse(json).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {

            ChildItemBean itemBean = new ChildItemBean();

            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

//            LogUtils.i("---jsonObj-" + GsonUtil.GsonString(jsonObject));

            String mapKey = jsonObject.get(key).getAsString();
            String mapValue = jsonObject.get(value).getAsString();

            itemBean.setItemId(mapKey);
            itemBean.setItemValue(mapValue);

            JsonElement jsonElement = jsonObject.get("telephone");
            JsonElement jsonElementLinkman = jsonObject.get("linkman");
            JsonElement jsonElementAddress = jsonObject.get("address");
            JsonElement jsonElementSupplyStatus = jsonObject.get("supplyStatus");
            JsonElement jsonElementSupplyId = jsonObject.get("supplyId");
            if (jsonElement != null && !jsonElement.isJsonNull()) {

                String telephone = jsonElement.getAsString();
                if (!TextUtils.isEmpty(telephone)) {
                    itemBean.setItemTelephone(telephone);
                }

            }

            if (jsonElementLinkman != null && !jsonElementLinkman.isJsonNull()) {

                String linkMan = jsonElementLinkman.getAsString();

                if (!TextUtils.isEmpty(linkMan)) {
                    itemBean.setItemLinkMan(linkMan);
                }

            }

            if (jsonElementAddress != null && !jsonElementAddress.isJsonNull()) {


                String address = jsonElementAddress.getAsString();

                if (!TextUtils.isEmpty(address)) {
                    itemBean.setItemAddress(address);
                }


            }
            if (jsonElementSupplyStatus != null && !jsonElementSupplyStatus.isJsonNull()) {
                String supplyStatusStr = jsonElementSupplyStatus.getAsString();

                if (!TextUtils.isEmpty(supplyStatusStr)) {
                    itemBean.setItemSupplyStatus(supplyStatusStr);
                }
            }
            if (jsonElementSupplyId != null && !jsonElementSupplyId.isJsonNull()) {
                String supplyIdStr = jsonElementSupplyId.getAsString();


                ChildItemBean childItemContract = new ChildItemBean();

                childItemContract.setItemId(mapKey);
                childItemContract.setItemValue(mapValue);
                childItemContract.setItemSupplyId(supplyIdStr);

                contractList.add(childItemContract);

                if (!TextUtils.isEmpty(supplyIdStr)) {
                    itemBean.setItemSupplyId(supplyIdStr);
                }
            }


//            LogUtils.i("--转换后-" + GsonUtil.GsonString(itemBean));

            childItemBeen.add(itemBean);
        }


//        LogUtils.i("---传值--" + json);

        return childItemBeen;
    }


    public static List<ChildItemBean> contractFilter(String filterSupplyId) {

        LogUtils.i("关键字--》" + filterSupplyId);

        List<ChildItemBean> filterContract = new ArrayList<>();

        if (contractList != null && contractList.size() > 0) {


            for (int i = 0; i < contractList.size(); i++) {

                ChildItemBean itemBean = contractList.get(i);
                String itemSupplyId = itemBean.getItemSupplyId();

                if (!TextUtils.isEmpty(itemSupplyId) && !TextUtils.isEmpty(filterSupplyId)) {


                    if (itemSupplyId.equals(filterSupplyId)) {

                        filterContract.add(itemBean);


                    }
                }
            }


        }

        LogUtils.i("--过滤合同结果-" + GsonUtil.GsonString(filterContract));

        return filterContract;
    }


}
