package com.example.apnarestaurantmanagementapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllExpenseAdapter extends RecyclerView.Adapter<AllExpenseAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id, category, title, description, doe, total;
    // category, title, description,String doe, total;


    public AllExpenseAdapter()
    {
    }

    public AllExpenseAdapter(Context context, ArrayList id, ArrayList category, ArrayList title, ArrayList description, ArrayList doe, ArrayList total)
    {
        this.context = context;
        this.id = id;
        this.category = category;
        this.title = title;
        this.description = description;
        this.doe = doe;
        this.total = total;
    }

    public AllExpenseAdapter(Context context, ArrayList category, ArrayList title, ArrayList description, ArrayList doe, ArrayList total) {
        this.context = context;
        this.category = category;
        this.title = title;
        this.description = description;
        this.doe = doe;
        this.total = total;
    }
    @NonNull
    @Override
    public AllExpenseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_expenses_layout, parent, false);
        return new AllExpenseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllExpenseAdapter.ViewHolder holder, int position) {
       // tvExpNamelist1,tvExpDescriptionList1,tvExpListPrice1,tvExpListDOE1,tvExpListid1,tvExpListCat1;

       // id, category, title, description, doe, total;
        holder.tvExpListid1.setText(String.valueOf(id.get(position)));
        holder.tvExpListCat1.setText(String.valueOf(category.get(position)));
        holder.tvExpNamelist1.setText(String.valueOf(title.get(position)));
        holder.tvExpDescriptionList1.setText(String.valueOf(description.get(position)));
        holder.tvExpListPrice1.setText(String.valueOf(doe.get(position)));
        holder.tvExpListDOE1.setText(String.valueOf(total.get(position)));



    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvExpNamelist1,tvExpDescriptionList1,tvExpListPrice1,tvExpListDOE1,tvExpListid1,tvExpListCat1;
        View rootView;
        int position;
        // Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
            //tvProductIDAll,
            //btnDeletePrdAll,tvPQtyAll,tvSale,tvPSKUAll,tvPUnitAll,tvPNameListAll
            //id,name,unit,sku,salePrice,qty
            tvExpListid1= itemView.findViewById(R.id.tvExpListid);
            tvExpNamelist1 = itemView.findViewById(R.id.tvExpNamelist);
            tvExpDescriptionList1 = itemView.findViewById(R.id.tvExpDescriptionList);
            tvExpListPrice1 = itemView.findViewById(R.id.tvExpListPrice);
            tvExpListDOE1 = itemView.findViewById(R.id.tvExpListDOE);
            tvExpListCat1 = itemView.findViewById(R.id.tvExpListCat);

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
