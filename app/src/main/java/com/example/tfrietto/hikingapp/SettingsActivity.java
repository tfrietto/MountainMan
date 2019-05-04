package com.example.tfrietto.hikingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        LinearLayout layout=(LinearLayout)findViewById(R.id.settingsMain);
        layout.getBackground().setAlpha(180);
    }
    public static Intent newIntent(Context packageContext){
        Intent i=new Intent(packageContext,SettingsActivity.class);
        return i;
    }
}
