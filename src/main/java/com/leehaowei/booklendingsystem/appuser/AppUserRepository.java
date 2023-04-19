package com.leehaowei.booklendingsystem.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface for business logic
public interface AppUserRepository
        extends JpaRepository<AppUser, Integer> {
}
