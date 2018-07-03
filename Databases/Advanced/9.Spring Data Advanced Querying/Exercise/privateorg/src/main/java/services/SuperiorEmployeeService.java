package services;

import entities.institutions.Department;
import entities.positions.Employee;
import entities.positions.SuperiorEmployee;

import javax.persistence.EntityManager;
import java.util.Set;

public class SuperiorEmployeeService {
    protected EntityManager em;

    public SuperiorEmployeeService(EntityManager em) {
        this.em = em;
    }
    public void addEmployee(SuperiorEmployee superiorEmployee, Employee employee) {
        em.getTransaction().begin();
        Department department = superiorEmployee.getManagedDepartment();
        Set<Employee> departmentEmployees = department.getEmployees();
        departmentEmployees.add(employee);
        department.setEmployees(departmentEmployees);
        em.persist(employee);
        em.persist(department);
        em.getTransaction().commit();
    }

    public void removeEmployee(SuperiorEmployee superiorEmployee, Employee employee) {
        em.getTransaction().begin();
        Department managedDepartment = superiorEmployee.getManagedDepartment();
        Set<Employee> employees = managedDepartment.getEmployees();
        employees.remove(employee);
        managedDepartment.setEmployees(employees);
        em.remove(employee);
        em.persist(managedDepartment);
        em.getTransaction().commit();
    }

    public Set<Employee> selectAllEmployeesFromManagedDepartment(SuperiorEmployee superiorEmployee) {
        em.getTransaction().begin();
        Department department = superiorEmployee.getManagedDepartment();
        Set<Employee> departmentEmployees = department.getEmployees();
        return departmentEmployees;
    }

}
