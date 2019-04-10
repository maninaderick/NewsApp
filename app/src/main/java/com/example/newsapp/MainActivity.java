package com.example.newsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
// My Name is MANINA DERICK
// MY Registration Number is 2017/BIT/169
// In my second year second semster pursuing A Bchelors degree of information and technology
// Mobile Application Development Second Assignment.
public class MainActivity extends AppCompatActivity {
    // dynamic receivers implementation
    MybroadcastReciever cast = new MybroadcastReciever();
    View view;
  Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.TEAL);
          btnlogin=(Button) findViewById(R.id.login);

          btnlogin.setOnClickListener(new View.OnClickListener(){

              public void onClick(View view){
                  Intent intent=new Intent(MainActivity.this,Home.class);
                  startActivity(intent);


              }


          });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setMessage("Are you sure you want to close");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//finish();
            }
        });
AlertDialog dialog=builder.create();
dialog.show();



    }

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
