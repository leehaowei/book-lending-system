package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import com.leehaowei.booklendingsystem.inventory.Inventory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingRecordService {

    private final BorrowingRecordDao recordDao;

    public BorrowingRecordService(@Qualifier("jpa-record")BorrowingRecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<BorrowingRecord> getAllRecords() {

        return recordDao.selectAllRecord();
    }

    public BorrowingRecord getRecord(Integer userId, Integer inventoryId) {
        return recordDao.selectRecordById(userId, inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "borrowing record with user id [%s] and inventory id [%s] not found"
                                .formatted(userId, inventoryId)
                ));
    }
    // Additional CRUD methods as needed


}
