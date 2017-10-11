package kolev.exam.utils;

import javax.validation.Validation;
import javax.validation.Validator;

public final class DataValidator {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private DataValidator() {
    }

    public static <T> boolean isValid(T t) {
        return t != null && validator.validate(t).size() == 0;
    }

}