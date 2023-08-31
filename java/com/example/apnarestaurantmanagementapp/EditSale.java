package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditSale extends AppCompatActivity
{
   Button btnEditSaleSubmit1;
   EditText etQty;
   TextView tvid,tvProductName,tvPrice;
   MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sale);
        btnEditSaleSubmit1=findViewById(R.id.btnEditSaleSubmit);
        etQty  =findViewById(R.id.etEditQty1);
        tvid=findViewById(R.id.tvEditProductID);
        tvProductName =findViewById(R.id.tvproductName);
        tvPrice=findViewById(R.id.tvEditProductPrice);
        db=new MyDatabase(this);
try {


    Intent intent = getIntent();

    if (intent != null && intent.hasExtra("saleid")) {
        String sid = intent.getStringExtra("saleid");
        bindData(sid);
    }
}
catch ( Exception exp){
    tvProductName.setText(exp.getMessage().toString());
}

        btnEditSaleSubmit1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String i=tvid.getText().toString();
                int id=Integer.parseInt(i);
                String q=etQty.getText().toString();

                int qty=Integer.parseInt(q);
String p=tvPrice.getText().toString();
                int price=Integer.parseInt(p);
                int total=price*qty;


                String productname=tvProductName.getText().toString();
db.updateSaleQty( id, qty,  productname ,total);
                Intent intent = new Intent(EditSale.this, AddToCart.class);
                startActivity(intent);
            }
        });
    }//oncreate
    private void  bindData(String id)
    {

        Cursor cursor=db.getTableData("sales","ID",id);
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                String sid=id;
                String name="";
                String qty="";
String price="";
                sid=cursor.getString(0);
                name=cursor.getString(2);
                qty=cursor.getString(5);

price=cursor.getString(4);
                etQty.setText(qty);
                tvid.setText(sid);
                tvProductName.setText(name);
                tvPrice.setText(price);
            }

        }
    }
}