package pl.gatomek.customvalidator.validator.custom.uuidversion;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UuidVersionValidator implements ConstraintValidator<UuidVersionConstraint, Integer> {
    @Override
    public boolean isValid(Integer version, ConstraintValidatorContext context) {
        if (version == null)
            return raiseConstraintViolation(context, "UUID version is null");

        if (!version.equals(4))
            return raiseConstraintViolation(context, "UUID version " + version + " is unsupported");

        return true;
    }

    private boolean raiseConstraintViolation(ConstraintValidatorContext context, String text) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(text).addConstraintViolation();
        return false;
    }
}
