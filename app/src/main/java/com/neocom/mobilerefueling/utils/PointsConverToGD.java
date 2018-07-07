package com.neocom.mobilerefueling.utils;

import android.content.Context;

import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.model.LatLng;

/**
 * Created by admin on 2017/12/7.
 *
 * 百度坐标系 转换为 高德地图 坐标系
 * 其他系坐标 调节 此值
 * CoordinateConverter.CoordType.BAIDU
 */


public class PointsConverToGD {

    public  static LatLng convetToGD(Context context, LatLng sourceLatLng){
        CoordinateConverter converter  = new CoordinateConverter(context);
        // CoordType.GPS 待转换坐标类型
        converter.from(CoordinateConverter.CoordType.BAIDU);
        // sourceLatLng待转换坐标点
        converter.coord(sourceLatLng);
        // 执行转换操作
        LatLng desLatLng = converter.convert();
        return desLatLng;
    }

}
