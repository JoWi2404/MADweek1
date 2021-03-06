package com.example.app;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.detail;

public class adapter extends RecyclerView.Adapter<adapter.ListViewHolder> {

    private ArrayList<detail> listdetail = new ArrayList<>();

    public adapter(ArrayList<detail> listdetail) {
        this.listdetail = listdetail;
    }


    @NonNull
    @Override
    public adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ListViewHolder holder, int position) {
        holder.name.setText(listdetail.get(position).getName());
        holder.age.setText(String.valueOf(listdetail.get(position).getAge()));
        holder.address.setText(listdetail.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return listdetail.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView name, age, address;
        private CardView cardview;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
           // cardview = itemView.findViewById(R.id.cardview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),userdetail.class);
//                    String n = listdetail.get(getAdapterPosition()).getName();
//                    int a = listdetail.get(getAdapterPosition()).getAge();
//                    int an = Integer.parseInt(a);
//                    String ad = listdetail.get(getAdapterPosition()).getAddress();
//                    detail d = new detail(n, a,ad);
//                    intent.putExtra("detail", d);
                    intent.putExtra("index", getAdapterPosition());
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}
