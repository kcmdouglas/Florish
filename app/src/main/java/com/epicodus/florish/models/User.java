package com.epicodus.florish.models;

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
    String[] pollinators;
    String userId;

    public User() {

    }

    public User(String name, String userId) {
        this.name = name;
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

    public String[] getPollinators() {
        return pollinators;
    }

    public void setPollinators(String[] pollinators) {
        this.pollinators = pollinators;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
