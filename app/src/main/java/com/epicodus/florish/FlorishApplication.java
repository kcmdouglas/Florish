package com.epicodus.florish;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Kassidy on 4/3/2016.
 */
public class FlorishApplication extends Application {
    private static FlorishApplication app;
    private Firebase mFirebaseRef;

    public static FlorishApplication getAppInstance() {
        return app;
    }

    public Firebase getFirebaseRef() {
        return mFirebaseRef;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase(this.getString(R.string.firebase_url));
    }
}
