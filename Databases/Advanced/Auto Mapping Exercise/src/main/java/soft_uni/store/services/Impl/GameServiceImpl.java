package soft_uni.store.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.store.entities.Game;
import soft_uni.store.models.bindingModels.game.AddGame;
import soft_uni.store.models.viewModels.game.GameView;
import soft_uni.store.repositories.GameRepository;
import soft_uni.store.services.api.GameService;
import soft_uni.store.utils.ModelParser;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void save(AddGame addGame) {
        Game game = ModelParser.getInstance().map(addGame,Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public List<GameView> getAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game,GameView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }
}
