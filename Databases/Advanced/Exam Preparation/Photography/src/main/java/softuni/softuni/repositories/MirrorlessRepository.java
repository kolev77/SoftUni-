package softuni.softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.softuni.entities.Mirrorless;

@Repository
public interface MirrorlessRepository extends JpaRepository<Mirrorless, Long> {
}