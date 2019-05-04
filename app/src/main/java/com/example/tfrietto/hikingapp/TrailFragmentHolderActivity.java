package com.example.tfrietto.hikingapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TrailFragmentHolderActivity extends AppCompatActivity {

    private static final String EXTRA_NAME="com.example.android.mountainman.name";
    private static final String EXTRA_DIFF="com.example.android.mountainman.diff";
    private static final String EXTRA_STAR="com.example.android.mountainman.star";
    private static final String EXTRA_LOCATION="com.example.android.mountainman.location";
    private static final String EXTRA_SUM="com.example.android.mountainman.summary";
    private static final String EXTRA_LENGTH="com.example.android.mountainman.length";
    private static final String EXTRA_MINALT="com.example.android.mountainman.minAlt";
    private static final String EXTRA_MAXALT="com.example.android.mountainman.maxAlt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_fragment_holder);

        TextView TrailName=(TextView)findViewById(R.id.title);
        String name=getIntent().getStringExtra(EXTRA_NAME);
        TrailName.setText(name);

        String diff=getIntent().getStringExtra(EXTRA_DIFF);
        double stars=getIntent().getDoubleExtra(EXTRA_STAR,0);
        String location=getIntent().getStringExtra(EXTRA_LOCATION);
        String summary=getIntent().getStringExtra(EXTRA_SUM);
        double length=getIntent().getDoubleExtra(EXTRA_LENGTH,0);
        int minAlt=getIntent().getIntExtra(EXTRA_MINALT,0);
        int maxAlt=getIntent().getIntExtra(EXTRA_MAXALT,0);
        GeneralInfoFrag.newInstance(diff,stars,location,summary,length,minAlt,maxAlt);

        ViewPager viewPager = findViewById(R.id.viewPager);
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    public static Intent newIntent(Context packageContext,String name,String diff,double star,String location,String summary,double length,int minAlt,int maxAlt){
        Intent i=new Intent(packageContext,TrailFragmentHolderActivity.class);
        i.putExtra(EXTRA_NAME,name);
        i.putExtra(EXTRA_DIFF,diff);
        i.putExtra(EXTRA_STAR,star);
        i.putExtra(EXTRA_LOCATION,location);
        i.putExtra(EXTRA_SUM,summary);
        i.putExtra(EXTRA_LENGTH,length);
        i.putExtra(EXTRA_MINALT,minAlt);
        i.putExtra(EXTRA_MAXALT,maxAlt);
        return i;
    }
}
