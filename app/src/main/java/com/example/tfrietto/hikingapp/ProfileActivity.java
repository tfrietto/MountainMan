package com.example.tfrietto.hikingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public static Intent newIntent(Context packageContext){
        Intent i=new Intent(packageContext,ProfileActivity.class);
        return i;
    }
}
