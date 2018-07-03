package services;

import entities.institutions.Administration;
import entities.institutions.Department;
import entities.positions.Chief;
import entities.positions.Employee;
import entities.positions.SuperiorEmployee;

import javax.persistence.EntityManager;
import java.util.Set;

public class ChiefService {
    protected EntityManager em;

    public ChiefService(EntityManager em) {
        this.em = em;
    }

    public void setManagerForDepartment(SuperiorEmployee superiorEmployee, Department department) {
        em.getTransaction().begin();
        department.setHeadOfDepartment(superiorEmployee);

        em.persist(department);
        em.persist(superiorEmployee);
        em.getTransaction().commit();
    }

    public void addChiefToAdministration(Chief chief, Administration administration){
        em.getTransaction().begin();
        administration.setChief(chief);
        chief.setManagedAdministration(administration);
        em.persist(administration);
        em.getTransaction().commit();
    }

    public void addAdministration(Administration administration){
        em.getTransaction().begin();
        em.persist(administration);
        em.getTransaction().commit();
    }

    public void removeAdministration(Administration administration){
        em.getTransaction().begin();
        em.remove(administration);
        em.getTransaction().commit();
    }

}
