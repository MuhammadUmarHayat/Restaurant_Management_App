package com.example.apnarestaurantmanagementapp;

import android.database.sqlite.SQLiteDatabase;

public class UserTable
{
//String full_name,userid,password,address,usertype,dateOfJoining,status;
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "full_name";
    public static final String COL_3 = "userid";
    public static final String COL_4 = "password";
    public static final String COL_5 = "address";
    public static final String COL_6 = "usertype";
    public static final String COL_7 = "dateOfJoining";
    public static final String COL_8 = "status";




    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT,"
                    + COL_7 + " TEXT,"
                    + COL_8 + " TEXT"

                    + ")";

    public static void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
