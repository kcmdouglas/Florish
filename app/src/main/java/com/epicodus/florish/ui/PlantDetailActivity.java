package com.epicodus.florish.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.florish.R;
import com.epicodus.florish.adapters.PlantPagerAdapter;
import com.epicodus.florish.models.Plant;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlantDetailActivity extends AppCompatActivity {
        @Bind(R.id.viewPager) ViewPager mViewPager;
        private PlantPagerAdapter adapterViewPager;
        ArrayList<Plant> mPlants = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plant_detail);
            ButterKnife.bind(this);
            mPlants = Parcels.unwrap(getIntent().getParcelableExtra("plants"));
            int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
            adapterViewPager = new PlantPagerAdapter(getSupportFragmentManager(), mPlants);
            mViewPager.setAdapter(adapterViewPager);
            mViewPager.setCurrentItem(startingPosition);
        }
    }