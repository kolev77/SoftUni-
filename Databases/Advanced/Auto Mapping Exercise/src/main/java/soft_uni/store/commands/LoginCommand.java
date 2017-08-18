package soft_uni.store.commands;

import soft_uni.store.models.bindingModels.user.LoggedInUser;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;
import soft_uni.store.utils.Session;

public class LoginCommand extends Command {
    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        String username = params[0];
        String password = params[1];
        if (Session.getLoggedInUser() !=null) {
        return "User already logged in";
        }

        LoggedInUser loggedInUser = super.getUserService().findByEmailAndAndPassword(username,password);
        if (loggedInUser == null){
            return "Incorrect username/password";
        }
        Session.setLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s",username);

    }
}
