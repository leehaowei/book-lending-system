package com.leehaowei.booklendingsystem.appuser;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void addUser(
            UserRegistrationRequest userRegistrationRequest) {

        // TODO: adjust time according to practical case
        LocalDateTime registration_time = LocalDateTime.now();
        LocalDateTime lastLogin_time = LocalDateTime.now();

        AppUser user = new AppUser(
                userRegistrationRequest.phone_number(),
                userRegistrationRequest.password(),
                userRegistrationRequest.user_name(),
                registration_time,
                lastLogin_time
        );
        userDao.insertUser(user);
    }
}
