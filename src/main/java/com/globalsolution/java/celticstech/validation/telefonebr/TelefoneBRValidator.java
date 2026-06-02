package com.globalsolution.java.celticstech.validation.telefonebr;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneBRValidator
        implements ConstraintValidator<TelefoneBR, String> {

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext context
    ) {

        if (value == null) {
            return false;
        }

        return value.matches("^\\d{11,13}$");

    }

}