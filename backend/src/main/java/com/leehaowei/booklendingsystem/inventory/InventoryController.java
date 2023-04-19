package com.leehaowei.booklendingsystem.inventory;

import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.appuser.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {

        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAllInventories() {

        return inventoryService.getAllInventories();
    }
    // Additional CRUD endpoints
}
