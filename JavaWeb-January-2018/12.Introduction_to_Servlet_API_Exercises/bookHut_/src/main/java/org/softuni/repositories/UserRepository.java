package org.softuni.repositories;

import org.softuni.entities.User;

public interface UserRepository {
    void createUser(User user);

    User findByUsernameAndPassword(String username, String password);
}
