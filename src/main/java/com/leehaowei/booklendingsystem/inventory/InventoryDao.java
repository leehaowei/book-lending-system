package com.leehaowei.booklendingsystem.inventory;

import com.leehaowei.booklendingsystem.appuser.AppUser;

import java.util.List;
import java.util.Optional;

public interface InventoryDao {
    List<Inventory> selectAllInventory();
    Optional<Inventory> selectInventoryById(Integer id);
}
