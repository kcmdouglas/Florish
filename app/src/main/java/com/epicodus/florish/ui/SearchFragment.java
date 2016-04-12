package com.epicodus.florish.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.adapters.PlantListAdapter;
import com.epicodus.florish.models.Plant;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    @Bind(R.id.seasonalLocation)
    TextView mSeasonalLocation;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    public ArrayList<Plant> starterPlants = new ArrayList<>();

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Plant kohlrabi = new Plant("Kohlrabi", "Vegetable", "Start Seeds in March, Plant April through mid-May",
                "Kohlrabi is a vegetable similar to a turnip. Raw kohlrabi has a mild flavor, often compared to apples. The whole plant can be steamed, stir-fired, or boiled and mashed.", "https://pixabay.com/static/uploads/photo/2013/01/08/01/20/kohlrabi-74276_960_720.jpg");

        Plant broccoli = new Plant("Broccoli", "Vegetable", "Start Seeds in February, Plant early March through mid-July",
                "Broccoli is a vegetable known for its hearty stem and multiple florets. It can be prepared in a variety of ways, including being steamed, roasted, or stir-fried.", "https://pixabay.com/static/uploads/photo/2014/10/19/21/50/broccoli-494754_960_720.jpg");

        Plant rosemary = new Plant("Rosemary", "Herb", "Start seeds indoors late March, Plant April through June","Rosemary is a perennial evergreen shrub with blue flowers. It is a pungent and distinctive plant with a sweet, resinous flavor. It is used for poultry, lamb, stews, and soups.", "https://pixabay.com/static/uploads/photo/2015/11/18/17/07/rosemary-1049531_960_720.jpg");

        starterPlants.add(kohlrabi);
        starterPlants.add(broccoli);
        starterPlants.add(rosemary);



        mAdapter = new PlantListAdapter(getContext(), starterPlants);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        return view;
    }

}
