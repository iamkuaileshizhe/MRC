package com.neocom.mobilerefueling.sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin_xyz on 2017/7/21.
 * 创建人：xyz
 * 创建日期:2017/7/21
 * 描述: 首页菜单 数据库 帮助类
 */

public class MenuDaoHelper extends SQLiteOpenHelper {



    private static final String TAG = "MenuDaoHelper";

//    public MenuDaoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    public MenuDaoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }

    /**
     * 数据库的构造函数
     * @param context
     *
     * name 数据库名称
     * factory 游标工程
     * version 数据库的版本号 不可以小于1
     */
    public MenuDaoHelper(Context context) {
        super(context, "menu.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        sqLiteDatabase.execSQL("CREATE TABLE homemenu(menuid INTEGER PRIMARY KEY AUTOINCREMENT,menuicon VARCHAR(20) ,menuname VARCHAR(20))");

        String sql="create table homemenu(menuid INTEGER PRIMARY KEY AUTOINCREMENT,menuorder integer,menuicon integer ,menuname varchar(20))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
