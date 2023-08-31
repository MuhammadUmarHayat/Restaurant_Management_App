package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SaleList extends AppCompatActivity
{
    RecyclerView recyclerView;
    Button btnBack;
    ArrayList<String> id,orderNo,customerName,productname,price,qty,total;
    AllOrdersAdapter adapter;
    TextView tv1;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_list);
        recyclerView=findViewById(R.id.rcSaleListView);
        btnBack=findViewById(R.id.btnSaleListBack);
        tv1=findViewById(R.id.tvSaleListTitle);

        db=new MyDatabase(this);
        id=new ArrayList<>();
        orderNo=new ArrayList<>();
        customerName=new ArrayList<>();
        productname=new ArrayList<>();
        price=new ArrayList<>();
        qty=new ArrayList<>();
        total=new ArrayList<>();
        try {
            adapter = new AllOrdersAdapter(this, id, orderNo, customerName, productname, price, qty, total);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            displayData();
        }
        catch (Exception exp)
        {
            tv1.setText(exp.getMessage().toString());
        }


        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SaleList.this, AdminPanel.class);
                startActivity(intent);
            }
        });
    }//on create
    private void displayData()
    {

        Cursor cursor = db.getAllData("orders");
        if (cursor.getCount() == 0)
        {

        } else
        {
            while (cursor.moveToNext()) {
                //id,orderNo,customerName,productname,price,qty,total;
                id.add(cursor.getString(0));
                orderNo.add(cursor.getString(3));
                customerName.add(cursor.getString(1));

                productname.add(cursor.getString(2));
                price.add(cursor.getString(4));
                qty.add(cursor.getString(5));
                total.add(cursor.getString(6));


            }
        }
    }
}