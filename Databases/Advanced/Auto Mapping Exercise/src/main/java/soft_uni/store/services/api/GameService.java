package soft_uni.store.services.api;

import soft_uni.store.models.bindingModels.game.AddGame;
import soft_uni.store.models.viewModels.game.GameView;

import java.util.List;

public interface GameService {
    void save(AddGame addGame);
    List<GameView> getAll();
}
