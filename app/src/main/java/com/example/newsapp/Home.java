package com.example.newsapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    MybroadcastReciever cast = new MybroadcastReciever();
View view;
TextView y;
Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.TEAL);

        y=findViewById(R.id.x);
        registerForContextMenu(y);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_setting,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.invite){

            Toast.makeText(this,"Invite Others Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.about){

            Toast.makeText(this,"About The App Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.share){
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra("NEWS APP",true);
            startActivity(Intent.createChooser(intent,"SHARE THE APP TO OTHERS USING ........"));
            Toast.makeText(this,"Share App Clicked",Toast.LENGTH_SHORT).show();

            return true;


        }
        if(id==R.id.rate){

            Toast.makeText(this,"Rate The App Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.refresh){

            Toast.makeText(this,"Refresh Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.setting){

            Toast.makeText(this,"Settings Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.logoff){
            finish();
                    Intent intent=new Intent(Home.this,MainActivity.class);
                    startActivity(intent);

        }
        if(id==R.id.set1){

            Toast.makeText(this,"Security Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.set2){

            Toast.makeText(this,"Help Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.set3){

            Toast.makeText(this,"Notification Clicked",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.set4){

            Toast.makeText(this,"Others Clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

      menu.setHeaderTitle("News Letter");
        menu.add("News HeadLines");
        menu.add("Local Bulletin");
        menu.add("International Bulletin");
        menu.add("Sports News");
        menu.add("Entertainment World");
        menu.add("Announcements");
        menu.add("Others");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "News HeadLines") {
            Intent intent1 = new Intent(this, News.class);
            startActivity(intent1);
        }

            else if(item.getTitle()=="Local Bulletin"){
                Intent intent2 = new Intent(this,News2_1.class);
                startActivity(intent2);
            }
        else if(item.getTitle()=="International Bulletin"){
            Intent intent3 = new Intent(this,News3_1.class);
            startActivity(intent3);
        }

        else if(item.getTitle()=="Sports News"){
            Intent intent4 = new Intent(this,News4_1.class);
            startActivity(intent4);
        }

        else if(item.getTitle()=="Entertainment World"){
            Intent intent5= new Intent(this,News5_1.class);
            startActivity(intent5);
        }

        else if(item.getTitle()=="Announcements"){
            Intent intent6= new Intent(this,News6_1.class);
            startActivity(intent6);
        }

            else{
            Intent intent7= new Intent(this,News7_1.class);
            startActivity(intent7);

        }



        return super.onContextItemSelected(item);
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
