package com.example.newsapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList arrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.homefragment,container,false);
        listView=v.findViewById(R.id.homeview);
        arrayList=new ArrayList();
        arrayList.add("HOME");
        arrayList.add("YOUR SATSIFACTION OUR PRIDE");
        arrayList.add("YOU SHALL ACCESS!!!");
        arrayList.add("LOCAL BULLETIN");
        arrayList.add("INTERNATIONAL BULLETIN");
        arrayList.add("SPORTS BULLETIN");
        arrayList.add("ANNOUNCEMENTS");
        arrayList.add("ENTERTAINMENT");
        arrayList.add(" STAY TUNED!!");

        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        return v;
    }
}
