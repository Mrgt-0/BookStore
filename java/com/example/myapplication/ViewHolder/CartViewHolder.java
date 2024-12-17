package com.example.myapplication.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CartViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView priceTextView;

    public CartViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.item_title);
        priceTextView = itemView.findViewById(R.id.item_price);
    }
}
