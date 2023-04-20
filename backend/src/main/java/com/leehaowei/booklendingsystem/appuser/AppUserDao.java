package com.leehaowei.booklendingsystem.appuser;

import java.util.List;
import java.util.Optional;

// UserDao is an abstract Data Access Layer of Customer db
public interface AppUserDao {
    List<AppUser> selectAllUser();
    Optional<AppUser> selectCustomerById(Integer id);

    void insertUser(AppUser user);

}
