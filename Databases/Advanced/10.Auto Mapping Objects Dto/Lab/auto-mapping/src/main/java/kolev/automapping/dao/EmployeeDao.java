package kolev.automapping.dao;

import kolev.automapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long> {

    List<Employee> findAllByBirthdateBeforeOrderBySalaryDesc(Date birthdate);


}
