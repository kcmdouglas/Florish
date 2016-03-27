package com.epicodus.florish.service;

import android.content.Context;

import com.epicodus.florish.R;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Kassidy on 3/25/2016.
 */
public class OpenWeatherMapService {
    private Context mContext;


    public OpenWeatherMapService(Context context) {
        this.mContext = context;
    }


    public void findForecast(String city, Callback callback) {
        String appid = mContext.getString(R.string.open_weather_map_API_key);

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/forecast?&units=imperial&APPID=" + appid).newBuilder();
        urlBuilder.addQueryParameter("q", city);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void findCurrentWeather(String city, Callback callback) {
        String appid = mContext.getString(R.string.open_weather_map_API_key);

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/weather?&units=imperial&APPID=" + appid).newBuilder();
        urlBuilder.addQueryParameter("q", city);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


}
