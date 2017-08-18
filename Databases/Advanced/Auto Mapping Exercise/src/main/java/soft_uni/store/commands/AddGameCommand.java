package soft_uni.store.commands;

import soft_uni.store.entities.Role;
import soft_uni.store.models.bindingModels.game.AddGame;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;
import soft_uni.store.utils.DataParser;
import soft_uni.store.utils.Session;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddGameCommand extends Command {
    public AddGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }


    @Override
    public String execute(String... params) {
        if (Session.getLoggedInUser() == null){
            return "No user logged in";
        }
        if (Session.getLoggedInUser().getRole() !=Role.ADMIN){
            return "Only admins can add game";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            AddGame addGame = new AddGame(params[0],
                    new BigDecimal(params[1]),
                    Double.parseDouble(params[2]),
                    params[3],
                    params[4],
                    params[5],
                    sdf.parse(params[6]));
            if (!DataParser.checkIsValid(addGame)) {
                return DataParser.getInvalidParamMessage(addGame);
            }
            super.getGameService().save(addGame);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.format("Added %s",params[0]);
    }
}
