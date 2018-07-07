package com.neocom.mobilerefueling.globle;

import android.net.Uri;

/**
 * Created by admin_xyz on 2017/7/20.
 * 创建人：xyz
 * 创建日期:2017/7/20
 * 描述: 公共资源类
 */

public class Constant {

    /**
     * 主机 地址
     */
// 公网地址 http://58.56.94.34:78
    public final static int ADDRESS_REQUESTCODE = 101; // 请求码
    public final static int ADDRESS_RESP = 102; // 响应吗

    public final static int ADDRESS_LIST_REQUESTCODE = 201; // 请求码

    public final static int ADDRESS_LIST_RESP = 202; // 响应吗

    public final static int ADDCAR_REQUESTCODE = 301; // 请求码

    public final static int ADDCAR_RESP = 302; // 响应吗

    public static final String GESTURE_PASSWORD = "GesturePassword";
    public static final String PAY_ONLINE = "1"; // 在线支付
    public static final String PAY_CASH = "0"; // 现金支付

    public static String CHUKU_TYPE = "1";// 备用
    /**
     * 0可编辑1
     */
    public static final String TV_CAN_EDIT = "0";
    /**
     * 1.只读
     */
    public static final String TV_ONLY_READ = "1";
    /**
     * 2.只显示内容
     */
    public static final String TV_ONLY_SHOW_CONTENT = "2";
    /**
     * 3.隐藏
     */
    public static final String TV_INVISIBLE_GONE = "3";

    /**
     * 按钮显示
     */
    public static boolean BUTTON_SHOW = false;

    /**
     * 按钮不显示
     */
    public static boolean BUTTON_DISSHOW = true;

    //        public static String BASE_URL = "http://yypt.mrefuel.com";
    public static String MENU_URL = "http://yypt.mrefuel.com/interfaceService/";
//    public static String MENU_URL = "http://www.mrefuel.com:8083";


//        public static String BASE_URL = "http://192.168.1.138:8080"; // 于紫洋 的
//    public static String BASE_URL = "http://192.168.1.128:8080"; // 刘清敦
//    public static String BASE_URL = "http://192.168.1.194:8080"; // 王兴亮
//        public static String BASE_URL = " http://192.168.1.185:8080";
//    public static String BASE_URL = "http://192.168.1.205:8080";
//    public static String BASE_URL = "http://www.mrefuel.com:8080 /"; // 公网
//    http://192.168.1.208:8088/webService/app/user/getUserAppMenus/userId

    public static String BASE_URL = "http://192.168.1.208:8080";
//        public static String MENU_URL = " http://192.168.1.156:8088";
//
//    public static String MENU_URL = " http://192.168.1.208:8088";


//    public static String BASE_URL = " http://192.168.1.156:8080";
//    public static String MENU_URL = " http://192.168.1.156:8088";


    public static String CONTENT_TYPE = "application/json; charset=utf-8";

    public static Uri UPDATE_RECEIVE = Uri.parse("content://com.neo.mobilerefuel/update");

    public static String CONTENT_MENU = "";

    public static int REQUESTCODE_FROM_ACTIVITY = 1000;
    public static int REQUESTCODE_FROM_FRAGMENT = 1001;


    public static String TY_REC_DAITOYOU = "0";
    public static String TY_REC_YIWANCHENG = "1";
    public static String TY_REC_TIYOUWACHENG = "2";
    public static String TY_REC_SHENHEBUTONGGUO = "3";
    public static String DEFAULT_IP = "defaultIp";
    public static String DEFAULT_IP_INUSE = "useIp";


    /**
     * 日结 待结算
     */
    public static final String JIESUAN_DAI = "0";

    /**
     * 日结 结算有申诉
     */
    public static final String JIESUAN_SHENSU = "1";

    /**
     * 日结 结算完成
     */
    public static final String JIESUAN_WANCHENG = "2";


    /**
     * 已接单
     */
    public static String ORDER_RECEIVED = "1";


    /**
     * 已拒绝
     */
    public static String ORDER_REFUSE = "2";

    /**
     * 已完成
     */
    public static String ORDER_FINISHED = "3";

    /**
     * 待接单
     */
    public static String ORDER_WILL = "0";


    /**
     * 全部订单
     */
    public static String ORDER_ALL = "0";


    //    SharePreference 中保存 数据用的 常量

    public static String SP_USER = "sp_user";
    public static String SP_AUTO_LOGIN = "sp_login";
    public static String SP_USERNAME = "sp_name";
    public static String SP_PASSWORD = "sp_password";
    public static String SP_REMBER = "sp_rember";


    public static String SP_WEB_HOST = "sp_web_host";
    public static String SP_WEB_PORT = "sp_web_port";

    public static String SP_PROCESS_HOST = "sp_process_host";
    public static String SP_PROCESS_PORT = "sp_process_port";

    public static String SP_C_USER = "c_user";
    public static String TTS_SWITCH = "TTS";

    public static String SP_LOGIN_CONTENT = "sp_login_content";

    public static String CAR_NO = "car_no";
    public static String CAR_TYPE = "car_type";
    public static String CAR_TYPE_BUJI = "car_type_buji";
    public static String CAR_TYPE_JIAYOU = "car_no_jy";
    public static boolean DEBUG = true;
    public static final int JPUSH_SEQUENCE = 1;

    public static final int REQUEST_CODE = 0x1001;

    /**
     * 每页显示多少条数目
     */
    public static final String PER_PAGE_NUMS = "10";
    /**
     * 第一页
     */
    public static final int FIRST_PAGE = 1;


    /**
     * case "0":
     * return "待接单";
     * <p>
     * case "1":
     * return "已接单";
     * <p>
     * case "2":
     * <p>
     * return "已拒绝";
     * <p>
     * case "3":
     * <p>
     * return "已完成";
     */
    public static final String JD_DQUANBU = "";
    public static final String JD_DAIJIEDAN = "0";
    public static final String JD_YIJIEDAN = "1";
    public static final String JD_YIJUJUE = "2";
    public static final String JD_YIWANCHENG = "3";
    public static final String JD_YIDAOCHANG = "6";
    public static final String JD_DAIZHIFU = "8";
    public static final String JD_YIQUXIAO = "10";
    public static final String JD_DAIQUEREN = "11";
    public static final String JD_YIQUEREN = "12";

    public static String deliveryCode = "";


    //    派送单 状态
    public static final String PAISONGDAN_STATE_DAIJIEDAN = "0";
    public static final String PAISONGDAN_STATE_YIJIEDAN = "1";
    public static final String PAISONGDAN_STATE_YIJUJUE = "2";
    public static final String PAISONGDAN_STATE_YIWANCHENG = "3";
    public static final String PAISONGDAN_STATE_DIAODUSHIBAI = "4";
    public static final String PAISONGDAN_STATE_DAIDIAODU = "5";
    public static final String PAISONGDAN_STATE_YIDAOCHANG = "6";
    public static final String PAISONGDAN_STATE_JIAYOUZHONG = "7";
    public static final String PAISONGDAN_STATE_JIAYOUWANCHENG = "8";
    public static final String PAISONGDAN_STATE_CHONGXINDIAODU = "9";
    public static final String PAISONGDAN_STATE_YIQUXIAO = "10";


    //    正常单据
    public static final String DOCTYPE_NORMAL = "0";
    //    补单单据
    public static final String DOCTYPE_BUDAN = "1";
//加油 弹窗是否 展示

    public static boolean isDialogShow = false;

    //    Bugly APPID

    public static final String BUGLY_APPID = "fbd25cc9e6";

    public static final String ROLE_KEHU_SIJI = "r_customer_s";
    public static final String ROLE_BUJU = "r_refuel_b";
    public static final String ROLE_JIAYOU = "r_refuel_j";


    /**
     * 潜在客户 查询 审核状态
     * 审核状态:
     * 0.未提交;
     * 1.待审核;
     * 2.审核失败;
     * 3.审核成功;
     */
    public static final String QZKH_ALL = "";
    public static final String QZKH_WEITIJIAO = "0";
    public static final String QZKH_DAISHENHE = "1";
    public static final String QZKH_SHENHESHIBAI = "2";
    public static final String QZKH_SHENHECHENGGONG = "3";


//    "checkStatus": "5"					   //客户审核状态: 0.未提交
//            1.待销售主任审核
//2.销售主任审核失败
//3.待地区经理审核
//4.地区经理审核失败
//5.审核成功
//      "customerStatus": "1",				   //客户状态:0.潜在客户 1.正式客户


    public static final String WTJ = "0";
    public static final String XSZR_DSH = "1";
    public static final String XSZR_SHSB = "2";
    public static final String DQJL_DSH = "3";
    public static final String DQJL_SHSB = "4";
    public static final String SHCG = "5";

    public static boolean MAIN_GROUND = false;
    public static boolean MAINTRANS_GROUND = false;


    public static final String ZSKH = "zskh";
    public static final String QZKH = "qzkh";
    public static final String KHTYPE = "khtype";


    public static final String CY_GB = "cy_gb";
    public static final String CY_LX = "cy_lx";


    /**
     * 名称	类型	是否必输	描述
     * map	Map	Y	参数类型集合
     * <p>
     * 参数分类
     * 参数类型	参数名称	是否必输	描述
     * JSFS	客户结算方式	N	现结算、账期结算
     * wf_manage_scope	经营范围	N	劳务总承包、劳务专业承包…
     * wf_firm_industry	所属行业	N	交通运输、石油炼化…
     * wf_firm_type	企业类型	N	私营企业、国有企业…
     * wf_customer_type	客户类型	N	企业、个人
     * wf_customer_source	客户来源	N	内部开发、合作伙伴
     * car_type	车辆类型	N	客车、货车…
     * supply_way	补给方式	N	油枪、油罐…
     * customer_grade	客户等级	N	普通会员、黄金会员…
     * wf_customer_payment	客户账期	N	一个月、两个月…
     */

    public static final String DIC_CONTENT = "dic_content";
    public static final String JSFS = "JSFS";
    public static final String WF_MANAGE_SCOPE = "wf_manage_scope";
    public static final String WF_FIRM_INDUSTRY = "wf_firm_industry";
    public static final String WF_FIRM_TYPE = "wf_firm_type";
    public static final String WF_CUSTOMER_TYPE = "wf_customer_type";
    public static final String WF_CUSTOMER_SOURCE = "wf_customer_source";
    public static final String CAR_TYPE_DIC = "car_type";
    public static final String SUPPLY_WAY = "supply_way";
    public static final String CUSTOMER_GRADE = "customer_grade";
    public static final String WF_CUSTOMER_PAYMENT = "wf_customer_payment";

    public static final String XIAOSHOU_JINGLI = "r_employee_x";//销售经理  1
    public static final String XIAOSHOU_ZHUGUAN = "r_employee_z";//销售主管  2
    public static final String DIQU_JINGLI = "r_employee_d";//地区经理  3


    public static final String YEWUYUAN_CODE = "0";//业务员
    public static final String SHICHANG_CODE = "1";//市场 经理
    public static final String JINGLI_CODE = "2";// 地区经理

    public static final String DPF_COMING = "dpf_coming";// 待批复列表 来源
    public static final String ZS_COMING = "zs_coming";// 正式客户 来源
    public static final String DCL_COMING = "dcl_coming";// 正式客户 来源
    public static final String COMING = "coming";// 地区经理


    public static final String WORK_STATE_OFF = "下班中";
    public static final String WORK_STATE_ON = "上班中";
    public static final String WORK_STATE = "work_state";
    public static final String CAR_NUM = "car_num";

    public static final String IN_WORK = "0"; // 上班中
    public static final String UN_WORK = "1"; // 下班中

    /*************菜单 名称****************************************/

    public static final String MENU_SAVE = "menu_save";

    /*************用户端 菜单 名称****************************************/
////资金账户信息	customer_accout	客户账户信息	用户端
//    public static final String MENU_CUSTOMER_ACCOUT = "customer_accout";
//
//    //执行价格查看	customer_oilPrice	查询客户的执行价格	用户端
//    public static final String MENU_CUSTOMER_OILPRICE = "customer_oilPrice";
//    //客户人员信息	customer_people	客户的人员信息	用户端
//    public static final String MENU_CUSTOMER_PEOPLE = "customer_people";
//    //客户车辆信息	customer_driver	客户车辆信息	用户端
//    public static final String MENU_CUSTOMER_DRIVER = "customer_driver";
//
//    //    下订单	app_order_input		用户端
//    public static final String MENU_APP_ORDER_INPUT = "app_order_input";
//
//    //    订单列表	app_order_list		用户端
//    public static final String MENU_APP_ORDER_LIST = "app_order_list";
//
//    //    充值	app_charge		用户端
//    public static final String MENU_app_charge = "app_charge";
//

    /*****************************************************/


    /*************企业端****************************************/

// // // // // // //＊＊＊＊＊＊客户信息管理＊＊＊＊ // // // // // //
//
//潜在客户信息管理	customer_hidden
    public static final String MENU_CUSTOMER_HIDDEN = "customer_hidden";

    //    潜在客户信息查询 customer_hidden_search
    public static final String MENU_CUSTOMER_HIDDEN_SEARCH = "customer_hidden_search";

    //    待批复列表-销售经理	customer_pifu
    public static final String MENU_CUSTOMER_PIFU = "customer_pifu";

    //    客户交易记录查询	customer_bill
    public static final String MENU_CUSTOMER_BILL = "customer_bill";

    //    客户车辆管理	customer_vehicle
    public static final String MENU_CUSTOMER_VEHICLE = "customer_vehicle";

    //    客户人员管理	customer_people
    public static final String MENU_CUSTOMER_PEOPLE = "customer_people";

//    客户信息管理-销售经理	customer_list

    public static final String MENU_CUSTOMER_LIST = "customer_list";

//待处理审核列表	customer_handle

    public static final String MENU_CUSTOMER_HANDLE = "customer_handle";
    //待批复列表-销售主管	customer_pifu1
    public static final String MENU_CUSTOMER_PIFU1 = "customer_pifu1";

    //待审核客户列表	customer_auth
    public static final String MENU_CUSTOMER_AUTH = "customer_auth";

    //    客户信息查询	customer_search
    public static final String MENU_CUSTOMER_SEARCH = "customer_search";
    //客户价格审核	customer_price
    public static final String MENU_CUSTOMER_PRICE = "customer_price";

    // // // // // // //＊＊＊＊＊＊订单管理＊＊＊＊ // // // // // //

    //    订单列表	busi_order_list
    public static final String MENU_BUSI_ORDER_LIST = "busi_order_list";

    //    接单	busi_order_pickUp
    public static final String MENU_BUSI_ORDER_PICKUP = "busi_order_pickUp";


//    完成订单	busi_order_finish

    public static final String MENU_BUSI_ORDER_FINISH = "busi_order_finish";


    //   交接班管理	busi_handOver

    public static final String MENU_BUSI_HANDOVER = "busi_handOver";

    //    交接班确认	busi_handOver_auth
    public static final String MENU_BUSI_HANDOVER_AUTH = "busi_handOver_auth";
    // 补给记录管理	busi_supplyOil
    public static final String MENU_BUSI_SUPPLYOIL = "busi_supplyOil";

    //    补给记录确认	busi_supplyOil_auth
    public static final String MENU_BUSI_SUPPLYOIL_AUTH = "busi_supplyOil_auth";

    //    提油记录管理	busi_purchaseOil
    public static final String MENU_BUSI_PURCHASEOIL = "busi_purchaseOil";

    //    车辆标签	busi_nfc
    public static final String MENU_BUSI_NFC = "busi_nfc";

    //    客户信息查询
    public static final String CUSTOMER_SEARCH = "customer_search";
    //    待办流程
    public static final String WAIT_TO_DO = "busi_todo";
    //    已办流程
    public static final String HAVE_DONE = "busi_haveDo";
    //    采购流程
    public static final String PURCHASEOIL = "busi_purchaseOilForFlow";

    public static final String busiDaily = "busi_daily";

    /**
     * DicBean 标识
     */
    public static final String DIC_BEAN = "0";
    /**
     * IdBean 标识
     */
    public static final String ID_BEAN = "1";


    /***********************充值相关***********************************/


//    1	账户充值	充值模块支付
//2	购油	购买油品支付
//3	个人结算	日清日结结算支付

    /**
     * 账户充值	充值模块支付
     */
    public static final String ZHIFU_CHONGZHI = "1";
    /**
     * 购油	购买油品支付
     */
    public static final String ZHIFU_GOUYOU = "2";

    /**
     * 个人结算	日清日结结算支付
     */

    public static final String ZHIFU_GERENJIESUAN = "3";
    public static final String payWayShow = "payWayShow";
    public static final String payYue = "payYueE";

    public static final String PAYWAY_UNION = "1";
    public static final String PAYWAY_ALIPAY = "2";
    public static final String PAYWAY_WX = "3";
    public static final String PAYWAY_ACOUNT = "4";

    public static final String TRADE_TYPE_CHONGZHI = "1";
    public static final String TRADE_TYPE_TUIKUAN = "2";
    public static final String TRADE_TYPE_ZHIFU = "3";

    public static final String GOODS_TYPE_CHONGZHI = "1";
    public static final String GOODS_TYPE_YOUPIN = "2";

    //    1待付款 2交易完成 3交易关闭 4付款中 5付款取消 6付款失败 根据交易记录id更新交易记录状态  /busi/payment/updateStatus

    public static final String ORDER_DAIFUKUAN = "1";
    public static final String ORDER_JIAOYIWANCHENG = "2";
    public static final String ORDER_JIAOYIGUANBI = "3";
    public static final String ORDER_FUKUANZHONG = "4";
    public static final String ORDER_FUKUANQUXIAO = "5";
    public static final String ORDER_FUKUANSHIBAI = "6";

    /**********************************************************/
    /**
     * 千克或升的单位标识
     */
    public static final String DANWEI_KG_L = "0";

    /**
     * 吨 的单位标识
     */
    public static final String DANWEI_T = "1";

    /**
     * 是否显示 按钮  key
     */
    public static final String showSureBtn = "show_sure_btn";
    public static final boolean showShowBtn = true;
    public static final boolean showDisShowBtn = false;
}
