package com.example.myapplication.Model.Item;

public class OrderItem {
    private String orderId;
    private String date;
    private double total;

    public OrderItem(String orderId, String date, double total) {
        this.orderId = orderId;
        this.date = date;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }
}
