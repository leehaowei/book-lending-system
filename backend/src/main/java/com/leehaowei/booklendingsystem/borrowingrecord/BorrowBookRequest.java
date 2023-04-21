package com.leehaowei.booklendingsystem.borrowingrecord;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BorrowBookRequest(
        @JsonProperty("user_id") int userId,
        @JsonProperty("inventory_id") int inventoryId
) {
}

