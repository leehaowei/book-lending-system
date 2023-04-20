package com.leehaowei.booklendingsystem.book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> selectAllBook();
    Optional<Book> selectBookByISBN(String isbn);
}
