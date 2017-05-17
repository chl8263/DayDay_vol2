package com.example.user.dayday_vol2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 115-03 on 2017-05-17.
 */

public class ListViewFragment  extends Fragment{
    private ArrayList<DrawItem> drawItems;
    private DrawAdapter drawAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        drawItems = new ArrayList<DrawItem>();

       // ListAdapter listAdapter = new ListAdapter(getActivity().getApplicationContext(),R.layout.list_fragment_item,);
        ListView view =(ListView)getView().findViewById(R.id.ListFragment);
        drawItems.add(new DrawItem(R.drawable.indraw_home, "홈"));
        drawItems.add(new DrawItem(R.drawable.indraw_cal, "캘린더"));
        drawItems.add(new DrawItem(R.drawable.indraw_album, "앨범"));
        drawItems.add(new DrawItem(R.drawable.indraw_set, "설정"));
        drawItems.add(new DrawItem(R.drawable.indraw_sign, "서명"));
        drawAdapter = new DrawAdapter(getActivity(), R.layout.draw_list_item, drawItems);
        view.setAdapter(drawAdapter);
    }
}
