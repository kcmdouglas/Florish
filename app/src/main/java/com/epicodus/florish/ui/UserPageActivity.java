package com.epicodus.florish.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.models.CurrentWeather;
import com.epicodus.florish.service.OpenWeatherMapService;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserPageActivity extends AppCompatActivity{
    private CurrentWeather mCurrentWeather;
    @Bind(R.id.user_starter_list_text_view) TextView mStarterTextView;
    @Bind(R.id.current_weather_image) ImageView mCurrentWeatherImageView;
    @Bind(R.id.current_weather_text_view) TextView mCurrentWeatherTextView;
    @Bind(R.id.current_temperature_text_view) TextView mCurrentTemperatureTextView;
    @Bind(R.id.share_button) Button mShareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCurrentWeather(location);





        //mShareButton.setOnClickListener();
    }

   // private OnClick



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
                        Picasso.with(UserPageActivity.this)
                                .load(mCurrentWeather.getImageUrl())
                                .into(mCurrentWeatherImageView);
                        mCurrentWeatherTextView.setText(mCurrentWeather.getLongDescription());
                        mCurrentTemperatureTextView.setText(mCurrentWeather.getCurrentTemp() + "°");
                    }
                });
            }
        });
    }
}
