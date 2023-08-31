package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
Spinner spUsertype1;
Button btnloginlg1;
EditText lgEd11,lgEd21;
MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lgEd11 =findViewById(R.id.lgEd1);
        lgEd21=findViewById(R.id.lgEd2);
        spUsertype1=findViewById(R.id.spUsertype);
        btnloginlg1=findViewById(R.id.btnloginlg);
        db=new MyDatabase(this);
        btnloginlg1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userid=lgEd11.getText().toString();
                String password=lgEd21.getText().toString();
                String usertype=spUsertype1.getSelectedItem().toString();
                if(userid.equals("admin")&& password.equals("admin")&& usertype.equals("admin") )
                {
                    Intent page = new Intent(MainActivity.this, AdminPanel.class);
                    page.putExtra("user",userid);
                    startActivity(page);

                }
              Boolean isExist=  db.checkUserExist(userid, password);
                if(isExist &&usertype.equals("manager"))
                {
                    Intent page = new Intent(MainActivity.this, ManagerPanel.class);
                    page.putExtra("user",userid);
                    startActivity(page);
                }
                if(isExist &&usertype.equals("cashier"))
                {
                    Intent page = new Intent(MainActivity.this, CashierPanel.class);
                    page.putExtra("user",userid);
                    startActivity(page);
                }
                if(isExist &&usertype.equals("worker"))
                {
                    Intent page = new Intent(MainActivity.this, AdminPanel.class);
                    page.putExtra("user",userid);
                    startActivity(page);
                }
            }
        });


    }
}