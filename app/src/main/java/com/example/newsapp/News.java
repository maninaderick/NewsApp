package com.example.newsapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class News extends AppCompatActivity {
    MybroadcastReciever cast = new MybroadcastReciever();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFrag = null;
            switch (menuItem.getItemId()){
                case R.id.hm:
                    selectedFrag = new HomeFragment();
                    break;
                case R.id.sport:
                    selectedFrag = new SportsFragment();
                    break;
                case R.id.ent:
                    selectedFrag = new EntertainmentFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFrag).commit();
            return true;
        }
    };
    @Override
    // triggered when the app goes into the foreground
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
