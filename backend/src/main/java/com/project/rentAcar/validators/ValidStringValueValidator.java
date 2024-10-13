package com.project.rentAcar.validators;

import com.project.rentAcar.services.ValidationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Validator class to ensure that a string value is one of the valid values
 * retrieved from the database for a specified entity field.
 */
public class ValidStringValueValidator implements ConstraintValidator<ValidStringValue, String> {

    @Autowired
    private ValidationService validationService;

    private Class<?> entityClass;
    private String field;

    /**
     * Initializes the validator in preparation for {@link #isValid(String, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidStringValue constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
        this.field = constraintAnnotation.field();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     *
     * @param value the string value to validate
     * @param context context in which the constraint is evaluated
     * @return {@code true} if {@code value} is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        List<String> validValues = validationService.getDistinctFieldValue(entityClass, field);
        return validValues.contains(value);
    }
}
