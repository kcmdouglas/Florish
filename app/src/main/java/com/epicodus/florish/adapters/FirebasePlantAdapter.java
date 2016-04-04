package com.epicodus.florish.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.florish.R;
import com.epicodus.florish.models.Plant;
import com.epicodus.florish.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Kassidy on 4/4/2016.
 */
public class FirebasePlantAdapter extends FirebaseRecyclerAdapter <PlantViewHolder, Plant> {


    public FirebasePlantAdapter(Query query, Class<Plant> itemClass) {
        super(query, itemClass);
    }

    @Override
    public PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plant_list_item, parent, false);
        return new PlantViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(PlantViewHolder holder, int position) {
        holder.bindPlant(getItem(position));
    }

    @Override
    protected void itemAdded(Plant item, String key, int position) {

    }

    @Override
    protected void itemChanged(Plant oldItem, Plant newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Plant item, String key, int position) {

    }

    @Override
    protected void itemMoved(Plant item, String key, int oldPosition, int newPosition) {

    }

}
