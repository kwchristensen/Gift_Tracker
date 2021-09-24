package com.example.gift_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GiftRecyclerAdapter extends RecyclerView.Adapter<GiftRecyclerAdapter.ViewHolder> {

    private ArrayList<Gift> giftArrayList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView giftName;
        TextView giftDescription;
        View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            giftName = itemView.findViewById(R.id.tvGiftName);
            giftDescription = itemView.findViewById(R.id.tvGiftDescription);
            layout = itemView;
        }
    }

    public GiftRecyclerAdapter(ArrayList<Gift> list, Context passedContext) {
        this.giftArrayList = list;
        this.context = passedContext;
    }


    @NonNull
    @Override
    public GiftRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gift_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GiftRecyclerAdapter.ViewHolder holder, int position) {
        holder.giftName.setText(giftArrayList.get(position).getName());
        holder.giftDescription.setText(giftArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return giftArrayList.size();
    }
}
