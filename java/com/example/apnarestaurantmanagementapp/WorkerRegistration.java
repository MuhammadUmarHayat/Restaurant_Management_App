package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WorkerRegistration extends AppCompatActivity
{
    Button btnSaveAdpWorker1;
    EditText etNameAdpWorker1,etUseridAdpWorker1,etPwAdpWorker1,etAddressAdpWorker1,etDOJAdpWorker1;
MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_registration);
        etNameAdpWorker1=findViewById(R.id. etNameAdpWorker);
        etUseridAdpWorker1=findViewById(R.id.etUseridAdpWorker);
        etPwAdpWorker1=findViewById(R.id.etPwAdpWorker);
        etAddressAdpWorker1=findViewById(R.id.etAddressAdpWorker);
        etDOJAdpWorker1=findViewById(R.id.etDOJAdpWorker);
        btnSaveAdpWorker1=findViewById(R.id.btnSaveAdpWorker);

        db=new MyDatabase(this);
        btnSaveAdpWorker1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String full_name=etNameAdpWorker1.getText().toString();
                String userid=etUseridAdpWorker1.getText().toString();
                String password=etNameAdpWorker1.getText().toString();
                String address=etAddressAdpWorker1.getText().toString();
                String usertype="manager";
                String dateOfJoining=etDOJAdpWorker1.getText().toString();
                String status="active";
                boolean isInserted=     db.saveUser(full_name,userid,password,address,usertype,dateOfJoining,status);
                if(isInserted == true)
                {
                    Toast.makeText(WorkerRegistration.this, "User is Registered successfully !", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}