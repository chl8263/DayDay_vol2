package com.example.user.dayday_vol2;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.dayday_vol2.DrawLay.DrawAdapter;
import com.example.user.dayday_vol2.DrawLay.DrawItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DrawAdapter drawAdapter;
    private ArrayList<DrawItem> drawItems;
    private ListView DrawlistView;
    private ImageView DrawButton;
    private LinearLayout listBtn;
    private LinearLayout gridBtn;
    private LinearLayout fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListGridBtn();
        setDrawerLayout();
        setDrawerLayoutButton();

    }
    private void setListGridBtn(){
        fragment = (LinearLayout)findViewById(R.id.fragament);
        listBtn = (LinearLayout)findViewById(R.id.ListViewBtn);
        gridBtn = (LinearLayout)findViewById(R.id.GridViewBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(0);
                Log.e("asd","asd");
            }
        });
        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(1);
                Log.e("aaaa","aaaa");
            }
        });
    }
    private void switchFragment(int i){
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (i){
            case 0:
                Log.e("switch0","aaaa");
                ListFragment Listfragment = new ListFragment();
                transaction.replace(R.id.fragament,Listfragment);
                transaction.commit();
                break;
            case 1:
                Log.e("switch1","aaaa");
                GridFragment Gridfragment = new GridFragment();
                transaction.replace(R.id.fragament,Gridfragment);
                transaction.commit();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START))
            drawerLayout.closeDrawer(Gravity.START);
        else
            super.onBackPressed();
    }

    private void setDrawerLayoutButton() {
        DrawButton = (ImageView) findViewById(R.id.drawlayoutMenu);
        DrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(DrawlistView);
            }
        });

    }

    private void setDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayoutNavigation);
        drawItems = new ArrayList<DrawItem>();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED); //드로워블 잠금
        drawItems.add(new DrawItem(R.drawable.indraw_home, "홈"));
        drawItems.add(new DrawItem(R.drawable.indraw_cal, "캘린더"));
        drawItems.add(new DrawItem(R.drawable.indraw_album, "앨범"));
        drawItems.add(new DrawItem(R.drawable.indraw_set, "설정"));
        drawItems.add(new DrawItem(R.drawable.indraw_sign, "서명"));
        drawAdapter = new DrawAdapter(this, R.layout.draw_list_item, drawItems);
        DrawlistView = (ListView) findViewById(R.id.menu_list);
        DrawlistView.setAdapter(drawAdapter);
        DrawlistView.setDividerHeight(5);
        DrawlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
            }
        });
    }
}
