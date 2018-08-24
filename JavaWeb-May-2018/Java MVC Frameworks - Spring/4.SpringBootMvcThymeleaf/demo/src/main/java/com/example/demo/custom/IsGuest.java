package com.example.demo.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = GuestValidator.class)
public @interface IsGuest {
    String message() default "Invalid guest ! ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean canBeEmpty() default true;
}
