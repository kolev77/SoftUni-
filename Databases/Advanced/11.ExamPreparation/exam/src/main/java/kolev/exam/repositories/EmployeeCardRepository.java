package kolev.exam.repositories;

import kolev.exam.entities.Branch;
import kolev.exam.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long> {
    EmployeeCard findByNumber(String number);
}
