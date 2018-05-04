package com.example.android.udacitypracticalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mBtnNextActivity;
    private EditText mUsernameEditText;
    private EditText mUserEmailEditText;
    private EditText mUserDescEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to the views
        mBtnNextActivity = (Button) findViewById(R.id.btn_next);
        mUsernameEditText = (EditText) findViewById(R.id.et_username);
        mUserEmailEditText = (EditText) findViewById(R.id.et_email);
        mUserDescEditText = (EditText) findViewById(R.id.et_about);

        //set toolbar
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        mBtnNextActivity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //save the user details to shared preferences
                saveUserDetails();

                Context context = MainActivity.this;
                Class detailsActivity = DetailActivity.class;
                Intent intent = new Intent(context, detailsActivity);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void saveUserDetails() {
        Resources res = getResources();
        SharedPreferences pref = getSharedPreferences(res.getString(R.string.shared_pref_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //save data
        String username = getUsername();
        if (!username.trim().isEmpty()) {
            editor.putString(res.getString(R.string.shared_pref_username_key), username);
        }
        String email = getUserEmail();
        if (!email.trim().isEmpty()) {
            editor.putString(res.getString(R.string.shared_pref_user_email_key), email);
        }
        String desc = getUserDesc();
        if (!desc.trim().isEmpty()) {
            editor.putString(res.getString(R.string.shared_pref_user_desc_key), desc);
        }
        editor.apply();
    }

    private String getUsername() {
        return mUsernameEditText.getText().toString();
    }
    private String getUserEmail() {
        return mUserEmailEditText.getText().toString();
    }
    private String getUserDesc() {
        return mUserDescEditText.getText().toString();
    }
}
