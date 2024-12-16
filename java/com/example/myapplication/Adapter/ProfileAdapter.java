package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Item.ProfileItem;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.ProfileViewHolder;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    private List<ProfileItem> profileItems;

    public ProfileAdapter(List<ProfileItem> profileItems) {
        this.profileItems = profileItems;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ProfileItem item = profileItems.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.valueTextView.setText(item.getValue());
    }

    @Override
    public int getItemCount() {
        return profileItems.size();
    }
}
