package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Item.CartItem;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.CartViewHolder;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private List<CartItem> cartItems;

    public CartAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.priceTextView.setText(String.format("$%.2f", item.getPrice()));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
