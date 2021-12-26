package com.example.retrofitapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Data> data;
    ArrayList<Integer>index;
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_profile
        ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
            /*if(index.size()>0) {
                for(int i=0;i<index.size();i++) {
                    holder.name.setText("Name : " + data.get(index.get(i)).getUserName());
                    holder.name.setTextColor(Color.RED);
                    holder.email.setText("Email : " + data.get(index.get(i)).getUserMail());
                    holder.email.setTextColor(Color.RED);
                    holder.Tel.setText("number Tel :" + data.get(index.get(i)).getNumberTel());
                    holder.Tel.setTextColor(Color.RED);
                }
            }else {*/
                holder.name.setText("Name :" + data.get(position).getUserName());
                holder.name.setTextColor(Color.RED);
                holder.email.setText("Email : " + data.get(position).getUserMail());
                holder.email.setTextColor(Color.RED);
                holder.Tel.setText("number Tel :" + data.get(position).getNumberTel());
                holder.Tel.setTextColor(Color.RED);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , email , Tel ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            Tel = itemView.findViewById(R.id.Telephone_Number);
        }
    }

    public void   setList(ArrayList<Data> data ) {
        this.data = data;
    }
}
