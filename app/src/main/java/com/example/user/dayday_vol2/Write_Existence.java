package com.example.user.dayday_vol2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dayday_vol2.Sqlite.DBManager;

import java.util.Calendar;

/**
 * Created by User on 2017-07-17.
 */

public class Write_Existence extends AppCompatActivity implements View.OnClickListener{
    private DBManager manager;
    private TextView year,day,date;
    private EditText write_title, write_content;
    private ImageView confirm,recycling_bin,album,photo;
    private String yearr,month,month2, time,dayy = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        manager = new DBManager(getApplicationContext(),"WRITE",null,1);
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

        /*SimpleDateFormat sdfNow = new SimpleDateFormat("MM", Locale.KOREA);
        month = sdfNow.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow2 = new SimpleDateFormat("dd",Locale.KOREA);
        month2 = sdfNow2.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow3 = new SimpleDateFormat("yyyy",Locale.KOREA);
        yearr = sdfNow3.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat timee = new SimpleDateFormat("HH:mm",Locale.KOREA);
        time = timee.format(new Date(System.currentTimeMillis()));*/

        day.setText(+"월"+month2+"일");
        year.setText(yearr);
        date.setText(dayy);
    }
    private String doDayOfWeek(){
        Calendar cal = Calendar.getInstance();

        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (nWeek){
            case 1:dayy  ="일요일";break;
            case 2:dayy  ="월요일";break;
            case 3:dayy  ="화요일";break;
            case 4:dayy  ="수요일";break;
            case 5:dayy  ="목요일";break;
            case 6:dayy  ="금요일";break;
            case 7:dayy  ="토요일";break;
        }
        return dayy;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm:
                manager.insertTable(yearr+month);
                manager.insert(yearr+month,month2,dayy,time,write_title.getText().toString(),write_content.getText().toString());
                Intent intent = new Intent("refresh");
                getApplicationContext().sendBroadcast(intent);

                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);//엑티비티 종료시에 자판 까지 뒤로 넘겨 자연스럽게하기
                inputMethodManager.hideSoftInputFromWindow(write_title.getWindowToken(),0);
                finish();
                break;
            case R.id.recycling_bin:
                manager.delectDB(yearr+month,month2,dayy,time);
                break;
            case R.id.album:
                break;
            case R.id.photo:
                break;
        }
    }
}