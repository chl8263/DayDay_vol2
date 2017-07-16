package com.example.user.dayday_vol2.Recycle_LIst;


import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.dayday_vol2.R;
import com.example.user.dayday_vol2.Sqlite.DBManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by User on 2017-07-07.
 */

public class ListFragment extends Fragment {
    private DBManager manager;
    private String yearr, month, month2;
    private RecyclerView recyclerView;
    private ArrayList<Re_List_item> items;
    private Re_List_Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTextView();

        items = new ArrayList<Re_List_item>();
        manager = new DBManager(getActivity().getApplicationContext(), "WRITE", null, 1);
        SQLiteDatabase db = manager.getReadableDatabase();
        if(manager.getTable(yearr + month)) {
            Cursor cursor = db.rawQuery("select * from '" + yearr + month + "'", null);

            while (cursor.moveToNext()) {
                items.add(new Re_List_item(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), R.drawable.aaa));
            }
        }
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

    private void setTextView() {
        SimpleDateFormat sdfNow = new SimpleDateFormat("MM", Locale.KOREA);
        month = sdfNow.format(new Date(System.currentTimeMillis()));


        SimpleDateFormat sdfNow3 = new SimpleDateFormat("yyyy", Locale.KOREA);
        yearr = sdfNow3.format(new Date(System.currentTimeMillis()));
    }
}
