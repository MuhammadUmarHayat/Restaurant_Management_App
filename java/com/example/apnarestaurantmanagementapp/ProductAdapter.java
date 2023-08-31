package com.example.apnarestaurantmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id,name,unit,sku,salePrice,qty;
    private List<ImageModel> imageList;

    public ProductAdapter()
    {

    }

    public ProductAdapter(Context context, ArrayList id, ArrayList name, ArrayList unit, ArrayList sku, ArrayList salePrice, ArrayList qty, List<ImageModel> imageList)
    {
        this.context = context;
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.sku = sku;
        this.salePrice = salePrice;
        this.qty = qty;
        this.imageList = imageList;
    }

    public ProductAdapter(Context context, ArrayList id, ArrayList name, ArrayList unit, ArrayList sku, ArrayList salePrice, ArrayList qty)
    {
        this.context = context;
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.sku = sku;
        this.salePrice = salePrice;
        this.qty = qty;
    }
    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_products_layout3, parent, false);
        return new ProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position)
    {
      //id,name,unit,sku,salePrice,qty;
      //  tvid1,tvname1,tvunit1,tvsku1,tvsalePrice1,tvqty1;
        holder.tvid1.setText(String.valueOf(id.get(position)));
        holder.tvname1.setText(String.valueOf(name.get(position)));
        holder.tvunit1.setText(String.valueOf(unit.get(position)));
        holder.tvsku1.setText(String.valueOf(sku.get(position)));
        holder.tvsalePrice1.setText(String.valueOf(salePrice.get(position)));
        holder.tvqty1.setText(String.valueOf("1"));//default value 1
        ImageModel imageModel = imageList.get(position);
        holder.imageView.setImageBitmap(imageModel.getImage());


    }
    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //id,name,unit,sku,salePrice,qty
        public TextView tvid1,tvname1,tvunit1,tvsku1,tvsalePrice1,tvqty1;
        ImageView imageView;
        View rootView;
        int position;
//        Institute ins;

        public ViewHolder(View itemView)
        {
            //tvid1,tvname1,tvunit1,tvsku1,tvsalePrice1,tvqty1;
            //btnAddTocart123
            super(itemView);
            tvid1= itemView.findViewById(R.id.tvInsid13);
            tvname1 = itemView.findViewById(R.id.tvname123);
            tvunit1 = itemView.findViewById(R.id.tvunit123);
            tvsku1 = itemView.findViewById(R.id.tvsku123);
            tvsalePrice1 = itemView.findViewById(R.id.tvprice123);
            tvqty1 = itemView.findViewById(R.id.tvqty123);//
            imageView= itemView.findViewById(R.id.imageView);

            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                  //  Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnAddTocart123).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid1.getText().toString();


                    Intent intent = new Intent(itemView.getContext(), AddToCart.class);
                    intent.putExtra("instituteName", tvname1.getText().toString());
                    intent.putExtra("Message", "Record is deleted");
                    context.startActivity(intent);

                }


            });

        }

    }
}
