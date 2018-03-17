package org.softuni.main.database.repositories;



import org.softuni.main.database.models.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserRepository extends BaseRepository {


    public UserRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    private boolean create(String username, String password) {
        this.entityManager.persist(new User(username, password));
        return true;
    }

    private User findById(String userId){
        User user = (User) this.entityManager
                .createNativeQuery("SELECT * FROM users as u WHERE u.id = \'"+ userId + " \'" , User.class).getSingleResult();
        return  user;
    }

    private User findByUsername(String username) {
        User user = (User) this.entityManager
                .createNativeQuery("SELECT * FROM users as u WHERE u.username = \'"+ username + " \'" , User.class).getSingleResult();
        return  user;
    }

    private User[] findAll() {
        List<User> resultList = this.entityManager
                .createNativeQuery("SELECT * FROM users", User.class).getResultList();

        return resultList.toArray(new User[resultList.size()]);
    }

    private void addFriend(String username, String friendName){
        User user = this.findByUsername(username);
        User friend = this.findByUsername(friendName);
        user.addFriend(friend);
        friend.addFriend(user);
    }

}
