package com.epicodus.florish.service;

import android.content.Context;

import com.epicodus.florish.R;
import com.epicodus.florish.models.CurrentWeather;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public void findCurrentWeather(String zip, Callback callback) {
        String appid = mContext.getString(R.string.open_weather_map_API_key);

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/weather?&units=imperial&APPID=" + appid).newBuilder();
        urlBuilder.addQueryParameter("zip", zip);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public CurrentWeather processCurrentResults(Response response) {

        CurrentWeather currentWeather;
        currentWeather = null;
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject currentWeatherJSON = new JSONObject(jsonData);
                Integer weatherId = currentWeatherJSON.getJSONArray("weather").getJSONObject(0).getInt("id");
                String mainDescription = currentWeatherJSON.getJSONArray("weather").getJSONObject(0).getString("main");
                String longDescription = currentWeatherJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                Double currentTemp = currentWeatherJSON.getJSONObject("main").getDouble("temp");
                Double tempMin = currentWeatherJSON.getJSONObject("main").getDouble("temp_min");
                Double tempMax = currentWeatherJSON.getJSONObject("main").getDouble("temp_max");
                Double humidity = currentWeatherJSON.getJSONObject("main").getDouble("humidity");
                Integer unconvertedDate = currentWeatherJSON.getInt("dt");
                String iconId = currentWeatherJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
                String imageUrl = "http://openweathermap.org/img/w/" + iconId + ".png";

                currentWeather = new CurrentWeather(weatherId, mainDescription, longDescription, currentTemp, tempMin, tempMax, humidity, unconvertedDate, imageUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return currentWeather;
    }

}
