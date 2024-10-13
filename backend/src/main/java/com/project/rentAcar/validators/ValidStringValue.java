package com.project.rentAcar.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to validate a string value
 */
@Constraint(validatedBy = ValidStringValueValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStringValue {

    /**
     * The default message that will be shown when the constraint is violated.
     *
     * @return the default error message
     */
    String message() default "Invalid ID";

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

    /**
     * Specifies the entity class to which the ID belongs.
     *
     * @return the entity class
     */
    Class<?> entityClass();

    /**
     * Specifies the field to validate.
     */

    String field();
}
