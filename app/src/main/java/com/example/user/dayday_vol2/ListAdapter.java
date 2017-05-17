package com.example.user.dayday_vol2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by 115-03 on 2017-05-17.
 */

public class ListAdapter extends BaseAdapter {
    private Context context;
    private int res;
    private ArrayList<DrawItem> drawItems;
    public ListAdapter (Context context,int res,ArrayList<DrawItem>items){
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

        return convertView;
    }
}
