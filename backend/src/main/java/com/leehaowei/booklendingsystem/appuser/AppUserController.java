package com.leehaowei.booklendingsystem.appuser;

import com.leehaowei.booklendingsystem.jwt.JWTUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class AppUserController {

    private final AppUserService UserService;
    private final JWTUtil jwtUtil;

    public AppUserController(AppUserService userService,
                             JWTUtil jwtUtil) {

        this.UserService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<AppUserDTO> getAllAppUsers() {

        return UserService.getAllUsers();
    }
    // Additional CRUD endpoints
    @PostMapping
    public ResponseEntity<?> registerUser(
            @RequestBody AppUserRegistrationRequest request) {
        UserService.addUser(request);
        String jwtToken = jwtUtil.issueToken(request.phone_number(), "ROLE_USER");
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtToken)
                .build();
    }
}

