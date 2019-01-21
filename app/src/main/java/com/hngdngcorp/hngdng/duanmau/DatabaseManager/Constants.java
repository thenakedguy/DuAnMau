package com.hngdngcorp.hngdng.duanmau.DatabaseManager;

public class Constants {
    //Khai bao bang nguoi dung
    public static final boolean isDEBUG = true ;
    public static final String USER_TABLE= "nguoiDung";
    public static final String USER_USER_NAME = "userName";
    public static final String USER_USER_PASSWORD = "Password";
    public static final String USER_PHONE_NUMBER = "Phone";
    public static final String USER_FULL_NAME = "hoTen";

    // Tao bang nguoi dung
    //CREATE TABLE nguoidung
    public static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "( " +
            " " + USER_USER_NAME +" NVARCHAR (50)," +
            " " + USER_USER_PASSWORD +" NVARCHAR (50)," +
            " " + USER_PHONE_NUMBER +" NCHAR (50)," +
            " " + USER_FULL_NAME +" NVARCHAR (50)" +
            ")" ;
}
