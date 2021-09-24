package com.example.gift_tracker;

import android.content.Context;
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
            giftName = itemView.findViewById(R.id.textListItem1);
            giftDescription = itemView.findViewById(R.id.textListItem1);
            layout = itemView;
        }
    }

    public GiftRecyclerAdapter







    @NonNull
    @Override
    public GiftRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GiftRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
