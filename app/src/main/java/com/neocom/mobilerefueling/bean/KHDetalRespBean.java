package com.neocom.mobilerefueling.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 * 客户 详情返回
 */


public class KHDetalRespBean extends BaseBean {


    /**
     * bring : {"id":"55495a0d5942405099f86033e7266d4d","cusname":"济南铁路(测试用)改1","nameNum":"C20180130002","nameSim":"济南铁路改","cusType":"1","cusSource":"2","customerPayment":"1","firmNum":"company_123","firmLoc":"济南市顺泰广场","firmCapital":"2000","firmLegal":"张总","firmDate":"2018-01-30","firmType":"2","firmBuscope":"6","firmIndustry":"4","linkmanOne":"3242a379eb3c400a8f32edf0d0c17c83","linkmanTwo":null,"salesMan":"3b6ddbe91a7444a3bec1d96bc20f5d29","other":"测试客户","cuser":"3b6ddbe91a7444a3bec1d96bc20f5d29","cdt":"2018-01-30 13:42:41","uuser":null,"udt":null,"checkStatus":"5","customerStatus":null,"status":"1","settlement":"1","customerGrade":"1","changeType":null,"oilType":"1","oilTypesName":"5号柴油","payWay":"2","billAsk":"无要求","carNum":"200","carType":"2","supplyRate":"2次/天","supplyNum":"200L/次","supplyWay":"2","wishArea":"山东省济南市","wishOil":"无","otherSer":"无","linkmanName":null,"linkmanPhone":null,"linkManMess":{"createTime":"2018-01-30 13:42:39","sex":"3","birth":"2018-01-29","belong":"55495a0d5942405099f86033e7266d4d","type":"0","licenceNum":null,"id":"3242a379eb3c400a8f32edf0d0c17c83","userInfoId":"3b10bb1a5aa5401785f367e37f1c42f9","name":"张强改","driverAge":null,"userId":"3b10bb1a5aa5401785f367e37f1c42f9","weChat":"wechat1","createId":null,"licenceType":null,"userCode":"GMJY000150","status":null,"updateTime":"2018-01-30 16:52:37","driverLev":null,"updateId":null,"workNum":null,"code":null,"createName":null,"updateName":"市场经理","email":"ceshi1@163.com","driverRemark":null,"telephone":"6666666","qqNum":"769609901","mobile":"1388888888"},"saleManMess":{"userTel":"13666666666","userName":"业务员","userEmail":"lmyou512@163.com"},"otherMess":{"customerSourceName":"合作伙伴","firmBuscopeName":"安防工程","settlementName":"现结算","customerTypeName":"企业","carTypeName":"客车","firmTypeName":"国有企业","firmIndustryName":"油气储运","payWayName":"账期结算","supplyWayName":"油罐"},"strikePriceList":[{"id":"584c69ee89e74dd184553ed9a04825fe","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.1","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"1"},{"id":"1b6494bea41e4e49a75b9a09e96aaa24","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.2","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"2"},{"id":"c0c105a53098422b84680907219ba479","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.3","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"3"},{"id":"c92343b7665d4be1a505d86376e407fe","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.4","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"4"},{"id":"4123ad9f4bb04e969bea24bfcb1fae91","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.5","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"5"},{"id":"4e7c8b7dd2264e1185df07037e9cb57f","nationalStandard":"4","customerId":"55495a0d5942405099f86033e7266d4d","performAmount":"5.6","province":"630000","provinceName":"青海省","discountAmount":"1","oilType":"6"}]}
     */

    private KHDetailBringBean bring;

    public KHDetailBringBean getBring() {
        return bring;
    }

    public void setBring(KHDetailBringBean bring) {
        this.bring = bring;
    }
}
