package soft_uni.store.utils;

import soft_uni.store.models.bindingModels.user.RegisterUser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataParser {
    public static <T> String getInvalidParamMessage(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return constraint.getMessage();
        }
        return null;
    }


    public static <T> boolean checkIsValid(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);

        for (ConstraintViolation<T> constraint : constraints) {
            return false;
        }
        return true;
    }
}
