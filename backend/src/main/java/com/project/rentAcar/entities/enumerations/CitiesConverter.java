package com.project.rentAcar.entities.enumerations;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converter class to convert Cities enum to String and vice versa for database persistence.
 */
@Converter(autoApply = true)
public class CitiesConverter implements AttributeConverter<Cities, String> {

    /**
     * Converts a Cities enum to a String for database storage.
     *
     * @param attribute the Cities enum to be converted
     * @return the String representation of the city
     */
    @Override
    public String convertToDatabaseColumn(Cities attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCity();
    }

    /**
     * Converts a String from the database to a Cities enum.
     *
     * @param dbData the String representation of the city from the database
     * @return the corresponding Cities enum
     * @throws IllegalArgumentException if the String does not match any Cities enum value
     */
    @Override
    public Cities convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        for (Cities city : Cities.values()) {
            if (city.getCity().equals(dbData)) {
                return city;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + dbData);
    }
}
