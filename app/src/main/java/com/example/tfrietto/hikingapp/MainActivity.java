package com.example.tfrietto.hikingapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView welcome=(TextView)findViewById(R.id.welcomeM);
        Typeface type = Typeface.createFromAsset(getAssets(),"swirl.ttf");
        welcome.setTypeface(type);
        Button places=(Button)findViewById(R.id.Trails);
        Button guides=(Button)findViewById(R.id.Guides);
        Button articles=(Button)findViewById(R.id.Articles);
        places.getBackground().setAlpha(64);
        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(v.getId()==R.id.Trails){
                    Intent i=TrailsActivity.newItent(MainActivity.this);
                    startActivity(i);
                }
                if(v.getId()==R.id.Guides){
                    Intent i=ProfileActivity.newIntent(MainActivity.this);
                    startActivity(i);
                }
                if(v.getId()==R.id.Articles){
                    Intent i=SettingsActivity.newIntent(MainActivity.this);
                    startActivity(i);
                }
            }
        };
        places.setOnClickListener(listener);
        guides.setOnClickListener(listener);
        articles.setOnClickListener(listener);
    }
}
