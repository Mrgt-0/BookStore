package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.BookAdapter;
import com.example.myapplication.Model.Book;
import com.example.myapplication.Status.BookStatus;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;
    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Создание списка книг
        books = new ArrayList<>();
        addSampleBooks(); // Вызов метода для добавления книг

        // Инициализация адаптера
        bookAdapter = new BookAdapter(books, this);
        recyclerView.setAdapter(bookAdapter);
    }

    private void addSampleBooks() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            books.add(new Book("Гарри Поттер и философский камень", "Джоан Роулинг", BookStatus.IN_STOCK,
                    LocalDate.of(1997 , 6, 26), 500.0, "Первый роман о юном волшебнике Гарри Поттере.", R.drawable.harry_potter_book));
            books.add(new Book("Властелин колец: Братство кольца", "Дж. Р. Р. Толкин", BookStatus.OUT_OF_STOCK,
                    LocalDate.of(1954 , 7, 29), 600.0, "Первый том великой трилогии о Средиземье.", R.drawable.lord_of_the_rings));
            books.add(new Book("1984", "Джордж Оруэлл",BookStatus.IN_STOCK,
                    LocalDate.of(1948, 10, 15), 450.0, "Антиутопический роман о тоталитарном обществе будущего.", R.drawable.book1984));
            books.add(new Book("Убийство в Восточном экспрессе", "Агата Кристи", BookStatus.IN_STOCK, LocalDate.of(1934, 1, 1),
                    400.0, "Детективный роман о расследовании убийства на поезде.", R.drawable.cover_murder_on_the_orient_expres));
            books.add(new Book("Алхимик", "Паула Коэльо", BookStatus.OUT_OF_STOCK, LocalDate.of(1988, 5, 16),
                    350.0, "Поучительная история о поисках своего личного назначения.", R.drawable.cover_alchemist));
        }
    }
}