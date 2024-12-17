package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Item.OrderItem;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.OrderViewHolder;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrderViewHolder>{
    private List<OrderItem> orders;

    public OrdersAdapter(List<OrderItem> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderItem order = orders.get(position);
        holder.orderIdTextView.setText(order.getOrderId());
        holder.dateTextView.setText(order.getDate());
        holder.totalTextView.setText(String.format("$%.2f", order.getTotal()));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}