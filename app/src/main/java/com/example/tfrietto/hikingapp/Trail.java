package com.example.tfrietto.hikingapp;

public class Trail {
    private String mName;
    private String mDifficulty;
    private double mStar;
    private String mPlace;
    private String mSummary;
    private double mlength;
    private int mMinAlt;
    private int mMaxAlt;
    public Trail(String name,String diff,double star,String place,String summary,double length,int minAlt,int maxAlt){
        mName=name;
        mDifficulty=diff;
        mStar=star;
        mPlace=place;
        mSummary=summary;
        mlength=length;
        mMinAlt=minAlt;
        mMaxAlt=maxAlt;
    }
    public String getName(){
        return mName;
    }
    public String getDifficulty(){
        return mDifficulty;
    }
    public double getStar(){
        return mStar;
    }
    public String getPlace(){
        return mPlace;
    }
    public String getSummary(){
        return mSummary;
    }
    public double getLength(){
        return mlength;
    }
    public int getMinAlt(){
        return mMinAlt;
    }
    public int getMaxAlt(){
        return mMaxAlt;
    }
}
