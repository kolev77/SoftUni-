package com.example.demo.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GuestValidator implements ConstraintValidator<IsGuest,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.contains("guest");
    }
}
