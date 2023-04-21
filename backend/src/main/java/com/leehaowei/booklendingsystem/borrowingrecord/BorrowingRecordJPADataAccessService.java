package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.book.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa-record")
public class BorrowingRecordJPADataAccessService
        implements BorrowingRecordDao{

    private final BorrowingRecordRepository recordRepository;

    public BorrowingRecordJPADataAccessService(BorrowingRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<BorrowingRecord> selectAllRecord() {
        return recordRepository.findAll();
    }

    @Override
    public Optional<BorrowingRecord> selectRecordById(Integer userId, Integer inventoryId) {
        BorrowingRecordId recordId = new BorrowingRecordId(userId, inventoryId);
        return recordRepository.findById(recordId);
    }

    @Override
    public void insertRecord(BorrowingRecord record) {
        recordRepository.save(record);
    }
}
