package Hiberspring.app.repositories;

import Hiberspring.app.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town,Long> {

}
