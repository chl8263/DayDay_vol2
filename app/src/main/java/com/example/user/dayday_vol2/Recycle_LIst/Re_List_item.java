package com.example.user.dayday_vol2.Recycle_LIst;

/**
 * Created by User on 2017-07-07.
 */

public class Re_List_item {
    private String date;
    private String day;
    private String time;
    private String title;
    private String contnet;
    private int image;
    public Re_List_item(String a ,String b,String c,String d,String f,int g){
        this.date=a;
        this.day= b;
        this.time=c;
        this.title=d;
        this.contnet=f;
        this.image=g;
    }
    public String getDate(){return date;}
    public String getDay(){
        return day;
    }
    public String getTime(){
        return time;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return contnet;
    }
    public int getImage(){return image;}
}
