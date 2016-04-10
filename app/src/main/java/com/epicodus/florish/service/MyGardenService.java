package com.epicodus.florish.service;

import android.content.Context;

import com.epicodus.florish.R;

import java.net.URLClassLoader;
import java.security.Provider;

import javax.security.auth.callback.Callback;

import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthProvider;

/**
 * Created by Kassidy on 4/9/2016.
 */
public class MyGardenService {
    private Context mContext;
    private String CONSUMER_KEY = mContext.getString(R.string.consumer_key);
    private String CONSUMER_SECRET = mContext.getString(R.string.consumer_secret);
    private String baseUrl = "http://api.mygarden.org";
    private String requestTokenUrl =  baseUrl+"oauth/request_token";
    private String accessTokenUrl = baseUrl + "oauth/access_token";
    private String authorizeUrl = baseUrl + "/oauth/authorize";
    private OkHttpOAuthProvider mProvider;

    private void createProvider() {
        mProvider = new OkHttpOAuthProvider(requestTokenUrl, accessTokenUrl, authorizeUrl);
    }


    public MyGardenService(Context context) {
        this.mContext = context;
    }

    public void findPlants(String name, Callback callback) {

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    }
}
