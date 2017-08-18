package LAB.EntityManager;

import java.sql.SQLException;

public interface DBContext {
    <E> boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException;

    <E> Iterable<E> find(Class<E> table);

    <E> Iterable<E> findFirst(Class<E> table,String where);

    void closeConnection();
}
