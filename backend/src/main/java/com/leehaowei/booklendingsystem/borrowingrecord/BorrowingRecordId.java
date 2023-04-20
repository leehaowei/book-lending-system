package com.leehaowei.booklendingsystem.borrowingrecord;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BorrowingRecordId implements Serializable {

    private Integer userId;
    private Integer inventoryId;

    // Constructors
    public BorrowingRecordId() {
    }

    public BorrowingRecordId(Integer userId, Integer inventoryId) {
        this.userId = userId;
        this.inventoryId = inventoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowingRecordId that = (BorrowingRecordId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(inventoryId, that.inventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, inventoryId);
    }
}

