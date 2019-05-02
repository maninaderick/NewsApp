package com.example.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class About extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        listView=(ListView)findViewById(R.id.about);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ABOUT THE APP");
        arrayList.add("THE APP IS A SIMPLE COLLECTION OF NEWS SURROUNDING US");
        arrayList.add("THE APP HAS NEWS CATEGORISED AS:");
        arrayList.add("LOCAL BULLETIN");
        arrayList.add("INTERNATIONAL BULLETIN");
        arrayList.add("SPORTS NEWS");
        arrayList.add("ENTERTAINMENT NEWS");
        arrayList.add("ANNOUNCEMENTS");
        arrayList.add("AMONG OTHERS");
        arrayList.add("PLEASE RATE APP ");
        arrayList.add("YOUR FEEDBACK IS VERY VITAL");
        arrayList.add("YOU ARE WELCOME!!!");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
