package com.example.user.dayday_vol2.Recycle_LIst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.dayday_vol2.R;

import java.util.ArrayList;

/**
 * Created by User on 2017-07-07.
 */

public class Re_List_Adapter extends RecyclerView.Adapter<Re_List_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Re_List_item> list;
    private ViewHolder holder;
    public Re_List_Adapter(Context context,ArrayList<Re_List_item> list){
        this.context = context;
        this.list=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item,parent,false);
        holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name1.setText(list.get(position).name1());
        holder.name2.setText(list.get(position).name2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name1;
        public TextView name2;
        public ViewHolder(View itemView) {
            super(itemView);
            name1=(TextView)itemView.findViewById(R.id.name1);
            name2=(TextView)itemView.findViewById(R.id.name2);
        }
    }
}
