package soft_uni.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.store.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long>{
}
