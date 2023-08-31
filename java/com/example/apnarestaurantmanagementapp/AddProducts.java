package com.example.apnarestaurantmanagementapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class AddProducts extends AppCompatActivity
{
    EditText etPName1,etPsize1,etPCategory1,etPSubCategory1,etPbrande1,etPSupplier1,etPQty1,etPPurchasePrice1,etPSalePrice1,etPPurchaseDate1;
    Button btnSave,btnBack;
    //btnbackProductsad,btnSaveProduct

    MyDatabase dbMain;
    SQLiteDatabase db;
    ImageView photo;
    private static final int PICK_IMAGE_REQUEST=100;

    private Uri imageFilePath;
    private Bitmap imageStore;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
        etPName1=findViewById(R.id.etPName);
                etPsize1=findViewById(R.id.etPsize);
        etPCategory1=findViewById(R.id.etPCategory);
                etPSubCategory1=findViewById(R.id.etPSubCategory);
        etPbrande1=findViewById(R.id.etPbrande);
                etPSupplier1=findViewById(R.id.etPSupplier);
        etPQty1=findViewById(R.id. etPQty);
                etPPurchasePrice1=findViewById(R.id.etPPurchasePrice);
        etPSalePrice1=findViewById(R.id.etPSalePrice);
                etPPurchaseDate1=findViewById(R.id.etPPurchaseDate);
                photo=findViewById(R.id.photo1);
                btnSave=findViewById(R.id.btnSaveProduct);
                btnBack=findViewById(R.id.btnbackProductsad);


                dbMain=new MyDatabase(this);

        selectPhoto();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProducts.this, AdminPanel.class);
                startActivity(intent);
            }
        });
btnSave.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {
        String name,category,subcategory,brand,sku,supplier,unit,purchasePrice,salePrice,qty,status,purchasing_Date;
        name=etPName1.getText().toString();
        category=etPCategory1.getText().toString();
        subcategory=etPSubCategory1.getText().toString();
        brand=etPbrande1.getText().toString();

        supplier=etPSupplier1.getText().toString();
        unit=etPsize1.getText().toString();
        purchasePrice=etPPurchasePrice1.getText().toString();
        salePrice=etPSalePrice1.getText().toString();
        qty=etPQty1.getText().toString();
        status="purchased";
        purchasing_Date=etPPurchaseDate1.getText().toString();
        int minRange = 1234;
        int maxRange = 9999;

        Random random = new Random();

        // Generate a random integer between minRange (inclusive) and maxRange (exclusive)
        int randomNo = random.nextInt(maxRange - minRange) + minRange;
        sku=category+randomNo;
        try {
           // String name,category,subcategory,brand,sku,supplier,unit,purchasePrice,salePrice,qty,status,purchasing_Date;
            ContentValues cv = new ContentValues();
            cv.put("name", name);
            cv.put("category",category );
            cv.put("subcategory",subcategory );
            cv.put("brand", brand);
            cv.put("sku",sku );//sku: stock keeping unit
            cv.put("supplier",supplier );
            cv.put("unit",unit );
            cv.put("purchasePrice",purchasePrice );
            cv.put("salePrice",salePrice );
            cv.put("qty",qty );
            cv.put("status",status );
            cv.put("photo", ImageViewToByte(photo));
            cv.put("purchasing_Date", purchasing_Date);
            db = dbMain.getWritableDatabase();
            long inserted = db.insert("products", null, cv);
            if (inserted > 0)
            {
                Toast.makeText(AddProducts.this, "Record is saved", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddProducts.this, AdminProductList.class);
                startActivity(intent);
            }
        }
        catch (Exception exp)
        {
            Toast.makeText(AddProducts.this, "error"+exp.getMessage().toString(), Toast.LENGTH_SHORT).show();

        }



    }
});


    }//oncreate
    private void selectPhoto()
    {
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chooseImage(view);
            }
        });
    }

    private byte[] ImageViewToByte(ImageView photo)
    {
        Bitmap bitmap=((BitmapDrawable)photo.getDrawable()).getBitmap();
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        byte[] bytes=stream.toByteArray();
        return bytes;
    }

    public void chooseImage(View objectView)
    {
        try
        {
            Intent objectIntent=new Intent();
            objectIntent.setType("image/*");
            objectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(objectIntent,PICK_IMAGE_REQUEST);

        }
        catch(Exception exp){

            Toast.makeText(this,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null &&data.getData()!=null)
            {
                imageFilePath=data.getData();
                imageStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
                photo.setImageBitmap(imageStore);

            }


        }
        catch(Exception exp){

            Toast.makeText(this,exp.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }





}