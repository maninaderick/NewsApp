package com.example.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_app);
    }
    void press(View V){
        RatingBar r =(RatingBar) findViewById(R.id.ratingBar);
        Toast.makeText(getApplicationContext(),String.valueOf(r.getRating()),Toast.LENGTH_LONG).show();

    }
}
