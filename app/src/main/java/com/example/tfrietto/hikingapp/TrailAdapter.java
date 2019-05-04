package com.example.tfrietto.hikingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TrailAdapter extends RecyclerView.Adapter<TrailViewHolder>{

    private List<Trail> mTrails;

    public TrailAdapter(List<Trail> trails) {
        mTrails = trails;
    }

    public void setData(List<Trail> trails){
        mTrails=trails;
    }

    @Override
    public TrailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater
                .inflate(R.layout.trail_list_item, parent, false);
        return new TrailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrailViewHolder holder, int position) {
        Trail trail = mTrails.get(position);
        holder.bindTrail(trail);
    }

    @Override
    public int getItemCount() {
        return mTrails.size();
    }
}
