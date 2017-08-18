import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String townName = br.readLine();

        Query selectAddresses = em.createQuery("SELECT a FROM Address AS a WHERE a.town.name = :name");
        List<Address> addressesToRemove = selectAddresses.setParameter("name",townName).getResultList();

        em.getTransaction().begin();

        for (Address address : addressesToRemove) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            em.flush();
            em.remove(address);
        }


        Query selectTown = em.createQuery("SELECT t FROM Town AS t WHERE t.name = :name");
        selectTown.setParameter("name", townName);

        Town town = (Town) selectTown.setParameter("name",townName).getSingleResult();
        em.remove(town);

        int deletedCount = addressesToRemove.size();

        System.out.printf("%d address%s in %s %s deleted\n",
                deletedCount,
                deletedCount==1 ? "" : "es",
                town.getName(),
                deletedCount == 1 ? "was" : "were");

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
