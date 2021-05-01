package br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Constraint(validatedBy = {ExistsValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD})
public @interface Exists {
    String message() default "The informed id does not exit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName() default "id";

    Class<?> domainClass();

}
