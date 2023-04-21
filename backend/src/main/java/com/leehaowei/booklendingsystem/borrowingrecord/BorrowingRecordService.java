package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.appuser.AppUserDao;
import com.leehaowei.booklendingsystem.appuser.AppUserRepository;
import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import com.leehaowei.booklendingsystem.inventory.Inventory;
import com.leehaowei.booklendingsystem.inventory.InventoryDao;
import com.leehaowei.booklendingsystem.inventory.InventoryRepository;
import com.leehaowei.booklendingsystem.inventory.InventoryStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowingRecordService {

    private final BorrowingRecordDao recordDao;
    private final AppUserDao userDao;
    private final InventoryDao inventoryDao;

    public BorrowingRecordService(@Qualifier("jpa-record") BorrowingRecordDao recordDao,
                                  @Qualifier("jdbc") AppUserDao userDao,
                                  @Qualifier("jdbc-inventory") InventoryDao inventoryDao) {
        this.recordDao = recordDao;
        this.userDao = userDao;
        this.inventoryDao = inventoryDao;
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
    public void addRecord(BorrowBookRequest borrowRequest) {
        // Fetch the AppUser and Inventory objects from the database
        System.out.println("KKKKKKK");
        System.out.println(borrowRequest.userId());
        System.out.println(borrowRequest.inventoryId());
        System.out.println(userDao.selectUserById(borrowRequest.userId()));
        System.out.println(inventoryDao.selectInventoryById(borrowRequest.inventoryId()));
        System.out.println("KKKKKKK");
        AppUser user = userDao.selectUserById(borrowRequest.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Inventory inventory = inventoryDao.selectInventoryById(borrowRequest.inventoryId())
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        System.out.println("AAAAAAA");
        // Create a new BorrowingRecord object
        BorrowingRecord record = new BorrowingRecord(user, inventory);
        System.out.println("BBBBBBB");
        // Save the BorrowingRecord object to the database
        recordDao.insertRecord(record);
    }
}
