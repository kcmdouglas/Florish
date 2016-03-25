package com.epicodus.florish.models;

import android.content.Context;

import com.epicodus.florish.R;

/**
 * Created by Kassidy on 3/25/2016.
 */
public class CurrentWeather {
    private Context mContext;


    public CurrentWeatherService(Context context) {
        this.mContext = context;
    }


    public void findForecast(String city, Callback callback) {
        String appid = mContext.getString(R.string.weather_API_key);

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
        String appid = mContext.getString(R.string.weather_API_key);

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
