package com.example.apnarestaurantmanagementapp;

import android.database.sqlite.SQLiteDatabase;

public class SaleTable
{
    //customerName,productname,productNo,price,qty,total,saleDate,status,remarks
    public static final String TABLE_NAME = "sales";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "customerName";
    public static final String COL_3 = "productname";
    public static final String COL_4 = "productNo";
    public static final String COL_5 = "price";
    public static final String COL_6 = "qty";
    public static final String COL_7 = "total";
    public static final String COL_8 = "saleDate";
    public static final String COL_9 = "status";
    public static final String COL_10 = "remarks";//order no/invoice no





    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " INTEGER,"
                    + COL_6 + " INTEGER,"
                    + COL_7 + " INTEGER,"
                    + COL_8 + " TEXT,"
                    + COL_9 + " TEXT,"
                    + COL_10 + " TEXT"

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
