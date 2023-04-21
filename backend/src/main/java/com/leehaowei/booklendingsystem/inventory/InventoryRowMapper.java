package com.leehaowei.booklendingsystem.inventory;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class InventoryRowMapper implements RowMapper<Inventory> {

    @Override
    public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Inventory(
                rs.getInt("inventory_id"),
                rs.getString("isbn"),
                rs.getTimestamp("store_time").toLocalDateTime(),
                InventoryStatus.valueOf(rs.getString("status"))
        );
    }
}


