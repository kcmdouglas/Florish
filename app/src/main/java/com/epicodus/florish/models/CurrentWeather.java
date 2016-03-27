package com.epicodus.florish.models;

import android.content.Context;

import java.util.Date;

/**
 * Created by Kassidy on 3/25/2016.
 */
public class CurrentWeather {
    private Integer mWeatherId;
    private String mMainDescription;
    private String mLongDescription;
    private Double mCurrentTemp;
    private Double mTemperatureMin;
    private Double mTemperatureMax;
    private Double mHumidity;
    private Integer mUnconvertedDate;
    private Date mConvertedDateFull;
    private String mImageUrl;
    private String mDateWithoutTime;
    private String mDateWithTime;


    public CurrentWeather(Integer weatherId, String mainDescription, String longDescription, Double currentTemp, Double temperatureMin, Double temperatureMax, Double humidity, Integer unconvertedDate, String imageUrl) {
        this.mWeatherId = weatherId;
        this.mMainDescription = mainDescription;
        this.mLongDescription = longDescription;
        this.mCurrentTemp = currentTemp;
        this.mTemperatureMin = temperatureMin;
        this.mTemperatureMax = temperatureMax;
        this.mHumidity = humidity;
        this.mUnconvertedDate = (unconvertedDate * 1000);
        this.mConvertedDateFull = new Date(mUnconvertedDate);
        this.mImageUrl = imageUrl;
    }

    public Integer getWeatherId() {
        return mWeatherId;
    }

    public String getMainDescription() {
        return mMainDescription;
    }

    public String getLongDescription() {
        return mLongDescription;
    }

    public Double getCurrentTemp() {
        return mCurrentTemp;
    }

    public Double getTemperatureMin() {
        return mTemperatureMin;
    }

    public Double getTemperatureMax() {
        return mTemperatureMax;
    }

    public Double getHumidity() {
        return mHumidity;
    }

    public Integer getUnconvertedDate() {
        return mUnconvertedDate;
    }
    public Date getConvertedDateFull() {
        return mConvertedDateFull;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

}


