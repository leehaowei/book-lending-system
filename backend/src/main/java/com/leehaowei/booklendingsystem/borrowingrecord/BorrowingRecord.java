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
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @MapsId("userId")
    private AppUser user;

    @ManyToOne
    @MapsId("inventoryId")
    @JoinColumn(name = "inventory_id", insertable = false, updatable = false)
    private Inventory inventory;

    private LocalDateTime borrowingTime;
    private LocalDateTime returnTime;

    // Constructors, getters, and setters
}

