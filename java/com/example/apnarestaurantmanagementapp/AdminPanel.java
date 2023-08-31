package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanel extends AppCompatActivity
{
    Button btn1adp1,btn2adp1,btn3adp1,btn4adp1,btn5adp1,btn6adp1,btn7adp1,btn8adp1,btn9adp1,btn10adp1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        btn1adp1=findViewById(R.id.btn1adp);
        btn2adp1=findViewById(R.id.btn2adp);
        btn3adp1=findViewById(R.id.btn3adp);
        btn4adp1=findViewById(R.id.btn4adp);
        btn5adp1=findViewById(R.id.btn5adp);
        btn6adp1=findViewById(R.id.btn6adp);
        btn7adp1=findViewById(R.id.btn7adp);
        btn8adp1=findViewById(R.id.btn8adp);
        btn9adp1=findViewById(R.id.btn9adp);
        btn10adp1=findViewById(R.id.btn10adp);

        btn10adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminPanel.this, AddPOS.class);
    startActivity(intent);
            }
        });
        btn1adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//navigate to manager registration
                Intent intent = new Intent(AdminPanel.this, ManagerRegistration.class);
                startActivity(intent);
            }
        });
        btn2adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//navigate to cashier registration
                Intent intent = new Intent(AdminPanel.this, CashierRegistration.class);
                startActivity(intent);
            }
        });
        btn3adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//navigate to worker registration
                Intent intent = new Intent(AdminPanel.this, WorkerRegistration.class);
                startActivity(intent);
            }
        });
        btn4adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminPanel.this, AdminProductList.class);
                startActivity(intent);
            }
        });
        btn5adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, AdminProductList.class);
                startActivity(intent);
            }
        });
        btn6adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, SaleList.class);
                startActivity(intent);
            }
        });
        btn7adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
//
                Intent intent = new Intent(AdminPanel.this, Reports.class);
 startActivity(intent);
            }
        });
        btn8adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //logout
                showLogoutConfirmationDialog();

            }
        });
        btn9adp1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminPanel.this, ExpenseList.class);
                startActivity(intent);
            }
        });

    }//on create
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
                Intent intent = new Intent(AdminPanel.this, MainActivity.class);
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