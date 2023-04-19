package com.leehaowei.booklendingsystem.inventory;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InventoryStatusConverter
        implements AttributeConverter<InventoryStatus, String> {

    @Override
    public String convertToDatabaseColumn(InventoryStatus attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public InventoryStatus convertToEntityAttribute(String dbData) {
        return dbData != null ? InventoryStatus.fromValue(dbData) : null;
    }
}

