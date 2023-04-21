package com.leehaowei.booklendingsystem.borrowingrecord;

import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.inventory.Inventory;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "borrowing_record")
public class BorrowingRecord {

    @EmbeddedId
    private BorrowingRecordId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private AppUser user;

    @ManyToOne
    @MapsId("inventoryId")
    @JoinColumn(name = "inventory_id", insertable = false, updatable = false)
    private Inventory inventory;

    private LocalDateTime borrowingTime;
    private LocalDateTime returnTime;

    // Constructors, getters, and setters
    public BorrowingRecord() {
    }

    public BorrowingRecord(AppUser user, Inventory inventory) {
        this.user = user;
        this.inventory = inventory;
    }

    public BorrowingRecord(BorrowingRecordId id, AppUser user, Inventory inventory) {
        this.id = id;
        this.user = user;
        this.inventory = inventory;
    }

    public BorrowingRecord(BorrowingRecordId id, AppUser user, Inventory inventory, LocalDateTime borrowingTime, LocalDateTime returnTime) {
        this.id = id;
        this.user = user;
        this.inventory = inventory;
        this.borrowingTime = borrowingTime;
        this.returnTime = returnTime;
    }

    public BorrowingRecordId getId() {
        return id;
    }

    public void setId(BorrowingRecordId id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public LocalDateTime getBorrowingTime() {
        return borrowingTime;
    }

    public void setBorrowingTime(LocalDateTime borrowingTime) {
        this.borrowingTime = borrowingTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowingRecord record = (BorrowingRecord) o;
        return Objects.equals(id, record.id) && Objects.equals(user, record.user) && Objects.equals(inventory, record.inventory) && Objects.equals(borrowingTime, record.borrowingTime) && Objects.equals(returnTime, record.returnTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, inventory, borrowingTime, returnTime);
    }
}

