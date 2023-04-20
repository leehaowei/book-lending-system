package com.leehaowei.booklendingsystem.inventory;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa-inventory")
public class InventoryJPADataAccessService
        implements InventoryDao {

    private final InventoryRepository inventoryRepository;

    public InventoryJPADataAccessService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> selectAllInventory() {

        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> selectInventoryById(Integer id) {

        return inventoryRepository.findById(id);
    }
}
