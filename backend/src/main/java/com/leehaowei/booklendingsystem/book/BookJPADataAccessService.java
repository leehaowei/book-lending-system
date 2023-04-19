package com.leehaowei.booklendingsystem.book;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa-book")
public class BookJPADataAccessService
    implements BookDao{

    private final BookRepository bookRepository;

    public BookJPADataAccessService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> selectAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> selectBookByISBN(String isbn) {

        // Id here represent the primary key - ISBN
        return bookRepository.findById(isbn);
    }
}
