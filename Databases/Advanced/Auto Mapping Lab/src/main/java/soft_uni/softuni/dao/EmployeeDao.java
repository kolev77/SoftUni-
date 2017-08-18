package soft_uni.softuni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.softuni.model.Employee;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Long>{

    List<Employee> findByBirthDateBeforeOrderBySalaryDesc(Date birthDate);
}
