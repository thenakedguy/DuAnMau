package com.hngdngcorp.hngdng.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hngdngcorp.hngdng.duanmau.DatabaseManager.DBHelper;
import com.hngdngcorp.hngdng.duanmau.Model.User;
import com.hngdngcorp.hngdng.duanmau.adapter.UserAdapter;

import java.util.List;
import java.util.Random;

public class UserManagerActivity extends BaseActivity  {
    private  RecyclerView lvUser;
    private UserAdapter userAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<User> users;
    private DBHelper dbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        setBackButton("UserManager");
        dbHelper = new DBHelper(UserManagerActivity.this);
        for (int i = 0 ; i <10; i++){
            User user = new User();
            user.USER_USER_NAME = "Dang " + i;
            user.USER_FULL_NAME = "Dang " + new Random().nextInt(100);
            user.USER_PHONE = new Random().nextInt(100000) + "";
            user.USER_PASSWORD = "1234566";
            dbHelper.insertUser(user);

        }
        lvUser = findViewById(R.id.lvUser);
        users = dbHelper.getAllUsers();
        userAdapter = new UserAdapter(this,users);
        linearLayoutManager = new LinearLayoutManager(this);
        lvUser.setLayoutManager(linearLayoutManager);
        lvUser.setAdapter(userAdapter);
    }


}
