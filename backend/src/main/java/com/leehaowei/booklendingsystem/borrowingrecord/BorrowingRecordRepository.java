package com.leehaowei.booklendingsystem.borrowingrecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository
        extends JpaRepository<BorrowingRecord, BorrowingRecordId> {
}
