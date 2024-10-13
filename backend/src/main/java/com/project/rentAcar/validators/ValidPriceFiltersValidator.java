package com.project.rentAcar.validators;

import com.project.rentAcar.dto.FiltersDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator class to ensure that the maxPrice in FiltersDto is greater than or equal to the minPrice.
 */
public class ValidPriceFiltersValidator implements ConstraintValidator<ValidPriceFilters, FiltersDto> {

    /**
     * Initializes the validator in preparation for {@link #isValid(FiltersDto, ConstraintValidatorContext)} calls.
     * This method is guaranteed to be called before any use of this instance for validation.
     *
     * @param constraintAnnotation the annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ValidPriceFilters constraintAnnotation) {
        // No initialization needed for this validator
    }

    /**
     * Implements the validation logic.
     * The state of {@code filtersDto} must not be altered.
     *
     * @param filtersDto the FiltersDto to validate
     * @param context context in which the constraint is evaluated
     * @return {@code true} if {@code filtersDto} is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(FiltersDto filtersDto, ConstraintValidatorContext context) {
        if (filtersDto == null) {
            return false;
        }
        return filtersDto.getMaxPrice() >= filtersDto.getMinPrice();
    }
}
