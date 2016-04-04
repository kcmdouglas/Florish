package com.epicodus.florish.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.models.Plant;
import com.epicodus.florish.ui.PlantDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Kassidy on 3/27/2016.
 */

public class PlantListAdapter extends RecyclerView.Adapter<PlantViewHolder> {
    private ArrayList<Plant> mPlants = new ArrayList<>();
    private Context mContext;

    public PlantListAdapter(Context context, ArrayList<Plant> plants) {
        mContext = context;
        mPlants = plants;
    }

    @Override
    public PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_list_item, parent, false);
        PlantViewHolder viewHolder = new PlantViewHolder(view, mPlants);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlantViewHolder holder, int position) {
        holder.bindPlant(mPlants.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlants.size();
    }

}

