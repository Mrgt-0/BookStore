package com.example.myapplication.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

public class OrderViewHolder extends RecyclerView.ViewHolder {
    public TextView orderIdTextView;
    public TextView dateTextView;
    public TextView totalTextView;

    public OrderViewHolder(View itemView) {
        super(itemView);
        orderIdTextView = itemView.findViewById(R.id.order_id);
        dateTextView = itemView.findViewById(R.id.order_date);
        totalTextView = itemView.findViewById(R.id.order_total);
    }
}
