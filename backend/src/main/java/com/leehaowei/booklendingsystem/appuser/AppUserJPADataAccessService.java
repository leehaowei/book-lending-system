package com.leehaowei.booklendingsystem.appuser;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa-user")
public class AppUserJPADataAccessService
        implements AppUserDao {

    private final AppUserRepository userRepository;

    public AppUserJPADataAccessService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<AppUser> selectAllUser() {

        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> selectCustomerById(Integer id) {

        return userRepository.findById(id);
    }

    @Override
    public void insertUser(AppUser user) {
        userRepository.save(user);
    }
}
