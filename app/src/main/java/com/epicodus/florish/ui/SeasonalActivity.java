package com.epicodus.florish.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.adapters.PlantListAdapter;
import com.epicodus.florish.models.CurrentWeather;
import com.epicodus.florish.models.Plant;
import com.epicodus.florish.service.OpenWeatherMapService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SeasonalActivity extends AppCompatActivity {
    @Bind(R.id.seasonalLocation) TextView mSeasonalLocation;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public ArrayList<Plant> starterPlants = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal);
        ButterKnife.bind(this);

        Plant Kohlrabi = new Plant("Kohlrabi", "Vegetable", "Start Seeds in March, Plant April through mid-May",
        "Kohlrabi is a vegetable similar to a turnip. Raw kohlrabi has a mild flavor, often compared to apples. The whole plant can be steamed, stir-fired, or boiled and mashed.", "https://pixabay.com/static/uploads/photo/2013/01/08/01/20/kohlrabi-74276_960_720.jpg");

        Plant Broccoli = new Plant("Broccoli", "Vegetable", "Start Seeds in February, Plant early March through mid-July",
                "Broccoli is a vegetable known for its hearty stem and multiple florets. It can be prepared in a variety of ways, including being steamed, roasted, or stir-fried.", "https://pixabay.com/static/uploads/photo/2014/10/19/21/50/broccoli-494754_960_720.jpg");

        Plant Rosemary = new Plant("Rosemary", "Herb", "Start seeds indoors late March, Plant April through June","Rosemary is a perennial evergreen shrub with blue flowers. It is a pungent and distinctive plant with a sweet, resinous flavor. It is used for poultry, lamb, stews, and soups.", "https://pixabay.com/static/uploads/photo/2015/11/18/17/07/rosemary-1049531_960_720.jpg");

        starterPlants.add(Kohlrabi);
        starterPlants.add(Broccoli);
        starterPlants.add(Rosemary);


        mAdapter = new PlantListAdapter(getApplicationContext(), starterPlants);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(SeasonalActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

    }


}
