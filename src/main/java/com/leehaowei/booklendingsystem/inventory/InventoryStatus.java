package com.leehaowei.booklendingsystem.inventory;

public enum InventoryStatus {
    IN_STOCK("in_stock"),
    ON_LOAN("on_loan"),
    PROCESSING("processing"),
    LOST("lost"),
    DAMAGED("damaged"),
    DISCARDED("discarded");

    private String value;

    InventoryStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InventoryStatus fromValue(String value) {
        for (InventoryStatus status : InventoryStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}


