package com.example.user.dayday_vol2.DrawLay;

/**
 * Created by User on 2017-07-07.
 */

public class DrawItem {
    private int res;
    private String name;

    public DrawItem(int res, String name) {
        this.res = res;
        this.name = name;
    }

    public int getImg() {
        return res;
    }

    public String getName() {
        return name;
    }
}
