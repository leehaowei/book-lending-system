package com.leehaowei.booklendingsystem.appuser;

import java.util.List;
import java.util.Optional;

// AppUserDao is an abstract Data Access Layer of Customer db
public interface AppUserDao {
    List<AppUser> selectAllUser();
    Optional<AppUser> selectCustomerById(Integer id);

}
