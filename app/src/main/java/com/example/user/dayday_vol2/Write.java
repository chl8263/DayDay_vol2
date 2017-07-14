package com.example.user.dayday_vol2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by User on 2017-07-10.
 */

public class Write extends AppCompatActivity {
    private TextView year,day,date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        setTextView();
    }
    private void setTextView(){
        String dayy = doDayOfWeek();
        year= (TextView)findViewById(R.id.year);
        date= (TextView)findViewById(R.id.date);
        day= (TextView)findViewById(R.id.day);

        SimpleDateFormat sdfNow = new SimpleDateFormat("MM");
        String month = sdfNow.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow3 = new SimpleDateFormat("yyyy");
        String yearr = sdfNow3.format(new Date(System.currentTimeMillis()));

        SimpleDateFormat sdfNow2 = new SimpleDateFormat("dd");
        String month2 = sdfNow2.format(new Date(System.currentTimeMillis()));
        day.setText(month+"월"+month2+"일");
        year.setText(yearr);
        date.setText(dayy);
    }
    private String doDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        String day = null;

        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        switch (nWeek){
            case 1:
                day  ="일요일";
                break;
            case 2:
                day  ="월요일";
                break;
            case 3:
                day  ="화요일";
               break;
            case 4:
                day  ="수요일";
                break;
            case 5:
                day  ="목요일";
                break;
            case 6:
                day  ="금요일";
                break;
            case 7:
                day  ="토요일";
                break;

        }
        return day;
    }
}






















