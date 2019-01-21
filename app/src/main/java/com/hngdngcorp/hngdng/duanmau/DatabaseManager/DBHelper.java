package com.hngdngcorp.hngdng.duanmau.DatabaseManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hngdngcorp.hngdng.duanmau.Model.User;

import java.util.List;

import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.CREATE_USER_TABLE;
import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.USER_FULL_NAME;
import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.USER_PHONE_NUMBER;
import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.USER_TABLE;
import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.USER_USER_NAME;
import static com.hngdngcorp.hngdng.duanmau.DatabaseManager.Constants.USER_USER_PASSWORD;

public class DBHelper extends SQLiteOpenHelper {
    private final String DB_NAME = "QuanLiSach";
    public DBHelper(Context context) {
        super(context, "QuanLiSach", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        if (Constants.isDEBUG) Log.e("CREATE_USER_TABLE",CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }
    public long insertUser (User user){
        long result = -1;

        ContentValues  contentValues= new ContentValues();

        contentValues.put(USER_USER_NAME,user.USER_USER_NAME);
        contentValues.put(USER_USER_PASSWORD,user.USER_PASSWORD);
        contentValues.put(USER_PHONE_NUMBER,user.USER_PHONE);
        contentValues.put(USER_FULL_NAME,user.USER_FULL_NAME);

        // XIN QUYEN GHI
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        result = sqLiteDatabase.insert(USER_TABLE,null,contentValues);
        sqLiteDatabase.close();

        return  result;
    }
    public long updateUser (User user){
        long result = -1;

        ContentValues  contentValues= new ContentValues();

        contentValues.put(USER_USER_NAME,user.USER_USER_NAME);
        contentValues.put(USER_USER_PASSWORD,user.USER_PASSWORD);
        contentValues.put(USER_PHONE_NUMBER,user.USER_PHONE);
        contentValues.put(USER_FULL_NAME,user.USER_FULL_NAME);

        // XIN QUYEN GHI
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        result = sqLiteDatabase.update(USER_TABLE,contentValues,USER_USER_NAME + "=?",new String[]{user.USER_USER_NAME});
        sqLiteDatabase.close();

        return  result;
    }
    public long delUser (User USER_USER_NAME){
        long result = -1;



        // XIN QUYEN GHI
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        result = sqLiteDatabase.delete(USER_TABLE,USER_USER_NAME + "=?",new String[]{String.valueOf(USER_USER_NAME)});
        sqLiteDatabase.close();

        return  result;
    }
    public List<User> getAllUsers(){
        List<User> users = null;
        String QUERY = "SELECT * FROM " +USER_TABLE;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(QUERY,null);
        if (cursor != null ){
            if (cursor.getCount() >0 ){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){

                     String USER_USER_NAME_ = cursor.getString(cursor.getColumnIndex(USER_USER_NAME));
                     String USER_PASSWORD_ = cursor.getString(cursor.getColumnIndex(USER_USER_PASSWORD));
                     String USER_PHONE_ = cursor.getString(cursor.getColumnIndex(USER_PHONE_NUMBER));
                     String USER_FULL_NAME_ = cursor.getString(cursor.getColumnIndex(USER_FULL_NAME));
                    User user = new User();
                    user.USER_USER_NAME = USER_USER_NAME_;
                    user.USER_PASSWORD = USER_PASSWORD_;
                    user.USER_PHONE = USER_PHONE_;
                    user.USER_FULL_NAME = USER_FULL_NAME_;
                    users.add(user);
                    cursor.moveToNext();

                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return users;
    }
}
