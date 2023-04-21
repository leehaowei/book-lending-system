package com.leehaowei.booklendingsystem.book;

import jakarta.persistence.*;

import java.util.Objects;

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

    public Book(String isbn, String name, String author, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(introduction, book.introduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name, author, introduction);
    }
}
