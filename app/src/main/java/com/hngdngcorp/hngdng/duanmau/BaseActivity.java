package com.hngdngcorp.hngdng.duanmau;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

class BaseActivity  extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
    }
    public void startNewActivity(Class target){
        Intent intent = new Intent(this, target);
        startActivity(intent);
    }
    @SuppressLint("RestrictedApi")
    public void setBackButton(String title){
        getSupportActionBar();
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

}
