package com.leehaowei.booklendingsystem.appuser;

public record UserRegistrationRequest(
        String phone_number,
        String password,
        String user_name
) {
}
