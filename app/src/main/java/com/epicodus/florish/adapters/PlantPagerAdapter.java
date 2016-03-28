package com.epicodus.florish.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.florish.models.Plant;
import com.epicodus.florish.ui.PlantDetailFragment;

import java.util.ArrayList;

/**
 * Created by Kassidy on 3/27/2016.
 */
public class PlantPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Plant> mPlants = new ArrayList<>();

    public PlantPagerAdapter(FragmentManager fm, ArrayList<Plant> plants) {
        super(fm);
        mPlants = plants;
    }

    @Override
    public Fragment getItem(int position) {
        return PlantDetailFragment.newInstance(mPlants.get(position));
    }

    @Override
    public int getCount() {
        return mPlants.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPlants.get(position).getName();
    }
}
