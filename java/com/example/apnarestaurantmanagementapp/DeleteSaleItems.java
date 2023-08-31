package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeleteSaleItems extends AppCompatActivity
{
Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_sale_items);
        btnBack=findViewById(R.id.btnBackDeleteSaleCart);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(DeleteSaleItems.this, AddToCart.class);
                startActivity(intent);

            }
        });
    }
}