package com.leehaowei.booklendingsystem.borrowingrecord;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

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
}

