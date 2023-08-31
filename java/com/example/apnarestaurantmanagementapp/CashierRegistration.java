package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CashierRegistration extends AppCompatActivity {
    Button btnSaveAdpChr1,btnBackAdpChr1;
    EditText etNameAdpChr1,etUseridAdpChr1,etPwAdpChr1,etAddressAdpChr1,etDOJAdpChr1;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_registration);
        etNameAdpChr1=findViewById(R.id. etNameAdpChr);
        etUseridAdpChr1=findViewById(R.id.etUseridAdpChr);
        etPwAdpChr1=findViewById(R.id.etPwAdpChr);
        etAddressAdpChr1=findViewById(R.id.etAddressAdpChr);
        etDOJAdpChr1=findViewById(R.id.etDOJAdpChr);
        btnSaveAdpChr1=findViewById(R.id.btnSaveAdpChr);
        btnBackAdpChr1=findViewById(R.id.btnBackAdpChr);
        db=new MyDatabase(this);
        btnSaveAdpChr1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String full_name=etNameAdpChr1.getText().toString();
                String userid=etUseridAdpChr1.getText().toString();
                String password=etNameAdpChr1.getText().toString();
                String address=etAddressAdpChr1.getText().toString();
                String usertype="cashier";
                String dateOfJoining=etDOJAdpChr1.getText().toString();
                String status="active";
                boolean isInserted=     db.saveUser(full_name,userid,password,address,usertype,dateOfJoining,status);
                if(isInserted == true)
                {
                    Toast.makeText(CashierRegistration.this, "User is Registered successfully !", Toast.LENGTH_LONG).show();

                }
            }
        });
        btnBackAdpChr1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(CashierRegistration.this, AdminPanel.class);
                startActivity(page);
            }
        });

    }
}