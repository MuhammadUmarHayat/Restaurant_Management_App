package com.example.apnarestaurantmanagementapp;

import android.database.sqlite.SQLiteDatabase;

public class ExpenseTable
{
//category,title,description,doe,remarks,total,status
    public static final String TABLE_NAME = "expenses";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "category";
    public static final String COL_3 = "title";
    public static final String COL_4 = "description";
    public static final String COL_5 = "doe";
    public static final String COL_6 = "remarks";
    public static final String COL_7 = "total";
    public static final String COL_8 = "status";




    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT,"
                    + COL_7 + " INTEGER,"
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
