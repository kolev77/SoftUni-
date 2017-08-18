package soft_uni.store.commands;

import soft_uni.store.models.bindingModels.user.LoggedInUser;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;
import soft_uni.store.utils.Session;

public class LogoutCommand extends Command {
    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if (Session.getLoggedInUser()== null){
            return "Cannot log out.No user was logged in";
        }
        LoggedInUser loggedInUser = Session.getLoggedInUser();
        Session.setLoggedInUser(null);

        return String.format("User %s successfully logged out",loggedInUser.getFullName());
    }
}
