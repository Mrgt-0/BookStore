package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Controller.BookStoreController;
import com.example.myapplication.Model.Book;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.*;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{
    private List<Book> books;
    private Context context;
    private BookStoreController bookStoreController;

    public BookAdapter(List<Book> books, Context context, BookStoreController bookStoreController) {
        this.books = books;
        this.context = context;
        this.bookStoreController=bookStoreController;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.getBookTitle().setText(book.getTitle());
        holder.getBookAuthor().setText("Автор: " + book.getAuthor());
        holder.getBookDescription().setText(book.getDescription());
        holder.getBookPrice().setText("Цена: " + book.getPrice() + " руб.");
        holder.getBookImage().setImageResource(book.getImageId());

        holder.buttonAddToCart.setOnClickListener(v -> {
            bookStoreController.addBook(book);
            Toast.makeText(context, "Книга добавлена в корзину", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
