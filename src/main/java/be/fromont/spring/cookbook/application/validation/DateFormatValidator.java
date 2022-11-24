package be.fromont.spring.cookbook.application.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateFormatValidator implements ConstraintValidator<DateFormatConstraint, String> {

    @Override
    public void initialize(DateFormatConstraint dateFormat) {
    }

    @Override
    public boolean isValid(String dateField, ConstraintValidatorContext cxt) {
        try {
            ZonedDateTime.parse(dateField,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withResolverStyle(ResolverStyle.STRICT));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
