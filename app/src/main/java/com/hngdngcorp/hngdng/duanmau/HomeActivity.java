package com.hngdngcorp.hngdng.duanmau;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hngdngcorp.hngdng.duanmau.DatabaseManager.DBHelper;

public class HomeActivity extends BaseActivity {

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBackButton("Home");
        DBHelper dbHelper = new DBHelper(HomeActivity.this);
    }
    public void openUserManager(View view) {
        startNewActivity(UserManagerActivity.class);

    }

    public void openBooksManager(View view) {
        startNewActivity(UserManagerActivity.class);

    }
    public void openInvoiceManager(View view){
        startNewActivity(UserManagerActivity.class);

    }
    public void openStatistics(View view){
        startNewActivity(UserManagerActivity.class);

    }
    public  void openAbout(View view){
        startNewActivity(UserManagerActivity.class);

    }
    public void exitApplication(View view){

    }
}
