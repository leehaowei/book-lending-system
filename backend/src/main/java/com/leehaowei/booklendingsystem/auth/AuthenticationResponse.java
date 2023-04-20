package com.leehaowei.booklendingsystem.auth;

import com.leehaowei.booklendingsystem.appuser.AppUserDTO;

public record AuthenticationResponse (
        String token,
        AppUserDTO userDTO){
}
