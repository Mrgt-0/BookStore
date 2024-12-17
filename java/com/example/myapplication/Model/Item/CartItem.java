package com.example.myapplication.Model.Item;

public class CartItem {
    private String title;
    private double price;

    public CartItem(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
