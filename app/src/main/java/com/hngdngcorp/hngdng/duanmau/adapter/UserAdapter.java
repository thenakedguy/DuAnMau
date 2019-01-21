package com.hngdngcorp.hngdng.duanmau.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hngdngcorp.hngdng.duanmau.DatabaseManager.DBHelper;
import com.hngdngcorp.hngdng.duanmau.Model.User;
import com.hngdngcorp.hngdng.duanmau.R;
import com.hngdngcorp.hngdng.duanmau.UserManagerActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    public Context context;
    public List<User> users;

    public UserAdapter(UserManagerActivity userManagerActivity, List<User> users) {
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_layout,viewGroup,false);
        
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
            User user = users.get(i);
            userHolder.mTextView.setText(user.USER_FULL_NAME);
            userHolder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });
    }

    @Override
    public int getItemCount() {
        if (users == null )return 0;
        else 
        return users.size();
        
    }
    class UserHolder extends RecyclerView.ViewHolder {
        public final TextView mTextView;
        public final Button mButton;

        

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mButton = (Button) itemView.findViewById(R.id.button);
        }
    }
}
