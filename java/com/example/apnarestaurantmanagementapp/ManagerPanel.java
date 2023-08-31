package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerPanel extends AppCompatActivity {
Button btnMgrPOSAdd1,btnMgrExpDetails1,btnMgrWorkerSignup1,btnMgrLogout11,btnMgrProductDetails1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);
        btnMgrWorkerSignup1=findViewById(R.id.btnMgrWorkerSignup);
        btnMgrPOSAdd1=findViewById(R.id.btnMgrPOSAdd);
        btnMgrExpDetails1=findViewById(R.id.btnMgrExpDetails);
        btnMgrLogout11=findViewById(R.id.btnMgrLogout1);
        btnMgrProductDetails1=findViewById(R.id.btnMgrProductDetails);
        btnMgrProductDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ManagerPanel.this, AdminProductList.class);
                startActivity(intent);
            }
        });
        btnMgrLogout11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //logout
                showLogoutConfirmationDialog();
            }
        });
        btnMgrWorkerSignup1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//navigate to worker registration
                Intent intent = new Intent(ManagerPanel.this, WorkerRegistration.class);
                startActivity(intent);
            }
        });
        btnMgrPOSAdd1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ManagerPanel.this, AddPOS.class);
                startActivity(intent);
            }
        });
        btnMgrExpDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ManagerPanel.this, ExpenseList.class);
                startActivity(intent);
            }
        });

    }
    private void showLogoutConfirmationDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                // Perform logout action here
                // For example, you can finish the current activity or navigate to the login screen
                // finish();
                Intent intent = new Intent(ManagerPanel.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Dismiss the dialog
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}