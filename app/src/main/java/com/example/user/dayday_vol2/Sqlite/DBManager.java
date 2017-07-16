package com.example.user.dayday_vol2.Sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2017-07-15.
 */

public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertTable(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("create table "+name+" (title text,content text)");
    }
    public void insert(String name,String title,String content){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into "+name+" values('"+title+"','"+content);
    }
    public String getTitle(String tablename){
        SQLiteDatabase db = getReadableDatabase();
        String result=null;

        Cursor cursor = db.rawQuery("select * from "+tablename,null);
        while (cursor.moveToNext()){
            result+=cursor.getString(0);
        }
        return  result;
    }

}
