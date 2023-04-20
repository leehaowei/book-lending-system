package com.leehaowei.booklendingsystem.appuser;

import com.leehaowei.booklendingsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// UserService is the business layer performing business logic
@Service
public class AppUserService {

    private final AppUserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AppUserDTOMapper userDTOMapper;

    public AppUserService(@Qualifier("jdbc") AppUserDao userDao,
                          PasswordEncoder passwordEncoder,
                          AppUserDTOMapper userDTOMapper) {

        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.userDTOMapper = userDTOMapper;
    }

    public List<AppUserDTO> getAllUsers() {
        return userDao.selectAllUser()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public AppUserDTO getCustomer(Integer id) {
        return userDao.selectUserById(id)
                .map(userDTOMapper)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with id [%s] not found".formatted(id)
                ));
    }
    // Additional CRUD methods as needed
    public void addUser(
            AppUserRegistrationRequest userRegistrationRequest) {


        AppUser user = new AppUser(
                userRegistrationRequest.phone_number(),
                passwordEncoder.encode(userRegistrationRequest.password()), // hash the password
                userRegistrationRequest.user_name()
        );
        userDao.insertUser(user);
    }
}
