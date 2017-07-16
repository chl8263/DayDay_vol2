package com.example.user.dayday_vol2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dayday_vol2.Sqlite.DBManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by User on 2017-07-10.
 */

public class Write extends AppCompatActivity implements View.OnClickListener{
    private DBManager manager= new DBManager(getApplicationContext(),"WRITE",null,1);
    private TextView year,day,date;
    private EditText write_title, write_content;
    private ImageView confirm,recycling_bin,album,photo;
    private String yearr,month,month2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        setEditView();
        setImage();
        setTextView();
    }
    private void setImage(){
        confirm = (ImageView)findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        recycling_bin = (ImageView)findViewById(R.id.recycling_bin);
        recycling_bin.setOnClickListener(this);
        album = (ImageView)findViewById(R.id.album);
        recycling_bin.setOnClickListener(this);
        photo = (ImageView)findViewById(R.id.photo);
        photo.setOnClickListener(this);
    }
    private void setEditView(){
        write_title = (EditText)findViewById(R.id.write_title);
        write_content=(EditText)findViewById(R.id.write_content);
    }
    private void setTextView(){
        String dayy = doDayOfWeek();
        year= (TextView)findViewById(R.id.year);
        date= (TextView)findViewById(R.id.date);
        day= (TextView)findViewById(R.id.day);

        SimpleDateFormat sdfNow = new SimpleDateFormat("MM");
        month = sdfNow.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow2 = new SimpleDateFormat("dd");
        month2 = sdfNow2.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow3 = new SimpleDateFormat("yyyy");
        yearr = sdfNow3.format(new Date(System.currentTimeMillis()));



        day.setText(month+"월"+month2+"일");
        year.setText(yearr);
        date.setText(dayy);
    }
    private String doDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        String day = null;
        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (nWeek){
            case 1:day  ="일요일";break;
            case 2:day  ="월요일";break;
            case 3:day  ="화요일";break;
            case 4:day  ="수요일";break;
            case 5:day  ="목요일";break;
            case 6:day  ="금요일";break;
            case 7:day  ="토요일";break;
        }
        return day;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                manager.insertTable(yearr+month);
                manager.insert();
                break;
            case R.id.recycling_bin:
                break;
            case R.id.album:
                break;
            case R.id.photo:
                break;
        }
    }
}






















