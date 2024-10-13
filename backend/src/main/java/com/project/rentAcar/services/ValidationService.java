package com.project.rentAcar.services;

import java.util.List;

/**
 * Service interface for validation operations.
 */
public interface ValidationService {

    /**
     * Finds the maximum ID of a given entity class.
     *
     * @param entity the entity class
     * @return the maximum ID
     */
    int findIndMax(Class<?> entity);

    /**
     * Retrieves distinct values of a specified field from a given entity class.
     *
     * @param entity the entity class
     * @param field the field for which to retrieve distinct values
     * @param <T> the type of the field
     * @return a list of distinct values of the specified field
     */
    <T> List<T> getDistinctFieldValue(Class<?> entity, String field);
}
