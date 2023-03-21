package com.example.concurrentapplicationtest;

import android.graphics.Bitmap;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.util.MalformedJsonException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Utils {

    public static final String UTILS_TAG = "TAG";

    private static InputStream getInputStream (URL url) throws IOException{

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        InputStream inputStream = null;

        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
        }catch(IOException e) {
            e.printStackTrace();
            Log.i(UTILS_TAG,"getInputStream: No Stream");
            throw e;
        }

        return inputStream;

    }

    private static Bitmap convertStreamToBitmap (InputStream inputStream){

        return BitmapFactory.decodeStream(inputStream);

    }

    static Bitmap getBitmap(URL url) throws IOException{

        return convertStreamToBitmap(getInputStream(url));
    }



}
