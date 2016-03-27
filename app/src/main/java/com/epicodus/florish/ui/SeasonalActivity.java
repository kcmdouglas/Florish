package com.epicodus.florish.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.models.CurrentWeather;
import com.epicodus.florish.service.OpenWeatherMapService;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SeasonalActivity extends AppCompatActivity {
    @Bind(R.id.seasonalLocation) TextView mSeasonalLocation;
    @Bind(R.id.starterListView) ListView mStarterListView;
    @Bind(R.id.plantDirectlyListView) ListView mPlantDirectlyListView;
    private CurrentWeather mCurrentWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mSeasonalLocation.setText("Here's what's in season near: " + location);

        getCurrentWeather(location);


        Resources res = getResources();
        String[] starterPlants = res.getStringArray(R.array.plants_to_start);
        String[] plantingPlants = res.getStringArray(R.array.plants_to_grow);

        ArrayAdapter starterAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, starterPlants);
        mStarterListView.setAdapter(starterAdapter);

        ArrayAdapter plantingAdapater = new ArrayAdapter(this, android.R.layout.simple_list_item_1, plantingPlants);
        mPlantDirectlyListView.setAdapter(plantingAdapater);

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

                SeasonalActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(SeasonalActivity.this)
                                .load(mCurrentWeather.getImageUrl())
                                .into(mCurrentWeatherImageView);
                        mCurrentDescription.setText(mCurrentWeather.getLongDescription());
                        mCurrentTemp.setText(mCurrentWeather.getCurrentTemp() + "°");
                    }
                });
            }
        });
    }
}
