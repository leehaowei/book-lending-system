package com.leehaowei.booklendingsystem.inventory;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    @SequenceGenerator(
            name = "inventory_inventory_id_seq",
            sequenceName = "inventory_inventory_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_inventory_id_seq"
    )
    private Integer inventoryId;

    @Column(nullable = false)
    private String isbn;

    @Column(name = "store_time", nullable = false)
    private LocalDateTime storeTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InventoryStatus status;

    public Inventory() {
    }

    public Inventory(Integer inventoryId, String isbn, LocalDateTime storeTime, InventoryStatus status) {
        this.inventoryId = inventoryId;
        this.isbn = isbn;
        this.storeTime = storeTime;
        this.status = status;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(LocalDateTime storeTime) {
        this.storeTime = storeTime;
    }

    public InventoryStatus getStatus() {
        return status;
    }

    public void setStatus(InventoryStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) && Objects.equals(isbn, inventory.isbn) && Objects.equals(storeTime, inventory.storeTime) && status == inventory.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, isbn, storeTime, status);
    }
}
