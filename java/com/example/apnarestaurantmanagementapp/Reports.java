package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Reports extends AppCompatActivity
{
TextView tvTotalEmp1,tvTotalOrders1,tvTotalIncome1,tvTotalProducts1,tvTotalPurchases1;
TextView tvTotalExpenses1;
MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        tvTotalEmp1=findViewById(R.id.tvTotalEmp);
        tvTotalOrders1=findViewById(R.id.tvTotalOrders);
        tvTotalIncome1=findViewById(R.id.tvTotalIncome);
        tvTotalProducts1=findViewById(R.id.tvTotalProducts);
        tvTotalPurchases1=findViewById(R.id.tvTotalPurchases);
        tvTotalExpenses1=findViewById(R.id.tvTotalExpenses);
        db=new MyDatabase(this);
      int expense=  db.totalExpense();
      int employes=db.totalUsers();
      int stock=db.totalPropductInstock();
      int purchases=db.totalPurchases();
      int sale=db.totalSale();
      int orders=db.totalOrders();

      tvTotalExpenses1.setText("Total Expenses: "+expense);
      tvTotalEmp1.setText("Total Exployees :"+employes);
      tvTotalIncome1.setText("Total Sale :" +sale);
      tvTotalProducts1.setText("Total Products in stock : "+stock);
      tvTotalPurchases1.setText("Total Purchases in price : "+purchases);
      tvTotalOrders1.setText("Total orders : "+orders);







    }
}