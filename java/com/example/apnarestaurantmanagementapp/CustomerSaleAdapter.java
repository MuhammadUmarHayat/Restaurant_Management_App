package com.example.apnarestaurantmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerSaleAdapter extends RecyclerView.Adapter<CustomerSaleAdapter.ViewHolder>
{

    private Context context;
    private ArrayList id,customerName,productname,price,qty,total;

    public CustomerSaleAdapter(Context context, ArrayList id, ArrayList customerName, ArrayList productname, ArrayList price, ArrayList qty, ArrayList total)
    {
        this.context = context;
        this.id = id;
        this.customerName = customerName;
        this.productname = productname;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }

    public CustomerSaleAdapter(Context context, ArrayList customerName, ArrayList productname, ArrayList price, ArrayList qty, ArrayList total)
    {
        this.context = context;
        this.customerName = customerName;
        this.productname = productname;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }
    @NonNull
    @Override
    public CustomerSaleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_sale_layout, parent, false);
        return new CustomerSaleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerSaleAdapter.ViewHolder holder, int position) {
        //id,name,unit,sku,salePrice,qty;
       // TextView tvsaleCusName1,tvSalePName1,tvSalePPrice1,tvSalePQty1,tvSaleTotal1,tvid;
        holder.tvid.setText(String.valueOf(id.get(position)));
        holder.tvsaleCusName1.setText(String.valueOf(customerName.get(position)));
        holder.tvSalePName1.setText(String.valueOf(productname.get(position)));
        holder.tvSalePPrice1.setText(String.valueOf(price.get(position)));
        holder.tvSalePQty1.setText(String.valueOf(qty.get(position)));
        holder.tvSaleTotal1.setText(String.valueOf(total.get(position)));


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvsaleCusName1,tvSalePName1,tvSalePPrice1,tvSalePQty1,tvSaleTotal1,tvid;
        View rootView;
        int position;
        // Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
//tvsaleCusName1,tvSalePName1,tvSalePPrice1,tvSalePQty1,tvSaleTotal1,tvProductIDSale11;
            //id,name,unit,sku,salePrice,qty
            tvsaleCusName1= itemView.findViewById(R.id.tvsaleCusName);
            tvSalePName1 = itemView.findViewById(R.id.tvSalePName);
            tvSalePPrice1 = itemView.findViewById(R.id.tvSalePPrice);
            tvSalePQty1 = itemView.findViewById(R.id.tvSalePQty);
            tvSaleTotal1 = itemView.findViewById(R.id.tvSaleTotal);
            tvid = itemView.findViewById(R.id.tvProductIDSale1);

            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    //Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnDeleteSale).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid.getText().toString();
                    MyDatabase db =new MyDatabase(itemView.getContext()) ;
                    db.delete("sales","id",id);


    Intent intent = new Intent(itemView.getContext(), DeleteSaleItems.class);

                   context.startActivity(intent);
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();


                }


            });
            itemView.findViewById(R.id.btnEditSale).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid.getText().toString();

                    Intent intent = new Intent(itemView.getContext(), EditSale.class);
                    intent.putExtra("saleid", id);
                    context.startActivity(intent);




                }


            });

        }
    }
}
