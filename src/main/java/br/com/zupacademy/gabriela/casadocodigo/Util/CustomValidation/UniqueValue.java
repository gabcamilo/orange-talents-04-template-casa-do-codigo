package br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
    String message() default "O valor deve ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();

}
