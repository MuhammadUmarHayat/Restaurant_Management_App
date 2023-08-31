package com.example.apnarestaurantmanagementapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllOrdersAdapter extends RecyclerView.Adapter<AllOrdersAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id,orderNo,customerName,productname,price,qty,total;

    public AllOrdersAdapter(Context context, ArrayList id, ArrayList orderNo, ArrayList customerName, ArrayList productname, ArrayList price, ArrayList qty, ArrayList total)
    {
        this.context = context;
        this.id = id;
        this.orderNo = orderNo;
        this.customerName = customerName;
        this.productname = productname;
        this.price = price;
        this.qty = qty;
        this.total = total;
    }
    @NonNull
    @Override
    public AllOrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_orders_layout, parent, false);
        return new AllOrdersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllOrdersAdapter.ViewHolder holder, int position) {
       // tvOrderId1,tvOrderorderNo1,tvOrdercustomerName1,tvOrderproductname1,
        //tvOrdersPrice1,tvOrdersListQty1,tvOrdersListTotal1

        // id,orderNo,customerName,productname,price,qty,total;
        holder.tvOrderId1.setText(String.valueOf(id.get(position)));
        holder.tvOrderorderNo1.setText(String.valueOf(orderNo.get(position)));
        holder.tvOrdercustomerName1.setText(String.valueOf(customerName.get(position)));
        holder.tvOrderproductname1.setText(String.valueOf(productname.get(position)));
        holder.tvOrdersPrice1.setText(String.valueOf(price.get(position)));
        holder.tvOrdersListQty1.setText(String.valueOf(qty.get(position)));
        holder.tvOrdersListTotal1.setText(String.valueOf(total.get(position)));



    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvOrderId1,tvOrderorderNo1,tvOrdercustomerName1,tvOrderproductname1;
        private TextView tvOrdersPrice1,tvOrdersListQty1,tvOrdersListTotal1;

        View rootView;
        int position;
        // Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);


          //  private TextView tvOrderId1,tvOrderorderNo1,tvOrdercustomerName1,tvOrderproductname1;
           // private TextView tvOrdersPrice1,tvOrdersListQty1,tvOrdersListTotal1;
            tvOrderId1= itemView.findViewById(R.id.tvOrderId);
            tvOrderorderNo1 = itemView.findViewById(R.id.tvOrderorderNo);
            tvOrdercustomerName1 = itemView.findViewById(R.id.tvOrdercustomerName);
            tvOrderproductname1 = itemView.findViewById(R.id.tvOrderproductname);
            tvOrdersPrice1 = itemView.findViewById(R.id.tvOrdersPrice);
            tvOrdersListQty1 = itemView.findViewById(R.id.tvOrdersListQty);
            tvOrdersListTotal1= itemView.findViewById(R.id.tvOrdersListTotal);

            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });



        }
    }
}
