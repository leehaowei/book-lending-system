package com.leehaowei.booklendingsystem.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface for business logic
public interface AppUserRepository
        extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findUserByPhoneNumber(String phoneNumber);
}
