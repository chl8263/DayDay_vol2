package com.example.user.dayday_vol2;

/**
 * Created by 115-03 on 2017-05-17.
 */

public class ListItem {
    private int res;
    private String name;

    public  ListItem(int res,String name){
        this.res = res;
        this.name = name;
    }
    public int getImg(){
        return res;
    }
    public String getName(){
        return name;
    }
}
