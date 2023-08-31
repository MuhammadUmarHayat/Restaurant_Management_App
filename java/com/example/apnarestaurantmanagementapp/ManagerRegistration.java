package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManagerRegistration extends AppCompatActivity
{
Button btnSaveAdpMgr1,btnBackAdpMgr1;
EditText etNameAdpmgr1,etUseridAdpmgr1,etPwAdpmgr1,etAddressAdpmgr1,etDOJAdpmgr1;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_registration);
        etNameAdpmgr1=findViewById(R.id. etNameAdpmgr);
        etUseridAdpmgr1=findViewById(R.id.etUseridAdpmgr);
        etPwAdpmgr1=findViewById(R.id.etPwAdpmgr);
        etAddressAdpmgr1=findViewById(R.id.etAddressAdpmgr);
        etDOJAdpmgr1=findViewById(R.id.etDOJAdpmgr);
        btnSaveAdpMgr1=findViewById(R.id.btnSaveAdpMgr);
        btnBackAdpMgr1=findViewById(R.id.btnBackAdpMgr);
db=new MyDatabase(this);
        btnSaveAdpMgr1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String full_name=etNameAdpmgr1.getText().toString();
                String userid=etUseridAdpmgr1.getText().toString();
                String password=etNameAdpmgr1.getText().toString();
                String address=etAddressAdpmgr1.getText().toString();
                String usertype="manager";
                String dateOfJoining=etDOJAdpmgr1.getText().toString();
                        String status="active";
                   boolean isInserted=     db.saveUser(full_name,userid,password,address,usertype,dateOfJoining,status);
                if(isInserted == true)
                {
                    Toast.makeText(ManagerRegistration.this, "User is Registered successfully !", Toast.LENGTH_LONG).show();

                }
            }
        });
        btnBackAdpMgr1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent page = new Intent(ManagerRegistration.this, AdminPanel.class);
                startActivity(page);
            }
        });

    }
}