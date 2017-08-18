package soft_uni.store.commands;

import soft_uni.store.models.bindingModels.user.RegisterUser;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;
import soft_uni.store.utils.DataParser;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RegisterCommand extends Command {

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(params[0]);
        registerUser.setPassword(params[1]);
        registerUser.setConfirmPassword(params[2]);
        registerUser.setFullName(params[3]);

        if (!DataParser.checkIsValid(registerUser)) {
            return DataParser.getInvalidParamMessage(registerUser);
        }
        try {
            super.getUserService().save(registerUser);
        }catch (Exception e){
            return e.getMessage();
        }

        return String.format("%s was registered !", params[3]);
    }
}
