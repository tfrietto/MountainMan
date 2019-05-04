package com.example.tfrietto.hikingapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.content.Loader;
import android.support.v4.app.LoaderManager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TrailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Trail>>{

    private RecyclerView mRecyclerView;
    private TrailAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private View mProgressBar;
    private static final String REQUEST_URL="https://www.hikingproject.com/data/get-trails?lat=40.0274&lon=-105.2519&maxDistance=200&maxResults=500&key=200445932-8013f6ffcf9b030282e9a156a496fb53";
    private static final int TRAIL_LOADER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trails);
        int p=(int)(Math.random()*4);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int[]possibleImage={R.drawable.imageone,R.drawable.imagetwo,R.drawable.imagethree,R.drawable.imagefour};
        mRecyclerView.setBackgroundResource(possibleImage[p]);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new TrailAdapter(new ArrayList<Trail>());
        mRecyclerView.setAdapter(mAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        mProgressBar = findViewById(R.id.loading_spinner);

        ConnectivityManager manager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=manager.getActiveNetworkInfo();

        if(networkInfo!=null&&networkInfo.isConnected()){
            getSupportLoaderManager().initLoader(TRAIL_LOADER_ID, null, this);
        }
        else{
            mRecyclerView.setVisibility(View.GONE);
            mEmptyStateTextView.setText("No Internet available");
            mEmptyStateTextView.setVisibility(View.VISIBLE);
        }
    }
    public static Intent newItent(Context packageContext){
        Intent i=new Intent(packageContext,TrailsActivity.class);
        return i;
    }
    @Override
    public Loader<List<Trail>> onCreateLoader(int i, Bundle bundle) {
        return new TrailLoader(this, REQUEST_URL);
    }
    @Override
    public void onLoadFinished(Loader<List<Trail>> loader, List<Trail> trails) {
        mProgressBar.setVisibility(View.GONE);
        if(trails!=null&&!trails.isEmpty()){
            mEmptyStateTextView.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.setData(trails);
            mAdapter.notifyDataSetChanged();
        }
        else{
            mRecyclerView.setVisibility(View.GONE);
            mEmptyStateTextView.setText("No trails available");
            mEmptyStateTextView.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<Trail>> loader) {
        mAdapter.setData(new ArrayList<Trail>());
    }

}
