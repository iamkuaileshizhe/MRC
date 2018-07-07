package com.neocom.mobilerefueling.utils;

import android.text.TextUtils;

import com.neocom.mobilerefueling.globle.Constant;

/**
 * Created by admin on 2017/8/22.
 */

public class GetOrderStateUtil {

    /**
     * indentStatus;//订单状态 0未提交，1审核中，2派单中，
     * 3司机已接单，4派送中，
     * 5已到场，6加油中，7加油完成，
     * 8结算完成，9客户已确认，
     * 10已完成，11撤单，12审核不通过
     */
    public static String GetOrderState(String indentStatus) {
        if (!TextUtils.isEmpty(indentStatus)) {


            switch (Integer.valueOf(indentStatus)) {
                case 0:

                    return "未提交";
                case 1:

                    return "审核中";
                case 2:

                    return "派单中";
                case 3:

                    return "司机已接单";
                case 4:

                    return "派送中";
                case 5:

                    return "已到场";
                case 6:

                    return "加油中";
                case 7:

                    return "加油完成";
                case 8:

                    return "结算完成";
                case 9:

                    return "客户已确认";
                case 10:

                    return "已完成";
                case 11:

                    return "撤单";
                case 12:

                    return "审核不通过";


            }
            return "";
        } else {

            return "";

        }
    }


    public static String getPaiSongDanState(String dsate) {

        if (TextUtils.isEmpty(dsate)) {
            return "";
        }

        switch (dsate) {
            case "0":
                return "待接单";

            case "1":
                return "已接单";

            case "2":

                return "已拒绝";

            case "3":

                return "已完成";
            case "8":

                return "待支付";

            case "6":
                return "已到场";

            case "10":

                return "已取消";
            case "11":

                return "待确认";
            case "12":

                return "已确认";

        }
        return "";

    }


    public static String getOilType(String oilType) {

        if (TextUtils.isEmpty(oilType)) {
            return "";
        }

        switch (oilType) {
            case "1":
                return "5号柴油";

            case "2":
                return "0号柴油";

            case "3":

                return "-10号柴油";

            case "4":

                return "-20号柴油";
            case "5":

                return "-35号柴油";
            case "6":

                return "-50号柴油";
        }
        return "";

    }


    public static String getTicketype(String ticketType) {

        if (TextUtils.isEmpty(ticketType)) {
            return "无发票";
        }

        switch (ticketType) {
            case "0":
                return "普通发票";

            case "1":
                return "电子发票";

            case "2":

                return "增值税发票";

        }
        return "无发票";

    }

    public static String getSendType(String sendNum) {

        if (TextUtils.isEmpty(sendNum)) {
            return "";
        }

        switch (sendNum) {
            case "0":
                return "未确认";

            case "1":
                return "确认未通过";

            case "2":

                return "确认已通过";

        }
        return "";

    }

    public static String getCarType(String carType) {

        if (TextUtils.isEmpty(carType)) {
            return "普通用户";
        }

        switch (carType) {
            case "1":
                return "补给车";

            case "0":
                return "运油车";
        }
        return "普通用户";

    }

    public static String getFuelType(String fuelType) {

        if (TextUtils.isEmpty(fuelType)) {
            return "";
        }

        switch (fuelType) {
            case "1":
                return "柴油";

            case "0":
                return "汽油";
        }
        return "";

    }

    public static String getShitWorkType(String shitWork) {

        if (TextUtils.isEmpty(shitWork)) {
            return "";
        }

        switch (shitWork) {
            case "1":
                return "已确认";
            case "2":
                return "已拒绝";

            case "0":
                return "未确认";
        }
        return "";

    }


    //    "checkStatus": "5"					   //客户审核状态: 0.未提交
//            1.待销售主任审核
//2.销售主任审核失败
//3.待地区经理审核
//4.地区经理审核失败
//5.审核成功

    public static String getcheckStatus(String checkStatus) {

        if (TextUtils.isEmpty(checkStatus)) {
            return "";
        }
        switch (checkStatus) {


            case Constant.WTJ:
                return "未提交";

            case Constant.XSZR_DSH:
                return "待销售主任审核";

            case Constant.XSZR_SHSB:
                return "销售主任审核失败";
            case Constant.DQJL_DSH:
                return "待地区经理审核";
            case Constant.DQJL_SHSB:
                return "地区经理审核失败";
            case Constant.SHCG:
                return "审核成功";
        }
        return "";

    }


    /**
     * if("1".equals(checkPeople)){
     * roleCode="r_employee_x_gmjy";//销售经理
     * }else if("2".equals(checkPeople)){
     * roleCode="r_employee_z_gmjy";//销售主管
     * }else if("3".equals(checkPeople)){
     * roleCode="r_employee_d_gmjy";//地区经理
     *
     * @param role
     * @return
     */
    public static String getRoleCode(String role) {

        if (TextUtils.isEmpty(role)) {
            return "";
        }

        if (role.contains("r_employee_x")) {
            return "0";
        } else if (role.contains("r_employee_z")) {
            return "1";
        } else if (role.contains("r_employee_d")) {
            return "2";
        }


//


        return "";
    }


    public static String getKHType(String khType) {

        if (TextUtils.isEmpty(khType)) {
            return "";
        }

        switch (khType) {
            case "1":
                return "企业";

            case "2":
                return "个人";
        }
        return "";

    }

    public static String getWorkState(String workState) {

        if (TextUtils.isEmpty(workState)) {
            return Constant.WORK_STATE_OFF;
        }

        switch (workState) {
            case "1":
                return Constant.WORK_STATE_OFF;

            case "0":
                return Constant.WORK_STATE_ON;
        }
        return "";

    }

    public static String getJoinTypeState(String joinType) {

        if (TextUtils.isEmpty(joinType)) {
            return "";
        }

        switch (joinType) {
            case "1":
                return "司机";

            case "0":
                return "押运员";
        }
        return "";

    }

    public static String getinsConfirmStatus(String recordStatus) {

        if (TextUtils.isEmpty(recordStatus)) {
            return "";
        }

        switch (recordStatus) {
            case "0":
                return "待提油";
            case "1":
                return "已完成";
            case "2":
                return "提油完成";
            case "3":
                return "审核不通过";
        }
        return "";

    }

    public static String getJoinStatus(String joinStatus) {

        if (TextUtils.isEmpty(joinStatus)) {
            return "";
        }

        switch (joinStatus) {
            case "1":
                return "";
            case "2":
                return "末岗";

            case "0":
                return "首岗";
        }
        return "";

    }

    public static String getconfirmStatus(String confirmStatus) {

        if (TextUtils.isEmpty(confirmStatus)) {
            return Constant.WORK_STATE_OFF;
        }

        switch (confirmStatus) {
            case "0":
                return "未审核";

            case "1":
                return "审核通过";
            case "2":
                return "审核失败";


        }
        return "";

    }


    /**
     * 获取 派送单 状态
     */
    public static String getPaiSonDanState(String state) {

        switch (state) {

            case Constant.PAISONGDAN_STATE_DAIJIEDAN:
                return "待结单";
            case Constant.PAISONGDAN_STATE_YIJIEDAN:
                return "已接单";
            case Constant.PAISONGDAN_STATE_YIJUJUE:
                return "已拒绝";
            case Constant.PAISONGDAN_STATE_YIWANCHENG:
                return "已完成";
            case Constant.PAISONGDAN_STATE_DIAODUSHIBAI:
                return "调度失败未派单";
            case Constant.PAISONGDAN_STATE_DAIDIAODU:
                return "待调度";
            case Constant.PAISONGDAN_STATE_YIDAOCHANG:
                return "已到场";
            case Constant.PAISONGDAN_STATE_JIAYOUZHONG:
                return "加油中";
            case Constant.PAISONGDAN_STATE_JIAYOUWANCHENG:
                return "待支付";
            case Constant.PAISONGDAN_STATE_CHONGXINDIAODU:
                return "重新调度";
            case Constant.PAISONGDAN_STATE_YIQUXIAO:
                return "已取消";
        }
        return "";
    }


    public static String getJieSuanState(String value) {

//        0:未结算; 1:有申诉2:结算完成

        switch (value) {

            case Constant.JIESUAN_DAI:

                return "待结算";

            case Constant.JIESUAN_SHENSU
                    :
                return "有申诉";
            case Constant.JIESUAN_WANCHENG:

                return "结算完成";

            default:
                return "";
        }


    }

    public static String getDailyBlanceState(String state) {

        String stateStr = "";
        switch (state) {

            case "0":
                stateStr = "未结算";
                break;
            case "1":
                stateStr = "有申诉";
                break;
            case "2":
                stateStr = "结算完成";
                break;

        }

        return stateStr;
    }


    public static String getSupplierValue(String value) {

        String valueReturn = "";
        if (value.equals("0")) {
            valueReturn = "否";
        } else if (value.equals("1")) {
            valueReturn = "是";
        }
        return valueReturn;
    }


}
