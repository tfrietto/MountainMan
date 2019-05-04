package com.example.tfrietto.hikingapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GeneralInfoFrag extends Fragment {

    private static final String EXTRA_DIFF="com.example.android.mountainman.diff";
    private static final String EXTRA_STAR="com.example.android.mountainman.star";
    private static final String EXTRA_LOCATION="com.example.android.mountainman.location";
    private static final String EXTRA_SUM="com.example.android.mountainman.summary";
    private static final String EXTRA_LENGTH="com.example.android.mountainman.length";
    private static final String EXTRA_MINALT="com.example.android.mountainman.minAlt";
    private static final String EXTRA_MAXALT="com.example.android.mountainman.maxAlt";
    private static Bundle bundle2=new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_general_info, container, false);
        TextView summaryTextView=(TextView)rootView.findViewById(R.id.sum);
        TextView diffTextView=(TextView)rootView.findViewById(R.id.diff);
        TextView starTextView=(TextView)rootView.findViewById(R.id.stars);
        TextView locationTextView=(TextView)rootView.findViewById(R.id.location);
        TextView lengthTextView=(TextView)rootView.findViewById(R.id.length);
        TextView minAltTextView=(TextView)rootView.findViewById(R.id.minAlt);
        TextView maxAltTextView=(TextView)rootView.findViewById(R.id.maxAlt);

        String summary = bundle2.getString(EXTRA_SUM);
        double star = bundle2.getDouble(EXTRA_STAR);
        double diff = bundle2.getDouble(EXTRA_DIFF);
        double location = bundle2.getDouble(EXTRA_LOCATION);
        double length = bundle2.getDouble(EXTRA_LENGTH);
        double minAlt = bundle2.getDouble(EXTRA_MINALT);
        double maxAlt = bundle2.getDouble(EXTRA_MAXALT);


        summaryTextView.setText("Summary: "+summary);
        diffTextView.setText(""+diff);
        starTextView.setText("This trail is rated "+star+"/5.0 stars");
        locationTextView.setText("located at: "+location);
        lengthTextView.setText(length+" miles long");
        minAltTextView.setText("Starts at "+minAlt+" ft");
        maxAltTextView.setText("ends  at "+maxAlt+" ft");
        return rootView;
    }
    public static GeneralInfoFrag newInstance(String diff,double star,String location,String summary,double length,int minAlt,int maxAlt) {
        GeneralInfoFrag generalInfoFrag = new GeneralInfoFrag();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_DIFF,diff);
        bundle.putDouble(EXTRA_STAR,star);
        bundle.putString(EXTRA_LOCATION,location);
        bundle.putString(EXTRA_SUM,summary);
        bundle.putDouble(EXTRA_LENGTH,length);
        bundle.putInt(EXTRA_MINALT,minAlt);
        bundle.putInt(EXTRA_MAXALT,maxAlt);
        bundle2=bundle;
        return generalInfoFrag;
    }
}
