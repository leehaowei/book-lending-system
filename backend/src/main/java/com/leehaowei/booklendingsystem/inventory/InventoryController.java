package com.leehaowei.booklendingsystem.inventory;

import com.leehaowei.booklendingsystem.appuser.AppUserRegistrationRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
