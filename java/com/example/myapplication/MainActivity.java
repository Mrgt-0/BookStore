package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Activity.*;
import com.example.myapplication.Adapter.*;
import com.example.myapplication.Controller.*;
import com.example.myapplication.Model.*;
import com.example.myapplication.Status.BookStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> books;
    private BookStore bookStore = new BookStore();
    private OrderController orderController = new OrderController(bookStore);
    private BookStoreController bookStoreController = new BookStoreController(bookStore, orderController);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_secondary);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        books = new ArrayList<>();
        addSampleBooks();

        bookAdapter = new BookAdapter(books, this, bookStoreController);
        recyclerView.setAdapter(bookAdapter);
    }

    private void addSampleBooks() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            books.add(new Book("Гарри Поттер и философский камень", "Джоан Роулинг", BookStatus.IN_STOCK,
                    LocalDate.of(1997, 6, 26), 500.0, "Первый роман о юном волшебнике Гарри Поттере.", R.drawable.harry_potter_book));
            books.add(new Book("Властелин колец: Братство кольца", "Дж. Р. Р. Толкин", BookStatus.OUT_OF_STOCK,
                    LocalDate.of(1954, 7, 29), 600.0, "Первый том великой трилогии о Средиземье.", R.drawable.lord_of_the_rings));
            books.add(new Book("1984", "Джордж Оруэлл", BookStatus.IN_STOCK,
                    LocalDate.of(1948, 10, 15), 450.0, "Антиутопический роман о тоталитарном обществе будущего.", R.drawable.book1984));
            books.add(new Book("Убийство в Восточном экспрессе", "Агата Кристи", BookStatus.IN_STOCK, LocalDate.of(1934, 1, 1),
                    400.0, "Детективный роман о расследовании убийства на поезде.", R.drawable.cover_murder_on_the_orient_expres));
            books.add(new Book("Алхимик", "Паула Коэльо", BookStatus.OUT_OF_STOCK, LocalDate.of(1988, 5, 16),
                    350.0, "Поучительная история о поисках своего личного назначения.", R.drawable.cover_alchemist));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {
            startActivity(new Intent(this, CartActivity.class));
            return true;
        } else if (id == R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
            return true;
        } else if (id == R.id.action_orders) {
            startActivity(new Intent(this, OrdersActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}