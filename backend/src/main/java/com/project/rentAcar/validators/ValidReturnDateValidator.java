package com.project.rentAcar.validators;

import com.project.rentAcar.dto.ReservationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator class to ensure that the return date in ReservationDto is not before the departure date.
 */
public class ValidReturnDateValidator implements ConstraintValidator<ValidReturnDate, ReservationDto> {

    /**
     * Initializes the validator in preparation for {@link #isValid(ReservationDto, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidReturnDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Implements the validation logic.
     * The state of {@code reservationDto} must not be altered.
     *
     * @param reservationDto the ReservationDto to validate
     * @param constraintValidatorContext context in which the constraint is evaluated
     * @return {@code true} if {@code reservationDto} is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(ReservationDto reservationDto, ConstraintValidatorContext constraintValidatorContext) {
        if (reservationDto.getReturnDate() == null || reservationDto.getDepartureDate() == null) {
            return false;
        }
        return !reservationDto.getReturnDate().isBefore(reservationDto.getDepartureDate());
    }
}
