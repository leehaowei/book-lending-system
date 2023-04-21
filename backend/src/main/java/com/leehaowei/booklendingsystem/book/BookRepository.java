package com.leehaowei.booklendingsystem.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BookRepository
        extends JpaRepository<Book, String> {

    @Procedure("borrow_book")
    void borrowBook(@Param("p_book_id") Integer bookId,
                    @Param("p_user_id") Integer userId,
                    @Param("p_borrow_date") Date borrowDate);

}
