package softuni.softuni.repositories;

import softuni.softuni.entities.DSLR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DSLRRepository extends JpaRepository<DSLR, Long> {
}