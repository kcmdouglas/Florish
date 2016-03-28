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

    public Plant() {

    }

    public Plant(String name, String category, String plantingSpan, String description) {
        mName = name;
        mCategory = category;
        mPlantingSpan = plantingSpan;
        mDescription = description;
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
}
