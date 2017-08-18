package soft_uni.store;

import soft_uni.store.commands.*;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;

public class CommandFactory {
    private UserService userService;
    private GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable getCommand(String command) {
        switch (command) {
            case "Register":
                return new RegisterCommand(this.userService, this.gameService);
            case "Login":
                return new LoginCommand(this.userService, this.gameService);
            case "Logout":
                return new LogoutCommand(this.userService, this.gameService);
            case "AddGame":
                return new AddGameCommand(this.userService, this.gameService);
            case "AllGames":
                return new AllGamesCommand(this.userService, this.gameService);
        }
        return null;
    }
}
