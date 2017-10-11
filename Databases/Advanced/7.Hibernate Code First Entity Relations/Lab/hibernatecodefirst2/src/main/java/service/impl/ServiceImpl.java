package service.impl;

import app.Transactions.Command;
import app.Transactions.MultiResultCommand;
import app.Transactions.Transactional;
import app.Transactions.VoidCommand;
import dao.api.Dao;
import dao.impl.JpaDao;
import service.api.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ServiceImpl<E, K> implements Service<E, K>, Transactional<E> {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShampooCompany");
    protected EntityManager em;
    protected Dao<E, K> dao;

    @Override
    public E findById(Class<E> serviceClass, K id) {
        return runInTransaction(new Command<E>() {
            @Override
            public E execute() {
                return dao.findById(serviceClass, id);
            }
        });
    }

    @Override
    public void remove(E object) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.remove(object);
            }
        });
    }

    @Override
    public List<E> findAll(Class<E> serviceClass) {
        return runInTransaction(new MultiResultCommand<E>() {
            @Override
            public List<E> execute() {
                return dao.findAll(serviceClass);
            }
        });
    }

    @Override
    public void save(E object) {
        runInTransaction(new VoidCommand<E>() {
            @Override
            public void execute() {
                dao.save(object);
            }
        });

    }

    @Override
    public void runInTransaction(VoidCommand<E> command) {
        em = emf.createEntityManager();
        try {
            dao = createDao();
            em.getTransaction().begin();
            command.execute();
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            //log here
            throw t;
        } finally {
            em.close();
        }
    }

    protected Dao<E,K> createDao() {
        return new JpaDao<>(em);
    }

    @Override
    public E runInTransaction(Command<E> command) {
        em = emf.createEntityManager();
        try {
            dao =createDao();
            em.getTransaction().begin();
            E result = command.execute();
            em.getTransaction().commit();
            return result;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            //log here
            throw t;
        } finally {
            em.close();
        }
    }

    @Override
    public List<E> runInTransaction(MultiResultCommand<E> command) {
        em = emf.createEntityManager();
        try {
            dao =createDao();
            em.getTransaction().begin();
            List<E> result = command.execute();
            em.getTransaction().commit();
            return result;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            //log here
            throw t;
        }finally {
            em.close();
        }
    }
}
