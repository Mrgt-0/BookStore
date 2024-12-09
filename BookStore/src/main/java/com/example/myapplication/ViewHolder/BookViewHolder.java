package com.example.myapplication.ViewHolder;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private TextView bookTitle;
    private TextView bookAuthor;
    private TextView bookDescription;
    private TextView bookPrice;
    private ImageView bookImage;
    private Button buttonAddToCart;

    public TextView getBookTitle() { return bookTitle; }

    public TextView getBookAuthor() { return bookAuthor; }

    public TextView getBookDescription() { return bookDescription; }

    public TextView getBookPrice() { return bookPrice; }

    public ImageView getBookImage() { return bookImage; }

    @SuppressLint("WrongViewCast")
    public BookViewHolder(View itemView) {
        super(itemView);
        bookTitle = itemView.findViewById(R.id.bookTitle);
        bookAuthor = itemView.findViewById(R.id.bookAuthor);
        bookDescription = itemView.findViewById(R.id.bookDescription);
        bookPrice = itemView.findViewById(R.id.bookPrice);
        bookImage=itemView.findViewById(R.id.bookImage);
       //buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);
    }
}
