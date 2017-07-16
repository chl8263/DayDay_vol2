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
        db.execSQL("CREATE TABLE IF NOT EXISTS '"+name+"' (date TEXT, dat TEXT , time TEXT , title TEXT, content TEXT);");
        db.close();
    }
    public void insert(String name,String date,String day,String time,String title,String content){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into '"+name+"' values('"+date+"','"+day+"','"+time+"','"+title+"','"+content+"');");
    }
    public String getTitle(String tablename){
        SQLiteDatabase db = getReadableDatabase();
        String result=null;

        Cursor cursor = db.rawQuery("select * from '"+tablename+"'",null);
        while (cursor.moveToNext()){
            result+=cursor.getString(0);
            result+=cursor.getString(1);
        }
        return  result;
    }
    public int count(String name){
        SQLiteDatabase db = getReadableDatabase();
        int cnt=0;
        Cursor cursor = db.rawQuery("select * from '"+name+"'",null);
        cnt = cursor.getCount();
        return cnt;
    }
    public boolean getTable(String name){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name ='"+name+"'" , null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}
