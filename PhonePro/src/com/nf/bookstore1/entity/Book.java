package com.nf.bookstore1.entity;

public class Book {

    private int id;
    private String name;
    private float price;
    private String author;
    private String press;

    public Book() {
    }

    public Book(String name, float price, String author, String press) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.press = press;
    }

    public Book(int id, String name, float price, String author, String press) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
