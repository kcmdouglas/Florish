package com.epicodus.florish.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.florish.FlorishApplication;
import com.epicodus.florish.R;
import com.epicodus.florish.models.Plant;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlantDetailFragment extends Fragment {
    @Bind(R.id.plantImageView) ImageView mImageLabel;
    @Bind(R.id.plantNameTextView) TextView mNameLabel;
    @Bind(R.id.plantCategoryTextView) TextView mCategoriesLabel;
    @Bind(R.id.plantPlantingSpanTextView) TextView mPlantingLabel;
    @Bind(R.id.descriptionTextView) TextView mDescription;
    @Bind(R.id.savePlantButton) Button mSavePlantButton;
    private Firebase mFirebaseRef;

    private Plant mPlant;

    public static PlantDetailFragment newInstance(Plant plant) {
        PlantDetailFragment plantDetailFragment = new PlantDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("plant", Parcels.wrap(plant));
        plantDetailFragment.setArguments(args);
        return plantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlant = Parcels.unwrap(getArguments().getParcelable("plant"));

        mFirebaseRef = FlorishApplication.getAppInstance().getFirebaseRef();
//
//        mSavePlantButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mPlant.getImageUrl()).fit().centerCrop().into(mImageLabel);
        mNameLabel.setText(mPlant.getName());
        mCategoriesLabel.setText(mPlant.getCategory());
        mPlantingLabel.setText(mPlant.getPlantingSpan());
        mDescription.setText(mPlant.getDescription());
        return view;
    }
}