package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.inventory.Inventory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing_record")
public class BorrowingRecord {

    @EmbeddedId
    private BorrowingRecordId id;

    @ManyToOne
    @MapsId("userId")
    private AppUser user;

    @ManyToOne
    @MapsId("inventoryId")
    private Inventory inventory;

    private LocalDateTime borrowingTime;
    private LocalDateTime returnTime;

    // Constructors, getters, and setters
}

