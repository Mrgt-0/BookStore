package com.example.myapplication.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.OrdersAdapter;
import com.example.myapplication.Model.Item.OrderItem;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {
    private RecyclerView recyclerViewOrders;
    private OrdersAdapter ordersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        recyclerViewOrders = findViewById(R.id.recyclerViewOrders);

        List<OrderItem> orders = new ArrayList<>();
        orders.add(new OrderItem("Order 1", "01-01-2023", 49.99));
        orders.add(new OrderItem("Order 2", "02-02-2023", 75.99));
        orders.add(new OrderItem("Order 3", "03-03-2023", 25.50));

        ordersAdapter = new OrdersAdapter(orders);
        recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewOrders.setAdapter(ordersAdapter);
    }
}
