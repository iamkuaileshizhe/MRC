package com.neocom.mobilerefueling.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.neocom.mobilerefueling.bean.CarNumBean;
import com.neocom.mobilerefueling.bean.ChildItemBean;
import com.neocom.mobilerefueling.bean.DanWeiBean;
import com.neocom.mobilerefueling.bean.DicBean;
import com.neocom.mobilerefueling.bean.IdBean;
import com.neocom.mobilerefueling.bean.JBRBringBean;
import com.neocom.mobilerefueling.bean.JBRConListBean;
import com.neocom.mobilerefueling.bean.JingBanRenRespBean;
import com.neocom.mobilerefueling.bean.LabelDataBean;
import com.neocom.mobilerefueling.bean.ProcessAgreeBean;
import com.neocom.mobilerefueling.bean.StartProcessBean;
import com.neocom.mobilerefueling.bean.StoreBean;
import com.neocom.mobilerefueling.bean.SupplierNameBean;
import com.neocom.mobilerefueling.bean.TextValue;
import com.neocom.mobilerefueling.bean.TypeListBean;
import com.neocom.mobilerefueling.bean.UnitBean;
import com.neocom.mobilerefueling.bean.UserIdBean;
import com.neocom.mobilerefueling.bean.batchNum;
import com.neocom.mobilerefueling.bean.permissionReqBean;
import com.neocom.mobilerefueling.globle.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */

public class FromJsonUtils {

//    public static LabelDataBean fromJson(String json, Class clazz) {
//        return new GsonBuilder()
//                .registerTypeAdapter(LabelDataBean.class, new JsonFormatParser(clazz))
//                .enableComplexMapKeySerialization()
//                .serializeNulls()
//                .create()
//                .fromJson(json, LabelDataBean.class);
//    }


    public static JingBanRenRespBean jsonToJBRBean(String json, ShowCallBack showCallBack) {


        JingBanRenRespBean respBean = new JingBanRenRespBean();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject mJsonObject = jsonElement.getAsJsonObject();

        //                解析最外层
        boolean res = mJsonObject.get("res").getAsBoolean();
        String message = mJsonObject.get("message").getAsString();
//判断 是否继续解析
        if (res) {

            respBean.setMessage(message);

//                解析 Bring

            JsonElement jsonElement1 = mJsonObject.get("bring");
            if (jsonElement1.isJsonNull()) {
                showCallBack.showTips("获取数据有误");
            }

            JsonObject bring = mJsonObject.get("bring").getAsJsonObject();
            JBRBringBean jbrBringBean = new JBRBringBean();
            String templateId = bring.get("templateId").getAsString();
            jbrBringBean.setTemplateId(templateId);
            String label = bring.get("label").getAsString();
            jbrBringBean.setLabel(label);

            JsonArray conList = bring.get("conList").getAsJsonArray();


            List<JBRConListBean> conListBeanList = new ArrayList<>();
            for (int i = 0; i < conList.size(); i++) {

                JBRConListBean jbrConListBean = new JBRConListBean();
                JsonObject labelDataBeanItem = conList.get(i).getAsJsonObject();

                String labelOrder = labelDataBeanItem.get("labelOrder").getAsString();

                jbrConListBean.setLabelOrder(labelOrder);

                String labelName = labelDataBeanItem.get("labelName").getAsString();

                jbrConListBean.setLabelName(labelName);

//                JsonArray labelData = labelDataBeanItem.get("labelData").getAsJsonArray();
                JsonElement labelDataElement = labelDataBeanItem.get("labelData");

                if (labelDataElement != null && !labelDataElement.isJsonNull()) {

                    JsonArray labelData = labelDataElement.getAsJsonArray();

                    List<LabelDataBean> labelDataBeanList = new ArrayList<>();


                    for (int j = 0; j < labelData.size(); j++) {


//                        String asString = labelData.get(j).getAsString();
                        JsonObject labelDataObject = labelData.get(j).getAsJsonObject();
                        LabelDataBean labelDataBean = new LabelDataBean();

                        String labelDataJson = GsonUtil.GsonString(labelDataObject);

//                        LogUtils.i("==============解析 开始=====================================");
//                        LogUtils.i("解析出的 labelDataObject " + new Gson().toJson(labelDataObject));

                        String coltext = labelDataObject.get("coltext").getAsString();
                        labelDataBean.setColtext(coltext);

//                        String value = labelDataObject.get("value").getAsString();
//                        labelDataBean.setValue(value);

                        JsonElement elementValue = labelDataObject.get("value");

                        if (elementValue != null) {
                            if (elementValue.isJsonNull()) {
                                labelDataBean.setValue("");
                            } else {
                                String value = elementValue.getAsString();
                                labelDataBean.setValue(value);
                            }
                        }


                        String colType = labelDataObject.get("colType").getAsString();
                        labelDataBean.setColType(colType);
                        String showorder = labelDataObject.get("showorder").getAsString();
                        labelDataBean.setShoworder(showorder);
                        String required = labelDataObject.get("required").getAsString();
                        labelDataBean.setRequired(required);
                        String defaultValue = labelDataObject.get("defaultValue").getAsString();
                        labelDataBean.setDefaultValue(defaultValue);
                        String colname = labelDataObject.get("colname").getAsString();
                        labelDataBean.setColname(colname);
                        String dataValue = labelDataObject.get("dataValue").getAsString();
//                        JsonArray dataValueArray = labelDataObject.get("dataValue").getAsJsonArray();
//                        LogUtils.i("==json  中的 解析===" + dataValue);

                        String isEditor = labelDataObject.get("isEditor").getAsString();
//                        新增的
                        String showValue = labelDataObject.get("showValue").getAsString();
                        labelDataBean.setShowValue(showValue);

                        String controlValue = labelDataObject.get("controlValue").getAsString();
                        labelDataBean.setControlValue(controlValue);

                        String controlText = labelDataObject.get("controlText").getAsString();
                        labelDataBean.setControlText(controlText);

                        labelDataBean.setIsEditor(isEditor);
//
                        if (colType.equals("select") || colType.equals("multiSelect")) {
//                            JsonStringToIdBeanUtil.handleJson(dataValueArray);

                            if (colType.equals("multiSelect")) {

                                LogUtils.i("+++++++multiSelect+++++++++++++++multiSelect+++++++++++++++++++++++++++++++++++++++");

                            }

                            List<ChildItemBean> childItemBeen = JsonStringToIdBeanUtil.handleJson(controlValue, controlText, dataValue);

//                            if (dataValue.contains("dictName") && dataValue.contains("dictValue")) {
//
////                            List<DicBean> dicBeen = GsonUtil.GsonToList(dataValue, DicBean.class);
//                                List<DicBean> dicBeen = GsonUtil.getObjectList(dataValue, DicBean.class);
//
////                                LogUtils.i("==dicBeen==>" + dicBeen.size() + "-->" + new Gson().toJson(dicBeen));
//
//                                if (dicBeen != null && dicBeen.size() > 0) {
//
//
//                                    List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                    for (int k = 0; k < dicBeen.size(); k++) {
//                                        DicBean dicBean = dicBeen.get(k);
//                                        ChildItemBean childItemBean = new ChildItemBean();
//                                        childItemBean.setItemType(Constant.DIC_BEAN);
//                                        childItemBean.setItemId(dicBean.getDictName());
//                                        childItemBean.setItemValue(dicBean.getDictName());
//                                        childItemBeen.add(childItemBean);
//                                    }
//
//                                    labelDataBean.setDataValue(childItemBeen);
//                                }
//
//
////                            labelDataBean.setDataValue(dicBeen);
//
//                            } else if (dataValue.contains("id") && dataValue.contains("name")) {
//
////                                IdBean idBean=new IdBean();
//
////                            List<IdBean> idBeen = GsonUtil.GsonToList(dataValue, IdBean.class);
//                                List<IdBean> idBeen = GsonUtil.getObjectList(dataValue, IdBean.class);
//
//
//                                if (idBeen != null && idBeen.size() > 0) {
//
//                                    List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                    for (int k = 0; k < idBeen.size(); k++) {
//                                        IdBean idBean = idBeen.get(k);
//                                        ChildItemBean childItemBean = new ChildItemBean();
//                                        childItemBean.setItemType(Constant.ID_BEAN);
//                                        childItemBean.setItemId(idBean.getId());
//                                        childItemBean.setItemValue(idBean.getName());
//                                        if (!TextUtils.isEmpty(idBean.getTelephone())) {
//                                            childItemBean.setItemTelephone(idBean.getTelephone());
//                                        }
//                                        childItemBeen.add(childItemBean);
//                                    }
//
//                                    labelDataBean.setDataValue(childItemBeen);
//
//                                }
//
//
////                            labelDataBean.setDataValue(idBeen);
//
//                            } else if (dataValue.contains("id") && dataValue.contains("storeName")) {
//
//                                List<StoreBean> storeBeen = GsonUtil.getObjectList(dataValue, StoreBean.class);
//
//
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < storeBeen.size(); k++) {
//                                    StoreBean idBean = storeBeen.get(k);
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//                                    childItemBean.setItemId(idBean.getId());
//                                    childItemBean.setItemValue(idBean.getStoreName());
//                                    childItemBeen.add(childItemBean);
//                                }
//
//                                labelDataBean.setDataValue(childItemBeen);
//
//
//                            } else if (dataValue.contains("userId") && dataValue.contains("userName")) {
//
//                                List<UserIdBean> userIdBeen = GsonUtil.getObjectList(dataValue, UserIdBean.class);
//
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < userIdBeen.size(); k++) {
//                                    UserIdBean userIdBean = userIdBeen.get(k);
//
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemId(userIdBean.getUserId());
//                                    childItemBean.setItemValue(userIdBean.getUserName());
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//
//                                    childItemBeen.add(childItemBean);
//                                }
//                                labelDataBean.setDataValue(childItemBeen);
//                            } else if (dataValue.contains("id") && dataValue.contains("supplierName")) {
//
//
//                                List<SupplierNameBean> supplierNameBeen = GsonUtil.getObjectList(dataValue, SupplierNameBean.class);
//
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < supplierNameBeen.size(); k++) {
//                                    SupplierNameBean supplierNameBean = supplierNameBeen.get(k);
//
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemId(supplierNameBean.getId());
//                                    childItemBean.setItemValue(supplierNameBean.getSupplierName());
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//
//                                    childItemBeen.add(childItemBean);
//                                }
//                                labelDataBean.setDataValue(childItemBeen);
//
//                            } else if (dataValue.contains("id") && dataValue.contains("batchNum")) {
//                                List<batchNum> batchNumList = GsonUtil.getObjectList(dataValue, batchNum.class);
//
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < batchNumList.size(); k++) {
//                                    batchNum batchNum = batchNumList.get(k);
//
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemId(batchNum.getId());
//                                    childItemBean.setItemValue(batchNum.getBatchNum());
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//
//                                    childItemBeen.add(childItemBean);
//                                }
//                                labelDataBean.setDataValue(childItemBeen);
//
//                            } else if (dataValue.contains("id") && dataValue.contains("carNum")) {
//
//                                List<CarNumBean> carNumBeen = GsonUtil.getObjectList(dataValue, CarNumBean.class);
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < carNumBeen.size(); k++) {
//                                    CarNumBean carNumBean = carNumBeen.get(k);
//
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemId(carNumBean.getId());
//                                    childItemBean.setItemValue(carNumBean.getCarNum());
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//
//                                    childItemBeen.add(childItemBean);
//
//                                }
//                                labelDataBean.setDataValue(childItemBeen);
//
//                            } else if (dataValue.contains("text") && dataValue.contains("value")) {
//
////                                TextValue
//
//
//                                List<TextValue> textValues = GsonUtil.getObjectList(dataValue, TextValue.class);
//                                List<ChildItemBean> childItemBeen = new ArrayList<>();
//                                for (int k = 0; k < textValues.size(); k++) {
//                                    TextValue textValue = textValues.get(k);
//
//                                    ChildItemBean childItemBean = new ChildItemBean();
//                                    childItemBean.setItemId(textValue.getText());
//                                    childItemBean.setItemValue(textValue.getValue());
//                                    childItemBean.setItemType(Constant.ID_BEAN);
//
//                                    childItemBeen.add(childItemBean);
//
//                                }
//                                labelDataBean.setDataValue(childItemBeen);
//
//
//                            } else {
//
//                                if (TextUtils.isEmpty(dataValue)) {
//                                    labelDataBean.setDataValue("");
//
//                                } else {
//                                    labelDataBean.setDataValue(dataValue);
//
//                                }
//
//                            }

                            labelDataBean.setDataValue(childItemBeen);

                        }


//                        LogUtils.i("===dataValue===" + dataValue);
//
//                        LogUtils.i("解析出的 labelDataObject " + new Gson().toJson(labelDataObject));


//                        LogUtils.i("==============解析 结束=====================================");

//                        LogUtil.i("解析出的 判断类型 element  " + new Gson().toJson(element)
//                                + "<==element=isJsonNull==>" + element.isJsonNull()
//                                + "<==element=isJsonObject==>" + element.isJsonObject()
//                                + "<==element=isJsonArray==>" + element.isJsonArray()
//                                + "<==element=isJsonPrimitive==>" + element.isJsonPrimitive());
                        labelDataBeanList.add(labelDataBean);
                    }

                    jbrConListBean.setLabelData(labelDataBeanList);


                    if (labelData.size() > 0) {
                        conListBeanList.add(jbrConListBean);
                    }

                }

            }

            jbrBringBean.setConList(conListBeanList); // 待解析 conList

            respBean.setBring(jbrBringBean);

//            LogUtils.i("==返回后解析的 数据===" + GsonUtil.GsonString(respBean));
        } else {


            if (TextUtils.isEmpty(message)) {

//                showWarnTip("获取数据失败");

                if (showCallBack != null) {

                    showCallBack.showTips("获取数据失败");

                }

            } else {
//                showWarnTip(message);
                showCallBack.showTips(message);

            }


        }

        return respBean;

    }


    public static void parseToViewJson(String json, ParseCallBack callBack) {

        if (TextUtils.isEmpty(json)) {

            if (callBack != null) {

                callBack.onError();
            }
            return;
        }

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);

        JsonObject asJsonObject = jsonElement.getAsJsonObject();

        boolean res = asJsonObject.get("res").getAsBoolean();

        if (res) {

            permissionReqBean reqBean = new permissionReqBean();

            ProcessAgreeBean agreeBean = new ProcessAgreeBean();


            JsonElement jsonElementBring = asJsonObject.get("bring");


            if (!jsonElementBring.isJsonNull()) {

                JsonObject jsonBringObject = jsonElementBring.getAsJsonObject();

                JsonElement jsonElementDaTa = jsonBringObject.get("data");

                JsonElement suggestionListElement = jsonBringObject.get("suggestionList");

                String curTaskName = jsonBringObject.get("curTaskName").getAsString();


                String insId = "";
                if (!suggestionListElement.isJsonNull()) {

                    if (suggestionListElement.isJsonArray()) {

                        JsonArray asJsonArray = suggestionListElement.getAsJsonArray();

                        for (int i = 0; i < asJsonArray.size(); i++) {

                            JsonObject jsonObjectSuggestionList = asJsonArray.get(i).getAsJsonObject();
                            insId = jsonObjectSuggestionList.get("insId").getAsString();
                        }

                    }


                }

                if (!jsonElementDaTa.isJsonNull()) {

                    JsonObject jsonObjData = jsonElementDaTa.getAsJsonObject();

                    String id = jsonObjData.get("id").getAsString();
                    String processDefId = jsonObjData.get("processDefId").getAsString();
                    String curTaskId = jsonBringObject.get("curTaskId").getAsString();
                    String templateId = jsonObjData.get("templateId").getAsString();
                    String uUser = jsonObjData.get("u_user").getAsString();
//                    reqBean.setProcessDefId(processDefId);
////        reqBean.setWorkOrderId("04a301e06e75441aa0811278ce25ff19");
//                    reqBean.setWorkOrderId(id);
//                    reqBean.setCurTaskId(curTaskId);
//                    reqBean.setFormCode("form_bb_insert");

                    agreeBean.setCurTaskName(curTaskName);
                    agreeBean.setProcessDefId(processDefId);
//        reqBean.setWorkOrderId("04a301e06e75441aa0811278ce25ff19");
                    agreeBean.setWorkOrderId(id);
                    agreeBean.setCurTaskId(curTaskId);
                    agreeBean.setFormCode("form_bb_insert");

//                    agreeBean.setCuserId(StaticUtils.App_UserId);
                    agreeBean.setEventId(id);

                    agreeBean.setInsId(insId);
                    agreeBean.setTemplateId(templateId);
                    agreeBean.setuUser(uUser);
                    if (callBack != null) {

//                        callBack.onSuccess(reqBean);
                        callBack.onSuccess(agreeBean);

                    }


                } else {
                    if (callBack != null) {
                        callBack.onError();
                    }
                }

            } else {
                if (callBack != null) {

                    callBack.onError();
                }
            }


        } else {


            String message = asJsonObject.get("message").getAsString();

            if (TextUtils.isEmpty(message)) {

                if (callBack != null) {
                    callBack.onFail("接口获取信息失败");
                }

            } else {
                if (callBack != null) {
                    callBack.onFail(message);
                }
            }


        }


    }

    public static StartProcessBean parseProcessStartJson(String json, ShowCallBack showCallBack) {

        if (TextUtils.isEmpty(json)) {

            if (showCallBack != null) {

                showCallBack.showTips("网络连接或数据异常");

            }
            return null;
        }
        StartProcessBean processBean = new StartProcessBean();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        boolean res = jsonObject.get("res").getAsBoolean();
        String message = jsonObject.get("message").getAsString();


        if (res) {

            processBean.setRes(res);
            processBean.setMessage(message);
        } else {

            if (TextUtils.isEmpty(message)) {

//                message = "发起流程失败";

                if (showCallBack != null) {

                    showCallBack.showTips("发起流程失败");

                }

            } else {

                if (showCallBack != null) {

                    showCallBack.showTips(message);

                }

            }


        }
        return processBean;

    }


    /**
     * 解析 返回的  获取商品分类和计量单位
     *
     * @param json
     * @param parseCalBank
     */
    public static void parseDanWeiAndType(String json, ParseCallBack parseCalBank) {


        if (TextUtils.isEmpty(json)) {

            if (parseCalBank != null) {
                parseCalBank.onFail("网络数据异常");
            }

        }

        if (parseCalBank == null) {

            new Throwable("回调为空");
            return;
        }

        JsonParser jsonParser = new JsonParser();


        JsonElement jsonElement = null;
        try {
            jsonElement = jsonParser.parse(json);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }


        if (jsonElement == null) {
            parseCalBank.onError();
            return;
        }

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        boolean res = jsonObject.get("res").getAsBoolean();
        DanWeiBean danWeiBean = new DanWeiBean();

        if (res) {

            danWeiBean.setRes(res);
            JsonElement jsonElementBring = jsonObject.get("bring");
            if (jsonElementBring.isJsonNull()) {


                String message = jsonObject.get("message").getAsString();

                if (TextUtils.isEmpty(message)) {
                    parseCalBank.onFail("获取数据异常");

                } else {

                    parseCalBank.onFail(message);

                }
            } else {
                JsonObject jsonObBring = jsonElementBring.getAsJsonObject();

                String unitList = jsonObBring.get("unitList").getAsString();
                LogUtils.i("--jijijji-" + unitList);


                if (!TextUtils.isEmpty(unitList)) {

                    List<UnitBean> unitBeen = GsonUtil.getObjectList(unitList, UnitBean.class);
                    danWeiBean.setUnitList(unitBeen);

                }

                String typeList = jsonObBring.get("typeList").getAsString();

                List<TypeListBean> typeListBeen = GsonUtil.getObjectList(typeList, TypeListBean.class);
                danWeiBean.setTypeList(typeListBeen);

            }

            parseCalBank.onSuccess(danWeiBean);

        } else {

            String message = jsonObject.get("message").getAsString();

            if (TextUtils.isEmpty(message)) {
                parseCalBank.onFail("获取数据异常");

            } else {

                parseCalBank.onFail(message);

            }


        }


    }


}
