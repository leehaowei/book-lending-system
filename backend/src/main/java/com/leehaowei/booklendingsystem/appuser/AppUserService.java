package com.leehaowei.booklendingsystem.appuser;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

// AppUserService is the business layer performing business logic
@Service
public class AppUserService {

    private final AppUserDao userDao;

    public AppUserService(@Qualifier("jpa-user") AppUserDao userDao) {

        this.userDao = userDao;
    }

    public List<AppUser> getAllUsers() {
        return userDao.selectAllUser();
    }

    public AppUser getCustomer(Integer id) {
        return userDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with id [%s] not found".formatted(id)
                ));
    }
    // Additional CRUD methods as needed
}
