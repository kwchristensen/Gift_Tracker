package com.example.gift_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipientRecyclerAdapter extends RecyclerView.Adapter<RecipientRecyclerAdapter.ViewHolder> {

    private ArrayList<Recipient> recipientList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipientName;
        View layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipientName = itemView.findViewById(R.id.tvRecipientName);
            layout = itemView;
        }
    }

    public RecipientRecyclerAdapter(ArrayList<Recipient> recipientList, Context context) {
        this.recipientList = recipientList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipient_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recipientName.setText(recipientList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return recipientList.size();
    }

    /*public void addNewRecipient(ArrayList<Recipient> arrayList) {

    }*/
}
