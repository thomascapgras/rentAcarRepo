package com.project.rentAcar.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of the ValidationDao interface.
 * Provides implementation for finding the maximum ID of a given entity class.
 */
@Repository
public class ValidationDaoImpl implements ValidationDao {

    @Autowired
    private EntityManager em;

    /**
     * Finds the maximum ID of a given entity class.
     *
     * @param entity the entity class
     * @return the maximum ID
     */
    @Override
    public int findIndMax(Class<?> entity) {
        String jpql = "SELECT MAX(a.id) FROM " + entity.getSimpleName() + " a";
        Query query = em.createQuery(jpql);
        Integer maxId = (Integer) query.getSingleResult();
        return maxId;
    }

    /**
     * Retrieves distinct values of a specified field from a given entity class.
     *
     * @param entity the entity class
     * @param field the field for which to retrieve distinct values
     * @return a list of distinct values of the specified field
     */
    @Override
    public <T> List<T> getDistinctFieldValue(Class<?> entity, String field) {
        String jpql = "SELECT DISTINCT a." + field + " FROM " + entity.getSimpleName() + " a";
        Query query = em.createQuery(jpql);
        List<T> distinctValues = query.getResultList();
        return distinctValues;
    }
}
