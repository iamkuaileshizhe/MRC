package com.neocom.mobilerefueling.net;

import com.neocom.mobilerefueling.adapter.YunYouCheResponseBean;
import com.neocom.mobilerefueling.bean.AddShitWorkRespBean;
import com.neocom.mobilerefueling.bean.AddressListRequest;
import com.neocom.mobilerefueling.bean.AllCostRespBean;
import com.neocom.mobilerefueling.bean.AllOrderBean;
import com.neocom.mobilerefueling.bean.BuJiRespBean;
import com.neocom.mobilerefueling.bean.CarCodeRespBean;
import com.neocom.mobilerefueling.bean.CarInfoRespBean;
import com.neocom.mobilerefueling.bean.CarNumRespInfoBean;
import com.neocom.mobilerefueling.bean.CarStateRespBean;
import com.neocom.mobilerefueling.bean.CheLiangRespBean;
import com.neocom.mobilerefueling.bean.ChooseCarBeanBring;
import com.neocom.mobilerefueling.bean.ChoosePersonBean;
import com.neocom.mobilerefueling.bean.DailyBalanceReqBean;
import com.neocom.mobilerefueling.bean.DailyBalanceRespBean;
import com.neocom.mobilerefueling.bean.DailyRecordRespBean;
import com.neocom.mobilerefueling.bean.DeliveryOrderRespBean;
import com.neocom.mobilerefueling.bean.DictBean;
import com.neocom.mobilerefueling.bean.EmptyBringGetOilBean;
import com.neocom.mobilerefueling.bean.FileUploadResponse;
import com.neocom.mobilerefueling.bean.FindOilPriceRespBean;
import com.neocom.mobilerefueling.bean.GetCarInfoRespBean;
import com.neocom.mobilerefueling.bean.GetOilDetaiBean;
import com.neocom.mobilerefueling.bean.GetPiCiBean;
import com.neocom.mobilerefueling.bean.GodsListRespBean;
import com.neocom.mobilerefueling.bean.GongYingShangRespBean;
import com.neocom.mobilerefueling.bean.HeTongResBean;
import com.neocom.mobilerefueling.bean.HeTongRespBean;
import com.neocom.mobilerefueling.bean.JiaYouJiRespBean;
import com.neocom.mobilerefueling.bean.JieSuanRespBean;
import com.neocom.mobilerefueling.bean.KHDetalRespBean;
import com.neocom.mobilerefueling.bean.LoginResponseBean;
import com.neocom.mobilerefueling.bean.MenuBean;
import com.neocom.mobilerefueling.bean.MsgBean;
import com.neocom.mobilerefueling.bean.OilLXGBBean;
import com.neocom.mobilerefueling.bean.OilResponseBean;
import com.neocom.mobilerefueling.bean.OnlyStringBeanReso;
import com.neocom.mobilerefueling.bean.OrderDetailBean;
import com.neocom.mobilerefueling.bean.OrderResponseBean;
import com.neocom.mobilerefueling.bean.OrderSuccessBean;
import com.neocom.mobilerefueling.bean.PaiSongDanOilPriceRespBean;
import com.neocom.mobilerefueling.bean.PaisongDanItemBean;
import com.neocom.mobilerefueling.bean.PayResponseParamBean;
import com.neocom.mobilerefueling.bean.PayWXRespParaBean;
import com.neocom.mobilerefueling.bean.PayWayReqBean;
import com.neocom.mobilerefueling.bean.PeopleDetailRespBean;
import com.neocom.mobilerefueling.bean.PiciDetailBean;
import com.neocom.mobilerefueling.bean.ProcessWithGoodsRespBean;
import com.neocom.mobilerefueling.bean.ProvinceCodeRespBean;
import com.neocom.mobilerefueling.bean.QZKHRespBean;
import com.neocom.mobilerefueling.bean.QzkhTjshBean;
import com.neocom.mobilerefueling.bean.RCodeResp;
import com.neocom.mobilerefueling.bean.ReceiverOrderBeanBring;
import com.neocom.mobilerefueling.bean.RecmentRespListBean;
import com.neocom.mobilerefueling.bean.RescheduRespBean;
import com.neocom.mobilerefueling.bean.ResetCarOilRespBean;
import com.neocom.mobilerefueling.bean.ResponseDingDanOrderBean;
import com.neocom.mobilerefueling.bean.ResponseGetOilPageBean;
import com.neocom.mobilerefueling.bean.SHTGRedpBean;
import com.neocom.mobilerefueling.bean.ShiftResponseBean;
import com.neocom.mobilerefueling.bean.ShiftWorkDetailBean;
import com.neocom.mobilerefueling.bean.StartProcessRespBean;
import com.neocom.mobilerefueling.bean.SupplyDetailRespBean;
import com.neocom.mobilerefueling.bean.SupplyListBean;
import com.neocom.mobilerefueling.bean.TiYNewRespBean;
import com.neocom.mobilerefueling.bean.TiYouRespBean;
import com.neocom.mobilerefueling.bean.UnionParRespBean;
import com.neocom.mobilerefueling.bean.UpdRespBean;
import com.neocom.mobilerefueling.bean.WaitDoResponse;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by admin on 2017/7/20.
 * 网络请求 接口
 */

public interface IRequestServices {

    /**
     * 获取所有的订单
     */
    @POST("/busi/interface/searchIndentList")
//    Call<AllOrderBean> getAllOrder(@Query("UserId") String userId);
    Call<AllOrderBean> getAllOrder(@Body RequestBody body);

    @POST("/busi/interface/searchIndentInfoById")
    Call<OrderDetailBean> getOrderInfoById(@Body RequestBody body);

    @POST("/busi/interface/searchIndentListByUserId")
    Call<AllOrderBean> getListByUserID(@Body RequestBody body);

    @POST("/busi/interface/saveIndent")
    Call<OrderSuccessBean> addOrder(@Body RequestBody body);


    @POST("/busi/interface/deliveryOrderList")
    Call<ReceiverOrderBeanBring> deliveryOrderList(@Body RequestBody body);

    /**
     * @param body
     * @return 获取 派送单详情
     */
    @POST("/busi/deliveryInterface/getDeliveryOrderById ")
    Call<DeliveryOrderRespBean> getDeliveryOrderById(@Body RequestBody body);

    /**
     * 新增一条提油管理信息
     */

    @POST("/busi/interface/addPurchase")
    Call<TiYouRespBean> addPurchase(@Body RequestBody body);

    /**
     * @param body
     * @return 获取批次信息
     */
    @POST("/busi/interface/searchBatchList")
    Call<GetPiCiBean> searchBatchList(@Body RequestBody body);

    /**
     * 接受 拒绝 拍单
     */

    @POST("/busi/deliveryInterface/takeDeliveryOrder")
    Call<EmptyBringGetOilBean> takeDeliveryOrder(@Body RequestBody body);

    /**
     * 提交 派送单
     *
     * @param body
     * @return
     */
    @POST("/busi/deliveryInterface/submitDeliveryOrder")
    Call<EmptyBringGetOilBean> submitDeliveryOrder(@Body RequestBody body);

    /**
     * 查询 当前油价
     */

    @POST("/busi/deliveryInterface/getCurrentOilPrice")
    Call<Object> getCurrentOilPrice(@Body RequestBody body);

    /**
     * 查询提油管理信息列表
     */
    @POST("/busi/interface/purchaseList")
    Call<ResponseGetOilPageBean> purchaseList(@Body RequestBody body);

    /**
     * 获取 车车辆列表
     */
    @POST("/busi/interface/findCarListByUserId")
    Call<ChooseCarBeanBring> findCarListByUserId(@Body RequestBody body);

    /**
     * 查询 当前用户的 地址列表
     */

    @POST("/busi/interface/searchAddressListByUserId")
    Call<AddressListRequest> searchAddressListByUserId(@Body RequestBody body);

    @POST("/busi/interface/searchIndentListByUserId")
    Call<ResponseDingDanOrderBean> searchIndentListByUserId(@Body RequestBody body);

//    @POST("/busi/interface/searchIndentInfoById")
//    Call<ResponseDingDanDetailBean> searchIndentInfoById(@Body RequestBody body);

    /**
     * 查询一条提油管理信息
     *
     * @param body
     * @return
     */

    @POST("/busi/interface/purchaseDetail")
    Call<GetOilDetaiBean> purchaseDetail(@Body RequestBody body);

    /**
     * 查询批次管理详细信息
     *
     * @param body
     * @return
     */
    @POST("/busi/interface/batchDetail")
    Call<PiciDetailBean> batchDetail(@Body RequestBody body);

    /**
     * 新增一条补给管理信息接口
     */
    @POST("/busi/interface/addSupply")
    Call<BuJiRespBean> addSupply(@Body RequestBody body);

    /**
     * 新增或修改一条地址信息
     */
    @POST("/busi/interface/saveOrUpdateAddress")
    Call<EmptyBringGetOilBean> saveOrUpdateAddress(@Body RequestBody body);

    /**
     * 删除地址信息
     */
    @POST("/busi/interface/deleteAddress")
    Call<EmptyBringGetOilBean> deleteAddress(@Body RequestBody body);

    /**
     * 查询用户交接班记录列表
     */
    @POST("/busi/interface/searchOilShiftList")
    Call<ShiftResponseBean> searchOilShiftList(@Body RequestBody body);

    @POST("/busi/interface/searchIndentInfoById")
    Call<OrderResponseBean> searchIndentInfoById(@Body RequestBody body);

    @Streaming
    @GET
    Call<ResponseBody> fileDownLoad(@Url String url);

    /**
     * 新增或修改交接班记录
     */
    @POST("/busi/interface/insertOilShiftDuty")
    Call<AddShitWorkRespBean> insertOilShiftDuty(@Body RequestBody body);

    /**
     * 根据Id查询交接班详情
     */
    @POST("/busi/interface/findOilShiftById")
    Call<ShiftWorkDetailBean> findOilShiftById(@Body RequestBody body);

    /**
     * 确认交接班
     */

    @POST("/busi/interface/updateShiftStatus")
    Call<EmptyBringGetOilBean> updateShiftStatus(@Body RequestBody body);

    /**
     * 登录
     */
    @POST("/busi/interface/login")
    Call<LoginResponseBean> login(@Body RequestBody body);


    /**
     * 查询补给管理信息列表
     */
    @POST("/busi/interface/supplyList")
    Call<YunYouCheResponseBean> supplyList(@Body RequestBody body);

    /**
     * 查询一条补给管理信息
     */

    @POST("/busi/interface/supplyDetail ")
    Call<SupplyDetailRespBean> supplyDetail(@Body RequestBody body);

    /**
     * 确认 提油单
     */

    @POST("/busi/interface/modifyRecordSupply")
    Call<EmptyBringGetOilBean> modifyRecordSupply(@Body RequestBody body);

    /**
     * 修改一条提油管理信息
     */
    @POST("/busi/interface/modifyPurchase")
    Call<EmptyBringGetOilBean> modifyPurchase(@Body RequestBody body);


    /**
     * 合同列表
     */
    @POST("/busi/interface/searchContractList")
    Call<HeTongResBean> searchContractList(@Body RequestBody body);

    /**
     * 合同详情
     */
    @POST("/busi/interface/contractDetail")
    Call<HeTongRespBean> contractDetail(@Body RequestBody body);

    /**
     * 根据部门Id查询人员列表
     */
    @POST("/busi/interface/findPeopleByDeptId")
    Call<ChoosePersonBean> findPeopleByDeptId(@Body RequestBody body);

    /**
     * 新增NFC标签
     */
    @POST("/busi/interface/insertNfcLable")
    Call<String> insertNfcLable(@Body RequestBody body);

    /**
     * 根据车牌号查询加油记录(查询加油机数据)
     */

    @POST("/busi/interface/findFuelDiaryByCarNum")
    Call<JiaYouJiRespBean> findFuelDiaryByCarNum(@Body RequestBody body);

    /**
     * 查询流程信息接口
     */

    @POST("/workflow/interface/toView")
    Call<String> toView(@Body RequestBody body);

    /**
     * 4	查询待办事项接口
     */

    @POST("/workflow/interface/todoList")
    Call<WaitDoResponse> todoList(@Body RequestBody body);

    /**
     * 获取 流程权限接口
     *
     * @param request
     * @return
     */
    @POST("/workflow/interface/permissionList")
    Call<String> permissionList(@Body RequestBody request);

    /**
     * 新增流程工单获取接口
     */
    @POST("/workflow/interface/toAddForApp")
    Call<String> toAddForApp(@Body RequestBody request);

    /**
     * 启动和关联事件流程
     *
     * @return
     */
    @POST("/workflow/interface/startProcess")
    Call<StartProcessRespBean> startProcessPart(@Body RequestBody body);

    /**
     * 5	流程信息通过接口*
     */
    @POST("/workflow/interface/processNodeTask")
    Call<OnlyStringBeanReso> processNodeTask(@Body RequestBody body);

    /**
     * 流程信息 退回接口
     */
    @POST("/workflow/interface/backTask")
    Call<OnlyStringBeanReso> backTask(@Body RequestBody body);

    /**
     * 流程关联商品接口
     */
    @POST("/busi/process/interface/processRelGoods")
    Call<ProcessWithGoodsRespBean> processRelGoods(@Body RequestBody body);


    /**
     * 启动事件流程
     *
     * @return
     */
    @retrofit2.http.POST("/workflow/interface/startProcess")
    retrofit2.Call<String> startProcess(@retrofit2.http.Body okhttp3.RequestBody body);

    /**
     * 根据车牌号查询油品类型和国标
     */
    @POST("/busi/interface/findOilTypeByCarNum")
    Call<PaisongDanItemBean> findOilTypeByCarNum(@Body RequestBody body);


    /**
     * 根据地区 查询油价
     */
    @POST("/busi/interface/findOilpriceByArea")
    Call<OilResponseBean> findOilpriceByArea(@Body RequestBody body);

    /**
     * 根据车牌号查询车辆信息
     */
    @POST("/busi/interface/findCarinfoByCarNum")
    Call<CarNumRespInfoBean> findCarinfoByCarNum(@Body RequestBody body);


    /**
     * 查询所有国标类型
     */
    @POST("/busi/interface/findAllGB")
    Call<OilLXGBBean> findAllGB(@Body RequestBody body);

    /**
     * 查询所有柴油类型
     */
    @POST("/busi/interface/findAllCYLX")
    Call<OilLXGBBean> findAllCYLX(@Body RequestBody body);


    /**
     * 检测更新
     */

    @POST("/busi/interface/upgradeApp")
    Call<UpdRespBean> upgradeApp(@Body RequestBody body);

    /**
     * 根据车牌号模糊查询车辆信息
     */

    @POST("/busi/interface/findCarinfoFuzzyCode")
    Call<GetCarInfoRespBean> findCarinfoFuzzyCode(@Body RequestBody body);

    /**
     * 根据  省份获取 该 省份对应的编码
     */
    @POST("/busi/deliveryInterface/getCodeByProvinceName")
    Call<ProvinceCodeRespBean> getCodeByProvinceName(@Body RequestBody body);

    /**
     * 根据登录用户id获取关联客户的所有油品类型的执行价格
     */
    @POST("/busi/interface/findOilPricesByUserId")
    Call<FindOilPriceRespBean> findOilPricesByUserId(@Body RequestBody body);

    /**
     * 消息列表
     */
    @POST("/busi/deliveryInterface/getAllMessage")
    Call<MsgBean> getAllMessage(@Body RequestBody body);

    /**
     * 获取订单中的商品执行价格
     */
    @POST("/busi/interface/findOilPrice")
    Call<PaiSongDanOilPriceRespBean> findOilPrice(@Body RequestBody body);

    /**
     * 更新用户密码
     */
    @POST("/busi/interface/changePassword")
    Call<EmptyBringGetOilBean> changePassword(@Body RequestBody body);

    /**
     * 获取最新版本号
     *
     * @param body
     * @return
     */
    @POST("/busi/interface/latestVersion")
    Call<UpdRespBean> latestVersion(@Body RequestBody body);

    /**
     * 企业端登录 新的
     */

    @POST("/busi/interface/enterpriseLogin")
    Call<LoginResponseBean> enterpriseLogin(@Body RequestBody body);

    /**
     * 查询潜在客户信息列表
     */

    @POST("/busi/interface/findHideCustomerList")
    Call<QZKHRespBean> findHideCustomerList(@Body RequestBody body);

    /**
     * 潜在客户信息详情查询
     */
    @POST("/busi/interface/findHideCustomerDetail")
    Call<KHDetalRespBean> findHideCustomerDetail(@Body RequestBody body);

    /**
     * 查询正式客户信息列表
     */
    @POST("/busi/interface/findFormalCustomerList")
    Call<QZKHRespBean> findFormalCustomerList(@Body RequestBody body);

    /**
     * 查看待批复列表
     */
    @POST("/busi/interface/noConfirmCustomerList")
    Call<QZKHRespBean> noConfirmCustomerList(@Body RequestBody body);

    /**
     * 待审核客户列表查询
     */

    @POST("/busi/interface/findCheckPendingCustomer")
    Call<QZKHRespBean> findCheckPendingCustomer(@Body RequestBody body);

    /**
     * 查询客户价格审批列表
     */
    @POST("/busi/interface/findPriceCheckList")
    Call<QZKHRespBean> findPriceCheckList(@Body RequestBody body);


    /**
     * 根据字典Code查询字典数据的集合
     */
    @POST("/busi/interface/findCustomerDictByCode")
    Call<DictBean> findCustomerDictByCode(@Body RequestBody body);


    /**
     * 潜在客户信息新增
     */
    @POST("/busi/interface/saveOrUpdateCustomer")
    Call<EmptyBringGetOilBean> saveCustomer(@Body RequestBody body);

    /**
     * 潜在客户信息修改
     */
    @POST("/busi/interface/saveOrUpdateCustomer")
    Call<QZKHRespBean> UpdateCustomer(@Body RequestBody body);

    /**
     * 潜在客户信息提交审核
     */
    @POST("/busi/interface/checkCustomer")
    Call<KHDetalRespBean> checkCustomer(@Body RequestBody body);

    /**
     * 潜在客户信息审核和确认
     */
    @POST("/busi/interface/customerAuditByRoleCode")
    Call<SHTGRedpBean> customerAuditByRoleCode(@Body RequestBody body);

    /**
     * 潜在客户信息删除
     *
     * @param body
     * @return
     */

    @POST("/busi/interface/deleteCustomer")
    Call<EmptyBringGetOilBean> deleteCustomer(@Body RequestBody body);


    /**
     * 正式客户信息修改
     */
    @POST("/busi/interface/updateFormalCustomer")
    Call<KHDetalRespBean> updateFormalCustomer(@Body RequestBody body);

    /**
     * 客户价格审核
     */
    @POST("/busi/interface/customerPriceCheck")
    Call<QZKHRespBean> customerPriceCheck(@Body RequestBody body);

    @POST("/busi/interface/findChangeCustomerDetail")
    Call<KHDetalRespBean> findChangeCustomerDetail(@Body RequestBody body);

    /**
     * 用户app权限查询
     *
     * @param userId
     * @return
     */
    @GET("webService/app/user/getUserAppMenus/{userId}")
    Call<MenuBean> getUserAppMenus(@Path("userId") String userId);

    /**
     * 查询没有交接班记录的车辆信息
     */
    @POST("/busi/interface/searchNewCarList")
    Call<CheLiangRespBean> searchNewCarList();


    /**
     * 根据运油车车牌号查询补给记录
     */
    @POST("/busi/interface/findSupplyListByCarNum")
    Call<YunYouCheResponseBean> findSupplyListByCarNum(@Body RequestBody body);

    /**
     * 接班人员签退下班
     */
    @POST("/busi/interface/submitQuit")
    Call<EmptyBringGetOilBean> submitQuit(@Body RequestBody body);


    /**
     * 供应商列表查询
     */
    @POST("/busi/interface/findSupplyList")
    Call<SupplyListBean> findSupplyList(@Body RequestBody body);


    /**
     * 新增批次信息管理
     */
    @POST("/busi/interface/saveBatchManager")
    Call<EmptyBringGetOilBean> saveBatchManager(@Body RequestBody body);

    /**
     * 根据车牌号查询车辆信息
     */
    @POST("/busi/interface/findCarinfoByCode")
    Call<CarInfoRespBean> findCarinfoByCode(@Body RequestBody body);

    /**
     * 根据车牌号查询提油记录列表
     */
    @POST("/busi/interface/searchByCarCode")
    Call<TiYNewRespBean> searchByCarCode(@Body RequestBody body);

    //文件上传
    @POST("/busi/interface/saveUploadFile")
    Call<FileUploadResponse> saveUploadFile(@Body RequestBody params);

    /**
     * 根据设备信息获取推荐码接口
     */
    @POST("/busi/interface/getRcodeByEquInfo")
    Call<EmptyBringGetOilBean> getRcodeByEquInfo(@Body RequestBody params);

    /**
     * 根据车牌号查询车辆状态信息
     */
    @POST("/busi/interface/findCarStateByCode")
    Call<CarStateRespBean> findCarStateByCode(@Body RequestBody params);

    /**
     * 查询人员详细信息接口
     */
    @POST("/busi/interface/findPeopleDetail")
    Call<PeopleDetailRespBean> findPeopleDetail(@Body RequestBody params);

    /**
     * 手机推荐下载链接和推荐码接口
     */
    @POST("/busi/interface/getUrlAndRcodeByUerId")
    Call<RCodeResp> getUrlAndRcodeByUerId(@Body RequestBody body);


    /**
     * 分页查询推荐客户信息接口
     */
    @POST("/busi/interface/queryRurInfoList")
    Call<RecmentRespListBean> queryRurInfoList(@Body RequestBody params);

    /**
     * 派送单重新调度请求接口
     */
    @POST("/busi/deliveryInterface/reScheduleDeliveryOrder")
    Call<RescheduRespBean> reScheduleDeliveryOrder(@Body RequestBody params);


    /**
     * 油品总价计算接口
     */
    @POST("/busi/interface/getOilTotalPrice")
    Call<AllCostRespBean> getOilTotalPrice(@Body RequestBody params);

    /**
     * 司机到场确认接口
     */

    @POST("/busi/interface/driverConfirm")
    Call<EmptyBringGetOilBean> driverConfirm(@Body RequestBody params);


//    车辆位置信息上传

    /**
     * 车辆位置信息上传
     */
    @POST("/busi/interface/uploadGps")
    Call<EmptyBringGetOilBean> uploadGps(@Body RequestBody params);

    /**
     * 车辆剩余油量清零
     */
    @POST("/busi/interface/resetCarOil")
    Call<ResetCarOilRespBean> resetCarOil(@Body RequestBody params);

    /**
     * 创建结算记录
     */
    @POST("/busi/interface/dailyIndex")
    Call<EmptyBringGetOilBean> dailyIndex(@Body RequestBody params);

    /**
     * 查询所有结算记录
     */
    @POST("/busi/interface/queryDailyRecordList")
    Call<DailyBalanceRespBean> queryDailyRecordList(@Body RequestBody params);

    /**
     * 查询结算单周期内订单详情
     */
    @POST("/busi/interface/queryIndentList")
    Call<JieSuanRespBean> queryIndentList(@Body RequestBody params);


    /**
     * @param relativeId
     * @param type
     * @return 广铁项目-根据表单id获取关联的商品信息集合
     */
    @retrofit2.http.POST("/webService/app/commodity/goodsList/{relativeId}/{type}")
    retrofit2.Call<GodsListRespBean> goodsList(@retrofit2.http.Path("relativeId") String relativeId, @retrofit2.http.Path("type") String type);

    /**
     * 查询车辆状态信息
     */
    @POST("/busi/interface/getCarStateList")
    Call<CarCodeRespBean> getCarStateList(@Body RequestBody body);

    /**
     * 查询车辆状态信息
     */
    @POST("/busi/interface/queryDailyRecordById")
    Call<DailyRecordRespBean> queryDailyRecordById(@Body RequestBody body);

    /**
     * 根据设备信息获取推荐码接口
     */
    @POST("/workflow/interface/havedoList")
    Call<WaitDoResponse> havedoList(@Body RequestBody params);

    /**
     * 新的 待办获取接口 待办流程工单获取接口
     */
    @POST("/workflow/interface/toUpdateForApp")
    Call<String> toUpdateForApp(@Body RequestBody params);


    /**
     * 已办流程和我发起的流程工单获取接口
     */
    @POST("/workflow/interface/toViewForApp")
    Call<String> toViewForApp(@Body RequestBody params);

    /**
     * 我要申诉
     *
     * @param body
     * @return
     */
    @POST("/busi/interface/dissentDailyRecord")
    Call<EmptyBringGetOilBean> dissentDailyRecord(@Body RequestBody body);


    @POST("/busi/interface/dailyAccountPass")
    Call<EmptyBringGetOilBean> dailyAccountPass(@Body RequestBody body);


    /**
     * 支付宝 支付接口
     */
    @POST("/busi/payment/payment")
    Call<PayResponseParamBean> paymentAliPay(@Body RequestBody body);

    /**
     * 微信支付接口
     */
    @POST("/busi/payment/payment")
    Call<PayWXRespParaBean> paymentWXPay(@Body RequestBody body);


    /**
     * 银联支付
     */
    @POST("/busi/payment/payment")
    Call<UnionParRespBean> paymentUnionPay(@Body RequestBody body);

    /**
     * 根据交易记录id更新交易记录状态
     */

    @POST("/busi/payment/updateStatus")
    Call<EmptyBringGetOilBean> updateStatus(@Body RequestBody body);

    /**
     * 根据业务标识获得支付方式
     */
    @POST("/busi/interface/getPayWayByBusinessId")
    Call<PayWayReqBean> getPayWayByBusinessId(@Body RequestBody params);

    /**
     *
     */
    @POST("/busi/interface/updateUserCustomize")
    Call<EmptyBringGetOilBean> updateUserCustomize(@Body RequestBody params);
//    /**
//     * 查询客户价格审批列表
//     */
//    @POST("/busi/interface/findPriceCheckList")
//    Call<QZKHRespBean> findPriceCheckList(@Body RequestBody body);

//    /**
//     * 根据字典Code查询字典数据的集合
//     */
//    @POST("/busi/interface/findCustomerDictByCode")
//    Call<QZKHRespBean> findCustomerDictByCode(@Body RequestBody body);


//    /**
//     * 根据登录用户id获取关联客户的所有油品类型的执行价格
//     */
//    @POST("/busi/interface/findOilPricesByUserId")
//    Call<FindOilPriceRespBean> findOilPricesByUserId(@Body RequestBody body);
//

}
