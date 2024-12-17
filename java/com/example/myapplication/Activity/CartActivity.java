package com.example.myapplication.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.BookAdapter;
import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.Model.Item.CartItem;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCart;
    private CartAdapter cartAdapter;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerViewCart = findViewById(R.id.recyclerViewCart);
        checkoutButton = findViewById(R.id.btn_checkout);

        // Создайте список для корзины
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Product 1", 19.99));
        cartItems.add(new CartItem("Product 2", 29.99));
        cartItems.add(new CartItem("Product 3", 15.99));

        // Установите адаптер для RecyclerView
        cartAdapter = new CartAdapter(cartItems);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(cartAdapter);

        // Обработчик нажатия на кнопку оформления заказа
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Логика оформления заказа
                // Например, можно показать сообщение или начать новую активность
                // Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                // startActivity(intent);
            }
        });
    }
}



