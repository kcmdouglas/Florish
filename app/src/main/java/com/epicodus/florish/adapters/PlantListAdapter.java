package com.epicodus.florish.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.models.Plant;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Kassidy on 3/27/2016.
 */

public class PlantListAdapter extends RecyclerView.Adapter<PlantListAdapter.PlantViewHolder> {
    private ArrayList<Plant> mPlants = new ArrayList<>();
    private Context mContext;

    public PlantListAdapter(Context context, ArrayList<Plant> plants) {
        mContext = context;
        mPlants = plants;
    }

    @Override
    public PlantListAdapter.PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_list_item, parent, false);
        PlantViewHolder viewHolder = new PlantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlantListAdapter.PlantViewHolder holder, int position) {
        holder.bindPlant(mPlants.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlants.size();
    }

    public class PlantViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.plantNameTextView) TextView mNameTextView;
        @Bind(R.id.categoryTextView) TextView mCategoryTextView;
        private Context mContext;


        public PlantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindPlant(Plant plant) {
            mNameTextView.setText(plant.getName());
            mCategoryTextView.setText(plant.getCategory());
        }
    }
}

