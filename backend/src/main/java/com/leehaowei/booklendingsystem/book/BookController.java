package com.leehaowei.booklendingsystem.book;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Additional CRUD endpoints
    @PostMapping("/api/borrow_book")
    public void borrowBook(@RequestParam Integer bookId, @RequestParam Integer userId, @RequestParam Date borrowDate) {
        bookService.borrowBook(bookId, userId, borrowDate);
    }
}


