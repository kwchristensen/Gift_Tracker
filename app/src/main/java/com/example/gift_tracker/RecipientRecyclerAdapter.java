package com.example.gift_tracker;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipientRecyclerAdapter extends RecyclerView.Adapter {

    private List<Recipient> recipientList;
    private int rowLayout;

    public RecipientRecyclerAdapter(List<Recipient> rList, int layout) {
        this.recipientList = rList;
        this.rowLayout = layout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.recipientList.size();
    }
}
