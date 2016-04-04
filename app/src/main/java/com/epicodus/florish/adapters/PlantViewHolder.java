package com.epicodus.florish.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.florish.R;
import com.epicodus.florish.models.Plant;
import com.epicodus.florish.ui.PlantDetailActivity;
import com.firebase.client.Firebase;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Kassidy on 4/4/2016.
 */
public class PlantViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.plantNameTextView)
    TextView mNameTextView;
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    ArrayList<Plant> mPlants = new ArrayList<>();
    private Context mContext;
    private Firebase mFirebaseRef;

    public PlantViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, PlantDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("plants", Parcels.wrap(mPlants));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindPlant(Plant plant) {
        mNameTextView.setText(plant.getName());
        mCategoryTextView.setText(plant.getCategory());
    }
}