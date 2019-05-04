package com.example.tfrietto.hikingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if(position==0){
            return new GeneralInfoFrag();
        }
        else if(position==1){
            return new OnMapFragment();
        }
        else{
            return new PostPicturesFragment();
        }
    }

    public int getCount() {
        return 3;
    }
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "Info";
        }
        else if(position == 1) {
            return "Map";
        }
        else {
            return "Community";
        }
    }

}

