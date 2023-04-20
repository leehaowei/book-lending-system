package com.leehaowei.booklendingsystem.appuser;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class AppUserJDBCDataAccessService implements AppUserDao {

    private final JdbcTemplate jdbcTemplate;

    public AppUserJDBCDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AppUser> selectAllUser() {

        return null;
    }

    @Override
    public Optional<AppUser> selectCustomerById(Integer id) {

        return Optional.empty();
    }

    @Override
    public void insertUser(AppUser user) {
        var sql = """
                INSERT INTO app_user(phone_number, password, user_name)
                VALUES (?, ?, ?)
                """;
        System.out.println("User object: " + user);

        int result = jdbcTemplate.update(
                sql,
                user.getPhoneNumber(),
                user.getPassword(),
                user.getUsername(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        System.out.println("jdbcTemplate.update = " + result);
    }
}
