package com.project.rentAcar.validators;

import com.project.rentAcar.services.ValidationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Validator class to ensure that an ID is between 0 and a maximum available.
 */
public class ValidIdValidator implements ConstraintValidator<ValidId, Integer> {

    @Autowired
    private ValidationService validationService;

    private Class<?> entityClass;

    /**
     * Initializes the validator in preparation for {@link #isValid(Integer, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidId constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     *
     * @param value the value to validate
     * @param constraintValidatorContext context in which the constraint is evaluated
     * @return {@code true} if {@code value} is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        int maxId = this.validationService.findIndMax(entityClass);
        return value > 0 && value <= maxId;
    }
}
