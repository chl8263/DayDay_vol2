package com.example.user.dayday_vol2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 115-03 on 2017-05-15.
 */

public class Preference {
    public static SharedPreferences p = null;
    public static void setPreferances(Context context, String key, String value){
        p = context.getSharedPreferences("ListGrid",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public static String getPreferences(Context context,String key){
        p = context.getSharedPreferences("ListGrid",context.MODE_PRIVATE);
        return p.getString(key,"asd");
    }
}
