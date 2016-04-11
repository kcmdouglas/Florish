package com.epicodus.florish.models;

import android.os.Parcelable;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Kassidy on 3/27/2016.
 */
@Parcel
public class User {
    String name;
    ArrayList<Plant> plantsToStart;
    ArrayList<Plant> plantsInGarden;
    String location;
    String userId;

    public User() {

    }

    public User(String name, String location, String userId) {
        this.name = name;
        this.location= location;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Plant> getPlantsToStart() {
        return plantsToStart;
    }

    public void setPlantsToStart(ArrayList<Plant> plantsToStart) {
        this.plantsToStart = plantsToStart;
    }

    public ArrayList<Plant> getPlantsInGarden() {
        return plantsInGarden;
    }

    public void setPlantsInGarden(ArrayList<Plant> plantsInGarden) {
        this.plantsInGarden = plantsInGarden;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
