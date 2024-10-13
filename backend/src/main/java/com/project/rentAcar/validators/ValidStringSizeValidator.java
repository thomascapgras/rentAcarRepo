package com.project.rentAcar.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator class to ensure that the size of a string is within specified limits.
 */
public class ValidStringSizeValidator implements ConstraintValidator<ValidStringSize, String> {

    private int maxSize;
    private int minSize;

    /**
     * Initializes the validator in preparation for {@link #isValid(String, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidStringSize constraintAnnotation) {
        this.maxSize = constraintAnnotation.maxSize();
        this.minSize = constraintAnnotation.minSize();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     *
     * @param value the string value to validate
     * @param constraintValidatorContext context in which the constraint is evaluated
     * @return {@code true} if {@code value} is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return value.length() >= minSize && value.length() <= maxSize;
    }
}
