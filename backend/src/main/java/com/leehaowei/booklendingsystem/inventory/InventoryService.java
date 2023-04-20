package com.leehaowei.booklendingsystem.inventory;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryDao inventoryDao;

    public InventoryService(@Qualifier("jpa-inventory") InventoryDao inventoryDao) {

        this.inventoryDao = inventoryDao;
    }

    public List<Inventory> getAllInventories() {

        return inventoryDao.selectAllInventory();
    }

    public Inventory getInventory(Integer id) {
        return inventoryDao.selectInventoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "inventory with id [%s] not found".formatted(id)
                ));
    }
    // Additional CRUD methods as needed
}
