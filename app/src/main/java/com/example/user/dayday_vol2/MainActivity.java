package com.example.user.dayday_vol2;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DrawAdapter drawAdapter;
    private ArrayList<DrawItem> drawItems;
    private ListView DrawlistView;
    private ImageView DrawButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDrawerLayout();
        setDrawerLayoutButton();

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
        drawAdapter = new DrawAdapter(this, R.layout.drawlistitem, drawItems);
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
