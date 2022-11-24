package be.fromont.spring.cookbook.application.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormatConstraint {
    String message() default "Invalid date format must be 'yyyy-MM-dd'T'HH:mm:ss.SSSXXX'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
