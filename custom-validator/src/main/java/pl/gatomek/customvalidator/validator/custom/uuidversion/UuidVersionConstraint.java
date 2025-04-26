package pl.gatomek.customvalidator.validator.custom.uuidversion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UuidVersionValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UuidVersionConstraint {
    String message() default "UUID version is unsupported";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}