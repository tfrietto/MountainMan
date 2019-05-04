package com.example.tfrietto.hikingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

public class TrailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private LinearLayout mLayout;
    private TextView mTitleTextView;
    private TextView mLengthTextView;
    private TextView mStars;
    private TextView mLocationTextView;
    private TextView mDifficultyTextView;
    private Trail mTrail;
    private Context mContext;

    public TrailViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mContext=itemView.getContext();
        mLayout=(LinearLayout)itemView.findViewById(R.id.layout);
        mTitleTextView=(TextView)itemView.findViewById(R.id.title);
        mLengthTextView=(TextView)itemView.findViewById(R.id.length);
        mStars=(TextView)itemView.findViewById(R.id.stars);
        mLocationTextView=(TextView)itemView.findViewById(R.id.location);
        mDifficultyTextView=(TextView)itemView.findViewById(R.id.diff);
    }

    public void bindTrail(Trail trail) {
        mTrail = trail;
        String length="This trail is "+mTrail.getLength()+" miles long";
        String stars=mTrail.getStar()+" / 5.0 stars";
        String diff=mTrail.getDifficulty().toUpperCase();
        if(diff.equals("GREENBLUE")){

            mDifficultyTextView.setText("Easy");
        }
        else if(diff.equals("BLUEBLACK")){
            mDifficultyTextView.setText("Hard");
        }
        else if(diff.equals("BLUE")){
            mDifficultyTextView.setText("Medium");
        }
        else if(diff.equals("BLACK")){
            mDifficultyTextView.setText("Expert");
        }
        else if(diff.equals("GREEN")){
            mDifficultyTextView.setText("Beginner");
        }
        mTitleTextView.setText(mTrail.getName());
        mLengthTextView.setText(length);
        mStars.setText(stars);
        mLocationTextView.setText(mTrail.getPlace());
        mLayout.getBackground().setAlpha(80);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.layout){
            Intent i=TrailFragmentHolderActivity.newIntent(mContext,mTrail.getName(),mTrail.getDifficulty(),mTrail.getStar(),mTrail.getPlace(),mTrail.getSummary(),mTrail.getLength(),mTrail.getMinAlt(),mTrail.getMaxAlt());
            mContext.startActivity(i);
        }
    }
}
