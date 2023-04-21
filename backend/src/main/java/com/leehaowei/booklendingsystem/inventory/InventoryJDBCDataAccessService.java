package com.leehaowei.booklendingsystem.inventory;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc-inventory")
public class InventoryJDBCDataAccessService implements InventoryDao {

    private final JdbcTemplate jdbcTemplate;
    private final InventoryRowMapper inventoryRowMapper;

    public InventoryJDBCDataAccessService(JdbcTemplate jdbcTemplate,
                                          InventoryRowMapper inventoryRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.inventoryRowMapper = inventoryRowMapper;
    }

    @Override
    public List<Inventory> selectAllInventory() {
        var sql = """
                SELECT inventory_id, isbn, store_time, status
                FROM inventory
                """;

        return jdbcTemplate.query(sql, inventoryRowMapper);
    }

    @Override
    public Optional<Inventory> selectInventoryById(Integer id) {
        var sql = """
                SELECT inventory_id, isbn, store_time, status
                FROM inventory
                WHERE inventory_id = ?
                """;
        try {
            Inventory inventory = jdbcTemplate.queryForObject(sql, inventoryRowMapper, id);
            return Optional.ofNullable(inventory);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}

