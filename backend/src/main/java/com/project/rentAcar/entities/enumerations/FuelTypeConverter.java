package com.project.rentAcar.entities.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converter class to convert FuelType enum to String and vice versa for database persistence.
 */
@Converter(autoApply = true)
public class FuelTypeConverter implements AttributeConverter<FuelType, String> {

    /**
     * Converts a FuelType enum to a String for database storage.
     *
     * @param attribute the FuelType enum to be converted
     * @return the String representation of the fuel type
     */
    @Override
    public String convertToDatabaseColumn(FuelType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getFuelType();
    }

    /**
     * Converts a String from the database to a FuelType enum.
     *
     * @param dbData the String representation of the fuel type from the database
     * @return the corresponding FuelType enum
     * @throws IllegalArgumentException if the String does not match any FuelType enum value
     */
    @Override
    public FuelType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (FuelType fuel : FuelType.values()) {
            if (fuel.getFuelType().equals(dbData)) {
                return fuel;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + dbData);
    }
}
