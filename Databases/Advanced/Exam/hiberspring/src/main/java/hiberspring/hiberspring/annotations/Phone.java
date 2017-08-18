//package softuni.softuni.annotations;
//
//
//
//import softuni.softuni.validators.PhoneValidator;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = {PhoneValidator.class})
//@Documented
//public @interface Phone {
//
//    String message() default "Incorrect phone";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//}