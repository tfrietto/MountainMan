package com.example.tfrietto.hikingapp;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class TrailLoader extends AsyncTaskLoader<List<Trail>> {

    private String mUrl;

    public TrailLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Trail> loadInBackground() {
        if(mUrl == null) {
            return null;
        }
        List<Trail> trails = QueryUtils.fetchTrailData(mUrl);
        return trails;
    }

}

