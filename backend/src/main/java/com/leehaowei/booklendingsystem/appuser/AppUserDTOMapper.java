package com.leehaowei.booklendingsystem.appuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AppUserDTOMapper implements Function<AppUser, AppUserDTO> {

    @Override
    public AppUserDTO apply(AppUser user) {
        return new AppUserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getPhoneNumber(),
                user.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()),
                user.getUsername()
        );
    }
}
