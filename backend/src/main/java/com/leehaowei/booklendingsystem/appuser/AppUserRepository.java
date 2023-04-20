package com.leehaowei.booklendingsystem.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

// interface for business logic
public interface AppUserRepository
        extends JpaRepository<AppUser, Integer> {
}
