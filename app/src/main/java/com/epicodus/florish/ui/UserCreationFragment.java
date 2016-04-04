package com.epicodus.florish.ui;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.florish.FlorishApplication;
import com.epicodus.florish.R;
import com.epicodus.florish.models.User;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserCreationFragment extends DialogFragment implements View.OnClickListener {
    private Firebase mFirebaseRef;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mName;
    private String mUserId;
    private String mLocation;
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.usernameEditText) EditText mUsernameEditText;
    @Bind(R.id.zipcodeEditText) EditText mZipcodeEditText;


    public UserCreationFragment() {
        // Required empty public constructor
    }

    public static UserCreationFragment newInstance() {
        return new UserCreationFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_creation, container, false);
        ButterKnife.bind(this, view);

        mFirebaseRef = FlorishApplication.getAppInstance().getFirebaseRef();

        mUserId = mFirebaseRef.getAuth().getUid();

        mSharedPreferences = this.getContext().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mSubmitButton.setOnClickListener(this);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitButton) {
            String name = mUsernameEditText.getText().toString();
            String location = mZipcodeEditText.getText().toString();
            addToSharedPreferences(name, location);
            createUser(name, mUserId);
            dismiss();
        }

    }

    private void addToSharedPreferences(String name, String location) {
        mEditor.putString("name", name).commit();
        mEditor.putString("location", location).commit();
    }

    private void createUser(String name, String userId) {
        User user = new User(name, userId);
        mFirebaseRef.child("users/" + userId).push().setValue(user);
    }


}
