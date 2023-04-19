package com.leehaowei.booklendingsystem.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app_users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {

        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAllAppUsers() {

        return appUserService.getAllUsers();
    }
    // Additional CRUD endpoints
    @PostMapping
    public void registerUser(
            @RequestBody UserRegistrationRequest request) {
        appUserService.addUser(request);
    }
}

