package com.leehaowei.booklendingsystem.appuser;

import java.util.List;

public record AppUserDTO(
        Integer userId,
        String userName,
        String phoneNumber,
        List<String> roles,
        String username
) {
}
