package com.example.newsapp;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class News2_1 extends AppCompatActivity {
    MybroadcastReciever cast = new MybroadcastReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news2_1);
    }
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(cast,filter);
    }

    @Override
    // triggered when the app goes into the background
    protected void onStop() {
        super.onStop();
        unregisterReceiver(cast);
    }
}
