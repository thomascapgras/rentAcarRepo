package com.project.rentAcar.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to validate that price max filter is higher than price min filter
 */
@Constraint(validatedBy = ValidPriceFiltersValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPriceFilters {
    /**
     * The default message that will be shown when the constraint is violated.
     *
     * @return the default error message
     */

    String message() default "Max price must be higher than min price";

    /**
     * Allows the specification of validation groups, to which this constraint belongs.
     *
     * @return the array of validation groups
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients of the Jakarta Bean Validation API to assign custom payload objects to a constraint.
     *
     * @return the array of payload classes
     */
    Class<? extends Payload>[] payload() default {};
}
