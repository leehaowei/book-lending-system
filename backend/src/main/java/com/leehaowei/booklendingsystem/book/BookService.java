package com.leehaowei.booklendingsystem.book;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;
    private BookRepository bookRepository;


    public BookService(@Qualifier("jpa-book")BookDao bookDao) {

        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAllBook();
    }

    public Book getBook(String isbn) {
        return bookDao.selectBookByISBN(isbn)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "book with ISBN [%s] not found".formatted(isbn)
                ));
    }
    // Additional CRUD methods as needed
    public void borrowBook(Integer bookId, Integer userId, Date borrowDate) {
        bookRepository.borrowBook(bookId, userId, borrowDate);
    }
}





