package com.example.apnarestaurantmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class AddPOS extends AppCompatActivity
{
Spinner spinnerCategory1,spinnersubCategory1,spinnerProduct1;
EditText etpostQty11,etPOSCustomerName11,etpostSize11,etPOSCustomerOrderNo1;
TextView tvPOSTotal11,tvPOSTitle11;
Button btncalculateBill,btnAddtocart,btnCheckout;
    List<String> itemSubCategory,itemCategory,itemProduct ;
MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pos);
        db=new MyDatabase(this);
        spinnerCategory1=findViewById(R.id.spinnerCategory);
        spinnersubCategory1=findViewById(R.id.spinnersubCategory);
        spinnerProduct1=findViewById(R.id.spinnerProduct);
        etPOSCustomerName11=findViewById(R.id.etPOSCustomerName1);
        etpostQty11=findViewById(R.id.etpostQty1);
        etpostSize11=findViewById(R.id.etpostSize1);
        etPOSCustomerOrderNo1=findViewById(R.id.etPOSCustomerOrderNo);
        tvPOSTotal11=findViewById(R.id.tvPOSTotal1);
        tvPOSTitle11=findViewById(R.id.tvPOSTitle1);

     btnAddtocart =findViewById(R.id.btnAddcartPOS);
     btncalculateBill =findViewById(R.id.btnPOsCalBill);//
       btnCheckout =findViewById(R.id.btncheckoutPOS);
       itemProduct=new ArrayList<>();
       itemCategory=new ArrayList<>();
       itemSubCategory=new ArrayList<>();

   orderNo();//generate order no
try {
    binCategory();
    bindSubCategory();
    bindProducts();
}
catch (Exception exp)
{
    tvPOSTitle11.setText(exp.getMessage().toString());
}






        btncalculateBill.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try {


                    String cat = spinnerCategory1.getSelectedItem().toString();
                    String subCat = spinnersubCategory1.getSelectedItem().toString();
                    String product = spinnerProduct1.getSelectedItem().toString();
                    String size = etpostSize11.getText().toString();
                    String quan =etpostQty11.getText().toString();
                    double price = db.getPOSPrice(product, size);
                    int qty=Integer.parseInt(quan);
                    double total = qty * price;
                    tvPOSTotal11.setText("Price :" + total);
                }
                catch (Exception exp)
                {
                    tvPOSTitle11.setText(exp.getMessage().toString());
                }

            }
        });

        btnAddtocart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String customer=etPOSCustomerName11.getText().toString();
                String cat = spinnerCategory1.getSelectedItem().toString();
                String subCat = spinnersubCategory1.getSelectedItem().toString();
                String product = spinnerProduct1.getSelectedItem().toString();
                String size = etpostSize11.getText().toString();
                String quan =etpostQty11.getText().toString();
                double price = db.getPOSPrice(product, size);
                int qty=Integer.parseInt(quan);
                double total = qty * price;

                // Get the current date
                Date currentDate = new Date();

// Define the desired date format
                String dateFormat = "yyyy-MM-dd"; // You can change this to the format you want

// Create a SimpleDateFormat object with the desired format
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());

// Format the current date as a string
                String formattedDate = sdf.format(currentDate);

                String saleDat=formattedDate;
               String status="sold";
try {
    int price1 = (int) price;
    int total1 = (int) total;
    String orderNo = etPOSCustomerOrderNo1.getText().toString();
    boolean result = db.saveSale(customer, product, product, price1, qty, total1, saleDat, status, orderNo);
    if (result) {
        tvPOSTitle11.setText("sold");
        Intent intent = new Intent(AddPOS.this, AddToCart.class);
        startActivity(intent);
    } else {
        tvPOSTitle11.setText("not sold");
    }
}
catch(Exception exp){
    tvPOSTitle11.setText(exp.getMessage().toString());
}

            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener()
        {
    @Override
    public void onClick(View view)
    {
        generateOrder();
    }
});





    }//on create
    private void binCategory()
    {
        //bind spinner with category
        Cursor cursor2=db.getPOSCategory();//get all categories
        if (cursor2.moveToFirst()) {
            do {
                String data = cursor2.getString(0);
                itemCategory.add(data);
            } while (cursor2.moveToNext());
        }

        cursor2.close();

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemCategory);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory1.setAdapter(adapter2);

    }
    private void bindSubCategory()
    {
        //bind spinner with sub category
        Cursor cursor3=db.getPOSSubCategory();//get all sub categories
        if (cursor3.moveToFirst()) {
            do {
                String data = cursor3.getString(0);
                itemSubCategory.add(data);
            } while (cursor3.moveToNext());
        }

        cursor3.close();

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemSubCategory);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersubCategory1.setAdapter(adapter3);

    }
    private void bindProducts()
    {
        //bind spinner with products
        Cursor cursor31=db.getPOSProducts();//get all sub categories
        if (cursor31.moveToFirst()) {
            do {
                String data = cursor31.getString(0);
                itemProduct.add(data);
            } while (cursor31.moveToNext());
        }

        cursor31.close();
        //bind cities
        ArrayAdapter<String> adapter31 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemProduct);
        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProduct1.setAdapter(adapter31);
    }
private void orderNo()
{
    Date currentDate = new Date();
    String dateFormat = "dd-MM-yyyy"; // Desired date format

    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());

    String f = sdf.format(currentDate);
    String orderNo= f.toString();
    etPOSCustomerOrderNo1.setText(orderNo);
}
    private void generateOrder()
    {
        int min = 1111;  // Minimum value of the range
        int max = 9999;  // Maximum value of the range

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        Cursor cursor = db.getAllData("sales");
        if (cursor.getCount() == 0)
        {

        }
        else
        {
            while (cursor.moveToNext())
            {
                //put into orders from sale cart(sales table)
                //id,customerName,productname,price,qty,total;
                String id=cursor.getString(0);
                String customer=cursor.getString(1);
                String pname=cursor.getString(2);

                String p=cursor.getString(4);
                int price=Integer.parseInt(p);
                String q=cursor.getString(5);
                int qty=Integer.parseInt(q);
                String t=cursor.getString(6);
                int total=Integer.parseInt(t);

                String orderno=Integer.toString(randomNumber);
                String saleDate,status,remarks;
                saleDate="";
                status="paid";
                remarks="paid";

                db.saveOrder(customer,pname,orderno,price,qty,total,saleDate,status,remarks);

            }

            //empty sale cart now
            db.deleteTableData("sales");
            Toast.makeText(this, "Order is generated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddPOS.this, CustomerInvoice.class);
            startActivity(intent);

        }
    }


}
