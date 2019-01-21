package com.hngdngcorp.hngdng.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SignUpActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setBackButton("Sign Up");
    }
}
