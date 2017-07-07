package com.example.user.dayday_vol2.DrawLay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.dayday_vol2.R;

import java.util.ArrayList;

/**
 * Created by User on 2017-05-14.
 */

public class DrawAdapter extends BaseAdapter {
    private Context context;
    private int res;
    private ArrayList<DrawItem> drawItems;
    public DrawAdapter (Context context,int res,ArrayList<DrawItem>items){
        this.context = context;
        this.res = res;
        this.drawItems = items;
    }
    @Override
    public int getCount() {
        return drawItems.size();
    }

    @Override
    public Object getItem(int position) {
        return drawItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(res,parent,false);
        }
        ImageView icon = (ImageView)convertView.findViewById(R.id.drawListImg);
        icon.setImageResource(drawItems.get(position).getImg());
        TextView name = (TextView)convertView.findViewById(R.id.drawListText);
        name.setText(drawItems.get(position).getName());
        return convertView;
    }


}
