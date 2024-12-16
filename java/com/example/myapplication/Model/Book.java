package com.example.myapplication.Model;

import com.example.myapplication.Status.BookStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{

    private int bookId;
    private static int idIncrement=0;
    private String title;
    private String author;
    private BookStatus status;
    private String publishDate;
    private double price;
    private String description;
    private int imageId;

    public Book(String title, String author, BookStatus status, String publishDate, double price, String desctiption, int imageId) {
        this.title = title;
        this.author=author;
        this.status = status;
        this.publishDate=publishDate;
        this.price=price;
        this.description=desctiption;
        this.imageId=imageId;
        this.bookId=++idIncrement;
    }

    public int getBookId(){
        return bookId;
    }

    public void setBookId(int bookId){
        this.bookId=bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getPublishDate(){
        return publishDate;
    }

    public double getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public int getImageId() { return imageId; }

    public void setImageId(int imageId) { this.imageId = imageId; }

    @Override
    public String toString(){
        return "Книга{" +
                "Название='" + title + '\'' +
                ", статус=" + status +
                ", дата публикации=" + publishDate +
                ", цена=" + price +
                '}';
    }
}
