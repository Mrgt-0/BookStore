package com.example.myapplication.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ProfileViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView valueTextView;

    public ProfileViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.profile_title);
        valueTextView = itemView.findViewById(R.id.profile_value);
    }
}
