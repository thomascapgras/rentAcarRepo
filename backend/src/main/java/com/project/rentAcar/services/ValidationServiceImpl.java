package com.project.rentAcar.services;

import com.project.rentAcar.dao.ValidationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService{

    @Autowired
    private ValidationDao validationDao;

    /**
     * Finds the maximum ID of a given entity class.
     *
     * @param entity the entity class
     * @return the maximum ID
     */
    @Override
    public int findIndMax(Class<?> entity) {
        return this.validationDao.findIndMax(entity);
    }

    /**
     * Retrieves distinct values of a specified field from a given entity class.
     *
     * @param entity the entity class
     * @param field the field for which to retrieve distinct values
     * @param <T> the type of the field
     * @return a list of distinct values of the specified field
     */
    @Override
    public <T> List<T> getDistinctFieldValue(Class<?> entity, String field) {
        return this.validationDao.getDistinctFieldValue(entity,field);
    }
}
