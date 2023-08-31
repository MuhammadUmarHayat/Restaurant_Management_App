package com.example.apnarestaurantmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder>
{
    //String name,category,subcategory,brand,sku,supplier,unit,purchasePrice,salePrice,qty,status,purchasing_Date;
    private Context context;
    private ArrayList id,name,unit,sku,salePrice,qty;


    public AllProductsAdapter()
    {

    }
    //String name,category,subcategory,brand,sku,supplier,unit,purchasePrice,salePrice,qty,status,purchasing_Date;


    public AllProductsAdapter(Context context, ArrayList id, ArrayList name, ArrayList unit, ArrayList sku, ArrayList salePrice, ArrayList qty)
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_products_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //id,name,unit,sku,salePrice,qty;
        holder.tvid.setText(String.valueOf(id.get(position)));
        holder.tvname.setText(String.valueOf(name.get(position)));
        holder.tvunit.setText(String.valueOf(unit.get(position)));
        holder.tvsku.setText(String.valueOf(sku.get(position)));
        holder.tvsalePrice.setText(String.valueOf(salePrice.get(position)));
        holder.tvqty.setText(String.valueOf(qty.get(position)));


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvid,tvname,tvunit,tvsku,tvsalePrice,tvqty;
        View rootView;
        int position;
        // Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
            //tvProductIDAll,
            //btnDeletePrdAll,tvPQtyAll,tvSale,tvPSKUAll,tvPUnitAll,tvPNameListAll
            //id,name,unit,sku,salePrice,qty
            tvname= itemView.findViewById(R.id.tvPNameListAll);
            tvunit = itemView.findViewById(R.id.tvPUnitAll);
            tvsku = itemView.findViewById(R.id.tvPSKUAll);
            tvsalePrice = itemView.findViewById(R.id.tvSale);
            tvqty = itemView.findViewById(R.id.tvPQtyAll);
            tvid = itemView.findViewById(R.id.tvProductIDAll);

            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnDeletePrdAll).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid.getText().toString();
                    MyDatabase db =new MyDatabase(itemView.getContext()) ;
                    db.delete("products","id",id);


//                    Intent intent = new Intent(itemView.getContext(), AllProductsAdapter.class);
//
//                    context.startActivity(intent);
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();


                }


            });


        }
    }
}
