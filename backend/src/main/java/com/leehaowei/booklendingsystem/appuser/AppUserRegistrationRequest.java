package com.leehaowei.booklendingsystem.appuser;

public record AppUserRegistrationRequest(
        String phone_number,
        String password,
        String user_name
) {
}
