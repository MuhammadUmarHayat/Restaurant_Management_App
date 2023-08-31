package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAddExpense extends AppCompatActivity
{
EditText etNameAdpExp1,etUseridAdpExpCat1,etPwAdpExpDes1,etAdpExpTotal1,etDOJAdpExpDate1;
Button btnSaveAdpExpSave1;
MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_expense);
        db=new MyDatabase(this);
        etNameAdpExp1=findViewById(R.id.etNameAdpExp);

etUseridAdpExpCat1=findViewById(R.id.etUseridAdpExpCat);
etPwAdpExpDes1=findViewById(R.id.etPwAdpExpDes);
        etAdpExpTotal1=findViewById(R.id.etAdpExpTotal);
        etDOJAdpExpDate1=findViewById(R.id.etDOJAdpExpDate);
        btnSaveAdpExpSave1=findViewById(R.id.btnSaveAdpExpSave);
        btnSaveAdpExpSave1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String category=etUseridAdpExpCat1.getText().toString();
                String title=etNameAdpExp1.getText().toString();
                String description=etPwAdpExpDes1.getText().toString();
                String doe=etDOJAdpExpDate1.getText().toString();
                String remarks="ok";
                String total=etAdpExpTotal1.getText().toString();
                String status="done";
                db.saveExpense(category,title,description,doe,remarks,total,status);
                Toast.makeText(AdminAddExpense.this, "Record is saved", Toast.LENGTH_SHORT).show();
            }
        });



    }
}