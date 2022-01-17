package com.keum.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {
    private int bookid;
    private String bookname;
    private String publisher;
    private int price;

    public Book() {}

    public Book(String bookname, String publisher, int price) {
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
    }
}
