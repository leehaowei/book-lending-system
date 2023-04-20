package com.leehaowei.booklendingsystem.appuser;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class AppUserRowMapper implements RowMapper<AppUser> {
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AppUser(
                rs.getInt("user_id"),
                rs.getString("phone_number"),
                rs.getString("password"),
                rs.getString("user_name"),
                rs.getTimestamp("registration_time").toLocalDateTime(),
                rs.getTimestamp("last_login_time").toLocalDateTime()
        );
    }
}
