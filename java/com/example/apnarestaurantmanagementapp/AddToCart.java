package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AddToCart extends AppCompatActivity
{
RecyclerView recyclerView;
Button btnContiue1,btncheckout;
    ArrayList<String> id,customerName,productname,price,qty,total;
    CustomerSaleAdapter adapter;
MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        recyclerView=findViewById(R.id.rcAddtoCartView);
        btnContiue1=findViewById(R.id.btnContiue);
        btncheckout=findViewById(R.id.btnAddtocartCheckout);


        db=new MyDatabase(this);
        id=new ArrayList<>();
        customerName=new ArrayList<>();
        productname=new ArrayList<>();
        price=new ArrayList<>();
        qty=new ArrayList<>();
        total=new ArrayList<>();

adapter=new CustomerSaleAdapter(this,id,customerName,productname,price,qty,total);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        btnContiue1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AddToCart.this, AddPOS.class);
                startActivity(intent);
            }
        });
        btncheckout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                generateOrder();
            }
        });


    }//oncreate

    private void generateOrder()
    {
        int min = 1111;  // Minimum value of the range
        int max = 9999;  // Maximum value of the range

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        Cursor cursor = db.getAllData("sales");
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                //put into orders from sale cart(sales table)
                //id,customerName,productname,price,qty,total;
                id.add(cursor.getString(0));
              String customer=cursor.getString(1);
                String pname=cursor.getString(2);

            String p=cursor.getString(4);
                int price=Integer.parseInt(p);
            String q=cursor.getString(5);
                int qty=Integer.parseInt(q);
              String t=cursor.getString(6);
                int total=Integer.parseInt(t);

                String orderno=Integer.toString(randomNumber);
               String saleDate,status,remarks;
               saleDate="";
               status="paid";
               remarks="paid";

db.saveOrder(customer,pname,orderno,price,qty,total,saleDate,status,remarks);

            }

            //empty sale cart now
           db.deleteTableData("sales");
            Toast.makeText(this, "Order is generated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddToCart.this, CustomerInvoice.class);
            startActivity(intent);

    }
    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        Cursor cursor = db.getAllData("sales");
        if (cursor.getCount() == 0)
        {

        }
        else {
            while (cursor.moveToNext()) {
             //id,customerName,productname,price,qty,total;
                id.add(cursor.getString(0));
                customerName.add(cursor.getString(1));
                productname.add(cursor.getString(2));

                price.add(cursor.getString(4));
                qty.add(cursor.getString(5));
                total.add(cursor.getString(6));


            }
        }
    }
}