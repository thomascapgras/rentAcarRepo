package com.project.rentAcar.dao;

import java.util.List;

/**
 * Interface for validation data access object.
 * Provides method to find the maximum ID of a given entity.
 */
public interface ValidationDao {

    /**
     * Finds the maximum ID of a given entity class.
     *
     * @param entity the entity class
     * @return the maximum ID
     */
    public int findIndMax(Class<?> entity);

    /**
     * Retrieves distinct values of a specified field from a given entity class.
     *
     * @param entity the entity class
     * @param field the field for which to retrieve distinct values
     * @return a list of distinct values of the specified field
     */
    <T> List<T> getDistinctFieldValue(Class<?> entity, String field);


}
