package com.example.gift_tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipientRecyclerAdapter extends RecyclerView.Adapter<RecipientRecyclerAdapter.ViewHolder> {

    private ArrayList<Recipient> recipientList;
    private Context context;

    public RecipientRecyclerAdapter(ArrayList<Recipient> recipientList, Context context) {
        this.recipientList = recipientList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
     ViewHolder holder = new ViewHolder(view);
     return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.recipientName.setText((CharSequence) recipientList.get(position));
    }

    @Override
    public int getItemCount() {
        return recipientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipientName;
        //RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipientName = itemView.findViewById(R.id.textListItem1);
            //layout = itemView.findViewById(R.id.recyclerLayout);
        }
    }
}
