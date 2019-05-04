package com.example.tfrietto.hikingapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    private static final String LOG_TAG=TrailsActivity.class.getSimpleName();

    private QueryUtils() {
    }

    public static ArrayList<Trail> extractTrails(String jsonResponse) {
        ArrayList<Trail> trails = new ArrayList<>();
        try {
            JSONObject baseJSONResponse = new JSONObject(jsonResponse);
            JSONArray trailArray = baseJSONResponse.getJSONArray("trails");
            for (int i = 0; i < trailArray.length(); i++) {
                JSONObject currentTrail = trailArray.getJSONObject(i);
                String name = currentTrail.getString("name");
                double star = currentTrail.getDouble("stars");
                String location = currentTrail.getString("location");
                String summary =currentTrail.getString("summary") ;
                double length = currentTrail.getDouble("length");
                int minAlt = currentTrail.getInt("low");
                int maxAlt=currentTrail.getInt("high");
                String difficulty=currentTrail.getString("difficulty");
                Trail newTrail = new Trail(name,difficulty, star, location, summary, length, minAlt, maxAlt);
                trails.add(newTrail);

            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the TRAIL JSON results", e);
        }
        return trails;
    }

    private static URL createUrl(String stringUrl) {
        URL url;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
            return null;
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(15000);
            urlConnection.setReadTimeout(10000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the trail JSON results.", e);
        }finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader =
                    new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<Trail> fetchTrailData(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request", e);
        }

        List<Trail> trails = extractTrails(jsonResponse);
        return trails;
    }


}
