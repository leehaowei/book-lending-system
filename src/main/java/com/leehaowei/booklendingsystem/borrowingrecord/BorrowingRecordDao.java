package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.book.Book;

import java.util.List;
import java.util.Optional;

public interface BorrowingRecordDao {
    List<BorrowingRecord> selectAllRecord();
    Optional<BorrowingRecord> selectRecordById(Integer userId, Integer inventoryId);
}
