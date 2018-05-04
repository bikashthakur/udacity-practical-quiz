package com.example.android.udacitypracticalquiz;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by BIKASH THAKUR on 02-May-18.
 */

public class DetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mUsernameTextView;
    private TextView mUserEmaiTextView;
    private TextView mUserDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mUsernameTextView = (TextView) findViewById(R.id.tv_username);
        mUserEmaiTextView = (TextView) findViewById(R.id.tv_email);
        mUserDescTextView = (TextView) findViewById(R.id.tv_about);

        //set toolbar
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);

        //back navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //retrieve user details from shared preferences if available

        Resources res = getResources();

        SharedPreferences pref = getSharedPreferences(res.getString(R.string.shared_pref_name), MODE_PRIVATE);

        mUsernameTextView.setText(pref.getString(res.getString(R.string.shared_pref_username_key), res.getString(R.string.tv_username_default)));
        mUserEmaiTextView.setText(pref.getString(res.getString(R.string.shared_pref_user_email_key), res.getString(R.string.tv_user_email_default)));
        mUserDescTextView.setText(pref.getString(res.getString(R.string.shared_pref_user_desc_key),res.getString(R.string.tv_user_desc_default)));

    }

}
