package com.example.apnarestaurantmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 101;
    private static final String DATABASE_NAME = "restaurantDB1";
    public MyDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        UserTable.onCreate(db);
        ProductTable.onCreate(db);
        SaleTable.onCreate(db);
        ExpenseTable.onCreate(db);
        OrderTable.onCreate(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //alter tables
        UserTable.onUpgrade(db, oldVersion, newVersion);
        ProductTable .onUpgrade(db, oldVersion, newVersion);
        SaleTable.onUpgrade(db, oldVersion, newVersion);
        ExpenseTable .onUpgrade(db, oldVersion, newVersion);
        OrderTable.onUpgrade(db, oldVersion, newVersion);
    }
    public boolean saveUser(String full_name,String userid,String password,String address,String usertype,String dateOfJoining,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",full_name);
        contentValues.put("userid",userid);
        contentValues.put("password",password);
        contentValues.put("address",address);
        contentValues.put("usertype",usertype);
        contentValues.put("dateOfJoining",dateOfJoining);
        contentValues.put("status",status);
        long result = db.insert("users",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean saveExpense(String category,String title,String description,String doe,String remarks,String total,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("category",category);
        contentValues.put("title",title);
        contentValues.put("description",description);
        contentValues.put("doe",doe);
        contentValues.put("remarks",remarks);
        contentValues.put("total",total);
        contentValues.put("status",status);
        long result = db.insert("expenses",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean saveSale(String customerName,String productname,String productNo,int price,int qty,int total,String saleDate,String status,String remarks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerName",customerName);
        contentValues.put("productname",productname);
        contentValues.put("productNo",productNo);
        contentValues.put("price",price);
        contentValues.put("qty",qty);
        contentValues.put("total",total);
        contentValues.put("saleDate",saleDate);
        contentValues.put("status",status);
        contentValues.put("remarks",remarks);

        long result = db.insert("sales",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //check user existance
    public boolean checkUserExist(String userid, String password) {//UserID ,Password
        String[] columns = {"userid"};
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = "userid=? and password = ?";
        String[] selectionArgs = {userid, password};

        Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveOrder(String customerName,String productname,String orderNo,int price,int qty,int total,String saleDate,String status,String remarks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("customerName",customerName);
        contentValues.put("productname",productname);
        contentValues.put("orderNo",orderNo);
        contentValues.put("price",price);
        contentValues.put("qty",qty);
        contentValues.put("total",total);
        contentValues.put("saleDate",saleDate);
        contentValues.put("status",status);
        contentValues.put("remarks",remarks);

        long result = db.insert("orders",null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(String table)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table,null);
        return res;
    }
    public Cursor getDataByID(String table,String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table+" where id='"+id+"'",null);
        return res;
    }
    public int delete(String tableName,String id,String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, id+"= ?",new String[] {value});
    }
    public int deleteTableData(String tableName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName, null, null);
    }
    public Cursor getPOSCategory()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select DISTINCT category from products",null);
        return res;
    }
    public Cursor getPOSSubCategory()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select DISTINCT subcategory from products",null);
        return res;
    }
    public Cursor getPOSProducts()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select DISTINCT name from products",null);
        return res;
    }
    public double getPOSPrice(String product, String size)
    {
        double price = -1; // Default value in case the product is not found or an error occurs
        SQLiteDatabase db = this.getReadableDatabase();

        // Use selectionArgs to avoid SQL injection
        String query = "SELECT salePrice FROM products WHERE name=? AND unit=?";
        String[] selectionArgs = {product, size};

        Cursor cursor = db.rawQuery(query, selectionArgs);

        try {
            if (cursor.moveToFirst()) {
                price = cursor.getDouble(cursor.getColumnIndex("salePrice"));
            }
        } catch (Exception e) {
            // Handle any exceptions that might occur during the database operation
            e.printStackTrace();
        } finally {
            cursor.close();
            db.close();
        }

        return price;
    }
    public Cursor getTableData(String table,String col,String value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table+" where "+col+"="+value ,null);
        return res;
    }
    public boolean updateSaleQty(int Id, int qty, String productname,int total )
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("productname",productname);
        values.put("qty",qty);
        values.put("total",total);
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(Id) };

        long result =  db.update("sales", values, selection, selectionArgs);
        if(result == -1)
            return false;
        else
            return true;
    }
    //functions for reporting
    public int totalOrders()
    {//return total orders
        String query = "SELECT COUNT(*) FROM orders";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
    public int totalIncome()
    {//return total orders
        String query = "SELECT sum(total) FROM orders";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
    public int totalUsers()
    {//return total orders
        String query = "SELECT COUNT(*) FROM users";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
    public int totalSale()
    {//return total orders
        String query = "SELECT sum(total) FROM orders";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }

    public int totalExpense()
    {//return total orders
        String query = "SELECT sum(total) FROM expenses";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
    public int totalPurchases()
    {//return total purchases price
        String query = "SELECT sum(purchasePrice) FROM products";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
    public int totalPropductInstock()
    {//return total orders
        String query = "SELECT COUNT(*) FROM products";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        int count = 0;
        if (cursor.moveToFirst())
        {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }
}
