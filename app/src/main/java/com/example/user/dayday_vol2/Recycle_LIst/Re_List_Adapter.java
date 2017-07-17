package com.example.user.dayday_vol2.Recycle_LIst;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    private ItemClick click;
    public interface ItemClick{
        public void onClick(View view,int position);
    }
    public void setItemClick (ItemClick itemClick){
        this.click = itemClick;
    }
    public Re_List_Adapter(Context context, ArrayList<Re_List_item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item, parent, false);
        holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.date.setText(list.get(position).getDate());
        holder.day.setText(list.get(position).getDay());
        holder.time.setText(list.get(position).getTime());
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
        holder.image.setImageResource(list.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(click != null){
                    click.onClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView day;
        public TextView time;
        public TextView title;
        public TextView content;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            day = (TextView) itemView.findViewById(R.id.day);
            time = (TextView) itemView.findViewById(R.id.time);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            image = (ImageView) itemView.findViewById(R.id.list_image);
        }
    }
}
