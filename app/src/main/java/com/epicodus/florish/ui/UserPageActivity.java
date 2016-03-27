package com.epicodus.florish.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.florish.R;
import com.epicodus.florish.models.CurrentWeather;
import com.epicodus.florish.service.OpenWeatherMapService;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserPageActivity extends AppCompatActivity {
    private CurrentWeather mCurrentWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCurrentWeather(location);
    }



    private void getCurrentWeather(String location) {
        final OpenWeatherMapService currentWeatherService = new OpenWeatherMapService(this);

        currentWeatherService.findCurrentWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mCurrentWeather = currentWeatherService.processCurrentResults(response);

                UserPageActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Picasso.with(UserPageActivity.this)
//                                .load(mCurrentWeather.getImageUrl())
//                                .into(mCurrentWeatherImageView);
//                        mCurrentDescription.setText(mCurrentWeather.getLongDescription());
//                        mCurrentTemp.setText(mCurrentWeather.getCurrentTemp() + "°");
                    }
                });
            }
        });
    }
}
