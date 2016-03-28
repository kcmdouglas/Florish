package com.epicodus.florish.models;

import org.parceler.Parcel;

/**
 * Created by Kassidy on 3/27/2016.
 */
@Parcel
public class Plant {
    public String mName;
    public String mCategory;
    public String mPlantingSpan;
    public String mDescription;
    public String mImageUrl;

    public Plant() {

    }

    public Plant(String name, String category, String plantingSpan, String description, String imageUrl) {
        mName = name;
        mCategory = category;
        mPlantingSpan = plantingSpan;
        mDescription = description;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getPlantingSpan() {
        return mPlantingSpan;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() { return mImageUrl; }
}
