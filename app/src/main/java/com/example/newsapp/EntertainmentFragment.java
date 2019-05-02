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

public class EntertainmentFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList arrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.entertainmentfragment,container,false);
        listView=v.findViewById(R.id.entview);
        arrayList=new ArrayList();
        arrayList.add("MUSIC");
        arrayList.add("MUSIC");
        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        return v;
    }
}
