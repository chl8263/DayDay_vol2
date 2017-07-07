package com.example.user.dayday_vol2.Recycle_LIst;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dayday_vol2.R;

import java.util.ArrayList;

/**
 * Created by User on 2017-07-07.
 */

public class ListFragment extends Fragment{
    private RecyclerView recyclerView;
    private ArrayList<Re_List_item> items;
    private Re_List_Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        items=new ArrayList<Re_List_item>();
        recyclerView=(RecyclerView)getView().findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);

        items.add(new Re_List_item("a","a"));
        items.add(new Re_List_item("s","s"));
        items.add(new Re_List_item("d","d"));
        items.add(new Re_List_item("f","f"));

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        adapter = new Re_List_Adapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
    }
}
