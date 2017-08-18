package soft_uni.store.commands;

import soft_uni.store.models.viewModels.game.GameView;
import soft_uni.store.services.api.GameService;
import soft_uni.store.services.api.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AllGamesCommand extends Command {
    public AllGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        List<GameView> gameViews = super.getGameService().getAll();

        return gameViews.stream()
                .map(a -> a.toString())
                .collect(Collectors.joining("\n"));
    }
}
