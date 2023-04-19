package com.leehaowei.booklendingsystem.book;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    private String isbn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    private String introduction;

    public Book() {
    }
}
