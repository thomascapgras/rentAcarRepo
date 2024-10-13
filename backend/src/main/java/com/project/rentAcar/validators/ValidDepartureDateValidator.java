package com.project.rentAcar.validators;

import com.project.rentAcar.dto.ReservationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

/**
 * Validator class to ensure that a departure date is today or later.
 */
public class ValidDepartureDateValidator implements ConstraintValidator<ValidDepartureDate, LocalDate> {
    private ReservationDto reservationDto;

    /**
     * Initializes the validator in preparation for {@link #isValid(LocalDate, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidDepartureDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
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
    public boolean isValid(LocalDate value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return !value.isBefore(LocalDate.now());
    }
}
