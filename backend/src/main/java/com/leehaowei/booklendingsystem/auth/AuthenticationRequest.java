package com.leehaowei.booklendingsystem.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
