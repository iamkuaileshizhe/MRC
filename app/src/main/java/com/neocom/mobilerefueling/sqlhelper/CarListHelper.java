package com.neocom.mobilerefueling.sqlhelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 2017/9/1.
 */

public class CarListHelper extends SQLiteOpenHelper {
    private static final String TAG = "CarListHelper";

    public CarListHelper(Context context) {
        super(context, "carList.db", null, 1);
        Log.i(TAG, "CarListHelper: 创建数据库");
    }

    public CarListHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // 操作数据库
        String sql = "create table car(_id integer primary key, id varchar(50),relateId varchar(50),relateType varchar(50),vehicleCode varchar(50),pName varchar(50),telphone varchar(50),oilType varchar(50),tankSize varchar(50),num varchar(50),finishTime varchar(50),oilBalance varchar(50),fillTime varchar(50),oilTypeName varchar(50),dstate varchar(50),status varchar(50),c_user varchar(50),c_dt varchar(50),u_user varchar(50),u_dt varchar(50));";
        sqLiteDatabase.execSQL(sql);
        Log.i(TAG, "onCreate: 创建数据库表...");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
