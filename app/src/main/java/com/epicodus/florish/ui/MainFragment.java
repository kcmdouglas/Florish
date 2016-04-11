package com.epicodus.florish.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.florish.FlorishApplication;
import com.epicodus.florish.R;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainFragment extends Fragment {

    @Bind(R.id.userGreetingTextView)
    TextView mUserGreetingTextView;
    private Firebase mFirebaseRef;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    private String mUserId;
    private String mUsername;
    private String mLocation;


    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//
//        Bundle bundle = getArguments();
//        mUserId = bundle.getString("userId");
//        mUsername = bundle.getString("username");
//        mLocation = bundle.getString("location");
//        mUserGreetingTextView.setText("Hello, " + mUsername);
        mFirebaseRef = FlorishApplication.getAppInstance().getFirebaseRef();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
