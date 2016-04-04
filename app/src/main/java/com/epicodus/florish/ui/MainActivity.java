package com.epicodus.florish.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.florish.FlorishApplication;
import com.epicodus.florish.R;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.core.Tag;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.seasonalButton) Button mSeasonalButton;
    @Bind(R.id.user_page_button) Button mUserPageButton;
    @Bind(R.id.userGreetingTextView) TextView mUserGreetingTextView;
    private Firebase mFirebaseRef;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mSharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        String name = mSharedPreferences.getString("name", null);

        if (name == null) {
            launchUserCreationFragment();
            mUserGreetingTextView.setText("Hi, " + name);
        } else {
            mUserGreetingTextView.setText("Hi, " + name);
        }


        mFirebaseRef = FlorishApplication.getAppInstance().getFirebaseRef();
        checkForAuthenticatedUser();



        mSeasonalButton.setOnClickListener(this);
        mUserPageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    if (v == mSeasonalButton) {
            Intent intent = new Intent(MainActivity.this, SeasonalActivity.class);
            startActivity(intent);
        } else if (v == mUserPageButton) {
            Intent intent = new Intent(MainActivity.this, UserPageActivity.class);
            startActivity(intent);
        }
    }

    private void checkForAuthenticatedUser() {
        AuthData authData = mFirebaseRef.getAuth();
        if (authData == null) {
            goToLoginActivity();
        }
    }

    private void goToLoginActivity() {
        Intent intent = new Intent(this, UserLoginActivity.class);
        startActivity(intent);
    }

    private void launchUserCreationFragment() {
        FragmentManager fm = getFragmentManager();
        UserCreationFragment userCreation = UserCreationFragment.newInstance();
        String tag = "fragment_user_creation";
        userCreation.show(fm, tag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                this.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        mFirebaseRef.unauth();
        goToLoginActivity();
    }

}
