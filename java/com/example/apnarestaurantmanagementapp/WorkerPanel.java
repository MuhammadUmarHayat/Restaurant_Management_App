package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkerPanel extends AppCompatActivity
{
    Button btnPOSAdd1,btnExpDetails1,btnLogout11;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_panel);

        btnPOSAdd1=findViewById(R.id.btnWorkerPOSAdd);
        btnExpDetails1=findViewById(R.id.btnWorkerExpDetails);
        btnLogout11=findViewById(R.id.btnWorkerLogout1);
        btnLogout11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //logout
                showLogoutConfirmationDialog();
            }
        });

        btnPOSAdd1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WorkerPanel.this, AddPOS.class);
                startActivity(intent);
            }
        });
        btnExpDetails1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WorkerPanel.this, ExpenseList.class);
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
                Intent intent = new Intent(WorkerPanel.this, MainActivity.class);
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