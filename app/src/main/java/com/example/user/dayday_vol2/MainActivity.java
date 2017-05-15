package com.example.user.dayday_vol2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DrawAdapter drawAdapter;
    private ArrayList<DrawItem>  drawItems;
    private ListView DrawlistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDrawerLayout();
    }

    private void setDrawerLayout(){
        drawerLayout = (DrawerLayout)findViewById(R.id.drawlayoutNavigation);
        drawItems = new ArrayList<DrawItem>();
        //asdasdsa
        drawItems.add(new DrawItem(R.drawable.indraw_home,"홈"));
        drawItems.add(new DrawItem(R.drawable.indraw_cal,"캘린더"));
        drawItems.add(new DrawItem(R.drawable.indraw_album,"앨범"));
        drawItems.add(new DrawItem(R.drawable.indraw_set,"설정"));
        drawItems.add(new DrawItem(R.drawable.indraw_sign,"서명"));
        drawAdapter = new DrawAdapter(this,R.layout.drawlistitem,drawItems);
        DrawlistView = (ListView)findViewById(R.id.menu_list);
        DrawlistView.setAdapter(drawAdapter);
        DrawlistView.setDividerHeight(5);

    }
}
