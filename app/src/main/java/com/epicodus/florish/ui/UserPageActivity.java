package com.epicodus.florish.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.florish.R;
import com.epicodus.florish.models.CurrentWeather;
import com.epicodus.florish.service.OpenWeatherMapService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserPageActivity extends AppCompatActivity implements View.OnClickListener{
    private CurrentWeather mCurrentWeather;
    @Bind(R.id.user_starter_list_text_view) TextView mStarterTextView;
    @Bind(R.id.current_weather_image_view) ImageView mCurrentWeatherIcon;
    @Bind(R.id.current_weather_text_view) TextView mCurrentWeatherTextView;
    @Bind(R.id.current_temperature_text_view) TextView mCurrentTemperatureTextView;
    @Bind(R.id.share_button) FloatingActionButton mShareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getCurrentWeather(location);

        mShareButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mShareButton) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Here's your current starter list: \n *Broccoli \n *Kohlrabi \n *Rosemary");
            sendIntent.setType("text/plain");
            PackageManager packageManager = getPackageManager();
            List activities = packageManager.queryIntentActivities(sendIntent,
                    PackageManager.MATCH_ALL);

            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(Intent.createChooser(sendIntent, "Select An App:"));
                Log.d("Intent response: ", "SEND");
            }
        }
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
                        Log.d("Weather image url:", mCurrentWeather.getImageUrl());
                        Picasso.with(UserPageActivity.this)
                                .load(mCurrentWeather.getImageUrl())
                                .fit()
                                .into(mCurrentWeatherIcon);
                        mCurrentWeatherTextView.setText(mCurrentWeather.getLongDescription());
                        mCurrentTemperatureTextView.setText(mCurrentWeather.getCurrentTemp() + "°");
                    }
                });
            }
        });
    }
}
