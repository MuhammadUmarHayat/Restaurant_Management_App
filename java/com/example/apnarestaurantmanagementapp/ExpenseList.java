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

public class ExpenseList extends AppCompatActivity
{
RecyclerView recyclerView;
Button btnNewExp;
     ArrayList <String>id, category, title, description, doe, total;
    AllExpenseAdapter adapter;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);
        recyclerView=findViewById(R.id.rcExpenseView);
        btnNewExp=findViewById(R.id.btnExpenseNew1);

        db=new MyDatabase(this);
        id=new ArrayList<>();
        category=new ArrayList<>();
        title=new ArrayList<>();
        description=new ArrayList<>();
        doe=new ArrayList<>();
        total=new ArrayList<>();
        adapter=new AllExpenseAdapter(ExpenseList.this,id, category, title, description, doe, total);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        btnNewExp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseList.this, AdminAddExpense.class);
                startActivity(intent);
            }
        });
    }

    private void displayData()
    {
        //  Cursor cursor = db.getTableData("institutes", "manager", manager);
        Cursor cursor = db.getAllData("expenses");
        if (cursor.getCount() == 0)
        {

        } else {
            while (cursor.moveToNext()) {
                //category, title, description, doe, total;
                id.add(cursor.getString(0));
                category.add(cursor.getString(1));
                title.add(cursor.getString(2));

                description.add(cursor.getString(3));
                doe.add(cursor.getString(4));
                total.add(cursor.getString(6));


            }
        }
    }
}
