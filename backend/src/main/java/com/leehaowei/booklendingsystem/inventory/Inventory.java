package com.leehaowei.booklendingsystem.inventory;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
}
