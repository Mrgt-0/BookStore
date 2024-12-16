package com.example.myapplication.Dao;

import com.example.myapplication.Model.Book;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID>{
    T create(T entity);
    Class<T> getEntityClass();
    Optional<T> getById(ID id);
    List<T> getAll();
    T update(T entity);
    void delete(Optional<Book> entity);
}
