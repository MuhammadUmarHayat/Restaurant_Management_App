package com.example.apnarestaurantmanagementapp;

import android.database.sqlite.SQLiteDatabase;

public class ProductTable
{
    //name,category,subcategory,brand,sku,supplier,unit,purchasePrice,salePrice,qty,photo,status,purchasing_Date
    public static final String TABLE_NAME = "products";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "name";
    public static final String COL_3 = "category";
    public static final String COL_4 = "subcategory";
    public static final String COL_5 = "brand";
    public static final String COL_6 = "sku";
    public static final String COL_7 = "supplier";
    public static final String COL_8 = "unit";
    public static final String COL_9 = "purchasePrice";
    public static final String COL_10 = "salePrice";
    public static final String COL_11 = "qty";
    public static final String COL_12 = "photo";
    public static final String COL_13 = "status";
    public static final String COL_14 = "purchasing_Date";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT,"
                    + COL_3 + " TEXT,"
                    + COL_4 + " TEXT,"
                    + COL_5 + " TEXT,"
                    + COL_6 + " TEXT,"
                    + COL_7 + " TEXT,"
                    + COL_8 + " TEXT,"
                    + COL_9 + " INTEGER,"
                    + COL_10 + " INTEGER,"
                    + COL_11 + " INTEGER,"
                    + COL_12 + " blob,"
                    + COL_13 + " TEXT,"
                    + COL_14 + " TEXT"
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
