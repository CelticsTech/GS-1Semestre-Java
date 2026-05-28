package com.globalsolution.java.celticstech.validation.telefonebr;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefoneBRValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface TelefoneBR {

    String message() default "Telefone inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}