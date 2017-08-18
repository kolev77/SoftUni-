package soft_uni.store.validations;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;

@Component
@Constraint(validatedBy = PasswordMatchingValidator.class)
public @interface PasswordMatching {

    String message() default "Password mismatch.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payLoad() default {};
}
