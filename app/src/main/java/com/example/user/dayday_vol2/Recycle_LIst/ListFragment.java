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

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Re_List_item> items;
    private Re_List_Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<Re_List_item>();
        items.add(new Re_List_item("a", "a","a","a","a",R.drawable.aaa));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.list_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.scrollToPosition(0);
        adapter = new Re_List_Adapter(view.getContext(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
