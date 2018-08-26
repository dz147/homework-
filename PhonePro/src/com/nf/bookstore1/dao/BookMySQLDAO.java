package com.nf.bookstore1.dao;

import com.nf.bookstore1.entity.Book;

import java.util.List;

public class BookMySQLDAO implements BookDAO {
    @Override
    public List<Book> listAll() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return null;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Book add(Book book) {
        return null;
    }
}
