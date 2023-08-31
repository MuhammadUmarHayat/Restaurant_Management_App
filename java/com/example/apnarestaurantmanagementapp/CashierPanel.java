package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CashierPanel extends AppCompatActivity
{
    Button btnPOSAdd1,btnExpDetails1,btnWorkerSignup1,btnLogout11;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashier_panel);
        btnWorkerSignup1=findViewById(R.id.btnCashierWorkerSignup);
        btnPOSAdd1=findViewById(R.id.btnCashierPOSAdd);
        btnExpDetails1=findViewById(R.id.btnCashierExpDetails);
        btnLogout11=findViewById(R.id.btnCashierLogout1);
        btnLogout11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //logout
                showLogoutConfirmationDialog();
            }
        });
        btnWorkerSignup1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//navigate to worker registration
                Intent intent = new Intent(CashierPanel.this, WorkerRegistration.class);
                startActivity(intent);
            }
        });
        btnPOSAdd1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CashierPanel.this, AddPOS.class);
                startActivity(intent);
            }
        });
        btnExpDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CashierPanel.this, ExpenseList.class);
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
                Intent intent = new Intent(CashierPanel.this, MainActivity.class);
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