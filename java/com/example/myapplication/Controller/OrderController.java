package com.example.myapplication.Controller;

import com.example.myapplication.Model.Book;
import com.example.myapplication.Model.BookStore;
import com.example.myapplication.Model.Order;
import com.example.myapplication.Status.BookStatus;
import com.example.myapplication.Status.OrderStatus;

public class OrderController {
    private BookStore bookStore;
    public OrderController(BookStore bookStore){
        this.bookStore=bookStore;
    }

    public void createOrder(Book book, OrderStatus status) {
        if (book.getStatus() == BookStatus.IN_STOCK) {
            Order order=new Order(book, status);
            bookStore.getOrders().add(order);
            System.out.println("Заказ на книгу " + order.getBook().getTitle() + " создан.");
        } else {
            System.out.println("Книга " + book.getTitle() + " недоступна для заказа.");
        }
    }

    public void updateStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        System.out.println("Статус заказа на книгу " + order.getBook().getTitle() + " изменен на " + status + ".");
    }

    public void cancelOrder(Order order) {
        bookStore.getOrders().remove(order);
        System.out.println("Заказ на книгу " + order.getBook().getTitle() + " отменен.");
    }
}
