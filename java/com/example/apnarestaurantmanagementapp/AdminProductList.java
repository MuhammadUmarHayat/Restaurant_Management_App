package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AdminProductList extends AppCompatActivity
{
RecyclerView recyclerView;
Button btnback,btnAllProductsNew1;
MyDatabase db;
AllProductsAdapter adapter;
    ArrayList<String> id,name,unit,sku,salePrice,qty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_product_list);
        recyclerView=findViewById(R.id.AdminrecyclerViewAllProducts);
        btnback=findViewById(R.id.btnAllProductsBack);
        btnAllProductsNew1=findViewById(R.id.btnAllProductsNew);

        db=new MyDatabase(this);
        id=new ArrayList<>();
        name=new ArrayList<>();
        unit=new ArrayList<>();
        sku=new ArrayList<>();
        salePrice=new ArrayList<>();
        qty=new ArrayList<>();
        adapter=new AllProductsAdapter(AdminProductList.this,id,name,unit,sku,salePrice,qty);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        btnAllProductsNew1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminProductList.this, AddProducts.class);
                startActivity(intent);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminProductList.this, AdminPanel.class);
                  startActivity(intent);
            }
        });
    }//on create

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        Cursor cursor = db.getAllData("products");
        if (cursor.getCount() == 0)
        {

        } else {
            while (cursor.moveToNext()) {
               //id,name,unit,sku,salePrice,qty;
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                unit.add(cursor.getString(7));

                sku.add(cursor.getString(5));
                salePrice.add(cursor.getString(9));
                qty.add(cursor.getString(10));


            }
        }
    }
}
